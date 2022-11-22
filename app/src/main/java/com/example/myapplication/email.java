package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class email extends AppCompatActivity {
    TextView info,info2,res,points;
    Button send,back;
    EditText email;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emal);

        info = (TextView) findViewById(R.id.textView8);
        info2 = (TextView) findViewById(R.id.textView7);
        res = (TextView) findViewById(R.id.textView9);
        points = (TextView) findViewById(R.id.textView10);
        send = (Button) findViewById(R.id.button6);
        back = (Button) findViewById(R.id.button8);
        email = (EditText) findViewById(R.id.editTextTextEmailAddress);

        points.setText(getIntent().getStringExtra("key"));

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String to = email.getText().toString();

                Intent emails = new Intent(Intent.ACTION_SEND);
                emails.putExtra(Intent.EXTRA_EMAIL, new String[] {to});
                emails.setType("message/rfc822");
                startActivity(Intent.createChooser(emails, "Выберите email клиент :"));
            }
        });



    }

    public void backgame(View v){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

}