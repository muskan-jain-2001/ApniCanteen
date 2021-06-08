package com.example.apnicanteen;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

public class snacksmenu extends Home implements View.OnClickListener {
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snacksmenu);
        toolbar = findViewById(R.id.mytoolbar);
        setSupportActionBar(toolbar);
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
        Spinner spinner4=findViewById(R.id.spinner4);
        spinner4.setAdapter(adapter);
        spinner4.setOnItemSelectedListener(this);
        Spinner spinner5=findViewById(R.id.spinner5);
        spinner5.setAdapter(adapter);
        spinner5.setOnItemSelectedListener(this);
        Spinner spinner6=findViewById(R.id.spinner6);
        spinner6.setAdapter(adapter);
        spinner6.setOnItemSelectedListener(this);
        Spinner spinner7=findViewById(R.id.spinner7);
        spinner7.setAdapter(adapter);
        spinner7.setOnItemSelectedListener(this);
        Spinner spinner8=findViewById(R.id.spinner8);
        spinner8.setAdapter(adapter);
        spinner8.setOnItemSelectedListener(this);
        Spinner spinner9=findViewById(R.id.spinner9);
        spinner9.setAdapter(adapter);
        spinner9.setOnItemSelectedListener(this);
        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);
        btn3 = (Button) findViewById(R.id.button3);
        btn4 = (Button) findViewById(R.id.button4);
        btn5 = (Button) findViewById(R.id.button5);
        btn6 = (Button) findViewById(R.id.button6);
        btn7 = (Button) findViewById(R.id.button7);
        btn8 = (Button) findViewById(R.id.button8);
        btn9 = (Button) findViewById(R.id.button9);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        myprefs=getSharedPreferences("id",MODE_PRIVATE);
        mypref2=getSharedPreferences("id2",MODE_PRIVATE);
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
            case R.id.button4:
                    title = (TextView) findViewById(R.id.textView4);
                    title2 = (TextView) findViewById(R.id.textView4a);
                    title3 = (TextView) findViewById(R.id.textView4b);
                    sp = (Spinner) findViewById(R.id.spinner4);
                    data();
                    btn4.setEnabled(false);
                break;
            case R.id.button5:
                    title = (TextView) findViewById(R.id.textView5);
                    title2 = (TextView) findViewById(R.id.textView5a);
                    title3 = (TextView) findViewById(R.id.textView5b);
                    sp = (Spinner) findViewById(R.id.spinner5);
                    data();
                    btn5.setEnabled(false);

                break;
            case R.id.button6:

                    title = (TextView) findViewById(R.id.textView6);
                    title2 = (TextView) findViewById(R.id.textView6a);
                    title3 = (TextView) findViewById(R.id.textView6b);
                    sp = (Spinner) findViewById(R.id.spinner6);
                   data();
                    btn6.setEnabled(false);

                break;
            case R.id.button7:

                    title = (TextView) findViewById(R.id.textView7);
                    title2 = (TextView) findViewById(R.id.textView7a);
                    title3 = (TextView) findViewById(R.id.textView7b);
                    sp = (Spinner) findViewById(R.id.spinner7);
                    data();
                    btn7.setEnabled(false);

                break;
            case R.id.button8:

                    title = (TextView) findViewById(R.id.textView8);
                    title2 = (TextView) findViewById(R.id.textView8a);
                    title3 = (TextView) findViewById(R.id.textView8b);
                    sp = (Spinner) findViewById(R.id.spinner8);
                    data();
                    btn8.setEnabled(false);

                break;
            case R.id.button9:

                    title = (TextView) findViewById(R.id.textView9);
                    title2 = (TextView) findViewById(R.id.textView9a);
                    title3 = (TextView) findViewById(R.id.textView9b);
                    sp = (Spinner) findViewById(R.id.spinner9);
                    data();

                    btn9.setEnabled(false);
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
        if(item.getItemId()==R.id.cart)
        {
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