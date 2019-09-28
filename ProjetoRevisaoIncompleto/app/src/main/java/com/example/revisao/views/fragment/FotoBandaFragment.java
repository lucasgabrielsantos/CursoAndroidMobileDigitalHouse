package com.example.revisao.views.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.revisao.R;
import com.example.revisao.views.activity.HomeActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class FotoBandaFragment extends Fragment {


    private static final String MSG_KEY = "mensagem";
    private TextView txtNomeBanda;
    private Button btnVoltar;

    public FotoBandaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //Implementar a lógica de verificação dos dados recebidos e setar o nome da banda no textView
        View view = inflater.inflate(R.layout.fragment_foto_banda, container, false);

        btnVoltar = view.findViewById(R.id.btnVoltar);
        txtNomeBanda = view.findViewById(R.id.textViewNomeBanda);

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeActivity contexto = (HomeActivity) getContext();
                contexto.replaceFragment(new BandaFragment());
            }
        });

        return view;
    }
}
