package com.api.bpm.model.entities;

import com.api.bpm.model.enums.*;

import javax.persistence.*;

import java.time.LocalDateTime;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "CovidTest")
public class CovidTest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Enumerated(EnumType.STRING)
    private COVID_TEST_TYPE type;

    private LocalDateTime date;

    @Enumerated(EnumType.STRING)
    private COVID_TEST_RESULT result;

    private long patientId;

    @Enumerated(EnumType.STRING)
    private COVID19_VARIANT variant;
}
