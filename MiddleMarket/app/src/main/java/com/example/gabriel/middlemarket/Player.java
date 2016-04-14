package com.example.gabriel.middlemarket;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by Gabriel on 14/04/2016.
 */
public class Player extends GameObject{
    private Bitmap sprite;
    private int score;
    private int speed;
    private boolean playing;

    public Player(Bitmap res, int w, int h){
        x = GamePanel.WIDTH/2;
        y = GamePanel.HEIGHT/2;
        dy = 0;
        score = 0;
        speed = 5;
        height = h;
        width = w;
        sprite = res;
    }

    public void setPosition(int tX, int tY)
    {
        x = tX;
        y = tY;
    }

    public void draw(Canvas canvas)
    {
        canvas.drawBitmap(sprite, (x - (width/2)), (y - (height/2)), null);
    }
}
