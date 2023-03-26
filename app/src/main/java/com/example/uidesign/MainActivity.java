package com.example.uidesign;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    CardView cvLoginScreen, cvProfileScreen, cvNavigation, cvWalkthrough, cvMaterialDesign;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intent = new Intent(getApplicationContext(), RecyclerActivity.class);

        cvLoginScreen = (CardView) findViewById(R.id.cvLoginScreen);
        cvProfileScreen = (CardView) findViewById(R.id.cvProfileScreen);
        cvNavigation = (CardView) findViewById(R.id.cvNavigation);
        cvWalkthrough = (CardView) findViewById(R.id.cvWalkthrough);
        cvMaterialDesign = (CardView) findViewById(R.id.cvMaterialDesign);


        cvLoginScreen.setOnClickListener(MainActivity.this);
        cvProfileScreen.setOnClickListener(MainActivity.this);
        cvNavigation.setOnClickListener(MainActivity.this);
        cvWalkthrough.setOnClickListener(MainActivity.this);
        cvMaterialDesign.setOnClickListener(MainActivity.this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cvLoginScreen:
                intent.putExtra("Activity", "LoginScreen");
                startActivity(intent);

                break;

            case R.id.cvProfileScreen:
                intent.putExtra("Activity", "ProfileScreen");
                startActivity(intent);
                break;

            case R.id.cvNavigation:
                intent.putExtra("Activity", "Navigation");
                startActivity(intent);
                break;

            case R.id.cvWalkthrough:
                intent.putExtra("Activity", "Walkthrough");
                startActivity(intent);
                break;

            case R.id.cvMaterialDesign:
                intent.putExtra("Activity", "MaterialDesign");
                startActivity(intent);
                break;
        }
    }
}
