package com.example.jesustepec.formulariodinamico.Data;

import android.support.v4.app.Fragment;

public class DataFragments {

    private String titulo;

    private int position;

    private Fragment fragmento;

    public DataFragments(String _titulo, int _position, Fragment _fragment){
        titulo = _titulo;
        position = _position;
        fragmento = _fragment;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Fragment getFragmento() {
        return fragmento;
    }

    public void setFragmento(Fragment fragmento) {
        this.fragmento = fragmento;
    }

}
