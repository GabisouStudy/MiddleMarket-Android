package com.example.gabriel.middlemarket;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by Gabriel.Souza on 14/04/2016.
 */
public class Item extends GameObject{
    private Bitmap sprite;
    private int id;

    private Color color;

    public Item(Bitmap res, int ID, int sY){
        x = (65 + (150 * ID) - (width/2));
        y = (sY - height/2);
        width = 80;
        height = 80;
        id = ID;

        sprite = res;

    }

    public void draw(Canvas canvas)
    {
        canvas.drawBitmap(sprite, (x), (y), null);
    }
}
