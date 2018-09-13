package com.example.jesustepec.mathgame;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.ArrayList;
import java.util.Random;


public class MainActivity extends Activity {

    Canvas canvas;
    SquashCourtView squashCourtView;

    Point ballPosition;

    ArrayList<Point> points;
    long lastFrameTime;
    int fps;
    int aux;

    int widthScreen;
    int heightScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        squashCourtView = new SquashCourtView(this);
        setContentView(squashCourtView);

        sizeScreen();

        ballPosition = new Point();
        ballPosition.x = randint(widthScreen - 20);
        ballPosition.y = 1 + 20;
        aux = 50;

        points = new ArrayList<>();
        points.add(ballPosition);
        points.add(new Point(randint(widthScreen - 20), 21));
        points.add(new Point(randint(widthScreen - 20), 21));

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
            for(Point point : points) {
                point.y += aux;
                if (point.y > heightScreen) {
                    point.y = 21;
                    point.x = randint(widthScreen - 20);
                }
            }
        }

        public void drawCourt() {

            if (ourHolder.getSurface().isValid()) {
                canvas = ourHolder.lockCanvas();
                canvas.drawColor(Color.BLACK);//the background
                for (Point point : points) {
                    paint.setColor(Color.argb(255, randint(255), randint(255), randint(255)));
                    canvas.drawRect(point.x, point.y,
                            point.x + 20, point.y + 20, paint);
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
        return randomNumber.nextInt(max) + 1;
    }

}
