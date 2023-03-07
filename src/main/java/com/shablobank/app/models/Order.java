package com.shablobank.app.models;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "torders")
public class Order  extends AbstractEntity {
    @Column(name = "bloodType", length = 3, nullable = false)
    private String bloodType;
    @Column(name = "quantity", nullable = false)
    private int quantity;
    @Column(name = "statut", nullable = false, columnDefinition = "false")
    private Boolean statut;

    @Column(name = "idHopitalTraitant", nullable = true)
    private Integer idHopitalTraitant;

    @Column(name = "info",length = 250, nullable = true)
    private String info;

    @ManyToOne
    @JoinColumn(name = "idHopitalDemandeur")
    private Hopital hopital;


}
