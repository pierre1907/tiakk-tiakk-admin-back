package com.ksi.tiakktiakk.model;

import com.ksi.tiakktiakk.liste_enum.TypePieceIdentite;
import lombok.*;


import javax.persistence.*;
import java.util.List;
import java.util.Random;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "utilisateur")
public class Utilisateur extends AbstractEntity{

    @Column(name = "reference_client")
    private String referenceClient;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "confirmation_password")
    private String confirmationPassword;

    @Embedded
    private Adresse adresse;

    @Column(name = "photo")
    private String photo;

    @Column(name = "etat")
    private Boolean etat;

    @Column(name = "nom_utilisateur")
    private String nomUtilisateur;

    @ManyToMany(mappedBy = "utlisateurs")
    private List<Roles> roles;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_piece_identite")
    private TypePieceIdentite typePieceIdentite;

    @PrePersist
    public void generateReference() {
        // Générer 5 chiffres aléatoires
        Random random = new Random();
        int randomInt = random.nextInt(90000) + 10000; // Générer un nombre entre 10000 et 99999

        // Créer la référence utilisateur en concaténant nom, prénom et 5 chiffres aléatoires
        this.referenceClient = this.nom.substring(0, 3) + this.prenom.substring(0, 3) + randomInt;
    }

}
