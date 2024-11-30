package com.ProyManager.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
@Data
@Entity
@Table(name = "payments")
public class Payments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int payment_id;

    @Column(name = "payment_date", nullable = false)
    private LocalDate payment_date;
    @Column(name = "amount", nullable = true)
    private double amount;
    @Column(name = "payment_type",nullable = false)
    private String payment_type;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Users client;

    @ManyToOne
    @JoinColumn(name = "supplier_id", nullable = false)
    private Suppliers supplier;

}
