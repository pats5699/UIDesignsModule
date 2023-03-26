package com.example.uidesign;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.BounceInterpolator;
import android.widget.RelativeLayout;

import com.jem.liquidswipe.clippathprovider.LiquidSwipeClipPathProvider;
import com.jem.liquidswipe.layout.LiquidSwipeConstraintLayout;
import com.jem.liquidswipe.layout.LiquidSwipeLinearLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Mountain extends Fragment {

    private LiquidSwipeConstraintLayout liquidSwipeConstraintLayout;
    private LiquidSwipeClipPathProvider liquidSwipeClipPathProvider;
    private RelativeLayout shadowRelativeLayout;

    public Fragment_Mountain() {
        // Required empty public constructor
    }

    public Fragment_Mountain(LiquidSwipeClipPathProvider liquidSwipeClipPathProvider) {
        this.liquidSwipeClipPathProvider = liquidSwipeClipPathProvider;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment__mountain, container, false);
        liquidSwipeConstraintLayout = view.findViewById(R.id.container);
        liquidSwipeConstraintLayout.setClipPathProvider(liquidSwipeClipPathProvider);

        shadowRelativeLayout = view.findViewById(R.id.shadowRelativeLayout);
        shadowRelativeLayout.setScaleX(0);
        shadowRelativeLayout.setScaleY(0);
        shadowRelativeLayout.animate().scaleX(1).scaleY(1).setInterpolator(new BounceInterpolator()).setDuration(500);



        return view;
    }

}
