package com.shablobank.app.dto;

import com.shablobank.app.models.AbstractEntity;
import com.shablobank.app.models.Hopital;
import lombok.*;


@Data
@Builder

public class OrderDto   {
    private String bloodType;
    private int quantity;
    private Boolean statut;

    private Integer idHopitalTraitant;

    private String info;

    private HopitalDto hopital;

}
