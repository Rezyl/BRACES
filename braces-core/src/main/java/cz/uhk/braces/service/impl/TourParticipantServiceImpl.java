package cz.uhk.braces.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.uhk.braces.model.TourParticipant;
import cz.uhk.braces.repository.TourParticipantRepository;
import cz.uhk.braces.service.CRUDService;

@Service
public class TourParticipantServiceImpl extends AbstractCRUDService<TourParticipant, TourParticipantRepository> implements CRUDService<TourParticipant>{

	@Autowired
	protected TourParticipantServiceImpl(TourParticipantRepository repository) {
		super(repository);
	}

}
