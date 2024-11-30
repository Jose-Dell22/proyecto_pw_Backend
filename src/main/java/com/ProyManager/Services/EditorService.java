package com.ProyManager.Services;

import com.ProyManager.Repository.ProjectsRepository;
import com.ProyManager.model.Projects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditorService {
    @Autowired
    private ProjectsRepository projectsRepository;

    public Projects saveOrUpdateProject(Projects project) {
        // Guardar o actualizar el proyecto, dependiendo de si tiene ID o no.
        return projectsRepository.save(project);
    }
}
