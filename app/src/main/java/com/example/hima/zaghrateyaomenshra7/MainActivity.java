package com.example.hima.zaghrateyaomenshra7;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;


public class MainActivity extends Activity {
    public  static int i;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        i=0;
    }



  /* public void onClickOk(View v) {
        n.Increase(40);
        m.Increase(5);
    }*/

    public void wasfClick(View v){
        startActivity(new Intent(this, Description.class));
    }

    public void playClick(View v){
        startActivity(new Intent(this, List.class));
    }


}
