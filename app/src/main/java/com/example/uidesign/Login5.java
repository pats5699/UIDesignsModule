package com.example.uidesign;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Login5 extends AppCompatActivity {

    TextView tvTitle, tvSubtitle;
    EditText etEmail, etPassword;
    Button btnSignIn, btnSignInFacebook, btn_cross, btnSignIn2;
    ImageView ivBackground;
    LinearLayout linearLayout;
    Animation bottomUp, title_subtitle, topDown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login5);

        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvSubtitle = (TextView) findViewById(R.id.tvSubtitle);
        btn_cross = (Button) findViewById(R.id.btn_cross);
        btnSignIn = (Button) findViewById(R.id.btn_signin);
        btnSignInFacebook = (Button) findViewById(R.id.btn_signin_facebook);
        ivBackground = (ImageView) findViewById(R.id.ivBackground);

        linearLayout = (LinearLayout) findViewById(R.id.linlay);

        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btnSignIn2 = (Button) findViewById(R.id.btn_signin_2);


        ivBackground.setTranslationY(0);
        tvTitle.setTranslationY(0);
        tvSubtitle.setTranslationY(0);
        btnSignIn.setTranslationY(0);
        btnSignInFacebook.setTranslationY(0);

        etEmail.setTranslationY(500);   etEmail.setAlpha(0);
        etPassword.setTranslationY(500);    etPassword.setAlpha(0);
        btnSignIn2.setTranslationY(500);    btnSignIn2.setAlpha(0);
        btn_cross.setTranslationY(500);     btn_cross.setScaleX(0);     btn_cross.setScaleY(0);


        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animate();


            }
        });

        btnSignIn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animate();
            }
        });

        btn_cross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animateReverse();
            }
        });


    }

//    Animation Forward
    private void animate() {

        ivBackground.setTranslationY(0);
        tvTitle.setTranslationY(0);
        tvSubtitle.setTranslationY(0);
        btnSignIn.setTranslationY(0);
        btnSignInFacebook.setTranslationY(0);

        etEmail.setTranslationY(500);   etEmail.setAlpha(0);
        etPassword.setTranslationY(500);    etPassword.setAlpha(0);
        btnSignIn2.setTranslationY(500);    btnSignIn2.setAlpha(0);
        btn_cross.setTranslationY(500);     btn_cross.setScaleX(0);     btn_cross.setScaleY(0);

        btnSignIn.setClickable(false);
        btnSignInFacebook.setClickable(false);
        linearLayout.setVisibility(View.VISIBLE);

/*      These are the animations using the xml files which can be done by using only java as done here.

        bottomUp = AnimationUtils.loadAnimation(this, R.anim.login5_bottom_up);
        title_subtitle = AnimationUtils.loadAnimation(this, R.anim.login5_title_subtitle);
        topDown = AnimationUtils.loadAnimation(Login5.this, R.anim.login5_top_down);

        ivBackground.startAnimation(bottomUp);
        tvTitle.startAnimation(title_subtitle);
        tvSubtitle.startAnimation(title_subtitle);
        btnSignIn.startAnimation(topDown);
        btnSignInFacebook.startAnimation(topDown);

*/

        ivBackground.animate().translationY(-(getScreenHeight()/2f)).setDuration(600);
        tvTitle.animate().translationY(-(getScreenHeight()/5f)).setDuration(600);
        tvSubtitle.animate().translationY(-(getScreenHeight()/5f)).setDuration(600);
        btnSignIn.animate().translationY(getScreenHeight()/2f).setDuration(500);
        btnSignInFacebook.animate().translationY(getScreenHeight()/2f).setDuration(500);


        etEmail.animate().translationY(40).alpha(1).setDuration(600).setStartDelay(200);
        etPassword.animate().translationY(40).alpha(1).setDuration(600).setStartDelay(200);
        btnSignIn2.animate().translationY(40).alpha(1).setDuration(600).setStartDelay(200);

        btn_cross.animate().translationY(40).scaleX(1).scaleY(1).setDuration(400).setStartDelay(200);


    }

//    Animation Reverse
    private void animateReverse() {

        ivBackground.setTranslationY(-(getScreenHeight()/2f));
        tvTitle.setTranslationY(-(getScreenHeight()/5f));
        tvSubtitle.setTranslationY(-(getScreenHeight()/5f));
        btnSignIn.setTranslationY(getScreenHeight()/2f);
        btnSignInFacebook.setTranslationY(getScreenHeight()/2f);

        etEmail.setTranslationY(40);   etEmail.setAlpha(1);
        etPassword.setTranslationY(40);    etPassword.setAlpha(1);
        btnSignIn2.setTranslationY(40);    btnSignIn2.setAlpha(1);

        btn_cross.setTranslationY(40);     btn_cross.setScaleX(1);     btn_cross.setScaleY(1);

        btnSignIn.setClickable(true);
        btnSignInFacebook.setClickable(true);


/*      These are the animations using the xml files which can be done by using only java as done here.

        bottomUp = AnimationUtils.loadAnimation(this, R.anim.login5_bottom_up);
        title_subtitle = AnimationUtils.loadAnimation(this, R.anim.login5_title_subtitle);
        topDown = AnimationUtils.loadAnimation(Login5.this, R.anim.login5_top_down);

        ivBackground.startAnimation(bottomUp);
        tvTitle.startAnimation(title_subtitle);
        tvSubtitle.startAnimation(title_subtitle);
        btnSignIn.startAnimation(topDown);
        btnSignInFacebook.startAnimation(topDown);

*/

        ivBackground.animate().translationY(0).setDuration(600);
        tvTitle.animate().translationY(0).setDuration(600);
        tvSubtitle.animate().translationY(0).setDuration(600);
        btnSignIn.animate().translationY(0).setDuration(500);
        btnSignInFacebook.animate().translationY(0).setDuration(500);


        etEmail.animate().translationY(500).alpha(0).setDuration(600).setStartDelay(200);
        etPassword.animate().translationY(500).alpha(0).setDuration(600).setStartDelay(200);
        btnSignIn2.animate().translationY(500).alpha(0).setDuration(600).setStartDelay(200);

        btn_cross.animate().translationY(500).scaleX(0).scaleY(0).setDuration(400).setStartDelay(200);


    }

//    Methods to get the window size in pixels
    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }


}
