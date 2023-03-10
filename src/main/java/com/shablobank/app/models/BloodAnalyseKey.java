package com.shablobank.app.models;

import javax.persistence.*;


import java.io.Serializable;

@Embeddable
public class BloodAnalyseKey implements Serializable {

  private static final long serialVersionUID = -7275079172834495736L;

  @Column(name="blood_id")
  private Integer bloodId;

  @Column(name="analyse_id")
  private Integer analyseId;
}
