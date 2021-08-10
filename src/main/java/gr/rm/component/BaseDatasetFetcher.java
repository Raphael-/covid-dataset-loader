package gr.rm.component;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;
import java.time.Instant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class BaseDatasetFetcher implements DatasetFetcher {
	private static final Logger LOGGER = LoggerFactory.getLogger(BaseDatasetFetcher.class);

	private static final String DATASET_URL = "https://raw.githubusercontent.com/OxCGRT/covid-policy-tracker/master/data/OxCGRT_latest.csv";

	@Override
	public InputStream fetch() {
		HttpClient client = buildClient();

		HttpRequest request = buildRequest();

		HttpResponse<InputStream> response = null;
		try {
			Instant start = Instant.now();
			response = client.send(request, BodyHandlers.ofInputStream());
			Instant finish = Instant.now();
			long timeElapsed = Duration.between(start, finish).toMillis();
			LOGGER.info("Dataset stream fetched in {} ms with status {}.", timeElapsed, response.statusCode());
			return response.body();
		} catch (IOException | InterruptedException e) {
			LOGGER.error("Error during dataset fetch.", e);
		}
		return null;
	}

	private HttpRequest buildRequest() {
		return HttpRequest.newBuilder().uri(URI.create(DATASET_URL)).timeout(Duration.ofMinutes(5)).build();
	}

	private HttpClient buildClient() {
		return HttpClient.newBuilder().version(Version.HTTP_2).followRedirects(Redirect.NEVER).build();
	}

}
