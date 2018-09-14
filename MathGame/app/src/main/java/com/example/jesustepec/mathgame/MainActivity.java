package com.example.jesustepec.mathgame;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.ArrayList;
import java.util.Random;


public class MainActivity extends Activity {

    Canvas canvas;
    SquashCourtView squashCourtView;

    ArrayList<Bola> bolitas;
    long lastFrameTime;
    int fps;
    int widthScreen;
    int heightScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        squashCourtView = new SquashCourtView(this);
        setContentView(squashCourtView);

        sizeScreen();
        int widthR = randint(25);

        bolitas = new ArrayList<>();
        Bola bolita = new Bola(randint(widthScreen - widthR), randint(50), widthR);
        bolita.setColor(Color.argb(255, randint(255), randint(255), randint(255)));
        bolita.setVx(10);
        bolita.setVy(10);
        bolitas.add(bolita);

    }

    class SquashCourtView extends SurfaceView implements Runnable {
        Thread ourThread = null;
        SurfaceHolder ourHolder;
        volatile boolean playingSquash;
        Paint paint;

        public SquashCourtView(Context context) {
            super(context);
            ourHolder = getHolder();
            paint = new Paint();
        }

        @Override
        public void run() {
            while (playingSquash) {
                updateCourt();
                drawCourt();
                controlFPS();
            }

        }

        public void updateCourt() {

            for(int i = 0; i < bolitas.size(); i++) {
                bolitas.get(i).setX(bolitas.get(i).getX() + bolitas.get(i).getVx());
                bolitas.get(i).setY(bolitas.get(i).getY() + bolitas.get(i).getVy());
                if (bolitas.get(i).getY() > heightScreen - bolitas.get(i).getRadio() || bolitas.get(i).getY() < bolitas.get(i).getRadio()) {
                    bolitas.get(i).setVy(bolitas.get(i).getVy() * -1);
                }
                if (bolitas.get(i).getX() > widthScreen - bolitas.get(i).getRadio() || bolitas.get(i).getX() < bolitas.get(i).getRadio()) {
                    bolitas.get(i).setVx(bolitas.get(i).getVx() * -1);
                }
            }
        }

        public void drawCourt() {
            if (ourHolder.getSurface().isValid()) {
                canvas = ourHolder.lockCanvas();
                canvas.drawColor(Color.BLACK);//the background
                for (int i = 0; i < bolitas.size(); i++) {
                    paint.setColor(bolitas.get(i).getColor());
                    canvas.drawCircle(bolitas.get(i).getX(), bolitas.get(i).getY(), bolitas.get(i).getRadio(), paint);
                }
                ourHolder.unlockCanvasAndPost(canvas);
            }
        }


        public void controlFPS() {
            long timeThisFrame = (System.currentTimeMillis() - lastFrameTime);
            long timeToSleep = 15 - timeThisFrame;
            if (timeThisFrame > 0) {
                fps = (int) (1000 / timeThisFrame);
            }
            if (timeToSleep > 0) {

                try {
                    ourThread.sleep(timeToSleep);
                } catch (InterruptedException e) {
                }

            }

            lastFrameTime = System.currentTimeMillis();
        }

        public void pause() {
            playingSquash = false;
            try {
                ourThread.join();
            } catch (InterruptedException e) {
            }

        }

        public void resume() {
            playingSquash = true;
            ourThread = new Thread(this);
            ourThread.start();
        }

        @SuppressLint("ClickableViewAccessibility")
        @Override
        public boolean onTouchEvent(MotionEvent motionEvent) {
            switch (motionEvent.getAction() & MotionEvent.ACTION_MASK) {
                case MotionEvent.ACTION_DOWN:
                    Bola bolita = new Bola(motionEvent.getX(), motionEvent.getY(), randint(25));
                    bolita.setColor(Color.argb(255, randint(255), randint(255), randint(255)));
                    int v = randint(10);
                    bolita.setVy(v);
                    bolita.setVx(v);
                    bolitas.add(bolita);
                    break;

                case MotionEvent.ACTION_UP:

                    break;
            }
            return true;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();

        while (true) {
            squashCourtView.pause();
            break;
        }

        finish();
    }


    @Override
    protected void onResume() {
        super.onResume();
        squashCourtView.resume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        squashCourtView.pause();
    }

    private void sizeScreen(){
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        widthScreen = size.x;
        heightScreen = size.y;
    }

    private int randint(int max){
        Random randomNumber = new Random();
        return randomNumber.nextInt((max - 5) + 1) + 5;
    }

}
