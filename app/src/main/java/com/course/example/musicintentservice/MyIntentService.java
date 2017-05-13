//This IntentService handles 3 tasks.
// Playing one of 2 streams and stopping the playing stream.
package com.course.example.musicintentservice;

import android.app.IntentService;
import android.content.Intent;
import android.media.MediaPlayer;
import android.util.Log;

import java.io.IOException;

public class MyIntentService extends IntentService {

    //must be static otherwise MediaPlayer is redeclared each time Service is used
    // and object reference is lost
    private static MediaPlayer mp;

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        String msg = intent.getStringExtra("MSG");
        Log.e("MyIntentService", msg);

        if (msg.equals(MainActivity.MSG_START_HARVARD)) {
            //check to see if another stream is already playing
            if (mp!=null && mp.isPlaying()) mp.stop();

            mp = new MediaPlayer();
            try {
                //select Harvard stream
                mp.setDataSource("http://hrbinc-hi.streamguys.net");
                mp.prepare();
                mp.start();
            } catch (IOException e) {
            }

        } else if (msg.equals(MainActivity.MSG_START_BBC)) {
            //check to see if another stream is already playing
            if (mp!=null && mp.isPlaying()) mp.stop();

            mp = new MediaPlayer();
            try {
                //select BBC stream
                mp.setDataSource("http://vprbbc.streamguys.net:80/vprbbc24.mp3");
                mp.prepare();
                mp.start();
            } catch (IOException e) {
            }
        } else mp.stop();

    }
}