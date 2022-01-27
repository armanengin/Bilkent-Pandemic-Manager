package com.api.bpm.model.entities;

import com.api.bpm.model.Report;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class LectureReport extends Report {
    private boolean isOnline;

    private boolean isInstructorPositive;

    @OneToOne
    @JoinColumn(name = "lecture_id", referencedColumnName = "id")
    private Lecture lecture;
    
}
