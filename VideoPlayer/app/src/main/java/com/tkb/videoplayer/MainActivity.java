package com.tkb.videoplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Update{

    Button btnPlay,btnBack,btnForward;
    TextView txtDisplay;
    PlayerInterface player;
    Drawable pauseDrawable,playDrawable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialization();
    }

    private void initialization() {
        btnBack = findViewById(R.id.btnBack);
        btnForward = findViewById(R.id.btnForward);
        btnPlay = findViewById(R.id.btnPlay);

        txtDisplay = findViewById(R.id.txtDisplay);

        btnPlay.setOnClickListener(this);
        btnForward.setOnClickListener(this);
        btnBack.setOnClickListener(this);

        setTag(Constants.PLAY_TAG);
        player = new PlayerFacade(new Player(),this);

        pauseDrawable =  ContextCompat.getDrawable(this, R.drawable.pause);
        playDrawable =  ContextCompat.getDrawable(this, R.drawable.play);

        changeImage(playDrawable);

    }

    @Override
    public void update(String value) {
        txtDisplay.setText(value);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnBack:
                player.rewind();
                break;
            case R.id.btnForward:
                player.forward();
                break;
            case R.id.btnPlay:
                if (btnPlay.getTag().equals(Constants.PLAY_TAG)){
                    setTag(Constants.PAUSE_TAG);
                    player.play();
                    changeImage(pauseDrawable);
                }else {
                    setTag(Constants.PLAY_TAG);
                    player.pause();
                    changeImage(playDrawable);
                }
                break;
        }
    }

    private void setTag(String tag){
        btnPlay.setTag(tag);
    }

    private void changeImage(Drawable img){
        btnPlay.setCompoundDrawablesWithIntrinsicBounds(null, img , null, null);
    }
}
