package br.com.digitalhouse.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;


/**
 * A simple {@link Fragment} subclass.
 */

public class BarcelonaFragment extends Fragment {

    Button barcatitulo;


    public BarcelonaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_barcelona, container, false);

        barcatitulo = view.findViewById(R.id.Titulobarca);
        barcatitulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "5 Champions League", Snackbar.LENGTH_LONG).show();
            }
        });
        return view;
    }
}