package com.ProyManager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

// LoginResponseDTO.java
@Data
@AllArgsConstructor
public class LoginResponseDTO {
    private String email;
    private String role;
}
