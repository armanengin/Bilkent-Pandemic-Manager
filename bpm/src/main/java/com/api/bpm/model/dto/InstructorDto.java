package com.api.bpm.model.dto;

import com.api.bpm.model.entities.*;
import com.api.bpm.model.enums.COVID_STATUS;
import com.api.bpm.model.enums.COVID_TEST_RESULT;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstructorDto {
    private String username;
    private String name;
    private String surname;
    private String email;
    private Long bilkentId;
    private COVID_STATUS covidStatus;
    private AbroadVaccineCardDto abroadVaccineCard;
    private BaseVaccineCardDto baseVaccineCard;
    private List<HesCodeDto> hesCodes;
    private List<CourseInfoDto> courseInfos;
    private List<COVID_TEST_RESULT> pastTestResults;
    private QuarantineDto quarantine;
    private List<InstructorCourseDto> courses;
}
