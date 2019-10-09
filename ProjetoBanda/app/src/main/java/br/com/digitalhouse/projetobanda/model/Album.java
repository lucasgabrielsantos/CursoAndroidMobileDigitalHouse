package br.com.digitalhouse.projetobanda.model;

import androidx.fragment.app.Fragment;

public class Album {

    private int imagem;
    private String nome;
    private Fragment fragment;


    public Album() {

    }

    public Album(String nome, Fragment fragment) {
        this.nome = nome;
        this.fragment = fragment;
    }

    public int getImagem() {
        return imagem;
    }

    public String getNome() {
        return nome;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }
}
