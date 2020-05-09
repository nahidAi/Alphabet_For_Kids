package com.p.alphabetforkids.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import pl.droidsonroids.gif.GifImageView;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ClipData;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetView;
import com.p.alphabetforkids.R;
import com.squareup.picasso.Picasso;

public class ActivityBuildWord extends AppCompatActivity {

    View view;
    private int myId;
    private Button option1, option2, option3, option4, option5, btnReNew,
            btnResult1, btnResult2, btnResult3, btnResult4, btnResult5,
            btnResult6, btnResult7, btnResult8, btnResult9, btnResult10, option10,
            option7, option8, option9, option6, btnGoNextActivity;
    private LinearLayout lnr1, lnr2, lnr3, lnr4, lnr5, lnr6, lnr7, lnr8, lnr9, lnr10;
    private TextView txtMainWord, txtLevelOne, txtLevelTwo;
    private ImageView imgLevelOne, imgLevelTwo, goRight, goLeft, audioLevelOne, audioLevelTwo, imgBack, imgHome, imgHelp;
    MediaPlayer mediaPlayer;
    SharedPreferences sharedPreferences;
    int intValue;
    GifImageView gifImageView;
    boolean isShowTapTargetView = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_build_word);



        //گرفتن آیدی
        Bundle bundle = getIntent().getExtras();
        myId = Integer.parseInt(bundle.getString("id"));

        //فول اسکرین کردن صفحه
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // مقدار پیش فرض شیردپرفرنسز
        sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("intValue", 0);
        editor.apply();

        boolean showHelp = sharedPreferences.getBoolean("TapTargetView_build_word", false);
        if (showHelp == false) {
            final Drawable drawable = ContextCompat.getDrawable(this, R.drawable.ic_help_black_24dp);
            TapTargetView.showFor(this,
                    TapTarget.forView(findViewById(R.id.imgHelp), "راهنمای تمرین", "گلم اینجا میتونی با طریقه املا نوشتن آشنا بشی.ابتدا به تلفظ کلمه گوش کن بعد حروف مناسب همون کلمه رو بکش و در جای خودش قرار بده")
                            .outerCircleColor(R.color.yellow_dark)
                            .outerCircleAlpha(0.96f)
                            .targetCircleColor(R.color.White)
                            .titleTextSize(20)
                            .titleTextColor(R.color.White)
                            .descriptionTextSize(20)
                            .descriptionTextColor(R.color.red)
                            .textColor(R.color.black)
                            .textTypeface(Typeface.SANS_SERIF)
                            .dimColor(R.color.black)
                            .drawShadow(true)
                            .cancelable(true)
                            .transparentTarget(false)
                            .icon(drawable)
                            .targetRadius(60),
                    new TapTargetView.Listener() {
                        @Override
                        public void onTargetClick(TapTargetView view) {
                            super.onTargetClick(view);

                        }
                    });
            isShowTapTargetView = true;
            sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
            SharedPreferences.Editor editor1 = sharedPreferences.edit();
            editor1.putBoolean("TapTargetView_build_word", isShowTapTargetView);
            editor1.apply();
        }


        findView();
        onClickMethod();
        changeWordsInTable();
        settingTouchAndDragListenerForButtons();

    }


    public void changeWordsInTable() {
        if (myId == 1) {
            txtMainWord.setText("آ ا");

            option1.setText("ا");
            option2.setText("آ");
            option3.setText("ا");


            lnr3.setVisibility(View.GONE);
            lnr4.setVisibility(View.GONE);
            lnr5.setVisibility(View.GONE);
            lnr10.setVisibility(View.GONE);
            btnResult2.setText("ب");
            btnResult6.setText("بـ");
            btnResult8.setText("بـ");


            txtLevelOne.setText(" = آب");
            txtLevelTwo.setText(" = بابا");

            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.water)
                    .into(imgLevelOne);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.father)
                    .into(imgLevelTwo);


        } else if (myId == 2) {
            txtMainWord.setText("بـ ب");

            option1.setText("ا");
            option2.setText("ب");
            option3.setText("بـ");
            option4.setText("آ");
            option5.setText("ا");
            option6.setText("بـ");

            lnr3.setVisibility(View.GONE);
            lnr4.setVisibility(View.GONE);
            lnr5.setVisibility(View.GONE);
            lnr10.setVisibility(View.GONE);

            txtLevelOne.setText(" = آب");
            txtLevelTwo.setText(" = بابا");

            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.water)
                    .into(imgLevelOne);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.father)
                    .into(imgLevelTwo);

        } else if (myId == 3) {
            txtMainWord.setText("اَ    َ ");

            option1.setText("بـ");
            option2.setText("اَ ");
            option3.setText("بـ");
            option4.setText(" َ  ");
            option5.setText("بـ");

            btnResult3.setText("ر");
            btnResult9.setText("ر");


            lnr4.setVisibility(View.GONE);
            lnr5.setVisibility(View.GONE);
            lnr10.setVisibility(View.GONE);

            txtLevelOne.setText(" = اَبر");
            txtLevelTwo.setText(" = بَبر");


            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.sky)
                    .into(imgLevelOne);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.tiger)
                    .into(imgLevelTwo);

        } else if (myId == 4) {
            txtMainWord.setText("د");

            option1.setText("د");
            option2.setText("ب");
            option3.setText("بـ");
            option4.setText("ا");
            option5.setText("د");
            option6.setText("اَ");
            option7.setText(" َ  ");


            lnr4.setVisibility(View.GONE);
            lnr5.setVisibility(View.GONE);
            lnr10.setVisibility(View.GONE);

            txtLevelOne.setText(" = باد");
            txtLevelTwo.setText(" = اَدَب");


            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.wind)
                    .into(imgLevelOne);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.leader)
                    .into(imgLevelTwo);

        } else if (myId == 5) {
            txtMainWord.setText("مـ م");

            option1.setText("ا");
            option2.setText("م");
            option3.setText("د");
            option4.setText("ا");
            option5.setText("بـ");
            option6.setText("آ");
            option7.setText(" َ  ");
            option8.setText("مـ");
            option9.setText("د");


            lnr5.setVisibility(View.GONE);

            txtLevelOne.setText(" = آمَد");
            txtLevelTwo.setText(" = بادام");


            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.come)
                    .into(imgLevelOne);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.almond)
                    .into(imgLevelTwo);

        } else if (myId == 6) {
            txtMainWord.setText("سـ س");

            option1.setText("ا");
            option2.setText("س");
            option3.setText("د");
            option4.setText("سـ");
            option5.setText("بـ");
            option6.setText(" َ  ");
            option7.setText(" َ  ");
            option8.setText("د");


            lnr9.setVisibility(View.GONE);
            lnr10.setVisibility(View.GONE);

            txtLevelOne.setText(" = سَبَد");
            txtLevelTwo.setText(" = داس");


            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.basket)
                    .into(imgLevelOne);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.farming_and_gardening)
                    .into(imgLevelTwo);

        } else if (myId == 7) {
            txtMainWord.setText("او  و");

            option1.setText("س");
            option2.setText("بـ");
            option3.setText("او");
            option4.setText("و");


            lnr5.setVisibility(View.GONE);
            lnr4.setVisibility(View.GONE);
            lnr3.setVisibility(View.GONE);
            lnr2.setVisibility(View.GONE);
            lnr9.setVisibility(View.GONE);
            lnr10.setVisibility(View.GONE);


            txtLevelOne.setText(" = او");
            txtLevelTwo.setText(" = بوس");


            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.finger)
                    .into(imgLevelOne);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.kiss)
                    .into(imgLevelTwo);
        } else if (myId == 8) {
            txtMainWord.setText("تـ ت");

            option1.setText("ب");
            option2.setText("ا");
            option3.setText("ت");
            option4.setText("تـ");
            option5.setText("و");
            option6.setText("تـ");


            lnr4.setVisibility(View.GONE);
            lnr5.setVisibility(View.GONE);
            lnr9.setVisibility(View.GONE);
            lnr10.setVisibility(View.GONE);


            txtLevelOne.setText(" = توت");
            txtLevelTwo.setText(" = تاب");


            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.berry)
                    .into(imgLevelOne);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.playground)
                    .into(imgLevelTwo);
        } else if (myId == 9) {
            txtMainWord.setText("ر");

            option1.setText(" َ  ");
            option2.setText("ا");
            option3.setText("ر");
            option4.setText("مـ");
            option5.setText("بـ");
            option6.setText("تـ");
            option7.setText(" َ  ");
            option8.setText("د");
            option9.setText("ر");
            option10.setText(" َ  ");

            txtLevelOne.setText(" = تَبَر");
            txtLevelTwo.setText(" = مادَر");

            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.ax)
                    .into(imgLevelOne);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.mother)
                    .into(imgLevelTwo);
        } else if (myId == 10) {
            txtMainWord.setText("نـ ن");

            option1.setText("ر");
            option2.setText("و");
            option3.setText("نـ");
            option4.setText("تـ");
            option5.setText(" َ  ");
            option6.setText("ا");
            option7.setText("ن");
            option8.setText(" نـ ");

            txtLevelOne.setText(" = نان");
            txtLevelTwo.setText(" = تَنور");

            lnr4.setVisibility(View.GONE);
            lnr5.setVisibility(View.GONE);

            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.bread)
                    .into(imgLevelOne);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.tanoor)
                    .into(imgLevelTwo);
        } else if (myId == 11) {
            txtMainWord.setText("ایـ یـ ی ای");
            txtMainWord.setTextSize(15);

            option1.setText("ایـ");
            option2.setText("ا");
            option3.setText("نـ");
            option4.setText("یـ");
            option5.setText("مـ");
            option6.setText("ا");
            option7.setText("ن");
            option8.setText(" ر ");

            txtLevelOne.setText(" = ایران");
            txtLevelTwo.setText(" = مینا");

            lnr5.setVisibility(View.GONE);
            lnr10.setVisibility(View.GONE);

            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.iran)
                    .into(imgLevelOne);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.girl)
                    .into(imgLevelTwo);
        } else if (myId == 12) {
            txtMainWord.setText("ز");

            option1.setText("بـ");
            option2.setText("ز");
            option3.setText("سـ");
            option4.setText("ز");
            option5.setText("ر");
            option6.setText("د");


            txtLevelOne.setText(" = زرد");
            txtLevelTwo.setText(" = سبز");


            lnr4.setVisibility(View.GONE);
            lnr5.setVisibility(View.GONE);
            lnr9.setVisibility(View.GONE);
            lnr10.setVisibility(View.GONE);

            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.yellow_color)
                    .into(imgLevelOne);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.green_color)
                    .into(imgLevelTwo);
        } else if (myId == 13) {
            txtMainWord.setText("اِ ِ ـه ه ");
            txtMainWord.setTextSize(20);

            option1.setText("مـ");
            option2.setText(" اِ ");
            option3.setText("سـ");
            option4.setText("ا");
            option5.setText("نـ");
            option6.setText("د");
            option7.setText("د");
            option8.setText("ا");
            option9.setText(" ِ  ");
            option10.setText("ن");

            txtLevelOne.setText(" = اِنسان");
            txtLevelTwo.setText(" = مِداد");

            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.human)
                    .into(imgLevelOne);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.pencil)
                    .into(imgLevelTwo);
        } else if (myId == 14) {
            txtMainWord.setText("شـ ش");

            option1.setText("آ");
            option2.setText("ر");
            option3.setText("یـ");
            option4.setText("شـ");
            option5.setText("ش");

            lnr4.setVisibility(View.GONE);
            lnr5.setVisibility(View.GONE);
            lnr8.setVisibility(View.GONE);
            lnr9.setVisibility(View.GONE);
            lnr10.setVisibility(View.GONE);

            txtLevelOne.setText(" = شیر");
            txtLevelTwo.setText(" = آش");

            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.milk)
                    .into(imgLevelOne);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.soup)
                    .into(imgLevelTwo);
        } else if (myId == 15) {
            txtMainWord.setText("یـ ی");

            option1.setText("ا");
            option2.setText("یـ");
            option3.setText("ی");
            option4.setText("ر");
            option5.setText("د");
            option6.setText("ا");
            option7.setText("َ ");


            lnr9.setVisibility(View.GONE);
            lnr10.setVisibility(View.GONE);
            btnResult6.setText("چـ");

            txtLevelOne.setText(" = دَریا");
            txtLevelTwo.setText(" = چای");

            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.sea)
                    .into(imgLevelOne);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.tea)
                    .into(imgLevelTwo);
        } else if (myId == 16) {
            txtMainWord.setText("اُ  ُ ");

            option1.setText("یـ");
            option2.setText("سـ");
            option3.setText("د");
            option4.setText("اُ");
            option5.setText(" ُ  ");
            option6.setText("س");
            option7.setText("مـ");


            lnr5.setVisibility(View.GONE);
            lnr9.setVisibility(View.GONE);
            lnr10.setVisibility(View.GONE);

            txtLevelOne.setText(" = اُمید");
            txtLevelTwo.setText(" = سُس");

            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.human)
                    .into(imgLevelOne);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.sos)
                    .into(imgLevelTwo);
        } else if (myId == 17) {
            txtMainWord.setText("کـ ک");

            option1.setText(" َ  ");
            option2.setText("و");
            option3.setText("اُ");
            option4.setText(" َ  ");
            option5.setText("ر");
            option6.setText("کـ");
            option7.setText("د");
            option8.setText("د");
            option9.setText("نـ");
            option10.setText("ک");

            txtLevelOne.setText(" = کَندو");
            txtLevelTwo.setText(" = اُردَک");

            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.kando)
                    .into(imgLevelOne);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.duckling)
                    .into(imgLevelTwo);
        } else if (myId == 18) {
            txtMainWord.setText("و");

            option1.setText("ا");
            option2.setText("ر");
            option3.setText("و");
            option4.setText("و");
            option5.setText("َ  ");
            option6.setText("د");
            option7.setText("ا");
            option8.setText("ن");


            lnr9.setVisibility(View.GONE);
            lnr10.setVisibility(View.GONE);

            txtLevelOne.setText(" = داوَر");
            txtLevelTwo.setText(" = وان");

            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.davar)
                    .into(imgLevelOne);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.baby_bath_tub)
                    .into(imgLevelTwo);
        } else if (myId == 19) {
            txtMainWord.setText("پـ پ");

            option1.setText("پ");
            option2.setText("و");
            option3.setText("ا");
            option4.setText("تـ");
            option5.setText("پـ");

            lnr3.setVisibility(View.GONE);
            lnr4.setVisibility(View.GONE);
            lnr5.setVisibility(View.GONE);
            lnr9.setVisibility(View.GONE);
            lnr10.setVisibility(View.GONE);

            txtLevelOne.setText(" = پا");
            txtLevelTwo.setText(" = توپ");

            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.leg)
                    .into(imgLevelOne);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.ball)
                    .into(imgLevelTwo);
        } else if (myId == 20) {
            txtMainWord.setText("گـ گ");

            option1.setText("ل");
            option2.setText("گـ");
            option3.setText("ر");
            option4.setText("گـ");
            option6.setText("جـ");
            option7.setText(" ُ  ");
            option8.setText("گ");
            option9.setText(" َ  ");
            option5.setText("نـ");


            lnr10.setVisibility(View.GONE);

            txtLevelOne.setText(" = جنگَل");
            txtLevelTwo.setText(" = گُرگ");

            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.janghal)
                    .into(imgLevelOne);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.wolf)
                    .into(imgLevelTwo);
        } else if (myId == 21) {
            txtMainWord.setText("فـ ف");

            option1.setText("فـ");
            option2.setText("ف");
            option3.setText("ش");
            option4.setText("کـ");
            option5.setText("کـ");
            option6.setText("یـ");
            option7.setText(" َ  ");

            lnr5.setVisibility(View.GONE);
            lnr9.setVisibility(View.GONE);
            lnr10.setVisibility(View.GONE);

            txtLevelOne.setText(" = کَفش");
            txtLevelTwo.setText(" = کیف");

            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.sneaker)
                    .into(imgLevelOne);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.bag)
                    .into(imgLevelTwo);
        } else if (myId == 22) {
            txtMainWord.setText("خـ خ");

            option1.setText("ـه");
            option2.setText(" َ  ");
            option3.setText("لـ");
            option4.setText("مـ");
            option5.setText("خ");
            option6.setText("شـ");
            option7.setText("خـ");
            option8.setText("ا");
            option9.setText(" َ  ");

            lnr5.setVisibility(View.GONE);

            txtLevelOne.setText(" = شاخه");
            txtLevelTwo.setText(" = مَلَخ");

            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.shakhe)
                    .into(imgLevelOne);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.insect)
                    .into(imgLevelTwo);
        } else if (myId == 23) {
            txtMainWord.setText("قـ ق");

            option1.setText("شـ");
            option2.setText("ق");
            option3.setText("  ُ  ");
            option4.setText("ی");
            option5.setText("قـ");
            option6.setText("و");
            option7.setText("قـ");
            option8.setText("ر");
            option9.setText("ا");

            lnr10.setVisibility(View.GONE);

            txtLevelOne.setText(" = قاشُق");
            txtLevelTwo.setText(" = قوری");

            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.ghashogh)
                    .into(imgLevelOne);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.gori)
                    .into(imgLevelTwo);
        } else if (myId == 67) {
            txtMainWord.setText("لـ ل");

            option1.setText("نـ");
            option2.setText("لـ");
            option3.setText(" ُ  ");
            option4.setText("ل");
            option5.setText("ـه");
            option6.setText("گـ");
            option7.setText("ا");


            lnr5.setVisibility(View.GONE);
            lnr9.setVisibility(View.GONE);
            lnr10.setVisibility(View.GONE);

            txtLevelOne.setText(" = لـانه");
            txtLevelTwo.setText(" = گُل");

            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.lane)
                    .into(imgLevelOne);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.flower)
                    .into(imgLevelTwo);
        } else if (myId == 68) {
            txtMainWord.setText("جـ ج");

            option1.setText("ج");
            option2.setText("جـ");
            option3.setText("ا");
            option4.setText("جـ");
            option5.setText("کـ");
            option6.setText("و");
            option7.setText("ـه");


            lnr5.setVisibility(View.GONE);
            lnr9.setVisibility(View.GONE);
            lnr10.setVisibility(View.GONE);

            txtLevelOne.setText(" = جوجه");
            txtLevelTwo.setText(" = کاج");

            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.chick)
                    .into(imgLevelOne);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.woodland)
                    .into(imgLevelTwo);
        } else if (myId == 69) {
            txtMainWord.setText("و-> ُ");

            option1.setText("و");
            option2.setText("نـ");
            option3.setText("د");
            option4.setText("ک");
            option5.setText("و");

            lnr4.setVisibility(View.GONE);
            lnr5.setVisibility(View.GONE);
            lnr8.setVisibility(View.GONE);
            lnr9.setVisibility(View.GONE);
            lnr10.setVisibility(View.GONE);

            txtLevelOne.setText(" = نوک");
            txtLevelTwo.setText(" = دو");

            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.nok)
                    .into(imgLevelOne);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.do_2)
                    .into(imgLevelTwo);
        } else if (myId == 70) {
            txtMainWord.setText("هـ ـهـ ـه ه");
            txtMainWord.setTextSize(15);

            option1.setText("و");
            option2.setText("مـ");
            option3.setText("آ");
            option4.setText("ـهـ");
            option5.setText("تـ");
            option6.setText("هـ");
            option7.setText("ب");
            option8.setText("ا");

            lnr4.setVisibility(View.GONE);
            lnr5.setVisibility(View.GONE);


            txtLevelOne.setText(" = آهو");
            txtLevelTwo.setText(" = مهتاب");

            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.gazelle)
                    .into(imgLevelOne);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.moonlight)
                    .into(imgLevelTwo);
        } else if (myId == 71) {
            txtMainWord.setText("چـ چ");
            option1.setText("ُ ");
            option2.setText("ر");
            option3.setText("چـ");
            option4.setText("د");
            option5.setText("ا");
            option6.setText("قـ");
            option7.setText("ر");
            option8.setText("ا");
            option9.setText("چ");

            lnr10.setVisibility(View.GONE);

            txtLevelOne.setText(" = چادُر");
            txtLevelTwo.setText(" = قارچ");

            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.chador)
                    .into(imgLevelOne);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.mushroom)
                    .into(imgLevelTwo);
        } else if (myId == 72) {
            txtMainWord.setText("ژ");

            option1.setText("لـ");
            option2.setText("ـه");
            option3.setText("لـ");
            option4.setText("ـه");
            option5.setText("ژ");
            option6.setText("ژ");
            option7.setText(" ِ ");
            option8.setText("ا");


            lnr5.setVisibility(View.GONE);
            lnr10.setVisibility(View.GONE);

            txtLevelOne.setText(" = ژاله");
            txtLevelTwo.setText(" = ژِله");

            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.girl)
                    .into(imgLevelOne);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.jelly)
                    .into(imgLevelTwo);
        } else if (myId == 73) {
            txtMainWord.setText("خوا");

            option1.setText("ر");
            option2.setText(" َ ");
            option3.setText("خوا");
            option4.setText("هـ");
            option5.setText("خوا");
            option6.setText("ب");


            lnr5.setVisibility(View.GONE);
            lnr8.setVisibility(View.GONE);
            lnr9.setVisibility(View.GONE);
            lnr10.setVisibility(View.GONE);

            txtLevelOne.setText(" = خواهَر");
            txtLevelTwo.setText(" = خواب");

            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.khahar)
                    .into(imgLevelOne);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.khob)
                    .into(imgLevelTwo);
        } else if (myId == 74) {
            txtMainWord.setText(" ّ  ");

            option1.setText(" ّ  ");
            option2.setText("ـه");
            option3.setText("ه");
            option4.setText(" َ  ");
            option5.setText(" ّ  ");
            option6.setText("ر");
            option8.setText("چـ");
            option9.setText("اَ");
            option7.setText("بـ");
            lnr5.setVisibility(View.GONE);


            txtLevelOne.setText(" = اَرّه");
            txtLevelTwo.setText(" = بَچّه");

            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.arre)
                    .into(imgLevelOne);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.bache)
                    .into(imgLevelTwo);
        } else if (myId == 75) {
            txtMainWord.setText("صـ ص");

            option1.setText(" َ  ");
            option2.setText(" ُ  ");
            option3.setText("ف");
            option4.setText("صـ");
            option5.setText("ر");
            option6.setText(" َ  ");
            option7.setText("قـ");
            option8.setText("د");
            option9.setText("ص");

            lnr10.setVisibility(View.GONE);

            txtLevelOne.setText(" = صَدَف");
            txtLevelTwo.setText(" = قُرص");

            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.seashell)
                    .into(imgLevelOne);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.gors)
                    .into(imgLevelTwo);
        } else if (myId == 76) {
            txtMainWord.setText("ذ");

            option1.setText("ذ");
            option2.setText(" ّ  ");
            option3.setText("ذ");
            option4.setText(" َ  ");
            option5.setText(" َ  ");
            option6.setText("ذ");
            option7.setText("یـ");
            option8.setText("ر");
            option9.setText("لـ");
            option10.setText("ت");

            txtLevelOne.setText(" = ذرَّت");
            txtLevelTwo.setText(" = لَذیذ");

            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.corn)
                    .into(imgLevelOne);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.laziz)
                    .into(imgLevelTwo);
        } else if (myId == 77) {
            txtMainWord.setText("عـ ـعـ ـع ع");
            txtMainWord.setTextSize(15);

            option1.setText("س");
            option2.setText(" َ  ");
            option3.setText("عـ");
            option4.setText("سـ");
            option5.setText("ـعـ");
            option6.setText("و");
            option7.setText("یـ");
            option8.setText("د");
            option9.setText(" َ  ");
            option10.setText("ر");

            txtLevelOne.setText(" = عَروس");
            txtLevelTwo.setText(" = سَعید");

            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.arous)
                    .into(imgLevelOne);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.human)
                    .into(imgLevelTwo);
        } else if (myId == 78) {
            txtMainWord.setText("ثـ ث");

            option1.setText("ثـ");
            option2.setText(" ّ ");
            option3.setText("لـ");
            option4.setText("ث");
            option5.setText("لـ");
            option6.setText("ثـ");
            option7.setText("مـ");
            option8.setText("ـه");
            option9.setText("َ  ");

            lnr5.setVisibility(View.GONE);

            txtLevelOne.setText(" = لَثه");
            txtLevelTwo.setText(" = مثلّث");

            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.dental)
                    .into(imgLevelOne);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.mosalas)
                    .into(imgLevelTwo);
        } else if (myId == 79) {
            txtMainWord.setText("حـ ح");

            option1.setText("ـه");
            option2.setText("ح");
            option3.setText("ا");
            option4.setText("تـ");
            option5.setText("حـ");
            option6.setText("سـ");
            option7.setText("لـ");
            option8.setText("مـ");
            option9.setText("و");

            lnr5.setVisibility(View.GONE);

            txtLevelOne.setText(" = حوله");
            txtLevelTwo.setText(" = تمساح");

            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.hole)
                    .into(imgLevelOne);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.wild_life)
                    .into(imgLevelTwo);
        } else if (myId == 80) {
            txtMainWord.setText("ضـ ض");

            option1.setText("و");
            option2.setText("ر");
            option3.setText("ا");
            option4.setText("ضـ");
            option5.setText("حـ");
            option6.setText(" ِ- ");
            option7.setText("ض");


            lnr5.setVisibility(View.GONE);
            lnr9.setVisibility(View.GONE);
            lnr10.setVisibility(View.GONE);

            txtLevelOne.setText(" = رِضا");
            txtLevelTwo.setText(" = حوض");

            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.human)
                    .into(imgLevelOne);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.pool)
                    .into(imgLevelTwo);
        } else if (myId == 81) {
            txtMainWord.setText("ط");

            option1.setText("ل");
            option2.setText("بـ");
            option3.setText(" َ  ");
            option4.setText("و");
            option5.setText("ط");
            option6.setText("ط");
            option7.setText("ی");
            option8.setText("ط");

            lnr5.setVisibility(View.GONE);
            lnr10.setVisibility(View.GONE);

            txtLevelOne.setText(" = طوطی");
            txtLevelTwo.setText(" = طَبل");

            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.parrot)
                    .into(imgLevelOne);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.tabl)
                    .into(imgLevelTwo);
        } else if (myId == 82) {
            txtMainWord.setText("غـ ـغـ ـغ غ");
            txtMainWord.setTextSize(15);


            option1.setText("جـ");
            option2.setText("ـغـ");
            option3.setText(" ُ  ");
            option4.setText("غـ");
            option5.setText("ز");
            option6.setText("د");
            option7.setText("ا");

            lnr4.setVisibility(View.GONE);
            lnr5.setVisibility(View.GONE);
            lnr10.setVisibility(View.GONE);

            txtLevelOne.setText(" = غاز");
            txtLevelTwo.setText(" = جُغد");

            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.goose)
                    .into(imgLevelOne);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.owl)
                    .into(imgLevelTwo);
        } else if (myId == 83) {
            txtMainWord.setText("ظ");

            option1.setText("ف");
            option2.setText("ظ");
            option3.setText("ر");
            option4.setText("ظ");
            option5.setText(" َ  ");
            option6.setText(" ُ  ");
            option7.setText("ـهـ");
            option8.setText("ر");


            lnr5.setVisibility(View.GONE);
            lnr10.setVisibility(View.GONE);

            txtLevelOne.setText(" = ظَرف");
            txtLevelTwo.setText(" = ظُهر");

            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.lunch_box)
                    .into(imgLevelOne);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.zohr)
                    .into(imgLevelTwo);
        }


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

    public void findView() {
        imgHelp = findViewById(R.id.imgHelp);
        btnGoNextActivity = findViewById(R.id.btn_go_next_activity);
        Animation animation = new AlphaAnimation(1, 0); // بین 1 و 0 یعنی بصورت کاملا پیدا و کاملا ناپیدا
        animation.setDuration(500); // مدت زمان انجام یک بار فرآیند
        animation.setInterpolator(new LinearInterpolator()); // جلوگیری از تغییرات اتوماتیک انیمیشن
        animation.setRepeatCount(Animation.INFINITE); // انجام دادن انیمیشن به اندازه بینهایت
        animation.setRepeatMode(Animation.REVERSE); // برعکس انجام دادن انیمیشن وقتی یکبار انجام شد
        btnGoNextActivity.setAnimation(animation);

        goLeft = findViewById(R.id.go_left);
        goRight = findViewById(R.id.go_right);
        audioLevelOne = findViewById(R.id.audio_level_1);
        audioLevelTwo = findViewById(R.id.audio_level_2);
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
        imgHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(ActivityBuildWord.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.custom_dialog);
                TextView txt = (TextView) dialog.findViewById(R.id.textView);
                txt.setText("گلم اینجا میتونی با طریقه املا نوشتن آشنا بشی.ابتدا به تلفظ کلمه گوش کن بعد حروف مناسب همون کلمه رو بکش و در جای خودش قرار بده");
                Button dismissButton = (Button) dialog.findViewById(R.id.button);
                dismissButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.show();

            }
        });
        btnGoNextActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (myId == 82) {
                    Intent intent = new Intent(ActivityBuildWord.this, ActivityBuildWordSix.class);
                    startActivity(intent);
                } else if (myId == 77) {
                    Intent intent = new Intent(ActivityBuildWord.this, ActivityBuildWordFive.class);
                    startActivity(intent);
                } else if (myId == 70) {
                    Intent intent = new Intent(ActivityBuildWord.this, ActivityBuildWordFour.class);
                    startActivity(intent);
                } else if (myId == 13) {
                    Intent intent = new Intent(ActivityBuildWord.this, ActivityBuildWordThree.class);
                    startActivity(intent);
                } else if (myId == 11) {
                    Intent intent = new Intent(ActivityBuildWord.this, ActivityBuildWordTwo.class);
                    startActivity(intent);
                }

            }
        });

        sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
        sharedPreferences.getBoolean("buy_is_ok", false);
        boolean isBuy = sharedPreferences.getBoolean("buy_is_ok", false);

        goLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer = MediaPlayer.create(ActivityBuildWord.this, R.raw.click);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });


                sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("intValue", 0);
                editor.apply();

               /* if (myId == 23) {
                    myId = myId + 43;
                }
                if (myId == 68) {
                    myId = myId + 2;
                } else if (myId == 72) {
                    myId = myId + 3;
                } else if (myId == 83) {
                    myId = 83;
                } else {
                    myId = myId + 1;
                }*/

                if (myId==9) {
                    if (isBuy == false) {
                        Intent intent = new Intent(ActivityBuildWord.this, ActivityPurchase.class);
                        startActivity(intent);
                    }else if (isBuy==true){
                        if (myId == 23) {
                            myId = myId + 43;
                        } if (myId == 68) {
                            myId = myId + 2;
                        } else if (myId == 72) {
                            myId = myId + 3;
                        } else if (myId == 83) {
                            myId = 83;
                        } else {

                            myId = myId + 1;
                        }
                    }
                }else if (myId==1|myId==2|myId==3|myId==4|myId==5|myId==6|myId==7|myId==8){
                    myId = myId + 1;
                }else if (isBuy==true){
                    if (myId == 23) {
                        myId = myId + 43;
                    } if (myId == 68) {
                        myId = myId + 2;
                    } else if (myId == 72) {
                        myId = myId + 3;
                    } else if (myId == 83) {
                        myId = 83;
                    } else {

                        myId = myId + 1;
                    }
                }

                setContentView(R.layout.activity_build_word);
                findView();
                onClickMethod();
                changeWordsInTable();
                settingTouchAndDragListenerForButtons();


            }
        });
        goRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer = MediaPlayer.create(ActivityBuildWord.this, R.raw.click);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("intValue", 0);
                editor.apply();

                if (myId == 67) {
                    myId = myId - 43;
                }
                if (myId == 70) {
                    myId = myId - 2;
                } else if (myId == 75) {
                    myId = myId - 3;
                } else if (myId == 1) {
                    myId = 1;
                } else {
                    myId = myId - 1;
                }
                setContentView(R.layout.activity_build_word);
                findView();
                onClickMethod();
                changeWordsInTable();
                settingTouchAndDragListenerForButtons();


            }
        });
        audioLevelOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (myId == 1) {
                    mediaVoice(R.raw.abb);
                }
                if (myId == 2) {
                    mediaVoice(R.raw.abb);
                }
                if (myId == 3) {
                    mediaVoice(R.raw.abr);
                }
                if (myId == 4) {
                    mediaVoice(R.raw.bad);
                }
                if (myId == 5) {
                    mediaVoice(R.raw.amad);
                }
                if (myId == 6) {
                    mediaVoice(R.raw.sabad);
                }
                if (myId == 7) {
                    mediaVoice(R.raw.ooa);
                }
                if (myId == 8) {
                    mediaVoice(R.raw.tot);
                }
                if (myId == 9) {
                    mediaVoice(R.raw.tabar);
                }
                if (myId == 10) {
                    mediaVoice(R.raw.nan);
                }
                if (myId == 11) {
                    mediaVoice(R.raw.iran);
                }
                if (myId == 12) {
                    mediaVoice(R.raw.zard);
                }
                if (myId == 13) {
                    mediaVoice(R.raw.ensan);
                }
                if (myId == 14) {
                    mediaVoice(R.raw.shir);
                }
                if (myId == 15) {
                    mediaVoice(R.raw.darya);
                }
                if (myId == 16) {
                    mediaVoice(R.raw.omid);
                }
                if (myId == 17) {
                    mediaVoice(R.raw.kando);
                }
                if (myId == 18) {
                    mediaVoice(R.raw.davar);
                }
                if (myId == 19) {
                    mediaVoice(R.raw.pa);
                }
                if (myId == 20) {
                    mediaVoice(R.raw.janghal);
                }
                if (myId == 21) {
                    mediaVoice(R.raw.kafsh);
                }
                if (myId == 22) {
                    mediaVoice(R.raw.shakhe);
                }
                if (myId == 23) {
                    mediaVoice(R.raw.ghashogh);
                }
                if (myId == 67) {
                    mediaVoice(R.raw.lane);
                }
                if (myId == 68) {
                    mediaVoice(R.raw.joje);
                }
                if (myId == 69) {
                    mediaVoice(R.raw.nok);
                }
                if (myId == 70) {
                    mediaVoice(R.raw.aho);
                }
                if (myId == 71) {
                    mediaVoice(R.raw.chador);
                }
                if (myId == 72) {
                    mediaVoice(R.raw.zhale);
                }
                if (myId == 73) {
                    mediaVoice(R.raw.khahar);
                }
                if (myId == 74) {
                    mediaVoice(R.raw.arre);
                }
                if (myId == 75) {
                    mediaVoice(R.raw.sadaf);
                }
                if (myId == 76) {
                    mediaVoice(R.raw.zorrat);
                }
                if (myId == 77) {
                    mediaVoice(R.raw.arous);
                }
                if (myId == 78) {
                    mediaVoice(R.raw.lase);
                }
                if (myId == 79) {
                    mediaVoice(R.raw.hole);
                }
                if (myId == 80) {
                    mediaVoice(R.raw.reza);
                }
                if (myId == 81) {
                    mediaVoice(R.raw.toti);
                }
                if (myId == 82) {
                    mediaVoice(R.raw.ghaz);
                }
                if (myId == 83) {
                    mediaVoice(R.raw.zarf);
                }

            }
        });
        audioLevelTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (myId == 1) {
                    mediaVoice(R.raw.baba);
                }
                if (myId == 2) {
                    mediaVoice(R.raw.baba);
                }
                if (myId == 3) {
                    mediaVoice(R.raw.babr);
                }
                if (myId == 4) {
                    mediaVoice(R.raw.adab);
                }
                if (myId == 5) {
                    mediaVoice(R.raw.badam);
                }
                if (myId == 6) {
                    mediaVoice(R.raw.das);
                }
                if (myId == 7) {
                    mediaVoice(R.raw.boss);
                }
                if (myId == 8) {
                    mediaVoice(R.raw.tab);
                }
                if (myId == 9) {
                    mediaVoice(R.raw.madar);
                }
                if (myId == 10) {
                    mediaVoice(R.raw.tanoor);
                }
                if (myId == 11) {
                    mediaVoice(R.raw.mina);
                }
                if (myId == 12) {
                    mediaVoice(R.raw.sabz);
                }
                if (myId == 13) {
                    mediaVoice(R.raw.medad);
                }
                if (myId == 14) {
                    mediaVoice(R.raw.ash);
                }
                if (myId == 15) {
                    mediaVoice(R.raw.chaii);
                }
                if (myId == 16) {
                    mediaVoice(R.raw.sos);
                }
                if (myId == 17) {
                    mediaVoice(R.raw.ordak);
                }
                if (myId == 18) {
                    mediaVoice(R.raw.van);
                }
                if (myId == 19) {
                    mediaVoice(R.raw.top);
                }
                if (myId == 20) {
                    mediaVoice(R.raw.ghorgh);
                }
                if (myId == 21) {
                    mediaVoice(R.raw.kif);
                }
                if (myId == 22) {
                    mediaVoice(R.raw.malakh);
                }
                if (myId == 23) {
                    mediaVoice(R.raw.ghori);
                }
                if (myId == 67) {
                    mediaVoice(R.raw.ghol);
                }
                if (myId == 68) {
                    mediaVoice(R.raw.kaj);
                }
                if (myId == 69) {
                    mediaVoice(R.raw.doo);
                }
                if (myId == 70) {
                    mediaVoice(R.raw.mahtab);
                }
                if (myId == 71) {
                    mediaVoice(R.raw.gharch);
                }
                if (myId == 72) {
                    mediaVoice(R.raw.zhele);
                }
                if (myId == 73) {
                    mediaVoice(R.raw.khab);
                }
                if (myId == 74) {
                    mediaVoice(R.raw.bachee);
                }
                if (myId == 75) {
                    mediaVoice(R.raw.ghors);
                }
                if (myId == 76) {
                    mediaVoice(R.raw.laziz);
                }
                if (myId == 77) {
                    mediaVoice(R.raw.saeed);
                }
                if (myId == 78) {
                    mediaVoice(R.raw.mosallas);
                }
                if (myId == 79) {
                    mediaVoice(R.raw.temsah);
                }
                if (myId == 80) {
                    mediaVoice(R.raw.hoz);
                }
                if (myId == 81) {
                    mediaVoice(R.raw.tabl);
                }
                if (myId == 82) {
                    mediaVoice(R.raw.joghd);
                }
                if (myId == 83) {
                    mediaVoice(R.raw.zohr);
                }

            }
        });
        btnReNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("intValue", 0);
                editor.apply();
                mediaVoice(R.raw.practic);
                setContentView(R.layout.activity_build_word);
                findView();
                onClickMethod();
                changeWordsInTable();
                settingTouchAndDragListenerForButtons();
            }
        });
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaVoice(R.raw.click);
                finish();
            }
        });
        imgHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaVoice(R.raw.click);
                Intent intent = new Intent(ActivityBuildWord.this, ActivityAllAlphabet.class);
                startActivity(intent);
            }
        });


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
        if (myId == 1) {
            if (view.getId() == R.id.option2 && v.getId() == R.id.lnr1) {
                oldAndNewParent((LinearLayout) v, view, btnResult1, lnr1);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 2) {
                    mediaVoice(R.raw.horaa);
                    showGif();
                }
            } else if (view.getId() == R.id.option1 | view.getId() == R.id.option3 && v.getId() == R.id.lnr7) {
                oldAndNewParent((LinearLayout) v, view, btnResult7, lnr7);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 2) {
                    mediaVoice(R.raw.horaa);
                    showGif();
                }


            } else if (view.getId() == R.id.option1 | view.getId() == R.id.option3 && v.getId() == R.id.lnr9) {
                oldAndNewParent((LinearLayout) v, view, btnResult9, lnr9);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 2) {
                    mediaVoice(R.raw.horaa);
                    showGif();
                }

            } else {
                mediaVoice(R.raw.wrong);
            }

        } else if (myId == 2) {
            if (view.getId() == R.id.option4 && v.getId() == R.id.lnr1) {
                oldAndNewParent((LinearLayout) v, view, btnResult1, lnr1);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 5) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }


            } else if (view.getId() == R.id.option2 | view.getId() == R.id.option5 && v.getId() == R.id.lnr2) {
                oldAndNewParent((LinearLayout) v, view, btnResult2, lnr2);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 5) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }


            } else if (view.getId() == R.id.option3 | view.getId() == R.id.option6 && v.getId() == R.id.lnr6) {
                oldAndNewParent((LinearLayout) v, view, btnResult6, lnr6);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 5) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }


            } else if (view.getId() == R.id.option1 | view.getId() == R.id.option5 && v.getId() == R.id.lnr7) {
                oldAndNewParent((LinearLayout) v, view, btnResult7, lnr7);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 5) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }


            } else if (view.getId() == R.id.option3 | view.getId() == R.id.option6 && v.getId() == R.id.lnr8) {
                oldAndNewParent((LinearLayout) v, view, btnResult8, lnr8);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 5) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }


            } else if (view.getId() == R.id.option1 | view.getId() == R.id.option5 && v.getId() == R.id.lnr9) {
                oldAndNewParent((LinearLayout) v, view, btnResult9, lnr9);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 5) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }


            } else {
                mediaVoice(R.raw.wrong);
            }


        } else if (myId == 3) {
            if (view.getId() == R.id.option2 && v.getId() == R.id.lnr1) {
                oldAndNewParent((LinearLayout) v, view, btnResult1, lnr1);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 4) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }


            } else if (view.getId() == R.id.option1 | view.getId() == R.id.option3 | view.getId() == R.id.option5 && v.getId() == R.id.lnr2) {
                oldAndNewParent((LinearLayout) v, view, btnResult2, lnr2);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 4) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }


            } else if (view.getId() == R.id.option1 | view.getId() == R.id.option3 | view.getId() == R.id.option5 && v.getId() == R.id.lnr6) {
                oldAndNewParent((LinearLayout) v, view, btnResult6, lnr6);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 4) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }


            } else if (view.getId() == R.id.option1 | view.getId() == R.id.option3 | view.getId() == R.id.option5 && v.getId() == R.id.lnr8) {
                oldAndNewParent((LinearLayout) v, view, btnResult8, lnr8);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 4) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }


            } else if (view.getId() == R.id.option4 && v.getId() == R.id.lnr7) {
                oldAndNewParent((LinearLayout) v, view, btnResult7, lnr7);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 4) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }


            } else {
                mediaVoice(R.raw.wrong);
            }


        } else if (myId == 4) {
            if (view.getId() == R.id.option3 && v.getId() == R.id.lnr1) {
                oldAndNewParent((LinearLayout) v, view, btnResult1, lnr1);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 6) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }


            } else if (view.getId() == R.id.option4 && v.getId() == R.id.lnr2) {
                oldAndNewParent((LinearLayout) v, view, btnResult2, lnr2);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 6) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }


            } else if (view.getId() == R.id.option1 | view.getId() == R.id.option5 && v.getId() == R.id.lnr3) {
                oldAndNewParent((LinearLayout) v, view, btnResult3, lnr3);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 6) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }


            } else if (view.getId() == R.id.option6 && v.getId() == R.id.lnr6) {
                oldAndNewParent((LinearLayout) v, view, btnResult6, lnr6);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 6) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }


            } else if (view.getId() == R.id.option1 | view.getId() == R.id.option5 && v.getId() == R.id.lnr7) {
                oldAndNewParent((LinearLayout) v, view, btnResult7, lnr7);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 6) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }


            } else if (view.getId() == R.id.option7 && v.getId() == R.id.lnr8) {
                oldAndNewParent((LinearLayout) v, view, btnResult8, lnr8);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 6) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }


            } else if (view.getId() == R.id.option2 && v.getId() == R.id.lnr9) {
                oldAndNewParent((LinearLayout) v, view, btnResult9, lnr9);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 6) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }


            } else {
                mediaVoice(R.raw.wrong);
            }


        } else if (myId == 5) {
            if (view.getId() == R.id.option6 && v.getId() == R.id.lnr1) {
                oldAndNewParent((LinearLayout) v, view, btnResult1, lnr1);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }


            } else if (view.getId() == R.id.option8 && v.getId() == R.id.lnr2) {
                oldAndNewParent((LinearLayout) v, view, btnResult2, lnr2);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }


            } else if (view.getId() == R.id.option7 && v.getId() == R.id.lnr3) {
                oldAndNewParent((LinearLayout) v, view, btnResult3, lnr3);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }


            } else if (view.getId() == R.id.option3 | view.getId() == R.id.option9 && v.getId() == R.id.lnr4) {
                oldAndNewParent((LinearLayout) v, view, btnResult4, lnr4);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }


            } else if (view.getId() == R.id.option5 && v.getId() == R.id.lnr6) {
                oldAndNewParent((LinearLayout) v, view, btnResult6, lnr6);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }


            } else if (view.getId() == R.id.option1 | view.getId() == R.id.option4 && v.getId() == R.id.lnr7) {
                oldAndNewParent((LinearLayout) v, view, btnResult7, lnr7);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }


            } else if (view.getId() == R.id.option3 | view.getId() == R.id.option9 && v.getId() == R.id.lnr8) {
                oldAndNewParent((LinearLayout) v, view, btnResult8, lnr8);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }


            } else if (view.getId() == R.id.option1 | view.getId() == R.id.option4 && v.getId() == R.id.lnr9) {
                oldAndNewParent((LinearLayout) v, view, btnResult9, lnr9);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }


            } else if (view.getId() == R.id.option2 && v.getId() == R.id.lnr10) {
                oldAndNewParent((LinearLayout) v, view, btnResult10, lnr10);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }


            } else {
                mediaVoice(R.raw.wrong);
            }


        } else if (myId == 6) {
            if (view.getId() == R.id.option4 && v.getId() == R.id.lnr1) {
                oldAndNewParent((LinearLayout) v, view, btnResult1, lnr1);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 7) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }


            } else if (view.getId() == R.id.option6 | view.getId() == R.id.option7 && v.getId() == R.id.lnr2) {
                oldAndNewParent((LinearLayout) v, view, btnResult2, lnr2);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 7) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }


            } else if (view.getId() == R.id.option5 && v.getId() == R.id.lnr3) {
                oldAndNewParent((LinearLayout) v, view, btnResult3, lnr3);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 7) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }


            } else if (view.getId() == R.id.option6 | view.getId() == R.id.option7 && v.getId() == R.id.lnr4) {
                oldAndNewParent((LinearLayout) v, view, btnResult4, lnr4);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 7) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }


            } else if (view.getId() == R.id.option3 | view.getId() == R.id.option8 && v.getId() == R.id.lnr5) {
                oldAndNewParent((LinearLayout) v, view, btnResult5, lnr5);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 7) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }


            } else if (view.getId() == R.id.option3 | view.getId() == R.id.option8 && v.getId() == R.id.lnr6) {
                oldAndNewParent((LinearLayout) v, view, btnResult6, lnr6);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 7) {
                    mediaVoice(R.raw.horaa);
                    showGif();
                }


            } else if (view.getId() == R.id.option1 && v.getId() == R.id.lnr7) {
                oldAndNewParent((LinearLayout) v, view, btnResult7, lnr7);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 7) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }


            } else if (view.getId() == R.id.option2 && v.getId() == R.id.lnr8) {
                oldAndNewParent((LinearLayout) v, view, btnResult8, lnr8);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 7) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }


            } else {
                mediaVoice(R.raw.wrong);
            }


        } else if (myId == 7) {
            if (view.getId() == R.id.option3 && v.getId() == R.id.lnr1) {
                oldAndNewParent((LinearLayout) v, view, btnResult1, lnr1);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 3) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }


            } else if (view.getId() == R.id.option2 && v.getId() == R.id.lnr6) {
                oldAndNewParent((LinearLayout) v, view, btnResult6, lnr6);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 3) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }


            } else if (view.getId() == R.id.option4 && v.getId() == R.id.lnr7) {
                oldAndNewParent((LinearLayout) v, view, btnResult7, lnr7);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 3) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }


            } else if (view.getId() == R.id.option1 && v.getId() == R.id.lnr8) {
                oldAndNewParent((LinearLayout) v, view, btnResult8, lnr8);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 3) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }


            } else {
                mediaVoice(R.raw.wrong);
            }

        } else if (myId == 8) {
            if (view.getId() == R.id.option4 | view.getId() == R.id.option6 && v.getId() == R.id.lnr1) {
                oldAndNewParent((LinearLayout) v, view, btnResult1, lnr1);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 5) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }


            } else if (view.getId() == R.id.option5 && v.getId() == R.id.lnr2) {
                oldAndNewParent((LinearLayout) v, view, btnResult2, lnr2);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 5) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }


            } else if (view.getId() == R.id.option3 && v.getId() == R.id.lnr3) {
                oldAndNewParent((LinearLayout) v, view, btnResult3, lnr3);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 5) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }


            } else if (view.getId() == R.id.option4 | view.getId() == R.id.option6 && v.getId() == R.id.lnr6) {
                oldAndNewParent((LinearLayout) v, view, btnResult6, lnr6);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 5) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }


            } else if (view.getId() == R.id.option2 && v.getId() == R.id.lnr7) {
                oldAndNewParent((LinearLayout) v, view, btnResult7, lnr7);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 5) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }


            } else if (view.getId() == R.id.option1 && v.getId() == R.id.lnr8) {
                oldAndNewParent((LinearLayout) v, view, btnResult8, lnr8);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 5) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }


            } else {
                mediaVoice(R.raw.wrong);
            }

        } else if (myId == 9) {
            if (view.getId() == R.id.option6 && v.getId() == R.id.lnr1) {
                oldAndNewParent((LinearLayout) v, view, btnResult1, lnr1);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 9) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }


            } else if (view.getId() == R.id.option1 | view.getId() == R.id.option7 | view.getId() == R.id.option10 && v.getId() == R.id.lnr2) {
                oldAndNewParent((LinearLayout) v, view, btnResult2, lnr2);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 9) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }


            } else if (view.getId() == R.id.option5 && v.getId() == R.id.lnr3) {
                oldAndNewParent((LinearLayout) v, view, btnResult3, lnr3);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 9) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }


            } else if (view.getId() == R.id.option1 | view.getId() == R.id.option7 | view.getId() == R.id.option10 && v.getId() == R.id.lnr4) {
                oldAndNewParent((LinearLayout) v, view, btnResult4, lnr4);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 9) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }


            } else if (view.getId() == R.id.option9 | view.getId() == R.id.option3 && v.getId() == R.id.lnr5) {
                oldAndNewParent((LinearLayout) v, view, btnResult5, lnr5);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 9) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }


            } else if (view.getId() == R.id.option4 && v.getId() == R.id.lnr6) {
                oldAndNewParent((LinearLayout) v, view, btnResult6, lnr6);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 9) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }


            } else if (view.getId() == R.id.option2 && v.getId() == R.id.lnr7) {
                oldAndNewParent((LinearLayout) v, view, btnResult7, lnr7);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 9) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }


            } else if (view.getId() == R.id.option8 && v.getId() == R.id.lnr8) {
                oldAndNewParent((LinearLayout) v, view, btnResult8, lnr8);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 9) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }


            } else if (view.getId() == R.id.option1 | view.getId() == R.id.option7 | view.getId() == R.id.option10 && v.getId() == R.id.lnr9) {
                oldAndNewParent((LinearLayout) v, view, btnResult9, lnr9);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 9) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }


            } else if (view.getId() == R.id.option3 | view.getId() == R.id.option9 && v.getId() == R.id.lnr10) {
                oldAndNewParent((LinearLayout) v, view, btnResult10, lnr10);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 9) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }


            } else {
                mediaVoice(R.raw.wrong);
            }

        } else if (myId == 10) {
            if (view.getId() == R.id.option3 | view.getId() == R.id.option8 && v.getId() == R.id.lnr1) {
                oldAndNewParent((LinearLayout) v, view, btnResult1, lnr1);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 7) {
                    mediaVoice(R.raw.horaa);
                    showGif();
                }
            } else if (view.getId() == R.id.option6 && v.getId() == R.id.lnr2) {
                oldAndNewParent((LinearLayout) v, view, btnResult2, lnr2);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 7) {
                    mediaVoice(R.raw.horaa);
                    showGif();
                }
            } else if (view.getId() == R.id.option7 && v.getId() == R.id.lnr3) {
                oldAndNewParent((LinearLayout) v, view, btnResult3, lnr3);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 7) {
                    mediaVoice(R.raw.horaa);
                    showGif();
                }
            } else if (view.getId() == R.id.option4 && v.getId() == R.id.lnr6) {
                oldAndNewParent((LinearLayout) v, view, btnResult6, lnr6);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 7) {
                    mediaVoice(R.raw.horaa);
                    showGif();
                }
            } else if (view.getId() == R.id.option5 && v.getId() == R.id.lnr7) {
                oldAndNewParent((LinearLayout) v, view, btnResult7, lnr7);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 7) {
                    mediaVoice(R.raw.horaa);
                    showGif();
                }
            } else if (view.getId() == R.id.option3 | view.getId() == R.id.option8 && v.getId() == R.id.lnr8) {
                oldAndNewParent((LinearLayout) v, view, btnResult8, lnr8);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 7) {
                    mediaVoice(R.raw.horaa);
                    showGif();
                }
            } else if (view.getId() == R.id.option2 && v.getId() == R.id.lnr9) {
                oldAndNewParent((LinearLayout) v, view, btnResult9, lnr9);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 7) {
                    mediaVoice(R.raw.horaa);
                    showGif();
                }
            } else if (view.getId() == R.id.option1 && v.getId() == R.id.lnr10) {
                oldAndNewParent((LinearLayout) v, view, btnResult10, lnr10);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 7) {
                    mediaVoice(R.raw.horaa);
                    showGif();
                }
            } else {
                mediaVoice(R.raw.wrong);
            }

        } else if (myId == 11) {
            if (view.getId() == R.id.option1 && v.getId() == R.id.lnr1) {
                oldAndNewParent((LinearLayout) v, view, btnResult1, lnr1);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 7) {
                    mediaVoice(R.raw.horaa);
                    showGif();
                    btnGoNextActivity.setVisibility(View.VISIBLE);


                }
            } else if (view.getId() == R.id.option8 && v.getId() == R.id.lnr2) {
                oldAndNewParent((LinearLayout) v, view, btnResult2, lnr2);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 7) {
                    mediaVoice(R.raw.horaa);
                    showGif();
                    btnGoNextActivity.setVisibility(View.VISIBLE);
                }
            } else if (view.getId() == R.id.option2 | view.getId() == R.id.option6 && v.getId() == R.id.lnr3) {
                oldAndNewParent((LinearLayout) v, view, btnResult3, lnr3);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 7) {
                    mediaVoice(R.raw.horaa);
                    showGif();
                    btnGoNextActivity.setVisibility(View.VISIBLE);
                }
            } else if (view.getId() == R.id.option7 && v.getId() == R.id.lnr4) {
                oldAndNewParent((LinearLayout) v, view, btnResult4, lnr4);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 7) {
                    mediaVoice(R.raw.horaa);
                    showGif();
                    btnGoNextActivity.setVisibility(View.VISIBLE);
                }
            } else if (view.getId() == R.id.option5 && v.getId() == R.id.lnr6) {
                oldAndNewParent((LinearLayout) v, view, btnResult6, lnr6);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 7) {
                    mediaVoice(R.raw.horaa);
                    showGif();
                    btnGoNextActivity.setVisibility(View.VISIBLE);
                }
            } else if (view.getId() == R.id.option4 && v.getId() == R.id.lnr7) {
                oldAndNewParent((LinearLayout) v, view, btnResult7, lnr7);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 7) {
                    mediaVoice(R.raw.horaa);
                    showGif();
                    btnGoNextActivity.setVisibility(View.VISIBLE);
                }
            } else if (view.getId() == R.id.option3 && v.getId() == R.id.lnr8) {
                oldAndNewParent((LinearLayout) v, view, btnResult8, lnr8);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 7) {
                    mediaVoice(R.raw.horaa);
                    showGif();
                    btnGoNextActivity.setVisibility(View.VISIBLE);
                }
            } else if (view.getId() == R.id.option2 | view.getId() == R.id.option6 && v.getId() == R.id.lnr9) {
                oldAndNewParent((LinearLayout) v, view, btnResult9, lnr9);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 7) {
                    mediaVoice(R.raw.horaa);
                    showGif();
                    btnGoNextActivity.setVisibility(View.VISIBLE);
                }
            } else {
                mediaVoice(R.raw.wrong);
            }

        } else if (myId == 12) {
            if (view.getId() == R.id.option2 | view.getId() == R.id.option4 && v.getId() == R.id.lnr1) {
                oldAndNewParent((LinearLayout) v, view, btnResult1, lnr1);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 5) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option5 && v.getId() == R.id.lnr2) {
                oldAndNewParent((LinearLayout) v, view, btnResult2, lnr2);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 5) {
                    mediaVoice(R.raw.horaa);
                    showGif();
                }
            } else if (view.getId() == R.id.option6 && v.getId() == R.id.lnr3) {
                oldAndNewParent((LinearLayout) v, view, btnResult3, lnr3);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 5) {
                    mediaVoice(R.raw.horaa);
                    showGif();
                }
            } else if (view.getId() == R.id.option3 && v.getId() == R.id.lnr6) {
                oldAndNewParent((LinearLayout) v, view, btnResult6, lnr6);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 5) {
                    mediaVoice(R.raw.horaa);
                    showGif();
                }
            } else if (view.getId() == R.id.option1 && v.getId() == R.id.lnr7) {
                oldAndNewParent((LinearLayout) v, view, btnResult7, lnr7);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 5) {
                    mediaVoice(R.raw.horaa);
                    showGif();
                }
            } else if (view.getId() == R.id.option2 | view.getId() == R.id.option4 && v.getId() == R.id.lnr8) {
                oldAndNewParent((LinearLayout) v, view, btnResult8, lnr8);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 5) {
                    mediaVoice(R.raw.horaa);
                    showGif();
                }
            } else {
                mediaVoice(R.raw.wrong);
            }

        } else if (myId == 13) {
            if (view.getId() == R.id.option2 && v.getId() == R.id.lnr1) {
                oldAndNewParent((LinearLayout) v, view, btnResult1, lnr1);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 9) {
                    mediaVoice(R.raw.horaa);
                    showGif();
                    btnGoNextActivity.setVisibility(View.VISIBLE);


                }
            } else if (view.getId() == R.id.option5 && v.getId() == R.id.lnr2) {
                oldAndNewParent((LinearLayout) v, view, btnResult2, lnr2);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 9) {
                    mediaVoice(R.raw.horaa);
                    showGif();
                    btnGoNextActivity.setVisibility(View.VISIBLE);

                }
            } else if (view.getId() == R.id.option3 && v.getId() == R.id.lnr3) {
                oldAndNewParent((LinearLayout) v, view, btnResult3, lnr3);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 9) {
                    mediaVoice(R.raw.horaa);
                    showGif();
                    btnGoNextActivity.setVisibility(View.VISIBLE);

                }
            } else if (view.getId() == R.id.option4 | view.getId() == R.id.option8 && v.getId() == R.id.lnr4) {
                oldAndNewParent((LinearLayout) v, view, btnResult4, lnr4);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 9) {
                    mediaVoice(R.raw.horaa);
                    showGif();
                    btnGoNextActivity.setVisibility(View.VISIBLE);

                }
            } else if (view.getId() == R.id.option10 && v.getId() == R.id.lnr5) {
                oldAndNewParent((LinearLayout) v, view, btnResult5, lnr5);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 9) {
                    mediaVoice(R.raw.horaa);
                    showGif();
                    btnGoNextActivity.setVisibility(View.VISIBLE);

                }
            } else if (view.getId() == R.id.option1 && v.getId() == R.id.lnr6) {
                oldAndNewParent((LinearLayout) v, view, btnResult6, lnr6);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 9) {
                    mediaVoice(R.raw.horaa);
                    showGif();
                    btnGoNextActivity.setVisibility(View.VISIBLE);

                }
            } else if (view.getId() == R.id.option9 && v.getId() == R.id.lnr7) {
                oldAndNewParent((LinearLayout) v, view, btnResult7, lnr7);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 9) {
                    mediaVoice(R.raw.horaa);
                    showGif();
                    btnGoNextActivity.setVisibility(View.VISIBLE);

                }
            } else if (view.getId() == R.id.option6 | view.getId() == R.id.option7 && v.getId() == R.id.lnr8) {
                oldAndNewParent((LinearLayout) v, view, btnResult8, lnr8);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 9) {
                    mediaVoice(R.raw.horaa);
                    showGif();
                    btnGoNextActivity.setVisibility(View.VISIBLE);

                }
            } else if (view.getId() == R.id.option4 | view.getId() == R.id.option8 && v.getId() == R.id.lnr9) {
                oldAndNewParent((LinearLayout) v, view, btnResult9, lnr9);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 9) {
                    mediaVoice(R.raw.horaa);
                    showGif();
                    btnGoNextActivity.setVisibility(View.VISIBLE);

                }
            } else if (view.getId() == R.id.option6 | view.getId() == R.id.option7 && v.getId() == R.id.lnr10) {
                oldAndNewParent((LinearLayout) v, view, btnResult10, lnr10);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 9) {
                    mediaVoice(R.raw.horaa);
                    showGif();
                    btnGoNextActivity.setVisibility(View.VISIBLE);
                }
            } else {
                mediaVoice(R.raw.wrong);
            }

        } else if (myId == 14) {
            if (view.getId() == R.id.option4 && v.getId() == R.id.lnr1) {
                oldAndNewParent((LinearLayout) v, view, btnResult1, lnr1);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 4) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option3 && v.getId() == R.id.lnr2) {
                oldAndNewParent((LinearLayout) v, view, btnResult2, lnr2);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 4) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option2 && v.getId() == R.id.lnr3) {
                oldAndNewParent((LinearLayout) v, view, btnResult3, lnr3);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 4) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option1 && v.getId() == R.id.lnr6) {
                oldAndNewParent((LinearLayout) v, view, btnResult6, lnr6);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 4) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option5 && v.getId() == R.id.lnr7) {
                oldAndNewParent((LinearLayout) v, view, btnResult7, lnr7);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 4) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else {
                mediaVoice(R.raw.wrong);
            }

        } else if (myId == 15) {
            if (view.getId() == R.id.option5 && v.getId() == R.id.lnr1) {
                oldAndNewParent((LinearLayout) v, view, btnResult1, lnr1);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 6) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option7 && v.getId() == R.id.lnr2) {
                oldAndNewParent((LinearLayout) v, view, btnResult2, lnr2);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 6) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option4 && v.getId() == R.id.lnr3) {
                oldAndNewParent((LinearLayout) v, view, btnResult3, lnr3);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 6) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option2 && v.getId() == R.id.lnr4) {
                oldAndNewParent((LinearLayout) v, view, btnResult4, lnr4);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 6) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option1 | view.getId() == R.id.option6 && v.getId() == R.id.lnr5) {
                oldAndNewParent((LinearLayout) v, view, btnResult5, lnr5);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 6) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option1 | view.getId() == R.id.option6 && v.getId() == R.id.lnr7) {
                oldAndNewParent((LinearLayout) v, view, btnResult7, lnr7);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 6) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option3 && v.getId() == R.id.lnr8) {
                oldAndNewParent((LinearLayout) v, view, btnResult8, lnr8);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 6) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else {
                mediaVoice(R.raw.wrong);
            }

        } else if (myId == 16) {
            if (view.getId() == R.id.option4 && v.getId() == R.id.lnr1) {
                oldAndNewParent((LinearLayout) v, view, btnResult1, lnr1);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 6) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option7 && v.getId() == R.id.lnr2) {
                oldAndNewParent((LinearLayout) v, view, btnResult2, lnr2);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 6) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option1 && v.getId() == R.id.lnr3) {
                oldAndNewParent((LinearLayout) v, view, btnResult3, lnr3);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 6) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option3 && v.getId() == R.id.lnr4) {
                oldAndNewParent((LinearLayout) v, view, btnResult4, lnr4);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 6) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option2 && v.getId() == R.id.lnr6) {
                oldAndNewParent((LinearLayout) v, view, btnResult6, lnr6);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 6) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option5 && v.getId() == R.id.lnr7) {
                oldAndNewParent((LinearLayout) v, view, btnResult7, lnr7);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 6) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option6 && v.getId() == R.id.lnr8) {
                oldAndNewParent((LinearLayout) v, view, btnResult8, lnr8);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 6) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else {
                mediaVoice(R.raw.wrong);
            }

        } else if (myId == 17) {
            if (view.getId() == R.id.option6 && v.getId() == R.id.lnr1) {
                oldAndNewParent((LinearLayout) v, view, btnResult1, lnr1);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 9) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option1 | view.getId() == R.id.option4 && v.getId() == R.id.lnr2) {
                oldAndNewParent((LinearLayout) v, view, btnResult2, lnr2);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 9) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option9 && v.getId() == R.id.lnr3) {
                oldAndNewParent((LinearLayout) v, view, btnResult3, lnr3);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 9) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option7 | view.getId() == R.id.option8 && v.getId() == R.id.lnr4) {
                oldAndNewParent((LinearLayout) v, view, btnResult4, lnr4);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 9) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option2 && v.getId() == R.id.lnr5) {
                oldAndNewParent((LinearLayout) v, view, btnResult5, lnr5);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 9) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option3 && v.getId() == R.id.lnr6) {
                oldAndNewParent((LinearLayout) v, view, btnResult6, lnr6);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 9) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option5 && v.getId() == R.id.lnr7) {
                oldAndNewParent((LinearLayout) v, view, btnResult7, lnr7);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 9) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option7 | view.getId() == R.id.option8 && v.getId() == R.id.lnr8) {
                oldAndNewParent((LinearLayout) v, view, btnResult8, lnr8);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 9) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option1 | view.getId() == R.id.option4 && v.getId() == R.id.lnr9) {
                oldAndNewParent((LinearLayout) v, view, btnResult9, lnr9);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 9) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option10 && v.getId() == R.id.lnr10) {
                oldAndNewParent((LinearLayout) v, view, btnResult10, lnr10);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 9) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else {
                mediaVoice(R.raw.wrong);
            }

        } else if (myId == 18) {
            if (view.getId() == R.id.option6 && v.getId() == R.id.lnr1) {
                oldAndNewParent((LinearLayout) v, view, btnResult1, lnr1);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 7) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option1 | view.getId() == R.id.option7 && v.getId() == R.id.lnr2) {
                oldAndNewParent((LinearLayout) v, view, btnResult2, lnr2);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 7) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option3 | view.getId() == R.id.option4 && v.getId() == R.id.lnr3) {
                oldAndNewParent((LinearLayout) v, view, btnResult3, lnr3);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 7) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option5 && v.getId() == R.id.lnr4) {
                oldAndNewParent((LinearLayout) v, view, btnResult4, lnr4);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 7) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option2 && v.getId() == R.id.lnr5) {
                oldAndNewParent((LinearLayout) v, view, btnResult5, lnr5);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 7) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option3 | view.getId() == R.id.option4 && v.getId() == R.id.lnr6) {
                oldAndNewParent((LinearLayout) v, view, btnResult6, lnr6);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 7) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option1 | view.getId() == R.id.option7 && v.getId() == R.id.lnr7) {
                oldAndNewParent((LinearLayout) v, view, btnResult7, lnr7);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 7) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option8 && v.getId() == R.id.lnr8) {
                oldAndNewParent((LinearLayout) v, view, btnResult8, lnr8);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 7) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else {
                mediaVoice(R.raw.wrong);
            }

        } else if (myId == 19) {
            if (view.getId() == R.id.option5 && v.getId() == R.id.lnr1) {
                oldAndNewParent((LinearLayout) v, view, btnResult1, lnr1);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 4) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option3 && v.getId() == R.id.lnr2) {
                oldAndNewParent((LinearLayout) v, view, btnResult2, lnr2);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 4) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option4 && v.getId() == R.id.lnr6) {
                oldAndNewParent((LinearLayout) v, view, btnResult6, lnr6);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 4) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option2 && v.getId() == R.id.lnr7) {
                oldAndNewParent((LinearLayout) v, view, btnResult7, lnr7);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 4) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option1 && v.getId() == R.id.lnr8) {
                oldAndNewParent((LinearLayout) v, view, btnResult8, lnr8);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 4) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else {
                mediaVoice(R.raw.wrong);
            }

        } else if (myId == 20) {
            if (view.getId() == R.id.option6 && v.getId() == R.id.lnr1) {
                oldAndNewParent((LinearLayout) v, view, btnResult1, lnr1);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option5 && v.getId() == R.id.lnr2) {
                oldAndNewParent((LinearLayout) v, view, btnResult2, lnr2);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option2 | view.getId() == R.id.option4 && v.getId() == R.id.lnr3) {
                oldAndNewParent((LinearLayout) v, view, btnResult3, lnr3);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option9 && v.getId() == R.id.lnr4) {
                oldAndNewParent((LinearLayout) v, view, btnResult4, lnr4);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option1 && v.getId() == R.id.lnr5) {
                oldAndNewParent((LinearLayout) v, view, btnResult5, lnr5);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option2 | view.getId() == R.id.option4 && v.getId() == R.id.lnr6) {
                oldAndNewParent((LinearLayout) v, view, btnResult6, lnr6);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option7 && v.getId() == R.id.lnr7) {
                oldAndNewParent((LinearLayout) v, view, btnResult7, lnr7);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option3 && v.getId() == R.id.lnr8) {
                oldAndNewParent((LinearLayout) v, view, btnResult8, lnr8);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option8 && v.getId() == R.id.lnr9) {
                oldAndNewParent((LinearLayout) v, view, btnResult9, lnr9);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else {
                mediaVoice(R.raw.wrong);
            }

        } else if (myId == 21) {
            if (view.getId() == R.id.option4 | view.getId() == R.id.option5 && v.getId() == R.id.lnr1) {
                oldAndNewParent((LinearLayout) v, view, btnResult1, lnr1);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 6) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option7 && v.getId() == R.id.lnr2) {
                oldAndNewParent((LinearLayout) v, view, btnResult2, lnr2);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 6) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option1 && v.getId() == R.id.lnr3) {
                oldAndNewParent((LinearLayout) v, view, btnResult3, lnr3);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 6) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option3 && v.getId() == R.id.lnr4) {
                oldAndNewParent((LinearLayout) v, view, btnResult4, lnr4);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 6) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option4 | view.getId() == R.id.option5 && v.getId() == R.id.lnr6) {
                oldAndNewParent((LinearLayout) v, view, btnResult6, lnr6);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 6) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option6 && v.getId() == R.id.lnr7) {
                oldAndNewParent((LinearLayout) v, view, btnResult7, lnr7);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 6) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option2 && v.getId() == R.id.lnr8) {
                oldAndNewParent((LinearLayout) v, view, btnResult8, lnr8);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 6) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else {
                mediaVoice(R.raw.wrong);
            }

        } else if (myId == 22) {
            if (view.getId() == R.id.option6 && v.getId() == R.id.lnr1) {
                oldAndNewParent((LinearLayout) v, view, btnResult1, lnr1);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option8 && v.getId() == R.id.lnr2) {
                oldAndNewParent((LinearLayout) v, view, btnResult2, lnr2);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option7 && v.getId() == R.id.lnr3) {
                oldAndNewParent((LinearLayout) v, view, btnResult3, lnr3);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option1 && v.getId() == R.id.lnr4) {
                oldAndNewParent((LinearLayout) v, view, btnResult4, lnr4);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option4 && v.getId() == R.id.lnr6) {
                oldAndNewParent((LinearLayout) v, view, btnResult6, lnr6);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option2 | view.getId() == R.id.option9 && v.getId() == R.id.lnr7) {
                oldAndNewParent((LinearLayout) v, view, btnResult7, lnr7);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option3 && v.getId() == R.id.lnr8) {
                oldAndNewParent((LinearLayout) v, view, btnResult8, lnr8);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option2 | view.getId() == R.id.option9 && v.getId() == R.id.lnr9) {
                oldAndNewParent((LinearLayout) v, view, btnResult9, lnr9);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option5 && v.getId() == R.id.lnr10) {
                oldAndNewParent((LinearLayout) v, view, btnResult10, lnr10);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else {
                mediaVoice(R.raw.wrong);
            }

        } else if (myId == 23) {
            if (view.getId() == R.id.option5 | view.getId() == R.id.option7 && v.getId() == R.id.lnr1) {
                oldAndNewParent((LinearLayout) v, view, btnResult1, lnr1);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option9 && v.getId() == R.id.lnr2) {
                oldAndNewParent((LinearLayout) v, view, btnResult2, lnr2);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option1 && v.getId() == R.id.lnr3) {
                oldAndNewParent((LinearLayout) v, view, btnResult3, lnr3);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option3 && v.getId() == R.id.lnr4) {
                oldAndNewParent((LinearLayout) v, view, btnResult4, lnr4);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option2 && v.getId() == R.id.lnr5) {
                oldAndNewParent((LinearLayout) v, view, btnResult5, lnr5);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option5 | view.getId() == R.id.option7 && v.getId() == R.id.lnr6) {
                oldAndNewParent((LinearLayout) v, view, btnResult6, lnr6);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option6 && v.getId() == R.id.lnr7) {
                oldAndNewParent((LinearLayout) v, view, btnResult7, lnr7);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option8 && v.getId() == R.id.lnr8) {
                oldAndNewParent((LinearLayout) v, view, btnResult8, lnr8);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option4 && v.getId() == R.id.lnr9) {
                oldAndNewParent((LinearLayout) v, view, btnResult9, lnr9);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else {
                mediaVoice(R.raw.wrong);
            }

        } else if (myId == 67) {
            if (view.getId() == R.id.option2 && v.getId() == R.id.lnr1) {
                oldAndNewParent((LinearLayout) v, view, btnResult1, lnr1);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 6) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option7 && v.getId() == R.id.lnr2) {
                oldAndNewParent((LinearLayout) v, view, btnResult2, lnr2);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 6) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option1 && v.getId() == R.id.lnr3) {
                oldAndNewParent((LinearLayout) v, view, btnResult3, lnr3);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 6) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option5 && v.getId() == R.id.lnr4) {
                oldAndNewParent((LinearLayout) v, view, btnResult4, lnr4);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 6) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option6 && v.getId() == R.id.lnr6) {
                oldAndNewParent((LinearLayout) v, view, btnResult6, lnr6);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 6) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option3 && v.getId() == R.id.lnr7) {
                oldAndNewParent((LinearLayout) v, view, btnResult7, lnr7);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 6) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option4 && v.getId() == R.id.lnr8) {
                oldAndNewParent((LinearLayout) v, view, btnResult8, lnr8);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 6) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else {
                mediaVoice(R.raw.wrong);
            }

        } else if (myId == 68) {
            if (view.getId() == R.id.option2 | view.getId() == R.id.option4 && v.getId() == R.id.lnr1) {
                oldAndNewParent((LinearLayout) v, view, btnResult1, lnr1);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 6) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option6 && v.getId() == R.id.lnr2) {
                oldAndNewParent((LinearLayout) v, view, btnResult2, lnr2);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 6) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option2 | view.getId() == R.id.option4 && v.getId() == R.id.lnr3) {
                oldAndNewParent((LinearLayout) v, view, btnResult3, lnr3);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 6) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option7 && v.getId() == R.id.lnr4) {
                oldAndNewParent((LinearLayout) v, view, btnResult4, lnr4);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 6) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option5 && v.getId() == R.id.lnr6) {
                oldAndNewParent((LinearLayout) v, view, btnResult6, lnr6);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 6) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option3 && v.getId() == R.id.lnr7) {
                oldAndNewParent((LinearLayout) v, view, btnResult7, lnr7);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 6) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option1 && v.getId() == R.id.lnr8) {
                oldAndNewParent((LinearLayout) v, view, btnResult8, lnr8);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 6) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else {
                mediaVoice(R.raw.wrong);
            }

        } else if (myId == 69) {
            if (view.getId() == R.id.option2 && v.getId() == R.id.lnr1) {
                oldAndNewParent((LinearLayout) v, view, btnResult1, lnr1);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 4) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option1 | view.getId() == R.id.option5 && v.getId() == R.id.lnr2) {
                oldAndNewParent((LinearLayout) v, view, btnResult2, lnr2);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 4) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option4 && v.getId() == R.id.lnr3) {
                oldAndNewParent((LinearLayout) v, view, btnResult3, lnr3);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 4) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option3 && v.getId() == R.id.lnr6) {
                oldAndNewParent((LinearLayout) v, view, btnResult6, lnr6);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 4) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option1 | view.getId() == R.id.option5 && v.getId() == R.id.lnr7) {
                oldAndNewParent((LinearLayout) v, view, btnResult7, lnr7);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 4) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else {
                mediaVoice(R.raw.wrong);
            }

        } else if (myId == 70) {
            if (view.getId() == R.id.option3 && v.getId() == R.id.lnr1) {
                oldAndNewParent((LinearLayout) v, view, btnResult1, lnr1);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 7) {
                    mediaVoice(R.raw.horaa);
                    showGif();
                    btnGoNextActivity.setVisibility(View.VISIBLE);


                }
            } else if (view.getId() == R.id.option6 && v.getId() == R.id.lnr2) {
                oldAndNewParent((LinearLayout) v, view, btnResult2, lnr2);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 7) {
                    mediaVoice(R.raw.horaa);
                    showGif();
                    btnGoNextActivity.setVisibility(View.VISIBLE);


                }
            } else if (view.getId() == R.id.option1 && v.getId() == R.id.lnr3) {
                oldAndNewParent((LinearLayout) v, view, btnResult3, lnr3);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 7) {
                    mediaVoice(R.raw.horaa);
                    showGif();
                    btnGoNextActivity.setVisibility(View.VISIBLE);


                }
            } else if (view.getId() == R.id.option2 && v.getId() == R.id.lnr6) {
                oldAndNewParent((LinearLayout) v, view, btnResult6, lnr6);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 7) {
                    mediaVoice(R.raw.horaa);
                    showGif();
                    btnGoNextActivity.setVisibility(View.VISIBLE);


                }
            } else if (view.getId() == R.id.option4 && v.getId() == R.id.lnr7) {
                oldAndNewParent((LinearLayout) v, view, btnResult7, lnr7);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 7) {
                    mediaVoice(R.raw.horaa);
                    showGif();
                    btnGoNextActivity.setVisibility(View.VISIBLE);


                }
            } else if (view.getId() == R.id.option5 && v.getId() == R.id.lnr8) {
                oldAndNewParent((LinearLayout) v, view, btnResult8, lnr8);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 7) {
                    mediaVoice(R.raw.horaa);
                    showGif();
                    btnGoNextActivity.setVisibility(View.VISIBLE);


                }
            } else if (view.getId() == R.id.option8 && v.getId() == R.id.lnr9) {
                oldAndNewParent((LinearLayout) v, view, btnResult9, lnr9);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 7) {
                    mediaVoice(R.raw.horaa);
                    showGif();
                    btnGoNextActivity.setVisibility(View.VISIBLE);


                }
            } else if (view.getId() == R.id.option7 && v.getId() == R.id.lnr10) {
                oldAndNewParent((LinearLayout) v, view, btnResult10, lnr10);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 7) {
                    mediaVoice(R.raw.horaa);
                    showGif();
                    btnGoNextActivity.setVisibility(View.VISIBLE);


                }
            } else {
                mediaVoice(R.raw.wrong);
            }

        } else if (myId == 71) {
            if (view.getId() == R.id.option3 && v.getId() == R.id.lnr1) {
                oldAndNewParent((LinearLayout) v, view, btnResult1, lnr1);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option5 | view.getId() == R.id.option8 && v.getId() == R.id.lnr2) {
                oldAndNewParent((LinearLayout) v, view, btnResult2, lnr2);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option4 && v.getId() == R.id.lnr3) {
                oldAndNewParent((LinearLayout) v, view, btnResult3, lnr3);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option1 && v.getId() == R.id.lnr4) {
                oldAndNewParent((LinearLayout) v, view, btnResult4, lnr4);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option2 | view.getId() == R.id.option7 && v.getId() == R.id.lnr5) {
                oldAndNewParent((LinearLayout) v, view, btnResult5, lnr5);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option6 && v.getId() == R.id.lnr6) {
                oldAndNewParent((LinearLayout) v, view, btnResult6, lnr6);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option5 | view.getId() == R.id.option8 && v.getId() == R.id.lnr7) {
                oldAndNewParent((LinearLayout) v, view, btnResult7, lnr7);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option2 | view.getId() == R.id.option7 && v.getId() == R.id.lnr8) {
                oldAndNewParent((LinearLayout) v, view, btnResult8, lnr8);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option9 && v.getId() == R.id.lnr9) {
                oldAndNewParent((LinearLayout) v, view, btnResult9, lnr9);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else {
                mediaVoice(R.raw.wrong);
            }

        } else if (myId == 72) {
            if (view.getId() == R.id.option5 | view.getId() == R.id.option6 && v.getId() == R.id.lnr1) {
                oldAndNewParent((LinearLayout) v, view, btnResult1, lnr1);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 7) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option8 && v.getId() == R.id.lnr2) {
                oldAndNewParent((LinearLayout) v, view, btnResult2, lnr2);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 7) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option1 | view.getId() == R.id.option3 && v.getId() == R.id.lnr3) {
                oldAndNewParent((LinearLayout) v, view, btnResult3, lnr3);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 7) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option2 | view.getId() == R.id.option4 && v.getId() == R.id.lnr4) {
                oldAndNewParent((LinearLayout) v, view, btnResult4, lnr4);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 7) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option5 | view.getId() == R.id.option6 && v.getId() == R.id.lnr6) {
                oldAndNewParent((LinearLayout) v, view, btnResult6, lnr6);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 7) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option7 && v.getId() == R.id.lnr7) {
                oldAndNewParent((LinearLayout) v, view, btnResult7, lnr7);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 7) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option1 | view.getId() == R.id.option3 && v.getId() == R.id.lnr8) {
                oldAndNewParent((LinearLayout) v, view, btnResult8, lnr8);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 7) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option2 | view.getId() == R.id.option4 && v.getId() == R.id.lnr9) {
                oldAndNewParent((LinearLayout) v, view, btnResult9, lnr9);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 7) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else {
                mediaVoice(R.raw.wrong);
            }

        } else if (myId == 73) {
            if (view.getId() == R.id.option3 | view.getId() == R.id.option5 && v.getId() == R.id.lnr1) {
                oldAndNewParent((LinearLayout) v, view, btnResult1, lnr1);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 5) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option4 && v.getId() == R.id.lnr2) {
                oldAndNewParent((LinearLayout) v, view, btnResult2, lnr2);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 5) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option2 && v.getId() == R.id.lnr3) {
                oldAndNewParent((LinearLayout) v, view, btnResult3, lnr3);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 5) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option1 && v.getId() == R.id.lnr4) {
                oldAndNewParent((LinearLayout) v, view, btnResult4, lnr4);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 5) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option3 | view.getId() == R.id.option5 && v.getId() == R.id.lnr6) {
                oldAndNewParent((LinearLayout) v, view, btnResult6, lnr6);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 5) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option6 && v.getId() == R.id.lnr7) {
                oldAndNewParent((LinearLayout) v, view, btnResult7, lnr7);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 5) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else {
                mediaVoice(R.raw.wrong);
            }

        } else if (myId == 74) {
            if (view.getId() == R.id.option9 && v.getId() == R.id.lnr1) {
                oldAndNewParent((LinearLayout) v, view, btnResult1, lnr1);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option6 && v.getId() == R.id.lnr2) {
                oldAndNewParent((LinearLayout) v, view, btnResult2, lnr2);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option1 | view.getId() == R.id.option5 && v.getId() == R.id.lnr3) {
                oldAndNewParent((LinearLayout) v, view, btnResult3, lnr3);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option3 && v.getId() == R.id.lnr4) {
                oldAndNewParent((LinearLayout) v, view, btnResult4, lnr4);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option7 && v.getId() == R.id.lnr6) {
                oldAndNewParent((LinearLayout) v, view, btnResult6, lnr6);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option4 && v.getId() == R.id.lnr7) {
                oldAndNewParent((LinearLayout) v, view, btnResult7, lnr7);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option8 && v.getId() == R.id.lnr8) {
                oldAndNewParent((LinearLayout) v, view, btnResult8, lnr8);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option1 | view.getId() == R.id.option5 && v.getId() == R.id.lnr9) {
                oldAndNewParent((LinearLayout) v, view, btnResult9, lnr9);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option2 && v.getId() == R.id.lnr10) {
                oldAndNewParent((LinearLayout) v, view, btnResult10, lnr10);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else {
                mediaVoice(R.raw.wrong);
            }

        } else if (myId == 75) {
            if (view.getId() == R.id.option4 && v.getId() == R.id.lnr1) {
                oldAndNewParent((LinearLayout) v, view, btnResult1, lnr1);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option1 | view.getId() == R.id.option6 && v.getId() == R.id.lnr2) {
                oldAndNewParent((LinearLayout) v, view, btnResult2, lnr2);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option8 && v.getId() == R.id.lnr3) {
                oldAndNewParent((LinearLayout) v, view, btnResult3, lnr3);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option1 | view.getId() == R.id.option6 && v.getId() == R.id.lnr4) {
                oldAndNewParent((LinearLayout) v, view, btnResult4, lnr4);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option3 && v.getId() == R.id.lnr5) {
                oldAndNewParent((LinearLayout) v, view, btnResult5, lnr5);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option7 && v.getId() == R.id.lnr6) {
                oldAndNewParent((LinearLayout) v, view, btnResult6, lnr6);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option2 && v.getId() == R.id.lnr7) {
                oldAndNewParent((LinearLayout) v, view, btnResult7, lnr7);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option5 && v.getId() == R.id.lnr8) {
                oldAndNewParent((LinearLayout) v, view, btnResult8, lnr8);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option9 && v.getId() == R.id.lnr9) {
                oldAndNewParent((LinearLayout) v, view, btnResult9, lnr9);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else {
                mediaVoice(R.raw.wrong);
            }

        } else if (myId == 76) {
            if (view.getId() == R.id.option1 | view.getId() == R.id.option6 | view.getId() == R.id.option3 && v.getId() == R.id.lnr1) {
                oldAndNewParent((LinearLayout) v, view, btnResult1, lnr1);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 9) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option8 && v.getId() == R.id.lnr2) {
                oldAndNewParent((LinearLayout) v, view, btnResult2, lnr2);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 9) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option2 && v.getId() == R.id.lnr3) {
                oldAndNewParent((LinearLayout) v, view, btnResult3, lnr3);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 9) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option5 | view.getId() == R.id.option4 && v.getId() == R.id.lnr4) {
                oldAndNewParent((LinearLayout) v, view, btnResult4, lnr4);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 9) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option10 | view.getId() == R.id.option6 && v.getId() == R.id.lnr5) {
                oldAndNewParent((LinearLayout) v, view, btnResult5, lnr5);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 9) {
                    mediaVoice(R.raw.horaa);
                    showGif();
                }
            } else if (view.getId() == R.id.option9 && v.getId() == R.id.lnr6) {
                oldAndNewParent((LinearLayout) v, view, btnResult6, lnr6);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 9) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option4 | view.getId() == R.id.option5 && v.getId() == R.id.lnr7) {
                oldAndNewParent((LinearLayout) v, view, btnResult7, lnr7);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 9) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option1 | view.getId() == R.id.option3 | view.getId() == R.id.option6 && v.getId() == R.id.lnr8) {
                oldAndNewParent((LinearLayout) v, view, btnResult8, lnr8);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 9) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option7 && v.getId() == R.id.lnr9) {
                oldAndNewParent((LinearLayout) v, view, btnResult9, lnr9);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 9) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option1 | view.getId() == R.id.option3 | view.getId() == R.id.option6 && v.getId() == R.id.lnr10) {
                oldAndNewParent((LinearLayout) v, view, btnResult10, lnr10);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 9) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else {
                mediaVoice(R.raw.wrong);
            }

        } else if (myId == 77) {
            if (view.getId() == R.id.option3 && v.getId() == R.id.lnr1) {
                oldAndNewParent((LinearLayout) v, view, btnResult1, lnr1);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 9) {
                    mediaVoice(R.raw.horaa);
                    showGif();
                    btnGoNextActivity.setVisibility(View.VISIBLE);


                }
            } else if (view.getId() == R.id.option2 |view.getId() == R.id.option9 && v.getId() == R.id.lnr2) {
                oldAndNewParent((LinearLayout) v, view, btnResult2, lnr2);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 9) {
                    mediaVoice(R.raw.horaa);
                    showGif();
                    btnGoNextActivity.setVisibility(View.VISIBLE);


                }
            } else if (view.getId() == R.id.option10 && v.getId() == R.id.lnr3) {
                oldAndNewParent((LinearLayout) v, view, btnResult3, lnr3);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 9) {
                    mediaVoice(R.raw.horaa);
                    showGif();
                    btnGoNextActivity.setVisibility(View.VISIBLE);


                }
            } else if (view.getId() == R.id.option6 && v.getId() == R.id.lnr4) {
                oldAndNewParent((LinearLayout) v, view, btnResult4, lnr4);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 9) {
                    mediaVoice(R.raw.horaa);
                    showGif();
                    btnGoNextActivity.setVisibility(View.VISIBLE);


                }
            } else if (view.getId() == R.id.option1 && v.getId() == R.id.lnr5) {
                oldAndNewParent((LinearLayout) v, view, btnResult5, lnr5);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 9) {
                    mediaVoice(R.raw.horaa);
                    showGif();
                    btnGoNextActivity.setVisibility(View.VISIBLE);


                }
            } else if (view.getId() == R.id.option4 && v.getId() == R.id.lnr6) {
                oldAndNewParent((LinearLayout) v, view, btnResult6, lnr6);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 9) {
                    mediaVoice(R.raw.horaa);
                    showGif();
                    btnGoNextActivity.setVisibility(View.VISIBLE);


                }
            } else if (view.getId() == R.id.option2 | view.getId() == R.id.option9 && v.getId() == R.id.lnr7) {
                oldAndNewParent((LinearLayout) v, view, btnResult7, lnr7);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 9) {
                    mediaVoice(R.raw.horaa);
                    showGif();
                    btnGoNextActivity.setVisibility(View.VISIBLE);


                }
            } else if (view.getId() == R.id.option5 && v.getId() == R.id.lnr8) {
                oldAndNewParent((LinearLayout) v, view, btnResult8, lnr8);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 9) {
                    mediaVoice(R.raw.horaa);
                    showGif();
                    btnGoNextActivity.setVisibility(View.VISIBLE);


                }
            } else if (view.getId() == R.id.option7 && v.getId() == R.id.lnr9) {
                oldAndNewParent((LinearLayout) v, view, btnResult9, lnr9);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 9) {
                    mediaVoice(R.raw.horaa);
                    showGif();
                    btnGoNextActivity.setVisibility(View.VISIBLE);


                }
            } else if (view.getId() == R.id.option8 && v.getId() == R.id.lnr10) {
                oldAndNewParent((LinearLayout) v, view, btnResult10, lnr10);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 9) {
                    mediaVoice(R.raw.horaa);
                    showGif();
                    btnGoNextActivity.setVisibility(View.VISIBLE);


                }
            } else {
                mediaVoice(R.raw.wrong);
            }

        } else if (myId == 78) {
            if (view.getId() == R.id.option3 | view.getId() == R.id.option5 && v.getId() == R.id.lnr1) {
                oldAndNewParent((LinearLayout) v, view, btnResult1, lnr1);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option1 | view.getId() == R.id.option6 && v.getId() == R.id.lnr3) {
                oldAndNewParent((LinearLayout) v, view, btnResult3, lnr3);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option9 && v.getId() == R.id.lnr2) {
                oldAndNewParent((LinearLayout) v, view, btnResult2, lnr2);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option8 && v.getId() == R.id.lnr4) {
                oldAndNewParent((LinearLayout) v, view, btnResult4, lnr4);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option7 && v.getId() == R.id.lnr6) {
                oldAndNewParent((LinearLayout) v, view, btnResult6, lnr6);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option1 | view.getId() == R.id.option6 && v.getId() == R.id.lnr7) {
                oldAndNewParent((LinearLayout) v, view, btnResult7, lnr7);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option3 | view.getId() == R.id.option5 && v.getId() == R.id.lnr8) {
                oldAndNewParent((LinearLayout) v, view, btnResult8, lnr8);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option2 && v.getId() == R.id.lnr9) {
                oldAndNewParent((LinearLayout) v, view, btnResult9, lnr9);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option4 && v.getId() == R.id.lnr10) {
                oldAndNewParent((LinearLayout) v, view, btnResult10, lnr10);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else {
                mediaVoice(R.raw.wrong);
            }

        } else if (myId == 79) {
            if (view.getId() == R.id.option5 && v.getId() == R.id.lnr1) {
                oldAndNewParent((LinearLayout) v, view, btnResult1, lnr1);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option9 && v.getId() == R.id.lnr2) {
                oldAndNewParent((LinearLayout) v, view, btnResult2, lnr2);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option7 && v.getId() == R.id.lnr3) {
                oldAndNewParent((LinearLayout) v, view, btnResult3, lnr3);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option1 && v.getId() == R.id.lnr4) {
                oldAndNewParent((LinearLayout) v, view, btnResult4, lnr4);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option4 && v.getId() == R.id.lnr6) {
                oldAndNewParent((LinearLayout) v, view, btnResult6, lnr6);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option8 && v.getId() == R.id.lnr7) {
                oldAndNewParent((LinearLayout) v, view, btnResult7, lnr7);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option6 && v.getId() == R.id.lnr8) {
                oldAndNewParent((LinearLayout) v, view, btnResult8, lnr8);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option3 && v.getId() == R.id.lnr9) {
                oldAndNewParent((LinearLayout) v, view, btnResult9, lnr9);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option2 && v.getId() == R.id.lnr10) {
                oldAndNewParent((LinearLayout) v, view, btnResult10, lnr10);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else {
                mediaVoice(R.raw.wrong);
            }

        } else if (myId == 80) {
            if (view.getId() == R.id.option2 && v.getId() == R.id.lnr1) {
                oldAndNewParent((LinearLayout) v, view, btnResult1, lnr1);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 6) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option6 && v.getId() == R.id.lnr2) {
                oldAndNewParent((LinearLayout) v, view, btnResult2, lnr2);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 6) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option4 && v.getId() == R.id.lnr3) {
                oldAndNewParent((LinearLayout) v, view, btnResult3, lnr3);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 6) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option3 && v.getId() == R.id.lnr4) {
                oldAndNewParent((LinearLayout) v, view, btnResult4, lnr4);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 6) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option5 && v.getId() == R.id.lnr6) {
                oldAndNewParent((LinearLayout) v, view, btnResult6, lnr6);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 6) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option1 && v.getId() == R.id.lnr7) {
                oldAndNewParent((LinearLayout) v, view, btnResult7, lnr7);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 6) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option7 && v.getId() == R.id.lnr8) {
                oldAndNewParent((LinearLayout) v, view, btnResult8, lnr8);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 6) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else {
                mediaVoice(R.raw.wrong);
            }

        } else if (myId == 81) {
            if (view.getId() == R.id.option5 | view.getId() == R.id.option6 | view.getId() == R.id.option8 && v.getId() == R.id.lnr1) {
                oldAndNewParent((LinearLayout) v, view, btnResult1, lnr1);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 7) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option4 && v.getId() == R.id.lnr2) {
                oldAndNewParent((LinearLayout) v, view, btnResult2, lnr2);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 7) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option5 | view.getId() == R.id.option6 | view.getId() == R.id.option8 && v.getId() == R.id.lnr3) {
                oldAndNewParent((LinearLayout) v, view, btnResult3, lnr3);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 7) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option7 && v.getId() == R.id.lnr4) {
                oldAndNewParent((LinearLayout) v, view, btnResult4, lnr4);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 7) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option5 | view.getId() == R.id.option6 | view.getId() == R.id.option8 && v.getId() == R.id.lnr6) {
                oldAndNewParent((LinearLayout) v, view, btnResult6, lnr6);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 7) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option3 && v.getId() == R.id.lnr7) {
                oldAndNewParent((LinearLayout) v, view, btnResult7, lnr7);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 7) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option2 && v.getId() == R.id.lnr8) {
                oldAndNewParent((LinearLayout) v, view, btnResult8, lnr8);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 7) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option1 && v.getId() == R.id.lnr9) {
                oldAndNewParent((LinearLayout) v, view, btnResult9, lnr9);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 7) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else {
                mediaVoice(R.raw.wrong);
            }

        } else if (myId == 82) {
            if (view.getId() == R.id.option4 && v.getId() == R.id.lnr1) {
                oldAndNewParent((LinearLayout) v, view, btnResult1, lnr1);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 6) {
                    mediaVoice(R.raw.horaa);
                    showGif();
                    btnGoNextActivity.setVisibility(View.VISIBLE);


                }
            } else if (view.getId() == R.id.option7 && v.getId() == R.id.lnr2) {
                oldAndNewParent((LinearLayout) v, view, btnResult2, lnr2);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 6) {
                    mediaVoice(R.raw.horaa);
                    showGif();
                    btnGoNextActivity.setVisibility(View.VISIBLE);


                }
            } else if (view.getId() == R.id.option5 && v.getId() == R.id.lnr3) {
                oldAndNewParent((LinearLayout) v, view, btnResult3, lnr3);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 6) {
                    mediaVoice(R.raw.horaa);
                    showGif();
                    btnGoNextActivity.setVisibility(View.VISIBLE);


                }
            } else if (view.getId() == R.id.option1 && v.getId() == R.id.lnr6) {
                oldAndNewParent((LinearLayout) v, view, btnResult6, lnr6);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 6) {
                    mediaVoice(R.raw.horaa);
                    showGif();
                    btnGoNextActivity.setVisibility(View.VISIBLE);


                }
            } else if (view.getId() == R.id.option3 && v.getId() == R.id.lnr7) {
                oldAndNewParent((LinearLayout) v, view, btnResult7, lnr7);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 6) {
                    mediaVoice(R.raw.horaa);
                    showGif();
                    btnGoNextActivity.setVisibility(View.VISIBLE);


                }
            } else if (view.getId() == R.id.option2 && v.getId() == R.id.lnr8) {
                oldAndNewParent((LinearLayout) v, view, btnResult8, lnr8);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 6) {
                    mediaVoice(R.raw.horaa);
                    showGif();
                    btnGoNextActivity.setVisibility(View.VISIBLE);


                }
            } else if (view.getId() == R.id.option6 && v.getId() == R.id.lnr9) {
                oldAndNewParent((LinearLayout) v, view, btnResult9, lnr9);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 6) {
                    mediaVoice(R.raw.horaa);
                    showGif();
                    btnGoNextActivity.setVisibility(View.VISIBLE);


                }
            } else {
                mediaVoice(R.raw.wrong);
            }

        } else if (myId == 83) {
            if (view.getId() == R.id.option2 | view.getId() == R.id.option4 && v.getId() == R.id.lnr1) {
                oldAndNewParent((LinearLayout) v, view, btnResult1, lnr1);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 7) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option5 && v.getId() == R.id.lnr2) {
                oldAndNewParent((LinearLayout) v, view, btnResult2, lnr2);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 7) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option3 | view.getId() == R.id.option8 && v.getId() == R.id.lnr3) {
                oldAndNewParent((LinearLayout) v, view, btnResult3, lnr3);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 7) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option1 && v.getId() == R.id.lnr4) {
                oldAndNewParent((LinearLayout) v, view, btnResult4, lnr4);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 7) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option2 | view.getId() == R.id.option4 && v.getId() == R.id.lnr6) {
                oldAndNewParent((LinearLayout) v, view, btnResult6, lnr6);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 7) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option6 && v.getId() == R.id.lnr7) {
                oldAndNewParent((LinearLayout) v, view, btnResult7, lnr7);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 7) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option7 && v.getId() == R.id.lnr8) {
                oldAndNewParent((LinearLayout) v, view, btnResult8, lnr8);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 7) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else if (view.getId() == R.id.option3 | view.getId() == R.id.option8 && v.getId() == R.id.lnr9) {
                oldAndNewParent((LinearLayout) v, view, btnResult9, lnr9);
                mediaVoice(R.raw.ok);
                sharedPref();
                if (intValue == 7) {
                    mediaVoice(R.raw.horaa);
                    showGif();


                }
            } else {
                mediaVoice(R.raw.wrong);
            }

        }


    }


    private void showGif() {
        gifImageView.setVisibility(View.VISIBLE);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                gifImageView.setVisibility(View.GONE);


            }
        }, 5000);
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
        if (intValue == 5) {
            mediaVoice(R.raw.horaa);
            showGif();


        }
    }

    private void sharedPref() {
        intValue = sharedPreferences.getInt("intValue", 0);
        sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("intValue", intValue + 1);
        editor.apply();
    }

    private void mediaVoice(int p) {
        mediaPlayer = MediaPlayer.create(ActivityBuildWord.this, p);
        mediaPlayer.start();
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.release();
            }
        });
    }


}
