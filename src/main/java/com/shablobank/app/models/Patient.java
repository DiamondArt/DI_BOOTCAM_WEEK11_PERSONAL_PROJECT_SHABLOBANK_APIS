package com.shablobank.app.models;

import java.util.List;
import javax.persistence.*;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "tpatients")
public class Patient extends AbstractEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @Column(name = "firstname")
  private String firstname;

  @Column(name = "lastname")
  private String lastname;

  @Embedded
  private Adresse adresse;

  @Column(name = "mail")
  private String mail;

  @Column(name = "phone")
  private String phone;

  @Column(name = "idHopital")
  private Integer idHopital;

  @OneToMany(mappedBy = "patient")
  private List<OrderPatient> orderPatient;

}
