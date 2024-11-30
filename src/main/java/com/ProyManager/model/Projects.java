package com.ProyManager.model;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "projects")
public class Projects {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int project_id;

    @Column(name = "project_name",nullable = false)
    private String project_name;
    @Column(name = "description",nullable = false)
    private String description;
    @Column(name = "price",nullable = false)
    private double price;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
    private List<Suppliers> suppliers;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
    private List<Client> clients;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
    private List<Invoices> invoices;

}
