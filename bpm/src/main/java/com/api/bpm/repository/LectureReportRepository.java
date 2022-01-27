package com.api.bpm.repository;

import com.api.bpm.model.entities.LectureReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LectureReportRepository extends JpaRepository<LectureReport, Long> {
    List<LectureReport> findByIsOnline(boolean isOnline);


}
