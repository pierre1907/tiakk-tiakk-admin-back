package com.ksi.tiakktiakk.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "vehicule")
public class Vehicule extends AbstractEntity {

    @Column(name = "marque")
    private String marque;

    @Column(name = "modele")
    private String modele;

    @Column(name = "annee_fabrication")
    private LocalDate anneeFabrication;

    @Column(name = "matricule")
    private String matricule;

    @Column(name = "couleur")
    private String couleur;

    @OneToMany(mappedBy = "vehicule")
    private List<Chauffeur> chauffeurs;


}
