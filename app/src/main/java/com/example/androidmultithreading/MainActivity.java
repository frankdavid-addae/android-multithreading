package com.example.androidmultithreading;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnStartDownload, btnClickMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnClickMe = findViewById(R.id.btnClickMe);
        btnStartDownload = findViewById(R.id.btnStartDownload);

        btnStartDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Running the for loop on a different thread
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 26; i++) {
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            Log.d("for-loop", "for loop execution " + i);
                        }
                    }
                }).start();
            }
        });

        btnClickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Toast for Click Me button", Toast.LENGTH_SHORT).show();
            }
        });
    }
}