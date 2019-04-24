package com.memorynotfound.spring.security.web.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "dictionary")
public class Dictionary implements Serializable {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "word")
    private String word;

    @Column(name = "mean")
    private String mean;

    @Column(name = "type")
    private String type;
}
