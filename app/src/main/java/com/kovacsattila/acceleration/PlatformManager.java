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
        //populate only first platform
        int xStart = (int)(Math.random()*(Constants.SCREEN_WIDTH - platformHeight));
        int length = (int)(Math.random()*(Constants.SCREEN_HEIGHT/2)) + 100;
        //platforms.add(new Platform(xStart, Constants.SCREEN_HEIGHT, platformHeight, length, color));
        platforms.add(new Platform(xStart, Constants.SCREEN_HEIGHT/2, platformHeight, length, color));

    }

    public void update(){

    }

    public void draw(Canvas canvas){
        for(Platform pl : platforms)
            pl.draw(canvas);
        //current point painting missing
    }
}
