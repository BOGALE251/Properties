package com.example.propertymanagement.service;


import com.example.propertymanagement.entities.Property;
import com.example.propertymanagement.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyService {

    @Autowired
    PropertyRepository propertyRepository;

    public List<Property> getAllProperties(){
        return propertyRepository.findAll();
    }
}
