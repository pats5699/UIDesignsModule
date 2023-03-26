package com.example.uidesign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class Login4 extends AppCompatActivity {

    private TextView tvTitle, tvSubtitle;
    private View view_underline;
    private Button btn_login, btn_register;
    private Animation title, subtitle, underline, login, register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login4);

        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvSubtitle = (TextView) findViewById(R.id.tvSubtitle);
        view_underline = (View) findViewById(R.id.underline);
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_register = (Button) findViewById(R.id.btn_register);

        animate();


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Login4_1.class));
            }
        });


        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animate();
            }
        });

    }

    private void animate() {
        title = AnimationUtils.loadAnimation(this, R.anim.login4_title);

        subtitle = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        subtitle.setStartOffset(500);

        underline = AnimationUtils.loadAnimation(this, R.anim.login4_underline);
        underline.setStartOffset(500);

        login = AnimationUtils.loadAnimation(this, R.anim.left_right);
        login.setStartOffset(500);

        register = AnimationUtils.loadAnimation(this, R.anim.right_left);
        register.setStartOffset(500);

        tvTitle.startAnimation(title);
        view_underline.startAnimation(underline);
        tvSubtitle.startAnimation(subtitle);
        btn_login.startAnimation(login);
        btn_register.startAnimation(register);
    }
}
