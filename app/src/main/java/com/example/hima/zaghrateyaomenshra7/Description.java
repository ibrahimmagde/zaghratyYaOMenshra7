package com.example.hima.zaghrateyaomenshra7;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Description extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
    }

    public void keshtaClick (View v){

        startActivity(new Intent(
                this,MainActivity.class
        ));
    }
}
