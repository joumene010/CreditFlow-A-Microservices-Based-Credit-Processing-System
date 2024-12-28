package com.example.bareme_management_service.service.serviceImpl;

import com.example.bareme_management_service.dto.BaremeDto;
import com.example.bareme_management_service.entity.Bareme;
import com.example.bareme_management_service.repository.BaremeRepository;
import com.example.bareme_management_service.service.BaremeService;
import com.example.bareme_management_service.mapper.impl.BaremeMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Component
@Service
public class BaremeServiceImpl implements BaremeService {
    @Autowired
    private final BaremeRepository baremeRepository;

    @Autowired
    private final BaremeMapper baremeMapper;

    public BaremeServiceImpl(BaremeRepository baremeRepository, BaremeMapper baremeMapper) {
        this.baremeRepository = baremeRepository;
        this.baremeMapper = baremeMapper;
    }

    @Override
    public BaremeDto addBareme(BaremeDto baremeDto) {
        Bareme entity = baremeMapper.toEntity(baremeDto);
        Bareme savedEntity = baremeRepository.save(entity);
        return baremeMapper.toDto(savedEntity);
    }

    @Override
    public Page<BaremeDto> getAllBaremes(int page, int size) {
        Page<Bareme> baremes = baremeRepository.findAll(PageRequest.of(page, size));
        List<BaremeDto> dtos = baremeMapper.toDto(baremes.getContent());
        return new PageImpl<>(dtos, baremes.getPageable(), baremes.getTotalElements());
    }

    @Override
    public BaremeDto getBaremeById(Long id) {
        Bareme entity = baremeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Barème not found with ID: " + id));
        return baremeMapper.toDto(entity);
    }

    @Override
    public BaremeDto updateBareme(BaremeDto baremeDto) {
        if (!baremeRepository.existsById(baremeDto.getId())) {
            throw new RuntimeException("Barème not found with ID: " + baremeDto.getId());
        }
        Bareme entity = baremeMapper.toEntity(baremeDto);
        Bareme updatedEntity = baremeRepository.save(entity);
        return baremeMapper.toDto(updatedEntity);
    }

    @Override
    public void deleteBareme(Long id) {
        if (!baremeRepository.existsById(id)) {
            throw new RuntimeException("Barème not found with ID: " + id);
        }
        baremeRepository.deleteById(id);
    }

    @Override
    public BaremeDto findOptimalBareme(int duree, double montant) {
        List<Bareme> applicableBaremes = baremeRepository
                .findByDureeMinimaleLessThanEqualAndDureeMaximaleGreaterThanEqualAndMontantMinimalLessThanEqualAndMontantMaximalGreaterThanEqual(
                        duree, duree, montant, montant);
        Bareme optimalBareme = applicableBaremes.stream()
                .min(Comparator.comparingDouble(Bareme::getTauxNominal))
                .orElseThrow(() -> new RuntimeException("No suitable barème found."));
        return baremeMapper.toDto(optimalBareme);
    }
}
