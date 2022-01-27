package com.api.bpm.repository;

import java.util.List;

import com.api.bpm.model.entities.CourseInfo;
import com.api.bpm.model.enums.DEPARTMENT;
import com.api.bpm.model.enums.LECTURE_CODE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseInfoRepository extends JpaRepository<CourseInfo, Long> {
    List<CourseInfo> findByCourseDepartment(DEPARTMENT department);
    List<CourseInfo> findByLectureCode(LECTURE_CODE lecture_code);
    List<CourseInfo> findBySection(int section);
    List<CourseInfo> findByName(String name);
}
