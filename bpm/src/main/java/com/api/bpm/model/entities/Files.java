package com.api.bpm.model.entities;

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
public class Files {
    @Id
    private String id;
    private String name;
    private String type;
    @Lob
    private byte[] data;

}
