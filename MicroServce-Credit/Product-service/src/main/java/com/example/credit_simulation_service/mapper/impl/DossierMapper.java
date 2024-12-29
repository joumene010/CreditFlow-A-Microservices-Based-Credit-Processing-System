package com.example.credit_simulation_service.mapper.impl;

import org.mapstruct.Mapper;

import com.example.credit_simulation_service.dto.DossierDTO;
import com.example.credit_simulation_service.entity.Dossier;
import com.example.credit_simulation_service.mapper.GenericMapper;

@Mapper(componentModel = "spring")
public interface DossierMapper extends GenericMapper<Dossier, DossierDTO> {

}
