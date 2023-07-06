package com.senai.projetoweb.repositories;

import com.senai.projetoweb.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepositorie extends JpaRepository<UserModel,Integer> {

    @Query(value = "SELECT * FROM usuario where email = :email and password = :senha", nativeQuery = true)
    public UserModel login(String email, String senha);

}

