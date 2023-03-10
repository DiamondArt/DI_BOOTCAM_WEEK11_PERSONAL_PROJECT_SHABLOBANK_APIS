package com.shablobank.app.models;

import javax.persistence.*;

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

  @Column(name = "codeRef", length = 250, nullable = false)
  private String codeRef;

  @Column(name = "bloodType")
  @Enumerated(EnumType.STRING)
  private BloodType bloodType;

  @Column(name = "designation", nullable = false)
  private String designation;

  @Column(name = "volume", nullable= false)
  private BigDecimal volume;

  @Column(name = "priceHt")
  private BigDecimal priceHt;

  @ManyToOne
  @JoinColumn(name = "idHopital")
  private Hopital hopital;

  @ManyToOne
  @JoinColumn(name = "idDonor")
  private Donor donor;

  @OneToMany(mappedBy = "blood")
  private List<MvtStock> mvtStks;

  @OneToMany(mappedBy = "blood",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
  private List<BloodAnalyse> bloodAnalysies;


}







