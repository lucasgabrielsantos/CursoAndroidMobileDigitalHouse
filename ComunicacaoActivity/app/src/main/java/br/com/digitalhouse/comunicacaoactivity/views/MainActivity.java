package br.com.digitalhouse.comunicacaoactivity.views;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import br.com.digitalhouse.comunicacaoactivity.R;
import br.com.digitalhouse.comunicacaoactivity.interfaces.Comunicador;
import br.com.digitalhouse.comunicacaoactivity.model.SistemaOperacional;

public class MainActivity extends AppCompatActivity implements Comunicador {
    public static final String SO_KEY = "SO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        replaceFragment(R.id.container2, new SistemaFragment());
    }

    @Override
    public void receberMensagem(SistemaOperacional sistema) {

        setBundleToFragment(sistema, SO_KEY);

    }

    public void replaceFragment(int container, Fragment fragment) {

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(container, fragment);
        transaction.commit();
    }

    public void setBundleToFragment(SistemaOperacional so, String CHAVE) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(CHAVE, so);

        Fragment segundoFragment = new ResultFragment();
        segundoFragment.setArguments(bundle);

        replaceFragment(R.id.container1, new ResultFragment());
    }
}
