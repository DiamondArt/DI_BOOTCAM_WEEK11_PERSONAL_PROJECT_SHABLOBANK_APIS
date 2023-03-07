package com.shablobank.app.dto;

import com.shablobank.app.models.Adresse;
import com.shablobank.app.models.Hopital;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class UserDto {
    private String firstname;

    private String lastname;

    private String email;


    private String password;

    private Adresse adresse;

    private Hopital hopital;

    private List<RoleDto> roles;
}
