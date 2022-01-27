package com.api.bpm.service.impl;

import java.util.List;
import java.util.Optional;

import com.api.bpm.model.entities.DormRoomInfo;
import com.api.bpm.repository.DormRoomInfoRepository;
import com.api.bpm.service.DormRoomInfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DormRoomInfoServiceImpl implements DormRoomInfoService{

    @Autowired
    private DormRoomInfoRepository dormRoomInfoRepository;

    @Override
    public List<DormRoomInfo> getAllDormRoomInfo() {
        return dormRoomInfoRepository.findAll();
    }

    @Override
    public DormRoomInfo createDormRoomInfo(DormRoomInfo covidTest) {
        return dormRoomInfoRepository.save(covidTest);
    }

    @Override
    public DormRoomInfo updateDormRoomInfo(long id, DormRoomInfo covidTestRequest) {
        DormRoomInfo dormRoomInfo = dormRoomInfoRepository.findById(id).orElseThrow();
        dormRoomInfo.setDormNo(covidTestRequest.getDormNo());
        dormRoomInfo.setFloor(covidTestRequest.getFloor());
        dormRoomInfo.setLabel(covidTestRequest.getLabel());
        dormRoomInfo.setRoomNo(covidTestRequest.getRoomNo());
        return dormRoomInfoRepository.save(dormRoomInfo);
    }

    @Override
    public void deleteDormRoomInfo(long id) {
        DormRoomInfo dormRoomInfo = dormRoomInfoRepository.findById(id).orElseThrow();
        dormRoomInfoRepository.delete(dormRoomInfo);
        
    }

    @Override
    public DormRoomInfo getDormRoomInfoById(long id) {
        Optional<DormRoomInfo> dormRoomInfo = dormRoomInfoRepository.findById(id);
        if(dormRoomInfo.isPresent()) return dormRoomInfo.get();
        return null;
    }

}