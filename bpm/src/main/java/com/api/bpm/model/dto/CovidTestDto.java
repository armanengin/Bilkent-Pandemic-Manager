package com.api.bpm.model.dto;

import com.api.bpm.model.enums.COVID19_VARIANT;
import com.api.bpm.model.enums.COVID_TEST_RESULT;
import com.api.bpm.model.enums.COVID_TEST_TYPE;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CovidTestDto {
    private COVID_TEST_TYPE type;
    private LocalDateTime date;
    private COVID_TEST_RESULT result;
    private long patientId;
    private COVID19_VARIANT variant;
}
