package com.api.bpm.service.impl;

import java.util.List;
import java.util.Optional;

import com.api.bpm.model.entities.CovidTest;
import com.api.bpm.repository.CovidTestRepository;
import com.api.bpm.service.CovidTestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CovidTestServiceImpl implements CovidTestService{

    @Autowired
    private CovidTestRepository covidTestRepository;


    @Override
    public List<CovidTest> getAllCovidTests() {
        return covidTestRepository.findAll();
 
    }

    @Override
    public CovidTest createCovidTest(CovidTest covidTest) {
        return covidTestRepository.save(covidTest);
    }

    @Override
    public CovidTest updateCovidTest(long id, CovidTest covidTestRequest) {
        CovidTest covidTest = covidTestRepository.findById(id).orElseThrow();
        covidTest.setDate(covidTestRequest.getDate());
        covidTest.setResult(covidTestRequest.getResult());
        covidTest.setType(covidTestRequest.getType());
        covidTest.setVariant(covidTestRequest.getVariant());
        return covidTestRepository.save(covidTest);
    }

    @Override
    public void deleteCovidTestCode(long id) {
        CovidTest covidTest = covidTestRepository.findById(id).orElseThrow();
        covidTestRepository.delete(covidTest);        
    }

    @Override
    public CovidTest getCovidTestById(long id) {
        Optional<CovidTest> covidTest = covidTestRepository.findById(id);
        if(covidTest.isPresent()) return covidTest.get();
        return null;
    }
}