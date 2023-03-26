package com.example.uidesign;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

public class Login4_1 extends AppCompatActivity {

    private TextView tvLoginText, tvForgotPassword;
    private ImageView ivBack;
    private EditText etEmail, etPassword;
    private Button btnLogin;
    private Animation fromtop, fade_in, left_right, right_left, frombottom, forgotpassword;
    private CustomSwitch customSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login4_1);

        tvLoginText = (TextView) findViewById(R.id.tvLoginText);
        tvForgotPassword = (TextView) findViewById(R.id.tvForgotPassword);
        ivBack = (ImageView) findViewById(R.id.ivBack);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btnLogin = (Button) findViewById(R.id.btn_login);

        customSwitch = new CustomSwitch(findViewById(R.id.customSwitch));
        customSwitch.setDefault(true);
        customSwitch.getSwitchValue();

        animate();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animate();
            }
        });

        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void animate() {
        fromtop = AnimationUtils.loadAnimation(this, R.anim.login4_title);

        fade_in = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        
        left_right = AnimationUtils.loadAnimation(this, R.anim.left_right);
        left_right.setStartOffset(100);

        right_left = AnimationUtils.loadAnimation(this, R.anim.right_left);
        right_left.setStartOffset(100);
        
        frombottom = AnimationUtils.loadAnimation(this, R.anim.login4_bottomtop);


        ivBack.startAnimation(fromtop);
        tvLoginText.startAnimation(fade_in);
//        customSwitch.startAnimation(fade_in);
        etEmail.startAnimation(left_right);
        etPassword.startAnimation(right_left);
        btnLogin.startAnimation(frombottom);
        tvForgotPassword.startAnimation(frombottom);
    }

}
