package com.shablobank.app.service;

import com.shablobank.app.controller.exception.EntityException;
import com.shablobank.app.models.User;
import com.shablobank.app.payload.LoginDto;
import com.shablobank.app.payload.SignupDto;
import com.shablobank.app.repository.IRoleRepository;
import com.shablobank.app.repository.IUserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements IAuthService {

    private AuthenticationManager authenticationManager;
    private IUserRepository userRepository;
    private IRoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    //private JwtTokenProvider jwtTokenProvider;


    public AuthService(AuthenticationManager authenticationManager,
                       IUserRepository userRepository,
                       IRoleRepository roleRepository,
                           PasswordEncoder passwordEncoder
                           //JwtTokenProvider jwtTokenProvider
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        //this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public String login(LoginDto loginDto) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsername(), loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        //String token = jwtTokenProvider.generateToken(authentication);
        String token = "rttaaaaaaaaaaaaaaaaa";

        return token;
    }

    @Override
    public String register(SignupDto registerDto) throws EntityException {


        // add check for email exists in database
        if(userRepository.existsByEmail(registerDto.getEmail())) {
            throw new EntityException("Email is already exists!.");
        }

        User user = new User();
        user.setEmail(registerDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        user.setLastname(registerDto.getLastname());
        user.setFirstname(registerDto.getFirstname());
        user.setHopital(registerDto.getIdHopital());
        //Role roles = roleRepository.findByName(ERole.ROLE_ADMIN).get();
        //user.setRoles(Collections.singletonList(roles));

        //Set<Role> roles = new HashSet<>();
        //Role userRole = roleRepository.findByName(ERole.ROLE_ADMIN).get();
        //roles.add(userRole);
        //user.setRoles((List<Role>) roles);

        userRepository.save(user);

        return "User registered successfully!.";
    }
}
