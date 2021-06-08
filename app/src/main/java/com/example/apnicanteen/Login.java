package com.example.apnicanteen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ButtonBarLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity{
EditText username,password;
Button btnlogin;
DBHelper DB;
public static String userid;
String user,pass;
//    SharedPreferences mypref4;
//    SharedPreferences.Editor editor4;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username=(EditText)findViewById(R.id.username1);
        password=(EditText)findViewById(R.id.password1);
        btnlogin=(Button) findViewById(R.id.btnsignin1);
        DB=new DBHelper(this);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                 user=username.getText().toString();
                 pass=password.getText().toString();
                if(user.equals("")||pass.equals(""))
                    Toast.makeText(Login.this,"Please Enter All Fields!!!!",Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpass=DB.checkusernamepassword(user,pass);
                    if(checkuserpass==true) {
                        Toast.makeText(Login.this, "Sign in Successfull", Toast.LENGTH_SHORT).show();
                        //DB.insertData3(user);
                        userid=user;
                        Intent intent = new Intent(getApplicationContext(), Home.class);
                        startActivity(intent);
                    }else
                    {
                        Toast.makeText(Login.this,"Inavalid Details!!",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }

}