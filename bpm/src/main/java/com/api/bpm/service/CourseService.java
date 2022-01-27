package com.api.bpm.service;

import java.util.List;

import com.api.bpm.model.entities.Course;
import com.api.bpm.model.entities.Instructor;
import org.springframework.stereotype.Service;

@Service
public interface CourseService {
    List<Course> getAllCourses();
    Course createCourse(Course course);
    Course updateCourse(long id, Course course);
    void deleteCourse(long id);
    Course getCourseById(long id);
    Course getCourseByInstructor(Instructor instructor);
}
