package com.ksi.tiakktiakk.dtos;

import com.ksi.tiakktiakk.model.Payement;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
@Builder
public class PayementDto {
    private Long id;
    private String reference;
    private BigDecimal montant;
    private LocalDateTime datePaiement;
    private String methode;
    private String statut;

    public static PayementDto fromEntity(Payement payement) {
        if (payement == null) {
            return null;
        }

        return PayementDto.builder()
                .id(payement.getId())
                .reference(payement.getReference())
                .montant(payement.getMontant())
                .datePaiement(payement.getDatePaiement())
                .methode(payement.getMethode())
                .statut(payement.getStatut())
                .build();
    }

    public static Payement toEntity(PayementDto payementDto) {
        if (payementDto == null) {
            return null;
        }

        Payement payement = new Payement();
        payement.setId(payementDto.getId());
        payement.setReference(payementDto.getReference());
        payement.setMontant(payementDto.getMontant());
        payement.setDatePaiement(payementDto.getDatePaiement());
        payement.setMethode(payementDto.getMethode());
        payement.setStatut(payementDto.getStatut());
        return payement;
    }
}
