
package com.example.musicadb.pojo;

import java.util.List;
import com.google.gson.annotations.Expose;

@SuppressWarnings("unused")
public class Artista {

    @Expose
    private List<Artist> artists;

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

}
