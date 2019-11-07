package com.example.musicadb.repository;

import com.example.musicadb.pojo.Artistas;

import io.reactivex.Observable;

import static com.example.musicadb.data.remote.RetroFitService.getApiService;

public class AudioRepository {

    public Observable<Artistas> getAlbumList(String apiKey){
        return getApiService().getAllAlbumList(apiKey);
    }
}
