package com.api.bpm.service;

import com.api.bpm.model.entities.CovidTest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CovidTestService {
    List<CovidTest> getAllCovidTests();
    CovidTest createCovidTest(CovidTest covidTest);
    CovidTest updateCovidTest(long id, CovidTest covidTest);
    public void deleteCovidTestCode(long id);
    CovidTest getCovidTestById(long id);
}
