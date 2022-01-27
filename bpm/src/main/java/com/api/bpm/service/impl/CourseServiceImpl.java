package com.api.bpm.service.impl;

import java.util.List;

import com.api.bpm.model.entities.Course;
import com.api.bpm.model.entities.Instructor;
import com.api.bpm.repository.CourseRepository;
import com.api.bpm.service.CourseService;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {
    
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
 
    }

    @Override
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course updateCourse(long id, Course courseRequest) {
        Course course = courseRepository.findById(id).orElseThrow();
        course.setCourseInfo(courseRequest.getCourseInfo());
        course.setInstructor(courseRequest.getInstructor());
        course.setLectures(course.getLectures());
        return courseRepository.save(courseRequest);
    }

    @Override
    public void deleteCourse(long id) {
        Course course = courseRepository.findById(id).orElseThrow();
        courseRepository.delete(course);     
    }

    @Override
    public Course getCourseById(long id) {
        Optional<Course> course = courseRepository.findById(id);
        if(course.isPresent()) return course.get();
        return null;
    }

    @Override
    public Course getCourseByInstructor(Instructor instructor) {
        Optional<Course> course = courseRepository.findByInstructor(instructor);
        if(course.isPresent()) return course.get();
        return null;
    }
}
