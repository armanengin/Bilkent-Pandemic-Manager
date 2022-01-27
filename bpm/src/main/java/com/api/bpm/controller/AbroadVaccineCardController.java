package com.api.bpm.controller;

import com.api.bpm.model.dto.AbroadVaccineCardDto;
import com.api.bpm.model.entities.AbroadVaccineCard;
import com.api.bpm.model.entities.Files;
import com.api.bpm.service.AbroadVaccineCardService;
import com.api.bpm.service.FileService;
import com.api.bpm.service.impl.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@SecurityRequirement(name = "BPM")
public class AbroadVaccineCardController {

    private final ModelMapper modelMapper;
    private final AbroadVaccineCardService abroadVaccineCardService;
    private final FileService fileService;

    @GetMapping("abroadVaccineCard/getAbroadVaccineCards")
    @PreAuthorize("hasRole('ADMIN')")
    public List<AbroadVaccineCardDto> getAllAbroadVaccineCards(){
        return abroadVaccineCardService.getAllAbroadVaccineCards().stream().map(abroadVaccineCard -> modelMapper.map(abroadVaccineCard,AbroadVaccineCardDto.class)).collect(Collectors.toList());
    }

    @PostMapping("abroadVaccineCard/createAbroadVaccineCard")
    @PreAuthorize("hasAnyRole('STUDENT','INSTRUCTOR')")
    public ResponseEntity<AbroadVaccineCardDto> createAbroadVaccineCard(@RequestBody AbroadVaccineCardDto abroadVaccineCardDto, @RequestParam ("file") MultipartFile file) throws IOException{
        Files newFile = fileService.store(file);//save file to database

        //Convert DTO to entity
        AbroadVaccineCard abroadVaccineCardRequest = modelMapper.map(abroadVaccineCardDto,AbroadVaccineCard.class);
        abroadVaccineCardRequest.setFile(newFile);
        AbroadVaccineCard abroadVaccineCard = abroadVaccineCardService.createAbroadVaccineCard(abroadVaccineCardRequest);

        //Convert entity to DTO
        AbroadVaccineCardDto abroadVaccineCardResponse = modelMapper.map(abroadVaccineCard,AbroadVaccineCardDto.class);
        return new ResponseEntity<AbroadVaccineCardDto>(abroadVaccineCardResponse, HttpStatus.CREATED);
    }

    @PutMapping("abroadVaccineCard/updateAbroadVaccineCard/{id}")
    @PreAuthorize("hasAnyRole('STUDENT','INSTRUCTOR')")
    public ResponseEntity<AbroadVaccineCardDto> updateAbroadVaccineCard(@PathVariable long id, @RequestBody AbroadVaccineCardDto abroadVaccineCardDto, @RequestParam ("file") MultipartFile file) throws IOException{
        Files newFile = fileService.store(file);//save file to database

        //Convert DTO to entity
        AbroadVaccineCard abroadVaccineCardRequest = modelMapper.map(abroadVaccineCardDto, AbroadVaccineCard.class);
        abroadVaccineCardRequest.setFile(newFile);
        AbroadVaccineCard abroadVaccineCard = abroadVaccineCardService.updateAbroadVaccineCard(id, abroadVaccineCardRequest);

        //Entity to DTO
        AbroadVaccineCardDto abroadVaccineCardResponse = modelMapper.map(abroadVaccineCard, AbroadVaccineCardDto.class);
        return ResponseEntity.ok().body(abroadVaccineCardResponse);
    }

    @DeleteMapping("abroadVaccineCard/{id}")
    @PreAuthorize("hasAnyRole('STUDENT','INSTRUCTOR','ADMIN')")
    public ResponseEntity<ApiResponse> deleteAbroadVaccineCard(@PathVariable(name = "id") Long id) {
        abroadVaccineCardService.deleteAbroadVaccineCard(id);
        ApiResponse apiResponse = new ApiResponse(Boolean.TRUE, "Abroad vaccine card deleted successfully", HttpStatus.OK);
        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("abroadVaccineCard/getHesCode/{id}")
    @PreAuthorize("hasAnyRole('STUDENT','INSTRUCTOR','ADMIN')")
    public ResponseEntity<AbroadVaccineCardDto> getAbroadVaccineCardById(@PathVariable(name ="id")Long id){
        AbroadVaccineCard abroadVaccineCard = abroadVaccineCardService.getAbroadVaccineCardById(id);

        //convert entity to dto
        AbroadVaccineCardDto abroadVaccineCardResponse = modelMapper.map(abroadVaccineCard, AbroadVaccineCardDto.class);
        return ResponseEntity.ok().body(abroadVaccineCardResponse);
    }
}
