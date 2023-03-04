package com.learnar.arservice.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "arimages")
public class ArImagesEntity {

    @Id
    private Integer id;

    private String name;

    private String uri;

    private String description;

    private String state;
}
