package com.ProyManager.Controllers;

import com.ProyManager.Services.ClientService;
import com.ProyManager.Services.EditorService;
import com.ProyManager.model.Projects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Editor")
public class EditorController {
    @Autowired
    private EditorService EditorService;
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
    @PostMapping("/update")
    public ResponseEntity<Projects> saveOrUpdateProject(@RequestBody Projects project) {
        Projects savedProject = EditorService.saveOrUpdateProject(project);
        return ResponseEntity.ok(savedProject);
    }
}
