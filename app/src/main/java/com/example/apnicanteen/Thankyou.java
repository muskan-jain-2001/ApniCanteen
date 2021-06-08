package com.example.apnicanteen;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Thankyou extends Home {
Button btn;
TextView txt;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thankyou);
        btn = (Button) findViewById(R.id.logoutbtn);
        txt=(TextView)findViewById(R.id.pid) ;
        txt.setText(payid);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kill();


            }
        });
    }
}