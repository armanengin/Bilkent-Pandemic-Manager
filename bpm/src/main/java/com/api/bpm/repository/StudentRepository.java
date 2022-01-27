package com.api.bpm.repository;

import java.util.List;

import com.api.bpm.model.entities.DormRoomInfo;
import com.api.bpm.model.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
