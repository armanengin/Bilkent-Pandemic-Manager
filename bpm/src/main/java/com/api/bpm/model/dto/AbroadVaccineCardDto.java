package com.api.bpm.model.dto;

import com.api.bpm.model.enums.COVID_VACCINE;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Transient;
import java.io.File;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AbroadVaccineCardDto {
    private LocalDate date;
    private String country;
    private COVID_VACCINE vaccine;
    private boolean isApproved;
}
