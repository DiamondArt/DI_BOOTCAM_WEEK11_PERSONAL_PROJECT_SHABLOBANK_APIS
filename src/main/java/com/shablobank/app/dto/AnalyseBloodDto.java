package com.shablobank.app.dto;

import com.shablobank.app.models.Analyses;
import com.shablobank.app.models.BloodBag;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AnalyseBloodDto {
    BloodBagDto bloodBag;
    AnalysesDto analyses;

}
