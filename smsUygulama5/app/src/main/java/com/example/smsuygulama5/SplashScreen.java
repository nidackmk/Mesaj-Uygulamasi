package com.example.smsuygulama5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class SplashScreen extends AppCompatActivity {

    FirebaseAuth firebaseAuth;
    Thread wait;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        firebaseAuth=FirebaseAuth.getInstance();
        splashScreen();

        if (firebaseAuth.getCurrentUser() != null){
            Toast.makeText(this, "You are already login. Redirect to main page.", Toast.LENGTH_SHORT).show();
            wait.start();
        }
    }

    public void signupOnClick(View view) {
        startActivity(new Intent(SplashScreen.this, RegisterActivity.class));
    }

    public void loginOnClick(View view) {
        startActivity(new Intent(SplashScreen.this, LoginActivity.class));
    }

    public void splashScreen(){
        wait=new Thread(){
            @Override
            public void run() {
                try {
                    sleep(3000);
                    startActivity(new Intent(SplashScreen.this, MainActivity.class));
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
    }
}