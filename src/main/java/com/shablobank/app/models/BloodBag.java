package com.shablobank.app.models;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "tbloodBags")
public class BloodBag extends AbstractEntity{
    @Column(name = "codeRef", length = 250, nullable = false)
    private String codeRef;

    @Column(name = "bloodType")
    @Enumerated(EnumType.STRING)
    private BloodType bloodType;

    @Column(name = "designation", nullable = false)
    private String designation;

    @Column(name = "volume", nullable= false)
    private BigDecimal volume;

    @Column(name = "priceHt")
    private BigDecimal priceHt;

    @OneToMany(mappedBy = "bloodBag")
    Set<AnalyseBlood> analyseBloods;
    @ManyToOne
    @JoinColumn(name = "idHopital")
    private Hopital hopital;

    @ManyToOne
    @JoinColumn(name = "idDonor")
    private Donor donor;

    @OneToMany(mappedBy = "bloodBag")
    private List<MvtStock> mvtStks;
}
