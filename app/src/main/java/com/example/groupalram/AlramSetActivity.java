package com.example.groupalram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class AlramSetActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnSetAlramCancle;
    private Button btnSetAlramSave;
    private Button btnSelcBell;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alram_set);

        btnSetAlramCancle = (Button) findViewById(R.id.btn_set_alram_cancle);
        btnSetAlramSave = (Button) findViewById(R.id.btn_set_alram_save);
        btnSelcBell = (Button) findViewById(R.id.btn_selc_bell);

        btnSetAlramCancle.setOnClickListener(this);
        btnSetAlramSave.setOnClickListener(this);
        btnSelcBell.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {


        switch (v.getId()) {
            // 취소버튼 클릭
            case R.id.btn_set_alram_cancle:
                onBackPressed();
                break;
            // 저장버튼 클릭
            case R.id.btn_set_alram_save:
                onBackPressed();
                break;

            case R.id.btn_selc_bell:

                PopupMenu pSelcBell = new PopupMenu(this, v);
                pSelcBell.getMenuInflater().inflate(R.menu.selc_bell_menu, pSelcBell.getMenu());
                pSelcBell.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.m1:
                                Toast.makeText(getApplication(),"메뉴1",Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.m2:
                                Toast.makeText(getApplication(),"메뉴2",Toast.LENGTH_SHORT).show();
                                break;
                        }
                        return false;
                    }
                });
                pSelcBell.show();
                break;
        }

    }
}
