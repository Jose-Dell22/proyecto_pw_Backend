package com.ProyManager.Controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @GetMapping("/all")
    public String allAccess() {
        return "Contenido Público";
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER')")
    public String userAccess() {
        return "Contenido de Usuario";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "Contenido de Admin";
    }
}