package com.example.groupalram;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AlarmReciver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent){
        Toast.makeText(context, "Alarm Triggered", Toast.LENGTH_SHORT).show();

        String get_string = intent.getExtras().getString("state");
        String ringToneName = intent.getExtras().getString("ringToneName");
        String rinToneUri = intent.getExtras().getString("rinToneUri");

        Intent service_intent = new Intent(context, RingtonePlayService.class);
        service_intent.putExtra("state", get_string);
        service_intent.putExtra("ringToneName", ringToneName);
        service_intent.putExtra("rinToneUri", rinToneUri);
        context.startService(service_intent);
    }
}
