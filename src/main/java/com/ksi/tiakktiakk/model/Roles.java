package com.ksi.tiakktiakk.model;

import com.ksi.tiakktiakk.liste_enum.RoleEnum;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "roles")
public class Roles  extends AbstractEntity{
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private RoleEnum role;


    @ManyToMany(mappedBy = "roles")
    private List<Utilisateur> users;

}
