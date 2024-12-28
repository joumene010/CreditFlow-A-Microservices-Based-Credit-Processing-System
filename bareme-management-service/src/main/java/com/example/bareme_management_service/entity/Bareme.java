package com.example.bareme_management_service.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bareme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private double tauxNominal;

    @Column(nullable = false)
    private int dureeMinimale;

    @Column(nullable = false)
    private int dureeMaximale;

    @Column(nullable = false)
    private double montantMinimal;

    @Column(nullable = false)
    private double montantMaximal;
}
