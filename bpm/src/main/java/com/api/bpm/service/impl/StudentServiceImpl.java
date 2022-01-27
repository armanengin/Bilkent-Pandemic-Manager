package com.api.bpm.service.impl;

import com.api.bpm.model.entities.Student;
import com.api.bpm.repository.StudentRepository;
import com.api.bpm.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

   public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

   public Student createStudent(Student student){
        return studentRepository.save(student);
    }

    public Student updateStudent(long id, Student studentRequest){
        Student student = studentRepository.findById(id).orElseThrow();
        student.setNearbyStudents(studentRequest.getNearbyStudents());
        student.setDormRoomInfo(studentRequest.getDormRoomInfo());
        student.setRoles(studentRequest.getRoles());
        student.setAbroadVaccineCard(studentRequest.getAbroadVaccineCard());
        student.setBaseVaccineCard(studentRequest.getBaseVaccineCard());
        student.setCourseInfos(studentRequest.getCourseInfos());
        student.setCovidStatus(studentRequest.getCovidStatus());
        student.setEmail(studentRequest.getEmail());
        student.setHesCodes(studentRequest.getHesCodes());
        student.setName(studentRequest.getName());
        student.setPassword(studentRequest.getPassword());
        student.setQuarantine(studentRequest.getQuarantine());
        student.setPastTestResults(studentRequest.getPastTestResults());
        student.setSurname(studentRequest.getSurname());
        student.setUsername(studentRequest.getUsername());
        return studentRepository.save(student);
    }

    public void deleteStudent(long id){
        Student student = studentRepository.findById(id).orElseThrow();
        studentRepository.delete(student);
    }

    public Student getStudentById(long id){
        Optional<Student> hesCode = studentRepository.findById(id);
        if(hesCode.isPresent()) return hesCode.get();
        return null;
    }
    public Student addNearbyStudent(long id, long nearbyId){
        Student student = studentRepository.findById(id).orElseThrow();
        Student nearbyStudent = studentRepository.findById(nearbyId).orElseThrow();
        List<Student> nearbyStudentList = student.getNearbyStudents();
        nearbyStudentList.add(nearbyStudent);
        student.setNearbyStudents(nearbyStudentList);
        return studentRepository.save(student);
    }

    public boolean deleteNearbyStudent(long id, long nearbyId){
        Student student = studentRepository.findById(id).orElseThrow();
        Student nearbyStudent = studentRepository.findById(nearbyId).orElseThrow();
        List<Student> nearbyStudentList = student.getNearbyStudents();
        for(int i = 0; i < nearbyStudentList.size(); ++i){
            if(nearbyStudentList.get(i).getId() == nearbyId) {
                nearbyStudentList.remove(i);
                return true;
            }
        }
        return false;
    }
}
