package com.ryxandy.pokedex.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BasicController {

    @GetMapping("/")
    String login(){
        System.out.println("Entrou no Login");
        return "Login";
    }

    @PostMapping("/loginForm")
    String processLogin(Model model,String username, String password){
        if (username.equals("ash") && password.equals("88719588")){
            return "redirect:/home";
        }else
            model.addAttribute("fail", 1);
        return "redirect:/";

    }

    @GetMapping(path = "/register")
    String register(){
        return "Register";
    }


}
