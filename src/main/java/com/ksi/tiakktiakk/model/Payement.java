package com.ksi.tiakktiakk.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "payement")
public class Payement extends AbstractEntity{

    @Column(name = "reference")
    private String reference;

    @Column(name = "montant")
    private BigDecimal montant;

    @Column(name = "date_paiement")
    private LocalDateTime datePaiement;

    @Column(name = "methode")
    private String methode;

    @Column(name = "statut")
    private String statut;

    @OneToOne
    @JoinColumn(name = "facture_id")
    private Facture facture;


    @PrePersist
    public void generateReference() {
        // Générer une série de 10 chiffres
        String digits = String.valueOf((int) ((Math.random() * 900_000_000) + 100_000_000));

        // Définir la référence de facture avec le préfixe et les chiffres générés
        this.reference = "ref_paiement_tt_" + digits;
    }

}
