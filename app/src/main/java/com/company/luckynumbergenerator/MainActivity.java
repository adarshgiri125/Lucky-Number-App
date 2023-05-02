package com.company.luckynumbergenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        name = findViewById(R.id.PersonName);




        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int number = getLuckyNo();

                String user_name = name.getText().toString();
                Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
                intent.putExtra("user", user_name);
                intent.putExtra("luckyNo",number);
                startActivity(intent);

            }
        });


    }

    public int getLuckyNo(){
        Random random = new Random();
        int upper_bound = 100;

        int value = random.nextInt(100);
        return value;
    }
}