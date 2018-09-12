package com.example.jesustepec.graphicsdemo;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends Activity {

    ImageView ourView;

    GameView gameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        gameView = new GameView(this);
        setContentView(gameView);

    }

    @Override
    protected void onResume() {
        super.onResume();

        // Tell the gameView resume method to execute
        gameView.resume();
    }

    // This method executes when the player quits the game
    @Override
    protected void onPause() {
        super.onPause();

        // Tell the gameView pause method to execute
        gameView.pause();
    }

    public void draw(){
        Bitmap blankBitmap;
        blankBitmap = Bitmap.createBitmap(600,600,Bitmap.Config.ARGB_8888);
        Canvas canvas;
        canvas = new Canvas(blankBitmap);
        ourView = new ImageView(this);
        ourView.setImageBitmap(blankBitmap);

        Paint paint;
        paint = new Paint();

        Bitmap bitmapBob;
        bitmapBob = BitmapFactory.decodeResource(this.getResources(), R.drawable.pollo);

        paint.setColor(Color.argb(255,  0, 140, 240));
        canvas.drawRect(new RectF(0, 0, 600, 400), paint);

        paint.setColor(Color.argb(255,  0, 20, 240));
        canvas.drawRect(new RectF(0, 400, 600, 600), paint);

        paint.setColor(Color.argb(255,  0, 20, 240));
        canvas.drawRect(new RectF(0, 400, 600, 600), paint);

        canvas.drawBitmap(bitmapBob, null, new RectF(0, 20, 100, 70), null);
        canvas.drawBitmap(bitmapBob, null, new RectF(100, 200, 200, 270), null);
        paint.setTextSize(20);
        paint.setColor(Color.argb(255,  255, 255, 255));
        canvas.drawText("Hola mundo", 200, 300, paint);
        paint.setColor(Color.argb(255,  230, 220, 15));
        canvas.drawCircle(450,100,50,paint);

    }

}
