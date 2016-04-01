package cz.uhk.braces.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.uhk.braces.model.Accomodation;
import cz.uhk.braces.repository.AccomodationRepository;
import cz.uhk.braces.service.CRUDService;

@Service
public class AccomodationServiceImpl extends AbstractCRUDService<Accomodation, AccomodationRepository> implements CRUDService<Accomodation>{

	@Autowired
	protected AccomodationServiceImpl(AccomodationRepository repository) {
		super(repository);
	}

}
