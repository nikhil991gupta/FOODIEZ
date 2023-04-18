package com.example.foodiez;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    EditText logemail,logpass;
    Button logbutton;
    FirebaseAuth auth;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        logemail=findViewById(R.id.logemail);
        logpass=findViewById(R.id.logpass);
        logbutton=findViewById(R.id.logbutton);
        auth= FirebaseAuth.getInstance();
        logbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=logemail.getText().toString();
                String pass=logpass.getText().toString();
                if(!email.isEmpty() && !pass.isEmpty())
                {
                    auth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful())
                            {
                                Toast.makeText(LoginActivity.this,"Login SuccessFul",Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(LoginActivity.this,HomeActivity.class);
                                startActivity(intent);
                                finish();


                            }
                            else{
                                Toast.makeText(LoginActivity.this,""+task.getException(),Toast.LENGTH_SHORT).show();

                            }

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(LoginActivity.this,""+e.getMessage(),Toast.LENGTH_SHORT).show();


                        }
                    });

                }
                else{
                    Toast.makeText(LoginActivity.this,"Please fill the empty field",Toast.LENGTH_SHORT).show();
                }

            }
        });


    }

    public void gotoregister(View view) {
        Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);

        startActivity(intent);

    }

    public void gotohome(View view) {
            Intent intent=new Intent(LoginActivity.this,HomeActivity.class);

            startActivity(intent);

    }
}