package com.senai.projetoweb.services;

import com.senai.projetoweb.models.UserModel;
import com.senai.projetoweb.repositories.UserRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class LoginService {
    @Autowired
    private UserRepositorie userRepositorie;

    public UserModel logar(UserModel userModel){
        return userRepositorie.login(userModel.getEmail(), userModel.getPassword());
    }
}
