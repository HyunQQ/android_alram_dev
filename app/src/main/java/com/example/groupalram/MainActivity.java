package com.example.groupalram;

import android.content.Context;
import android.content.Intent;
import android.database.SQLException;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private DbOpenHelper mDbOpenHelper;
    Context context;
    LinearLayout layout;
    int btnCnt = 0;
    int swcIndex = 10000000;
    int groupCnt = 100000000;
    int groupSwcIndex = 100000000;

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
        Button btnAddGroup = (Button) findViewById(R.id.btn_add_group);

        btnAddAlram.setOnClickListener(this);
        btnTemp.setOnClickListener(this);
        btnAddGroup.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_add_group:
                final int groupId = ++groupCnt;
                final int groupSwcId = groupCnt + groupSwcIndex;

                final Switch swc = new Switch(context);
                swc.setChecked(true);

                LinearLayout.LayoutParams swcParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
                swcParams.weight = 1;
                swc.setLayoutParams(swcParams);
                swc.setId(groupSwcId);
                swc.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(swc.isChecked()){
                            LinearLayout groupLayout = (LinearLayout) findViewById(groupId);
                            for (int i=1; i<groupLayout.getChildCount(); i++){
                                LinearLayout childLayout = (LinearLayout) groupLayout.getChildAt(i);
                                Switch innerSwc = (Switch) findViewById(childLayout.getChildAt(1).getId());
                                innerSwc.setChecked(true);
                            }
                        }else{
                            LinearLayout groupLayout = (LinearLayout) findViewById(groupId);
                            for (int i=1; i<groupLayout.getChildCount(); i++){
                                LinearLayout childLayout = (LinearLayout) groupLayout.getChildAt(i);
                                Switch innerSwc = (Switch) findViewById(childLayout.getChildAt(1).getId());
                                innerSwc.setChecked(false);
                            }
                        }
                    }
                });


                LinearLayout titleRow = new LinearLayout(context);
                titleRow.setOrientation(LinearLayout.HORIZONTAL);
                titleRow.addView(swc);


                LinearLayout groupRow = new LinearLayout(context);
                groupRow.setOrientation(LinearLayout.VERTICAL);
                groupRow.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.rounded));
                groupRow.addView(titleRow);
                groupRow.setId(groupId);


                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                layoutParams.topMargin = 20;
                groupRow.setLayoutParams(layoutParams);


                layout.addView(groupRow);

                break;
            case R.id.btn_temp:

                EditText groupNum = (EditText) findViewById(R.id.checked_group_num);
                int selectGroupId = Integer.parseInt(groupNum.getText().toString());
                LinearLayout selectedGroup = (LinearLayout) findViewById(selectGroupId);

                // 알람 생성
                addAlramRow(selectedGroup);
                break;
            case R.id.btn_add_alram:
                // 알람 추가 화면 이동
                Intent intent = new Intent(MainActivity.this, AlramSetActivity.class);
                startActivity(intent);
                break;
        }

    }

    public void addAlramRow(LinearLayout selectedGroup){
        final int btnId = ++btnCnt;
        final int swcId = btnCnt + swcIndex;
        final int groupId = selectedGroup.getId();

        Button btn = new Button(context);
        btn.setBackgroundColor(0);
        btn.setId(btnId);
        btn.setText("7:45");
        btn.setTextSize(40);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("[ID CHECK]", "btnId = " + btnId + " / groupId = " + groupId);
                Intent intent = new Intent(MainActivity.this, AlramSetActivity.class);
                startActivity(intent);
            }
        });


        LinearLayout.LayoutParams btnParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        btnParams.weight = 4;
        btn.setLayoutParams(btnParams);


        final Switch swc = new Switch(context);
        swc.setChecked(true);

        LinearLayout.LayoutParams swcParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        swcParams.weight = 1;
        swc.setLayoutParams(swcParams);
        swc.setId(swcId);
        swc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(swc.isChecked()){
                    Log.d("[switch clike]", "[switch on] :" + swcId);
                }else{
                    Log.d("[switch clike]", "[switch off] :" + swcId);
                }
            }
        });


        LinearLayout alramRow = new LinearLayout(context);
        alramRow.setOrientation(LinearLayout.HORIZONTAL);
        alramRow.addView(btn);
        alramRow.addView(swc);

        selectedGroup.addView(alramRow);

    }




}
