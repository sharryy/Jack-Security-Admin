package com.anonymous.usama_jack_admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btn_SignUp_Main;
    private Button btn_SignIn_Main;
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sessionManager = new SessionManager(this);

        if (sessionManager.getLogin()) {
            startActivity(new Intent(getApplicationContext(), Home.class));
            finish();
        }

        btn_SignUp_Main = findViewById(R.id.btn_SignUp_Main);
        btn_SignIn_Main = findViewById(R.id.btn_SignIn_Main);

        btn_SignUp_Main.setOnClickListener(this);
        btn_SignIn_Main.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_SignIn_Main:
                Intent intent_SignIn = new Intent(MainActivity.this, Signin.class);
                startActivity(intent_SignIn);
                break;
            case R.id.btn_SignUp_Main:
                Intent intent_SignUp = new Intent(MainActivity.this, Signup.class);
                startActivity(intent_SignUp);
                break;
        }
    }
}