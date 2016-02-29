package cz.uhk.braces.dataset;

import cz.uhk.braces.MainLoader;
import cz.uhk.braces.model.Country;
import cz.uhk.braces.service.CRUDService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * User: Lukas Rezner
 * Date: 27.2.16
 */
@Component("country-dataset")
public class CountryDataset extends AbstractDataset {
	private static final Logger LOG = LoggerFactory.getLogger(CountryDataset.class);

	@Autowired
	@Qualifier("countryServiceImpl")
	private CRUDService<Country> countryService;

	@Override
	protected void loadData() {
		countryService.update(createCountry("ITALY", "Itálie"));
		countryService.update(createCountry("TURKEY", "Turecko"));
	}

	private Country createCountry(String code, String name) {
		Country c = new Country();
		c.setCountryCode(code);
		c.setCountryName(name);
		LOG.info("It was created country: {}", c);
		return c;
	}

	public static void main(String[] args) {
		MainLoader.load("/braces-initial-data-context.xml", "country-dataset");
	}
}
