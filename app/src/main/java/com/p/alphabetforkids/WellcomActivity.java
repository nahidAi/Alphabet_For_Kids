package com.p.alphabetforkids;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import pl.droidsonroids.gif.GifImageView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;

import com.p.alphabetforkids.util.IabHelper;
import com.p.alphabetforkids.util.IabResult;
import com.p.alphabetforkids.util.Inventory;
import com.p.alphabetforkids.util.Purchase;
import com.pushpole.sdk.PushPole;

import com.p.alphabetforkids.Activity.ActivityAllAlphabet;

import java.util.ArrayList;
import java.util.List;

public class WellcomActivity extends AppCompatActivity {
    GifImageView gifImageView;
    Button btnWellcom;
    MediaPlayer mediaPlayer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wellcom);








        //  سرویس پوشه
        PushPole.initialize(this, true);

        //فول اسکرین کردن صفحه
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //دادن انیمیشن به تصویر زنبور با استفاده از کتابخونه
        gifImageView = findViewById(R.id.z_wellcome);
        // Start the animation like this
        gifImageView.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.anim_left_to_right));

        //‍خش صدا موقع بالا آمدن اکتیویتی
        mediaPlayer = MediaPlayer.create(WellcomActivity.this, R.raw.wellcome);
        mediaPlayer.start();

        //قابلیت کلیک دکمه بزن بریم
        btnWellcom = findViewById(R.id.btn_WellCome);
        btnWellcom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
                Intent intent = new Intent(WellcomActivity.this, ActivityAllAlphabet.class);
                startActivity(intent);
                finish();


            }
        });

    }


    // برای اینکه دکمه بک خود گوشی کار نکنه
    @Override
    public void onBackPressed() {

    }

    //////////////////////////////////////////وقتی روی دکمه هوم در گوشی کلیک شد صدای برنامه قطع بشه
    // و همچنین برنامه در سیستم نصفه نمونه وقتی پخش شد از اول صداش پخش بشه
    @Override
    public void onPause() {
        super.onPause();
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            // System.exit(0);
        } else
            return;
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            //  System.exit(0);
        } else
            return;
    }
    /////////////////////////////////////////////////////////////////////////////////

    // دادن انیمیشن در رفتن از یک اکتیویتی به اکتیویتی دیگر
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }






}
