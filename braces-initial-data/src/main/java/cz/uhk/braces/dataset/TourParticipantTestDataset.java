package cz.uhk.braces.dataset;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import cz.uhk.braces.MainLoader;
import cz.uhk.braces.model.Address;
import cz.uhk.braces.model.TourParticipant;
import cz.uhk.braces.service.CRUDService;

@Component("tour-participant-dataset")
public class TourParticipantTestDataset extends AbstractDataset{
	
	@Autowired
	@Qualifier("tourParticipantServiceImpl")
	private CRUDService<TourParticipant> tourParticipantService;
	
	@Autowired
	@Qualifier("addressServiceImpl")
	private CRUDService<Address> addressService;

	@Override
	protected void loadData() {
		for (int i = 0; i < 10; i++) {
			Address address = new Address();
			address.setBuildingNumber("1122");
			address.setCity("Hradec Králové");
			address.setPostalCode("11144");
			address.setStreet("Hradecká");
			address.setState("Česká republika");
			addressService.update(address);
			
			TourParticipant tourParticipant = new TourParticipant();
			tourParticipant.setAddress(address);
			tourParticipant.setFirstName("Alžběta");
			tourParticipant.setLastName("Zcestovalá");
			tourParticipant.setBirthDate(new Date(1988, 1, 2));
			tourParticipant.setPIN("19880102/1222");
			tourParticipant.setPhoneNumber("112567112");
			tourParticipant.setEmail("betka.zcs@betka.cz");
			
			tourParticipantService.update(tourParticipant);
		}
		
	}
	
	public static void main(String[] args) {
		MainLoader.load("/braces-initial-data-context.xml", "tour-participant-dataset");
	}

}
