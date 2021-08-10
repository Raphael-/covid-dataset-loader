package gr.rm.component;

public interface DatasetPersister<T> {
	
	void persist(T dataset);
	
	void clearData();
	
	void recreateIndexes();
}
