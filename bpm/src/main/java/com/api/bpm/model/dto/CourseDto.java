package com.api.bpm.model.dto;

import com.api.bpm.model.entities.CourseInfo;
import com.api.bpm.model.entities.Instructor;
import com.api.bpm.model.entities.Lecture;
import com.api.bpm.model.entities.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDto {
    private CourseInfoDto courseInfo;
    private List<CourseLectureDto> lectures;
    private CourseInstructorDto instructor;
    private List<StudentDto> students;
}
