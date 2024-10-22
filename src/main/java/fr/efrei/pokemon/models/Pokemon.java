package fr.efrei.pokemon.models;

import fr.efrei.pokemon.constants.Type;
import jakarta.persistence.*;

@Entity
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)// AUTO INCREMENT

    private String id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Type type;

    private int level;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public  Pokemon() {
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

}
