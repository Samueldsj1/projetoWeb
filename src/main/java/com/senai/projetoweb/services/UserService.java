package com.senai.projetoweb.services;

import com.senai.projetoweb.models.UserModel;
import com.senai.projetoweb.repositories.UserRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepositorie userRepositorie;

    public UserModel save(UserModel userModel){
        return userRepositorie.save(userModel);
    }
    public List<UserModel> findAll(){
        return userRepositorie.findAll();
    }
    public Optional<UserModel> findById(Integer id){
        return userRepositorie.findById(id);
    }

}
