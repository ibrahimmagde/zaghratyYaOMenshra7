package com.example.hima.zaghrateyaomenshra7;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    // Keep all Images in array
    public Integer[] mThumbIds = {
            R.drawable.abocomin,R.drawable.enspostermin,R.drawable.tpostermin,R.drawable.lembipostermin,R.drawable.kalempostermin,
            R.drawable.ahlpostermin,R.drawable.bpostermin,R.drawable.opostermin,R.drawable.oopostermin,R.drawable.bbpostermin

    };

    // Constructor
    public ImageAdapter(Context c){
        mContext = c;
    }

    @Override
    public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int position) {
        return mThumbIds[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(mThumbIds[position]);
        imageView.setLayoutParams(new GridView.LayoutParams(500,500));
        return imageView;
    }

}