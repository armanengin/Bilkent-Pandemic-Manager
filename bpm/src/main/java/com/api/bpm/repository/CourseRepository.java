package com.api.bpm.repository;

import java.util.List;
import java.util.Optional;

import com.api.bpm.model.entities.Course;
import com.api.bpm.model.entities.Instructor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    Optional<Course> findByInstructor(Instructor instructor);
}
