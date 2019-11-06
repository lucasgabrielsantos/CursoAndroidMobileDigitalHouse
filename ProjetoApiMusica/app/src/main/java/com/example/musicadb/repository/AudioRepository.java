package com.example.musicadb.repository;

import com.example.musicadb.pojo.Artista;

import io.reactivex.Observable;

import static com.example.musicadb.data.remote.RetroFitService.getApiService;

public class AudioRepository {

    public Observable<Artista> getAlbum(String artista){
        return getApiService().getAllAlbumList(artista);
    }
}
