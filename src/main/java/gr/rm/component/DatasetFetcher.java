package gr.rm.component;

import java.io.InputStream;

public interface DatasetFetcher {
	/**
	 * Fetches the dataset as {@link InputStream}
	 * 
	 * @return {@link InputStream}
	 */
	InputStream fetch();
}
