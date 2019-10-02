package br.com.digitalhouse.listaanimais.adapter;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import br.com.digitalhouse.listaanimais.Interface.RecyclerViewOnClick;
import br.com.digitalhouse.listaanimais.R;
import br.com.digitalhouse.listaanimais.model.Animal;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.ViewHolder> {

    private List<Animal> listaAnimais;
    private RecyclerViewOnClick listener;


    public AnimalAdapter(List<Animal> listaAnimais, RecyclerViewOnClick listener) {
        this.listaAnimais = listaAnimais;
        this.listener = listener;
    }

    @NonNull
    @Override
    public AnimalAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_lista, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalAdapter.ViewHolder viewHolder, int position) {
        final Animal animal = listaAnimais.get(position);

        viewHolder.onBind(animal);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.OnClick(animal);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaAnimais.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textnome;
        private ImageView imagem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textnome = itemView.findViewById(R.id.textViewNome);
            imagem = itemView.findViewById(R.id.imageView);
        }

        //Método que seta as informações nos componentes
        public void onBind(Animal animal) {
            Drawable drawable = itemView.getResources().getDrawable(animal.getImagem());
            imagem.setImageDrawable(drawable);
            textnome.setText(animal.getNome());

        }
    }
}
