package com.example.apnicanteen;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.content.Intent;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

public class thalimenu extends Home implements View.OnClickListener  {
        Button btn1, btn2, btn3;

@RequiresApi(api = Build.VERSION_CODES.O)
@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thalimenu);
        toolbar=findViewById(R.id.mytoolbar);
        setSupportActionBar(toolbar);
        myprefs=getSharedPreferences("id",MODE_PRIVATE);
        mypref2=getSharedPreferences("id2",MODE_PRIVATE);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.numbers,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner spinner1=findViewById(R.id.spinner1);
        spinner1.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(this);
        Spinner spinner2=findViewById(R.id.spinner2);
        spinner2.setAdapter(adapter);
        spinner2.setOnItemSelectedListener(this);
        Spinner spinner3=findViewById(R.id.spinner3);
        spinner3.setAdapter(adapter);
        spinner3.setOnItemSelectedListener(this);
        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);
        btn3 = (Button) findViewById(R.id.button3);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);

        }

@Override
public void onClick(View view) {
        switch (view.getId()) {
                case R.id.button1:

                        title = (TextView) findViewById(R.id.textView1);
                        title2 = (TextView) findViewById(R.id.textView1a);
                        title3 = (TextView) findViewById(R.id.textView1b);
                        sp = (Spinner) findViewById(R.id.spinner1);
                        data();
                        btn1.setEnabled(false);

                        break;
                case R.id.button2:

                        title = (TextView) findViewById(R.id.textView2);
                        title2 = (TextView) findViewById(R.id.textView2a);
                        title3 = (TextView) findViewById(R.id.textView2b);
                        sp = (Spinner) findViewById(R.id.spinner2);
                       data();

                        btn2.setEnabled(false);

                        break;
                case R.id.button3:

                        title = (TextView) findViewById(R.id.textView3);
                        title2 = (TextView) findViewById(R.id.textView3a);
                        title3 = (TextView) findViewById(R.id.textView3b);
                        sp = (Spinner) findViewById(R.id.spinner3);
                       data();
                        btn3.setEnabled(false);

                        break;


        }
        }
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
                MenuInflater inflater= getMenuInflater();
                inflater.inflate(R.menu.menu,menu);
                return true;
        }

        @Override
        public boolean onOptionsItemSelected(@NonNull MenuItem item) {
                if(item.getItemId()==R.id.cart) {
                        Intent intent = new Intent(getApplicationContext(), cart.class);
                        startActivity(intent);
                }
                else if(item.getItemId()==R.id.cross)
                {
                        kill();
                }
                return true;
        }

        private void setSupportActionBar(Toolbar toolbar) {
        }
        }