package com.api.bpm.facade;

import com.api.bpm.model.dto.*;
import com.api.bpm.model.entities.*;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class DtoConverter {
    AbroadVaccineCardDto abroadVaccineCardToDto(AbroadVaccineCard from){
        return new AbroadVaccineCardDto(from.getDate(),
                from.getCountry(),
                from.getVaccine(),
                from.isApproved());
    }
    BaseVaccineCardDto baseVaccineCardToDto(BaseVaccineCard from){
        return new BaseVaccineCardDto(from.getVaccine(),
                from.getVaccinationDate(),
                from.getVaccinationCertificateNumber(),
                from.isApproved());
    }

    CourseDto courseToDto(Course from){
        return new CourseDto(courseInfoToDto(from.getCourseInfo()),
                from.getLectures().stream().map(x -> courseLectureToDto(x)).collect(Collectors.toList()),
                courseInstructorToDto(from.getInstructor()),
                from.getStudents().stream().map(x -> studentToDto(x)).collect(Collectors.toList()));
    }

    CourseInfoDto courseInfoToDto(CourseInfo from){
        return new CourseInfoDto(from.getCourseDepartment(),
                from.getLectureCode(),
                from.getSection(),
                from.getName());
    }

    CourseReportDto courseReportToDto(CourseReport from){
        return new CourseReportDto(from.getReportStartDate(),
                from.getReportEndDate(),
                from.getNumberOfPositivePeople(),
                from.getNumberOfTests(),
                courseInfoToDto(from.getCourseInfo()),
                from.getPositiveStudents().stream().map(x -> studentToDto(x)).collect(Collectors.toList()));
    }

    CovidTestDto covidTestToDto(CovidTest from){
        return new CovidTestDto(from.getType(),
                from.getDate(),
                from.getResult(),
                from.getPatientId(),
                from.getVariant());
    }

    DormReportDto dormReportToDto(DormReport from){
        return new DormReportDto(from.getReportStartDate(),
                from.getReportEndDate(),
                from.getNumberOfPositivePeople(),
                from.getNumberOfTests(),
                from.getDormRoomInfo());
    }

    DormRoomInfoDto dormRoomInfoToDto(DormRoomInfo from){
        return new DormRoomInfoDto(from.getDormNo(),
                from.getFloor(),
                from.getLabel(),
                from.getRoomNo());
    }

    HesCodeDto hesCodeDtoToDto(HesCode from){
        return new HesCodeDto(from.getHesCode(),
                from.isApproved());
    }

    InstructorDto instructorToDto(Instructor from){
        return new InstructorDto(from.getUsername(),
                from.getName(),
                from.getSurname(),
                from.getEmail(),
                from.getBilkentId(),
                from.getCovidStatus(),
                abroadVaccineCardToDto(from.getAbroadVaccineCard()),
                baseVaccineCardToDto(from.getBaseVaccineCard()),
                from.getHesCodes().stream().map(x -> hesCodeDtoToDto(x)).collect(Collectors.toList()),
                from.getCourseInfos().stream().map(x -> courseInfoToDto(x)).collect(Collectors.toList()),
                from.getPastTestResults(),
                quarantineToDto(from.getQuarantine()),
                from.getCourses().stream().map(x -> instructorCourseToDto(x)).collect(Collectors.toList()));
    }

    LectureDto lectureToDto(Lecture from){
        return new LectureDto(from.getLectureHour(),
                from.getLectureDay(),
                from.getLectureHourEnd(),
                lectureCourseDto(from.getCourse()));
    }

    //lectureToDto lazim
    LectureReportDto lectureReportToDto(LectureReport from){
        return new LectureReportDto(from.getReportStartDate(),
                from.getReportEndDate(),
                from.getNumberOfPositivePeople(),
                from.getNumberOfTests(),
                from.isOnline(),
                from.isInstructorPositive(),
                lectureToDto(from.getLecture()));
    }

    QuarantineDto quarantineToDto(Quarantine from){
        return new QuarantineDto(from.getStartDate(),
                from.getRemainingDays());
    }

    StudentDto studentToDto(Student from){
        return new StudentDto(from.getUsername(),
                from.getName(),
                from.getSurname(),
                from.getPassword(),
                from.getEmail(),
                from.getBilkentId(),
                from.getCovidStatus(),
                abroadVaccineCardToDto(from.getAbroadVaccineCard()),
                baseVaccineCardToDto(from.getBaseVaccineCard()),
                from.getHesCodes().stream().map(x -> hesCodeDtoToDto(x)).collect(Collectors.toList()),
                from.getCourseInfos().stream().map(x -> courseInfoToDto(x)).collect(Collectors.toList()),
                from.getPastTestResults(),
                quarantineToDto(from.getQuarantine()),
                dormRoomInfoToDto(from.getDormRoomInfo()),
                from.getNearbyStudents().stream().map(x -> studentStudentToDto(x)).collect(Collectors.toList()));
    }

    UserDto userToDto(User from){
        return new UserDto(from.getUsername(),
                from.getName(),
                from.getSurname(),
                from.getEmail(),
                from.getPassword(),
                from.getBilkentId(),
                from.getCovidStatus(),
                abroadVaccineCardToDto(from.getAbroadVaccineCard()),
                baseVaccineCardToDto(from.getBaseVaccineCard()),
                from.getHesCodes().stream().map(x -> hesCodeDtoToDto(x)).collect(Collectors.toList()),
                from.getCourseInfos().stream().map(x -> courseInfoToDto(x)).collect(Collectors.toList()),
                from.getPastTestResults(),
                quarantineToDto(from.getQuarantine()));
    }

    CourseLectureDto courseLectureToDto(Lecture from){
        return new CourseLectureDto(from.getLectureHour(),
                from.getLectureDay(),
                from.getLectureHourEnd());
    }

    LectureCourseDto lectureCourseDto(Course from){
        return new LectureCourseDto(courseInfoToDto(from.getCourseInfo()),
                instructorToDto(from.getInstructor()),
                from.getStudents().stream().map(x -> studentToDto(x)).collect(Collectors.toList()));
    }

    StudentStudentDto studentStudentToDto(Student from){
        return new StudentStudentDto(from.getUsername(),
                from.getName(),
                from.getSurname(),
                from.getEmail(),
                from.getBilkentId(),
                from.getCovidStatus(),
                abroadVaccineCardToDto(from.getAbroadVaccineCard()),
                baseVaccineCardToDto(from.getBaseVaccineCard()),
                from.getHesCodes().stream().map(x -> hesCodeDtoToDto(x)).collect(Collectors.toList()),
                from.getCourseInfos().stream().map(x -> courseInfoToDto(x)).collect(Collectors.toList()),
                from.getPastTestResults(),
                quarantineToDto(from.getQuarantine()),
                dormRoomInfoToDto(from.getDormRoomInfo()));
    }

    CourseInstructorDto courseInstructorToDto(Instructor from){
        return new CourseInstructorDto(from.getUsername(),
                from.getName(),
                from.getSurname(),
                from.getEmail(),
                from.getBilkentId(),
                from.getCovidStatus(),
                abroadVaccineCardToDto(from.getAbroadVaccineCard()),
                baseVaccineCardToDto(from.getBaseVaccineCard()),
                from.getHesCodes().stream().map(x -> hesCodeDtoToDto(x)).collect(Collectors.toList()),
                from.getCourseInfos().stream().map(x -> courseInfoToDto(x)).collect(Collectors.toList()),
                from.getPastTestResults(),
                quarantineToDto(from.getQuarantine()));
    }

    InstructorCourseDto instructorCourseToDto(Course from){
        return new InstructorCourseDto(courseInfoToDto(from.getCourseInfo()),
                from.getLectures().stream().map(x -> courseLectureToDto(x)).collect(Collectors.toList()),
                from.getStudents().stream().map(x -> studentToDto(x)).collect(Collectors.toList()));
    }
}
