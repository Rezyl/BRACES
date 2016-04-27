package cz.uhk.braces.dataset;

import cz.uhk.braces.MainLoader;
import cz.uhk.braces.model.*;
import cz.uhk.braces.model.register.Register;
import cz.uhk.braces.service.CRUDService;
import cz.uhk.braces.service.RegisterItemService;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

/**
 * User: Lukas Rezner
 * Date: 27.2.16
 */
@Component("tour-dataset")
public class TourTestDataset extends AbstractDataset {
	private static final Logger LOG = LoggerFactory.getLogger(TourTestDataset.class);

	@Autowired
	@Qualifier("tourServiceImpl")
	private CRUDService<Tour> tourService;

	@Autowired
	@Qualifier("countryServiceImpl")
	private CRUDService<Country> countryService;
	

	@Autowired
	@Qualifier("accomodationServiceImpl")
	private CRUDService<Accomodation> accomodationService;

	@Autowired
	private RegisterItemService registerItemService;
	

	@Override
	protected void loadData() {
		createTestTours();
	}

	private void createTestTours() {
		List<Country> countries = countryService.getAll();
		for (int i = 0; i < 10; i++) {
			Tour tour = new Tour();
			tour.setAccommodation(accomodationService.getAll().get(0));
			tour.setCategory(registerItemService.getByRegister(Register.TOUR_CATEGORY).get(0));
			tour.setCatering(registerItemService.getByRegister(Register.TOUR_CATERING).get(0));
			tour.setTransportType(registerItemService.getByRegister(Register.TRANSPORT_TYPE).get(0));
			tour.setType(registerItemService.getByRegister(Register.TOUR_TYPE).get(0));

			tour.setPrice(new BigDecimal(i));
			tour.setDateFrom(DateTime.now());
			tour.setDateTo(DateTime.now().plusMonths(i));
			tour.setTourLength(i);
			tour.setCountry(countries.isEmpty() ? null : countries.get(0));
			tour.setCatalog(true);
			tourService.update(tour);


		}
	}

	public static void main(String[] args) {
		MainLoader.load("/braces-initial-data-context.xml", "tour-dataset");
	}
}
