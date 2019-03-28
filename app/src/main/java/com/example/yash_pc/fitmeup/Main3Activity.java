package com.example.yash_pc.fitmeup;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Main3Activity extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    EditText ed1,ed2,ed3;
    Button b,b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ed1=(EditText)findViewById(R.id.editText3);
        ed2=(EditText)findViewById(R.id.editText4);
        ed3=(EditText)findViewById(R.id.editText5);
        b=(Button)findViewById(R.id.button3);
        b1=(Button)findViewById(R.id.button4);
        firebaseAuth=FirebaseAuth.getInstance();
    }
    public void next(View v)
    {
        String email=ed1.getText().toString().trim();
        String password=ed2.getText().toString().trim();
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Intent intent=new Intent(Main3Activity.this,Main2Activity.class);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(Main3Activity.this,"Registration Failed",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
    public void back(View v)
    {
        Intent intent=new Intent(Main3Activity.this,Main2Activity.class);
        startActivity(intent);
    }
}
