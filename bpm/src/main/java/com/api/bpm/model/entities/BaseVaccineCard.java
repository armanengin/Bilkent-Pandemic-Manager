package com.api.bpm.model.entities;

import lombok.*;

import java.time.LocalDate;
import javax.persistence.*;

import com.api.bpm.model.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "BaseVaccineCard")
public class BaseVaccineCard extends VaccineCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    private LocalDate vaccinationDate;

    private String vaccinationCertificateNumber;

    @OneToOne
    @JoinColumn(name = "file_id", referencedColumnName = "id")
    private Files file;
}
