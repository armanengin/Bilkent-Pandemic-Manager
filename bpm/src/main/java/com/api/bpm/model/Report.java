package com.api.bpm.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDate reportStartDate;

    private LocalDate reportEndDate;

    private int numberOfPositivePeople;

    private int numberOfTests;


    
}
