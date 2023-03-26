package com.example.uidesign;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jem.liquidswipe.clippathprovider.LiquidSwipeClipPathProvider;
import com.jem.liquidswipe.layout.LiquidSwipeLinearLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Map extends Fragment {

    private LiquidSwipeLinearLayout liquidSwipeLinearLayout;
    private LiquidSwipeClipPathProvider liquidSwipeClipPathProvider;

    public Fragment_Map() {
        // Required empty public constructor
    }

    public Fragment_Map(LiquidSwipeClipPathProvider liquidSwipeClipPathProvider) {
        this.liquidSwipeClipPathProvider = liquidSwipeClipPathProvider;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment__map, container, false);
        liquidSwipeLinearLayout = view.findViewById(R.id.container);
        liquidSwipeLinearLayout.setClipPathProvider(liquidSwipeClipPathProvider);

        return view;
    }

}
