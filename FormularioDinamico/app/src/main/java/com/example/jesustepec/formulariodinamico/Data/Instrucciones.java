package com.example.jesustepec.formulariodinamico.Data;

import java.util.ArrayList;

public class Instrucciones {

    String texto;

    public Instrucciones(String _texto){
        texto = _texto;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public static ArrayList<Instrucciones> getInstrucciones(){
        ArrayList<Instrucciones> listaInstrucciones = new ArrayList<>();
        listaInstrucciones.add(new Instrucciones("1.- Seleccione comenzar juego para que aparesca el orden de los colores"));
        listaInstrucciones.add(new Instrucciones("2.- Seleccione comenzar juego para que aparesca el orden de los colores"));
        listaInstrucciones.add(new Instrucciones("3.- Seleccione comenzar juego para que aparesca el orden de los colores"));
        listaInstrucciones.add(new Instrucciones("4.- Seleccione comenzar juego para que aparesca el orden de los colores"));
        listaInstrucciones.add(new Instrucciones("5.- Seleccione comenzar juego para que aparesca el orden de los colores"));
        listaInstrucciones.add(new Instrucciones("5.- Seleccione comenzar juego para que aparesca el orden de los colores"));
        return  listaInstrucciones;
    }
}
