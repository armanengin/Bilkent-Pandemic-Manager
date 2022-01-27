package com.api.bpm.model.dto;

import com.api.bpm.model.enums.DEPARTMENT;
import com.api.bpm.model.enums.LECTURE_CODE;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseInfoDto {
    private DEPARTMENT courseDepartment;
    private LECTURE_CODE lectureCode;
    private int section;
    private String name;
}
