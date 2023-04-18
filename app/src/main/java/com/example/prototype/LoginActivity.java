package com.example.prototype;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    String userID, name_Signin, email_Signin, phonenumber_Signin, password, editTextAddress;
    Button buttonReg;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        mAuth.createUserWithEmailAndPassword(email_Signin, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        // User account created successfully
                    } else {
                        // User account creation failed
                    }
                });
    }
}