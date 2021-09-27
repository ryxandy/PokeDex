package com.ryxandy.pokedex.Controller;

import com.ryxandy.pokedex.Model.Pokemon;
import com.ryxandy.pokedex.Repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
        System.out.println("Starting to create adding your pokemon... ");
        return "addPokemon";
    }

    @PostMapping("/addPokemon")
    String addPokemon(Pokemon pokemon){
        System.out.println("Starting to create and adding your pokemon... ");
        return "redirect:/home";
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

    @PostMapping(path = "/home/edit/{id}")
    public String editPokemon(Model model,@PathVariable int id) {
        System.out.println("Entrei no método do edit");
        Optional<Pokemon> pokemon = pokemonRepository.findById(id);
        if (pokemon.isPresent()){
            model.addAttribute("PokemonEdit", pokemon);
            pokemonRepository.save(pokemon.get());
            return "redirect:/home";
        }
        return "Home";
      }
    }



