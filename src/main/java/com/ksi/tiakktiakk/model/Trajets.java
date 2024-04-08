package com.ksi.tiakktiakk.model;

import lombok.*;

import javax.persistence.*;
import java.time.Duration;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "trajets")
public class Trajets extends AbstractEntity{

    @Column(name = "reference_trajet")
    private String referenceTrajet;

    @Column(name = "point_depart")
    private String pointDepart;

    @Column(name = "point_arrivee")
    private String pointArrivee;

    @Column(name = "distance")
    private double distance;

    @Column(name = "duree")
    private Duration duree;

    @Column(name = "date_depart")
    private String dateDepart;

    @Column(name = "date_arrivee")
    private String dateArrivee;

    @Column(name = "heure_depart")
    private String heureDepart;

    @Column(name = "heure_arrivee")
    private String heureArrivee;

    @Column(name = "statut")
    private String statut;



    @OneToOne
    @JoinColumn(name = "id_commande")
    private CommandeClient commandeClient;

    @OneToOne
    @JoinColumn(name = "facture_id")
    private Facture facture;

    @ManyToOne
    @JoinColumn(name = "chauffeur_id")
    private Chauffeur chauffeur;



    @PrePersist
    public void generateReference() {
        // Générer une série de 10 chiffres
        String digits = String.valueOf((int) ((Math.random() * 900_000_000) + 100_000_000));

        // Définir la référence de facture avec le préfixe et les chiffres générés
        this.referenceTrajet = "ref_trajet_tt_" + digits;
    }
}
