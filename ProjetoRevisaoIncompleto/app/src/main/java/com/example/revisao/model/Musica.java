package com.example.revisao.model;

public class Musica {

    private String nomecantor,nomemusica;

    public Musica(){

    }

    public Musica(String nomecantor, String nomemusica) {
        this.nomecantor = nomecantor;
        this.nomemusica = nomemusica;
    }

    public String getNomecantor() {
        return nomecantor;
    }

    public void setNomecantor(String nomecantor) {
        this.nomecantor = nomecantor;
    }

    public String getNomemusica() {
        return nomemusica;
    }

    public void setNomemusica(String nomemusica) {
        this.nomemusica = nomemusica;
    }
}
