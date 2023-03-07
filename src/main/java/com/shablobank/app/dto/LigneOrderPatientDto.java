package com.shablobank.app.dto;

import com.shablobank.app.models.Order;
import com.shablobank.app.models.OrderPatient;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class LigneOrderPatientDto {
    private Order order;

    private OrderPatientDto orderPatient;

    private BigDecimal quantity;

    private BigDecimal price;

    private Integer idHopital;
}
