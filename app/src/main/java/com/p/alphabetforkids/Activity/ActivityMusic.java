package com.p.alphabetforkids.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.p.alphabetforkids.R;

public class ActivityMusic extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    private int Id;
    ImageView imgToolbarBack;
    private Button btnMusicText;
    private TextView txtMusic;
    private Boolean isVisible = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        //فول اسکرین کردن صفحه
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
       //   گرفتن ایدی
        Bundle bundle = getIntent().getExtras();
        Id = Integer.parseInt(bundle.getString("id"));
        switchMethodForPoetry();
        findView_onClick();
    }

    public void switchMethodForPoetry() {
        switch (Id) {
            case 1:
                mediaPlayer = MediaPlayer.create(ActivityMusic.this, R.raw.m_a);
                mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(100,100);
                mediaPlayer.start();

                break;
            case 2:
                mediaPlayer = MediaPlayer.create(ActivityMusic.this, R.raw.m_b);
                mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(100,100);
                mediaPlayer.start();
                break;
            case 3:
                mediaPlayer = MediaPlayer.create(ActivityMusic.this, R.raw.m_p);
                mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(100,100);
                mediaPlayer.start();
                break;
            case 4:
                mediaPlayer = MediaPlayer.create(ActivityMusic.this, R.raw.m_t);
                mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(100,100);
                mediaPlayer.start();
                break;
            case 5:
                mediaPlayer = MediaPlayer.create(ActivityMusic.this, R.raw.m_ccc);
                mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(100,100);
                mediaPlayer.start();
                break;
            case 6:
                mediaPlayer = MediaPlayer.create(ActivityMusic.this, R.raw.m_j);
                mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(100,100);
                mediaPlayer.start();
                break;
            case 7:
                mediaPlayer = MediaPlayer.create(ActivityMusic.this, R.raw.m_ch);
                mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(100,100);
                mediaPlayer.start();
                break;
            case 8:
                mediaPlayer = MediaPlayer.create(ActivityMusic.this, R.raw.m_h);
                mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(100,100);
                mediaPlayer.start();
                break;
            case 9:
                mediaPlayer = MediaPlayer.create(ActivityMusic.this, R.raw.m_kh);
                mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(100,100);
                mediaPlayer.start();
                break;
            case 10:
                mediaPlayer = MediaPlayer.create(ActivityMusic.this, R.raw.m_d);
                mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(100,100);
                mediaPlayer.start();
                break;
            case 11:
                mediaPlayer = MediaPlayer.create(ActivityMusic.this, R.raw.m_zal);
                mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(100,100);
                mediaPlayer.start();
                break;
            case 12:
                mediaPlayer = MediaPlayer.create(ActivityMusic.this, R.raw.m_r);
                mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(100,100);
                mediaPlayer.start();
                break;
            case 13:
                mediaPlayer = MediaPlayer.create(ActivityMusic.this, R.raw.m_z);
                mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(100,100);
                mediaPlayer.start();
                break;
            case 14:
                mediaPlayer = MediaPlayer.create(ActivityMusic.this, R.raw.m_zh);
                mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(100,100);
                mediaPlayer.start();
                break;
            case 15:
                mediaPlayer = MediaPlayer.create(ActivityMusic.this, R.raw.m_c);
                mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(100,100);
                mediaPlayer.start();
                break;
            case 16:
                mediaPlayer = MediaPlayer.create(ActivityMusic.this, R.raw.m_sh);
                mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(100,100);
                mediaPlayer.start();
                break;
            case 17:
                mediaPlayer = MediaPlayer.create(ActivityMusic.this, R.raw.m_sad);
                mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(100,100);
                mediaPlayer.start();
                break;
            case 18:
                mediaPlayer = MediaPlayer.create(ActivityMusic.this, R.raw.m_zad);
                mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(100,100);
                mediaPlayer.start();
                break;
            case 19:
                mediaPlayer = MediaPlayer.create(ActivityMusic.this, R.raw.m_t);
                mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(100,100);
                mediaPlayer.start();
                break;
            case 20:
                mediaPlayer = MediaPlayer.create(ActivityMusic.this, R.raw.m_za);
                mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(100,100);
                mediaPlayer.start();
                break;
            case 21:
                mediaPlayer = MediaPlayer.create(ActivityMusic.this, R.raw.m_ain);
                mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(100,100);
                mediaPlayer.start();
                break;
            case 22:
                mediaPlayer = MediaPlayer.create(ActivityMusic.this, R.raw.m_ghein);
                mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(100,100);
                mediaPlayer.start();
                break;
            case 23:
                mediaPlayer = MediaPlayer.create(ActivityMusic.this, R.raw.m_f);
                mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(100,100);
                mediaPlayer.start();
                break;
            case 67:
                mediaPlayer = MediaPlayer.create(ActivityMusic.this, R.raw.m_gh);
                mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(100,100);
                mediaPlayer.start();
                break;
            case 68:
                mediaPlayer = MediaPlayer.create(ActivityMusic.this, R.raw.m_k);
                mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(100,100);
                mediaPlayer.start();
                break;
            case 69:
                mediaPlayer = MediaPlayer.create(ActivityMusic.this, R.raw.m_ghaf);
                mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(100,100);
                mediaPlayer.start();
                break;
            case 70:
                mediaPlayer = MediaPlayer.create(ActivityMusic.this, R.raw.m_l);
                mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(100,100);
                mediaPlayer.start();
                break;
            case 71:
                mediaPlayer = MediaPlayer.create(ActivityMusic.this, R.raw.m_m);
                mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(100,100);
                mediaPlayer.start();
                break;
            case 72:
                mediaPlayer = MediaPlayer.create(ActivityMusic.this, R.raw.m_n);
                mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(100,100);
                mediaPlayer.start();
                break;
            case 73:
                mediaPlayer = MediaPlayer.create(ActivityMusic.this, R.raw.m_v);
                mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(100,100);
                mediaPlayer.start();
                break;
            case 74:
                mediaPlayer = MediaPlayer.create(ActivityMusic.this, R.raw.m_ha);
                mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(100,100);
                mediaPlayer.start();
                break;
            case 75:
                mediaPlayer = MediaPlayer.create(ActivityMusic.this, R.raw.m_i);
                mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(100,100);
                mediaPlayer.start();
                break;
            case 76:
                mediaPlayer = MediaPlayer.create(ActivityMusic.this, R.raw.m_ei);
                mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(100,100);
                mediaPlayer.start();
                break;
            case 77:
                mediaPlayer = MediaPlayer.create(ActivityMusic.this, R.raw.m_aa);
                mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(100,100);
                mediaPlayer.start();
                break;
            case 78:
                mediaPlayer = MediaPlayer.create(ActivityMusic.this, R.raw.m_ea);
                mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(100,100);
                mediaPlayer.start();
                break;
            case 79:
                mediaPlayer = MediaPlayer.create(ActivityMusic.this, R.raw.m_o);
                mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(100,100);
                mediaPlayer.start();
                break;
            case 80:
                mediaPlayer = MediaPlayer.create(ActivityMusic.this, R.raw.m_tashdid);
                mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(100,100);
                mediaPlayer.start();
                break;
        }
    }

    public void findView_onClick() {
        txtMusic = findViewById(R.id.txtMusic);
        imgToolbarBack = findViewById(R.id.imageToolbarBack);
        imgToolbarBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
                finish();
            }
        });
        btnMusicText = findViewById(R.id.btnMusicText);
        btnMusicText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isVisible){
                    txtMusic.setVisibility(View.VISIBLE);
                    isVisible=false;
                    btnMusicText.setText("حذف متن");
                }else  if (!isVisible){
                    txtMusic.setVisibility(View.GONE);
                    isVisible=true;
                    btnMusicText.setText("متن شعر رو ببین");
                }


            }
        });
    }

    // برای اینکه دکمه بک خود گوشی کار نکنه
    @Override
    public void onBackPressed() {

    }
}
