package com.example.credit_simulation_service.dto;

import lombok.Data;

@Data
public class DossierDTO {
    private Long id;
    private String clientReference;
    private double montantCredit;
    private Long referenceBareme;
    private double interet;
    private int dureeCredit;
    private double mensualite;
}
