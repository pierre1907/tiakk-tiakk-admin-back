package com.ksi.tiakktiakk.dtos;

import com.ksi.tiakktiakk.liste_enum.TypePieceIdentite;
import com.ksi.tiakktiakk.model.Utilisateur;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class UtilisateurDto {
    private Long id;

    private String referenceClient;

    private String nom;

    private String prenom;

    private String email;

    private String password;

    private String confirmationPassword;

    private AdresseDto adresse;

    private String photo;

    private Boolean etat;

    private String nomUtilisateur;

    private List<RolesDto> roles;

    private TypePieceIdentite typePieceIdentite;


    public static UtilisateurDto fromEntity(Utilisateur utilisateur) {
        if (utilisateur == null) {
            return null;
        }

        return UtilisateurDto.builder()
                .id(utilisateur.getId())
                .referenceClient(utilisateur.getReferenceClient())
                .nom(utilisateur.getNom())
                .prenom(utilisateur.getPrenom())
                .email(utilisateur.getEmail())
                .password(utilisateur.getPassword())
                .confirmationPassword(utilisateur.getConfirmationPassword())
                .adresse(AdresseDto.fromEntity(utilisateur.getAdresse()))
                .photo(utilisateur.getPhoto())
                .etat(utilisateur.getEtat())
                .nomUtilisateur(utilisateur.getNomUtilisateur())
                .roles(utilisateur.getRoles().stream().map(RolesDto::fromEntity).collect(Collectors.toList()))
                .typePieceIdentite(utilisateur.getTypePieceIdentite())
                .build();
    }

    public static Utilisateur toEntity(UtilisateurDto utilisateurDto) {
        if (utilisateurDto == null) {
            return null;
        }

        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(utilisateurDto.getId());
        utilisateur.setReferenceClient(utilisateurDto.getReferenceClient());
        utilisateur.setNom(utilisateurDto.getNom());
        utilisateur.setPrenom(utilisateurDto.getPrenom());
        utilisateur.setEmail(utilisateurDto.getEmail());
        utilisateur.setPassword(utilisateurDto.getPassword());
        utilisateur.setConfirmationPassword(utilisateurDto.getConfirmationPassword());
        utilisateur.setAdresse(AdresseDto.toEntity(utilisateurDto.getAdresse()));
        utilisateur.setPhoto(utilisateurDto.getPhoto());
        utilisateur.setEtat(utilisateurDto.getEtat());
        utilisateur.setNomUtilisateur(utilisateurDto.getNomUtilisateur());
        utilisateur.setRoles(utilisateurDto.getRoles().stream().map(RolesDto::toEntity).collect(Collectors.toList()));
        utilisateur.setTypePieceIdentite(utilisateurDto.getTypePieceIdentite());
        return utilisateur;
    }
}
