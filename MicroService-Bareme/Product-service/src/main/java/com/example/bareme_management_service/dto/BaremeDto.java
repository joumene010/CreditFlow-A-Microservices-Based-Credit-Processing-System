package com.example.bareme_management_service.dto;

import lombok.*;

@NoArgsConstructor
@Data
public class BaremeDto {
    private Long id;
    private double tauxNominal;
    private int dureeMinimale;
    private int dureeMaximale;
    private double montantMinimal;
    private double montantMaximal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
