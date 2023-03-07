package com.shablobank.app.dto;

import com.shablobank.app.models.AbstractEntity;
import com.shablobank.app.models.EtatCommande;
import com.shablobank.app.models.LigneOrderPatient;
import lombok.*;

import java.time.Instant;
import java.util.List;

@Data
@Builder

public class OrderPatientDto  {

  private String code;

  private Instant dateCommande;

  private EtatCommande etatCommande;

  private Integer idHopital;

  private PatientDto patient;

  private List<LigneOrderPatientDto> ligneOderPatients;
}
