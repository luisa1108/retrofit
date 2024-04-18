package com.moviles.api.modelos;

public class Pokemon {
    private String name,url;
    private int number;

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

    public int getNumber(){
        //toma la url y la secciona por el /
        String [] numeroPokemon = url.split("/");
        return Integer.parseInt(numeroPokemon[numeroPokemon.length -1]);
    }

    public void setnumber(int number){
        this.number = number;
    }
}
