package com.example.hima.zaghrateyaomenshra7;

import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageButton;

public class MyAnimationListener implements Animation.AnimationListener {
    private ImageButton mImgButton;

    public MyAnimationListener(ImageButton imgButton) {
        mImgButton = imgButton;
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        mImgButton.setVisibility(View.GONE);

    }

    @Override
    public void onAnimationRepeat(Animation animation) {
        // TODO Auto - generated method stub

    }

    @Override
    public void onAnimationStart(Animation animation) {
        // TODO Auto - generated method stub

    }

}