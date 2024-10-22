package fr.efrei.pokemon.dto;

import fr.efrei.pokemon.models.Shop;

import java.util.List;

public class CreateTrainer {

    private String name;

    private List<String> team;

    private int money;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getTeam() {
        return team;
    }

    public void setTeam(List<String> team) {
        this.team = team;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}