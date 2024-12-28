package com.example.bareme_management_service.mapper.impl;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import com.example.bareme_management_service.dto.BaremeDto;
import com.example.bareme_management_service.entity.Bareme;
import com.example.bareme_management_service.mapper.GenericMapper;

@Component
@Mapper(componentModel = "spring")
public interface BaremeMapper extends GenericMapper<Bareme, BaremeDto> {
}
