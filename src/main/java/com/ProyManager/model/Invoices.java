package com.ProyManager.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
@Data
@Entity
@Table(name = "invoices")
public class Invoices {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int invoice_id;
    @Column(name = "invoice_date", nullable = false)
    private String invoice_date;
    @Column(name = "amount", nullable = true)
    private double amount;
    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Projects project;
    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "type_payment", nullable = false)
    private String type_payment;
}
