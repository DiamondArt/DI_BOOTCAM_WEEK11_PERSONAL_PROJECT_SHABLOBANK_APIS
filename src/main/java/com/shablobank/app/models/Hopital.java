package com.shablobank.app.models;

import com.fasterxml.jackson.annotation.JsonIgnore;



import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "thopitals")
public class Hopital extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull(message = "Le champ name est obligatoire")
    @NotBlank(message = "Le champ name ne peut etre vide")
    @Column(name = "name", length = 50, nullable = false)
    private String name;
    @Embedded
    private Adresse adresse;
    @Column(name = "latitude", length = 250, nullable = false)
    @NotNull(message = "Le champ latitude est obligatoire")
    @NotBlank(message = "Le champ latitude ne peut etre vide")
    private String latitude;
    @Column(name = "longitude", length = 250, nullable = false)
    @NotNull(message = "Le champ longitude est obligatoire")
    @NotBlank(message = "Le champ longitude ne peut etre vide")
    private String longitude;
    @Column(name = "statut_juridique", length = 100, nullable = true)
    private String statut_juridique;
    @Column(name = "nbre_associe", nullable = true)
    private Integer nbre_associe;

    @JsonIgnore
    @OneToMany(mappedBy = "hopital")
    private List<User> users;
    @JsonIgnore
    @OneToMany(mappedBy = "hopital")
    private List<Bloods> bloods;

    @JsonIgnore
    @OneToMany(mappedBy = "hopital")
    private List<Demandes> demandes;
}
