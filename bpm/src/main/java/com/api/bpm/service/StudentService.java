package com.api.bpm.service;

import com.api.bpm.model.entities.HesCode;
import com.api.bpm.model.entities.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    List<Student> getAllStudents();
    Student createStudent(Student student);
    Student updateStudent(long id, Student student);
    void deleteStudent(long id);
    Student getStudentById(long id);
    Student addNearbyStudent(long id, long nearbyId);
    boolean deleteNearbyStudent(long id, long nearbyId);
}
