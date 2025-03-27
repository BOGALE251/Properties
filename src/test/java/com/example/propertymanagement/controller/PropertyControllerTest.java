package com.example.propertymanagement.controller;

import com.example.propertymanagement.dto.PropertyDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PropertyControllerTest {


    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void getAllProperties(){

        List<PropertyDTO> propertyDTOList = List.of(restTemplate.getForObject("/properties", PropertyDTO[].class));
        assertEquals(0,propertyDTOList.size());
    }

}