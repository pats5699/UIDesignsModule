package com.example.uidesign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Login7 extends AppCompatActivity {

    private ImageView ivBackground, ivGradientTop, ivGradientBottom, ivNavigation, ivSearch;
    private LinearLayout llTop, llCenter;
    private Button btnSignup;

    //    Methods to get the window size in pixels
    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login7);


        ivBackground = (ImageView) findViewById(R.id.ivBackground);
        ivGradientTop = (ImageView) findViewById(R.id.ivGradientTop);
        ivGradientBottom = (ImageView) findViewById(R.id.ivGradientBottom);
        ivNavigation = (ImageView) findViewById(R.id.ivNavigation);
        ivSearch = (ImageView) findViewById(R.id.ivSearch);
        llTop = (LinearLayout) findViewById(R.id.llTop);
        llCenter = (LinearLayout) findViewById(R.id.llCenter);
        btnSignup = (Button) findViewById(R.id.btnSignup);

        animate();

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animate();
            }
        });

        ivNavigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivBackground.setBackground(getDrawable(R.drawable.login7_background));
            }
        });

        ivSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivBackground.setBackground(getDrawable(R.drawable.login7_background_2));
            }
        });


    }

    private void animate() {

        ivBackground.setAlpha(0f);
        llTop.setTranslationY(-((float) llTop.getHeight() * 4));
        llCenter.setTranslationX(-(getScreenWidth() / 10f));
        llCenter.setAlpha(0);
        btnSignup.setTranslationX(getScreenWidth() / 10f);
        btnSignup.setAlpha(0);
        ivGradientTop.setTranslationX(-(getScreenWidth() * 1.5f));
        ivGradientBottom.setTranslationX(getScreenWidth() * 1.5f);

        ivBackground.animate().alpha(1).setDuration(1000).setStartDelay(0);
        llTop.animate().translationY(0).setDuration(600).setStartDelay(900);
        llCenter.animate().translationX(0).alpha(1).setDuration(600).setStartDelay(1000);
        btnSignup.animate().translationX(0).alpha(1).setDuration(600).setStartDelay(1000);
        ivGradientTop.animate().translationX(0).setDuration(1000).setStartDelay(1500);
        ivGradientBottom.animate().translationX(0).setDuration(1000).setStartDelay(1500);


    }


}
