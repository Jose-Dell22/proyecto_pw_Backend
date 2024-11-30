package com.ProyManager.model;

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

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Projects project;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private List<Invoices> invoices;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private List<Payments> payments;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "client_roles",
            joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
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

}
