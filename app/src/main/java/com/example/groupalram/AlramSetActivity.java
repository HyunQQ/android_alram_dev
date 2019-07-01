package com.example.groupalram;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.Toast;

public class AlramSetActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnSetAlramCancle;
    private Button btnSetAlramSave;
    private Button btnSelcBell;
    private Button btnSelcCycle;
    private Button btnSelcGroup;
    private Button btnSelcOpt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alram_set);

        btnSetAlramCancle   = (Button) findViewById(R.id.btn_set_alram_cancle);
        btnSetAlramSave     = (Button) findViewById(R.id.btn_set_alram_save);
        btnSelcBell         = (Button) findViewById(R.id.btn_selc_bell);
        btnSelcCycle        = (Button)findViewById(R.id.btn_selc_cycle);
        btnSelcGroup        = (Button)findViewById(R.id.btn_selc_group);
        btnSelcOpt          = (Button)findViewById(R.id.btn_selc_opt);

        btnSetAlramCancle.setOnClickListener(this);
        btnSetAlramSave.setOnClickListener(this);
        btnSelcBell.setOnClickListener(this);
        btnSelcCycle.setOnClickListener(this);
        btnSelcGroup.setOnClickListener(this);
        btnSelcOpt.setOnClickListener(this);

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

                View selcBellPopView = getLayoutInflater().inflate(R.layout.selc_bell_pop,null);
                PopupWindow mPopupWindow = new PopupWindow(selcBellPopView, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

                mPopupWindow.setFocusable(true);

                mPopupWindow.showAtLocation(selcBellPopView, Gravity.CENTER, 0, 0);



//                  팝업 메뉴
//                PopupMenu pSelcBell = new PopupMenu(this, v);
//                pSelcBell.getMenuInflater().inflate(R.menu.selc_bell_menu, pSelcBell.getMenu());
//                pSelcBell.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
//                    @Override
//                    public boolean onMenuItemClick(MenuItem item) {
//                        switch (item.getItemId()){
//                            case R.id.alram_bell_1:
//                                Toast.makeText(getApplication(),"벨소리 리스트",Toast.LENGTH_SHORT).show();
//                                break;
//                        }
//                        return false;
//                    }
//                });
//                pSelcBell.show();
                break;

            case R.id.btn_selc_cycle:

                PopupMenu pSelcCycle = new PopupMenu(this, v);
                pSelcCycle.getMenuInflater().inflate(R.menu.selc_cycle_menu, pSelcCycle.getMenu());
                pSelcCycle.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.alram_cycle_1:
                                Toast.makeText(getApplication(),"cycle1",Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.alram_cycle_2:
                                Toast.makeText(getApplication(),"cycle2",Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.alram_cycle_3:
                                Toast.makeText(getApplication(),"cycle3",Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.alram_cycle_4:
                                Toast.makeText(getApplication(),"cycle4",Toast.LENGTH_SHORT).show();
                                break;
                        }
                        return false;
                    }
                });
                pSelcCycle.show();
                break;

            case R.id.btn_selc_group:

                PopupMenu pSelcGroup = new PopupMenu(this, v);
                pSelcGroup.getMenuInflater().inflate(R.menu.selc_group_menu, pSelcGroup.getMenu());
                pSelcGroup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.alram_group_1:
                                Toast.makeText(getApplication(),"alram_group_1",Toast.LENGTH_SHORT).show();
                                break;

                        }
                        return false;
                    }
                });
                pSelcGroup.show();
                break;

            case R.id.btn_selc_opt:

                PopupMenu pSelcOpt = new PopupMenu(this, v);
                pSelcOpt.getMenuInflater().inflate(R.menu.selc_opt_menu, pSelcOpt.getMenu());
                pSelcOpt.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.alram_opt_1:
                                Toast.makeText(getApplication(),"alram_opt_1",Toast.LENGTH_SHORT).show();
                                break;

                        }
                        return false;
                    }
                });
                pSelcOpt.show();
                break;
        }

    }
}
