package com.ksi.tiakktiakk.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "chaufeur")
public class Chauffeur extends AbstractEntity{
    @OneToOne
    @JoinColumn(name = "user_id")
    private Utilisateur utilisateur;

    @Column(name = "code_chauffeur")
    private String codeChauffeur;

    @Column(name = "num_permis_conduire")
    private String numeroPermisConduire;

    @OneToMany(mappedBy = "chauffeur")
    private List<Trajets> trajets;

    @OneToMany(mappedBy = "courses")
    private List<CourseChauffeur> courses;

    @ManyToOne
    @JoinColumn(name = "vehicule_id")
    private Vehicule vehicule;

    @ManyToOne
    @JoinColumn(name = "adresse_id")
    private Adresse adresse;


    @PrePersist
    public void generateCode() {
        // Générer une série de 10 chiffres
        String digits = String.valueOf((int) ((Math.random() * 900_000_000) + 100_000_000));

        // Définir la référence de facture avec le préfixe et les chiffres générés
        this.codeChauffeur = "code_chauffeur_tt_" + digits;
    }

}
