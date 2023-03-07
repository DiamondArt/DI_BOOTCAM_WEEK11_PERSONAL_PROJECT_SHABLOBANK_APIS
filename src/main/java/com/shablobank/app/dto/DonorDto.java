package com.shablobank.app.dto;

import com.shablobank.app.models.Adresse;
import com.shablobank.app.models.BloodBag;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.OneToMany;
import java.util.List;

@Builder
@Data
public class DonorDto {
    @Column(name = "firstName", length = 50, nullable = false)
    private String firstName;
    @Column(name = "lastName", length = 150, nullable = false)
    private String lastName;
    @Column(name = "email", length = 250, nullable = true)
    private String email;
    @Column(name = "phone", length = 250, nullable = false)
    private String phone;
    @Column(name = "typeDonor", length = 100, nullable = false)
    private String typeDonor;
    @Embedded
    private Adresse adresse;

    @Column(name = "idHopital")
    private Integer idHopital;

    @OneToMany(mappedBy = "donor")
    private List<BloodBagDto> bloodBags;
}
