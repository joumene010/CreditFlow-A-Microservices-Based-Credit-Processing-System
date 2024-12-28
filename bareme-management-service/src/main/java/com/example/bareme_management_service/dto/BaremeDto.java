package com.example.bareme_management_service.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaremeDto {
    private Long id;
    private double tauxNominal;
    private int dureeMinimale;
    private int dureeMaximale;
    private double montantMinimal;
    private double montantMaximal;

}
