package com.example.broadcastsecurity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class LocalReciever extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent intent1 = new Intent(context,SecondActivity.class);
        String data = intent.getStringExtra("message");
        intent1.putExtra("message",data);

        context.startActivity(intent1);
    }
}
