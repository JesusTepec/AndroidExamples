package com.example.jesustepec.spinnerimages;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = (Spinner) findViewById(R.id.dificultad_spinner);

        List<String> niveles = new ArrayList<String>();
        niveles.add("Principiante");
        niveles.add("Normal");
        niveles.add("Avanzado");
        ArrayAdapter<String> nivelesAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, niveles);
        nivelesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(nivelesAdapter);
    }
}
