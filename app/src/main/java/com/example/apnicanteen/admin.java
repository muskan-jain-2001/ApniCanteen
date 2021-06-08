package com.example.apnicanteen;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class admin extends AppCompatActivity{
    EditText username,password;
    Button btnlogin;
    DBHelper DB;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        username=(EditText)findViewById(R.id.username2);
        password=(EditText)findViewById(R.id.password2);
        btnlogin=(Button) findViewById(R.id.btnsignin2);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String user=username.getText().toString();
                String pass=password.getText().toString();
                if(user.equals("")||pass.equals(""))
                    Toast.makeText(com.example.apnicanteen.admin.this,"Please Enter All Fields!!!!",Toast.LENGTH_SHORT).show();
                else{

                      if(user.equals("admin")&&pass.equals("admin")) {
                            Toast.makeText(admin.this, "Sign in Successfull", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), admincheck.class);
                            startActivity(intent);
                        }else
                        {
                            Toast.makeText(admin.this,"Inavalid Details!!",Toast.LENGTH_SHORT).show();
                        }

                }
            }
        });
    }

}