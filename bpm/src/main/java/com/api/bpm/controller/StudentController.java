package com.api.bpm.controller;

import com.api.bpm.model.dto.StudentDto;
import com.api.bpm.model.entities.Student;
import com.api.bpm.service.StudentService;
import com.api.bpm.service.impl.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class StudentController {
    private final ModelMapper modelMapper;
    private final StudentService studentService;

    @GetMapping("student/getAll")
    @PreAuthorize("hasAnyRole('STUDENT','INSTRUCTOR','ADMIN')")
    public List<StudentDto> getAllStudent(){
        return studentService.getAllStudents().stream().map(student -> modelMapper.map(student, StudentDto.class)).collect(Collectors.toList());
    }

    @PostMapping("student/create")
    @PreAuthorize("hasAnyRole('STUDENT','INSTRUCTOR','ADMIN')")
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto){
        //Convert DTO to entity
        Student studentRequest = modelMapper.map(studentDto, Student.class);
        Student student = studentService.createStudent(studentRequest);
        //Convert entity to DTO
        StudentDto studentResponse = modelMapper.map(student, StudentDto.class);
        return new ResponseEntity<StudentDto>(studentResponse, HttpStatus.CREATED);
    }

    @PutMapping("student/update/{id}")
    @PreAuthorize("hasAnyRole('STUDENT','INSTRUCTOR','ADMIN')")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable long id, @RequestBody StudentDto studentDto){
        //Convert DTO to entity
        Student studentRequest = modelMapper.map(studentDto, Student.class);
        Student student = studentService.updateStudent(id, studentRequest);

        //Entity to DTO
        StudentDto studentResponse = modelMapper.map(student, StudentDto.class);
        return ResponseEntity.ok().body(studentResponse);
    }

    @DeleteMapping("student/delete/{id}")
    @PreAuthorize("hasAnyRole('STUDENT','INSTRUCTOR','ADMIN')")
    public ResponseEntity<ApiResponse> deleteStudent(@PathVariable(name = "id") Long id) {
        studentService.deleteStudent(id);
        ApiResponse apiResponse = new ApiResponse(Boolean.TRUE, "Student deleted successfully", HttpStatus.OK);
        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("student/get/{id}")
    @PreAuthorize("hasAnyRole('STUDENT','INSTRUCTOR','ADMIN')")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable(name ="id")Long id){
        Student student = studentService.getStudentById(id);

        //convert entity to dto
        StudentDto studentResponse = modelMapper.map(student, StudentDto.class);
        return ResponseEntity.ok().body(studentResponse);
    }

    @PostMapping("student/addNearby/{id}/{nearbyId}")
    @PreAuthorize("hasRole('STUDENT')")
    public ResponseEntity<StudentDto> addNearbyStudent(@PathVariable(name = "id") long id, @PathVariable(name = " nearbyId") long nearbyId){
        Student student = studentService.addNearbyStudent(id, nearbyId);
        StudentDto studentResponse = modelMapper.map(student, StudentDto.class);
        return ResponseEntity.ok().body(studentResponse);
    }

    @DeleteMapping("student/deleteNearby/{id}/{nearbyId}")
    @PreAuthorize("hasRole('STUDENT')")
    public ResponseEntity<ApiResponse> deleteNearbyStudent(@PathVariable(name = "id") long id, @PathVariable(name = " nearbyId") long nearbyId){
        boolean deleted = studentService.deleteNearbyStudent(id, nearbyId);
        if(deleted) {
            ApiResponse apiResponse = new ApiResponse(Boolean.TRUE, "Student deleted successfully", HttpStatus.OK);
            return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
        }
        else{
            ApiResponse apiResponse = new ApiResponse(Boolean.TRUE, "Student could not find", HttpStatus.BAD_REQUEST);
            return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.BAD_REQUEST);
        }
    }
}
