package com.shablobank.app.dto;

import com.shablobank.app.models.*;
import com.shablobank.app.models.AnalyseBlood;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Builder
@Data
public class BloodBagDto {
    private String codeRef;
    private BloodType bloodType;
    private String designation;
    private BigDecimal volume;
    private BigDecimal priceHt;
    Set<AnalyseBloodDto> analyseBloods;
    private HopitalDto hopital;
    private DonorDto donor;
    private List<MvtStockDto> mvtStks;
}
