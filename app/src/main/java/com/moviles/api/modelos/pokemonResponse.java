package com.moviles.api.modelos;

import java.util.ArrayList;

public class pokemonResponse {
    private ArrayList<Pokemon> resultados;

    public ArrayList<Pokemon> getresults(){
        return resultados;
    }

    public void setResults(ArrayList<Pokemon> results){
        this.resultados = results;
    }
}
