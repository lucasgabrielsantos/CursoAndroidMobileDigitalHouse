package br.com.digitalhouse.appmytasks.views.fragments;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.appmytasks.R;
import br.com.digitalhouse.appmytasks.adapter.RecyclerViewTarefaAdapter;
import br.com.digitalhouse.appmytasks.data.DatabaseLocal;
import br.com.digitalhouse.appmytasks.data.TarefaDao;
import br.com.digitalhouse.appmytasks.model.Tarefa;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerViewTarefaAdapter adapter;
    private List<Tarefa> tarefaList = new ArrayList<>();
    private TarefaDao tarefaDao;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        initViews(view);

        //TODO: Fazer as chamadas necessárias quando inicializado o fragmento

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        buscaTodosTarefasRecentes();
        return view;
    }

    private void initViews(View view) {
        recyclerView = view.findViewById(R.id.recyclerViewUltimasTarefas);
        adapter = new RecyclerViewTarefaAdapter(tarefaList);

        //TODO: inicializar o DAO
        tarefaDao = DatabaseLocal.getDatabase(getActivity()).tarefaDao();

    }

    //TODO: Desenvolver o método que busca as tarefas em ordem decrecente com um limite de 5 itens
    private void buscaTodosTarefasRecentes() {

        //Chama o método que retorna os dados no bd , lembrando que esse método retorna um Observable
        tarefaDao.getAllTarefasLimit()
                //SubscribeOn: determina em qual thread o observable irá emitir os dados
                .subscribeOn(Schedulers.io())
                //ObserveOn: determina em qual thread será executa quando os dados forem emitidos
                .observeOn(AndroidSchedulers.mainThread())
                //Assina o observer ao observable
                //Se for sucesso irá pegar a lista de tarefas e setar no método do adapter que atualiza a lista de tarefas
                .subscribe(tarefas -> {
                            adapter.atualizaListaTarefa(tarefas);
                        },

                        //Senão irá lançar uma exceção
                        throwable -> {
                            Log.i("TAG", "método getAllTarefa" + throwable.getMessage());
                        });
    }
}
