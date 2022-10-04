package com.revature.service;

import com.revature.model.User;
import com.revature.repository.UserRepository;

import java.sql.SQLException;

public class AuthService {

    private UserRepository userRepo = new UserRepository();

    public User login (String username, String password) throws SQLException{
        User user = userRepo.getUserByUsernameAndPassword(username,password);

        return user;
    }

}
