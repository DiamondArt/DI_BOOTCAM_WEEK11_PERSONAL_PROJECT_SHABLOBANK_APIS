package com.shablobank.app.models;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "tpatients")
public class Patient extends AbstractEntity {

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
