package com.example.uidesign;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.airbnb.lottie.LottieAnimationView;

public class LottieAnimations extends AppCompatActivity {

    boolean isCheckedDone = true, isSwitchOn = true;
    private int counter = 0;
    private Button btnNext;
    private LottieAnimationView lottieAnimationView, lottieCheckedDone, lottieSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lottie_animations);

        btnNext = (Button) findViewById(R.id.btnNext);
        lottieAnimationView = (LottieAnimationView) findViewById(R.id.lottieAnimationView);
        lottieCheckedDone = (LottieAnimationView) findViewById(R.id.lottieCheckedDone);
        lottieSwitch = (LottieAnimationView) findViewById(R.id.lottieSwitch);

        lottieCheckedDone.playAnimation();
        lottieCheckedDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isCheckedDone) {
                    lottieCheckedDone.setSpeed(-1); // This will play reverse animation with normal speed
                    lottieCheckedDone.playAnimation();
                    isCheckedDone = false;
                } else {
                    lottieCheckedDone.setSpeed(1); // This will play regular animation with normal speed
                    lottieCheckedDone.playAnimation();
                    isCheckedDone = true;
                }
            }
        });

        lottieSwitch.playAnimation();
        lottieSwitch.setSpeed(4f);
        lottieSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isSwitchOn) {
                    lottieSwitch.setMinAndMaxProgress(0.5f, 1.0f); //Switch OFF Animation
                    lottieSwitch.playAnimation();
                    isSwitchOn = false;
                } else {
                    lottieSwitch.setMinAndMaxProgress(0.0f, 0.5f); //Switch ON Animation
                    lottieSwitch.playAnimation();
                    isSwitchOn = true;
                }
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (counter < 4) {
                    counter++;
                } else {
                    counter = 0;
                }

                switch (counter) {
                    case 0:
                        lottieAnimationView.setAnimation(R.raw.lottie_pen_mug_main_logo);
                        lottieAnimationView.playAnimation();
                        break;

                    case 1:
                        lottieAnimationView.setAnimation(R.raw.lottie_glass_of_water);
                        lottieAnimationView.playAnimation();
                        break;

                    case 2:
                        lottieAnimationView.setAnimation(R.raw.lottie_play_the_guitar);
                        lottieAnimationView.playAnimation();
                        break;

                    case 3:
                        lottieAnimationView.setAnimation(R.raw.lottie_earth_animation);
                        lottieAnimationView.playAnimation();
                        break;

                    case 4:
                        lottieAnimationView.setAnimation(R.raw.lottie_stay_home);
                        lottieAnimationView.playAnimation();
                        break;
                }

            }
        });

    }
}
