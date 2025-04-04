package com.example.propertymanagement.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

    private Long id;

    @NotBlank(message = "name cannot be empty")
    private String name;

    @Email(message = "wrong email format")
    private String email;

}
