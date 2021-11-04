package com.ryxandy.pokedex.Controller;

import com.ryxandy.pokedex.Model.Pokemon;
import com.ryxandy.pokedex.Repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class PokemonController {

    @Autowired
    PokemonRepository pokemonRepository;

    @Autowired
    Optional<Pokemon> pokemon;

    @GetMapping("/addPokemon")
    String showAddPage(Model model){
        model.addAttribute("pokemon", new Pokemon());
        return "addPokemon";
    }

    @PostMapping("/addPokemon")
    String addPokemon(@Valid Pokemon pokemon){
        System.out.println("Starting to create and adding your pokemon... ");
        System.out.println(pokemon.getName() + "" + pokemon.getType());
        pokemonRepository.save(pokemon);
        return "redirect:/home";
    }

    @GetMapping("/about")
    String About(Model model){
        return "About";
    }

    @GetMapping("/home")
    String home(Model model){
        model.addAttribute("Pokemons", pokemonRepository.findAll());
        System.out.println("Entrou no Home");
        return "Home";
    }

    @GetMapping(path = "/home/delete/{id}")
    public String deletePokemon(@PathVariable int id) {
            Optional<Pokemon> pokemon = pokemonRepository.findById(id);
            if (pokemon.isPresent()){
                pokemonRepository.delete(pokemon.get());
                return "redirect:/home";
            }
             return "Home";
        }

    @PostMapping("/editPokemon")
    String editPokemon(@Valid Pokemon pokemons){
        pokemonRepository.save(pokemons);
        return "redirect:/home";
     }
}



