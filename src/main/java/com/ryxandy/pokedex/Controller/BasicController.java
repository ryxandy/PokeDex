package com.ryxandy.pokedex.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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


}
