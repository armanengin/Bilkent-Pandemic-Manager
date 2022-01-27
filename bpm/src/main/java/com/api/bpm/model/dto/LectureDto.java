package com.api.bpm.model.dto;

import com.api.bpm.model.entities.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;
import java.time.DayOfWeek;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LectureDto {
    private LocalTime lectureHour;
    private DayOfWeek lectureDay;
    private LocalTime lectureHourEnd;
    private LectureCourseDto course;
}
