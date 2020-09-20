package com.example.dp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

public class MainActivity2 extends AppCompatActivity {

    public VideoView splashScreenVideo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        splashScreenVideo = findViewById(R.id.splashScreenVideo);
        Uri video = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.re);

        splashScreenVideo.setVideoURI(video);

        splashScreenVideo.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                if(isFinishing() == false)
                {
                    Intent intent = new Intent(MainActivity2.this, Start.class);
                    finish();
                    startActivity(intent);
                }
            }
        });
        splashScreenVideo.start();
    }
}