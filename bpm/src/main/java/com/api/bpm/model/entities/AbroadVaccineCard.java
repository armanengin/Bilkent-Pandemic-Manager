package com.api.bpm.model.entities;

import java.time.LocalDate;

import javax.persistence.*;

import com.api.bpm.model.VaccineCard;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "AbroadVaccineCard")
public class AbroadVaccineCard extends VaccineCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    private LocalDate date;

    private String country;

    @OneToOne
    @JoinColumn(name = "file_id", referencedColumnName = "id")
    private Files file;

    
}
