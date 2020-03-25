package com.p.alphabetforkids.Activity;

import androidx.appcompat.app.AppCompatActivity;
import pl.droidsonroids.gif.GifImageView;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.p.alphabetforkids.R;
import com.squareup.picasso.Picasso;

public class ActivityBuildWordTwo extends AppCompatActivity {
    View view;
    private int myId;
    private Button option1, option2, option3, option4, option5, btnReNew,
            btnResult1, btnResult2, btnResult3, btnResult4, btnResult5,
            btnResult6, btnResult7, btnResult8, btnResult9, btnResult10, option10, option7, option8, option9, option6;
    private LinearLayout lnr1, lnr2, lnr3, lnr4, lnr5, lnr6, lnr7, lnr8, lnr9, lnr10;
    private TextView txtMainWord, txtLevelOne, txtLevelTwo;
    private ImageView imgLevelOne, imgLevelTwo, goRight, goLeft;
    MediaPlayer mediaPlayer;
    SharedPreferences sharedPreferences;
    int intValue;
    GifImageView gifImageView;
    ImageView imgBack, imgHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_build_word_two);

        //فول اسکرین کردن صفحه
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // مقدار پیش فرض شیردپرفرنسز
        sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("intValue", 0);
        editor.apply();

        findView();
        onClickMethod();
        settingTouchAndDragListenerForButtons();


        txtMainWord.setText("ایـ یـ ی ای");
        txtLevelTwo.setTextSize(15);
        option1.setText("ی");
        option2.setText("سـ");
        option3.setText("یـ");
        option4.setText("نـ");
        option5.setText("ای");
        option6.setText("مـ");
        option7.setText("ر");
        option8.setText("سـ");


        btnResult9.setText("ـه");
        lnr5.setVisibility(View.GONE);

        txtLevelOne.setText(" = سینی");
        txtLevelTwo.setText(" = سرمه ای");

        Picasso
                .with(getApplicationContext())
                .load(R.drawable.tray)
                .into(imgLevelOne);
        Picasso
                .with(getApplicationContext())
                .load(R.drawable.dark_blue)
                .into(imgLevelTwo);
    }

    public void findView() {
        imgBack = findViewById(R.id.imgBack);
        imgHome = findViewById(R.id.imgMyHome);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);
        option5 = findViewById(R.id.option5);
        option6 = findViewById(R.id.option6);
        option7 = findViewById(R.id.option7);
        option8 = findViewById(R.id.option8);
        option9 = findViewById(R.id.option9);
        option10 = findViewById(R.id.option10);

        btnResult1 = findViewById(R.id.result1);
        btnResult2 = findViewById(R.id.result2);
        btnResult3 = findViewById(R.id.result3);
        btnResult4 = findViewById(R.id.result4);
        btnResult5 = findViewById(R.id.result5);
        btnResult6 = findViewById(R.id.result6);
        btnResult7 = findViewById(R.id.result7);
        btnResult8 = findViewById(R.id.result8);
        btnResult9 = findViewById(R.id.result9);
        btnResult10 = findViewById(R.id.result10);


        lnr1 = findViewById(R.id.lnr1);
        lnr2 = findViewById(R.id.lnr2);
        lnr3 = findViewById(R.id.lnr3);
        lnr4 = findViewById(R.id.lnr4);
        lnr5 = findViewById(R.id.lnr5);
        lnr6 = findViewById(R.id.lnr6);
        lnr7 = findViewById(R.id.lnr7);
        lnr8 = findViewById(R.id.lnr8);
        lnr9 = findViewById(R.id.lnr9);
        lnr10 = findViewById(R.id.lnr10);


        btnReNew = findViewById(R.id.btnReNew);

        txtMainWord = findViewById(R.id.txt_mainWord);
        txtLevelOne = findViewById(R.id.txt_level_one);
        txtLevelTwo = findViewById(R.id.txt_level_two);

        imgLevelOne = findViewById(R.id.img_level_one);
        imgLevelTwo = findViewById(R.id.img_level_two);

        gifImageView = findViewById(R.id.tashvigh_soti);

    }

    public void onClickMethod() {
        btnReNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaOk(R.raw.practic);
                recreate();
            }
        });
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaOk(R.raw.click);
                finish();
            }
        });
        imgHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaOk(R.raw.click);
                Intent intent = new Intent(ActivityBuildWordTwo.this, ActivityAllAlphabet.class);
                startActivity(intent);
            }
        });


    }

    private void mediaOk(int p) {
        mediaPlayer = MediaPlayer.create(ActivityBuildWordTwo.this, p);
        mediaPlayer.start();
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.release();
            }
        });
    }

    private void sharedPref() {
        intValue = sharedPreferences.getInt("intValue", 0);
        sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("intValue", intValue + 1);
        editor.apply();
    }

    @SuppressLint("ClickableViewAccessibility")
    public void settingTouchAndDragListenerForButtons() {

        option1.setOnTouchListener(touchListener);
        option2.setOnTouchListener(touchListener);
        option3.setOnTouchListener(touchListener);
        option4.setOnTouchListener(touchListener);
        option5.setOnTouchListener(touchListener);
        option6.setOnTouchListener(touchListener);
        option7.setOnTouchListener(touchListener);
        option8.setOnTouchListener(touchListener);
        option9.setOnTouchListener(touchListener);
        option10.setOnTouchListener(touchListener);

        lnr1.setOnDragListener(dragListener);
        lnr2.setOnDragListener(dragListener);
        lnr3.setOnDragListener(dragListener);
        lnr4.setOnDragListener(dragListener);
        lnr5.setOnDragListener(dragListener);
        lnr6.setOnDragListener(dragListener);
        lnr7.setOnDragListener(dragListener);
        lnr8.setOnDragListener(dragListener);
        lnr9.setOnDragListener(dragListener);
        lnr10.setOnDragListener(dragListener);

    }

    // ست کردن تاچ لیسنر برای هر یک از آپشن ها
    View.OnTouchListener touchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            ClipData data = ClipData.newPlainText("", "");
            View.DragShadowBuilder myShadowBuilder = new View.DragShadowBuilder(v);
            v.startDrag(data, myShadowBuilder, v, 0);
            view = v;
            return true;

        }
    };

    //ست کرن درگ لیسنر برای ویو
    View.OnDragListener dragListener = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {
            int dragEvent = event.getAction();
            //  final View view = (View) event.getLocalState();

            switch (dragEvent) {
                case DragEvent.ACTION_DRAG_ENTERED:

                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    break;
                case DragEvent.ACTION_DROP:
                    settingForDropAndDrags(v, view);

                    break;


            }
            return true;
        }
    };

    private void settingForDropAndDrags(View v, View view) {
        if (view.getId() == R.id.option2|view.getId() == R.id.option8 && v.getId() == R.id.lnr1) {
            oldAndNewParent((LinearLayout) v, view, btnResult1, lnr1);
            mediaOk(R.raw.ok);
            sharedPref();
            intValueMethod();


        } else if (view.getId() == R.id.option3 && v.getId() == R.id.lnr2) {
            oldAndNewParent((LinearLayout) v, view, btnResult2, lnr2);
            mediaOk(R.raw.ok);
            sharedPref();
            intValueMethod();


        } else if (view.getId() == R.id.option4  && v.getId() == R.id.lnr3) {
            oldAndNewParent((LinearLayout) v, view, btnResult3, lnr3);
            mediaOk(R.raw.ok);
            sharedPref();
            intValueMethod();

        } else if (view.getId() == R.id.option1  && v.getId() == R.id.lnr4) {
            oldAndNewParent((LinearLayout) v, view, btnResult4, lnr4);
            mediaOk(R.raw.ok);
            sharedPref();
            intValueMethod();

        } else if (view.getId() == R.id.option2 | view.getId() == R.id.option8 && v.getId() == R.id.lnr6) {
            oldAndNewParent((LinearLayout) v, view, btnResult6, lnr6);
            mediaOk(R.raw.ok);
            sharedPref();
            intValueMethod();

        } else if (view.getId() == R.id.option7 && v.getId() == R.id.lnr7) {
            oldAndNewParent((LinearLayout) v, view, btnResult7, lnr7);
            mediaOk(R.raw.ok);
            sharedPref();
            intValueMethod();

        }else if (view.getId() == R.id.option6 && v.getId() == R.id.lnr8) {
            oldAndNewParent((LinearLayout) v, view, btnResult8, lnr8);
            mediaOk(R.raw.ok);
            sharedPref();
            intValueMethod();

        } else if (view.getId() == R.id.option5 && v.getId() == R.id.lnr10) {
            oldAndNewParent((LinearLayout) v, view, btnResult10, lnr10);
            mediaOk(R.raw.ok);
            sharedPref();
            intValueMethod();

        }else {
            mediaOk(R.raw.wrong);
        }

    }


    private void oldAndNewParent(LinearLayout v, View view, Button btnResult1, LinearLayout lnr1) {
        LinearLayout oldParent = (LinearLayout) view.getParent();
        oldParent.removeView(view);
        LinearLayout newParent = v;
        btnResult1.setVisibility(View.GONE);
        lnr1.setBackgroundColor(0xFF00FF00);
        newParent.addView(view);
    }
    private void intValueMethod() {
        if (intValue == 7) {
            mediaOk(R.raw.horaa);
            gifImageView.setVisibility(View.VISIBLE);
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    gifImageView.setVisibility(View.GONE);
                }
            }, 5000);


        }
    }
}
