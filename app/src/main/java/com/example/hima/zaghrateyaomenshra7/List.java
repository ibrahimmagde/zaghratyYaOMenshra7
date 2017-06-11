package com.example.hima.zaghrateyaomenshra7;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.GridLayoutAnimationController;
import android.widget.AdapterView;
import android.widget.GridView;

public class List extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));

        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.grid_item_anim);
        GridLayoutAnimationController controller = new GridLayoutAnimationController(animation, .2f, .2f);
        gridview.setLayoutAnimation(controller);


       gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id){
                // Send intent to SingleViewActivity



                Intent i = new Intent(getApplicationContext(), level.class);

                // Pass image index
                i.putExtra("id", position);
                startActivity(i);


            }
        });
    }
}
