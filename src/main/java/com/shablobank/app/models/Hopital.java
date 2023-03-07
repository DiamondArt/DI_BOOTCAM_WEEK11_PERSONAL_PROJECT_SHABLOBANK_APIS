package com.shablobank.app.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "thopitals")
public class Hopital extends AbstractEntity {
    @Column(name = "name", length = 50, nullable = false)
    private String name;
    @Embedded
    private Adresse adresse;
    @Column(name = "latitude", length = 250, nullable = false)
    private String latitude;
    @Column(name = "longitude", length = 250, nullable = false)
    private String longitude;
    @Column(name = "statut_juridique", length = 100, nullable = true)
    private String statut_juridique;
    @Column(name = "nbre_associe", nullable = true)
    private Integer nbre_associe;

    @OneToMany(mappedBy = "hopital")
    private List<User> users;

    @OneToMany(mappedBy = "hopital")
    private List<BloodBag> bloodBags;

    @OneToMany(mappedBy = "hopital")
    private List<Order> orders;
}
