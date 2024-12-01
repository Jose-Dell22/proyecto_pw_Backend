package com.ProyManager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.apache.catalina.User;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long client_id;

    @Column(name = "client_name", nullable = false)
    private String client_name;

    @Column(unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @ManyToMany
    @JoinTable(
            name = "client_projects",
            joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id")
    )
    private Set<Projects> projects = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "client_roles",
            joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    @JsonIgnore
    private Set<Role> roles = new HashSet<>();

    // Métodos helper para gestionar roles
    public void addRole(Role role) {
        this.roles.add(role);
        role.getClients().add(this);
    }

    public void removeRole(Role role) {
        this.roles.remove(role);
        role.getClients().remove(this);
    }

    public void addProject(Projects project) {
        this.projects.add(project);
        project.getClients().add(this);
    }

    public void removeProject(Projects project) {
        this.projects.remove(project);
        project.getClients().remove(this);
    }

}
