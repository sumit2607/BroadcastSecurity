package com.example.broadcastsecurity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView tvResponse;
    LocalReciever localReciever;
    private static final int REQUEST_CODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tvResponse = findViewById(R.id.tvResponse);
        String[] permissions = {Manifest.permission.CAMERA};
        ActivityCompat.requestPermissions(SecondActivity.this, permissions, REQUEST_CODE);
        String data  = getIntent().getStringExtra("message");
        tvResponse.setText(data);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(localReciever);
    }
}