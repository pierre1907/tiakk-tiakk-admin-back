package com.ksi.tiakktiakk.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "course_chauffeur")
public class CourseChauffeur extends AbstractEntity{
    @ManyToOne
    @JoinColumn(name = "chauffeur_id")
    private Chauffeur chauffeur;

    @ManyToOne
    @JoinColumn(name = "trajet_id")
    private Trajets trajet;

    @Column(name = "date_depart")
    private LocalDateTime dateDepart;

    @Column(name = "date_arrivee")
    private LocalDateTime dateArrivee;

    @Column(name = "statut")
    private String statut;
}
