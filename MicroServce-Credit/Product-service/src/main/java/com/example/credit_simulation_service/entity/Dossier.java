package com.example.credit_simulation_service.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "dossiers")
public class Dossier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String clientReference;

    @Column(nullable = false)
    private double montantCredit;

    @Column(nullable = false)
    private Long referenceBareme;

    @Column(nullable = false)
    private double interet;

    @Column(nullable = false)
    private int dureeCredit;

    @Column(nullable = false)
    private double mensualite;
}
