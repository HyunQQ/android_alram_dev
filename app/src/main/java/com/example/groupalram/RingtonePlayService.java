package com.example.groupalram;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;

public class RingtonePlayService extends Service {
    MediaPlayer mediaPlayer;
//    int startId;
//    boolean isRunning;

    @Nullable
    @Override
    public IBinder onBind(Intent intent){
        return null;
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        String getState = intent.getExtras().getString("state");
        String ringToneName = intent.getExtras().getString("ringToneName");
        Uri rinToneUri = Uri.parse(intent.getExtras().getString("rinToneUri"));
        Toast.makeText(this, "알람이 울립니다.", Toast.LENGTH_SHORT).show();
        mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource(getApplicationContext(), rinToneUri);
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return START_NOT_STICKY;
    }
//        assert getState != null;
//        switch (getState) {
//            case "alarm on":
//                startId = 1;
//                break;
//            case "alarm off":
//                startId = 0;
//                break;
//            default:
//                startId = 0;
//                break;
//        }

        // 알람음 재생 X , 알람음 시작 클릭
//        if(!this.isRunning && startId == 1) {
//
////            mediaPlayer = MediaPlayer.create(this, ringToneName+rinToneUri);
//
//
//
//            this.isRunning = true;
//            this.startId = 0;
//        }
//
//        // 알람음 재생 O , 알람음 종료 버튼 클릭
//        else if(this.isRunning && startId == 0) {
//
//            mediaPlayer.stop();
//            mediaPlayer.reset();
//            mediaPlayer.release();
//
//            this.isRunning = false;
//            this.startId = 0;
//        }
//
//        // 알람음 재생 X , 알람음 종료 버튼 클릭
//        else if(!this.isRunning && startId == 0) {
//
//            this.isRunning = false;
//            this.startId = 0;
//
//        }
//
//        // 알람음 재생 O , 알람음 시작 버튼 클릭
//        else if(this.isRunning && startId == 1){
//
//            this.isRunning = true;
//            this.startId = 1;
//        }
//
//        else {
//        }
//        return START_NOT_STICKY;
//    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.d("onDestory() 실행", "서비스 파괴");

    }

}
