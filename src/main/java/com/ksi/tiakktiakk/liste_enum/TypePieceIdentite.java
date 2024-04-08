package com.ksi.tiakktiakk.liste_enum;

import lombok.Getter;

@Getter
public enum TypePieceIdentite {
    CARTE_IDENTITE("CI", "Carte d'identité"),
    PASSEPORT("PSP", "Passeport"),
    PERMIS_CONDUIRE("PC", "Permis de conduire"),
    CARTE_CONSULAIRE("CC", "Carte consulaire"),
    AUTRE("AUT", "Autre");

    private final String code;
    private final String label;

    TypePieceIdentite(String code, String label) {
        this.code = code;
        this.label = label;
    }

    public String getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }
}
