package com.kovacsattila.acceleration;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.SurfaceHolder;
import android.widget.Toast;

/**
 * Created by Kovács Attila on 2018-05-31.
 */
public class GamePanel extends SurfaceView implements SurfaceHolder.Callback {
    private MainThread thread;

    private GameplayScene gameplayScene;

    public GamePanel (Context context) {
        super(context);

        getHolder().addCallback(this);

        Constants.CURRENT_CONTEXT = context;

        thread = new MainThread(getHolder(), this);

        gameplayScene = new GameplayScene();

        setFocusable(true);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        thread = new MainThread(getHolder(), this);
        Constants.INIT_TIME = System.currentTimeMillis();
        thread.setRunning(true);
        thread.start();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        while (retry) {
            try {
                thread.setRunning(false);
                thread.join();
            } catch(Exception e) {e.printStackTrace();}
            retry = false;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        gameplayScene.receiveTouch(event);

        return true;
        //return super.onTouchEvent(event);
    }

    public void update() {
        gameplayScene.update();
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

        gameplayScene.draw(canvas);
    }
}
