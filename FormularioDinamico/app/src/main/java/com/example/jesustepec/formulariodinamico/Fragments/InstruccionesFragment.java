package com.example.jesustepec.formulariodinamico.Fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jesustepec.formulariodinamico.Adapters.InstruccionesAdapter;
import com.example.jesustepec.formulariodinamico.Data.Instrucciones;
import com.example.jesustepec.formulariodinamico.R;

import java.util.ArrayList;

public class InstruccionesFragment extends Fragment {



    public InstruccionesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = (ViewGroup) inflater.inflate(R.layout.fragment_instrucciones, container, false);

        RecyclerView rvInstrucciones = (RecyclerView) view.findViewById(R.id.instrucciones_recycleView);
        ArrayList<Instrucciones> instrucciones = Instrucciones.getInstrucciones();
        InstruccionesAdapter adapter = new InstruccionesAdapter(instrucciones);
        rvInstrucciones.setAdapter(adapter);
        rvInstrucciones.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }

}
