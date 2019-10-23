package br.com.digitalhouse.appmytasks.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.digitalhouse.appmytasks.R;
import br.com.digitalhouse.appmytasks.model.Tarefa;

public class RecyclerViewTarefaAdapter extends RecyclerView.Adapter<RecyclerViewTarefaAdapter.ViewHolder> {

    private List<Tarefa> tarefaList;

    public RecyclerViewTarefaAdapter(List<Tarefa> tarefaList) {
        this.tarefaList = tarefaList;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_view_tarefas, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Tarefa tarefa = tarefaList.get(position);
        holder.onBind(tarefa);
    }

    @Override
    public int getItemCount() {
        return tarefaList.size();
    }


    public void atualizaListaTarefa(List<Tarefa> listaProdutos) {
        this.tarefaList.clear();
        this.tarefaList = listaProdutos;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nome;
        private TextView descricao;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nome = itemView.findViewById(R.id.textViewNomeTarefa);
            descricao = itemView.findViewById(R.id.textViewDescricaoTarefa);

            itemView.setOnClickListener(v -> {
                int descriptionState = descricao.getVisibility();
                if (descriptionState == View.VISIBLE) {
                    toggleDescription(false);
                } else {
                    toggleDescription(true);
                }
            });
        }

        private void toggleDescription(boolean show) {
            if (show) {
                descricao.setVisibility(View.VISIBLE);
            } else {
                descricao.setVisibility(View.GONE);
            }
        }

        public void onBind(Tarefa tarefa) {
            nome.setText(tarefa.getNome());
            descricao.setText(tarefa.getDescricao());
        }
    }
}
