package usrm.service.api;

import java.util.Set;

import usrm.model.User;

/**
 * Created with IntelliJ IDEA.
 * User: lukas
 * Date: 2.1.15
 */
public interface UserService {

	User getByID(Long id);

	void save(User type);

	void edit(User type);

	void delete(Long id);

	Set<User> getAll();

	void deleteAll();

	User getByName(String name);
}
