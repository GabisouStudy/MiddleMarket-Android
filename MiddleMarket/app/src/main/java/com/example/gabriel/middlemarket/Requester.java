package com.example.gabriel.middlemarket;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import java.util.Random;

/**
 * Created by Gabriel on 22/04/2016.
 */
public class Requester extends GameObject {
    private Bitmap[] spriteItems;
    private int request;
    public int getRequest(){
        return request;
    }

    private boolean good;

    private int life;
    private int id;

    private float startRandom = 3;
    private int maxRandom = 20;

    private int yLine;

    private int speed;

    public Requester(Bitmap[] res, int Y, int ID){
        width = 80;
        height = 80;
        x = ((180 * ID) - (width/2)) - 900;
        yLine = Y;

        Random r1 = new Random();
        int extraY = r1.nextInt(261);

        y = yLine - extraY;

        id = ID;

        Random r2 = new Random();
        request = r2.nextInt(5);

        spriteItems = res;

        Random r3 = new Random();
        speed = r3.nextInt((int)startRandom) + 5;
    }

    public void move(){
        x += speed;
    }

    public void reset(){
        x = ((180 * id) - (width/2)) - 900;

        Random r1 = new Random();
        request = r1.nextInt(5);

        Random r2 = new Random();
        int extraY = r2.nextInt(200);

        y = yLine - extraY;

        Random r3 = new Random();
        speed = r3.nextInt((int)startRandom) + 5;
        if(startRandom < maxRandom) {
            startRandom += 0.5f;
        }
    }

    public void draw(Canvas canvas)
    {
        canvas.drawBitmap(spriteItems[request], (x), (y), null);
    }

}
