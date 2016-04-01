package cz.uhk.braces.dataset.main;

import cz.uhk.braces.MainLoader;
import cz.uhk.braces.dataset.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * User: Lukas Rezner
 * Date: 17.3.16
 */
@Component
public class CreateTestDataset extends AbstractDataset {

	@Autowired
	private CountryDataset countryDataset;

	@Autowired
	private TourTestDataset tourTestDataset;
	
	@Autowired
	private TourParticipantTestDataset tourParticipantTestDataset;
	
	@Autowired
	private ContractTestDataset contractTestDataset;

	@Autowired
	private RegisterItemDataset registerItemDataset;
	
	@Autowired
	private AccomodationTestDataset accomodationTestDataset;

	public static void main(String[] args) {
		MainLoader.load("/braces-initial-data-context.xml", "createTestDataset");
	}

	@Override
	protected void loadData() {
		registerItemDataset.load();
		countryDataset.load();
		accomodationTestDataset.load();
		tourTestDataset.load();
		tourParticipantTestDataset.load();
		contractTestDataset.load();
	}
}
