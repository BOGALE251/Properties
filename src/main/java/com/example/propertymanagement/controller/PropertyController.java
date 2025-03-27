package com.example.propertymanagement.controller;


import com.example.propertymanagement.dto.PropertyDTO;
import com.example.propertymanagement.entities.Property;
import com.example.propertymanagement.repository.PropertyRepository;
import com.example.propertymanagement.service.PropertyService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController()
public class PropertyController {

    @Autowired
    PropertyService propertyService;

    private PropertyDTO mapToDTO(Property property){
        PropertyDTO propertyDTO = new PropertyDTO();
        BeanUtils.copyProperties(property,propertyDTO);
        return  propertyDTO;
    }

    @GetMapping("/properties")
    public List<PropertyDTO> getProperty() {
        return  propertyService.getAllProperties()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }
}
