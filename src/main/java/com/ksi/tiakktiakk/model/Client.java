package com.ksi.tiakktiakk.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "client")
public class Client extends AbstractEntity{
    @OneToOne
    @JoinColumn(name = "user_id")
    private Utilisateur utilisateur;

    @Column(name = "code_client")
    private String codeClient;

    @Column(name = "adresse_facturation")
    private String adresseFacturation;

    @Column(name = "adresse_livraison")
    private String adresseLivraison;

    @OneToMany(mappedBy = "client")
    private List<CommandeClient> commandes;

    @PrePersist
    public void generateCode() {
        // Générer une série de 10 chiffres
        String digits = String.valueOf((int) ((Math.random() * 900_000_000) + 100_000_000));

        // Définir la référence de facture avec le préfixe et les chiffres générés
        this.codeClient = "rcode_client_tt_" + digits;
    }



    //@Column(name = "carte_credit")
    //private String carteCredit;

    //@Column(name = "points_fidelite")
    //private int pointsFidelite;

}


