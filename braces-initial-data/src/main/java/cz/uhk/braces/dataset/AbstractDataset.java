package cz.uhk.braces.dataset;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User: Lukas Rezner
 * Date: 27.2.16
 */
public abstract class AbstractDataset {
	private final Logger LOG = LoggerFactory.getLogger(getClass());

	public void load() {
		long start = System.nanoTime();
		loadData();
		long end = System.nanoTime();
		LOG.info("Dataset '{}' has been loaded in {} ms", getClass().getSimpleName(), (end-start)/1000000);
	}

	protected abstract void loadData();
}
