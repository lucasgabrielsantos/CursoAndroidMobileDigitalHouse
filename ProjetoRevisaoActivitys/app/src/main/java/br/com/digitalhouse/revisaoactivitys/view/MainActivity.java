package br.com.digitalhouse.revisaoactivitys.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import br.com.digitalhouse.revisaoactivitys.Interface.Comunicador;
import br.com.digitalhouse.revisaoactivitys.R;
import br.com.digitalhouse.revisaoactivitys.model.Animal;
import br.com.digitalhouse.revisaoactivitys.view.AnimalFragment;
import br.com.digitalhouse.revisaoactivitys.view.ButtonFragment;


public class MainActivity extends AppCompatActivity implements Comunicador {
    public static final String ANIMAL_KEY = "animal";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        replaceFragment(R.id.container2, new ButtonFragment());
    }

    private void replaceFragment(int container, Fragment fragment){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(container, fragment);
        transaction.commit();
    }


    @Override
    public void recebeMensagem(Animal animal){
        Bundle bundle = new Bundle();

        bundle.putParcelable(ANIMAL_KEY, animal);

        Fragment segundoFragment = new AnimalFragment();

        segundoFragment.setArguments(bundle);

        replaceFragment(R.id.container1, segundoFragment);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
