package com.example.apnicanteen;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;


public class admincheck extends AppCompatActivity {
DBHelper db;
TextView tv;
String text1,text3,text2,text4,text5,text6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admincheck);
       tv=(TextView) findViewById(R.id.textView13);
       db= new DBHelper(this);
        Cursor cursor=db.alldata();
        if(cursor.getCount()==0){
            Toast.makeText(getApplicationContext(),"No Data",Toast.LENGTH_SHORT).show();
        }
        else{
            cursor.moveToLast();
            text5=cursor.getString(0);
            text1= cursor.getString(1);
            text4=cursor.getString(2);
            text2= cursor.getString(3);
            text3= cursor.getString(4);
            text6 = cursor.getString(5);
            tv.append("Date-Time: "+text5+"\n\nOrder Id: "+text1+"\n\nUsername: "+text4+text2+"\n\nAmount: "+text3+"\n\nPaymentId: " + text6+"\n--------------------------------------------------------------\n");
            while(cursor.moveToPrevious()){
                text5=cursor.getString(0);
                text1= cursor.getString(1);
                text4=cursor.getString(2);
                text2= cursor.getString(3);
                text3= cursor.getString(4);
                text6 = cursor.getString(5);
                tv.append("Date-Time: "+text5+"\n\nOrder Id: "+text1+"\n\nUsername: "+text4+text2+"\n\nAmount: "+text3+"\n\nPaymentId: " + text6+"\n----------------------------------------------------------\n");


            }
        }
    }
}