package com.kovacsattila.acceleration;

import android.graphics.Canvas;

/**
 * Created by Kovács Attila on 2018-06-03.
 */

public interface GameObject {
    public void draw(Canvas canvas);
    public void update();
}
