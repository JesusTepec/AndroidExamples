package com.example.jesustepec.formulariodinamico.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.jesustepec.formulariodinamico.Data.Instrucciones;
import com.example.jesustepec.formulariodinamico.R;

import java.util.List;

public class InstruccionesAdapter extends RecyclerView.Adapter<InstruccionesAdapter.ViewHolder> {

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.item_instrccion, viewGroup, false);

        // Return a new holder instance
        return new ViewHolder(contactView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        // Get the data model based on position
        Instrucciones contact = mInstrucciones.get(position);

        // Set item views based on your views and data model
        TextView textView = viewHolder.textoInstruccion;
        textView.setText(contact.getTexto());
        CheckBox check = viewHolder.check;
      //  check.setText("Jugar");
    }

    @Override
    public int getItemCount() {
        return mInstrucciones.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textoInstruccion;
        public CheckBox check;

        public ViewHolder(View itemView) {
            super(itemView);

            textoInstruccion = (TextView) itemView.findViewById(R.id.instrccion_texto);
        }
    }

    // Store a member variable for the contacts
    private List<Instrucciones> mInstrucciones;

    // Pass in the contact array into the constructor
    public InstruccionesAdapter(List<Instrucciones> instrucciones) {
        mInstrucciones = instrucciones;
    }
}
