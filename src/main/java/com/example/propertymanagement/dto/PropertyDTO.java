package com.example.propertymanagement.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PropertyDTO {

    private String propertyName;
    private String description;
    private Double price;
    private String ownerName;
}
