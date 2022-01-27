package com.api.bpm.repository;

import com.api.bpm.model.entities.Course;
import com.api.bpm.model.entities.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LectureRepository extends JpaRepository<Lecture, Long> {
    List<Lecture> findByCourse(Course course);
}
