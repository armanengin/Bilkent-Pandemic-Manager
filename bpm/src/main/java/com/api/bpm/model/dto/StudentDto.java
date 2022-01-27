package com.api.bpm.model.dto;

import com.api.bpm.model.entities.DormRoomInfo;
import com.api.bpm.model.entities.Student;
import com.api.bpm.model.enums.COVID_STATUS;
import com.api.bpm.model.enums.COVID_TEST_RESULT;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private String username;
    private String name;
    private String surname;
    private String password;
    private String email;
    private Long bilkentId;
    private COVID_STATUS covidStatus;
    private AbroadVaccineCardDto abroadVaccineCard;
    private BaseVaccineCardDto baseVaccineCard;
    private List<HesCodeDto> hesCodes;
    private List<CourseInfoDto> courseInfos;
    private List<COVID_TEST_RESULT> pastTestResults;
    private QuarantineDto quarantine;
    private DormRoomInfoDto dormRoomInfo;
    private List<StudentStudentDto> nearbyStudents;
}
