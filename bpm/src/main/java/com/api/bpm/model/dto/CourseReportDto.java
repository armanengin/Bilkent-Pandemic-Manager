package com.api.bpm.model.dto;

import com.api.bpm.model.entities.CourseInfo;
import com.api.bpm.model.entities.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseReportDto {
    private LocalDate reportStartDate;
    private LocalDate reportEndDate;
    private int numberOfPositivePeople;
    private int numberOfTests;
    private CourseInfoDto courseInfo;
    private List<StudentDto> positiveStudents;
}
