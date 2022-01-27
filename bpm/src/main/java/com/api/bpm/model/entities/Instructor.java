package com.api.bpm.model.entities;

import javax.persistence.*;
import lombok.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Instructor extends User {

    @OneToMany(mappedBy = "instructor")
    private List<Course> courses;
}
