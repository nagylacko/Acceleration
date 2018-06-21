package com.kovacsattila.acceleration;

import android.graphics.Canvas;

import java.util.ArrayList;

/**
 * Created by Kovács Attila on 2018-06-19.
 */

public class PlatformManager {

    private ArrayList<Platform> platforms;
    private int platformHeight;
    private int platformLength;
    private int color;

    private long startTime;
    private long initTime;

    private int score = 0;

    public PlatformManager(int platformHeight, int color){
        this.platformHeight = platformHeight;
        this.color = color;

        startTime = initTime = System.currentTimeMillis();

        platforms = new ArrayList<>();

        populatePlatforms();
    }

    public void populatePlatforms(){
        int xStart = (int)(Math.random()*(Constants.SCREEN_WIDTH - platformHeight));
        int length = (int)(Math.random()*(Constants.SCREEN_HEIGHT/2)) + 100;
        //platforms.add(new Platform(xStart, Constants.SCREEN_HEIGHT, platformHeight, length, color));
        platforms.add(new Platform(xStart, Constants.SCREEN_HEIGHT/2, platformHeight, length, color));

        //ez a feltetel (es lejjebb) nem biztos h jo, csak egy elem van a tombben
        if(platforms.get(platforms.size() - 1).getRectangle().bottom <= Constants.SCREEN_HEIGHT + 200) {
            xStart = (int)(Math.random()*(Constants.SCREEN_WIDTH - platformHeight));
            length = (int)(Math.random()*(Constants.SCREEN_HEIGHT/2)) + 100;
            platforms.add(new Platform(xStart, platforms.get(platforms.size() - 1).getRectangle().bottom, platformHeight, length, color));
        }

    }

    public void update(){
        if(startTime < Constants.INIT_TIME)
            startTime = Constants.INIT_TIME;
        int elapsedTime = (int)(System.currentTimeMillis() - startTime);
        startTime = System.currentTimeMillis();
        float speed = (float)(Math.sqrt(1 + (startTime - initTime)/2000.0)) * Constants.SCREEN_HEIGHT/(10000.0f);
        for (Platform pl : platforms) {
            pl.incrementY(speed * elapsedTime);
        }

        if(platforms.get(platforms.size() - 1).getRectangle().bottom <= Constants.SCREEN_HEIGHT + 200) {
            int xStart = (int)(Math.random()*(Constants.SCREEN_WIDTH - platformHeight));
            int length = (int)(Math.random()*(Constants.SCREEN_HEIGHT/2)) + 100;
            platforms.add(new Platform(xStart, platforms.get(platforms.size() - 1).getRectangle().bottom, platformHeight, length, color));
        }
    }

    public void draw(Canvas canvas){
        for(Platform pl : platforms)
            pl.draw(canvas);
        //current point painting missing
    }
}
