package com.example.groupalram;

import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private DbOpenHelper mDbOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //database 생성
        mDbOpenHelper = new DbOpenHelper(this);
        try{
            mDbOpenHelper.open();
        }catch (SQLException e){
            e.printStackTrace();
        }


        Button btnAddAlram = (Button) findViewById(R.id.btn_add_alram);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 알람 추가
                Intent intent = new Intent(MainActivity.this, AlramSetActivity.class);
                startActivity(intent);
            }
        };

        btnAddAlram.setOnClickListener(listener);
    }

}
