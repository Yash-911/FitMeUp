package com.example.yash_pc.fitmeup;

import android.content.Intent;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Main5Activity extends AppCompatActivity {
    Button b,b1,b2,b3;
    Spinner s;
    String record;

    String name[]={"Hydration Reminder","Medicine Reminder","Appointment Reminder","Calorie Log Reminder"};
    ArrayAdapter <String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        b=(Button)findViewById(R.id.button7);
        b1=(Button)findViewById(R.id.button16);
        b2=(Button)findViewById(R.id.button17);
        b3=(Button)findViewById(R.id.button18);
        s=(Spinner)findViewById(R.id.spinner);
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,name);
        s.setAdapter(adapter);
        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch(position) {
                    case 0:
                        record = "Hydration Reminder";
                        Toast.makeText(Main5Activity.this,record,Toast.LENGTH_LONG).show();
                        break;

                    case 1:
                        record = "Medicine Reminder";
                        Toast.makeText(Main5Activity.this,record,Toast.LENGTH_LONG).show();
                        break;
                    case 2:
                        record = "Appointment Reminder";
                        Toast.makeText(Main5Activity.this,record,Toast.LENGTH_LONG).show();
                        break;
                    case 3:
                        record = "Calorie Log Reminder";
                        Toast.makeText(Main5Activity.this,record,Toast.LENGTH_LONG).show();
                        break;


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
    public void set(View v)
    {
        Intent intent=new Intent(AlarmClock.ACTION_SET_ALARM);
        intent.putExtra(AlarmClock.EXTRA_HOUR,10);
        intent.putExtra(AlarmClock.EXTRA_MINUTES,10);
        startActivity(intent);
    }
    public void diet1(View v)
    {
        Intent intent=new Intent(Main5Activity.this,Main6Activity.class);
        startActivity(intent);
    }
    public void settings1(View v)
    {
        Intent intent=new Intent(Main5Activity.this,Main8Activity.class);
        startActivity(intent);
    }
    public void home2(View v)
    {
        Intent intent=new Intent(Main5Activity.this,Main4Activity.class);
        startActivity(intent);
    }



}
