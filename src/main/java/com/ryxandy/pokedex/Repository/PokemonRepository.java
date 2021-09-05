package com.ryxandy.pokedex.Repository;

import com.ryxandy.pokedex.Model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon,Long> {
}
