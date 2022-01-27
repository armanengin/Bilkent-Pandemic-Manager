package com.api.bpm.repository;

import com.api.bpm.model.entities.CourseReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseReportRepository extends JpaRepository<CourseReport, Long> {
}
