package com.example.propertymanagement.controller;


import com.example.propertymanagement.dto.PropertyDTO;
import com.example.propertymanagement.entities.Property;
import com.example.propertymanagement.repository.PropertyRepository;
import com.example.propertymanagement.service.PropertyService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController()
@RequestMapping("/api/v1/properties")
public class PropertyController {

    @Autowired
    PropertyService propertyService;

    private PropertyDTO mapToDTO(Property property){
        PropertyDTO propertyDTO = new PropertyDTO();
        BeanUtils.copyProperties(property,propertyDTO);
        return  propertyDTO;
    }

    private Property mapToProperty(PropertyDTO propertyDTO){
        Property property = new Property();
        BeanUtils.copyProperties(propertyDTO,property);
        return  property;
    }

    @GetMapping("/getall")
    public List<PropertyDTO> getProperty() {
        return  propertyService.getAllProperties()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    @PostMapping("/add")
    public ResponseEntity<PropertyDTO> createProperty(@RequestBody PropertyDTO propertyDTO){
        Property property = mapToProperty(propertyDTO);
        Property p = propertyService.createProperty(property);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(p.getId()).toUri();
        return ResponseEntity.created(location).body(mapToDTO(p));
    }
}
