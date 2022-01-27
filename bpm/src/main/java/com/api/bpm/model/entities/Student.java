package com.api.bpm.model.entities;

import javax.persistence.*;

import lombok.*;
import lombok.Getter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student extends User {
    @OneToOne(targetEntity = DormRoomInfo.class, cascade = CascadeType.ALL )
    @JoinColumn(name = "dormRoomInfo_id", referencedColumnName = "id")
    private DormRoomInfo dormRoomInfo;

    @ManyToMany
    @JoinColumn( name = "nearby_student_id", referencedColumnName = "id" )
    private List<Student> nearbyStudents;
}
