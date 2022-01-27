package com.api.bpm.model;

import com.api.bpm.model.enums.COVID_VACCINE;

import lombok.*;

import javax.persistence.MappedSuperclass;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class VaccineCard{
    private COVID_VACCINE vaccine;
    private boolean isApproved;
}