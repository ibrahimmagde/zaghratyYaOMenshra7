package com.example.hima.zaghrateyaomenshra7;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Hima on 9/12/2016.
 */
public class level extends AppCompatActivity {

    Toolbar mToolbar4;
    ProgressBar n;
    ProgressBar2 m;
    Button b;
    TextView tv;
    TextView tv2;
    Typeface tf;
   MediaPlayer mp;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level);

        mp = MediaPlayer.create(getApplicationContext(), R.raw.frtka);


        Intent i = getIntent();

        tv = (TextView)findViewById(R.id.textView2);
        tv2 = (TextView)findViewById(R.id.textView);
        tf =  Typeface.createFromAsset(getAssets(),"Pokemon Solid.ttf");
        tv.setTypeface(tf);
        tv2.setTypeface(tf);

        tv.setText("0");
        tv2.setText("0");


        // Selected image id
        int position = i.getExtras().getInt("id");


        if(position==0) {

            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.your_placeholder, new FilmOne());
            ft.commit();
        }

        if(position==1) {

            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.your_placeholder, new FilmTwo());

            ft.commit();
        }if(position==2) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.your_placeholder, new FilmThree());
            ft.commit();
        }

        if(position==3) {

            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.your_placeholder, new FilmFour());
            ft.commit();
        }if(position==4) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.your_placeholder, new FilmFive());
            ft.commit();
        }
        if(position==5) {

            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.your_placeholder, new FilmSix());
            ft.commit();
        }
        if(position==6) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.your_placeholder, new FilmSeve());
            ft.commit();
        }

        if(position==7) {

            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.your_placeholder, new FilmEight());
            ft.commit();
        }if(position==8) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.your_placeholder, new FilmNine());
            ft.commit();
        }
        if(position==9) {

            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.your_placeholder, new FilmTen());
            ft.commit();
        }







        n=new ProgressBar(this);
        m=new ProgressBar2(this);


    }







    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences = getSharedPreferences(getPackageName() +".my_pref_file", Context.MODE_PRIVATE);
        Integer counterN = sharedPreferences.getInt("counterN",0);
        Integer counterM = sharedPreferences.getInt("counterM",0);

        n.counter=counterN;
        m.counter=counterM;
        tv.setText(String.valueOf(n.counter));
        tv2.setText(String.valueOf(m.counter));
        n.Increase(false,false);
        m.Increase(false,false);



    }

    @Override
    protected void onStop() {
        super.onStop();

        SharedPreferences sharedPreferences = getSharedPreferences(getPackageName() +".my_pref_file", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("counterN",n.counter);
        editor.putInt("counterM",m.counter);

        editor.apply();

    }

    public void lucky(View v) {


        Animation a = AnimationUtils.loadAnimation(this, R.anim.scale);
        a.reset();

        MainActivity.i++;
        if(MainActivity.i%2==0) {
            n.counter += 2;
            n.Increase(true,false);
            tv.setText(String.valueOf(n.counter));
            tv.clearAnimation();
            tv.startAnimation(a);




        }else {
            m.counter += 2;
            m.Increase(true,false);
            tv2.setText(String.valueOf(m.counter));
            tv2.clearAnimation();
            tv2.startAnimation(a);


        }

        RotateAnimation anim = new RotateAnimation(0f, 350f, 15f, 15f);
        anim.setInterpolator(new LinearInterpolator());
        anim.setRepeatCount(1);
        anim.setDuration(1000);
        v.startAnimation(anim);

       /* Animation animFadeOut = AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.fade_out);
        Animation animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.fade_in);
        v.setAnimation(animFadeOut);*/

        v.setVisibility(View.INVISIBLE);


        if(m.counter==100||n.counter==100){
            n.counter=0;

            m.counter=0;

            mp.start();
        }
    }

    public void Unlucky(View v) {


        MainActivity.i++;
        if(MainActivity.i%2==0) {
            n.counter -= 2;
            n.Increase(true,true);
            tv.setText(String.valueOf(n.counter));

        }else {
            m.counter -= 2;
            m.Increase(true,true);
            tv2.setText(String.valueOf(m.counter));

        }


        Animation animFadeOut = AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.fade_out);
        Animation animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.fade_in);
        v.setAnimation(animFadeOut);

        v.setVisibility(View.INVISIBLE);
    }


    public void replayClick(View v){
        n.counter=0;
        n.Increase(false,false);
        m.counter=0;
        m.Increase(false,false);
        tv.setText("0");
        tv2.setText("0");
        finish();
        overridePendingTransition(0, 0);
        startActivity(getIntent());
        overridePendingTransition(0, 0);
        mp.stop();
    }

    private void stopPlaying() {
        if (mp != null) {
            mp.stop();
            mp.release();
            mp = null;
        }
    }





}
