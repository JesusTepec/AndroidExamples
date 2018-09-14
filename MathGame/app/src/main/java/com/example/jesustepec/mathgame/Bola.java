package com.example.jesustepec.mathgame;

public class Bola {

    private float x;
    private float y;

    private float vx;
    private float vy;
    private int color;
    private float radio;

    public Bola(float x, float y, float radio){
        this.x = x;
        this.y = y;
        this.radio = radio;

    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getVx() {
        return vx;
    }

    public float getVy() {
        return vy;
    }

    public int getColor() {
        return color;
    }

    public float getRadio() {
        return radio;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setVx(float vx) {
        this.vx = vx;
    }

    public void setVy(float vy) {
        this.vy = vy;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
