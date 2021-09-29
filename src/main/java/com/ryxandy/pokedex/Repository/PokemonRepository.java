package com.ryxandy.pokedex.Repository;

import com.ryxandy.pokedex.Model.Pokemon;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface PokemonRepository extends CrudRepository<Pokemon,Integer> {
    List<Pokemon> findByName(String name);

}
