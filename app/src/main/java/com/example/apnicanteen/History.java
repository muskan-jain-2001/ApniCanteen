package com.example.apnicanteen;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class History extends AppCompatActivity {
    DBHelper db;
    TextView tv;
    String text1,text3,text2,text4,text5,text6;
 Login l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        tv=(TextView) findViewById(R.id.textView10);
        db= new DBHelper(this);
        Cursor cursor=db.retrieveData(l.userid);

        if(cursor.moveToLast()) {
            text5 = cursor.getString(0);
            text1 = cursor.getString(1);
            text4 = cursor.getString(2);
            text2 = cursor.getString(3);
            text3 = cursor.getString(4);
            text6 = cursor.getString(5);
            tv.append("Date-Time: " + text5 + "\n\nOrder Id: " + text1 + "\n\nUsername: " + text4 +  text2 + "\n\nAmount: " + text3 +"\n\nPaymentId: " + text6+ "\n--------------------------------------------------------------\n");
            while (cursor.moveToPrevious()) {
                text5 = cursor.getString(0);
                text1 = cursor.getString(1);
                text4 = cursor.getString(2);
                text2 = cursor.getString(3);
                text3 = cursor.getString(4);
                text6 = cursor.getString(5);
                tv.append("Date-Time: " + text5 + "\n\nOrder Id: " + text1 + "\n\nUsername: " + text4 +  text2 + "\n\nAmount: " + text3 + "\n\nPaymentId: " + text6+"\n--------------------------------------------------------------\n");
            }
        }

    }
}
