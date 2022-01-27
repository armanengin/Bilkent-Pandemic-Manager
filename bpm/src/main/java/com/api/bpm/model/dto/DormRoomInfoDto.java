package com.api.bpm.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DormRoomInfoDto {
    private int dormNo;
    private int floor;
    private char label;
    private int roomNo;
}
