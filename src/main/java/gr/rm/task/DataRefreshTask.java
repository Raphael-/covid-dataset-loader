package gr.rm.task;

import java.io.InputStream;
import java.time.Duration;
import java.time.Instant;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.convert.converter.Converter;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import gr.rm.component.DatasetFetcher;
import gr.rm.component.DatasetPersister;
import gr.rm.model.CountryRestrictionNormalized;
import gr.rm.model.CountryRestrictionPojo;

@Component
public class DataRefreshTask implements ApplicationListener<ApplicationReadyEvent> {
	private static final Logger LOGGER = LoggerFactory.getLogger(DataRefreshTask.class);

	@Autowired
	private DatasetFetcher fetcher;

	@Autowired
	private DatasetPersister<CountryRestrictionNormalized> persister;

	@Autowired
	private Converter<InputStream, Stream<CountryRestrictionPojo>> converter;

	@Autowired
	private Converter<CountryRestrictionPojo, CountryRestrictionNormalized> normalizer;

	@Scheduled(cron = "0 0 0 * * *")
	public void execute() {
		LOGGER.info("Data refresh started.");
		Instant start = Instant.now();
		InputStream dataset = fetcher.fetch();
		LOGGER.info("Clearing previous data.");
		persister.clearData();
		LOGGER.info("Inserting new data.");
		converter.convert(dataset).map(normalizer::convert).forEach(persister::persist);
		LOGGER.info("Recreating indexes.");
		persister.recreateIndexes();
		Instant finish = Instant.now();
		long timeElapsed = Duration.between(start, finish).toMillis();
		LOGGER.info("Data refresh completed successfully in {} ms.", timeElapsed);
	}

	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		execute();
	}
}