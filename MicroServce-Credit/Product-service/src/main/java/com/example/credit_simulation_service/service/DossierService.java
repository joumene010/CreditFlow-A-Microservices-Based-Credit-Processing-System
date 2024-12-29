package com.example.credit_simulation_service.service;

import java.util.List;

import com.example.credit_simulation_service.dto.DossierDTO;

public interface DossierService {
    DossierDTO createDossier(DossierDTO dossierDTO);

    DossierDTO getDossierById(Long id);

    void deleteDossier(Long id);

    List<DossierDTO> getAllDossiers();
}
