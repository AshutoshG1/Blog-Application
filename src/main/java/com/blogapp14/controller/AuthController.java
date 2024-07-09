package com.blogapp14.controller;

import com.blogapp14.entity.User;
import com.blogapp14.payload.LoginDto;
import com.blogapp14.payload.Signup;
import com.blogapp14.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    //http://localhost:8080/api/auth/sign-up
    @PostMapping("/sign-up")
    public ResponseEntity<String> createUser(@RequestBody Signup signup){
        if(userRepository.existsByEmail(signup.getEmail())){
            return new ResponseEntity<>("email id is already registered", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if(userRepository.existsByUsername(signup.getUsername())){
            return new ResponseEntity<>("username is already registered", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        User user = new User();
        user.setName(signup.getName());
        user.setUsername(signup.getUsername());
        user.setEmail(signup.getEmail());
        user.setPassword(passwordEncoder.encode(signup.getPassword()));

        User save = userRepository.save(user);
        return new ResponseEntity<>("user registered", HttpStatus.CREATED);

    }

    @PostMapping("/sign-in")
    public ResponseEntity<String> signIn(@RequestBody LoginDto loginDto){
        //1.Supply loginDto.getUsername() username to loadByUser method to CustomUserDetail class
        //2.It will compare
        // expected credentials with-loginDto.getUsername(), loginDto.getPassword()
        //with Actual credential given by loadByUser method
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword());
        Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        //similar to session variable
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        return new ResponseEntity<>("sign-in successful ", HttpStatus.OK);
    }
}
