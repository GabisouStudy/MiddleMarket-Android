package com.example.gabriel.middlemarket;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.text.style.LineHeightSpan;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by Gabriel on 04/04/2016.
 */

public class GamePanel extends SurfaceView implements SurfaceHolder.Callback
{
    public static final int WIDTH = 856;
    public static final int HEIGHT = 480;
    public static final int MOVESPEED = -5;
    private MainThread thread;

    private Background bg;
    private Player player;

    public GamePanel(Context context)
    {
        super(context);


        //add the callback to the surfaceholder to intercept events
        getHolder().addCallback(this);

        thread = new MainThread(getHolder(), this);

        //make gamePanel focusable so it can handle events
        setFocusable(true);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height){}

    @Override
    public void surfaceDestroyed(SurfaceHolder holder){
        boolean retry = true;
        while(retry)
        {
            try{thread.setRunning(false);
                thread.join();

            }catch(InterruptedException e){e.printStackTrace();}
            retry = false;
        }

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder){

        bg = new Background(BitmapFactory.decodeResource(getResources(), R.drawable.bgclouds));
        bg.setVector(-5);

        player = new Player(BitmapFactory.decodeResource(getResources(), R.drawable.hand_player), 40, 60);
        //we can safely start the game loop
        thread.setRunning(true);
        thread.start();

    }



    @Override
    public boolean onTouchEvent(MotionEvent event)
    {


        float x = event.getX();
        float y = event.getY();

        player.setPosition((int)x, (int)y);

        return  true;
    }
    public void update()
    {

        bg.update();
    }
    @Override
    public void draw(Canvas canvas){
        final float scaleFactorX = getWidth()/(WIDTH*1.f);
        final float scaleFactorY = getWidth()/(HEIGHT*1.f);
        if(canvas != null) {
            final int savedState = canvas.save();
            bg.draw(canvas);
            player.draw(canvas);
            canvas.restoreToCount(savedState);
        }
    }
}