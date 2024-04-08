package com.ksi.tiakktiakk.dtos;

import com.ksi.tiakktiakk.model.Client;
import com.ksi.tiakktiakk.model.Utilisateur;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientDto {
    private Long id;
    private Long userId;
    private String codeClient;
    private String adresseFacturation;
    private String adresseLivraison;

    public static ClientDto fromEntity(Client client) {
        if (client == null) {
            return null;
        }

        return ClientDto.builder()
                .id(client.getId())
                .userId(client.getId())
                .codeClient(client.getCodeClient())
                .adresseFacturation(client.getAdresseFacturation())
                .adresseLivraison(client.getAdresseLivraison())
                .build();
    }

    public static Client toEntity(ClientDto clientDto) {
        if (clientDto == null) {
            return null;
        }

        Client client = new Client();
        client.setId(clientDto.getId());

        //UtilisateurDto utilisateur = new UtilisateurDto();
        //utilisateur.setId(clientDto.getUserId());

        UtilisateurDto utilisateur = UtilisateurDto.fromEntity(new Utilisateur());
        utilisateur.setId(clientDto.getUserId());

        client.setCodeClient(clientDto.getCodeClient());
        client.setAdresseFacturation(clientDto.getAdresseFacturation());
        client.setAdresseLivraison(clientDto.getAdresseLivraison());
        return client;
    }
}
