package com.example.groupalram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AlramSetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alram_set);

        Button btnSetAlramCancle = (Button) findViewById(R.id.btn_set_alram_cancle);
        Button btnSetAlramSave = (Button) findViewById(R.id.btn_set_alram_save);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (v.getId()) {
                    // 취소버튼 클릭
                    case R.id.btn_set_alram_cancle :
                        onBackPressed();
                        break;
                    // 저장버튼 클릭
                    case R.id.btn_set_alram_save :
                        onBackPressed();
                        break;
                }
            }
        };

        btnSetAlramCancle.setOnClickListener(listener);
        btnSetAlramSave.setOnClickListener(listener);
    }
}
