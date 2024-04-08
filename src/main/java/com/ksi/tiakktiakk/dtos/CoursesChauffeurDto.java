package com.ksi.tiakktiakk.dtos;

import com.ksi.tiakktiakk.model.CourseChauffeur;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder

public class CoursesChauffeurDto {
    private Long id;

    private ChauffeurDto chauffeur;

    private TrajetsDto trajet;

    private LocalDateTime dateDepart;

    private LocalDateTime dateArrivee;

    private String statut;

    public static CoursesChauffeurDto fromEntity(CourseChauffeur coursesChauffeur) {
        if (coursesChauffeur == null) {
            return null;
        }

        return CoursesChauffeurDto.builder()
                .id(coursesChauffeur.getId())
                .chauffeur(ChauffeurDto.fromEntity(coursesChauffeur.getChauffeur()))
                .trajet(TrajetsDto.fromEntity(coursesChauffeur.getTrajet()))
                .dateDepart(coursesChauffeur.getDateDepart())
                .dateArrivee(coursesChauffeur.getDateArrivee())
                .statut(coursesChauffeur.getStatut())
                .build();
    }

    public static CourseChauffeur toEntity(CoursesChauffeurDto coursesChauffeurDto) {
        if (coursesChauffeurDto == null) {
            return null;
        }

        CourseChauffeur coursesChauffeur = new CourseChauffeur();
        coursesChauffeur.setId(coursesChauffeurDto.getId());
        coursesChauffeur.setChauffeur(ChauffeurDto.toEntity(coursesChauffeurDto.getChauffeur()));
        coursesChauffeur.setTrajet(TrajetsDto.toEntity(coursesChauffeurDto.getTrajet()));
        coursesChauffeur.setDateDepart(coursesChauffeurDto.getDateDepart());
        coursesChauffeur.setDateArrivee(coursesChauffeurDto.getDateArrivee());
        coursesChauffeur.setStatut(coursesChauffeurDto.getStatut());
        return coursesChauffeur;
    }
}
