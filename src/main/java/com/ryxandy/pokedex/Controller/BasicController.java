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

    @GetMapping("/home")
    String home(){
        System.out.println("Entrou no Home");
        return "Home";
    }

    @PostMapping("/loginForm")
    String processLogin(Model model, String username, String password){
        System.out.println(username);
        if (username.equals("ash") && password.equals("88719588")){
            System.out.println("Logado com sucesso");
            return "Home";
        }
        System.out.println("Seu login falhou");
        model.addAttribute("failLogin",1 );
        return "Login";
    }


}
