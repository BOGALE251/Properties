package com.example.propertymanagement.controller;

import com.example.propertymanagement.dto.PropertyDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PropertyControllerTest {


    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void getAllProperties(){
        List<PropertyDTO> propertyDTOList = List.of(restTemplate.getForObject("/api/v1/properties/getall", PropertyDTO[].class));
        assertEquals(0,propertyDTOList.size());
    }

    @Test
    void addProperty(){
        PropertyDTO propertyDTO = new PropertyDTO();
        propertyDTO.setPropertyName("propertyName");
        propertyDTO.setDescription("des");
        propertyDTO.setOwnerName("ownerName");
        propertyDTO.setPrice(500.0);

       URI propertyDTO1 = restTemplate.postForLocation("/api/v1/properties/add", propertyDTO);
       System.out.println(" URI is " +propertyDTO1);
    }

}