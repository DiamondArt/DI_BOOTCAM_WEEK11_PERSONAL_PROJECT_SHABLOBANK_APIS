package com.shablobank.app.dto;

import com.shablobank.app.models.AnalyseBlood;
import lombok.Builder;
import lombok.Data;
import java.util.Set;

@Data
@Builder
public class AnalysesDto {
    private String anaylyseName;
    //@JsonIgnore
    Set<AnalyseBloodDto> analyseBloods;
}
