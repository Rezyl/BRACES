package cz.uhk.braces.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.uhk.braces.model.Address;
import cz.uhk.braces.repository.AddressRepository;
import cz.uhk.braces.service.CRUDService;

@Service
public class AddressServiceImpl extends AbstractCRUDService<Address, AddressRepository> implements CRUDService<Address>{

	@Autowired
	protected AddressServiceImpl(AddressRepository repository) {
		super(repository);
	}

}
