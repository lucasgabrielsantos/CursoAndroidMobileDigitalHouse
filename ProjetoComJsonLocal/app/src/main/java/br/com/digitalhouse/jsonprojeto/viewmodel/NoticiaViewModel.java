package br.com.digitalhouse.jsonprojeto.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import br.com.digitalhouse.jsonprojeto.model.Noticia;
import br.com.digitalhouse.jsonprojeto.repository.NoticiaRepository;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class NoticiaViewModel extends AndroidViewModel {
    private MutableLiveData<List<Noticia>> listnoticia = new MutableLiveData<>();
    private MutableLiveData<Boolean> loading = new MutableLiveData<>();
    private NoticiaRepository repository = new NoticiaRepository();
    private CompositeDisposable disposable = new CompositeDisposable();


    public NoticiaViewModel(@NonNull Application application) {
        super(application);

    }

    public LiveData<List<Noticia>> retornaNoticias() {
        return this.listnoticia;
    }

    public LiveData<Boolean> retornaValorLoading() {
        return this.loading;
    }

    public void buscaNoticias() {
        disposable.add(
                repository.obterListaNoticias(getApplication().getApplicationContext())
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe(disposable -> loading.setValue(true))
                        .doAfterTerminate(() -> loading.setValue(false))
                        .subscribe(noticiaResposta -> {
                            listnoticia.setValue(noticiaResposta.getNoticias());
                        }, throwable -> {
                            Log.i("LOG", "busca noticias" + throwable.getMessage());
                        })
        );
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }
}
