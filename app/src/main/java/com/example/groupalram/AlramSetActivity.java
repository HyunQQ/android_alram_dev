package com.example.groupalram;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AlramSetActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnSetAlramCancle;
    private Button btnSetAlramSave;
    private Button btnSelcBell;
    private Button btnSelcCycle;
    private Button btnSelcGroup;
    private Button btnSelcOpt;

    public static final int REQUEST_CODE_RINGTONE=10005;

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
                selcBellShow();
                break;

            case R.id.btn_selc_cycle:
                selcCycleShow();
                break;

            case R.id.btn_selc_group:
                selcGroupShow();
                break;

            case R.id.btn_selc_opt:
                selcOptShow();
                break;
        }

    }
    // 팝업 메뉴에서의 리턴값 활용을 위해
    public void onActivityResult(int requestCode, int resultCode, Intent intent){
        super.onActivityResult(requestCode, resultCode, intent);
        switch (requestCode){
            case REQUEST_CODE_RINGTONE:
                if(resultCode == RESULT_OK){
                    Uri uri = intent.getParcelableExtra(RingtoneManager.EXTRA_RINGTONE_PICKED_URI);
                    String ringToneName = RingtoneManager.getRingtone(this, uri).getTitle(this);
                    Toast.makeText(getApplicationContext(), ringToneName + "is selected", Toast.LENGTH_SHORT).show();
                }
        }
    }

    public void selcBellShow(){
//        https://developer.android.com/reference/android/media/RingtoneManager 찾아보기
        Intent intent = new Intent(RingtoneManager.ACTION_RINGTONE_PICKER);
        intent.putExtra(RingtoneManager.EXTRA_RINGTONE_TITLE,"벨소리를 선택하세요.");
        intent.putExtra(RingtoneManager.EXTRA_RINGTONE_SHOW_SILENT, false);
        intent.putExtra(RingtoneManager.EXTRA_RINGTONE_SHOW_DEFAULT, true);
        intent.putExtra(RingtoneManager.EXTRA_RINGTONE_TYPE,RingtoneManager.TYPE_ALARM);
        startActivityForResult(intent, REQUEST_CODE_RINGTONE);
    }

    public void selcCycleShow(){
        final List<String> ListItems = new ArrayList<>();
        ListItems.add("test cycle1");
        ListItems.add("test cycle2");
        ListItems.add("test cycle3");

        final CharSequence[] items = ListItems.toArray(new String[ListItems.size()]);

        final List selectedItems = new ArrayList();
        int defaultItem = 0;
        selectedItems.add(defaultItem);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("벨소리 선택");
        builder.setSingleChoiceItems(items, defaultItem,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        selectedItems.clear();
                        selectedItems.add(which);
                    }
                });
        builder.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String msg ="";

                        if(!selectedItems.isEmpty()){
                            int index = (int) selectedItems.get(0);
                            msg = ListItems.get(index);
                        }
                        Toast.makeText(getApplicationContext(), msg + "Item Selected.", Toast.LENGTH_SHORT).show();
                    }
                });
        builder.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        builder.show();
    }
    public void selcGroupShow(){
        final List<String> ListItems = new ArrayList<>();
        ListItems.add("test group1");
        ListItems.add("test group2");
        ListItems.add("test group3");

        final CharSequence[] items = ListItems.toArray(new String[ListItems.size()]);

        final List selectedItems = new ArrayList();
        int defaultItem = 0;
        selectedItems.add(defaultItem);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("그룹 선택");
        builder.setSingleChoiceItems(items, defaultItem,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        selectedItems.clear();
                        selectedItems.add(which);
                    }
                });
        builder.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String msg ="";

                        if(!selectedItems.isEmpty()){
                            int index = (int) selectedItems.get(0);
                            msg = ListItems.get(index);
                        }
                        Toast.makeText(getApplicationContext(), msg + "Item Selected.", Toast.LENGTH_SHORT).show();
                    }
                });
        builder.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        builder.show();
    }
    public void selcOptShow(){
        final List<String> ListItems = new ArrayList<>();
        ListItems.add("test opt1");
        ListItems.add("test opt2");
        ListItems.add("test opt3");

        final CharSequence[] items = ListItems.toArray(new String[ListItems.size()]);

        final List selectedItems = new ArrayList();
        int defaultItem = 0;
        selectedItems.add(defaultItem);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("옵션 선택");
        builder.setSingleChoiceItems(items, defaultItem,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        selectedItems.clear();
                        selectedItems.add(which);
                    }
                });
        builder.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String msg ="";

                        if(!selectedItems.isEmpty()){
                            int index = (int) selectedItems.get(0);
                            msg = ListItems.get(index);
                        }
                        Toast.makeText(getApplicationContext(), msg + "Item Selected.", Toast.LENGTH_SHORT).show();
                    }
                });
        builder.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        builder.show();
    }
}
