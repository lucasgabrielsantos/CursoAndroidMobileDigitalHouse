
package com.example.musicadb.pojo;

import com.google.gson.annotations.Expose;

import java.util.List;

@SuppressWarnings("unused")
public class Artistas {

    @Expose
    private List<Loved> loved;

    public List<Loved> getLoved() {
        return loved;
    }

    public void setLoved(List<Loved> loved) {
        this.loved = loved;
    }

}
