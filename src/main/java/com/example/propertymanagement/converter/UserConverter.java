package com.example.propertymanagement.converter;


import com.example.propertymanagement.dto.UserDTO;
import com.example.propertymanagement.entities.User;

public class UserConverter {

    public static UserDTO from(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setEmail(user.getEmail());
        userDTO.setName(user.getName());
        return userDTO;
    }

    public static User from(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        return user;
    }
}
