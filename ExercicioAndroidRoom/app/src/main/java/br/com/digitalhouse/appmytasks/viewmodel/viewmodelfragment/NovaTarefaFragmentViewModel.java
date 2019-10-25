package br.com.digitalhouse.appmytasks.viewmodel.viewmodelfragment;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import br.com.digitalhouse.appmytasks.model.data.DatabaseLocal;
import br.com.digitalhouse.appmytasks.model.data.TarefaDao;
import br.com.digitalhouse.appmytasks.model.pojos.Tarefa;
import io.reactivex.disposables.CompositeDisposable;

public class NovaTarefaFragmentViewModel extends AndroidViewModel {
    private MutableLiveData<Tarefa> tarefa = new MutableLiveData<>();
    private TarefaDao tarefaDao = DatabaseLocal.getDatabase(getApplication()).tarefaDao();
    private CompositeDisposable disposable = new CompositeDisposable();


    public NovaTarefaFragmentViewModel(@NonNull Application application) {
        super(application);
    }


    public LiveData<Tarefa> retornaLista() {
        return this.tarefa;
    }

    public void insereTarefaNoBanco(Tarefa tarefa) {

        new Thread(() -> {
            if (tarefa != null) {
                tarefaDao.insereTarefa(tarefa);
            }
        }).start();
        this.tarefa.setValue(tarefa);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }
}
