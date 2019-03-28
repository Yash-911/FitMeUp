package com.example.yash_pc.fitmeup;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class Main8Activity extends AppCompatActivity {
    FirebaseAuth mAuth;
    Button b,b1,b2;
    GoogleSignInClient mGoogleSignInClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth=FirebaseAuth.getInstance();
        setContentView(R.layout.activity_main8);
        b=(Button)findViewById(R.id.button20);
        b1=(Button)findViewById(R.id.button21);
        b2=(Button)findViewById(R.id.button14);

    }
    public void home5(View v)
    {
        Intent intent=new Intent(Main8Activity.this,Main4Activity.class);
        startActivity(intent);
    }

    public void re4(View v)
    {
        Intent intent=new Intent(Main8Activity.this,Main10Activity.class);
        startActivity(intent);
    }
    public void logout(View v)
    {
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        mGoogleSignInClient= GoogleSignIn.getClient(this,gso);
        mGoogleSignInClient.signOut()
                .addOnCompleteListener(Main8Activity.this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        // ...
                    }
                });
        mAuth.signOut();
        finish();
        Intent intent=new Intent(Main8Activity.this,Main2Activity.class);
        startActivity(intent);
    }
}