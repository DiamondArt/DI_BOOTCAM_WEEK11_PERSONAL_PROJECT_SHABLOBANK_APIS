package com.shablobank.app.models;
import lombok.*;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "tdemandes")
public class Demandes extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "Le champ groupe sanguin est obligatoire")
    @NotBlank(message = "Le champ groupe sanguin ne peut etre vide")
    @Column(name = "bloodType", length = 3, nullable = false)
    private String bloodType;
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "statut", nullable = false)
    private Boolean statut;

    @Column(name = "idHopitalTraitant", nullable= true)
    private Integer idHopitalTraitant;

    @Column(name = "antecedant",length = 250, nullable = true)
    private String info;

   @ManyToOne
   @JoinColumn(name = "idHopitalDemandeur")
   private Hopital hopital;

}
