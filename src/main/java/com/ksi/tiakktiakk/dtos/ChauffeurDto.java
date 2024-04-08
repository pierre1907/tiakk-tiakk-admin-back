package com.ksi.tiakktiakk.dtos;

import com.ksi.tiakktiakk.model.Adresse;
import com.ksi.tiakktiakk.model.Chauffeur;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class ChauffeurDto {

    private Long id;

    private UtilisateurDto utilisateur;

    private String codeChauffeur;

    private String numeroPermisConduire;

    private List<TrajetsDto> trajets;

    private List<CoursesChauffeurDto> courses;

    private VehiculeDto vehicule;

    private AdresseDto adresse;

    public static Chauffeur toEntity(ChauffeurDto chauffeurDto) {
        if (chauffeurDto == null) {
            return null;
        }

        Chauffeur chauffeur = new Chauffeur();
        chauffeur.setId(chauffeurDto.getId());
        chauffeur.setUtilisateur(UtilisateurDto.toEntity(chauffeurDto.getUtilisateur())); // UtilisateurDto.toEntity ici
        chauffeur.setCodeChauffeur(chauffeurDto.getCodeChauffeur());
        chauffeur.setNumeroPermisConduire(chauffeurDto.getNumeroPermisConduire());
        chauffeur.setTrajets(chauffeurDto.getTrajets().stream().map(TrajetsDto::toEntity).collect(Collectors.toList()));
        chauffeur.setCourses(chauffeurDto.getCourses().stream().map(CoursesChauffeurDto::toEntity).collect(Collectors.toList()));
        chauffeur.setVehicule(VehiculeDto.toEntity(chauffeurDto.getVehicule()));
        chauffeur.setAdresse(AdresseDto.toEntity(chauffeurDto.getAdresse())); // Utilisation de la méthode toEntity de AdresseDto
        return chauffeur;
    }

    public static ChauffeurDto fromEntity(Chauffeur chauffeur) {
        if (chauffeur == null) {
            return null;
        }

        return ChauffeurDto.builder()
                .id(chauffeur.getId())
                .utilisateur(UtilisateurDto.fromEntity(chauffeur.getUtilisateur()))
                .codeChauffeur(chauffeur.getCodeChauffeur())
                .numeroPermisConduire(chauffeur.getNumeroPermisConduire())
                .trajets(chauffeur.getTrajets().stream().map(TrajetsDto::fromEntity).collect(Collectors.toList()))
                .courses(chauffeur.getCourses().stream().map(CoursesChauffeurDto::fromEntity).collect(Collectors.toList()))
                .vehicule(VehiculeDto.fromEntity(chauffeur.getVehicule()))
                .adresse(AdresseDto.fromEntity(chauffeur.getAdresse()))
                .build();
    }

}
