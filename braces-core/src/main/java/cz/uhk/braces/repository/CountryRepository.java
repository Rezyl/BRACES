package cz.uhk.braces.repository;

import cz.uhk.braces.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * User: Lukas Rezner
 * Date: 27.2.16
 */
@Transactional
public interface CountryRepository extends JpaRepository<Country, Long> {
}
