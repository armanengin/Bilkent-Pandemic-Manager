package com.api.bpm.model.dto;

import com.api.bpm.model.enums.COVID_VACCINE;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseVaccineCardDto {
    private COVID_VACCINE vaccine;
    private LocalDate vaccinationDate;
    private String vaccinationCertificateNumber;
    private boolean isApproved;
}
