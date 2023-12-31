package com.senai.projetoweb.controllers;

import com.senai.projetoweb.models.UserModel;
import com.senai.projetoweb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping(value = "/usuario")
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/cadastrar")
    public String saveUser(UserModel userModel){
    userService.save(userModel);
    return "redirect:/usuario";
    }
    @GetMapping(value = "/registro")
    public String formInsertUser(){
        return "user/register";
    }
    @GetMapping
    public String listUser(Model model){
        List<UserModel>listUser = userService.findAll();
        model.addAttribute("users",listUser);
        return "user/users";
    }


    @GetMapping(value = "/{id}")
    public String getUser(@PathVariable Integer id, Model model){
        Optional<UserModel> user = userService.findById(id);
        if(user.isPresent()){
            model.addAttribute("user", user.get());
            return "user/update";
        }else{ return "redirect:/usuario";}
    }
    @PostMapping(value = "/alterar/{id}")
    public  String updateUser(@PathVariable Integer id, UserModel userModel){
        Optional<UserModel> user= userService.findById(id);
        if(user.isPresent()){
            userService.save(userModel);
            return "redirect:/usuario";
        }else {
            return"redirect:/usuario";
        }
    }
    @GetMapping(value = "/delete/{id}")
    public  String deleteUserById(@PathVariable Integer id){
        userService.deleteUserById(id);
        return "redirect:/usuario";
    }



}