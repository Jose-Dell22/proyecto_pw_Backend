package com.ProyManager.Services;

import com.ProyManager.Repository.ProjectsRepository;
import com.ProyManager.model.Projects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    private ProjectsRepository projectsRepository;

    // Crear o actualizar un proyecto
    public Projects saveOrUpdateProject(Projects project) {
        return projectsRepository.save(project);
    }

    // Obtener todos los proyectos
    public List<Projects> getAllProjects() {
        return projectsRepository.findAll();
    }

    // Obtener un proyecto por ID
    public Optional<Projects> getProjectById(int projectId) {
        return projectsRepository.findById(projectId);
    }

    // Eliminar un proyecto por ID
    public void deleteProjectById(int projectId) {
        projectsRepository.deleteById(projectId);
    }
}
