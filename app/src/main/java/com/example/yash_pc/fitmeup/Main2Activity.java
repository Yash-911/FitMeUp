package com.example.yash_pc.fitmeup;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class Main2Activity extends AppCompatActivity {
    FirebaseAuth mAuth;
    FirebaseUser mUser;
    EditText ed1,ed2;
    Button b,b1,b2;
    GoogleSignInClient mGoogleSignInClient;
    Button signInButton;
    Button pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        b=(Button)findViewById(R.id.button);
        ed1= findViewById(R.id.editText);
        ed2= findViewById(R.id.editText2);
        pass=(findViewById(R.id.button28));
        mAuth=FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();
        if(mUser!=null){
            Intent intent=new Intent(Main2Activity.this,Main4Activity.class);
            startActivity(intent);
        }
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        mGoogleSignInClient= GoogleSignIn.getClient(this,gso);
        signInButton=(Button)findViewById(R.id.button25);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signInIntent=mGoogleSignInClient.getSignInIntent();
                startActivityForResult(signInIntent,101);
            }
        });
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == 101) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuthWithGoogle(account);
            } catch (ApiException e) {


            }
        }
    }
    private void firebaseAuthWithGoogle(GoogleSignInAccount account)
    {
        AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            FirebaseUser user = mAuth.getCurrentUser();
                            finish();
                            Intent i=new Intent(Main2Activity.this,Main4Activity.class);
                            startActivity(i);
                            Toast.makeText(Main2Activity.this,"Login Successfull",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(Main2Activity.this,"Login UnSuccessfull",Toast.LENGTH_SHORT).show();

                        }

                        // ...
                    }
                });
    }
    public void signin(View v)
    {
        String email=ed1.getText().toString().trim();
        String password=ed2.getText().toString().trim();
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Intent intent=new Intent(Main2Activity.this,Main4Activity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(Main2Activity.this,"HELP",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void signup(View v)
    {
        Intent intent=new Intent(Main2Activity.this,Main3Activity.class);
        startActivity(intent);
    }
    public void phones(View v)
    {
        Intent intent=new Intent(Main2Activity.this,Main9Activity.class);
        startActivity(intent);
    }
    public void password(View v)
    {
        pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main2Activity.this,PasswordActivity.class));
            }
        });
    }
}
