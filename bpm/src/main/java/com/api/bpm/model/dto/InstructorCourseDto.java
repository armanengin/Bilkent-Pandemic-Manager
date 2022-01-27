package com.api.bpm.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstructorCourseDto {
    private CourseInfoDto courseInfo;
    private List<CourseLectureDto> lectures;
    private List<StudentDto> students;
}
