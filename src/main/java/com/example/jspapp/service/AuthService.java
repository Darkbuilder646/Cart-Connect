package com.example.jspapp.service;

import com.example.jspapp.entity.Users;
import com.example.jspapp.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UsersMapper usersMapper;

    public boolean registerUser(Users user) {
        Users existingUser = usersMapper.getByEmail(user.getEmail());
        if (existingUser != null) {
            return false;
        } else {
            usersMapper.save(user);
            return true;
        }
    }

    public boolean loginUser(String userEmail, String userPassword) {
        Users user = usersMapper.getByEmail(userEmail);
        if(user != null) {
            return user.getPassword().equals(userPassword);
        } else {
            return false;
        }
    }
}
