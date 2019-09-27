package br.com.digitalhouse.revisaoactivitys.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import br.com.digitalhouse.revisaoactivitys.Interface.Comunicador;
import br.com.digitalhouse.revisaoactivitys.R;
import br.com.digitalhouse.revisaoactivitys.model.Animal;

public class ButtonFragment extends Fragment {
    private Button btnCachorro;
    private Button btnGato;
    private Comunicador comunicador;


    public ButtonFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
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
        View view = inflater.inflate(R.layout.fragment_button, container, false);
        initView(view);

        btnCachorro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animal cachorro = new Animal(R.drawable.cachorro, "DOG LINDO");
                comunicador.recebeMensagem(cachorro);
            }
        });


        btnGato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animal gato = new Animal(R.drawable.gato, "GATO FDP");
                comunicador.recebeMensagem(gato);
            }
        });

        return view;
    }

    public void initView(View view){
        btnCachorro = view.findViewById(R.id.btn_cachorro);
        btnGato = view.findViewById(R.id.btn_gato);
    }

}