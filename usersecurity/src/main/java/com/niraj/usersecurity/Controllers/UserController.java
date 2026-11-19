
package com.niraj.usersecurity.Controllers;

import com.niraj.usersecurity.Config.JWTService;
import com.niraj.usersecurity.Entity.User;
import com.niraj.usersecurity.Services.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserService userservice;
    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;

    public UserController(
            UserService userservice,
            AuthenticationManager authenticationManager,
            JWTService jwtService) {
        this.userservice = userservice;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {

        // Save the user in the database
        userservice.addUser(user);

        // Generate and return the token
        return jwtService.generateToken(user.getUserName());
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody User user) {

        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                user.getUserName(),
                                user.getUserPassword()
                        )
                );

        return jwtService.generateToken(authentication.getName());
    }
}