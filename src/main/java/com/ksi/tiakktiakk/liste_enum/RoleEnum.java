package com.ksi.tiakktiakk.liste_enum;

public enum RoleEnum {
    ADMIN("Admin", "ADM"),
    CLIENT("Client", "CLT"),
    CHAUFFEUR("Chauffeur", "CHF"),
    GESTIONNAIRE("Gestionnaire", "GST");

    private final String label;
    private final String code;

    RoleEnum(String label, String code) {
        this.label = label;
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public String getCode() {
        return code;
    }
}
