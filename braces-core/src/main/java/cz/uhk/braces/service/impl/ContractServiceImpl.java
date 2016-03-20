package cz.uhk.braces.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.uhk.braces.model.Contract;
import cz.uhk.braces.repository.ContractRepository;
import cz.uhk.braces.service.CRUDService;

@Service
public class ContractServiceImpl extends AbstractCRUDService<Contract, ContractRepository> implements CRUDService<Contract>{

	@Autowired
	protected ContractServiceImpl(ContractRepository repository) {
		super(repository);
	}

}
