package com.ProyManager.Controllers;

import com.ProyManager.Services.ClientService;
import com.ProyManager.model.Projects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Client")
public class ClientController {
    @Autowired
    private ClientService ClientService;

    @GetMapping("/see")
    public List<Projects> getAllProjects() {
        return ClientService.getAllProjects();
    }


    @GetMapping("/see/{id}")
    public ResponseEntity<Projects> getProjectById(@PathVariable int id) {
        Optional<Projects> project = ClientService.getProjectById(id);
        return project.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
