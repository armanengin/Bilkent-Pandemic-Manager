package com.api.bpm.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseLectureDto {
    private LocalTime lectureHour;
    private DayOfWeek lectureDay;
    private LocalTime lectureHourEnd;
}
