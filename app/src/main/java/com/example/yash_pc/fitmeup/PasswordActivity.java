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
import com.google.firebase.auth.FirebaseAuth;

public class PasswordActivity extends AppCompatActivity {
    EditText email;
    Button reset;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        email=(EditText)findViewById(R.id.editText8);
        reset=(Button)findViewById(R.id.button27);
        firebaseAuth=FirebaseAuth.getInstance();
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String useremail=email.getText().toString().trim();
                if(useremail.equals(""))
                {
                    Toast.makeText(PasswordActivity.this,"Please enter registered email id",Toast.LENGTH_SHORT).show();

                }
                else
                {
                    firebaseAuth.sendPasswordResetEmail(useremail).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful())
                            {
                                Toast.makeText(PasswordActivity.this,"Password reset email sent",Toast.LENGTH_SHORT).show();
                                finish();
                                startActivity(new Intent(PasswordActivity.this,Main2Activity.class));
                            }
                            else
                            {
                                Toast.makeText(PasswordActivity.this,"Error in sending reset password",Toast.LENGTH_SHORT).show();

                            }
                        }
                    });
                }
            }
        });
    }
}
