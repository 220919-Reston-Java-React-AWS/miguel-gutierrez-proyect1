package com.revature.service;

import com.revature.model.User;
import com.revature.repository.UserRepository;

import java.sql.SQLException;

public class RegisterService {

    private UserRepository userRepo = new UserRepository();


    public User register (String username,String password, String firstname, String lastname, int roleId) throws SQLException{
        User user = userRepo.addUser(username, password, firstname, lastname, roleId);
        return user;
    }
}
