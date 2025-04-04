package com.example.propertymanagement.service;

import com.example.propertymanagement.converter.UserConverter;
import com.example.propertymanagement.dto.UserDTO;
import com.example.propertymanagement.entities.User;
import com.example.propertymanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDTO registerUser(UserDTO user){
       User savedUser =  userRepository.save(UserConverter.from(user));
       return UserConverter.from(savedUser);
    }

    public UserDTO loginUser(UserDTO user){
         User u =  UserConverter.from(user);
         Optional<User> optionalUser  = userRepository.findById(u.getId());
         if(optionalUser.isPresent()){
             return UserConverter.from(optionalUser.get());
         }
         throw new RuntimeException("User not found");
    }
}
