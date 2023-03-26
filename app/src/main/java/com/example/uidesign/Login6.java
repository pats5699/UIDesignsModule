package com.example.uidesign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.VideoView;

public class Login6 extends AppCompatActivity {

    private LinearLayout llTop, llBottom;
    private EditText etUsername, etPassword;
    private Button btnLogin, btnCreateAccount;
    private TextureVideoView mTextureVideoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login6);

        llTop = (LinearLayout) findViewById(R.id.llTop);
        llBottom = (LinearLayout) findViewById(R.id.llBottom);
        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnCreateAccount = (Button) findViewById(R.id.btnCreateAccount);


        llTop.setTranslationY(-900);
        llBottom.setTranslationY(900);
        etUsername.setTranslationX(-getScreenWidth()-300);
        etPassword.setTranslationX(getScreenWidth()+300);


        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.login6background1080);

        mTextureVideoView = (TextureVideoView) findViewById(R.id.cropTextureView);
        mTextureVideoView.setScaleType(TextureVideoView.ScaleType.CENTER_CROP);
        mTextureVideoView.setDataSource(this, uri);
        mTextureVideoView.setLooping(true);

        mTextureVideoView.setListener(new TextureVideoView.MediaPlayerListener() {
            @Override
            public void onVideoPrepared() {
                mTextureVideoView.play();
                animate();

            }

            @Override
            public void onVideoEnd() {

            }
        });



        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animate();
            }
        });

        btnCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llTop.setTranslationY(-900);
                llBottom.setTranslationY(300);
                etUsername.setTranslationX(-getScreenWidth()-300);
                etPassword.setTranslationX(getScreenWidth()+300);
            }
        });


    }

    private void animate() {
        llTop.setTranslationY(-900);
        llBottom.setTranslationY(900);
        etUsername.setTranslationX(-getScreenWidth()-300);
        etPassword.setTranslationX(getScreenWidth()+300);

        llTop.animate().translationY(0).setDuration(500);
        llBottom.animate().translationY(0).setDuration(500);
        etUsername.animate().translationX(0).setDuration(500);
        etPassword.animate().translationX(0).setDuration(500);


    }

    @Override
    protected void onResume() {
        super.onResume();
        // to restart the video after coming from other activity like Sing up
        mTextureVideoView.play();

    }


    //    Methods to get the window size in pixels
    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

}
