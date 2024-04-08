package com.ksi.tiakktiakk.model;

import lombok.*;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "facture")
public class Facture extends AbstractEntity {
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @Column(name = "reference")
    private String reference;

    @OneToOne(mappedBy = "facture")
    private CommandeClient commande;

    @OneToOne(mappedBy = "facture")
    private Payement paiement;

    @OneToOne(mappedBy = "facture")
    private Trajets trajet;


    @PrePersist
    public void generateReference() {
        // Générer une série de 10 chiffres
        String digits = String.valueOf((int) ((Math.random() * 900_000_000) + 100_000_000));

        // Définir la référence de facture avec le préfixe et les chiffres générés
        this.reference = "ref_facture_tt_" + digits;
    }

 }
