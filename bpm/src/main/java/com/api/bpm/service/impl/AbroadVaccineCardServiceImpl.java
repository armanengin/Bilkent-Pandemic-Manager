package com.api.bpm.service.impl;

import java.util.List;
import java.util.Optional;

import com.api.bpm.model.entities.AbroadVaccineCard;
import com.api.bpm.repository.AbroadVaccineCardRepository;
import com.api.bpm.service.AbroadVaccineCardService;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AbroadVaccineCardServiceImpl implements AbroadVaccineCardService{

    private final AbroadVaccineCardRepository abroadVaccineCardRepository;

    @Override
    public List<AbroadVaccineCard> getAllAbroadVaccineCards() {
        return abroadVaccineCardRepository.findAll();
    }

    @Override
    public AbroadVaccineCard createAbroadVaccineCard(AbroadVaccineCard abroadVaccineCard) {
        return abroadVaccineCardRepository.save(abroadVaccineCard);
    }

    @Override
    public AbroadVaccineCard updateAbroadVaccineCard(long id, AbroadVaccineCard abroadVaccineCardRequest) {
        AbroadVaccineCard abroadVaccineCard = abroadVaccineCardRepository.findById(id).orElseThrow();
        abroadVaccineCard.setDate(abroadVaccineCardRequest.getDate());
        abroadVaccineCard.setCountry(abroadVaccineCard.getCountry());
        abroadVaccineCard.setFile(abroadVaccineCard.getFile());
        abroadVaccineCard.setVaccine(abroadVaccineCard.getVaccine());
        return abroadVaccineCardRepository.save(abroadVaccineCard);
    }

    @Override
    public void deleteAbroadVaccineCard(long id) {
        AbroadVaccineCard abroadVaccineCard = abroadVaccineCardRepository.findById(id).orElseThrow();
        abroadVaccineCardRepository.delete(abroadVaccineCard);
        
    }

    @Override
    public AbroadVaccineCard getAbroadVaccineCardById(long id) {
        Optional<AbroadVaccineCard> abroadVaccineCard = abroadVaccineCardRepository.findById(id);
        if(abroadVaccineCard.isPresent()) return abroadVaccineCard.get();
        return null;
    }
   
}