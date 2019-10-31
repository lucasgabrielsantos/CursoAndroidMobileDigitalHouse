package br.com.digitalhouse.projetoretrofitfilmes.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import br.com.digitalhouse.projetoretrofitfilmes.model.Result;
import br.com.digitalhouse.projetoretrofitfilmes.repository.FilmeRepository;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class ViewModelFilme extends AndroidViewModel {

    private MutableLiveData<List<Result>> listaFilme = new MutableLiveData<>();
    private MutableLiveData<Boolean> loading = new MutableLiveData<>();
    private CompositeDisposable disposable = new CompositeDisposable();
    private FilmeRepository repository = new FilmeRepository();

    public ViewModelFilme(@NonNull Application application) {

        super(application);

    }

    public LiveData<List<Result>> getListaFilme() {
        return this.listaFilme;
    }

    public MutableLiveData<Boolean> loading(){
        return this.loading;
    }

    public void getAllFilmes(String apiKey) {
        disposable.add(
                repository.getFilmes(apiKey)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe(disposable1 -> loading.setValue(true))
                        .doOnTerminate(() -> loading.setValue(false))
                        .subscribe(filmeResult -> listaFilme.setValue(filmeResult.getResults()),
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
