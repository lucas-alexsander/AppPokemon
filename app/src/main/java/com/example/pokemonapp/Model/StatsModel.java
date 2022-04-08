package com.example.pokemonapp.Model;

import java.util.Objects;

public class StatsModel {
    private float base_stat;
    private float effort;
    private String name;
    private String url;

    public StatsModel(float base_stat, float effort, String name, String url) {
        this.base_stat = base_stat;
        this.effort = effort;
        this.name = name;
        this.url = url;
    }

    public float getBase_stat() {
        return base_stat;
    }

    public void setBase_stat(float base_stat) {
        this.base_stat = base_stat;
    }

    public float getEffort() {
        return effort;
    }

    public void setEffort(float effort) {
        this.effort = effort;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatsModel that = (StatsModel) o;
        return Float.compare(that.base_stat, base_stat) == 0 && Float.compare(that.effort, effort) == 0 && Objects.equals(name, that.name) && Objects.equals(url, that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(base_stat, effort, name, url);
    }
}
