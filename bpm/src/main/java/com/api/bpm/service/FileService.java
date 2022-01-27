package com.api.bpm.service;

import com.api.bpm.model.entities.Files;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public interface FileService {
    Files store(MultipartFile file) throws IOException;
    Files getFileById(String id);
    List<Files> getFilesList();
}
