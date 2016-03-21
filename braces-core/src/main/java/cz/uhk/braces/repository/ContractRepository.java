package cz.uhk.braces.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.uhk.braces.model.Contract;

public interface ContractRepository extends JpaRepository<Contract, Long>{

}
