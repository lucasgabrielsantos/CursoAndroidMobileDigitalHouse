package br.com.digitalhouse.appmytasks.views.fragments;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

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
public class NovaTarefaFragment extends Fragment {
    private TextInputLayout nome;
    private TextInputLayout descricao;
    private FloatingActionButton btnAdd;
    private RecyclerView recyclerView;
    private RecyclerViewTarefaAdapter adapter;
    private List<Tarefa> tarefaList = new ArrayList<>();

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


            //TODO: Desenvolver a ação de inserção dos dados no BD

            if (!nomeTarefa.isEmpty() && !descricaoTarefa.isEmpty()) {

                new Thread(() -> {

                    Tarefa tarefa = new Tarefa(nomeTarefa, descricaoTarefa);

                    if (tarefa != null) {

                        tarefaDao.insereTarefa(tarefa);
                    }

                }).start();

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

        //TODO: inicializar o DAO
        tarefaDao = DatabaseLocal.getDatabase(getActivity()).tarefaDao();
    }

    private void buscaTodosTarefas() {

        //Chama o método que retorna os dados no bd , lembrando que esse método retorna um Observable
        tarefaDao.getAllTarefas()
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
