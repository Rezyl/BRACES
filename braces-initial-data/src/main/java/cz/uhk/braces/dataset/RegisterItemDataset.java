package cz.uhk.braces.dataset;

import cz.uhk.braces.MainLoader;
import cz.uhk.braces.model.register.Register;
import cz.uhk.braces.model.register.RegisterItem;
import cz.uhk.braces.service.RegisterItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Lukas Rezner
 * Date: 20.3.16
 */
@Component("register-item-dataset")
public class RegisterItemDataset extends AbstractDataset {
	private static final Logger LOG = LoggerFactory.getLogger(RegisterItemDataset.class);

	@Autowired
	private RegisterItemService registerItemService;

	@Override
	protected void loadData() {
		List<RegisterItem> toStore = new ArrayList<>();

//		Typ zájezdu
		toStore.add(new RegisterItem("PACKAGE_TOURS", "Pobytové zájezdy", Register.TOUR_TYPE));
		toStore.add(new RegisterItem("NEAR_SEA", "Pobytové zájezdy", Register.TOUR_TYPE));
		toStore.add(new RegisterItem("SKY_TOURS", "Blízká moře", Register.TOUR_TYPE));
		toStore.add(new RegisterItem("COGNITIVE_TOURS", "Poznávací zájezdy", Register.TOUR_TYPE));
		toStore.add(new RegisterItem("EXOTICA", "Exotila", Register.TOUR_TYPE));
		toStore.add(new RegisterItem("EURO_WEEKEND", "Eurovíkendy", Register.TOUR_TYPE));
		toStore.add(new RegisterItem("COTTAGES", "Chaty a chalupy", Register.TOUR_TYPE));
		toStore.add(new RegisterItem("HOLIDAY_HOMES", "Rekreační domy", Register.TOUR_TYPE));
		toStore.add(new RegisterItem("MOUNTAINS", "Hory a jezera", Register.TOUR_TYPE));
		toStore.add(new RegisterItem("ACTIVE_HOLIDAY", "Aktivní dovolená", Register.TOUR_TYPE));
		toStore.add(new RegisterItem("BOATING", "Plavba lodí", Register.TOUR_TYPE));
		toStore.add(new RegisterItem("INDIVIDUAL_TOURISM", "Individuální turistika", Register.TOUR_TYPE));
//		Typ dopravy
		toStore.add(new RegisterItem("BUS", "Autobusem", Register.TRANSPORT_TYPE));
		toStore.add(new RegisterItem("AIRPLANE", "Letecky", Register.TRANSPORT_TYPE));
		toStore.add(new RegisterItem("TRAIN", "Vlakem", Register.TRANSPORT_TYPE));
		toStore.add(new RegisterItem("OWN", "Vlastní", Register.TRANSPORT_TYPE));
//		Kategorie
		toStore.add(new RegisterItem("FIRST_MINUTE", "First minute", Register.TOUR_CATEGORY));
		toStore.add(new RegisterItem("LAST_MINUTE", "Last minute", Register.TOUR_CATEGORY));
		toStore.add(new RegisterItem("VIP", "VIP", Register.TOUR_CATEGORY));
		toStore.add(new RegisterItem("SALE", "Akční nabídka", Register.TOUR_CATEGORY));
		toStore.add(new RegisterItem("STANDARD", "Standardní zájezd", Register.TOUR_CATEGORY));
//		Stravování
		toStore.add(new RegisterItem("WITHOUT", "Bez stravy", Register.TOUR_CATERING));
		toStore.add(new RegisterItem("BREAKFAST", "Snídaně", Register.TOUR_CATERING));
		toStore.add(new RegisterItem("LUNCH", "Obědy", Register.TOUR_CATERING));
		toStore.add(new RegisterItem("LUNCH", "Obědy", Register.TOUR_CATERING));
		toStore.add(new RegisterItem("DINNER", "Večeře", Register.TOUR_CATERING));
		toStore.add(new RegisterItem("HALF_BOARD", "Polopenze", Register.TOUR_CATERING));
		toStore.add(new RegisterItem("FULL_BOARD", "Plná penze", Register.TOUR_CATERING));
		toStore.add(new RegisterItem("ALL_INCLUSIVE", "All inclusive", Register.TOUR_CATERING));
		toStore.add(new RegisterItem("Ultra_INCLUSIVE", "Ultra inclusive", Register.TOUR_CATERING));
//		Typ ubytování
		toStore.add(new RegisterItem("HOTEL", "Hotel", Register.TOUR_ACCOMMODATION));
		toStore.add(new RegisterItem("TENT", "Stan", Register.TOUR_ACCOMMODATION));
		toStore.add(new RegisterItem("APARTMENT", "Apartmán", Register.TOUR_ACCOMMODATION));
		toStore.add(new RegisterItem("STUDIO", "Studio", Register.TOUR_ACCOMMODATION));
//		Fakultativní služby
		toStore.add(new RegisterItem("LAUNDRY", "Praní prádla", Register.OPTIONAL_SERVICE));
		toStore.add(new RegisterItem("SWIMMING_POOL", "Bazén", Register.OPTIONAL_SERVICE));
		toStore.add(new RegisterItem("WELLNESS", "Wellness", Register.OPTIONAL_SERVICE));
		toStore.add(new RegisterItem("HAIRDRESSER", "Kadeřnictví", Register.OPTIONAL_SERVICE));
		toStore.add(new RegisterItem("PEDICURE", "Pedicure", Register.OPTIONAL_SERVICE));
		toStore.add(new RegisterItem("LIBRARY", "Knihovna", Register.OPTIONAL_SERVICE));
		toStore.add(new RegisterItem("FITNESS", "Posilovna", Register.OPTIONAL_SERVICE));

		saveRegisterItems(toStore);
	}

	private void saveRegisterItems(List<RegisterItem> toStore) {
		for (RegisterItem registerItem : toStore) {
			registerItemService.update(registerItem);
			LOG.info("It was created register item: {}", registerItem);
		}
	}
	
	public static void main(String[] args) {
		MainLoader.load("/braces-initial-data-context.xml", "register-item-dataset");
	}
}
