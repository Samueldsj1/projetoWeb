package com.senai.projetoweb.repositories;

import com.senai.projetoweb.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositorie extends JpaRepository<UserModel,Integer> {
}

