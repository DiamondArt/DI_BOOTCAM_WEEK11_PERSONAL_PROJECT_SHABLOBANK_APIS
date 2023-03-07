package com.shablobank.app.dto;

import com.shablobank.app.models.AbstractEntity;
import com.shablobank.app.models.BloodBag;
import lombok.*;

import java.math.BigDecimal;

@Data
@Builder

public class LigneVenteDto   {

  private VentesDto vente;

  private BloodBagDto bloodBag;

  private BigDecimal quantity;

  private BigDecimal price;
  private Integer idHopital;

}
