package com.springboot.api.react_api.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String title;
    private String type;
    @Column(columnDefinition="LONGTEXT")
    private String description;
    private String location;
    private String salary;

    @Embedded
    private Company company;

    public Job() {
    }
}
