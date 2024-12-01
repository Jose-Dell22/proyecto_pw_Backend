package com.ProyManager.Services;

import com.ProyManager.Repository.ProjectsRepository;
import com.ProyManager.model.Client;
import com.ProyManager.model.Projects;
import com.ProyManager.model.Role;
import com.ProyManager.Repository.ClientRepository;
import com.ProyManager.Repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final ClientRepository clientRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final ProjectsRepository projectsRepository;

    public Client registerClient(String name, String email, String password, String role, List<Long> projectIds) {
        if (clientRepository.existsByEmail(email)) {
            throw new RuntimeException("Email is already in use!");
        }

        Client client = new Client();
        client.setClient_name(name);
        client.setEmail(email);
        client.setPassword(passwordEncoder.encode(password));

        Role userRole = roleRepository.findByName(role)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        client.getRoles().add(userRole);

        List<Projects> projects = projectsRepository.findAllById(projectIds);
        client.getProjects().addAll(projects);

        return clientRepository.save(client);
    }
}