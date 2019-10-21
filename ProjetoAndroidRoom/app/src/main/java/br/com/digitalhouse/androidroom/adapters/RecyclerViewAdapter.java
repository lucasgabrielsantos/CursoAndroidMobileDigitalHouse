package br.com.digitalhouse.androidroom.adapters;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.digitalhouse.androidroom.Interfaces.OnClick;
import br.com.digitalhouse.androidroom.R;
import br.com.digitalhouse.androidroom.models.Produto;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<Produto> produtoList;
    private OnClick listener;

    public RecyclerViewAdapter(List<Produto> produtoList, OnClick listener) {
        this.produtoList = produtoList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_produtos_recyclerview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Produto produto = produtoList.get(position);
        holder.onBind(produto);

        holder.itemView.setOnClickListener(v -> {
            listener.OnClick(produto);
        });

    }

    @Override
    public int getItemCount() {
        return produtoList.size();
    }

    //Método que atualiza a lista de produtos
    public void atualizaListaProduto(List<Produto> listaProdutos) {
        this.produtoList.clear();
        this.produtoList = listaProdutos;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nome;
        private TextView preco;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nome = itemView.findViewById(R.id.textViewNome);
            preco = itemView.findViewById(R.id.textViewPreco);
        }

        public void onBind(Produto produto) {

            nome.setText(produto.getNomeProduto());
            String precoString = String.valueOf(produto.getPreco());
            preco.setText(precoString);
        }
    }
}

