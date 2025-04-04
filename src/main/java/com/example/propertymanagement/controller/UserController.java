package com.example.propertymanagement.controller;


import com.example.propertymanagement.dto.UserDTO;
import com.example.propertymanagement.entities.User;
import com.example.propertymanagement.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {


    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDTO> register(@Valid @RequestBody UserDTO userDTO) {
        UserDTO userDTO1 = userService.registerUser(userDTO);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userDTO1.getId()).toUri();
        return ResponseEntity.created(location).body(userDTO1);
    }
}
