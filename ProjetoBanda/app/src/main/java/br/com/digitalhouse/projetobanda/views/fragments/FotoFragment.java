package br.com.digitalhouse.projetobanda.views.fragments;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import br.com.digitalhouse.projetobanda.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FotoFragment extends Fragment {
    private static final String NOME = "nome";
    private static final String IMAGEM = "imagem";
    private TextView txtNomeAlbum;
    private ImageView imgAlbum;


    public FotoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_foto, container, false);

        txtNomeAlbum = view.findViewById(R.id.nomeAlbum);
        imgAlbum = view.findViewById(R.id.imagemAlbum);


        if (getArguments() != null) {

            int imagemRecebida = getArguments().getInt(IMAGEM);
            String nomeRecebido = getArguments().getString(NOME);

            Drawable drawable = getResources().getDrawable(imagemRecebida);

            imgAlbum.setImageDrawable(drawable);
            txtNomeAlbum.setText(nomeRecebido);

        }

        return view;
    }

    public static Fragment novaInstancia(int imagem, String nomeAlbum) {

        FotoFragment fotoFragment = new FotoFragment();
        Bundle bundle = new Bundle();

        bundle.putInt(IMAGEM, imagem);
        bundle.putString(NOME, nomeAlbum);

        fotoFragment.setArguments(bundle);

        return fotoFragment;
    }
}
