package com.shablobank.app.service;
import com.shablobank.app.Exception.EntityException;
import com.shablobank.app.payload.LoginDto;
import com.shablobank.app.payload.SignupDto;
public interface IAuthService {

    String login(LoginDto loginDto);
    String register(SignupDto registerDto) throws EntityException;
}
