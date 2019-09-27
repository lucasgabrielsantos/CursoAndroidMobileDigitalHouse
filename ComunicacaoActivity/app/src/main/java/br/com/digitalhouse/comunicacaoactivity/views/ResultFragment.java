package br.com.digitalhouse.comunicacaoactivity.views;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import br.com.digitalhouse.comunicacaoactivity.R;
import br.com.digitalhouse.comunicacaoactivity.model.SistemaOperacional;

import static br.com.digitalhouse.comunicacaoactivity.views.MainActivity.SO_KEY;


/**
 * A simple {@link Fragment} subclass.
 */
public class ResultFragment extends Fragment {

    private ImageView imagem;
    private TextView txtNome;

    public ResultFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_android, container, false);

        initView(view);

        if (!getArguments().isEmpty()) {
            SistemaOperacional sistemaOperacional = getArguments().getParcelable(SO_KEY);

            if (sistemaOperacional != null) {
                Drawable drawable = getResources().getDrawable(sistemaOperacional.getImagem());

                imagem.setImageDrawable(drawable);
                txtNome.setText(sistemaOperacional.getNome());
            }
        }
        return view;
    }

    private void initView(View view) {
        imagem = view.findViewById(R.id.imageAndroid);
        txtNome = view.findViewById(R.id.nomeandroid);
    }
}
