package com.api.bpm.service;

import java.util.List;

import com.api.bpm.model.entities.AbroadVaccineCard;

import org.springframework.stereotype.Service;

@Service
public interface AbroadVaccineCardService {
    List<AbroadVaccineCard> getAllAbroadVaccineCards();
    AbroadVaccineCard createAbroadVaccineCard(AbroadVaccineCard abroadVaccineCard);
    AbroadVaccineCard updateAbroadVaccineCard(long id, AbroadVaccineCard abroadVaccineCard);
    public void deleteAbroadVaccineCard(long id);
    AbroadVaccineCard getAbroadVaccineCardById(long id);
    
}
