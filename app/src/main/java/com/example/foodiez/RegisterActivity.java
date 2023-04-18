package com.example.foodiez;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    EditText Name,Pass,Email;
    Button Register;
    FirebaseAuth auth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Name=findViewById(R.id.Name);
        Pass=findViewById(R.id.Pass);
        Email=findViewById(R.id.Email);
        Register=findViewById(R.id.Register);
        auth=FirebaseAuth.getInstance();
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name1=Name.getText().toString();
                String Pass1=Pass.getText().toString();
                String Email1=Email.getText().toString();
                if(!Name1.isEmpty() && !Pass1.isEmpty() && !Email1.isEmpty())
                {
                    auth.createUserWithEmailAndPassword(Email1,Pass1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful())
                            {
                                Toast.makeText(RegisterActivity.this,"Account Successfully Created",Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Toast.makeText(RegisterActivity.this,""+task.getException(),Toast.LENGTH_SHORT).show();

                            }


                        }
                    });

                }
                else{
                    Toast.makeText(RegisterActivity.this,"Plaese fill empty field",Toast.LENGTH_SHORT).show();
                }



            }
        });


    }

    public void gotologin(View view) {
        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);

        startActivity(intent);
    }
}

