package com.api.bpm.model.entities;

import javax.persistence.*;
import javax.persistence.Table;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "Course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @OneToOne(targetEntity = CourseInfo.class, cascade = CascadeType.ALL )
    @JoinColumn(name = "courseInfo_id", referencedColumnName = "id")
    private CourseInfo courseInfo;

    @OneToMany(targetEntity = Lecture.class, orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Lecture> lectures;

    @ManyToOne(targetEntity = Instructor.class)
    @JoinColumn(name = "instructor_id", referencedColumnName = "id")
    private Instructor instructor;

    @ManyToMany(targetEntity = Instructor.class)
    private List<Student> students;
}