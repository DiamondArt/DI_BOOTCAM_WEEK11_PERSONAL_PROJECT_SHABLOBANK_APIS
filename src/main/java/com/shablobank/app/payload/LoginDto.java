package com.shablobank.app.payload;

import lombok.Data;

@Data
public class LoginDto {
    private String firstNameOrEmail;
    private String password;
}
