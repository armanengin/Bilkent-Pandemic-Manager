package com.api.bpm.repository;

import com.api.bpm.model.entities.DormReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DormReportRepository extends JpaRepository<DormReport, Long> {

}
