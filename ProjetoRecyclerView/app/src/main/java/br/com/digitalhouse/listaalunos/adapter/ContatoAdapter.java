package br.com.digitalhouse.listaalunos.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import br.com.digitalhouse.listaalunos.R;
import br.com.digitalhouse.listaalunos.model.Contatos;

public class ContatoAdapter extends RecyclerView.Adapter<ContatoAdapter.ViewHolder>{

    private List<Contatos> listaContatos;

    public ContatoAdapter(List<Contatos> listaContatos) {
        this.listaContatos = listaContatos;
    }


    //Método que infla o layout do item e retorna uma nova instancia da classe ViewHolder
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_lista,viewGroup, false);
        return new ViewHolder(view);
    }

    //Método que possui um objeto que recebe o valor de acordo com a posição da lista
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int posicao) {
        Contatos contato = listaContatos.get(posicao);

        //chama o método onBind a partir do viewHolder passando o objeto como parametro
        viewHolder.onBind(contato);
    }

    //Método que retorna o tamanho da lista
    @Override
    public int getItemCount() {
        return listaContatos.size();
    }

    //CLASSE A VIEWHOLDER
    public class ViewHolder extends RecyclerView.ViewHolder {
        //Declaração dos componentes
        private TextView txtNome;
        private TextView txtTelefone;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtNome = itemView.findViewById(R.id.txtNome);
            txtTelefone = itemView.findViewById(R.id.txtTelefone);
        }

        //Método que seta as informações nos componentes
        public void onBind(Contatos contato){

            txtNome.setText(contato.getNome());
            txtTelefone.setText(contato.getTelefone());

        }
    }
}

