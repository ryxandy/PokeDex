package com.ryxandy.pokedex.Repository;

import com.ryxandy.pokedex.Model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;
import java.util.List;
import java.util.Optional;

@Repository
public interface PokemonRepository extends CrudRepository<Pokemon,Integer> {
    public List<Pokemon> findByName(String name);
}
