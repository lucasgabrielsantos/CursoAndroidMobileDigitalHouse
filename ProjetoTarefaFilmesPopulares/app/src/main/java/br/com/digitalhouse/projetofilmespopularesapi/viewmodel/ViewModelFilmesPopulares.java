package br.com.digitalhouse.projetofilmespopularesapi.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import br.com.digitalhouse.projetofilmespopularesapi.model.FilmePopular;
import br.com.digitalhouse.projetofilmespopularesapi.model.Result;
import br.com.digitalhouse.projetofilmespopularesapi.repository.FilmePopularRepository;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class ViewModelFilmesPopulares extends AndroidViewModel {

    private MutableLiveData<List<Result>> listaFilmePop = new MutableLiveData<>();
    private MutableLiveData<Boolean> loading = new MutableLiveData<>();
    private CompositeDisposable disposable = new CompositeDisposable();
    private FilmePopularRepository repository = new FilmePopularRepository();

    public ViewModelFilmesPopulares(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Result>> getListaFilmePopular() {

        return this.listaFilmePop;
    }

    public MutableLiveData<Boolean> loading() {
        return this.loading;
    }


    public void GetAllFilmesPopulares(String apiKey) {
        disposable.add(
                repository.getFilmesPop(apiKey)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe(disposable1 -> loading.setValue(true))
                        .doOnTerminate(() -> loading.setValue(false))
                        .subscribe(filmeResult -> listaFilmePop.setValue(filmeResult.getResults()),
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
