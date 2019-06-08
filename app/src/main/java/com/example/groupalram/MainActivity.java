package com.example.groupalram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onBtnAddAlranClick(View v){
        //Log.d("btn", "알람 추가창으로 이동");
        Intent intent = new Intent(this, AlramSetActivity.class);
        startActivity(intent);
    }
}
