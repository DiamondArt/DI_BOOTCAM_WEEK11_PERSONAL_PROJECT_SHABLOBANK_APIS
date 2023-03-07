package com.shablobank.app.models;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "tlignevente")
public class LigneVente extends AbstractEntity {

  @ManyToOne
  @JoinColumn(name = "idvente")
  private Ventes vente;

  @ManyToOne
  @JoinColumn(name = "idbloodbag")
  private BloodBag bloodBag;

  @Column(name = "quantity")
  private BigDecimal quantity;

  @Column(name = "price")
  private BigDecimal price;

  @Column(name = "iHopital")
  private Integer idHopital;

}
