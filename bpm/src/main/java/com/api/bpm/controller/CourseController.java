package com.api.bpm.controller;

import com.api.bpm.model.dto.CourseDto;
import com.api.bpm.model.entities.Course;
import com.api.bpm.model.entities.Instructor;
import com.api.bpm.service.CourseService;
import com.api.bpm.service.impl.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/course")
@SecurityRequirement(name = "BPM")
public class CourseController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CourseService courseService;

    @GetMapping("/getCourses")
    @PreAuthorize("hasRole('INSTRUCTOR','STUDENT','ADMIN')")
    public List<CourseDto> getAllCourses(){
        return courseService.getAllCourses().stream().map(course -> modelMapper.map(course,CourseDto.class)).collect(Collectors.toList());
    }

    @PostMapping("/createCourse")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<CourseDto> createCourse(@RequestBody CourseDto courseDto){

        //Convert DTO to entity
        Course courseRequest = modelMapper.map(courseDto,Course.class);
        Course course = courseService.createCourse(courseRequest);

        //Convert entity to DTO
        CourseDto courseResponse = modelMapper.map(course,CourseDto.class);
        return new ResponseEntity<CourseDto>(courseResponse, HttpStatus.CREATED);
    }

    @PutMapping("/updateCourse/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<CourseDto> updateCourse(@PathVariable long id, @RequestBody CourseDto courseDto){

        //Convert DTO to entity
        Course courseRequest = modelMapper.map(courseDto, Course.class);
        Course course = courseService.updateCourse(id, courseRequest);

        //Entity to DTO
        CourseDto courseResponse = modelMapper.map(course, CourseDto.class);
        return ResponseEntity.ok().body(courseResponse);
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<ApiResponse> deleteCourse(@PathVariable(name = "id") Long id) {
        courseService.deleteCourse(id);
        ApiResponse apiResponse = new ApiResponse(Boolean.TRUE, "Course deleted successfully", HttpStatus.OK);
        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/getCourse/{id}")
    @PreAuthorize("hasAnyRole('STUDENT','INSTRUCTOR','ADMIN')")
    public ResponseEntity<CourseDto> getCourseById(@PathVariable(name ="id")Long id){
        Course course = courseService.getCourseById(id);

        //convert entity to dto
        CourseDto courseResponse = modelMapper.map(course, CourseDto.class);
        return ResponseEntity.ok().body(courseResponse);
    }

    @GetMapping("/getCourse/instructor/{id}")
    @PreAuthorize("hasAnyRole('STUDENT','INSTRUCTOR','ADMIN')")
    public ResponseEntity<CourseDto> getCourseByInstructor(@PathVariable(name ="instructor")Instructor instructor){
        Course course = courseService.getCourseByInstructor(instructor);

        //convert entity to dto
        CourseDto courseResponse = modelMapper.map(course, CourseDto.class);
        return ResponseEntity.ok().body(courseResponse);
    }
}
