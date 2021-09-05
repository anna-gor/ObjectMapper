package com.mapper.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Step {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String timer;
    private String img;
    private int count;
    @Column(columnDefinition="varchar(2000)")
    private String description;

}
