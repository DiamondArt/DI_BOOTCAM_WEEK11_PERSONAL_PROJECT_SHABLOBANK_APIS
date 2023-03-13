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
@Table(name = "tventes")
public class Ventes extends AbstractEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "code")
  private String code;

  @Column(name = "datevente")
  private Instant dateVente;

  @Column(name = "commentaire")
  private String commentaire;

  @Column(name = "idHopital")
  private Integer idHopital;

  @OneToMany(mappedBy = "vente")
  private List<LigneVente> ligneVentes;
}
