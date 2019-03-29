package com.example.yash_pc.fitmeup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main14Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main14);

    }
    public void call(View v)
    {
        Intent intent=new Intent(Main14Activity.this,Main10Activity.class);
        startActivity(intent);
    }
    public void homev(View v)
    {
        Intent intent=new Intent(Main14Activity.this,Main4Activity.class);
        startActivity(intent);
    }
    public void sett(View v)
    {
        Intent intent=new Intent(Main14Activity.this,Main8Activity.class);
        startActivity(intent);
    }
}
