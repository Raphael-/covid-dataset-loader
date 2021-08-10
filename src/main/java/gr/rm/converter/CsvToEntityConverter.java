package gr.rm.converter;

import java.io.IOException;
import java.io.InputStream;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import gr.rm.model.CountryRestrictionPojo;

@Component
public class CsvToEntityConverter implements Converter<InputStream, Stream<CountryRestrictionPojo>> {

	private static final Logger LOGGER = LoggerFactory.getLogger(CsvToEntityConverter.class);

	@Override
	public Stream<CountryRestrictionPojo> convert(InputStream source) {
		if (source == null) {
			return Stream.empty();
		}
		CsvSchema bootstrap = CsvSchema.emptySchema().withHeader();
		ObjectMapper csvMapper = new CsvMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		try {
			MappingIterator<CountryRestrictionPojo> iterator = csvMapper.readerFor(CountryRestrictionPojo.class)
					.with(bootstrap).<CountryRestrictionPojo>readValues(source);
			return StreamSupport.stream(Spliterators.spliteratorUnknownSize(iterator, Spliterator.ORDERED), false)
					.onClose(() -> {
						try {
							iterator.close();
						} catch (IOException e) {
							throw new RuntimeException(e);
						}
					});

		} catch (IOException e) {
			LOGGER.error("Error during csv to pojo conversion.", e);
			throw new RuntimeException(e);
		}
	}

}
