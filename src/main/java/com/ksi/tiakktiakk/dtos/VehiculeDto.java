package com.ksi.tiakktiakk.dtos;

import com.ksi.tiakktiakk.model.Vehicule;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class VehiculeDto {

    private Long id;

    private String marque;

    private String modele;

    private LocalDate anneeFabrication;

    private String matricule;

    private String couleur;

    private List<ChauffeurDto> chauffeurs;


    public static VehiculeDto fromEntity(Vehicule vehicule) {
        if (vehicule == null) {
            return null;
        }

        return VehiculeDto.builder()
                .id(vehicule.getId())
                .marque(vehicule.getMarque())
                .modele(vehicule.getModele())
                .anneeFabrication(vehicule.getAnneeFabrication())
                .matricule(vehicule.getMatricule())
                .couleur(vehicule.getCouleur())
                .chauffeurs(vehicule.getChauffeurs().stream().map(ChauffeurDto::fromEntity).collect(Collectors.toList()))
                .build();
    }




    public static Vehicule toEntity(VehiculeDto vehiculeDto) {
        if (vehiculeDto == null) {
            return null;
        }

        Vehicule vehicule = new Vehicule();
        vehicule.setId(vehiculeDto.getId());
        vehicule.setMarque(vehiculeDto.getMarque());
        vehicule.setModele(vehiculeDto.getModele());
        vehicule.setAnneeFabrication(vehiculeDto.getAnneeFabrication());
        vehicule.setMatricule(vehiculeDto.getMatricule());
        vehicule.setCouleur(vehiculeDto.getCouleur());
        vehicule.setChauffeurs(vehiculeDto.getChauffeurs().stream().map(ChauffeurDto::toEntity).collect(Collectors.toList()));
        return vehicule;
    }

}
