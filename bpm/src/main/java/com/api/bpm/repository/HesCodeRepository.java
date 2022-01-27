package com.api.bpm.repository;

import com.api.bpm.model.entities.HesCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HesCodeRepository extends JpaRepository<HesCode, Long> {

}
