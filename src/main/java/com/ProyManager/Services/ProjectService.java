package com.ProyManager.Services;

import com.ProyManager.Repository.ClientRepository;
import com.ProyManager.Repository.ProjectsRepository;
import com.ProyManager.model.Client;
import com.ProyManager.model.Projects;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectsRepository projectRepository;
    private final ClientRepository clientRepository;

    public List<Projects> getAllProjects() {
        return projectRepository.findAllByOrderByProjectNameAsc();
    }

    public Projects getProjectById(Long id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found with id: " + id));
    }

    public List<Projects> getProjectsByUser() {
        // Obtener el usuario autenticado
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserEmail = authentication.getName();

        // Buscar el cliente por email
        Client client = clientRepository.findByEmail(currentUserEmail)
                .orElseThrow(() -> new RuntimeException("Client not found"));

        return projectRepository.findProjectsByClientId(client.getClient_id());
    }

    public Projects createProject(Projects project) {
        return projectRepository.save(project);
    }

    public Projects updateProject(Long id, Projects projectDetails) {
        Projects project = getProjectById(id);
        project.setProjectName(projectDetails.getProjectName());
        project.setDescription(projectDetails.getDescription());
        project.setPrice(projectDetails.getPrice());
        return projectRepository.save(project);
    }

    @Transactional
    public void deleteProject(Long id) {
        Projects project = getProjectById(id);

        // Eliminar las referencias en client_projects
        project.getClients().forEach(client -> client.getProjects().remove(project));

        projectRepository.delete(project);
    }

    public Projects addClientToProject(Long projectId, Long clientId) {
        Projects project = getProjectById(projectId);
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found"));

        client.getProjects().add(project);
        clientRepository.save(client);
        return project;
    }

    public Projects removeClientFromProject(Long projectId, Long clientId) {
        Projects project = getProjectById(projectId);
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found"));

        client.getProjects().remove(project);
        clientRepository.save(client);
        return project;
    }
}