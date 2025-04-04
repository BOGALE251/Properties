package com.example.propertymanagement.controller;


import com.example.propertymanagement.converter.PropertyConverter;
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

    @GetMapping("/getall")
    public List<PropertyDTO> getProperty() {
        return  propertyService.getAllProperties()
                .stream()
                .map(PropertyConverter::mapToDTO)
                .toList();
    }

    @PostMapping("/add")
    public ResponseEntity<PropertyDTO> createProperty(@RequestBody PropertyDTO propertyDTO){
        Property property = PropertyConverter.mapToProperty(propertyDTO);
        Property p = propertyService.createProperty(property);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(p.getId()).toUri();
        return ResponseEntity.created(location).body(PropertyConverter.mapToDTO(p));
    }
}
