package com.example.bareme_management_service.service;

import com.example.bareme_management_service.dto.BaremeDto;
import org.springframework.data.domain.Page;

public interface BaremeService {
    BaremeDto addBareme(BaremeDto baremeDto);

    Page<BaremeDto> getAllBaremes(int page, int size);

    BaremeDto getBaremeById(Long id);

    BaremeDto updateBareme(BaremeDto baremeDto);

    void deleteBareme(Long id);

    BaremeDto findOptimalBareme(int duree, double montant);
}
