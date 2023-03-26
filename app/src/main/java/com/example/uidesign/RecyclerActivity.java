package com.example.uidesign;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class RecyclerActivity extends AppCompatActivity implements RecyclerAdapter.OnItemClickListener {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<String> titles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_activity);

        String activity = getIntent().getStringExtra("Activity");

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(activity);
        }

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);

        titles = new ArrayList<>();

        if (activity.equals("LoginScreen")){
            titles.add("Insta Login");
            titles.add("Login 2");
            titles.add("Login 3");
            titles.add("Login 4");
            titles.add("Login 5");
            titles.add("Login 6");
            titles.add("Login 7");
            titles.add("OTP Verification");


        }else if (activity.equals("ProfileScreen")) {
            titles.add("Profile Design");

        }else if (activity.equals("Navigation")) {
            titles.add("Tab Navigation Strip");
            titles.add("Navigation Animation");

        }else if (activity.equals("Walkthrough")) {
            titles.add("Card Swipe");
            titles.add("Liquid Swipe");

        }else if (activity.equals("MaterialDesign")) {
            titles.add("Custom Alert Dialog");
            titles.add("Image Slider");
            titles.add("Progress Button");
            titles.add("Lottie Animations");

        }

        mAdapter = new RecyclerAdapter(titles, this);
        recyclerView.setAdapter(mAdapter);

    }

    @Override
    public void onItemClick(int position, String str) {
        /* Login Page  */
        if (str.equals("Insta Login")) {
            startActivity(new Intent(this, InstaLogin.class));
        }

        if (str.equals("Login 2")) {
            startActivity(new Intent(this, Login2.class));
        }

        if (str.equals("Login 3")) {
            startActivity(new Intent(this, Login3.class));
        }

        if (str.equals("Login 4")) {
            startActivity(new Intent(this, Login4.class));
        }

        if (str.equals("Login 5")) {
            startActivity(new Intent(this, Login5.class));
        }

        if (str.equals("Login 6")) {
            startActivity(new Intent(this, Login6.class));
        }

        if (str.equals("Login 7")) {
            startActivity(new Intent(this, Login7.class));
        }

        if (str.equals("OTP Verification")) {
            startActivity(new Intent(this, OTPVerification.class));
        }

        /* Profile Screen */
        if (str.equals("Profile Design")){
            startActivity(new Intent(this, ProfileDesign.class));
        }

        /* Navigation */
        if (str.equals("Tab Navigation Strip")){
            startActivity(new Intent(this, TabNavigationStrip.class));
        }

        if (str.equals("Navigation Animation")){
            startActivity(new Intent(this, Temp.class));
        }

        /* Walk Through */
        if (str.equals("Card Swipe")){
            startActivity(new Intent(this, SwipeCardViewPager.class));
        }

        if (str.equals("Liquid Swipe")){
            startActivity(new Intent(this, MyLiquidSwipe.class));
        }

        /* Material Design */
        if (str.equals("Custom Alert Dialog")){
            startActivity(new Intent(this, CustomAlertDialog.class));
        }

        if (str.equals("Image Slider")){
            startActivity(new Intent(this, ImageSlider.class));
        }

        if (str.equals("Progress Button")){
            startActivity(new Intent(this, ProgressButton.class));
        }

        if (str.equals("Lottie Animations")){
            startActivity(new Intent(this, LottieAnimations.class));
        }



    }
}
