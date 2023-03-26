package com.example.uidesign;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.wooplr.spotlight.SpotlightView;

import java.util.ArrayList;
import java.util.Random;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Temp extends AppCompatActivity implements Nav.NavClick {

    Button btnmenu;
    View view;
    private DrawerLayout mDrawerLayout;
    private RecyclerView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;
    private FrameLayout frame;
    private float lastTranslate = 0.0f;
    private ArrayList<String> list;
    private SpotlightView spotlightView;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (RecyclerView) findViewById(R.id.left_drawer);
        frame = (FrameLayout) findViewById(R.id.content_frame);

        btnmenu = (Button) findViewById(R.id.btnmenu);


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mDrawerList.setLayoutManager(layoutManager);

        list = new ArrayList<>();
        list.add("Hello");

        final Nav navAdapter = new Nav(list, this, this);
        mDrawerList.setAdapter(navAdapter);

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.acc_drawer_open, R.string.acc_drawer_close) {
            @SuppressLint("NewApi")
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                float moveFactor = (mDrawerList.getWidth() * slideOffset);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                    frame.setTranslationX(moveFactor);
                } else {
                    TranslateAnimation anim = new TranslateAnimation(lastTranslate, moveFactor, 0.0f, 0.0f);
                    anim.setDuration(0);
                    anim.setFillAfter(true);
                    frame.startAnimation(anim);

                    lastTranslate = moveFactor;
                }
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);


        btnmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // If the navigation drawer is not open then open it, if its already open then close it.
                if (!mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
                    mDrawerLayout.openDrawer(GravityCompat.START);
                    navAdapter.method();
                } else mDrawerLayout.closeDrawer(GravityCompat.END);
            }
        });


        spotLightBuilder();
    }

    private void spotLightBuilder() {
        spotlightView = new SpotlightView.Builder(this)
                .introAnimationDuration(400)
                .enableRevealAnimation(false)
                .performClick(true)
                .fadeinTextDuration(400)
                .headingTvColor(Color.parseColor("#eb273f"))
                .headingTvSize(32)
                .headingTvText("Navigation Drawer Animation")
                .subHeadingTvColor(Color.parseColor("#ffffff"))
                .subHeadingTvSize(22)
                .subHeadingTvText("Click this Button")
                .maskColor(Color.parseColor("#dc000000"))
                .target(btnmenu)
                .lineAnimDuration(400)
                .lineAndArcColor(Color.parseColor("#eb273f"))
                .dismissOnTouch(true)
                .dismissOnBackPress(true)
                .enableDismissAfterShown(true)
                .show();

        spotlightView.setUsageId(String.valueOf(new Random(1000)));
    }


    @Override
    public void onItemClick(View view) {
        //Handling the Clicks on Navigation Items

        switch (view.getId()) {
            case R.id.exp:
                Toast.makeText(this, "Explore", Toast.LENGTH_SHORT).show();
                mDrawerLayout.closeDrawer(GravityCompat.START);
                break;

            case R.id.ao:
                Toast.makeText(this, "AddOns", Toast.LENGTH_SHORT).show();
                mDrawerLayout.closeDrawer(GravityCompat.START);
                break;

            case R.id.msg:
                Toast.makeText(this, "Messages", Toast.LENGTH_SHORT).show();
                mDrawerLayout.closeDrawer(GravityCompat.START);
                break;

            case R.id.st:
                Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
                mDrawerLayout.closeDrawer(GravityCompat.START);
                break;

            case R.id.so:
                Toast.makeText(this, "Sign Out", Toast.LENGTH_SHORT).show();
                mDrawerLayout.closeDrawer(GravityCompat.START);
                break;
        }
    }
}
