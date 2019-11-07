package com.example.musicadb.data.remote;

import com.example.musicadb.pojo.Artistas;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AudioAPI {

    @GET("mostloved.php")
    Observable<Artistas> getAllAlbumList(
        @Query("format") String artista);
    }

