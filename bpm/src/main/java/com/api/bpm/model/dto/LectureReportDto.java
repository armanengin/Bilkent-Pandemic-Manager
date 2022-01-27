package com.api.bpm.model.dto;

import com.api.bpm.model.entities.Lecture;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LectureReportDto {
    private LocalDate reportStartDate;
    private LocalDate reportEndDate;
    private int numberOfPositivePeople;
    private int numberOfTests;
    private boolean isOnline;
    private boolean isInstructorPositive;
    private LectureDto lecture;
}
