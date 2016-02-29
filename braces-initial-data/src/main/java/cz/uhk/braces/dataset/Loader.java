package cz.uhk.braces.dataset;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * Initial data loader component which executes load on all required datasets.
 */
@Component
public class Loader {

	@Autowired
	private BeanFactory factory;

    /**
	 * Load dataset into database.
	 * 
	 * @param aDatasets
	 *            list of datasets to load
	 */
	public void load(final String... aDatasets) {
            initDatasets(aDatasets);

			TransactionTemplate transactionTemplate = factory.getBean(TransactionTemplate.class);
			transactionTemplate.execute(new TransactionCallbackWithoutResult() {

				@Override
				protected void doInTransactionWithoutResult(TransactionStatus status) {
					loadInternal(aDatasets);
				}
			});
	}

    /**
     * Gets dataset beans which invokes autowires resolving ...
     * initializes Spring JPA repositories which would otherwise mark transactions for rollback only
     * with Hibernate 4.3.
     *
     * See https://hibernate.atlassian.net/browse/HHH-8837.
     */
    private void initDatasets(String... aDatasets){
        for (String dataset : aDatasets) {
            factory.getBean(dataset, AbstractDataset.class);
        }
    }

	private void loadInternal(String... aDatasets) {
		for (String dataset : aDatasets) {
			factory.getBean(dataset, AbstractDataset.class).load();
		}
	}
}
