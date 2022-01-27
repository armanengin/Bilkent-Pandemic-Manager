package com.api.bpm.controller;

import com.api.bpm.model.dto.BaseVaccineCardDto;
import com.api.bpm.model.entities.BaseVaccineCard;
import com.api.bpm.model.entities.Files;
import com.api.bpm.service.BaseVaccineCardService;
import com.api.bpm.service.FileService;
import com.api.bpm.service.impl.ApiResponse;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/baseVaccineCard")
@RequiredArgsConstructor
public class BaseVaccineCardController {

    private final ModelMapper modelMapper;


    private final BaseVaccineCardService baseVaccineCardService;
    private final FileService fileService;

    @GetMapping("/getBaseVaccineCard")
    @PreAuthorize("hasRole('ADMIN')")
    public List<BaseVaccineCardDto> getAllBaseVaccineCards(){
        return baseVaccineCardService.getAllBaseVaccineCards().stream().map(baseVaccineCard -> modelMapper.map(baseVaccineCard,BaseVaccineCardDto.class)).collect(Collectors.toList());
    }

    @PostMapping("/createBaseVaccineCard")
    @PreAuthorize("hasAnyRole('STUDENT','INSTRUCTOR')")
    public ResponseEntity<BaseVaccineCardDto> createBaseVaccineCard(@RequestBody BaseVaccineCardDto baseVaccineCardDto, @RequestParam ("file") MultipartFile file) throws IOException {
        Files newFile = fileService.store(file);//save file to database

        //Convert DTO to entity
        BaseVaccineCard baseVaccineCardRequest = modelMapper.map(baseVaccineCardDto,BaseVaccineCard.class);
        baseVaccineCardRequest.setFile(newFile);

        BaseVaccineCard baseVaccineCard = baseVaccineCardService.createBaseVaccineCard(baseVaccineCardRequest);

        //Convert entity to DTO
        BaseVaccineCardDto baseVaccineCardResponse = modelMapper.map(baseVaccineCard,BaseVaccineCardDto.class);
        return new ResponseEntity<BaseVaccineCardDto>(baseVaccineCardResponse, HttpStatus.CREATED);
    }

    @PutMapping("/updateBaseVaccineCard{id}")
    @PreAuthorize("hasAnyRole('STUDENT','INSTRUCTOR')")
    public ResponseEntity<BaseVaccineCardDto> updateBaseVaccineCard(@PathVariable long id, @RequestBody BaseVaccineCardDto baseVaccineCardDto){

        //Convert DTO to entity
        BaseVaccineCard baseVaccineCardRequest = modelMapper.map(baseVaccineCardDto, BaseVaccineCard.class);
        BaseVaccineCard baseVaccineCard = baseVaccineCardService.updateBaseVaccineCard(id, baseVaccineCardRequest);

        //Entity to DTO
        BaseVaccineCardDto baseVaccineCardResponse = modelMapper.map(baseVaccineCard, BaseVaccineCardDto.class);
        return ResponseEntity.ok().body(baseVaccineCardResponse);
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('STUDENT','INSTRUCTOR','ADMIN')")
    public ResponseEntity<ApiResponse> deleteBaseVaccineCard(@PathVariable(name = "id") Long id) {
        baseVaccineCardService.deleteBaseVaccineCard(id);
        ApiResponse apiResponse = new ApiResponse(Boolean.TRUE, "Abroad vaccine card deleted successfully", HttpStatus.OK);
        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/getHesCode/{id}")
    @PreAuthorize("hasAnyRole('STUDENT','INSTRUCTOR','ADMIN')")
    public ResponseEntity<BaseVaccineCardDto> getBaseVaccineCardById(@PathVariable(name ="id")Long id){
        BaseVaccineCard baseVaccineCard = baseVaccineCardService.getBaseVaccineCardById(id);

        //convert entity to dto
        BaseVaccineCardDto baseVaccineCardResponse = modelMapper.map(baseVaccineCard, BaseVaccineCardDto.class);
        return ResponseEntity.ok().body(baseVaccineCardResponse);
    }


}
