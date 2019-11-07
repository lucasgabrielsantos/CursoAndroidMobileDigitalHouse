package com.example.musicadb.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.musicadb.pojo.Artist;
import com.example.musicadb.pojo.Artista;
import com.example.musicadb.repository.AudioRepository;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class ViewModelMusica extends AndroidViewModel {

    private MutableLiveData<List<Artist>> listaAlbum = new MutableLiveData<>();
    private MutableLiveData<Boolean> loading = new MutableLiveData<>();
    private CompositeDisposable disposable = new CompositeDisposable();
    private AudioRepository repository = new AudioRepository();

    public ViewModelMusica(@NonNull Application application) {

        super(application);
    }

    public LiveData<List<Artist>> getListaAlbum() {
        return this.listaAlbum;
    }

    public MutableLiveData<Boolean> loading() {
        return this.loading;
    }


    public void getAllAlbuns(String apiKey) {
        disposable.add(
                repository.getAlbumList(apiKey)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe(disposable1 -> loading.setValue(true))
                        .doOnTerminate(() -> loading.setValue(false))
                        .subscribe((Artista artista) -> {
                                    listaAlbum.setValue(artista.getArtists());
                                },
                                throwable -> {
                                    Log.i("LOG", "erro" + throwable.getMessage());
                                })
        );
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }
}
