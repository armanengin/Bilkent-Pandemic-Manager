package com.api.bpm.controller;

import com.api.bpm.model.entities.Files;
import com.api.bpm.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("file")
@RequiredArgsConstructor
public class FileController {
    private final FileService fileService;

    @PostMapping
    @PreAuthorize("hasAnyRole('STUDENT','INSTRUCTOR','ADMIN')")
    public Files uploadFile(@RequestParam ("file") MultipartFile file) throws IOException{
        return fileService.store(file);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('STUDENT','INSTRUCTOR','ADMIN')")
    public Files getFile(@PathVariable String id){
        return fileService.getFileById(id);
    }

    @GetMapping("/list")
    @PreAuthorize("hasAnyRole('STUDENT','INSTRUCTOR','ADMIN')")
    public List<Files> getFileList(){
        return fileService.getFilesList();
    }
}
