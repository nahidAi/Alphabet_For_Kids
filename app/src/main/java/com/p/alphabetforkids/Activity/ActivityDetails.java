package com.p.alphabetforkids.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.hujiaweibujidao.wava.Techniques;
import com.github.hujiaweibujidao.wava.YoYo;
import com.p.alphabetforkids.R;

public class ActivityDetails extends AppCompatActivity {
    ImageView imgbackRight, imagbackLeft, imgMusic, imgHome, imgEdit;
    TextView txtTop,txt_small_alphabet,txt_larg_alphabet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_for_four_word);
        findView();
        onClick();

        //فول اسکرین کردن صفحه
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //  دادن انیمیشن به تکست
       /* YoYo.with(Techniques.Shake).duration(1200)
                .playOn(txtTop);

        YoYo.with(Techniques.Shake).duration(1200)
                .playOn(txt_small_alphabet);

        YoYo.with(Techniques.Shake).duration(1200)
                .playOn(txt_larg_alphabet);*/




    }

    public void findView() {
        imagbackLeft = findViewById(R.id.back_left);
        imgbackRight = findViewById(R.id.back_right);
        imgMusic = findViewById(R.id.music);
        imgHome = findViewById(R.id.home);
        imgEdit = findViewById(R.id.edit);
        txtTop = findViewById(R.id.txt_top);
        txt_small_alphabet = findViewById(R.id.txt_First_small_alphabet);
        txt_larg_alphabet = findViewById(R.id.txt_First_larg_alphabet);
    }

    public void onClick() {
        imagbackLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ActivityDetails.this, "clicked", Toast.LENGTH_SHORT).show();
            }
        });
        imgbackRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ActivityDetails.this, "clicked", Toast.LENGTH_SHORT).show();
            }
        });
        imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ActivityDetails.this, "clicked", Toast.LENGTH_SHORT).show();
            }
        });
        imgHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ActivityDetails.this, "clicked", Toast.LENGTH_SHORT).show();
            }
        });
        imgMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ActivityDetails.this, "clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }


   /* public void showAlfaAnimation() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(1000);
        alphaAnimation.setFillAfter(true);
         // alphaAnimation.setRepeatCount(Animation.INFINITE);
        // alphaAnimation.setRepeatMode(Animation.REVERSE);
        txtTop.setAnimation(alphaAnimation);
    }*/

   /* public void showTranslateAnimation() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0, 0, 0, 100);
        translateAnimation.setDuration(1000);
        translateAnimation.setFillAfter(true);
        translateAnimation.setRepeatCount(3);
        translateAnimation.setRepeatMode(Animation.REVERSE);
        translateAnimation.setInterpolator(new BounceInterpolator());
        txtTop.startAnimation(translateAnimation);
    }*/
}
