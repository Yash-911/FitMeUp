package com.example.yash_pc.fitmeup;

import android.content.Intent;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView logo;
    private static int splashTimeOut=2000;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logo= findViewById(R.id.imageView);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
                finish();
            }
        },splashTimeOut);

        Animation myanim=AnimationUtils.loadAnimation(this,R.anim.splashanimation);
        logo.startAnimation(myanim);

    }
}
