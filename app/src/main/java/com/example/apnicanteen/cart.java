package com.example.apnicanteen;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.text.method.ScrollingMovementMethod;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toolbar;

public class cart extends Home{
    TextView showdata,amount,random;
    Button btn1,btn2;
    String showdt,dbamnt,user;
    int x,y;
    AlertDialog.Builder alertDialogBuilder;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        alertDialogBuilder=new AlertDialog.Builder(this);
        myprefs = getSharedPreferences("id",MODE_PRIVATE);
        String name = myprefs.getString("key","Default");
        mypref2 = getSharedPreferences("id2",MODE_PRIVATE);
        int amt=mypref2.getInt("key2",0);
        mypref3 = getSharedPreferences("id3",MODE_PRIVATE);
        showdata=(TextView) findViewById(R.id.showinput);
        showdata.setText(name);
        showdt=String.valueOf(name);
        showdata.setMovementMethod(new ScrollingMovementMethod());
        amount=(TextView) findViewById(R.id.amount);
        amount.setText(String.valueOf(amt));
        dbamnt=String.valueOf(amt);
        btn1=(Button)findViewById(R.id.order);
        btn2=(Button)findViewById(R.id.delete);
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        switch (day) {
            case Calendar.SUNDAY:
                btn1.setEnabled(false);
                AlertDialog.Builder alertDialogBuilder=new AlertDialog.Builder(this);
                alertDialogBuilder.setTitle("Sunday Closed!");
                alertDialogBuilder.setMessage("Order cannot be placed right now:(");
                alertDialogBuilder.setCancelable(false);
                alertDialogBuilder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                AlertDialog alertDialog=alertDialogBuilder.create();
                alertDialog.show();
                break;

        }
        SimpleDateFormat mdformat = new SimpleDateFormat("H");
        String strDate = mdformat.format(calendar.getTime());
        int x=Integer.parseInt(strDate);
        if((x>=19 && x<=23)||(x>=0 && x<9))
        {
            btn1.setEnabled(false);
            AlertDialog.Builder alertDialogBuilder=new AlertDialog.Builder(this);
            alertDialogBuilder.setTitle("Canteen Closed!");
            alertDialogBuilder.setMessage("Order cannot be placed right now:(");
            alertDialogBuilder.setCancelable(false);
            alertDialogBuilder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            AlertDialog alertDialog=alertDialogBuilder.create();
            alertDialog.show();
        }
        btn1.setOnClickListener(new View.OnClickListener()

        {
            public void onClick (View view)
            {
                Random ran=new Random();
                int number=ran.nextInt(1000000000)+1;
                editor3 = mypref3.edit();
                editor3.putInt("key3",number);
                editor3.commit();
                Intent intent = new Intent(getApplicationContext(), placeorder.class);
                startActivity(intent);


            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                alertDialogBuilder.setTitle("Delete.");
                alertDialogBuilder.setMessage("Are you sure you want to clear your Cart?");
                alertDialogBuilder.setCancelable(false);
                alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        data=" ";
                        amnt=0;
                        showdata.setText(""+"Oops!! Your Cart is empty:(");
                        amount.setText("0");
                    }
                });
                alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                AlertDialog alertDialog=alertDialogBuilder.create();
                alertDialog.show();


            }
        });


    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.menu3,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.home) {
            Intent intent = new Intent(getApplicationContext(), Home.class);
            startActivity(intent);
        }
        if(item.getItemId()==R.id.cross) {
            kill();
        }


        return true;
    }


    private void setSupportActionBar(Toolbar toolbar) {
    }
}



