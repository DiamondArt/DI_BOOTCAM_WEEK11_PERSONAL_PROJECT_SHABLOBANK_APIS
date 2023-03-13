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
@Table(name = "tligneOrderpatients")
public class LigneOrderPatient extends AbstractEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @ManyToOne
  @JoinColumn(name = "idOrderpatient")
  private OrderPatient orderPatient;

  @Column(name = "quantity")
  private BigDecimal quantity;

  @Column(name = "price")
  private BigDecimal price;

  @Column(name = "idHopital")
  private Integer idHopital;

}
