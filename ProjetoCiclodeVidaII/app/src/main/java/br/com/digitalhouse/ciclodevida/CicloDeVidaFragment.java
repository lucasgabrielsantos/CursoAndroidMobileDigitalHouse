package br.com.digitalhouse.ciclodevida;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class CicloDeVidaFragment extends Fragment {


    public CicloDeVidaFragment() {
        // Required empty public constructor

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.i("CICLO", "FRAGMENT: Metodo OnAttach()");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("CICLO", "FRAGMENT: Metodo OnCreate()");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.i("CICLO", "FRAGMENT: Metodo OnCreateView()");
        return inflater.inflate(R.layout.fragment_ciclo_de_vida, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("CICLO", "FRAGMENT: Metodo OnStart()");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("CICLO", "FRAGMENT: Metodo OnResume()");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("CICLO","FRAGMENT: Metodo OnPause()");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("CICLO","FRAGMENT: Metodo OnStop()");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i("CICLO","FRAGMENT: Metodo OnDestroyView()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("CICLO","FRAGMENT: Metodo OnDestroy()");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i("CICLO","FRAGMENT: Metodo OnDetach()");
    }
}
