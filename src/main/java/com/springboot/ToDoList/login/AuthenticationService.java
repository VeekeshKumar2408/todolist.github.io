package com.springboot.ToDoList.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public boolean authenticate(String username, String password){
        boolean isValidUsername = username.equalsIgnoreCase("Veekesh");
        boolean isValidPassword = password.equalsIgnoreCase("Dummy");
        return isValidUsername&& isValidPassword;
    }
}
