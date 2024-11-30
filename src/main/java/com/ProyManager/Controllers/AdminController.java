package com.ProyManager.Controllers;

import com.ProyManager.Services.AdminService;
import com.ProyManager.model.Projects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    private AdminService AdminService;

    // Crear o actualizar un proyecto
    @PostMapping("/update")
    public ResponseEntity<Projects> saveOrUpdateProject(@RequestBody Projects project) {
        Projects savedProject = AdminService.saveOrUpdateProject(project);
        return ResponseEntity.ok(savedProject);
    }

    // Obtener todos los proyectos
    @GetMapping("/see")
    public List<Projects> getAllProjects() {
        return AdminService.getAllProjects();
    }

    // Obtener un proyecto por ID
    @GetMapping("/see/{id}")
    public ResponseEntity<Projects> getProjectById(@PathVariable int id) {
        Optional<Projects> project = AdminService.getProjectById(id);
        return project.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Eliminar un proyecto por ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProjectById(@PathVariable int id) {
        AdminService.deleteProjectById(id);
        return ResponseEntity.noContent().build();
    }
}
