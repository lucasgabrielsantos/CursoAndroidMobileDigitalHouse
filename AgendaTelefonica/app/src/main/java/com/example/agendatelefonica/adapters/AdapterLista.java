package com.example.agendatelefonica.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.agendatelefonica.R;
import com.example.agendatelefonica.models.Pessoa;

import java.util.List;

public class AdapterLista extends RecyclerView.Adapter<AdapterLista.ViewHolder> {

    private TextView nomePessoa;
    private TextView telefonePessoa;
    private List<Pessoa> listaPessoas;

    public AdapterLista(List<Pessoa> listaPessoas) {
        this.listaPessoas = listaPessoas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Pessoa pessoa = listaPessoas.get(position);
        holder.bind(pessoa);
    }

    @Override
    public int getItemCount() {
        return listaPessoas.size();
    }

    public void atualizaListaPessoas(List<Pessoa> pessoasList){
        this.listaPessoas.clear();
        this.listaPessoas = pessoasList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nomePessoa = itemView.findViewById(R.id.nomeList);
            telefonePessoa = itemView.findViewById(R.id.telefoneList);

        }
        public void bind(Pessoa pessoa){
            nomePessoa.setText(pessoa.getNome());
            telefonePessoa.setText(pessoa.getTelefone());
        }
    }
}
