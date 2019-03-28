package com.example.yash_pc.fitmeup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Main6Activity extends AppCompatActivity {
    Button b,b1;
    ImageView iv;
    TextView tv1,tv2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        tv1=(TextView)findViewById(R.id.textView7);
        tv2=(TextView)findViewById(R.id.textView8);
        b=(Button)findViewById(R.id.button15);
        b1=(Button)findViewById(R.id.button13);
    }

    public void settings3(View v)
    {
        Intent intent=new Intent(Main6Activity.this,Main8Activity.class);
        startActivity(intent);
    }
    public void home3(View v)
    {
        Intent intent=new Intent(Main6Activity.this,Main4Activity.class);
        startActivity(intent);
    }
}
