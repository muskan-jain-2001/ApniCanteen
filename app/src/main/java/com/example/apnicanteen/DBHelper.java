package com.example.apnicanteen;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "apniCanteen2.db";

    public DBHelper(Context context) {
        super(context, "apniCanteen2.db", null, 1);

    }
    SQLiteDatabase MyDB;
    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        String SQL="CREATE TABLE users(username TEXT PRIMARY KEY,password TEXT)";
        String SQL2="CREATE TABLE orders(Date_Time TEXT,orderid TEXT PRIMARY KEY,username TEXT,item TEXT,Amount TEXT, PaymentId TEXT)";
        Log.d("Data", "onCreate: " + SQL);
        Log.d("Data", "onCreate: " + SQL2);
        MyDB.execSQL(SQL);
        MyDB.execSQL(SQL2);
    }
    public String getDateTime() {

        SimpleDateFormat dateFormat = new SimpleDateFormat(

                "yyyy-MM-dd HH:mm:ss", Locale.getDefault());

        Date date = new Date();

        return dateFormat.format(date);

    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("DROP TABLE if exists users");
        MyDB.execSQL("DROP TABLE if exists orders");
    }

    public Boolean insertData(String username, String password) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        long result = MyDB.insert("users", null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }
    public void insertData2(String date,String orderid,String username, String item, String dbamount, String PaymentId) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Date_Time",date);
        contentValues.put("orderid", orderid);
        contentValues.put("username", username);
        contentValues.put("item", item);
        contentValues.put("amount", dbamount);
        contentValues.put("PaymentId", PaymentId);
         MyDB.insert("orders", null, contentValues);

    }
    public Boolean checkusername(String username) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("SELECT * FROM users WHERE username=?", new String[]{username});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }
    public Cursor alldata(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from orders",null);
        return cursor;
    }


    public Boolean checkusernamepassword(String username, String password) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("SELECT * FROM users WHERE username=? AND password=?", new String[]{username, password});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }
    public Cursor retrieveData(String username){
        SQLiteDatabase db = this.getReadableDatabase();
        //String SQL="SELECT * FROM ORDERS WHERE username= ";
        Cursor cursor = db.rawQuery("SELECT * FROM ORDERS WHERE username=?",new String[] {username});
        return cursor;

    }


}

