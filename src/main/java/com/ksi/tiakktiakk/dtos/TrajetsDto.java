package com.ksi.tiakktiakk.dtos;

import com.ksi.tiakktiakk.model.*;
import lombok.Builder;
import lombok.Data;
import java.time.Duration;

@Data
@Builder
public class TrajetsDto {
    private Long id;

    private String referenceTrajet;

    private String pointDepart;

    private String pointArrivee;

    private double distance;

    private Duration duree;

    private String dateDepart;

    private String dateArrivee;

    private String heureDepart;

    private String heureArrivee;

    private String statut;

    private CommandeClientDto commandeClient;

    private FactureDto facture;

    private ChauffeurDto chauffeur;

    public static TrajetsDto fromEntity(Trajets trajets) {
        if (trajets == null) {
            return null;
        }
        return TrajetsDto.builder()
                .id(trajets.getId())
                .referenceTrajet(trajets.getReferenceTrajet())
                .pointDepart(trajets.getPointDepart())
                .pointArrivee(trajets.getPointArrivee())
                .distance(trajets.getDistance())
                .duree(trajets.getDuree())
                .commandeClient(CommandeClientDto.fromEntity(trajets.getCommandeClient()))
                .facture(FactureDto.fromEntity(trajets.getFacture()))
                .heureArrivee(trajets.getHeureArrivee())
                .heureDepart(trajets.getHeureDepart())
                .dateDepart(trajets.getDateDepart())
                .dateArrivee(trajets.getDateArrivee())
                .chauffeur(ChauffeurDto.fromEntity(trajets.getChauffeur()))
                .build();
    }

    public static Trajets toEntity(TrajetsDto trajetsDto) {
        if (trajetsDto == null) {
            return null;
        }

        Trajets trajets = new Trajets();
        trajets.setId(trajetsDto.getId());
        trajets.setPointDepart(trajetsDto.getPointDepart());
        trajets.setPointArrivee(trajetsDto.getPointArrivee());
        trajets.setDuree(trajetsDto.getDuree());
        trajets.setDistance(trajetsDto.getDistance());
        trajets.setDateArrivee(trajetsDto.getDateArrivee());
        trajets.setStatut(trajetsDto.getStatut());
        trajets.setReferenceTrajet(trajetsDto.getReferenceTrajet());
        trajets.setDateDepart(trajetsDto.getDateDepart());
        trajets.setHeureDepart(trajetsDto.getHeureDepart());
        trajets.setHeureArrivee(trajetsDto.getHeureArrivee());
        return trajets;
    }

}
