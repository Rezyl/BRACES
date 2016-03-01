package usrm.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import usrm.model.User;

/**
 * User: Lukas Rezner
 * Date: 27.2.16
 */
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {

	User findByLogin(String login, Sort sort);
}
