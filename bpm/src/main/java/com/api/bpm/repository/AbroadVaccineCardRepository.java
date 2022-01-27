package com.api.bpm.repository;

import java.util.List;

import com.api.bpm.model.entities.AbroadVaccineCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbroadVaccineCardRepository extends JpaRepository<AbroadVaccineCard, Long> {
    List<AbroadVaccineCard> findByCountry(String country);
}
