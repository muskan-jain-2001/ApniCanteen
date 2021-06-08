package com.example.apnicanteen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import java.util.Timer;
import java.util.TimerTask;
import android.content.Intent;

public class Welcome extends AppCompatActivity {

    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        timer= new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent =new Intent(Welcome.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);
    }
}
