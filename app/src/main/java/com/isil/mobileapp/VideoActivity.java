package com.isil.mobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity implements MediaPlayer.OnCompletionListener {
    VideoView mvvMuestra;
    private int mCurrentPosition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        MediaController controller = new MediaController(this);
        controller.setMediaPlayer(mvvMuestra);
        mCurrentPosition = 5000;




        mvvMuestra = findViewById(R.id.vvMuestra);

        Uri uri = Uri.parse("android.resource://" + getPackageName() +
                "/raw/demo" );
        mvvMuestra.setVideoURI(uri);
        mvvMuestra.setMediaController(controller);
        if (mCurrentPosition > 0) {
            mvvMuestra.seekTo(mCurrentPosition);
        } else {
            // Skipping to 1 shows the first frame of the video.
            mvvMuestra.seekTo(1);
        }
        mvvMuestra.start();
        //this.setTitle(String.valueOf(mvvMuestra.getCurrentPosition()));

        mvvMuestra.setOnCompletionListener(this);
    }

    public void verPosicion(View view) {
        this.setTitle(mvvMuestra.getDuration() + " de " +  mvvMuestra.getCurrentPosition() + " - " + mvvMuestra.getBufferPercentage());
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        Toast.makeText(this,"TERMINO",Toast.LENGTH_SHORT).show();
    }
}