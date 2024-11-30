package com.ProyManager.Controllers;
import com.ProyManager.Services.GetService;
import com.ProyManager.model.Invoices;
import com.ProyManager.model.Projects;
import com.ProyManager.model.Suppliers;
import com.ProyManager.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Api/projects")
public class GetController {
    @Autowired
    private GetService projectService;

    @GetMapping("/projects")
    public List<Projects> getAllProjects() {
        return projectService.getAllProjects();
    }

    @GetMapping("/suppliers")
    public List<Suppliers> getAllSuppliers() {
        return projectService.getAllSuppliers();
    }

    @GetMapping("/users")
    public List<Users> getAllUsers() {
        return projectService.getAllUsers();
    }

    @GetMapping("/invoices")
    public List<Invoices> getAllInvoices() {
        return projectService.getAllInvoices();
    }

    @GetMapping("/allEntities")
    public List<Object> getAllEntities() {
        return projectService.getAllEntities();
    }
}
