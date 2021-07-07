package com.example.memo;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class SplashActivity extends AppCompatActivity  /*implements Runnable*/ {

    @SuppressLint("StaticFieldLeak")
    protected static LinearLayout imgNumber, imgSpeaker;
    @SuppressLint("StaticFieldLeak")
    protected static ImageView imgTrophy;
    private ImageView imgDelete;
    private Button btnPlay, btnOut;
    protected static int level;
    private MediaPlayer player;
    @SuppressLint("StaticFieldLeak")
    protected static Chronometer splashTime;
    protected static long time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //Handler handler = new Handler();
        //handler.postDelayed(this,3000);
        btnPlay = findViewById(R.id.btnPlay);
        btnOut = findViewById(R.id.btnOut);
        imgNumber = findViewById(R.id.imgNumber);
        imgSpeaker = findViewById(R.id.imgSpeaker);
        imgTrophy = findViewById(R.id.imgTrophy);
        imgDelete = findViewById(R.id.imgDelete);
        splashTime = findViewById(R.id.splashTime);

        if(level > 0) {
            time = splashTime.getBase() + time;
            splashTime.setBase(time);
        }
        level++;

        if(level ==1){
            sleep1();
            player.setLooping(true);
        }

        imgSpeaker.setOnClickListener(v -> {
            if(player.isPlaying()) {
                player.stop();
                imgDelete.setVisibility(View.VISIBLE);
            }else if (!player.isPlaying()) {
                player.setLooping(true);
                switch (level) {
                    case 1:
                        player = MediaPlayer.create(SplashActivity.this, R.raw.sleep1);
                        player.start();
                        imgDelete.setVisibility(View.INVISIBLE);
                        break;
                    case 2:
                        player = MediaPlayer.create(SplashActivity.this, R.raw.sleep2);
                        player.start();
                        imgDelete.setVisibility(View.INVISIBLE);
                        break;
                    case 3:
                        player = MediaPlayer.create(SplashActivity.this, R.raw.sleep3);
                        player.start();
                        imgDelete.setVisibility(View.INVISIBLE);
                        break;
                    case 4:
                        player = MediaPlayer.create(SplashActivity.this, R.raw.sleep4);
                        player.start();
                        imgDelete.setVisibility(View.INVISIBLE);
                        break;
                    case 5:
                        player = MediaPlayer.create(SplashActivity.this, R.raw.sleep5);
                        player.start();
                        imgDelete.setVisibility(View.INVISIBLE);
                        break;
                    case 6:
                        player = MediaPlayer.create(SplashActivity.this, R.raw.sleep6);
                        player.start();
                        imgDelete.setVisibility(View.INVISIBLE);
                        break;
                    case 7:
                        player = MediaPlayer.create(SplashActivity.this, R.raw.sleep7);
                        player.start();
                        imgDelete.setVisibility(View.INVISIBLE);
                        break;
                    default:
                        player = MediaPlayer.create(SplashActivity.this, R.raw.sleep);
                        player.start();
                        imgDelete.setVisibility(View.INVISIBLE);
                        break;
                }
            }
        });

        if(level == 9) level = 2;

        switch(level) {
            case 2:
                imgNumber.setBackgroundResource(R.drawable.one);
                visible();
                sleep2();
                player.setLooping(true);
                break;
            case 3:
                imgNumber.setBackgroundResource(R.drawable.two);
                visible();
                sleep3();
                player.setLooping(true);
                break;
            case 4:
                imgNumber.setBackgroundResource(R.drawable.three);
                visible();
                sleep4();
                player.setLooping(true);
                break;
            case 5:
                imgNumber.setBackgroundResource(R.drawable.four);
                visible();
                sleep5();
                player.setLooping(true);
                break;
            case 6:
                imgNumber.setBackgroundResource(R.drawable.five);
                visible();
                sleep6();
                player.setLooping(true);
                break;
            case 7:
                imgNumber.setBackgroundResource(R.drawable.six);
                visible();
                sleep7();
                player.setLooping(true);
                break;
            case 8:
                imgNumber.setBackgroundResource(R.drawable.seven);
                visible();
                btnPlay.setText(R.string.playagain);
                sleep();
                player.setLooping(true);
                break;
            default:
                invisible();
                break;
        }

        btnPlay.setOnClickListener(v -> {
            btnPlay.setBackgroundColor(Color.GRAY);
            player.stop();


            Intent displaySplash = new Intent(SplashActivity.this, MainActivity.class);
            SplashActivity.this.startActivity(displaySplash);
            SplashActivity.this.finish();
        });

        btnOut.setOnClickListener(v -> {
            btnOut.setBackgroundColor(Color.GRAY);
            player.stop();
            level = 0;
            SplashActivity.this.finish();
        });
    }

    private void visible() {
        imgNumber.setVisibility(View.VISIBLE);
        imgTrophy.setVisibility(View.VISIBLE);
        splashTime.setVisibility(View.VISIBLE);
        btnPlay.setText(R.string.goon);
    }

    private void invisible() {
        imgNumber.setVisibility(View.INVISIBLE);
        imgTrophy.setVisibility(View.INVISIBLE);
        splashTime.setVisibility(View.INVISIBLE);
        btnPlay.setText(R.string.play);
    }

    protected void release() {
        if(player != null) {
            player.release();
        }
    }

    protected void sleep(){
        release();
        if(player == null) {
            player = MediaPlayer.create(SplashActivity.this, R.raw.sleep);
            player.start();
        }else if(!player.isPlaying()) {
            player = MediaPlayer.create(SplashActivity.this, R.raw.sleep);
            player.start();
        }
    }

    protected void sleep1(){
        release();
        if(player == null ) {
            player = MediaPlayer.create(SplashActivity.this, R.raw.sleep1);
            player.start();
        }else if(!player.isPlaying()) {
            player = MediaPlayer.create(SplashActivity.this, R.raw.sleep1);
            player.start();
        }
    }

    protected void sleep2(){
        release();
        if(player == null) {
            player = MediaPlayer.create(SplashActivity.this, R.raw.sleep2);
            player.start();
        }else if(!player.isPlaying()) {
            player = MediaPlayer.create(SplashActivity.this, R.raw.sleep2);
            player.start();
        }
    }

    protected void sleep3(){
        release();
        if(player == null) {
            player = MediaPlayer.create(SplashActivity.this, R.raw.sleep3);
            player.start();
        }else if(!player.isPlaying()) {
            player = MediaPlayer.create(SplashActivity.this, R.raw.sleep3);
            player.start();
        }
    }

    protected void sleep4(){
        release();
        if(player == null) {
            player = MediaPlayer.create(SplashActivity.this, R.raw.sleep4);
            player.start();
        }else if(!player.isPlaying()) {
            player = MediaPlayer.create(SplashActivity.this, R.raw.sleep4);
            player.start();
        }
    }

    protected void sleep5(){
        release();
        if(player == null) {
            player = MediaPlayer.create(SplashActivity.this, R.raw.sleep5);
            player.start();
        }else if(!player.isPlaying()) {
            player = MediaPlayer.create(SplashActivity.this, R.raw.sleep5);
            player.start();
        }
    }

    protected void sleep6(){
        release();
        if(player == null) {
            player = MediaPlayer.create(SplashActivity.this, R.raw.sleep6);
            player.start();
        }else if(!player.isPlaying()) {
            player = MediaPlayer.create(SplashActivity.this, R.raw.sleep6);
            player.start();
        }
    }

    protected void sleep7(){
        release();
        if(player == null) {
            player = MediaPlayer.create(SplashActivity.this, R.raw.sleep7);
            player.start();
        }else if(!player.isPlaying()) {
            player = MediaPlayer.create(SplashActivity.this, R.raw.sleep7);
            player.start();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        btnOut.callOnClick();
        MainActivity.imageRepository = 0;
    }

    /* @Override
    public void run() {
        Intent displaySplash = new Intent(SplashActivity.this, MainActivity.class);
        SplashActivity.this.startActivity(displaySplash);
        SplashActivity.this.finish();
    } */

}