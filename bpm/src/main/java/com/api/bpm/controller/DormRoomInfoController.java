package com.api.bpm.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.api.bpm.model.dto.DormRoomInfoDto;
import com.api.bpm.model.entities.DormRoomInfo;
import com.api.bpm.service.DormRoomInfoService;
import com.api.bpm.service.impl.ApiResponse;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class DormRoomInfoController {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private DormRoomInfoService dormRoomInfoService;

    @GetMapping("/getDormRoomInfo")
    @PreAuthorize("hasRole('ADMIN,'STUDENT','INSTRUCTOR')")
    public List<DormRoomInfoDto> getAllDormRoomInfos(){
        return dormRoomInfoService.getAllDormRoomInfo().stream().map(dormRoomInfo -> modelMapper.map(dormRoomInfo,DormRoomInfoDto.class)).collect(Collectors.toList());
    }

    @PostMapping("/createDormInfo")
    @PreAuthorize("hasAnyRole('STUDENT','INSTRUCTOR')")
    public ResponseEntity<DormRoomInfoDto> createDormRoomInfo(@RequestBody DormRoomInfoDto dormRoomInfoDto){

        //Convert DTO to entity
        DormRoomInfo dormRoomInfoRequest = modelMapper.map(dormRoomInfoDto,DormRoomInfo.class);
        DormRoomInfo dormRoomInfo = dormRoomInfoService.createDormRoomInfo(dormRoomInfoRequest);

        //Convert entity to DTO
        DormRoomInfoDto dormRoomInfoResponse = modelMapper.map(dormRoomInfo,DormRoomInfoDto.class);
        return new ResponseEntity<DormRoomInfoDto>(dormRoomInfoResponse, HttpStatus.CREATED);
    }

    @PutMapping("/updateDormRoomInfo/{id}")
    @PreAuthorize("hasAnyRole('STUDENT','INSTRUCTOR')")
    public ResponseEntity<DormRoomInfoDto> updateDormRoomInfo(@PathVariable long id, @RequestBody DormRoomInfoDto dormRoomInfoDto){

        //Convert DTO to entity
        DormRoomInfo dormRoomInfoRequest = modelMapper.map(dormRoomInfoDto, DormRoomInfo.class);
        DormRoomInfo dormRoomInfo = dormRoomInfoService.updateDormRoomInfo(id, dormRoomInfoRequest);

        //Entity to DTO
        DormRoomInfoDto dormRoomInfoResponse = modelMapper.map(dormRoomInfo, DormRoomInfoDto.class);
        return ResponseEntity.ok().body(dormRoomInfoResponse);
    }
    
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<ApiResponse> deleteDormRoomInfo(@PathVariable(name = "id") Long id) {
        dormRoomInfoService.deleteDormRoomInfo(id);
        ApiResponse apiResponse = new ApiResponse(Boolean.TRUE, "Dorm room info deleted successfully", HttpStatus.OK);
        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/getDormRoomInfo/{id}")
    @PreAuthorize("hasAnyRole('STUDENT','INSTRUCTOR','ADMIN')")
    public ResponseEntity<DormRoomInfoDto> getDormRoomInfoById(@PathVariable(name ="id")Long id){
        DormRoomInfo dormRoomInfo = dormRoomInfoService.getDormRoomInfoById(id);

        //convert entity to dto
        DormRoomInfoDto dormRoomInfoResponse = modelMapper.map(dormRoomInfo, DormRoomInfoDto.class);
        return ResponseEntity.ok().body(dormRoomInfoResponse);
    }
}
