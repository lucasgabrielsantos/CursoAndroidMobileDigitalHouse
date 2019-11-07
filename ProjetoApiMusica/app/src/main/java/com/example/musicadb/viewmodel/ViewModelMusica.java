package com.example.musicadb.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.musicadb.pojo.Artistas;
import com.example.musicadb.pojo.Loved;
import com.example.musicadb.repository.AudioRepository;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class ViewModelMusica extends AndroidViewModel {

    private MutableLiveData<List<Loved>> listaAlbum = new MutableLiveData<>();
    private MutableLiveData<Boolean> loading = new MutableLiveData<>();
    private CompositeDisposable disposable = new CompositeDisposable();
    private AudioRepository repository = new AudioRepository();

    public ViewModelMusica(@NonNull Application application) {

        super(application);
    }

    public LiveData<List<Loved>> getListaAlbum() {
        return this.listaAlbum;
    }

    public MutableLiveData<Boolean> loading() {
        return this.loading;
    }


    public void getAllAlbuns(String nomemusica) {
        disposable.add(
                repository.getAlbumList(nomemusica)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe(disposable1 -> loading.setValue(true))
                        .doOnTerminate(() -> loading.setValue(false))
                        .subscribe((Artistas artista) -> {
                                    listaAlbum.setValue(artista.getLoved());
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
