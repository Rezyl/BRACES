package cz.uhk.braces.dataset;

import cz.uhk.braces.MainLoader;
import cz.uhk.braces.model.*;
import cz.uhk.braces.service.CRUDService;
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

	@Override
	protected void loadData() {
		createTestTours();
	}

	private void createTestTours() {
		List<Country> countries = countryService.getAll();
		for (int i = 0; i < 10; i++) {
			Tour tour = new Tour();
			tour.setAccommodation(TourAccommodation.APARTMENT);
			tour.setCategory(TourCategory.RELAX);
			tour.setCatering(TourCatering.FULL_BOARD);
			tour.setTransportType(TransportType.BUS);

			tour.setPrice(new BigDecimal(10000));
			tour.setDate(DateTime.now());
			tour.setTourLength(10);
			tour.setCountry(countries.isEmpty() ? null : countries.get(0));
			tourService.update(tour);
		}
	}

	public static void main(String[] args) {
		MainLoader.load("/braces-initial-data-context.xml", "tour-dataset");
	}
}
