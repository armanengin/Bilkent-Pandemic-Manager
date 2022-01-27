package com.api.bpm.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HesCodeDto {
    private String hesCode;
    private boolean isApproved;
}
