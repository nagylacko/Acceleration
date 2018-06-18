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

    public Platform(){

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
