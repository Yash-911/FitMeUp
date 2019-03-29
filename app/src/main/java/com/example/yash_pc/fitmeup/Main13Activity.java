package com.example.yash_pc.fitmeup;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Main13Activity extends AppCompatActivity {
    EditText ed1,ed2,ed3,ed4;
    TextView edx;
    String Name,phone;
    float weight,height;
    float BMI;
    ImageView iv;
    static final int REQUEST_IMAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main13);
        ed1=(EditText)findViewById(R.id.editText9);
        ed2=(EditText)findViewById(R.id.editText10);
        ed3=(EditText)findViewById(R.id.editText12);
        ed4=(EditText)findViewById(R.id.editText13);
        edx=(TextView)findViewById(R.id.textView5);
        iv=(ImageView)findViewById(R.id.imageView3);
    }
    public void enter()
    {
        Name=ed1.getText().toString().trim();
        weight=Float.parseFloat(ed3.getText().toString());
        height=Float.parseFloat(ed2.getText().toString());
        phone=ed4.getText().toString().trim();
    }
    public void set()
    {
        BMI=weight/height;

        ed1.setText(Name);
        ed2.setText(String.valueOf(height));
        ed3.setText(String.valueOf(weight));
        ed4.setText(phone);
        edx.setText(String.valueOf(BMI));
    }
    public void store(View view)
    {
        enter();
        set();
    }
   /* private boolean present() {

    }
    public void picture(View v)
    {

    }*/


}
