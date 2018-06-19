package com.kovacsattila.acceleration;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by Kovács Attila on 2018-06-18.
 */

public class Platform implements GameObject {

    private Rect rectangle;
    private int color;

    public Platform(int startX, int startY, int height, int length,  int color){
        this.color = color;
        rectangle = new Rect(startX, startY, startX + height, startY + length);
    }

    public Rect getRectangle() {
        return rectangle;
    }

    public void incrementY(float y) {
        rectangle.bottom += y;
        rectangle.top += y;
    }

    public boolean playerCollide(Ball ball) {
        //return Rect.intersects(rectangle, ball.getRectangle()) || Rect.intersects(rectangle2, ball.getRectangle());
        return false;
    }

    @Override
    public void draw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(color);
        canvas.drawRect(rectangle, paint);
    }

    @Override
    public void update() {

    }
}
