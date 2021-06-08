package com.example.apnicanteen;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class placeorder extends cart implements PaymentResultListener  {
    Button btn2;
    TextView random;
    public static String abc, date;

    DBHelper DB;
    Login l;
    int h;


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Checkout.preload(getApplicationContext());
        DB = new DBHelper(this);
        String samount = dbamnt;
        final int amount = Math.round(Float.parseFloat(samount) * 100);
        setContentView(R.layout.activity_placeorder);
        mypref3 = getSharedPreferences("id3", MODE_PRIVATE);
        int num = mypref3.getInt("key3", 0);
        random = (TextView) findViewById(R.id.randomno);
        random.setText(String.valueOf(num));
        abc = String.valueOf(num);
        date = DB.getDateTime();
        btn2 = (Button) findViewById(R.id.paymentbtn);
       // Date d = Calendar.getInstance().getTime();




        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Checkout checkout = new Checkout();
                checkout.setKeyID("rzp_test_gMLefaJQHUiU8a");
                checkout.setImage(R.drawable.icon);
                JSONObject object = new JSONObject();
                try {
                    object.put("name", "Apnicanteen");
                    object.put("Description", "Payment");
                    object.put("currency", "INR");
                    object.put("Amount", amount);
                   // object.put("image","https://s3.amazonaws.com/rzp-mobile/images/rzp.png");
                    object.put("theme.color", "#ffbb33");
                    object.put("prefill contact", "9871610350");
                    checkout.open(placeorder.this, object);
                } catch (JSONException e) {
                    Toast.makeText(placeorder.this, "Error in payment: " + e.getMessage(), Toast.LENGTH_SHORT)
                            .show();
                    e.printStackTrace();
                }



            }
        });

    }


    @Override
    public void onPaymentSuccess(String s) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Payment ID");
        builder.setMessage(s);
        builder.setCancelable(false);
        builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(placeorder.this, Thankyou.class);
                startActivity(intent);
            }
        });

        AlertDialog alertDialog=builder.create();
        alertDialog.show();
        payid=s;
        DB.insertData2(date, abc, l.userid, showdt, dbamnt,payid);
    }



    @Override
    public void onPaymentError(int i, String s) {
        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
    }


}


