package com.springboot.api.react_api.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Embeddable
public class Company {

    private String name;
    @Column(name = "company_description", columnDefinition = "LONGTEXT")
    private String description;
    private String contactEmail;
    private String contactPhone;

    public Company() {
    }
}
