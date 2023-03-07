package com.shablobank.app.models;

import java.time.Instant;
import java.util.List;
import javax.persistence.*;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "torderpatients")
public class OrderPatient extends AbstractEntity {

  @Column(name = "code")
  private String code;

  @Column(name = "datecommande")
  private Instant dateCommande;

  @Column(name = "etatcommande")
  @Enumerated(EnumType.STRING)
  private EtatCommande etatCommande;

  @Column(name = "idHopital")
  private Integer idHopital;

  @ManyToOne
  @JoinColumn(name = "idpatient")
  private Patient patient;

  @OneToMany(mappedBy = "orderPatient")
  private List<LigneOrderPatient> ligneOderPatients;
}
