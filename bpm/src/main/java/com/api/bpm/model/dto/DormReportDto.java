package com.api.bpm.model.dto;

import com.api.bpm.model.entities.DormRoomInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DormReportDto {
    private LocalDate reportStartDate;
    private LocalDate reportEndDate;
    private int numberOfPositivePeople;
    private int numberOfTests;
    private DormRoomInfo dormRoomInfo;
}
