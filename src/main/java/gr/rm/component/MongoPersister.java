package gr.rm.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.BulkOperations.BulkMode;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.Index;
import org.springframework.stereotype.Component;

@Component
public class MongoPersister<T> implements DatasetPersister<T> {
	private static final String COLLECTION_NAME = "covid-restrictions";
	private static final String DATE_FIELD_NAME = "Date";
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public void persist(T object) {
		bulkInsertData(object);
	}

	private void bulkInsertData(T object) {
		mongoTemplate.bulkOps(BulkMode.UNORDERED, COLLECTION_NAME).insert(object).execute();
	}

	public void clearData() {
		mongoTemplate.getDb().getCollection(COLLECTION_NAME).drop();
		mongoTemplate.getDb().createCollection(COLLECTION_NAME);
	}

	public void recreateIndexes() {
		mongoTemplate.indexOps(COLLECTION_NAME).ensureIndex(new Index(DATE_FIELD_NAME, Direction.DESC));
	}

}