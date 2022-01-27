package com.api.bpm.model.entities;

import javax.persistence.*;

import com.api.bpm.model.enums.*;

import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Getter(value=AccessLevel.NONE)
    private long id;

    @Enumerated(EnumType.STRING)
    private DEPARTMENT courseDepartment;

    @Enumerated(EnumType.STRING)
    private LECTURE_CODE lectureCode;

    private int section;

    private String name;
    
}
