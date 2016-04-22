package com.example.gabriel.middlemarket;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.Random;

/**
 * Created by Gabriel on 14/04/2016.
 */
public class Player extends GameObject{
    private Bitmap sprite;

    private Bitmap[] spriteSelect;

    public int score;
    public void setScore(int score){
        this.score = score;
    }
    public int getScore(){
        return score;
    }

    private int life;
    public void setLife(int life){ this.life = life; }
    public int getLife(){return life; }

    private int select;
    public void setSelect(int select){
        this.select = select;
    }
    public int getSelect(){
        return select;
    }

    private boolean playing;

    private int scoreX;

    public Player(Bitmap res, int w, int h, int sX, Bitmap[] sS){
        x = GamePanel.WIDTH/2;
        y = GamePanel.HEIGHT/2;

        dy = 0;

        score = 0;
        life = 3;

        height = h;
        width = w;

        sprite = res;

        select = 5;

        scoreX = sX;

        spriteSelect = sS;
    }

    public void setPosition(int pX, int pY)
    {
        x = (pX - width/2);
        y = (pY - height/2);
    }

    public void draw(Canvas canvas)
    {
        if(select != 5){
            canvas.drawBitmap((spriteSelect[select]), (x - 20), (y - 15), null);
        }

        canvas.drawBitmap(sprite, (x), (y), null);

        Paint paint = new Paint();

        paint.setColor(Color.BLACK);
        paint.setTextSize(20);

        paint.setColor(Color.BLACK);
        paint.setTextSize(40);
        canvas.drawText(("Score: " + score), 10, 50, paint);
        canvas.drawText(("Life: " + life), scoreX, 50, paint);
    }
}
