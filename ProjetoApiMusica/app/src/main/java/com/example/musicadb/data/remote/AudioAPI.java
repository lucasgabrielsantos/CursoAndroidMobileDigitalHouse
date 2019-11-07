package com.example.musicadb.data.remote;

import com.example.musicadb.pojo.Artista;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AudioAPI {

    @GET("search.php")
    Observable<Artista> getAllAlbumList(
        @Query("s") String artista);
    }

