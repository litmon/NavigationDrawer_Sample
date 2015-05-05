package com.example.fukuo.navigationdrawer_sample;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by fukuo on 2015/05/04.
 */
public class CustomPagerAdapter extends PagerAdapter {

    ArrayList<Integer> ids = new ArrayList<Integer>();
    Context context;

    public CustomPagerAdapter(Context context){
        this.context = context;
    }

    public void add(int id){
        ids.add(id);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView v = new ImageView(context);

        v.setImageResource(ids.get(position));

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("CustomPagerAdapter", "view onClicked.");
            }
        });

        container.addView(v);

        return v;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }

    @Override
    public int getCount() {
        return ids.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
