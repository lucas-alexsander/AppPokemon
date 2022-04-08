package com.example.pokemonapp.Model;

import java.util.List;

public class PokemonModel {

    String name;
    String url;
    String sprint_url;
    List<MoveModel> abilities;
    List<StatsModel> stats;
    double weight;

    public PokemonModel(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public PokemonModel(String name, String url, String sprint_url, List<MoveModel> abilities, List<StatsModel> stats, double weight) {
        this.name = name;
        this.url = url;
        this.sprint_url = sprint_url;
        this.abilities = abilities;
        this.stats = stats;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSprint_url() {
        return sprint_url;
    }

    public void setSprint_url(String sprint_url) {
        this.sprint_url = sprint_url;
    }

    public List<MoveModel> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<MoveModel> abilities) {
        this.abilities = abilities;
    }

    public List<StatsModel> getStats() {
        return stats;
    }

    public void setStats(List<StatsModel> stats) {
        this.stats = stats;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }


}
