package com.ryxandy.pokedex.Resources;


import com.ryxandy.pokedex.Model.Pokemon;
import com.ryxandy.pokedex.Repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class PokemonResource {

    @Autowired
    PokemonRepository pokeRepo;


    @GetMapping(path = "/api/pokemons")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Pokemon> getAllPokemons(){
        System.out.println("Retrieving all Pokemons, wait a sec...");
        return (List<Pokemon>) pokeRepo.findAll();
    }

    @DeleteMapping(path = "/api/pokemon/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePokemon(@PathVariable int id){
        System.out.println("Deleting the selected Pokemon, wait a sec...");
        pokeRepo.deleteById(id);
    }


    @GetMapping(path = "/api/pokemon/{name}")
    @ResponseStatus(HttpStatus.OK)
    public List<Pokemon> findByName(@PathVariable String name){
        return pokeRepo.findByName(name);
    }


    @PostMapping(path = "/api/pokemon")
    public ResponseEntity<Pokemon> createPokemon(@Validated @RequestBody Pokemon pokemon){
        pokeRepo.save(pokemon);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
