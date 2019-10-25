package br.com.digitalhouse.appmytasks.views.fragments;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.appmytasks.R;
import br.com.digitalhouse.appmytasks.model.data.DatabaseLocal;
import br.com.digitalhouse.appmytasks.model.data.TarefaDao;
import br.com.digitalhouse.appmytasks.model.pojos.Tarefa;
import br.com.digitalhouse.appmytasks.viewmodel.viewmodelfragment.HomeFragmentViewModel;
import br.com.digitalhouse.appmytasks.viewmodel.viewmodelfragment.NovaTarefaFragmentViewModel;
import br.com.digitalhouse.appmytasks.viewmodel.viewmodelfragment.TodasTarefasFragmentViewModel;
import br.com.digitalhouse.appmytasks.views.adapter.RecyclerViewTarefaAdapter;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 */
public class NovaTarefaFragment extends Fragment {
    private TextInputLayout nome;
    private TextInputLayout descricao;
    private FloatingActionButton btnAdd;
    private RecyclerView recyclerView;
    private RecyclerViewTarefaAdapter adapter;
    private List<Tarefa> tarefaList = new ArrayList<>();
    private NovaTarefaFragmentViewModel viewModel;

    private TarefaDao tarefaDao;

    public NovaTarefaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_nova_tarefa, container, false);

        initViews(view);

        btnAdd.setOnClickListener(v -> {
            String nomeTarefa = nome.getEditText().getText().toString();
            String descricaoTarefa = descricao.getEditText().getText().toString();

            if (!nomeTarefa.isEmpty() && !descricaoTarefa.isEmpty()) {

                Tarefa tarefa = new Tarefa(nomeTarefa, descricaoTarefa);

                //Método que insere a nova tarefa no banco de dados
                viewModel.insereTarefaNoBanco(tarefa);

                nome.getEditText().setText("");
                descricao.getEditText().setText("");

                Snackbar.make(nome, "Dado salvo com sucesso!", Snackbar.LENGTH_LONG).show();

            } else {
                nome.setError("Preencha o campo de nome");
                descricao.setError("Preencha o campo de descrição");
            }

        });

        return view;
    }

    private void initViews(View view) {
        nome = view.findViewById(R.id.textInpuLayoutNome);
        descricao = view.findViewById(R.id.textInputLayoutDescricao);
        btnAdd = view.findViewById(R.id.floatingActionButtonSalvar);
        viewModel = ViewModelProviders.of(this).get(NovaTarefaFragmentViewModel.class);

    }


}
