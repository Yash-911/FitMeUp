package com.example.yash_pc.fitmeup;

import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity {
    private long backPressedTime;
    private Toast backToast;
    Button b,b2,b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        b=(Button)findViewById(R.id.button5);
        b2=(Button)findViewById(R.id.button9);
        b1=(Button)findViewById(R.id.button8);
    }
    public void onBackPressed() {
        if(backPressedTime + 2000 > System.currentTimeMillis())
        {
            super.onBackPressed();
            ActivityCompat.finishAffinity(this);
            return;
        }
        else
        {
            backToast=Toast.makeText(getBaseContext(),"Press Again To Exit",Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime=System.currentTimeMillis();
    }

    public void alarm(View v)
    {
        Intent intent=new Intent(Main4Activity.this,Main5Activity.class);
        startActivity(intent);
    }
    public void steps(View v)
    {
        Intent intent=new Intent(Main4Activity.this,Main7Activity.class);
        startActivity(intent);
    }
    public void diet(View v)
    {
        Intent intent=new Intent(Main4Activity.this,Main14Activity.class);
        startActivity(intent);
    }
    public void settings4(View v)
    {
        Intent intent=new Intent(Main4Activity.this,Main8Activity.class);
        startActivity(intent);
    }
    public void recyclerlog(View v)
    {
        Intent intent=new Intent(Main4Activity.this,Main10Activity.class);
        startActivity(intent);
    }
    public void healthtips(View v)
    {
        Intent intent=new Intent(Main4Activity.this,Main11Activity.class);
        startActivity(intent);
    }
}
