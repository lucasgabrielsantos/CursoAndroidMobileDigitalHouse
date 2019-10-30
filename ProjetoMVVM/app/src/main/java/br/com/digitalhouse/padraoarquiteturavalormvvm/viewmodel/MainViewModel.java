package br.com.digitalhouse.padraoarquiteturavalormvvm.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class MainViewModel extends AndroidViewModel {
    private MutableLiveData<Integer> valor = new MutableLiveData<>();

    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Integer> retornaValor(){

        return valor;
    }

    public void somaValor(Integer valor){
        Integer soma = valor + 1;

        this.valor.setValue(soma);

    }


}


