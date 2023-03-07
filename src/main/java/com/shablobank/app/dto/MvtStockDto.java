package com.shablobank.app.dto;

import com.shablobank.app.models.AbstractEntity;
import com.shablobank.app.models.BloodBag;
import com.shablobank.app.models.SourceMvtStk;
import com.shablobank.app.models.TypeMvtStk;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@Builder

public class MvtStockDto   {
    private Instant dateMvt;

    private BigDecimal quantite;

    private BloodBagDto bloodBag;

    private TypeMvtStk typeMvt;

    private SourceMvtStk sourceMvt;

    private Integer idEntreprise;
}
