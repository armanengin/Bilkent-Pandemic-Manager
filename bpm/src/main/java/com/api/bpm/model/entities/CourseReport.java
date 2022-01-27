package com.api.bpm.model.entities;

import com.api.bpm.model.Report;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CourseReport extends Report {

    @OneToOne
    @JoinColumn(name = "courseInfo_id", referencedColumnName = "id")
    private CourseInfo courseInfo;

    @OneToMany
    private List<Student> positiveStudents;
}
