package com.niraj.usersecurity.Services;

import com.niraj.usersecurity.Entity.User;
import com.niraj.usersecurity.Entity.UserRequest;
import com.niraj.usersecurity.Entity.UserResponse;
import com.niraj.usersecurity.Repo.UserRepo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserRepo repo;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepo repo, PasswordEncoder passwordEncoder) {
        this.repo = repo;
        this.passwordEncoder = passwordEncoder;
    }

    public String addUser(User user) {
        User u = new User();
        u.setUserName(user.getUserName());
        u.setUserPassword(
                passwordEncoder.encode(user.getUserPassword())
        );

        repo.save(u);

        return "Registration successful";
    }
}