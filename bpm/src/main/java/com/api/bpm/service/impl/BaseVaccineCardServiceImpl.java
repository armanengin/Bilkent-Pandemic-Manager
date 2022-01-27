package com.api.bpm.service.impl;

import com.api.bpm.model.entities.BaseVaccineCard;
import com.api.bpm.repository.BaseVaccineCardRepository;
import com.api.bpm.service.BaseVaccineCardService;
//import jdk.internal.loader.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BaseVaccineCardServiceImpl implements BaseVaccineCardService {
    @Autowired
    private BaseVaccineCardRepository baseVaccineCardRepository; 

    @Override
    public List<BaseVaccineCard> getAllBaseVaccineCards() {
       return baseVaccineCardRepository.findAll();
    }

    @Override
    public BaseVaccineCard createBaseVaccineCard(BaseVaccineCard baseVaccineCard) {
        return baseVaccineCardRepository.save(baseVaccineCard);
    }

    @Override
    public BaseVaccineCard updateBaseVaccineCard(long id, BaseVaccineCard baseVaccineCardRequest) {
        BaseVaccineCard baseVaccineCard = baseVaccineCardRepository.findById(id).orElseThrow();
        baseVaccineCard.setVaccinationDate(baseVaccineCardRequest.getVaccinationDate());
        baseVaccineCard.setVaccine(baseVaccineCard.getVaccine());
        return baseVaccineCardRepository.save(baseVaccineCard);
    }

    @Override
    public void deleteBaseVaccineCard(long id) {
        BaseVaccineCard baseVaccineCard = baseVaccineCardRepository.findById(id).orElseThrow();
        baseVaccineCardRepository.delete(baseVaccineCard);
    }

    @Override
    public BaseVaccineCard getBaseVaccineCardById(long id) {
        Optional<BaseVaccineCard> baseVaccineCard = baseVaccineCardRepository.findById(id);
        if(baseVaccineCard.isPresent()) return baseVaccineCard.get();
        return null;
    }
   
}
