package com.shablobank.app.models;
import lombok.*;
import javax.persistence.*;

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
    @Column(name = "bloodType", length = 3, nullable = false)
    private String bloodType;
    @Column(name = "quantity", nullable = false)
    private int quantity;
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
