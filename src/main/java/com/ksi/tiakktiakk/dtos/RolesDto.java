package com.ksi.tiakktiakk.dtos;

import com.ksi.tiakktiakk.liste_enum.RoleEnum;
import com.ksi.tiakktiakk.model.Roles;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RolesDto {
    private Long id;
    private RoleEnum role;


    public static RolesDto fromEntity(Roles roles) {
        if (roles == null) {
            return null;
        }

        return RolesDto.builder()
                .id(roles.getId())
                .role(roles.getRole())
                .build();
    }

    public static Roles toEntity(RolesDto rolesDto) {
        if (rolesDto == null) {
            return null;
        }

        Roles roles = new Roles();
        roles.setId(rolesDto.getId());
        roles.setRole(rolesDto.getRole());
        return roles;
    }


}
