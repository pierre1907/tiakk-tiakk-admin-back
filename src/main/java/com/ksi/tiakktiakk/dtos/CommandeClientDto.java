package com.ksi.tiakktiakk.dtos;

import com.ksi.tiakktiakk.model.CommandeClient;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;

@Builder
@Data
public class CommandeClientDto {
    private Long id;
    private String code;
    private Long clientId;
    private String adresseDepart;
    private String adresseDestination;
    private LocalDateTime dateHeureCommande;
    private String instructionsSpeciales;
    private String statutCommande;
    private BigDecimal prix;
    private int evaluationConducteur;
    private String commentairesClient;
    private double distanceEstimee;
    private Duration dureeEstimee;

    public static CommandeClientDto fromEntity(CommandeClient commandeClient) {
        if (commandeClient == null) {
            return null;
        }

        return CommandeClientDto.builder()
                .id(commandeClient.getId())
                .code(commandeClient.getCodeCommande())
                .clientId(commandeClient.getClient().getId())
                .adresseDepart(commandeClient.getAdresseDepart())
                .adresseDestination(commandeClient.getAdresseDestination())
                .dateHeureCommande(commandeClient.getDateHeureCommande())
                .instructionsSpeciales(commandeClient.getInstructionsSpeciales())
                .statutCommande(commandeClient.getStatutCommande())
                .prix(commandeClient.getPrix())
                .evaluationConducteur(commandeClient.getEvaluationConducteur())
                .commentairesClient(commandeClient.getCommentairesClient())
                .distanceEstimee(commandeClient.getDistanceEstimee())
                .dureeEstimee(commandeClient.getDureeEstimee())
                .build();
    }

    public static CommandeClient toEntity(CommandeClientDto commandeClientDto) {
        if (commandeClientDto == null) {
            return null;
        }

        CommandeClient commandeClient = new CommandeClient();
        commandeClient.setId(commandeClientDto.getId());
        commandeClient.setCodeCommande(commandeClientDto.getCode());
        //commandeClient.setClientId(commandeClientDto.getClientId());
        commandeClient.setAdresseDepart(commandeClientDto.getAdresseDepart());
        commandeClient.setAdresseDestination(commandeClientDto.getAdresseDestination());
        commandeClient.setDateHeureCommande(commandeClientDto.getDateHeureCommande());
        commandeClient.setInstructionsSpeciales(commandeClientDto.getInstructionsSpeciales());
        commandeClient.setStatutCommande(commandeClientDto.getStatutCommande());
        commandeClient.setPrix(commandeClientDto.getPrix());
        commandeClient.setEvaluationConducteur(commandeClientDto.getEvaluationConducteur());
        commandeClient.setCommentairesClient(commandeClientDto.getCommentairesClient());
        commandeClient.setDistanceEstimee(commandeClientDto.getDistanceEstimee());
        commandeClient.setDureeEstimee(commandeClientDto.getDureeEstimee());
        return commandeClient;
    }

}
