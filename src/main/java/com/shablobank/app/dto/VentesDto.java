package com.shablobank.app.dto;

import com.shablobank.app.models.AbstractEntity;
import lombok.*;
import java.time.Instant;
import java.util.List;

@Data
@Builder

public class VentesDto {

  private String code;

  private Instant dateVente;

  private String commentaire;

  private Integer idHopital;

  private List<LigneVenteDto> ligneVentes;
}
