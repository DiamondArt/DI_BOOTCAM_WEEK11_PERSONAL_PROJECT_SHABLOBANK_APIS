package com.shablobank.app.dto;

import com.shablobank.app.models.AbstractEntity;
import lombok.*;


@Data
@Builder

public class RoleDto {
    private String roleName;

    private UserDto user;
}
