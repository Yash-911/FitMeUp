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
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class Main9Activity extends AppCompatActivity {
    FirebaseAuth auth;
    EditText e1,e2;
    Button b1,b2,b3;
    PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallback;
    String verificationcode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);
        e1=(EditText)findViewById(R.id.editText6);
        e2=(EditText)findViewById(R.id.editText7);
        b1=(Button)findViewById(R.id.button19);
        b2=(Button)findViewById(R.id.button22);
        b3=(Button)findViewById(R.id.button23);
        auth=FirebaseAuth.getInstance();
        mCallback=new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {

            }

            @Override
            public void onVerificationFailed(FirebaseException e) {
            }

            @Override
            public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken)
            {
                super.onCodeSent(s, forceResendingToken);
                verificationcode=s;
                Toast.makeText(Main9Activity.this,"Code sent",Toast.LENGTH_SHORT).show();
            }
        };
    }

    public void send_sms(View v)
    {
        String number=e1.getText().toString();
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                number,60,TimeUnit.SECONDS,this,mCallback
        );
    }

    public void signInWithPhone(PhoneAuthCredential credential)
    {
        auth.signInWithCredential(credential)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(Main9Activity.this,"Sign in Successfull",Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(Main9Activity.this,Main4Activity.class);
                            startActivity(intent);

                        }
                        else
                        {
                            Toast.makeText(getBaseContext(),"Sign In failed",Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }

    public void verifys(View v)
    {
        String inputcode=e2.getText().toString();
        if(inputcode.length()==0)
        {
            Toast.makeText(getBaseContext(),"Enter OTP",Toast.LENGTH_SHORT).show();
        }
        else
        {
            verifyPhoneNumber(verificationcode,inputcode);

        }

    }

    public void verifyPhoneNumber(String verifycode,String inputcode)
    {

        PhoneAuthCredential credential=PhoneAuthProvider.getCredential(verifycode,inputcode);
        signInWithPhone(credential);

    }


}

