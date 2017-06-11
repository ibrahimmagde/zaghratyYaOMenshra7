package com.example.hima.zaghrateyaomenshra7;

import android.app.Activity;
import android.graphics.drawable.ClipDrawable;
import android.media.MediaPlayer;
import android.os.Handler;
import android.widget.ImageView;


public class ProgressBar2 {

    private ClipDrawable mImageDrawable;
    public int counter=0;
    // a field in your class
    private int mLevel = 0;
    private int fromLevel = 0;
    private int toLevel = 0;
    Activity x;

    public static final int MAX_LEVEL = 10000;
    public static final int LEVEL_DIFF = 100;
    public static final int DELAY = 30;

    private Handler mUpHandler = new Handler();
    private Runnable animateUpImage = new Runnable() {

        @Override
        public void run() {
            doTheUpAnimation(fromLevel, toLevel);
        }
    };
    ProgressBar2(Activity a){

        x=a;
        ImageView img = (ImageView) this.x.findViewById(R.id.imageViewOne);
        mImageDrawable = (ClipDrawable) img.getDrawable();
        mImageDrawable.setLevel(0);

    }

    private Handler mDownHandler = new Handler();
    private Runnable animateDownImage = new Runnable() {

        @Override
        public void run() {
            doTheDownAnimation(fromLevel, toLevel);
        }
    };



    private void doTheUpAnimation(int fromLevel, int toLevel) {
        mLevel += LEVEL_DIFF;
        mImageDrawable.setLevel(mLevel);
        if (mLevel <= toLevel) {
            mUpHandler.postDelayed(animateUpImage, DELAY);
        } else {
            mUpHandler.removeCallbacks(animateUpImage);
            this.fromLevel = toLevel;
        }
    }

    private void doTheDownAnimation(int fromLevel, int toLevel) {
        mLevel -= LEVEL_DIFF;
        mImageDrawable.setLevel(mLevel);
        if (mLevel >= toLevel) {
            mDownHandler.postDelayed(animateDownImage, DELAY);
        } else {
            mDownHandler.removeCallbacks(animateDownImage);
            this.fromLevel = toLevel;
        }
    }

    public void Increase(boolean b,boolean isBad) {

        if(b&&!isBad) {
            if (counter % 10 == 0) {

                final MediaPlayer mp = MediaPlayer.create(x.getApplicationContext(), R.raw.khamsa);
                mp.start();
            }
            if (counter % 10 != 0 && counter % 5 != 0) {
                final MediaPlayer mp = MediaPlayer.create(x.getApplicationContext(), R.raw.zaghrouta);
                mp.start();
            }


        }

        if(isBad){
            final MediaPlayer mp = MediaPlayer.create(x.getApplicationContext(), R.raw.yalhwete);
            mp.start();
        }





        int temp_level = (counter* MAX_LEVEL) / 100;

        if (toLevel == temp_level || temp_level > MAX_LEVEL) {
            return;
        }
        toLevel =(temp_level <= MAX_LEVEL) ? temp_level : toLevel;
        if (toLevel > fromLevel) {
            // cancel previous process first
            mDownHandler.removeCallbacks(animateDownImage);
            this.fromLevel = toLevel;

            mUpHandler.post(animateUpImage);
        } else {
            // cancel previous process first
            mUpHandler.removeCallbacks(animateUpImage);
            this.fromLevel = toLevel;

            mDownHandler.post(animateDownImage);
        }
    }
}
