package com.api.bpm.model.entities;

import com.api.bpm.model.Report;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class DormReport extends Report {

    @OneToOne
    @JoinColumn(name = "dormRoomInfo_id", referencedColumnName = "id")
    private DormRoomInfo dormRoomInfo;
}
