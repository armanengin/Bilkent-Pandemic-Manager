package com.api.bpm.repository;

import com.api.bpm.model.entities.CovidTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CovidTestRepository extends JpaRepository<CovidTest, Long> {

}
