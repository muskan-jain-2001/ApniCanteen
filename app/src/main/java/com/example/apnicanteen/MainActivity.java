package com.example.apnicanteen;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
EditText username,password,repassword;
Button signup,signin,adminsignin;
DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);
        repassword=(EditText)findViewById(R.id.repassword);
        signin=(Button) findViewById(R.id.btnsignin);
        signup=(Button) findViewById(R.id.btnsignup);
        adminsignin=(Button)findViewById(R.id.adminsignin);
        DB=new DBHelper(this);
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        switch (day) {
            case Calendar.SUNDAY:
                Toast.makeText(MainActivity.this,"Sunday Closed!",Toast.LENGTH_SHORT).show();

        }
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              String  user=username.getText().toString();
            String pass=password.getText().toString();
            String repass=repassword.getText().toString();
            if(user.equals("")||pass.equals("")||repass.equals(""))
               Toast.makeText(MainActivity.this,"Please Enter All Fields!!!!",Toast.LENGTH_SHORT).show();
            else
            {
                if(pass.equals(repass)){
                    Boolean checkuser=DB.checkusername(user);
                    if(checkuser==false){
                        Boolean insert=DB.insertData(user,pass);
                        if(insert==true){
                            Toast.makeText(MainActivity.this,"Registered Successfully!",Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(getApplicationContext(),Login.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(MainActivity.this,"Registered Failed!!!",Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(MainActivity.this,"User already Exist!!Please Sign In",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(MainActivity.this,"Incorrect Password!!!",Toast.LENGTH_SHORT).show();
                }
            }

            }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
            }
        });
        adminsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),admin.class);
                startActivity(intent);
            }
        });
    }
}