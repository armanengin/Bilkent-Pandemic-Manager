package com.api.bpm.service;

import com.api.bpm.model.entities.HesCode;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HesCodeService {
    List<HesCode> getAllHesCodes();
    HesCode createHesCode(HesCode hesCode);
    HesCode updateHesCode(long id, HesCode hescode);
    public void deleteHesCode(long id);
    HesCode getHesCodeById(long id);
}
