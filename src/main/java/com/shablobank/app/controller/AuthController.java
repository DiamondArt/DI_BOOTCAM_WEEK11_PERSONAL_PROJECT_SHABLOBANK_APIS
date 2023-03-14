package com.shablobank.app.controller;

import com.shablobank.app.models.User;
import com.shablobank.app.payload.LoginDto;
import com.shablobank.app.payload.SignupDto;
import com.shablobank.app.repository.IRoleRepository;
import com.shablobank.app.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IRoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/signin")
    public ResponseEntity<String> authenticateUser(@RequestBody LoginDto loginDto){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsername(), loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new ResponseEntity<>("User signed-in successfully!.", HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignupDto signUpDto){

        // add check for username exists in a DB
        //if(userRepository.existsByUsername(signUpDto.getUsername())){
          //  return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
       // }

        // add check for email exists in DB
        if(userRepository.existsByEmail(signUpDto.getEmail())){
            return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
        }

        // create user object
        User user = new User();
        user.setLastname(signUpDto.getLastname());
        user.setFirstname(signUpDto.getFirstname());
        user.setEmail(signUpDto.getEmail());
        user.setHopital(signUpDto.getIdHopital());
        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));
        //Role roles = roleRepository.findByName(ERole.ROLE_ADMIN).get();
        //user.setRoles(Collections.singletonList(roles));

        userRepository.save(user);

       return new ResponseEntity<>("User registered successfully", HttpStatus.OK);

    }

}
