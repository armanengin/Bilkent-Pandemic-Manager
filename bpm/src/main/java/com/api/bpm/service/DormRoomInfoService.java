package com.api.bpm.service;

import java.util.List;

import com.api.bpm.model.entities.DormRoomInfo;

public interface DormRoomInfoService {
    List<DormRoomInfo> getAllDormRoomInfo();
    DormRoomInfo createDormRoomInfo(DormRoomInfo covidTest);
    DormRoomInfo updateDormRoomInfo(long id, DormRoomInfo covidTest);
    public void deleteDormRoomInfo(long id);
    DormRoomInfo getDormRoomInfoById(long id);
}

