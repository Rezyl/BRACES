package cz.uhk.braces.dataset;

import java.math.BigDecimal;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import cz.uhk.braces.MainLoader;
import cz.uhk.braces.model.Contract;
import cz.uhk.braces.model.Tour;
import cz.uhk.braces.model.TourParticipant;
import cz.uhk.braces.service.CRUDService;

@Component("contract-dataset")
public class ContractTestDataset extends AbstractDataset {

	@Autowired
	@Qualifier("tourServiceImpl")
	private CRUDService<Tour> tourService;

	@Autowired
	@Qualifier("tourParticipantServiceImpl")
	private CRUDService<TourParticipant> tourParticipantService;

	@Autowired
	@Qualifier("contractServiceImpl")
	private CRUDService<Contract> contractService;

	@Override
	protected void loadData() {

		List<TourParticipant> participants = tourParticipantService.getAll();
		List<Tour> tours = tourService.getAll();

		for (int i = 0; i < 10; i++) {
			Contract contract = new Contract();
			contract.setContactParticipant(participants.get(0));
			contract.setCreationDate(new DateTime());
			contract.setPricePayed(new BigDecimal(1000));
			contract.setTour(tours.get(0));
		}


	}

	public static void main(String[] args) {
		MainLoader.load("/braces-initial-data-context.xml", "contract-dataset");
	}

}
