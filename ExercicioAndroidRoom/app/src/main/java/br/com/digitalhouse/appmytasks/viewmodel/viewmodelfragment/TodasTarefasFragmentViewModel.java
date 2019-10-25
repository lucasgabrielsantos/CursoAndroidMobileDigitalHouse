package br.com.digitalhouse.appmytasks.viewmodel.viewmodelfragment;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import br.com.digitalhouse.appmytasks.model.data.DatabaseLocal;
import br.com.digitalhouse.appmytasks.model.data.TarefaDao;
import br.com.digitalhouse.appmytasks.model.pojos.Tarefa;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class TodasTarefasFragmentViewModel extends AndroidViewModel {
    private MutableLiveData<List<Tarefa>> listaTarefas = new MutableLiveData<>();
    private TarefaDao tarefaDao = DatabaseLocal.getDatabase(getApplication()).tarefaDao();
    private CompositeDisposable disposable = new CompositeDisposable();

    public TodasTarefasFragmentViewModel(@NonNull Application application) {

        super(application);
    }

    public LiveData<List<Tarefa>> retornaTodasTarefas() {
        return this.listaTarefas;
    }

    public void buscaTodasTarefas() {
        disposable.add(
                tarefaDao.getAllTarefas()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(tarefas -> {
                                    listaTarefas.setValue(tarefas);
                                },
                                throwable -> {
                                    Log.i("LOG", "Tarefas recentes " + throwable.getMessage());
                                })
        );
    }
}
