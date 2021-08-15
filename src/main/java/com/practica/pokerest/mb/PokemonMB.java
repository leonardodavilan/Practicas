package com.practica.pokerest.mb;

import com.google.gson.Gson;
import com.practica.pokerest.bean.Pokemon;
import com.practica.pokerest.util.UtilREST;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.List;

@Named("pokemonMB")
@ViewScoped
public class PokemonMB implements Serializable {

    String uri="https://pokeapi.co/api/v2/pokemon";


    private Pokemon[] pokemons;

    @PostConstruct
    public void init() {
        this.listar();
    }

    public void listar() {
        try {
            Gson gson = new Gson();
            pokemons = gson.fromJson(UtilREST.getREST(uri), Pokemon[].class);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Pokemon[] getPokemons() {
        return pokemons;
    }

}
