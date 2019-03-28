package com.example.yash_pc.fitmeup;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class Main7Activity extends AppCompatActivity implements SensorEventListener {
    Button b,b1,b2;
    TextView tv_steps;
    ProgressBar progressBar;
    SensorManager sensorManager;
    boolean running=false;
    int steps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        b=(Button)findViewById(R.id.button10);
        b1=(Button)findViewById(R.id.button11);
        b2=(Button)findViewById(R.id.button12);

        progressBar=(ProgressBar)findViewById(R.id.progressBar2);
        tv_steps=findViewById(R.id.textView4);
        sensorManager=(SensorManager)getSystemService(SENSOR_SERVICE);
        progressBar.setMax(1000);
    }
    @Override
    public void onResume() {
        super.onResume();
        running=true;
        Sensor countsensor=sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        if(countsensor != null)
        {
            sensorManager.registerListener(this,countsensor,SensorManager.SENSOR_DELAY_UI);
        }
        else
        {
            Toast.makeText(Main7Activity.this,"Sensor not found",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        running=false;
    }

    @Override
    public void onSensorChanged(final SensorEvent event) {

        if(running)
        {
            steps=(int)event.values[0];
            tv_steps.setText(String.valueOf(steps));
            progressBar.setProgress(steps);
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
    public void home4(View v)
    {
        Intent intent=new Intent(Main7Activity.this,Main4Activity.class);
        startActivity(intent);
    }
    public void settings5(View v)
    {
        Intent intent=new Intent(Main7Activity.this,Main8Activity.class);
        startActivity(intent);
    }
    public void diet3(View v)
    {
        Intent intent=new Intent(Main7Activity.this,Main6Activity.class);
        startActivity(intent);
    }
}
