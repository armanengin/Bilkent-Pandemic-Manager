package com.api.bpm.service.impl;

import com.api.bpm.model.entities.HesCode;
import com.api.bpm.repository.HesCodeRepository;
import com.api.bpm.service.HesCodeService;
//import jdk.internal.loader.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HesCodeServiceImpl implements HesCodeService {
    @Autowired
    private HesCodeRepository hesCodeRepository;


    @Override
    public List<HesCode> getAllHesCodes() {
        return hesCodeRepository.findAll();
    }

    @Override
    public HesCode createHesCode(HesCode hesCode) {
        return hesCodeRepository.save(hesCode);
    }

    @Override
    public HesCode updateHesCode(long id, HesCode hesCodeRequest) {
        HesCode hesCode = hesCodeRepository.findById(id).orElseThrow();
        hesCode.setHesCode(hesCodeRequest.getHesCode());
        hesCode.setApproved(hesCodeRequest.isApproved());
        return hesCodeRepository.save(hesCode);
    }

    @Override
    public void deleteHesCode(long id) {
        HesCode hesCode = hesCodeRepository.findById(id).orElseThrow();
        hesCodeRepository.delete(hesCode);
    }

    @Override
    public HesCode getHesCodeById(long id) {
        Optional<HesCode> hesCode = hesCodeRepository.findById(id);
        if(hesCode.isPresent()) return hesCode.get();
        return null;
    }
}
