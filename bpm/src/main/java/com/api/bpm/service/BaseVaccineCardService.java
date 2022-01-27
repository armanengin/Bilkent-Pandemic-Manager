package com.api.bpm.service;

import java.util.List;

import com.api.bpm.model.entities.BaseVaccineCard;

import org.springframework.stereotype.Service;


@Service
public interface BaseVaccineCardService {
    List<BaseVaccineCard> getAllBaseVaccineCards();
    BaseVaccineCard createBaseVaccineCard(BaseVaccineCard baseVaccineCard);
    BaseVaccineCard updateBaseVaccineCard(long id, BaseVaccineCard baseVaccineCard);
    public void deleteBaseVaccineCard(long id);
    BaseVaccineCard getBaseVaccineCardById(long id);
}
