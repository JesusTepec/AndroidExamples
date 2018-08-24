package com.example.jesustepec.formulariodinamico;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Switch opcion = (Switch) findViewById(R.id.opciones_swicth);
        final FrameLayout alertas = (FrameLayout)  findViewById(R.id.zona_mensajes);
        final TextView mensaje = (TextView) findViewById(R.id.mensaje);

        opcion.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(!isChecked) {
                    alertas.setVisibility(View.INVISIBLE);
                    mensaje.setText("");
                }
                else {
                    alertas.setVisibility(View.VISIBLE);
                    mensaje.setText(R.string.mesaje_alerte);
                }
            }
        });
    }
}
