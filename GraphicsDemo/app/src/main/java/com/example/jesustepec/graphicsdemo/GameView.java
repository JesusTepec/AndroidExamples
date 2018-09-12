package com.example.jesustepec.graphicsdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GameView extends SurfaceView implements Runnable {

    Thread gameThread = null;

    SurfaceHolder ourHolder;

    volatile boolean playing;

    Canvas canvas;
    Paint paint;

    long fps;

    private long timeThisFrame;

    Bitmap bitmapBob;

    boolean isMoving = false;

    float walkSpeedPerSecond = 150;

    float bobXPosition = 10;

    public GameView(Context context) {
        super(context);

        // Initialize ourHolder and paint objects
        ourHolder = getHolder();
        paint = new Paint();

        // Load Bob from his .png file
        bitmapBob = BitmapFactory.decodeResource(this.getResources(), R.drawable.pollo);
    }

    @Override
    public void run() {
        while (playing) {

            long startFrameTime = System.currentTimeMillis();

            update();

            draw();

            timeThisFrame = System.currentTimeMillis() - startFrameTime;
            if (timeThisFrame > 0) {
                fps = 1000 / timeThisFrame;
            }

        }
    }

    public void update() {

        if(isMoving){
            bobXPosition = bobXPosition + (walkSpeedPerSecond / fps);
        }

    }

    public void draw() {

        if (ourHolder.getSurface().isValid()) {
            // Lock the canvas ready to draw
            canvas = ourHolder.lockCanvas();

            // Draw the background color
            canvas.drawColor(Color.argb(255,  26, 128, 182));

            // Choose the brush color for drawing
            paint.setColor(Color.argb(255,  249, 129, 0));

            // Make the text a bit bigger
            paint.setTextSize(45);

            // Display the current fps on the screen
            canvas.drawText("FPS:" + fps, 20, 40, paint);

            // Draw bob at bobXPosition, 200 pixels
            canvas.drawBitmap(bitmapBob, null, new RectF(bobXPosition, 200, bobXPosition + 100, 270), paint);

            // Draw everything to the screen
            ourHolder.unlockCanvasAndPost(canvas);
        }

    }

    // shutdown our thread.
    public void pause() {
        playing = false;
        try {
            gameThread.join();
        } catch (InterruptedException e) {
            Log.e("Error:", "joining thread");
        }

    }

    // If SimpleGameEngine Activity is started theb
    // start our thread.
    public void resume() {
        playing = true;
        gameThread = new Thread(this);
        gameThread.start();
    }


    // The SurfaceView class implements onTouchListener
    // So we can override this method and detect screen touches.
    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {

        switch (motionEvent.getAction() & MotionEvent.ACTION_MASK) {

            // Player has touched the screen
            case MotionEvent.ACTION_DOWN:

                // Set isMoving so Bob is moved in the update method
                isMoving = true;

                break;

            // Player has removed finger from screen
            case MotionEvent.ACTION_UP:

                // Set isMoving so Bob does not move
                isMoving = false;

                break;
        }
        return true;
    }

}
