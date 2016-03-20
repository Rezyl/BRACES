package cz.uhk.braces.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.uhk.braces.model.TourParticipant;

public interface TourParticipantRepository extends JpaRepository<TourParticipant, Long>{

}
