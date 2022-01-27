package com.api.bpm.repository;

import com.api.bpm.model.entities.Files;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<Files, String> {
}
