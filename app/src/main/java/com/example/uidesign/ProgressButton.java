package com.example.uidesign;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.github.ybq.android.spinkit.SpinKitView;
import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.ChasingDots;
import com.github.ybq.android.spinkit.style.Circle;
import com.github.ybq.android.spinkit.style.CubeGrid;
import com.github.ybq.android.spinkit.style.DoubleBounce;
import com.github.ybq.android.spinkit.style.FadingCircle;
import com.github.ybq.android.spinkit.style.FoldingCube;
import com.github.ybq.android.spinkit.style.MultiplePulse;
import com.github.ybq.android.spinkit.style.MultiplePulseRing;
import com.github.ybq.android.spinkit.style.Pulse;
import com.github.ybq.android.spinkit.style.PulseRing;
import com.github.ybq.android.spinkit.style.RotatingCircle;
import com.github.ybq.android.spinkit.style.RotatingPlane;
import com.github.ybq.android.spinkit.style.ThreeBounce;
import com.github.ybq.android.spinkit.style.WanderingCubes;
import com.github.ybq.android.spinkit.style.Wave;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import br.com.simplepass.loadingbutton.customViews.CircularProgressButton;

public class ProgressButton extends AppCompatActivity implements View.OnClickListener {

    View view;
    SpinKitView circleProgress;
    private CircularProgressButton btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progress_button);

        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progress);
        Sprite rotatingPlane = new RotatingPlane();
        progressBar.setIndeterminateDrawable(rotatingPlane);

        btn = (CircularProgressButton) findViewById(R.id.circleProgressButton);
        circleProgress = (SpinKitView) findViewById(R.id.circleProgress);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn.startAnimation();
                circleProgress.animate().alpha(1).setDuration(100).setStartDelay(200);
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        circleProgress.setAlpha(0);
                        btn.revertAnimation();
                    }
                }, 4000);
            }
        });

        view = findViewById(R.id.myProgressButton);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressButtonItem progressButtonItem = new ProgressButtonItem(ProgressButton.this, view);

                progressButtonItem.buttonActivated();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        progressButtonItem.buttonFinished();
                        Handler handler1 = new Handler();
                        handler1.postDelayed(new Runnable() {
                            @Override
                            public void run() {
//                                onBackPressed();
//                                Toast.makeText(ProgressButton.this, "Task Completed", Toast.LENGTH_SHORT).show();
                            }
                        }, 2000);
                    }
                }, 3000);
            }
        });

        View view = findViewById(R.id.material_button);
        final MaterialButtonProcess materialButton = new MaterialButtonProcess(view);
        materialButton.setText("PAYMENT");
        materialButton.setBackgroundColor("#6200EE");
        materialButton.setVectorIcon(R.drawable.ic_shopping_cart);
        materialButton.setRadiusPixel(2);
        materialButton.setProgressColor("#FFFFFF");
        materialButton.setIconColor("#FFFFFF");
        materialButton.setTextColor("#FFFFFF");

        materialButton.getButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                materialButton.setProgressVisibility(true);
            }
        });


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.progress:
                circleProgress.setIndeterminateDrawable(new RotatingPlane());
                break;
            case R.id.DoubleBounce:
                circleProgress.setIndeterminateDrawable(new DoubleBounce());
                break;
            case R.id.Wave:
                circleProgress.setIndeterminateDrawable(new Wave());
                break;
            case R.id.WanderingCubes:
                circleProgress.setIndeterminateDrawable(new WanderingCubes());
                break;
            case R.id.Pulse:
                circleProgress.setIndeterminateDrawable(new Pulse());
                break;
            case R.id.ChasingDots:
                circleProgress.setIndeterminateDrawable(new ChasingDots());
                break;
            case R.id.ThreeBounce:
                circleProgress.setIndeterminateDrawable(new ThreeBounce());
                break;
            case R.id.Circle:
                circleProgress.setIndeterminateDrawable(new Circle());
                break;
            case R.id.CubeGrid:
                circleProgress.setIndeterminateDrawable(new CubeGrid());
                break;
            case R.id.FadingCircle:
                circleProgress.setIndeterminateDrawable(new FadingCircle());
                break;
            case R.id.FoldingCube:
                circleProgress.setIndeterminateDrawable(new FoldingCube());
                break;
            case R.id.RotatingCircle:
                circleProgress.setIndeterminateDrawable(new RotatingCircle());
                break;
            case R.id.MultiplePulse:
                circleProgress.setIndeterminateDrawable(new MultiplePulse());
                break;
            case R.id.PulseRing:
                circleProgress.setIndeterminateDrawable(new PulseRing());
                break;
            case R.id.MultiplePulseRing:
                circleProgress.setIndeterminateDrawable(new MultiplePulseRing());
                break;
        }

    }

    class ProgressButtonItem {
        Animation fade_in;
        private CardView cardView;
        private ConstraintLayout layout;
        private ProgressBar progressBar;
        private TextView textView;

        public ProgressButtonItem(Context ct, View view) {
            fade_in = AnimationUtils.loadAnimation(ct, R.anim.fade_in);
            fade_in.setDuration(400);
            cardView = view.findViewById(R.id.cardView);
            layout = view.findViewById(R.id.constraint_layout);
            progressBar = view.findViewById(R.id.progressBar);
            textView = view.findViewById(R.id.textView);
        }

        void buttonActivated() {
            progressBar.setAnimation(fade_in);
            progressBar.setVisibility(View.VISIBLE);
            textView.setAnimation(fade_in);
            textView.setText("Please Wait...");
        }

        void buttonFinished() {
            layout.setBackgroundColor(cardView.getResources().getColor(R.color.login4_green));
            progressBar.setVisibility(View.GONE);
            textView.setText("Done");
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    textView.setText("Login");
                    layout.setBackgroundColor(cardView.getResources().getColor(R.color.login3_red));
                }
            }, 2000);
        }

    }


}
