package com.api.bpm.repository;

import java.util.List;

import com.api.bpm.model.entities.Course;
import com.api.bpm.model.entities.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long> {
}
