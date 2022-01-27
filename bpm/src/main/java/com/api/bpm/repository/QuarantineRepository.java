package com.api.bpm.repository;

import com.api.bpm.model.entities.Quarantine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuarantineRepository extends JpaRepository<Quarantine, Long> {
    
}
