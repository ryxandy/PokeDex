package com.ryxandy.pokedex.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Pokemon {
    @Id
    @GeneratedValue
    private int id;

    private String name;

    private String type;

    private String weakness;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWeakness() {
        return weakness;
    }

    public void setWeakness(String weakness) {
        this.weakness = weakness;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pokemon pokemon = (Pokemon) o;
        return id == pokemon.id && Objects.equals(name, pokemon.name) && Objects.equals(type, pokemon.type) && Objects.equals(weakness, pokemon.weakness);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type, weakness);
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", weakness='" + weakness + '\'' +
                '}';
    }
}
