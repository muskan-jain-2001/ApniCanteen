package com.example.apnicanteen;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import android.widget.LinearLayout.LayoutParams;

public class Home extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
private ImageView image1,image2,image3,image4,image5,image6,image7,image8,image9,image10;
public Toolbar toolbar;
public Intent intent;
public TextView title, title2, title3;
public Spinner sp;
    public static String data="";
    TextView value;
    public static int amnt = 0;
    int sum=0;
    String str, sp1;
    public static String payid;
    SharedPreferences myprefs,mypref2,mypref3;
    SharedPreferences.Editor editor,editor2,editor3;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        toolbar=findViewById(R.id.mytoolbar);
        setSupportActionBar(toolbar);
        image1=(ImageView) findViewById(R.id.imageView1) ;
        image2=(ImageView) findViewById(R.id.imageView2) ;
        image3=(ImageView) findViewById(R.id.imageView3) ;
        image4=(ImageView) findViewById(R.id.imageView4) ;
        image5=(ImageView) findViewById(R.id.imageView5) ;
        image6=(ImageView) findViewById(R.id.imageView6) ;
        image7=(ImageView) findViewById(R.id.imageView7) ;
        image8=(ImageView) findViewById(R.id.imageView8) ;
        image9=(ImageView) findViewById(R.id.imageView9) ;
        image10=(ImageView) findViewById(R.id.imageView10) ;
        image1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), snacksmenu.class);
                startActivity(intent);
            }
        });
        image2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), chineesemenu.class);
                startActivity(intent);
            }
        });
        image3.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), northmenu.class);
                startActivity(intent);
            }
        });
        image4.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), coldsmenu.class);
                startActivity(intent);
            }
        });
        image5.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), italiansmenu.class);
                startActivity(intent);
            }
        });
        image6.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), southsmenu.class);
                startActivity(intent);
            }
        });
        image7.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), teamenu.class);
                startActivity(intent);
            }
        });
        image8.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), dessertmenu.class);
                startActivity(intent);
            }
        });
        image9.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), thalimenu.class);
                startActivity(intent);
            }
        });
        image10.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), combomenu.class);
                startActivity(intent);
            }
        });



    }
    public void data(){
        Integer txt= Integer.parseInt(sp1);
        data =  data + "\n\n" + title.getText().toString()  + title2.getText().toString() + title3.getText().toString()+"\n"+"Qty: "+sp1;
        intent = new Intent(getApplicationContext(), cart.class);
        Toast.makeText(this, "Added To cart!!!!", Toast.LENGTH_SHORT).show();
        editor = myprefs.edit();
        editor.putString("key", data);
        editor.commit();
        str= title2.getText().toString();
        sum = Integer.parseInt(str);
        sum=sum*txt;
        amnt= amnt+sum;
        editor2=mypref2.edit();
        editor2.putInt("key2",amnt);
        editor2.commit();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        inflater.inflate(R.menu.menu2,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
if(item.getItemId()==R.id.cart) {
    Intent intent = new Intent(getApplicationContext(), cart.class);
    startActivity(intent);
}else if(item.getItemId()==R.id.cross)
{
    kill();
}
else if(item.getItemId()==R.id.history)
{
    Intent intent = new Intent(getApplicationContext(), History.class);
    startActivity(intent);
}
        return true;
    }

    private void setSupportActionBar(Toolbar toolbar) {
    }
public void kill()
{
    AlertDialog.Builder alertDialogBuilder=new AlertDialog.Builder(this);
    alertDialogBuilder.setTitle("Confirm Exit.....!!");
    alertDialogBuilder.setIcon(R.drawable.ic_cross);
    alertDialogBuilder.setMessage("Are you sure you want to exit?");
    alertDialogBuilder.setCancelable(false);
    alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }
});
    alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            Intent intent = new Intent(getApplicationContext(), Home.class);
            startActivity(intent);
        }
    });
AlertDialog alertDialog=alertDialogBuilder.create();
alertDialog.show();
}

        @Override
        public void onItemSelected (AdapterView < ? > adapterView, View view,int i, long l){
            String text = adapterView.getItemAtPosition(i).toString();
            sp1=text;

        }

        @Override
        public void onNothingSelected (AdapterView < ? > adapterView){

        }

}
