package com.ksi.tiakktiakk.dtos;

import com.ksi.tiakktiakk.model.Client;
import com.ksi.tiakktiakk.model.Facture;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class FactureDto {
    private Long id;
    private Long clientId;
    private String reference;

    public static FactureDto fromEntity(Facture facture) {
        if (facture == null) {
            return null;
        }

        return FactureDto.builder()
                .id(facture.getId())
                .clientId(facture.getClient().getUtilisateur().getId())
                .reference(facture.getReference())
                .build();
    }

    public static Facture toEntity(FactureDto factureDto) {
        if (factureDto == null) {
            return null;
        }

        Facture facture = new Facture();
        facture.setId(factureDto.getId());

        Client client = new Client();
        client.setId(factureDto.getClientId());
        facture.setClient(client);

        facture.setReference(factureDto.getReference());
        return facture;
    }
}
