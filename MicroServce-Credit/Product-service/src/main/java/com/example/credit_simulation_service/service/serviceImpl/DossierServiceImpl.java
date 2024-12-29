package com.example.credit_simulation_service.service.serviceImpl;

import org.springframework.stereotype.Service;

import com.example.credit_simulation_service.dto.DossierDTO;
import com.example.credit_simulation_service.entity.Dossier;
import com.example.credit_simulation_service.mapper.impl.DossierMapper;
import com.example.credit_simulation_service.repository.DossierRepository;
import com.example.credit_simulation_service.service.DossierService;

import java.util.List;

@Service
public class DossierServiceImpl implements DossierService {

    private final DossierRepository dossierRepository;
    private final DossierMapper dossierMapper;

    public DossierServiceImpl(DossierRepository dossierRepository, DossierMapper dossierMapper) {
        this.dossierRepository = dossierRepository;
        this.dossierMapper = dossierMapper;
    }

    @Override
    public DossierDTO createDossier(DossierDTO dossierDTO) {
        validateDossierInput(dossierDTO);

        // Map DTO to Entity
        Dossier dossier = dossierMapper.toEntity(dossierDTO);

        // Calculate interest and mensualite
        double interest = dossier.getMontantCredit() * dossierDTO.getInteret();
        dossier.setInteret(interest);
        dossier.setMensualite((dossier.getMontantCredit() + interest) / dossier.getDureeCredit());

        // Save to repository
        Dossier savedDossier = dossierRepository.save(dossier);

        // Map Entity to DTO
        return dossierMapper.toDto(savedDossier);
    }

    @Override
    public List<DossierDTO> getAllDossiers() {
        List<Dossier> dossiers = dossierRepository.findAll();
        return dossierMapper.toDto(dossiers);
    }

    @Override
    public DossierDTO getDossierById(Long id) {
        Dossier dossier = dossierRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dossier not found with ID: " + id));
        return dossierMapper.toDto(dossier);
    }

    @Override
    public void deleteDossier(Long id) {
        if (!dossierRepository.existsById(id)) {
            throw new RuntimeException("Dossier not found with ID: " + id);
        }
        dossierRepository.deleteById(id);
    }

    private void validateDossierInput(DossierDTO dossierDTO) {
        if (dossierDTO.getMontantCredit() <= 0) {
            throw new IllegalArgumentException("Credit amount must be greater than zero.");
        }
        if (dossierDTO.getDureeCredit() <= 0) {
            throw new IllegalArgumentException("Credit duration must be greater than zero.");
        }
    }
}
