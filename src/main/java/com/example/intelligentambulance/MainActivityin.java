package com.example.intelligentambulance;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivityin extends AppCompatActivity {
private Button button1;
private Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainin);
        button1=findViewById(R.id.buttonSignIn);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivityin.this,MainActivity2.class);
                startActivity(intent);
            }

        });
        button2=findViewById(R.id.buttonSignUp);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivityin.this,MainActivity3.class);
                startActivity(intent);
            }
        });

    }
}