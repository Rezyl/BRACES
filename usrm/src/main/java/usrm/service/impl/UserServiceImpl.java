package usrm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import usrm.model.User;
import usrm.repository.UserRepository;
import usrm.service.api.UserService;

/**
 * Created with IntelliJ IDEA.
 * User: lukas
 * Date: 4.1.15
 */
@Service
public class UserServiceImpl extends AbstractCRUDService<User> implements UserService {

	@Autowired
	private UserRepository repository;

	@Override
	protected JpaRepository<User, Long> getRepositoryInstance() {
		return repository;
	}

	@Override
	public User getByName(String name)	{
		Sort userSort = new Sort(Sort.Direction.ASC, "login");
		return repository.findByLogin(name, userSort);
	}
}
