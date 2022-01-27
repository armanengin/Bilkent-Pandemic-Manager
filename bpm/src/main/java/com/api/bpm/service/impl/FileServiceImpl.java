package com.api.bpm.service.impl;

import com.api.bpm.model.entities.Files;
import com.api.bpm.repository.FileRepository;
import com.api.bpm.service.FileService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class FileServiceImpl implements FileService {
    private final FileRepository fileRepository;

    public Files store(MultipartFile mulFile) throws IOException {
        String fileName = mulFile.getOriginalFilename();
        Files file = new Files(UUID.randomUUID().toString(), fileName, mulFile.getContentType(), mulFile.getBytes());
        return fileRepository.save(file);
    }

    public Files getFileById(String id){
        Optional<Files> fileOptional = fileRepository.findById(id);
        if(fileOptional.isPresent()) return fileOptional.get();
        return null;
    }

    public List<Files> getFilesList(){
        return fileRepository.findAll();
    }
}
