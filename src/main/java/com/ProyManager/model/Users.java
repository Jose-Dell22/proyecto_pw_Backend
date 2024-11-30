package com.ProyManager.model;

import jakarta.persistence.*;
import lombok.Data;
import org.apache.catalina.User;

import java.util.List;
@Data
@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int client_id;
    @Column(name = "client_name",nullable = false)
    private String client_name;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Projects project;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private List<Invoices> invoices;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private List<Payments> payments;

}
