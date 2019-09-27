package br.com.digitalhouse.comunicacaoactivity.views;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import br.com.digitalhouse.comunicacaoactivity.R;
import br.com.digitalhouse.comunicacaoactivity.interfaces.Comunicador;
import br.com.digitalhouse.comunicacaoactivity.model.SistemaOperacional;


/**
 * A simple {@link Fragment} subclass.
 */
public class SistemaFragment extends Fragment {


    private Button btnandroid;
    private Button btnios;
    private Comunicador comunicador;

    public SistemaFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            comunicador = (Comunicador) context;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sistema, container, false);

        initViews(view);

        btnandroid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SistemaOperacional android = new SistemaOperacional(R.drawable.androiddd, "ANDROID");
                comunicador.receberMensagem(android);
            }
        });

        btnios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SistemaOperacional ios = new SistemaOperacional(R.drawable.ios, "IOS");
                comunicador.receberMensagem(ios);
            }
        });
        return view;
    }

    public void initViews(View view) {
        btnandroid = view.findViewById(R.id.btnandroid);
        btnios = view.findViewById(R.id.btnios);
    }
}
