package com.niraj.usersecurity.Config;

import com.niraj.usersecurity.Entity.User;
import com.niraj.usersecurity.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = repo.findByUserName(username);
        if(user==null){
            System.out.print("USer not there BROORRRR");
            throw new UsernameNotFoundException("USER NAHI HAII!!!!!!!");
        }

        UserDetailsImpl udi = new UserDetailsImpl(user);
        return  udi;
    }
}
