package br.com.digitalhouse.appmytasks.views.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.appmytasks.R;
import br.com.digitalhouse.appmytasks.model.pojos.Tarefa;
import br.com.digitalhouse.appmytasks.viewmodel.viewmodelfragment.TodasTarefasFragmentViewModel;
import br.com.digitalhouse.appmytasks.views.adapter.RecyclerViewTarefaAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class TodasTarefasFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerViewTarefaAdapter adapter;
    private List<Tarefa> tarefaList = new ArrayList<>();
    private TodasTarefasFragmentViewModel viewModel;

    public TodasTarefasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_todas_tarefas, container, false);

        //TODO: Fazer as chamadas necessárias quando inicializado o fragmento

        initViews(view);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        //Método que busca as tarefas recentes
        viewModel.buscaTodasTarefas();

        /*Método que retorna o valor da lista de tarefas onde é atribuido para o adapter a lista retornada
        Nesse método é passado o proprietário que nesse caso é o fragment como primeiro parametro
        E no segundo parametro é passado o objeto Observer que será chamado quando a mudança acontecer
        É nesse método que a interface gráfica deve ser atualiada com os novos dados vindo do viewmodel
        */
        viewModel.retornaTodasTarefas().observe(this, tarefas -> {
            adapter.atualizaListaTarefa(tarefas);
        });

        return view;
    }


    private void initViews(View view) {
        recyclerView = view.findViewById(R.id.recyclerViewTodasTarefas);
        adapter = new RecyclerViewTarefaAdapter(tarefaList);
        viewModel = ViewModelProviders.of(this).get(TodasTarefasFragmentViewModel.class);


    }

    //TODO: Desenvolver o método que busca todas as tarefas


}