package com.example.jesustepec.formulariodinamico.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LayoutAnimationController;
import android.view.animation.TranslateAnimation;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Switch;

import com.example.jesustepec.formulariodinamico.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ConfiguracionesFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = (ViewGroup) inflater.inflate(R.layout.fragment_configuraciones, container, false);
        Switch opcion = (Switch) view.findViewById(R.id.opciones_swicth);

        final LinearLayout opc1 = (LinearLayout) view.findViewById(R.id.opciones_basicas);
        final LinearLayout opc2 = (LinearLayout) view.findViewById(R.id.opciones_avanzadas);

        Spinner nivelesSpinner = (Spinner) view.findViewById(R.id.niveles_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.nivels_juego, android.R.layout.simple_selectable_list_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        nivelesSpinner.setAdapter(adapter);

        opc2.setVisibility(View.INVISIBLE);

        opcion.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                int visible = (isChecked) ? View.VISIBLE : View.INVISIBLE;
                int invisible = (isChecked) ? View.INVISIBLE : View.VISIBLE;
                opc1.setVisibility(visible);
                opc2.setVisibility(invisible);
                animar(isChecked, opc1);
                animar(!isChecked, opc2);
            }
        });

        return view;
    }


    private void animar(boolean mostrar, LinearLayout layout) {
        AnimationSet set = new AnimationSet(true);
        Animation animation = null;
        if (mostrar) {
            //desde la esquina inferior derecha a la superior izquierda
            animation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 1.0f, Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 1.0f, Animation.RELATIVE_TO_SELF, 0.0f);
        } else {    //desde la esquina superior izquierda a la esquina inferior derecha
            animation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 1.0f, Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 1.0f);
        }
        //duración en milisegundos
        animation.setDuration(500);
        set.addAnimation(animation);
        LayoutAnimationController controller = new LayoutAnimationController(set, 0.25f);

        layout.setLayoutAnimation(controller);
        layout.startAnimation(animation);
    }

}
