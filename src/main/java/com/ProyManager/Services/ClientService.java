package com.ProyManager.Services;

import com.ProyManager.Repository.ProjectsRepository;
import com.ProyManager.model.Projects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ProjectsRepository projectsRepository;


    public List<Projects> getAllProjects() {
        return projectsRepository.findAll();
    }


    public Optional<Projects> getProjectById(int projectId) {
        return projectsRepository.findById(projectId);
    }
}
