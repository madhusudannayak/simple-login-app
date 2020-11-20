package com.example.simpleloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText name;
    private EditText Password;
    private TextView info;
    private Button Login;
    private int counter=5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=findViewById(R.id.name);
        Password=findViewById(R.id.password);
        info=findViewById(R.id.info);
        Login=findViewById(R.id.bt_login);

        info.setText("No of attempts remaining: 5 times");

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(name.getText().toString(), Password.getText().toString());
            }
        });

    }

    private void validate(String userName, String password){
        if((userName.equals("Admin")) && (password.equals("123"))){
            Intent intent=new Intent(this,Second_Activity.class);
            startActivity(intent);
        }else{
            counter--;
            info.setText("No of attempt available " +counter +" times");
            Toast.makeText(MainActivity.this,"Sorry Try Again", Toast.LENGTH_SHORT).show();
            if(counter == 0){
                Login.setEnabled(false);
                info.setText("No of attempt available " +counter +" time");


            }

        }


    }

}