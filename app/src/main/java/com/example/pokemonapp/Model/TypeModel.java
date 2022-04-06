package com.example.pokemonapp.Model;

import java.util.Objects;

public class TypeModel {

    String name;
    String url;

    public TypeModel(String name, String url) {
        this.name = name;
        this.url = url;
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
        TypeModel typeModel = (TypeModel) o;
        return Objects.equals(name, typeModel.name) && Objects.equals(url, typeModel.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, url);
    }


}
