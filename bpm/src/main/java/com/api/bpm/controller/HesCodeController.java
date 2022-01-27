package com.api.bpm.controller;

import com.api.bpm.model.dto.HesCodeDto;
import com.api.bpm.model.entities.HesCode;
import com.api.bpm.service.HesCodeService;
import com.api.bpm.service.impl.ApiResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/hesCode")
public class HesCodeController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private HesCodeService hesCodeService;

    @GetMapping("/getHesCodes")
    @PreAuthorize("hasAnyRole('STUDENT','INSTRUCTOR', 'ADMIN')")
    public List<HesCodeDto> getAllHesCodes(){
        return hesCodeService.getAllHesCodes().stream().map(hesCode -> modelMapper.map(hesCode,HesCodeDto.class)).collect(Collectors.toList());
    }

    @PostMapping("/createHesCode")
    @PreAuthorize("hasAnyRole('STUDENT','INSTRUCTOR')")
    public ResponseEntity<HesCodeDto> createHesCode(@RequestBody HesCodeDto hesCodeDto){

        //Convert DTO to entity
        HesCode hesCodeRequest = modelMapper.map(hesCodeDto,HesCode.class);
        HesCode hesCode = hesCodeService.createHesCode(hesCodeRequest);

        //Convert entity to DTO
        HesCodeDto hesCodeResponse = modelMapper.map(hesCode,HesCodeDto.class);
        return new ResponseEntity<HesCodeDto>(hesCodeResponse, HttpStatus.CREATED);
    }

    @PutMapping("/updateHesCode/{id}")
    @PreAuthorize("hasAnyRole('STUDENT','INSTRUCTOR')")
    public ResponseEntity<HesCodeDto> updateHesCode(@PathVariable long id, @RequestBody HesCodeDto hesCodeDto){

        //Convert DTO to entity
        HesCode hesCodeRequest = modelMapper.map(hesCodeDto, HesCode.class);
        HesCode hesCode = hesCodeService.updateHesCode(id, hesCodeRequest);

        //Entity to DTO
        HesCodeDto hesCodeResponse = modelMapper.map(hesCode, HesCodeDto.class);
        return ResponseEntity.ok().body(hesCodeResponse);
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('STUDENT','INSTRUCTOR','ADMIN')")
    public ResponseEntity<ApiResponse> deleteHesCode(@PathVariable(name = "id") Long id) {
        hesCodeService.deleteHesCode(id);
        ApiResponse apiResponse = new ApiResponse(Boolean.TRUE, "Post deleted successfully", HttpStatus.OK);
        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/getHesCode/{id}")
    @PreAuthorize("hasAnyRole('STUDENT','INSTRUCTOR','ADMIN')")
    public ResponseEntity<HesCodeDto> getHesCodeById(@PathVariable(name ="id")Long id){
        HesCode hesCode = hesCodeService.getHesCodeById(id);

        //convert entity to dto
        HesCodeDto hesCodeResponse = modelMapper.map(hesCode, HesCodeDto.class);
        return ResponseEntity.ok().body(hesCodeResponse);
    }
}
