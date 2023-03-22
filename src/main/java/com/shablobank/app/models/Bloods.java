package com.shablobank.app.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbloods")
public class Bloods extends AbstractEntity implements  Serializable{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @NotNull(message = "Le champ réference est obligatoire")
  @NotBlank(message = "Le champ référence ne peut etre vide")
  @Column(name = "codeRef", length = 250, nullable = false)
  private String codeRef;

  @NotNull(message = "Le champ groupe sanguin est obligatoire")
  @NotBlank(message = "Le champ groupe sanguin ne peut etre vide")
  @Column(name = "bloodType" )
  private String bloodType;

  @NotNull(message = "Le champ rhesus est obligatoire")
  @NotBlank(message = "Le champ rhesus ne peut etre vide")
  @Column(name = "rhesus" )
  private String rhesus;

  @Column(name = "designation", nullable = true)
  private String designation;

  @Column(name = "quantity")
  private Integer quantity;

  @NotNull(message = "Le champ volume est obligatoire")
  @NotBlank(message = "Le champ volume ne peut etre vide")
  @Column(name = "volume", nullable= false)
  private String volume;

  @Column(name = "priceHt", nullable = true)
  private String priceHt;

  @Column(name = "statut", nullable = false)
  private Boolean statut;

  @ManyToOne
  @JoinColumn(name = "idHopital")
  private Hopital hopital;

  @OneToMany(mappedBy = "blood")
  private List<MvtStock> mvtStks;

  @JsonIgnore
  @OneToMany(mappedBy = "blood", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
  private List<CommandePatient> commandePatientList;

  @OneToMany(mappedBy = "blood",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
  private List<BloodAnalyse> bloodAnalysies;


}







