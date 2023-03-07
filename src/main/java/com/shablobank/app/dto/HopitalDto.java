package com.shablobank.app.dto;

import com.shablobank.app.models.Adresse;
import com.shablobank.app.models.BloodBag;
import com.shablobank.app.models.Order;
import com.shablobank.app.models.User;
import lombok.Builder;
import lombok.Data;
import java.util.List;

@Builder
@Data
public class HopitalDto {
    private String name;

    private Adresse adresse;private String latitude;
    private String longitude;
    private String statut_juridique;
    private Integer nbre_associe;

    private List<UserDto> users;

    private List<BloodBagDto> bloodBags;

    private List<OrderDto> orders;
}
