package com.api.bpm.repository;

import com.api.bpm.model.entities.BaseVaccineCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BaseVaccineCardRepository extends JpaRepository<BaseVaccineCard, Long> {
    List<BaseVaccineCard> vaccinationDate(LocalDate vaccinationDate);

}
