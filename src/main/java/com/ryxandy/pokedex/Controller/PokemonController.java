package com.ryxandy.pokedex.Controller;

import com.ryxandy.pokedex.Model.Pokemon;
import com.ryxandy.pokedex.Repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PokemonController {

    @Autowired
    PokemonRepository pokemonRepository;

    @GetMapping("/addPokemon")
    String showAddPage(Model model){
        model.addAttribute("pokemon", new Pokemon());
        System.out.println("Starting to create adding your pokemon... ");
        return "addPokemon";
    }

    @PostMapping("/addPokemon")
    String addPokemon(Pokemon pokemon){
        System.out.println("Starting to create and adding your pokemon... ");
        pokemonRepository.save(pokemon);
        return "redirect:/home";
    }

}
