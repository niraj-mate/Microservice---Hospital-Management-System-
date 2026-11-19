package com.niraj.usersecurity.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserRequest {


    private String userName;
    private String UserPassword;

}
