package com.shablobank.app.models;

import java.math.BigDecimal;
import javax.persistence.*;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "tlignevente")
public class LigneVente extends AbstractEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @ManyToOne
  @JoinColumn(name = "idvente")
  private Ventes vente;

  @ManyToOne
  @JoinColumn(name = "idblood")
  private Bloods bloods;

  @Column(name = "quantity")
  private BigDecimal quantity;

  @Column(name = "price")
  private BigDecimal price;

  @Column(name = "iHopital")
  private Integer idHopital;

}
