package com.ryxandy.pokedex.Resources;


import com.ryxandy.pokedex.Model.Pokemon;
import com.ryxandy.pokedex.Repository.PokemonRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(value = "/api")
public class PokemonResource {

    @Autowired
    PokemonRepository pokeRepo;


    @GetMapping(path = "/pokemons")
    @ApiOperation(value = "Show all pokemons")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Pokemon> getAllPokemons(){
        System.out.println("Retrieving all Pokemons, wait a sec...");
        return (List<Pokemon>) pokeRepo.findAll();
    }

    @DeleteMapping(path = "/pokemon/{id}")
    @ApiOperation(value = "Delete one pokemon using id as parameter")
    @ResponseStatus(HttpStatus.OK)
    public void deletePokemon(@PathVariable int id){
        System.out.println("Deleting the selected Pokemon, wait a sec...");
        pokeRepo.deleteById(id);
    }



    @GetMapping(path = "/pokemon/{name}")
    @ApiOperation(value = "Find one pokemon using name as parameter")
    @ResponseStatus(HttpStatus.OK)
    public List<Pokemon> findByName(@PathVariable String name){
        return pokeRepo.findByName(name);
    }


    @PostMapping(path = "/pokemon")
    @ApiOperation(value = "Create a new Pokemon")
    public ResponseEntity<Pokemon> createPokemon(@Validated @RequestBody Pokemon pokemon){
        pokeRepo.save(pokemon);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> errorDealer(MethodArgumentNotValidException e){
        Map<String, String> erros = new HashMap<>();

        e.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            erros.put(fieldName,errorMessage);
        });

     return erros;
    }

}
