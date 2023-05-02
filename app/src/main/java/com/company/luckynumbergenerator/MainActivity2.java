package com.company.luckynumbergenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView = findViewById(R.id.NumberView);
        button = findViewById(R.id.button2);



        Intent i = getIntent();
        String user = i.getStringExtra("user");
        int luckyNo = i.getIntExtra("luckyNo",7);


        textView.setText(""+luckyNo);
        Toast.makeText(this, "username :" + user, Toast.LENGTH_LONG).show();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendNumber(user,luckyNo);
            }
        });






    }

    public void sendNumber(String user, int luckyNo){

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setType("text/plain");

        String number = " " + luckyNo;


        intent.putExtra(Intent.EXTRA_SUBJECT, user + " got lucky Number today");
        intent.putExtra(Intent.EXTRA_TEXT,"His Lucky no. is" + number);

       // Toast.makeText(this, "luckyno :" +number, Toast.LENGTH_LONG).show();

        startActivity(Intent.createChooser(intent,"Choose a platform"));


    }
}