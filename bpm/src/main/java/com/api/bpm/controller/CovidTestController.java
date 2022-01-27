package com.api.bpm.controller;

import com.api.bpm.model.dto.CovidTestDto;
import com.api.bpm.model.entities.CovidTest;
import com.api.bpm.service.CovidTestService;
import com.api.bpm.service.impl.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/covidTest")
@SecurityRequirement(name = "BPM")
public class CovidTestController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CovidTestService covidTestService;

    @GetMapping("/getCovidTests")
    @PreAuthorize("hasAnyRole('ADMIN','STUDENT','INSTRUCTOR')")
    public List<CovidTestDto> getAllCovidTests(){
        return covidTestService.getAllCovidTests().stream().map(covidTest -> modelMapper.map(covidTest,CovidTestDto.class)).collect(Collectors.toList());
    }

    @PostMapping("/createCovidTest")
    @PreAuthorize("hasAnyRole('STUDENT','INSTRUCTOR')")
    public ResponseEntity<CovidTestDto> createCovidTest(@RequestBody CovidTestDto covidTestDto){

        //Convert DTO to entity
        CovidTest covidTestRequest = modelMapper.map(covidTestDto,CovidTest.class);
        CovidTest covidTest = covidTestService.createCovidTest(covidTestRequest);

        //Convert entity to DTO
        CovidTestDto covidTestResponse = modelMapper.map(covidTest,CovidTestDto.class);
        return new ResponseEntity<CovidTestDto>(covidTestResponse, HttpStatus.CREATED);
    }

    @PutMapping("/updateCovidTest/{id}")
    @PreAuthorize("hasAnyRole('STUDENT','INSTRUCTOR')")
    public ResponseEntity<CovidTestDto> updateCovidTest(@PathVariable long id, @RequestBody CovidTestDto covidTestDto){

        //Convert DTO to entity
        CovidTest covidTestRequest = modelMapper.map(covidTestDto, CovidTest.class);
        CovidTest covidTest = covidTestService.updateCovidTest(id, covidTestRequest);

        //Entity to DTO
        CovidTestDto covidTestResponse = modelMapper.map(covidTest, CovidTestDto.class);
        return ResponseEntity.ok().body(covidTestResponse);
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<ApiResponse> deleteCovidTest(@PathVariable(name = "id") Long id) {
        covidTestService.deleteCovidTestCode(id);
        ApiResponse apiResponse = new ApiResponse(Boolean.TRUE, "Covid Test deleted successfully", HttpStatus.OK);
        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/getCovidTest/{id}")
    @PreAuthorize("hasAnyRole('STUDENT','INSTRUCTOR','ADMIN')")
    public ResponseEntity<CovidTestDto> getCovidTestById(@PathVariable(name ="id")Long id){
        CovidTest covidTest = covidTestService.getCovidTestById(id);

        //convert entity to dto
        CovidTestDto covidTestResponse = modelMapper.map(covidTest, CovidTestDto.class);
        return ResponseEntity.ok().body(covidTestResponse);
    }
}
