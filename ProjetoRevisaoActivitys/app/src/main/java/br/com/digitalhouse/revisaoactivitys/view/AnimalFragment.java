package br.com.digitalhouse.revisaoactivitys.view;


import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.digitalhouse.revisaoactivitys.R;
import br.com.digitalhouse.revisaoactivitys.model.Animal;

import static br.com.digitalhouse.revisaoactivitys.view.MainActivity.ANIMAL_KEY;

public class AnimalFragment extends Fragment {
    private ImageView imgAnimal;
    private TextView textAnimal;



    public AnimalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_animal, container, false);
        initView(view);

        if(!getArguments().isEmpty()){

            Animal animal = getArguments().getParcelable(ANIMAL_KEY);

            if(animal != null){

                Drawable drawable = getResources().getDrawable(animal.getImage());
                imgAnimal.setImageDrawable(drawable);
                textAnimal.setText(animal.getNome());
            }
        }
        return view;
    }

    public void initView(View view){
        imgAnimal = view.findViewById(R.id.img_animal);
        textAnimal = view.findViewById(R.id.text_animal);
    }

}