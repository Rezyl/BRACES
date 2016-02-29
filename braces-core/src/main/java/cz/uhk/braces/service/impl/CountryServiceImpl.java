package cz.uhk.braces.service.impl;

import cz.uhk.braces.model.Country;
import cz.uhk.braces.repository.CountryRepository;
import cz.uhk.braces.service.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User: Lukas Rezner
 * Date: 27.2.16
 */
@Service
public class CountryServiceImpl extends AbstractCRUDService<Country, CountryRepository> implements CRUDService<Country> {

	@Autowired
	protected CountryServiceImpl(CountryRepository repository) {
		super(repository);
	}
}
