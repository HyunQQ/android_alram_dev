package com.example.groupalram;

import android.content.Context;
import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public DbOpenHelper mDbOpenHelper;
    Context context;
    LinearLayout layout;
    int count = 0;

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

        context = this;

        layout = (LinearLayout) findViewById(R.id.layout_main);

        Button btnAddAlram = (Button) findViewById(R.id.btn_add_alram);
        Button btnTemp = (Button) findViewById(R.id.btn_temp);

        btnAddAlram.setOnClickListener(this);
        btnTemp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_temp:


                Button btn = new Button(context);
                btn.setText("B_" + count++);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, AlramSetActivity.class);
                        startActivity(intent);
                    }
                });
                //btn.setId();

                Switch swc = new Switch(context);

                LinearLayout alramRow = new LinearLayout(context);
                alramRow.setOrientation(LinearLayout.HORIZONTAL);
                alramRow.addView(btn);
                alramRow.addView(swc);


                LinearLayout groupRow = new LinearLayout(context);
                groupRow.setOrientation(LinearLayout.VERTICAL);
                groupRow.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.rounded));
                groupRow.addView(alramRow);


                layout.addView(groupRow);
                break;

            case R.id.btn_add_alram:
                // 알람 추가
                Intent intent = new Intent(MainActivity.this, AlramSetActivity.class);
                startActivity(intent);
                break;
        }

    }





}
