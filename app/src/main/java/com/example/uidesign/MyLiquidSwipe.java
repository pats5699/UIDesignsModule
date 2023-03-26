package com.example.uidesign;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import com.jem.liquidswipe.LiquidSwipeViewPager;
import com.jem.liquidswipe.clippathprovider.LiquidSwipeClipPathProvider;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class MyLiquidSwipe extends AppCompatActivity {

    LiquidSwipeViewPager liquidSwipeViewPager;
    LiquidSwipeAdapter liquidSwipeAdapter;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_liquid_swipe);


        liquidSwipeViewPager = (LiquidSwipeViewPager) findViewById(R.id.lsViewpager);

        final LiquidSwipeClipPathProvider liquidSwipeClipPathProvider1 = new LiquidSwipeClipPathProvider();
        final LiquidSwipeClipPathProvider liquidSwipeClipPathProvider2 = new LiquidSwipeClipPathProvider();
        final LiquidSwipeClipPathProvider liquidSwipeClipPathProvider3 = new LiquidSwipeClipPathProvider();
        final LiquidSwipeClipPathProvider liquidSwipeClipPathProvider4 = new LiquidSwipeClipPathProvider();
        final LiquidSwipeClipPathProvider liquidSwipeClipPathProvider5 = new LiquidSwipeClipPathProvider();


        liquidSwipeAdapter = new LiquidSwipeAdapter(getSupportFragmentManager());
        liquidSwipeAdapter.addFragment(new Fragment_Mountain(liquidSwipeClipPathProvider1), "TAB ONE");
        liquidSwipeAdapter.addFragment(new Fragment_Map(liquidSwipeClipPathProvider2), "TAB TWO");
        liquidSwipeAdapter.addFragment(new Fragment_Bag(liquidSwipeClipPathProvider3), "TAB THREE");
        liquidSwipeAdapter.addFragment(new Fragment_Camera(liquidSwipeClipPathProvider4), "TAB FOUR");
        liquidSwipeAdapter.addFragment(new Fragment_Van(liquidSwipeClipPathProvider5), "TAB Five");


        liquidSwipeViewPager.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                float waveCenterY = event.getY();
                liquidSwipeClipPathProvider1.setWaveCenterY(waveCenterY);
                liquidSwipeClipPathProvider2.setWaveCenterY(waveCenterY);
                liquidSwipeClipPathProvider3.setWaveCenterY(waveCenterY);
                liquidSwipeClipPathProvider4.setWaveCenterY(waveCenterY);
                liquidSwipeClipPathProvider5.setWaveCenterY(waveCenterY);

                return false;
            }
        });


        liquidSwipeViewPager.setAdapter(liquidSwipeAdapter);

    }


}
