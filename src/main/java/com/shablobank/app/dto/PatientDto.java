package com.shablobank.app.dto;

import com.shablobank.app.models.AbstractEntity;
import com.shablobank.app.models.Adresse;
import lombok.*;

import java.util.List;

@Data
@Builder

public class PatientDto  {

  private String firstname;

  private String lastname;

  private Adresse adresse;

  private String mail;

  private String phone;

  private Integer idHopital;
  private List<OrderPatientDto> orderPatient;

}
