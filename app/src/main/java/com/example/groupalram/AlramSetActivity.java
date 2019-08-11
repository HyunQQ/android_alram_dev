package com.example.groupalram;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class AlramSetActivity extends AppCompatActivity implements View.OnClickListener, TimePicker.OnTimeChangedListener {
    private Button btnSetAlramCancle;
    private Button btnSetAlramSave;
    private Button btnSelcBell;
    private Button btnSelcCycle;
    private Button btnSelcGroup;
    private Button btnSelcOpt;
    private ToggleButton btnMon;
    private ToggleButton btnTue;
    private ToggleButton btnWed;
    private ToggleButton btnThu;
    private ToggleButton btnFri;
    private ToggleButton btnSat;
    private ToggleButton btnSun;



    TimePicker mTimePicker;
    int pickerHourDay =0;
    int pickerMinute = 0;
    // 시간 설정을 위한 객체
    Calendar Time;

    //알람 설정을 위한 객체
//    private Intent intent;
    private PendingIntent pendingIntent;
    private AlarmManager alarmManager;
    private Calendar calendar;
    private String ringToneName;
    private Uri rinToneUri;
    public static final int REQUEST_CODE_RINGTONE=10005;

    //timepicker 설정 값 받아오는 함수
    @Override
    public void onTimeChanged(TimePicker timePicker, int hourOfDay, int minute){
        pickerHourDay = hourOfDay;
        pickerMinute = minute;
    }

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

        btnMon = (ToggleButton) findViewById(R.id.btn_mon);
        btnTue = (ToggleButton) findViewById(R.id.btn_tue);
        btnWed = (ToggleButton) findViewById(R.id.btn_wed);
        btnThu = (ToggleButton) findViewById(R.id.btn_thu);
        btnFri = (ToggleButton) findViewById(R.id.btn_fri);
        btnSat = (ToggleButton) findViewById(R.id.btn_sat);
        btnSun = (ToggleButton) findViewById(R.id.btn_sun);

        mTimePicker         = (TimePicker)findViewById(R.id.alram_time_picker);
        mTimePicker.setIs24HourView(false);
        mTimePicker.setOnTimeChangedListener(this);



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
                setAlarm();
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
                    rinToneUri = intent.getParcelableExtra(RingtoneManager.EXTRA_RINGTONE_PICKED_URI);
                    ringToneName = RingtoneManager.getRingtone(this, rinToneUri).getTitle(this);
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

//    알람 설정
//    참고
//    https://illua.tistory.com/1
//    https://androidclarified.com/android-example-alarm-manager-complete-working/
//    https://developer88.tistory.com/83
    public void setAlarm(){
        //알람 receiver intent 생성(xml 파일에 ALARM_START 이름으로 AlarmReciver 연결)
        Intent intent = new Intent("com.example.groupalram.ALARM_START");

        //벨소리 선택 여부 확인
        if(rinToneUri == null){
            Toast.makeText(getApplicationContext(), "벨소리를 선택해주세요.", Toast.LENGTH_SHORT).show();
        }else {
            intent.putExtra("state","alarm on");
            intent.putExtra("ringToneName", ringToneName);
            intent.putExtra("rinToneUri", rinToneUri.toString());

            //Toast.makeText(getApplicationContext(), "벨소리 uri:"+rinToneUri.toString(), Toast.LENGTH_SHORT).show();

            pendingIntent = PendingIntent.getBroadcast(
                    this, 111, intent, PendingIntent.FLAG_UPDATE_CURRENT);

            calendar = Calendar.getInstance();
//        시간 선택이 안되었을 경우 현재 시간으로 등록
            if( pickerHourDay == 0 && pickerMinute == 0){
                pickerHourDay = calendar.get(Calendar.HOUR_OF_DAY);
                pickerMinute = calendar.get(Calendar.MINUTE);
            }else{
                calendar.set(Calendar.HOUR_OF_DAY, pickerHourDay);
                calendar.set(Calendar.MINUTE, pickerMinute);
            }
            alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
            alarmManager.set(AlarmManager.RTC, calendar.getTimeInMillis(), pendingIntent);

            Toast.makeText(getBaseContext(),"알람 설정:"+pickerHourDay+"시"+pickerMinute+"분", Toast.LENGTH_SHORT).show();
        }
    }

}
