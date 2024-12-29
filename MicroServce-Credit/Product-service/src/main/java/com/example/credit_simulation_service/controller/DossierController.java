package com.example.credit_simulation_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.credit_simulation_service.dto.DossierDTO;
import com.example.credit_simulation_service.service.DossierService;

import java.util.List;

@RestController
@RequestMapping("/api/dossiers")
public class DossierController {

    private final DossierService dossierService;

    public DossierController(DossierService dossierService) {
        this.dossierService = dossierService;
    }

    @PostMapping
    public ResponseEntity<DossierDTO> createDossier(@RequestBody DossierDTO dossierDTO) {
        return ResponseEntity.ok(dossierService.createDossier(dossierDTO));
    }

    @GetMapping
    public ResponseEntity<List<DossierDTO>> getAllDossiers() {
        return ResponseEntity.ok(dossierService.getAllDossiers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DossierDTO> getDossierById(@PathVariable Long id) {
        return ResponseEntity.ok(dossierService.getDossierById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDossier(@PathVariable Long id) {
        dossierService.deleteDossier(id);
        return ResponseEntity.noContent().build();
    }
}
