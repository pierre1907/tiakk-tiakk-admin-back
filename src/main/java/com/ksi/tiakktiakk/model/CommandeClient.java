package com.ksi.tiakktiakk.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "commande_client")
public class CommandeClient extends AbstractEntity{

    @Column(name = "codeCommande")
    private String codeCommande;

    @Column(name = "id_client")
    private Long idClient;

    @Column(name = "adresse_depart")
    private String adresseDepart;

    @Column(name = "adresse_destination")
    private String adresseDestination;

    @Column(name = "date_heure_commande")
    private LocalDateTime dateHeureCommande;

    @Column(name = "instructions_speciales")
    private String instructionsSpeciales;

    @Column(name = "statut_commande")
    private String statutCommande;

    @Column(name = "prix")
    private BigDecimal prix;

    @Column(name = "evaluation_conducteur")
    private int evaluationConducteur;

    @Column(name = "commentaires_client")
    private String commentairesClient;

    @Column(name = "distance_estimee")
    private double distanceEstimee;

    @Column(name = "duree_estimee")
    private Duration dureeEstimee;

    //@Column(name = "moyen_paiement")
    //private String moyenPaiement;

    @OneToOne(mappedBy = "commandeClient")
    private Trajets trajet;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToOne
    @JoinColumn(name = "facture_id")
    private Facture facture;

    @PrePersist
    public void generateCodeCommande() {
        // Générer une série de 10 chiffres
        String digits = String.valueOf((int) ((Math.random() * 900_000_000) + 100_000_000));

        // Définir la référence de facture avec le préfixe et les chiffres générés
        this.codeCommande = "code_cmd_tt_" + digits;
    }

}
