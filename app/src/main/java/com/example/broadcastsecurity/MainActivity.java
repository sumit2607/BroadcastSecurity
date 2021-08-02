package com.example.broadcastsecurity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnsend;
    private LocalReciever localReciever;
    private static final int REQUEST_CODE = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnsend = findViewById(R.id.btnSend);
        registerLocalReciever();

        btnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] permissions = {Manifest.permission.CAMERA};
                ActivityCompat.requestPermissions(MainActivity.this, permissions, REQUEST_CODE);
                Intent intent = new Intent();
                intent.setAction("Second.Activity.com");
                intent.putExtra("message","Hey! hi this is from Activity one");
                sendBroadcast(intent,Manifest.permission.CAMERA);

            }
        });
    }



    private void showToast(String message) {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }

    private void registerLocalReciever() {
        localReciever = new LocalReciever();
        IntentFilter intentFilter = new IntentFilter("Second.Activity.com");
        registerReceiver(localReciever, intentFilter);
    }
}