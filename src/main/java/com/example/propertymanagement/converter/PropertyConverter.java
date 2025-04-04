package com.example.propertymanagement.converter;


import com.example.propertymanagement.dto.PropertyDTO;
import com.example.propertymanagement.entities.Property;
import org.springframework.beans.BeanUtils;

public class PropertyConverter {

    public static PropertyDTO mapToDTO(Property property){
        PropertyDTO propertyDTO = new PropertyDTO();
        BeanUtils.copyProperties(property,propertyDTO);
        return  propertyDTO;
    }

    public static Property mapToProperty(PropertyDTO propertyDTO){
        Property property = new Property();
        BeanUtils.copyProperties(propertyDTO,property);
        return  property;
    }
}
