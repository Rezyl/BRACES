package cz.uhk.braces.dataset.main;

import cz.uhk.braces.MainLoader;
import cz.uhk.braces.dataset.AbstractDataset;
import cz.uhk.braces.dataset.CountryDataset;
import cz.uhk.braces.dataset.TourTestDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * User: Lukas Rezner
 * Date: 17.3.16
 */
@Component
public class ReloadTestDataset extends AbstractDataset {

	@Autowired
	private CountryDataset countryDataset;

	@Autowired
	private TourTestDataset tourTestDataset;



	public static void main(String[] args) {
		MainLoader.load("/braces-initial-data-context.xml", "reloadTestDataset");
	}

	@Override
	protected void loadData() {
		countryDataset.load();
		tourTestDataset.load();
	}
}
