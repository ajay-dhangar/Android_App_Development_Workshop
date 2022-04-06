package com.example.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;

import androidx.annotation.Nullable;


public class myService extends Service {

    //create media player
    MediaPlayer mediaPlayer;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mediaPlayer = MediaPlayer.create(this, R.raw.mysong);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();

        return START_STICKY;

    }

    @Override
    public void onDestroy() {
        mediaPlayer.stop();

        super.onDestroy();

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
