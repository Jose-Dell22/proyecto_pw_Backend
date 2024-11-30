package com.ProyManager.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Data
@Entity
@Table(name = "suppliers")
public class Suppliers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int supplier_id;
    @Column(name = "supplier_name",nullable = false)
    private String supplier_name;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Projects project;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplier")
    private List<Payments> payments;

}
