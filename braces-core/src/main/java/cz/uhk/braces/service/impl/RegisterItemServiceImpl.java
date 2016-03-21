package cz.uhk.braces.service.impl;

import cz.uhk.braces.model.register.Register;
import cz.uhk.braces.model.register.RegisterItem;
import cz.uhk.braces.repository.RegisterItemRepository;
import cz.uhk.braces.service.RegisterItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * User: Lukas Rezner
 * Date: 20.3.16
 */
@Service
public class RegisterItemServiceImpl extends AbstractCRUDService<RegisterItem, RegisterItemRepository> implements RegisterItemService {
	private static final Logger LOG = LoggerFactory.getLogger(RegisterItemServiceImpl.class);

	private RegisterItemRepository registerItemRepository;

	@Autowired
	protected RegisterItemServiceImpl(RegisterItemRepository repository) {
		super(repository);
		this.registerItemRepository = repository;
	}

	@Override
	public List<RegisterItem> getByRegisterCode(String registerCode) {
		Register register = Register.getByCode(registerCode);
		if (register != null) {
			return getByRegister(register);
		}
		LOG.error("Register with code {} does not exist.", registerCode);
		return Collections.emptyList();
	}

	@Override
	public List<RegisterItem> getByRegister(Register register) {
		return registerItemRepository.findByRegister(register);
	}

	@Override
	public RegisterItem getByRegisterItemCode(String registerItemCode) {
		return registerItemRepository.findByCode(registerItemCode);
	}
}
