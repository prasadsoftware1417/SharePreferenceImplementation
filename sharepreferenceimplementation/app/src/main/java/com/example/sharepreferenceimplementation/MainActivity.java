package com.example.sharepreferenceimplementation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText userName,password;
    Button saveButton,clearButton,retrieveButton;
    SharedPreferences sharedPreferences;
    static final String syPreference="sypreff";
    static final  String username="usernamekey";
    static final  String pass="passwordkey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userName=findViewById(R.id.username);
        password=findViewById(R.id.pass);
        saveButton=findViewById(R.id.save);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=userName.getText().toString();
                String s2=password.getText().toString();
                sharedPreferences=getSharedPreferences(syPreference, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString(username,s1);
                editor.putString(pass,s2 );
                editor.commit();
                Toast.makeText(MainActivity.this, "Data Save Successfully", Toast.LENGTH_SHORT).show();

            }

        });


    }



    public void retrieve(View view) {
        sharedPreferences=getSharedPreferences(syPreference, Context.MODE_PRIVATE);
        userName.setText(sharedPreferences.getString(username,""));
        password.setText(sharedPreferences.getString(pass,""));
    }

    public void clear(View view) {
        userName.setText("");
        password.setText("");
    }


}
