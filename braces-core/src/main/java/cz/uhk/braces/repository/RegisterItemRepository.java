package cz.uhk.braces.repository;

import cz.uhk.braces.model.register.Register;
import cz.uhk.braces.model.register.RegisterItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * User: Lukas Rezner
 * Date: 20.3.16
 */
public interface RegisterItemRepository extends JpaRepository<RegisterItem, Long> {

	List<RegisterItem> findByRegister(Register register);
	RegisterItem findByCode(String code);
}
