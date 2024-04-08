package com.ksi.tiakktiakk.dtos;

 import com.ksi.tiakktiakk.model.Adresse;
 import lombok.Builder;
 import lombok.Data;


@Data
@Builder
public class AdresseDto {
    private Long id;
    private String telephone1;
    private String telephone2;
    private String adresse;
    private String ville;
    private String pays;

    public static AdresseDto fromEntity(Adresse adresse) {
        if (adresse == null) {
            return null;
        }

        return AdresseDto.builder()
                .id(adresse.getId())
                .telephone1(adresse.getTelephone1())
                .telephone2(adresse.getTelephone2())
                .adresse(adresse.getAdresse())
                .ville(adresse.getVille())
                .pays(adresse.getPays())
                .build();
    }

    public static Adresse toEntity(AdresseDto adresseDto) {
        if (adresseDto == null) {
            return null;
        }

        Adresse adresse = new Adresse();
        adresse.setId(adresseDto.getId());
        adresse.setTelephone1(adresseDto.getTelephone1());
        adresse.setTelephone2(adresseDto.getTelephone2());
        adresse.setAdresse(adresseDto.getAdresse());
        adresse.setVille(adresseDto.getVille());
        adresse.setPays(adresseDto.getPays());
        return adresse;
    }
}
