package com.example.credit_simulation_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.credit_simulation_service.entity.Dossier;

public interface DossierRepository extends JpaRepository<Dossier, Long> {
}
