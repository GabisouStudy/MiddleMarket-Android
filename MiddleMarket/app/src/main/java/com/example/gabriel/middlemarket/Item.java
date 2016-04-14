package com.example.gabriel.middlemarket;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by Gabriel.Souza on 14/04/2016.
 */
public class Item extends GameObject{
    private Bitmap sprite;
    private int id;

    public void draw(Canvas canvas)
    {
        canvas.drawBitmap(sprite, (x - (width/2)), (y - (height/2)), null);
    }
}
