package com.senai.projetoweb.controllers;

import com.senai.projetoweb.models.UserModel;
import com.senai.projetoweb.services.LoginService;
import com.senai.projetoweb.services.CookieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;

    @GetMapping(value = "/login")
    public String loginIndex() {
        return "login/login";
    }

    @PostMapping(value = "/logar")
    public String logon(UserModel userModel, Model model, HttpServletResponse response) {
        UserModel user = loginService.logar(userModel);
        if (user != null) {
            int tempoCookie = 10; // 10 segundos de cookie (apenas para exemplo)
            if (user != null) {
                tempoCookie = 60 * 60 * 24 * 365; // 1 ano de cookie
            }
            CookieService.setCookie(response, "id", String.valueOf(user.getId()), tempoCookie);
            CookieService.setCookie(response, "name", user.getName(), tempoCookie);
            return "redirect:/";
        } else {
            CookieService.deleteCookie(response, "id");
            CookieService.deleteCookie(response, "name");
            model.addAttribute("erro", "EMAIL ou SENHA inválidos!");
            return "login/login";
        }
    }

}
