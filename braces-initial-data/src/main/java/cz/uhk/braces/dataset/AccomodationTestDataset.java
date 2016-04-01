package cz.uhk.braces.dataset;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import cz.uhk.braces.MainLoader;
import cz.uhk.braces.model.Accomodation;
import cz.uhk.braces.model.Address;
import cz.uhk.braces.model.register.Register;
import cz.uhk.braces.model.register.RegisterItem;
import cz.uhk.braces.service.CRUDService;
import cz.uhk.braces.service.RegisterItemService;

@Component("accomodation-dataset")
public class AccomodationTestDataset extends AbstractDataset{
	
	@Autowired
	@Qualifier("accomodationServiceImpl")
	private CRUDService<Accomodation> accomodationService;

	@Autowired
	private RegisterItemService registerItemService;
	
	@Autowired
	@Qualifier("addressServiceImpl")
	private CRUDService<Address> addressService;
	
	private static final Logger LOG = LoggerFactory.getLogger(AccomodationTestDataset.class);
	
	public static void main(String[] args) {
		MainLoader.load("/braces-initial-data-context.xml", "accomodation-dataset");
	}

	@Override
	protected void loadData() {
		for (int i = 0; i < 5; i++) {
			Accomodation accomodation = new Accomodation();
			accomodation.setAccomodationType(registerItemService.getByRegister(Register.TOUR_ACCOMMODATION).get(0));
			accomodation.setAddress(addressService.getByID(1l));
			accomodation.setCapacity(111);
			accomodation.setName("U Vody");
			accomodation.setPrice(new BigDecimal(125));
			accomodation.setRating(3);
			
			List<RegisterItem> optionalServices = new ArrayList<>();
			optionalServices.add(registerItemService.getByRegister(Register.OPTIONAL_SERVICE).get(0));
			optionalServices.add(registerItemService.getByRegister(Register.OPTIONAL_SERVICE).get(1));
			
			accomodation.setOptionalServices(optionalServices);
			accomodationService.update(accomodation);
			
			accomodation = new Accomodation();
			accomodation.setAccomodationType(registerItemService.getByRegister(Register.TOUR_ACCOMMODATION).get(1));
			accomodation.setAddress(addressService.getByID(0l));
			accomodation.setCapacity(111);
			accomodation.setName("U Sklípku");
			accomodation.setPrice(new BigDecimal(100));
			accomodation.setRating(4);
			
			optionalServices = new ArrayList<>();
			optionalServices.add(registerItemService.getByRegister(Register.OPTIONAL_SERVICE).get(2));
			optionalServices.add(registerItemService.getByRegister(Register.OPTIONAL_SERVICE).get(3));
			
			accomodation.setOptionalServices(optionalServices);
			accomodationService.update(accomodation);			
		}
		
	}

}
