package cz.uhk.braces.service.impl;

import cz.uhk.braces.model.Tour;
import cz.uhk.braces.repository.TourRepository;
import cz.uhk.braces.service.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User: Lukas Rezner
 * Date: 27.2.16
 */
@Service
public class TourServiceImpl extends AbstractCRUDService<Tour, TourRepository> implements CRUDService<Tour> {

	@Autowired
	protected TourServiceImpl(TourRepository repository) {
		super(repository);
	}
}
