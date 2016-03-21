package cz.uhk.braces.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.uhk.braces.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

}
