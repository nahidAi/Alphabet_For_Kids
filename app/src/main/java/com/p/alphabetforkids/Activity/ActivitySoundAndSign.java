package com.p.alphabetforkids.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.ClipData;
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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetView;
import com.p.alphabetforkids.R;

public class ActivitySoundAndSign extends AppCompatActivity {
    private Button btnSign, btnResult, btnOption, btnOption2, btnResult2,
            btnRenew, btnOption3, btnResult3, btnResult4, btnOption4,
            btnResult5, btnOption5, btnOption6, btnResult6;
    private LinearLayout lnrResult, lnrResult2, lnrResult3, lnrResult4, lnrResult5, lnrResult6;
    private ImageView imgBack, imgHome, imgGoRight, imgGoLeft,imgHelp;
    private int myId;
    private Handler handler;
    private View view;
    int myRow;
    int newId;
    MediaPlayer mediaPlayer;
    boolean isShowTapTargetView = false;
    SharedPreferences sharedPreferences;


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //   گرفتن ایدی
        Bundle bundle = getIntent().getExtras();
        myId = Integer.parseInt(bundle.getString("id"));
        myRow = Integer.parseInt(bundle.getString("row"));

        //---------------------------------------------------------------- ست کردن لایه مناسب هر ایدی

        settingLayoutForDifferentId();



        // فول اسکرین کردن صفحه
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        findView();
        setOnClick();
        changeWordsInTable();
        settingTouchAndDragListenerForButtons();
        sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
        boolean showHelp = sharedPreferences.getBoolean("TapTargetView_sound_sign", false);
        if (showHelp == false) {
            final Drawable drawable = ContextCompat.getDrawable(this, R.drawable.ic_help_black_24dp);
            TapTargetView.showFor(this,
                    TapTarget.forView(findViewById(R.id.imgHelp), "راهنمای تمرین", "دانشجوی کوچولوی من حرف مشخص شده در ردیف دوم را با صداهای ردیف اول ترکیب کن و جواب درست رو بکش و در جای مناسب رها کن")
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
            editor1.putBoolean("TapTargetView_sound_sign", isShowTapTargetView);
            editor1.apply();
        }


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

    @SuppressLint("ClickableViewAccessibility")
    private void settingTouchAndDragListenerForButtons() {

        btnOption.setOnTouchListener(touchListener);
        lnrResult.setOnDragListener(dragListener);

        if (myId == 3 | myId == 4 | myId == 5 | myId == 6) {
            lnrResult2.setOnDragListener(dragListener);
            btnOption2.setOnTouchListener(touchListener);
        } else if (myId == 7 | myId == 8 | myId == 9 | myId == 10) {
            lnrResult2.setOnDragListener(dragListener);
            btnOption2.setOnTouchListener(touchListener);
            lnrResult3.setOnDragListener(dragListener);
            btnOption3.setOnTouchListener(touchListener);
        } else if (myId == 11 | myId == 12) {
            lnrResult2.setOnDragListener(dragListener);
            btnOption2.setOnTouchListener(touchListener);
            lnrResult3.setOnDragListener(dragListener);
            btnOption3.setOnTouchListener(touchListener);
            lnrResult4.setOnDragListener(dragListener);
            btnOption4.setOnTouchListener(touchListener);
        } else if (myId == 13 | myId == 14 | myId == 15) {
            lnrResult2.setOnDragListener(dragListener);
            btnOption2.setOnTouchListener(touchListener);
            lnrResult3.setOnDragListener(dragListener);
            btnOption3.setOnTouchListener(touchListener);
            lnrResult4.setOnDragListener(dragListener);
            btnOption4.setOnTouchListener(touchListener);
            lnrResult5.setOnDragListener(dragListener);
            btnOption5.setOnTouchListener(touchListener);
        } else if (myId == 16 | myId == 17 | myId == 18 | myId == 19 | myId == 20 | myId == 21 | myId == 22 | myId == 23 | myId == 67 | myId == 68
                | myId == 69 | myId == 70 | myId == 71 | myId == 72 | myId == 73 |
                myId == 74 | myId == 75 | myId == 76 | myId == 77 | myId == 78 |
                myId == 79 | myId == 80 | myId == 81 | myId == 82 | myId == 83) {
            lnrResult2.setOnDragListener(dragListener);
            btnOption2.setOnTouchListener(touchListener);
            lnrResult3.setOnDragListener(dragListener);
            btnOption3.setOnTouchListener(touchListener);
            lnrResult4.setOnDragListener(dragListener);
            btnOption4.setOnTouchListener(touchListener);
            lnrResult5.setOnDragListener(dragListener);
            btnOption5.setOnTouchListener(touchListener);
            lnrResult6.setOnDragListener(dragListener);
            btnOption6.setOnTouchListener(touchListener);
        }
    }

    private void changeWordsInTable() {
        if (myId == 4) {
            btnSign.setText("د");
            btnOption.setText("دا");
            btnOption2.setText("دَ");
        } else if (myId == 5) {
            btnSign.setText("مـ م");
            btnOption.setText("ما");
            btnOption2.setText("مـَ");
        } else if (myId == 6) {
            btnSign.setText("سـ س ");
            btnOption.setText("سا");
            btnOption2.setText("سـَ");
        } else if (myId == 7) {
            btnSign.setText("سـ س ");
            btnOption.setText("سا");
            btnOption2.setText("سـَ");
            btnOption3.setText("سو");
        } else if (myId == 8) {
            btnSign.setText("تـ ت ");
            btnOption.setText("تا");
            btnOption2.setText("تـَ");
            btnOption3.setText("تو");
        } else if (myId == 9) {
            btnSign.setText("ر ");
            btnOption.setText("را");
            btnOption2.setText("رَ");
            btnOption3.setText("رو");
        } else if (myId == 10) {
            btnSign.setText("نـ ن ");
            btnOption.setText("نا");
            btnOption2.setText("نـَ");
            btnOption3.setText("نو");
        } else if (myId == 11) {
            btnSign.setText("نـ ن ");
            btnOption.setText("نا");
            btnOption2.setText("نـَ");
            btnOption3.setText("نو");
            btnOption4.setText("نیـ نی");
        } else if (myId == 12) {
            btnSign.setText("ز ");
            btnOption.setText("زا");
            btnOption2.setText("زَ");
            btnOption3.setText("زو");
            btnOption4.setText("زیـ  زی");
        } else if (myId == 13) {
            btnSign.setText("سـ س ");
            btnSign.setTextSize(20);
            btnOption.setText("سا");
            btnOption2.setText("سـَ");
            btnOption3.setText("سو");
            btnOption4.setText("سیـ سی");
            btnOption5.setText("سـِ سه");
        } else if (myId == 14) {
            btnSign.setText("شـ ش ");
            btnSign.setTextSize(20);
            btnOption.setText("شا");
            btnOption2.setText("شـَ");
            btnOption3.setText("شو");
            btnOption4.setText("شیـ شی");
            btnOption5.setText("شـِ شه");
        } else if (myId == 15) {
            btnSign.setText("یـ ی");
            btnOption.setText("یا");
            btnOption2.setText("یـَ");
            btnOption3.setText("یو");
            btnOption4.setText("ییـ یی");
            btnOption5.setText("یـِ یه");
        } else if (myId == 16) {
            btnSign.setText("بـ ب");
            btnOption.setText("با");
            btnOption2.setText("بـَ");
            btnOption3.setText("بو");
            btnOption4.setText("بیـ بی");
            btnOption5.setText("بـِ به");
            btnOption6.setText("بـُ");
        } else if (myId == 17) {
            btnSign.setText("کـ ک");
            btnOption.setText("کا");
            btnOption2.setText("کـَ");
            btnOption3.setText("کو");
            btnOption4.setText("کیـ کی");
            btnOption5.setText("کـِ که");
            btnOption6.setText("کـُ");
        } else if (myId == 18) {
            btnSign.setText("و");
            btnOption.setText("وا");
            btnOption2.setText("وَ");
            btnOption3.setText("وو");
            btnOption4.setText("ویـ وی");
            btnOption5.setText("وِ وه");
            btnOption6.setText("وُ");
        } else if (myId == 19) {
            btnSign.setText("پـ پ");
            btnOption.setText("پا");
            btnOption2.setText("پـَ");
            btnOption3.setText("پو");
            btnOption4.setText("پیـ پی");
            btnOption5.setText("پـِ په");
            btnOption6.setText("پـُ");
        } else if (myId == 20) {
            btnSign.setText("گـ گ");
            btnOption.setText("گا");
            btnOption2.setText("گـَ");
            btnOption3.setText("گو");
            btnOption4.setText("گیـ گی");
            btnOption5.setText("گـِ گه");
            btnOption6.setText("گـُ");
        } else if (myId == 21) {
            btnSign.setText("فـ ف");
            btnOption.setText("فا");
            btnOption2.setText("فـَ");
            btnOption3.setText("فو");
            btnOption4.setText("فیـ فی");
            btnOption5.setText("فـِ فه");
            btnOption6.setText("فـُ");
        } else if (myId == 22) {
            btnSign.setText("خـ خ");
            btnOption.setText("خا");
            btnOption2.setText("خـَ");
            btnOption3.setText("خو");
            btnOption4.setText("خیـ خی");
            btnOption5.setText("خـِ خه");
            btnOption6.setText("خـُ");
        } else if (myId == 23) {
            btnSign.setText("قـ ق");
            btnOption.setText("قا");
            btnOption2.setText("قـَ");
            btnOption3.setText("قو");
            btnOption4.setText("قیـ قی");
            btnOption5.setText("قـِ قه");
            btnOption6.setText("قـُ");
        } else if (myId == 67) {
            btnSign.setText("لـ ل");
            btnOption.setText("لـا");
            btnOption2.setText("لـَ");
            btnOption3.setText("لو");
            btnOption4.setText("لیـ لی");
            btnOption5.setText("لـِ له");
            btnOption6.setText("لـُ");
        } else if (myId == 68) {
            btnSign.setText("جـ ج");
            btnOption.setText("جا");
            btnOption2.setText("جـَ");
            btnOption3.setText("جو");
            btnOption4.setText("جیـ جی");
            btnOption5.setText("جـِ جه");
            btnOption6.setText("جـُ");
        } else if (myId == 69) {
            btnSign.setText("بـ ب");
            btnOption.setText("با");
            btnOption2.setText("بـَ");
            btnOption3.setText("بو");
            btnOption4.setText("بیـ بی");
            btnOption5.setText("بـِ به");
            btnOption6.setText("بـُ");
        } else if (myId == 70) {
            btnSign.setText("هـ ـهـ ـه ه");
            btnSign.setTextSize(17);
            btnOption.setText("ها");
            btnOption2.setText("هـَ");
            btnOption3.setText("هو");
            btnOption4.setText("هیـ هی");
            btnOption5.setText("هـِ هه");
            btnOption6.setText("هـُ");
        } else if (myId == 71) {
            btnSign.setText("چـ چ");
            btnOption.setText("چا");
            btnOption2.setText("چـَ");
            btnOption3.setText("چو");
            btnOption4.setText("چیـ چی");
            btnOption5.setText("چـِ چه");
            btnOption6.setText("چـُ");
        } else if (myId == 72) {
            btnSign.setText("ژ ");
            btnOption.setText("ژا");
            btnOption2.setText("ژَ");
            btnOption3.setText("ژو");
            btnOption4.setText("ژیـ ژی");
            btnOption5.setText("ژِ ژه");
            btnOption6.setText("ژُ");
        } else if (myId == 73) {
            btnSign.setText("بـ ب");
            btnOption.setText("با");
            btnOption2.setText("بـَ");
            btnOption3.setText("بو");
            btnOption4.setText("بیـ بی");
            btnOption5.setText("بـِ به");
            btnOption6.setText("بـُ");
        } else if (myId == 74) {
            btnSign.setText("بـ ب");
            btnOption.setText("با");
            btnOption2.setText("بـَ");
            btnOption3.setText("بو");
            btnOption4.setText("بیـ بی");
            btnOption5.setText("بـِ به");
            btnOption6.setText("بـُ");
        } else if (myId == 75) {
            btnSign.setText("صـ ص");
            btnOption.setText("صا");
            btnOption2.setText("صـَ");
            btnOption3.setText("صو");
            btnOption4.setText("صیـ صی");
            btnOption5.setText("صـِ صه");
            btnOption6.setText("صـُ");
        } else if (myId == 76) {
            btnSign.setText("ذ");
            btnOption.setText("ذا");
            btnOption2.setText("ذَ");
            btnOption3.setText("ذو");
            btnOption4.setText("ذیـ ذی");
            btnOption5.setText("ذِ ذه");
            btnOption6.setText("ذُ");
        } else if (myId == 77) {
            btnSign.setText("عـ ـعـ ـع ع");
            btnSign.setTextSize(17);
            btnOption.setText("عا");
            btnOption2.setText("عـَ");
            btnOption3.setText("عو");
            btnOption4.setText("عیـ عی");
            btnOption5.setText("عـِ عه");
            btnOption6.setText("عـُ");
        } else if (myId == 78) {
            btnSign.setText("ثـ ث");
            btnOption.setText("ثا");
            btnOption2.setText("ثـَ");
            btnOption3.setText("ثو");
            btnOption4.setText("ثیـ ثی");
            btnOption5.setText("ثـِ ثه");
            btnOption6.setText("ثـُ");
        } else if (myId == 79) {
            btnSign.setText("حـ ح");
            btnOption.setText("حا");
            btnOption2.setText("حـَ");
            btnOption3.setText("حو");
            btnOption4.setText("حیـ حی");
            btnOption5.setText("حـِ حه");
            btnOption6.setText("حـُ");
        } else if (myId == 80) {
            btnSign.setText("ضـ ض");
            btnOption.setText("ضا");
            btnOption2.setText("ضـَ");
            btnOption3.setText("ضو");
            btnOption4.setText("ضیـ ضی");
            btnOption5.setText("ضـِ ضه");
            btnOption6.setText("ضـُ");
        } else if (myId == 81) {
            btnSign.setText("ط");
            btnOption.setText("طا");
            btnOption2.setText("طَ");
            btnOption3.setText("طو");
            btnOption4.setText("طیـ طی");
            btnOption5.setText("طِ طه");
            btnOption6.setText("طُُ");
        } else if (myId == 82) {
            btnSign.setText("غـ ـغـ ـغ غ");
            btnSign.setTextSize(17);
            btnOption.setText("غا");
            btnOption2.setText("غـَ");
            btnOption3.setText("غو");
            btnOption4.setText("غیـ غی");
            btnOption5.setText("غـِ غه");
            btnOption6.setText("غـُ");
        } else if (myId == 83) {
            btnSign.setText("ظ");
            btnOption.setText("ظا");
            btnOption2.setText("ظَ");
            btnOption3.setText("ظو");
            btnOption4.setText("ظیـ ظی");
            btnOption5.setText("ظِ ظه");
            btnOption6.setText("ظُ");
        }
    }

    private void settingLayoutForDifferentId() {
        if (myId == 2) {
            setContentView(R.layout.activity_sound_and_sign);
        } else if (myId == 3 | myId == 4 | myId == 5 | myId == 6) {
            setContentView(R.layout.activity_sound_and_sign_2);
        } else if (myId == 7 | myId == 8 | myId == 9 | myId == 10) {
            setContentView(R.layout.activity_sound_and_sign_3);
        } else if (myId == 11 | myId == 12) {
            setContentView(R.layout.activity_sound_and_sign_4);
        } else if (myId == 13 | myId == 14 | myId == 15) {
            setContentView(R.layout.activity_sound_and_sign_5);

        } else if (myId == 16 | myId == 17 | myId == 18 | myId == 19 | myId == 20 | myId == 21 | myId == 22 | myId == 23 | myId == 67 | myId == 68
                | myId == 69 | myId == 70 | myId == 71 | myId == 72 | myId == 73 |
                myId == 74 | myId == 75 | myId == 76 | myId == 77 | myId == 78 |
                myId == 79 | myId == 80 | myId == 81 | myId == 82 | myId == 83) {
            setContentView(R.layout.activity_sound_and_sign_6);
        }


    }

    public void findView() {
        imgHelp = findViewById(R.id.imgHelp);
        imgGoLeft = findViewById(R.id.go_left);
        imgGoRight = findViewById(R.id.go_right);
        btnSign = findViewById(R.id.btn_sign);
        btnOption = findViewById(R.id.btn_option);
        btnResult = findViewById(R.id.btn_result);
        btnResult2 = findViewById(R.id.btn_result2);
        lnrResult = findViewById(R.id.lnr_result);
        lnrResult2 = findViewById(R.id.lnr_result2);
        lnrResult3 = findViewById(R.id.lnr_result3);
        lnrResult4 = findViewById(R.id.lnr_result4);
        lnrResult5 = findViewById(R.id.lnr_result5);
        imgBack = findViewById(R.id.imgBack);
        imgHome = findViewById(R.id.imgMyHome);
        btnOption2 = findViewById(R.id.btn_option2);
        btnRenew = findViewById(R.id.btnReNew);
        btnOption3 = findViewById(R.id.btn_option3);
        btnOption4 = findViewById(R.id.btn_option4);
        btnOption5 = findViewById(R.id.btn_option5);
        btnResult3 = findViewById(R.id.btn_result3);
        btnResult4 = findViewById(R.id.btn_result4);
        btnResult5 = findViewById(R.id.btn_result5);
        btnOption6 = findViewById(R.id.btn_option6);
        btnResult6 = findViewById(R.id.btn_result6);
        lnrResult6 = findViewById(R.id.lnr_result6);


    }

    public void setOnClick() {
        imgHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(ActivitySoundAndSign.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.custom_dialog);
                TextView txt = (TextView) dialog.findViewById(R.id.textView);
                txt.setText("دانشجوی کوچولوی من حرف مشخص شده در ردیف دوم را با صداهای ردیف اول ترکیب کن و جواب درست رو بکش و در جای مناسب رها کن");
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
        imgGoRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer = MediaPlayer.create(ActivitySoundAndSign.this, R.raw.click);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });


                if (myId == 67) {
                    myId = myId - 43;
                }
                if (myId == 70) {
                    myId = myId - 2;
                } else if (myId == 75) {
                    myId = myId - 3;
                }  else if (myId == 2) {
                    myId =2;
                }else {
                    myId = myId - 1;
                }

                if (myId == 2) {
                    setContentView(R.layout.activity_sound_and_sign);
                    settingFornewId();
                }
                if (myId == 3 | myId == 4 | myId == 5 | myId == 6) {
                    setContentView(R.layout.activity_sound_and_sign_2);
                    settingFornewId();
                } else if (myId == 7 | myId == 8 | myId == 9 | myId == 10) {
                    setContentView(R.layout.activity_sound_and_sign_3);
                    settingFornewId();
                } else if (myId == 11 | myId == 12) {
                    setContentView(R.layout.activity_sound_and_sign_4);
                    settingFornewId();
                } else if (myId == 13 | myId == 14 | myId == 15) {
                    setContentView(R.layout.activity_sound_and_sign_5);
                    settingFornewId();
                } else if (myId == 16 | myId == 17 | myId == 18 | myId == 19 | myId == 20 | myId == 21 | myId == 22) {
                    setContentView(R.layout.activity_sound_and_sign_6);
                    settingFornewId();
                } else if (myId == 23) {
                    setContentView(R.layout.activity_sound_and_sign_6);
                    settingFornewId();
                } else if (myId == 67 | myId == 68 | myId == 70 | myId == 71 | myId == 72
                        | myId == 75 | myId == 76 | myId == 77 | myId == 78
                        | myId == 79 | myId == 80 | myId == 81 | myId == 82 | myId == 83) {
                    setContentView(R.layout.activity_sound_and_sign_6);
                    settingFornewId();

                }

            }
        });

        sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
        sharedPreferences.getBoolean("buy_is_ok", false);
        boolean isBuy = sharedPreferences.getBoolean("buy_is_ok", false);

        imgGoLeft.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mediaPlayer = MediaPlayer.create(ActivitySoundAndSign.this, R.raw.click);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });


               /* if (myId == 23) {
                    myId = myId + 43;
                }
                if (myId == 68) {
                    myId = myId + 2;
                } else if (myId == 72) {
                    myId = myId + 3;
                }else if (myId == 83) {
                    myId = 83;
                } else {
                    myId = myId + 1;
                }*/
                if (myId==9) {
                    if (isBuy == false) {
                        Intent intent = new Intent(ActivitySoundAndSign.this, ActivityPurchase.class);
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


                if (myId == 3 | myId == 4 | myId == 5 | myId == 6) {
                    setContentView(R.layout.activity_sound_and_sign_2);
                    settingFornewId();
                } else if (myId == 7 | myId == 8 | myId == 9 | myId == 10) {
                    setContentView(R.layout.activity_sound_and_sign_3);
                    settingFornewId();
                } else if (myId == 11 | myId == 12) {
                    setContentView(R.layout.activity_sound_and_sign_4);
                    settingFornewId();
                } else if (myId == 13 | myId == 14 | myId == 15) {
                    setContentView(R.layout.activity_sound_and_sign_5);
                    settingFornewId();
                } else if (myId == 16 | myId == 17 | myId == 18 | myId == 19 | myId == 20 | myId == 21 | myId == 22) {
                    setContentView(R.layout.activity_sound_and_sign_6);
                    settingFornewId();
                } else if (myId == 23) {
                    setContentView(R.layout.activity_sound_and_sign_6);
                    settingFornewId();
                } else if (myId == 67 | myId == 68 | myId == 70 | myId == 71 | myId == 72
                        | myId == 75 | myId == 76 | myId == 77 | myId == 78
                        | myId == 79 | myId == 80 | myId == 81 | myId == 82 | myId == 83) {
                    setContentView(R.layout.activity_sound_and_sign_6);
                    settingFornewId(); }



            }

        });
        btnRenew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaOk(R.raw.practic);
                if (myId == 3 | myId == 4 | myId == 5 | myId == 6) {
                    setContentView(R.layout.activity_sound_and_sign_2);
                    settingFornewId();
                } else if (myId == 7 | myId == 8 | myId == 9 | myId == 10) {
                    setContentView(R.layout.activity_sound_and_sign_3);
                    settingFornewId();
                } else if (myId == 11 | myId == 12) {
                    setContentView(R.layout.activity_sound_and_sign_4);
                    settingFornewId();
                } else if (myId == 13 | myId == 14 | myId == 15) {
                    setContentView(R.layout.activity_sound_and_sign_5);
                    settingFornewId();
                } else if (myId == 16 | myId == 17 | myId == 18 | myId == 19 | myId == 20 | myId == 21 | myId == 22) {
                    setContentView(R.layout.activity_sound_and_sign_6);
                    settingFornewId();
                } else if (myId == 23) {
                    setContentView(R.layout.activity_sound_and_sign_6);
                    settingFornewId();
                } else if (myId == 67 | myId == 68 | myId == 70 | myId == 71 | myId == 72
                        | myId == 75 | myId == 76 | myId == 77 | myId == 78
                        | myId == 79 | myId == 80 | myId == 81 | myId == 82 | myId == 83) {
                    setContentView(R.layout.activity_sound_and_sign_6);
                    settingFornewId();

                }
                changeWordsInTable();
                settingTouchAndDragListenerForButtons();


            }
        });
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer = MediaPlayer.create(ActivitySoundAndSign.this, R.raw.click);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                finish();
            }
        });
        imgHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer = MediaPlayer.create(ActivitySoundAndSign.this, R.raw.click);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                Intent intent = new Intent(ActivitySoundAndSign.this, ActivityAllAlphabet.class);
                startActivity(intent);
            }
        });

    }

    private void settingFornewId() {
        findView();
        setOnClick();
        changeWordsInTable();
        settingTouchAndDragListenerForButtons();
    }

    private void settingForDropAndDrags(View v, View view) {

        if (myId == 2) {
            if (view.getId() == R.id.btn_option && v.getId() == R.id.lnr_result) {
                btnOption((LinearLayout) v, view, btnResult, lnrResult);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_ba);
                mediaAfarin(R.raw.afarin);
            }
        } else if (myId == 3) {
            if (view.getId() == R.id.btn_option && v.getId() == R.id.lnr_result) {
                btnOption((LinearLayout) v, view, btnResult, lnrResult);

                mediaOk(R.raw.ok);

                wordPronunciation(R.raw.tarkib_ba);
            } else if (view.getId() == R.id.btn_option2 && v.getId() == R.id.lnr_result2) {
                btnOption((LinearLayout) v, view, btnResult2, lnrResult2);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_baa);
                mediaAfarin(R.raw.barikala);


            } else {
                mediaWrong();
            }

        } else if (myId == 4) {
            if (view.getId() == R.id.btn_option && v.getId() == R.id.lnr_result) {
                btnOption((LinearLayout) v, view, btnResult, lnrResult);

                mediaOk(R.raw.ok);

                wordPronunciation(R.raw.tarkib_da);
            } else if (view.getId() == R.id.btn_option2 && v.getId() == R.id.lnr_result2) {
                btnOption((LinearLayout) v, view, btnResult2, lnrResult2);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_daa);
                mediaAalii();


            } else {
                mediaWrong();
            }

        } else if (myId == 5) {
            if (view.getId() == R.id.btn_option && v.getId() == R.id.lnr_result) {
                btnOption((LinearLayout) v, view, btnResult, lnrResult);

                mediaOk(R.raw.ok);

                wordPronunciation(R.raw.tarkib_ma);
            } else if (view.getId() == R.id.btn_option2 && v.getId() == R.id.lnr_result2) {
                btnOption((LinearLayout) v, view, btnResult2, lnrResult2);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_maa);


            } else {
                mediaWrong();

            }

        } else if (myId == 6) {
            if (view.getId() == R.id.btn_option && v.getId() == R.id.lnr_result) {
                btnOption((LinearLayout) v, view, btnResult, lnrResult);

                mediaOk(R.raw.ok);

                wordPronunciation(R.raw.tarkib_sa);
            } else if (view.getId() == R.id.btn_option2 && v.getId() == R.id.lnr_result2) {
                btnOption((LinearLayout) v, view, btnResult2, lnrResult2);


                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_saa);
                mediaAalii();


            } else {
                mediaWrong();
            }

        } else if (myId == 7) {
            if (view.getId() == R.id.btn_option && v.getId() == R.id.lnr_result) {
                btnOption((LinearLayout) v, view, btnResult, lnrResult);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_sa);


            } else if (view.getId() == R.id.btn_option2 && v.getId() == R.id.lnr_result2) {
                btnOption((LinearLayout) v, view, btnResult2, lnrResult2);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_saa);


            } else if (view.getId() == R.id.btn_option3 && v.getId() == R.id.lnr_result3) {
                btnOption((LinearLayout) v, view, btnResult3, lnrResult3);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_soo);
                mediaAalii();


            } else {
                mediaWrong();
            }

        } else if (myId == 8) {
            if (view.getId() == R.id.btn_option && v.getId() == R.id.lnr_result) {
                btnOption((LinearLayout) v, view, btnResult, lnrResult);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_ta);


            } else if (view.getId() == R.id.btn_option2 && v.getId() == R.id.lnr_result2) {
                btnOption((LinearLayout) v, view, btnResult2, lnrResult2);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_taa);


            } else if (view.getId() == R.id.btn_option3 && v.getId() == R.id.lnr_result3) {
                btnOption((LinearLayout) v, view, btnResult3, lnrResult3);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_too);
                mediaAalii();


            } else {
                mediaWrong();
            }

        } else if (myId == 9) {
            if (view.getId() == R.id.btn_option && v.getId() == R.id.lnr_result) {
                btnOption((LinearLayout) v, view, btnResult, lnrResult);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_ra);


            } else if (view.getId() == R.id.btn_option2 && v.getId() == R.id.lnr_result2) {
                btnOption((LinearLayout) v, view, btnResult2, lnrResult2);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_raa);


            } else if (view.getId() == R.id.btn_option3 && v.getId() == R.id.lnr_result3) {
                btnOption((LinearLayout) v, view, btnResult3, lnrResult3);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_roo);
                mediaAalii();


            } else {
                mediaWrong();
            }

        } else if (myId == 10) {
            if (view.getId() == R.id.btn_option && v.getId() == R.id.lnr_result) {
                btnOption((LinearLayout) v, view, btnResult, lnrResult);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_na);


            } else if (view.getId() == R.id.btn_option2 && v.getId() == R.id.lnr_result2) {
                btnOption((LinearLayout) v, view, btnResult2, lnrResult2);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_naa);


            } else if (view.getId() == R.id.btn_option3 && v.getId() == R.id.lnr_result3) {
                btnOption((LinearLayout) v, view, btnResult3, lnrResult3);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_noo);
                mediaAfarin(R.raw.afarin);


            } else {
                mediaWrong();
            }

        } else if (myId == 11) {
            if (view.getId() == R.id.btn_option && v.getId() == R.id.lnr_result) {
                btnOption((LinearLayout) v, view, btnResult, lnrResult);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_na);


            } else if (view.getId() == R.id.btn_option2 && v.getId() == R.id.lnr_result2) {
                btnOption((LinearLayout) v, view, btnResult2, lnrResult2);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_naa);


            } else if (view.getId() == R.id.btn_option4 && v.getId() == R.id.lnr_result4) {
                btnOption((LinearLayout) v, view, btnResult4, lnrResult4);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_ni);
                mediaAalii();


            } else if (view.getId() == R.id.btn_option3 && v.getId() == R.id.lnr_result3) {
                btnOption((LinearLayout) v, view, btnResult3, lnrResult3);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_noo);


            } else {
                mediaWrong();
            }

        } else if (myId == 12) {
            if (view.getId() == R.id.btn_option && v.getId() == R.id.lnr_result) {
                btnOption((LinearLayout) v, view, btnResult, lnrResult);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_za);


            } else if (view.getId() == R.id.btn_option2 && v.getId() == R.id.lnr_result2) {
                btnOption((LinearLayout) v, view, btnResult2, lnrResult2);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_zaa);


            } else if (view.getId() == R.id.btn_option4 && v.getId() == R.id.lnr_result4) {
                btnOption((LinearLayout) v, view, btnResult4, lnrResult4);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_zi);
                mediaAalii();


            } else if (view.getId() == R.id.btn_option3 && v.getId() == R.id.lnr_result3) {
                btnOption((LinearLayout) v, view, btnResult3, lnrResult3);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_zoo);


            } else {
                mediaWrong();
            }

        } else if (myId == 13) {
            if (view.getId() == R.id.btn_option && v.getId() == R.id.lnr_result) {
                btnOption((LinearLayout) v, view, btnResult, lnrResult);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_sa);


            } else if (view.getId() == R.id.btn_option2 && v.getId() == R.id.lnr_result2) {
                btnOption((LinearLayout) v, view, btnResult2, lnrResult2);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_saa);


            } else if (view.getId() == R.id.btn_option4 && v.getId() == R.id.lnr_result4) {
                btnOption((LinearLayout) v, view, btnResult4, lnrResult4);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_si);


            } else if (view.getId() == R.id.btn_option5 && v.getId() == R.id.lnr_result5) {
                btnOption((LinearLayout) v, view, btnResult5, lnrResult5);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_sea);
                mediaAfarin(R.raw.afarin);


            } else if (view.getId() == R.id.btn_option3 && v.getId() == R.id.lnr_result3) {
                btnOption((LinearLayout) v, view, btnResult3, lnrResult3);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_soo);


            } else {
                mediaWrong();
            }

        } else if (myId == 14) {
            if (view.getId() == R.id.btn_option && v.getId() == R.id.lnr_result) {
                btnOption((LinearLayout) v, view, btnResult, lnrResult);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_sha);


            } else if (view.getId() == R.id.btn_option2 && v.getId() == R.id.lnr_result2) {
                btnOption((LinearLayout) v, view, btnResult2, lnrResult2);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_shaa);


            } else if (view.getId() == R.id.btn_option4 && v.getId() == R.id.lnr_result4) {
                btnOption((LinearLayout) v, view, btnResult4, lnrResult4);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_shi);


            } else if (view.getId() == R.id.btn_option5 && v.getId() == R.id.lnr_result5) {
                btnOption((LinearLayout) v, view, btnResult5, lnrResult5);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_shea);
                mediaAalii();

            } else if (view.getId() == R.id.btn_option3 && v.getId() == R.id.lnr_result3) {
                btnOption((LinearLayout) v, view, btnResult3, lnrResult3);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_shoo);


            } else {
                mediaWrong();
            }

        } else if (myId == 15) {
            if (view.getId() == R.id.btn_option && v.getId() == R.id.lnr_result) {
                btnOption((LinearLayout) v, view, btnResult, lnrResult);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_ya);


            } else if (view.getId() == R.id.btn_option2 && v.getId() == R.id.lnr_result2) {
                btnOption((LinearLayout) v, view, btnResult2, lnrResult2);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_yaa);


            } else if (view.getId() == R.id.btn_option4 && v.getId() == R.id.lnr_result4) {
                btnOption((LinearLayout) v, view, btnResult4, lnrResult4);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_yii);


            } else if (view.getId() == R.id.btn_option5 && v.getId() == R.id.lnr_result5) {
                btnOption((LinearLayout) v, view, btnResult5, lnrResult5);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_yea);
                mediaAalii();


            } else if (view.getId() == R.id.btn_option3 && v.getId() == R.id.lnr_result3) {
                btnOption((LinearLayout) v, view, btnResult3, lnrResult3);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_yoo);


            } else {
                mediaWrong();
            }

        } else if (myId == 16) {
            if (view.getId() == R.id.btn_option && v.getId() == R.id.lnr_result) {
                btnOption((LinearLayout) v, view, btnResult, lnrResult);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_ba);


            } else if (view.getId() == R.id.btn_option2 && v.getId() == R.id.lnr_result2) {
                btnOption((LinearLayout) v, view, btnResult2, lnrResult2);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_baa);


            } else if (view.getId() == R.id.btn_option4 && v.getId() == R.id.lnr_result4) {
                btnOption((LinearLayout) v, view, btnResult4, lnrResult4);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_bi);


            } else if (view.getId() == R.id.btn_option5 && v.getId() == R.id.lnr_result5) {
                btnOption((LinearLayout) v, view, btnResult5, lnrResult5);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_bea);


            } else if (view.getId() == R.id.btn_option6 && v.getId() == R.id.lnr_result6) {
                btnOption((LinearLayout) v, view, btnResult6, lnrResult6);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_bo);
                mediaAalii();


            } else if (view.getId() == R.id.btn_option3 && v.getId() == R.id.lnr_result3) {
                btnOption((LinearLayout) v, view, btnResult3, lnrResult3);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_boo);


            } else {
                mediaWrong();
            }

        } else if (myId == 17) {
            if (view.getId() == R.id.btn_option && v.getId() == R.id.lnr_result) {
                btnOption((LinearLayout) v, view, btnResult, lnrResult);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_ka);


            } else if (view.getId() == R.id.btn_option2 && v.getId() == R.id.lnr_result2) {
                btnOption((LinearLayout) v, view, btnResult2, lnrResult2);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_kaa);


            } else if (view.getId() == R.id.btn_option4 && v.getId() == R.id.lnr_result4) {
                btnOption((LinearLayout) v, view, btnResult4, lnrResult4);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_ki);


            } else if (view.getId() == R.id.btn_option5 && v.getId() == R.id.lnr_result5) {
                btnOption((LinearLayout) v, view, btnResult5, lnrResult5);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_kea);


            } else if (view.getId() == R.id.btn_option6 && v.getId() == R.id.lnr_result6) {
                btnOption((LinearLayout) v, view, btnResult6, lnrResult6);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_ko);
                mediaAalii();


            } else if (view.getId() == R.id.btn_option3 && v.getId() == R.id.lnr_result3) {
                btnOption((LinearLayout) v, view, btnResult3, lnrResult3);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_koo);


            } else {
                mediaWrong();
            }

        } else if (myId == 18) {
            if (view.getId() == R.id.btn_option && v.getId() == R.id.lnr_result) {
                btnOption((LinearLayout) v, view, btnResult, lnrResult);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_va);


            } else if (view.getId() == R.id.btn_option2 && v.getId() == R.id.lnr_result2) {
                btnOption((LinearLayout) v, view, btnResult2, lnrResult2);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_vaa);


            } else if (view.getId() == R.id.btn_option4 && v.getId() == R.id.lnr_result4) {
                btnOption((LinearLayout) v, view, btnResult4, lnrResult4);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_vi);


            } else if (view.getId() == R.id.btn_option5 && v.getId() == R.id.lnr_result5) {
                btnOption((LinearLayout) v, view, btnResult5, lnrResult5);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_vea);


            } else if (view.getId() == R.id.btn_option6 && v.getId() == R.id.lnr_result6) {
                btnOption((LinearLayout) v, view, btnResult6, lnrResult6);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_vo);
                mediaAalii();


            } else if (view.getId() == R.id.btn_option3 && v.getId() == R.id.lnr_result3) {
                btnOption((LinearLayout) v, view, btnResult3, lnrResult3);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_voo);


            } else {
                mediaWrong();
            }

        } else if (myId == 19) {
            if (view.getId() == R.id.btn_option && v.getId() == R.id.lnr_result) {
                btnOption((LinearLayout) v, view, btnResult, lnrResult);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_pa);


            } else if (view.getId() == R.id.btn_option2 && v.getId() == R.id.lnr_result2) {
                btnOption((LinearLayout) v, view, btnResult2, lnrResult2);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_paa);


            } else if (view.getId() == R.id.btn_option4 && v.getId() == R.id.lnr_result4) {
                btnOption((LinearLayout) v, view, btnResult4, lnrResult4);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_pi);


            } else if (view.getId() == R.id.btn_option5 && v.getId() == R.id.lnr_result5) {
                btnOption((LinearLayout) v, view, btnResult5, lnrResult5);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_pea);


            } else if (view.getId() == R.id.btn_option6 && v.getId() == R.id.lnr_result6) {
                btnOption((LinearLayout) v, view, btnResult6, lnrResult6);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_po);
                mediaAalii();


            } else if (view.getId() == R.id.btn_option3 && v.getId() == R.id.lnr_result3) {
                btnOption((LinearLayout) v, view, btnResult3, lnrResult3);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_poo);


            } else {
                mediaWrong();
            }

        } else if (myId == 20) {
            if (view.getId() == R.id.btn_option && v.getId() == R.id.lnr_result) {
                btnOption((LinearLayout) v, view, btnResult, lnrResult);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_gha);


            } else if (view.getId() == R.id.btn_option2 && v.getId() == R.id.lnr_result2) {
                btnOption((LinearLayout) v, view, btnResult2, lnrResult2);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_ghaa);


            } else if (view.getId() == R.id.btn_option4 && v.getId() == R.id.lnr_result4) {
                btnOption((LinearLayout) v, view, btnResult4, lnrResult4);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_ghi);


            } else if (view.getId() == R.id.btn_option5 && v.getId() == R.id.lnr_result5) {
                btnOption((LinearLayout) v, view, btnResult5, lnrResult5);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_ghea);


            } else if (view.getId() == R.id.btn_option6 && v.getId() == R.id.lnr_result6) {
                btnOption((LinearLayout) v, view, btnResult6, lnrResult6);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_gho);
                mediaAfarin(R.raw.afarin);


            } else if (view.getId() == R.id.btn_option3 && v.getId() == R.id.lnr_result3) {
                btnOption((LinearLayout) v, view, btnResult3, lnrResult3);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_ghoo);


            } else {
                mediaWrong();
            }

        } else if (myId == 21) {
            if (view.getId() == R.id.btn_option && v.getId() == R.id.lnr_result) {
                btnOption((LinearLayout) v, view, btnResult, lnrResult);
                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_fa);


            } else if (view.getId() == R.id.btn_option2 && v.getId() == R.id.lnr_result2) {
                btnOption((LinearLayout) v, view, btnResult2, lnrResult2);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_faa);


            } else if (view.getId() == R.id.btn_option4 && v.getId() == R.id.lnr_result4) {
                btnOption((LinearLayout) v, view, btnResult4, lnrResult4);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_fi);


            } else if (view.getId() == R.id.btn_option5 && v.getId() == R.id.lnr_result5) {
                btnOption((LinearLayout) v, view, btnResult5, lnrResult5);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_fea);


            } else if (view.getId() == R.id.btn_option6 && v.getId() == R.id.lnr_result6) {
                btnOption((LinearLayout) v, view, btnResult6, lnrResult6);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_fo);
                mediaAalii();


            } else if (view.getId() == R.id.btn_option3 && v.getId() == R.id.lnr_result3) {
                btnOption((LinearLayout) v, view, btnResult3, lnrResult3);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_foo);


            } else {
                mediaWrong();
            }

        } else if (myId == 22) {
            if (view.getId() == R.id.btn_option && v.getId() == R.id.lnr_result) {
                btnOption((LinearLayout) v, view, btnResult, lnrResult);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_kha);


            } else if (view.getId() == R.id.btn_option2 && v.getId() == R.id.lnr_result2) {
                btnOption((LinearLayout) v, view, btnResult2, lnrResult2);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_khaa);


            } else if (view.getId() == R.id.btn_option4 && v.getId() == R.id.lnr_result4) {
                btnOption((LinearLayout) v, view, btnResult4, lnrResult4);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_khi);


            } else if (view.getId() == R.id.btn_option5 && v.getId() == R.id.lnr_result5) {
                btnOption((LinearLayout) v, view, btnResult5, lnrResult5);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_khea);


            } else if (view.getId() == R.id.btn_option6 && v.getId() == R.id.lnr_result6) {
                btnOption((LinearLayout) v, view, btnResult6, lnrResult6);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_kho);
                mediaAalii();


            } else if (view.getId() == R.id.btn_option3 && v.getId() == R.id.lnr_result3) {
                btnOption((LinearLayout) v, view, btnResult3, lnrResult3);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_khoo);


            } else {
                mediaWrong();
            }

        } else if (myId == 23) {
            if (view.getId() == R.id.btn_option && v.getId() == R.id.lnr_result) {
                btnOption((LinearLayout) v, view, btnResult, lnrResult);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_ggha);


            } else if (view.getId() == R.id.btn_option2 && v.getId() == R.id.lnr_result2) {
                btnOption((LinearLayout) v, view, btnResult2, lnrResult2);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_gghaa);


            } else if (view.getId() == R.id.btn_option4 && v.getId() == R.id.lnr_result4) {
                btnOption((LinearLayout) v, view, btnResult4, lnrResult4);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_gghi);


            } else if (view.getId() == R.id.btn_option5 && v.getId() == R.id.lnr_result5) {
                btnOption((LinearLayout) v, view, btnResult5, lnrResult5);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_gghea);


            } else if (view.getId() == R.id.btn_option6 && v.getId() == R.id.lnr_result6) {
                btnOption((LinearLayout) v, view, btnResult6, lnrResult6);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_ggho);
                mediaAfarin(R.raw.afarin);


            } else if (view.getId() == R.id.btn_option3 && v.getId() == R.id.lnr_result3) {
                btnOption((LinearLayout) v, view, btnResult3, lnrResult3);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_gghoo);


            } else {
                mediaWrong();
            }

        } else if (myId == 67) {
            if (view.getId() == R.id.btn_option && v.getId() == R.id.lnr_result) {
                btnOption((LinearLayout) v, view, btnResult, lnrResult);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_la);


            } else if (view.getId() == R.id.btn_option2 && v.getId() == R.id.lnr_result2) {
                btnOption((LinearLayout) v, view, btnResult2, lnrResult2);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_laa);


            } else if (view.getId() == R.id.btn_option4 && v.getId() == R.id.lnr_result4) {
                btnOption((LinearLayout) v, view, btnResult4, lnrResult4);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_li);


            } else if (view.getId() == R.id.btn_option5 && v.getId() == R.id.lnr_result5) {
                btnOption((LinearLayout) v, view, btnResult5, lnrResult5);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_lea);


            } else if (view.getId() == R.id.btn_option6 && v.getId() == R.id.lnr_result6) {
                btnOption((LinearLayout) v, view, btnResult6, lnrResult6);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_lo);
                mediaAalii();


            } else if (view.getId() == R.id.btn_option3 && v.getId() == R.id.lnr_result3) {
                btnOption((LinearLayout) v, view, btnResult3, lnrResult3);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_loo);


            } else {
                mediaWrong();
            }

        } else if (myId == 68) {
            if (view.getId() == R.id.btn_option && v.getId() == R.id.lnr_result) {
                btnOption((LinearLayout) v, view, btnResult, lnrResult);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_ja);


            } else if (view.getId() == R.id.btn_option2 && v.getId() == R.id.lnr_result2) {
                btnOption((LinearLayout) v, view, btnResult2, lnrResult2);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_jaa);


            } else if (view.getId() == R.id.btn_option4 && v.getId() == R.id.lnr_result4) {
                btnOption((LinearLayout) v, view, btnResult4, lnrResult4);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_ji);


            } else if (view.getId() == R.id.btn_option5 && v.getId() == R.id.lnr_result5) {
                btnOption((LinearLayout) v, view, btnResult5, lnrResult5);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_jea);


            } else if (view.getId() == R.id.btn_option6 && v.getId() == R.id.lnr_result6) {
                btnOption((LinearLayout) v, view, btnResult6, lnrResult6);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_jo);
                mediaAalii();


            } else if (view.getId() == R.id.btn_option3 && v.getId() == R.id.lnr_result3) {
                btnOption((LinearLayout) v, view, btnResult3, lnrResult3);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_joo);


            } else {
                mediaWrong();
            }

        } else if (myId == 70) {
            if (view.getId() == R.id.btn_option && v.getId() == R.id.lnr_result) {
                btnOption((LinearLayout) v, view, btnResult, lnrResult);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_ha);


            } else if (view.getId() == R.id.btn_option2 && v.getId() == R.id.lnr_result2) {
                btnOption((LinearLayout) v, view, btnResult2, lnrResult2);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_haa);


            } else if (view.getId() == R.id.btn_option4 && v.getId() == R.id.lnr_result4) {
                btnOption((LinearLayout) v, view, btnResult4, lnrResult4);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_hi);


            } else if (view.getId() == R.id.btn_option5 && v.getId() == R.id.lnr_result5) {
                btnOption((LinearLayout) v, view, btnResult5, lnrResult5);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_hea);


            } else if (view.getId() == R.id.btn_option6 && v.getId() == R.id.lnr_result6) {
                btnOption((LinearLayout) v, view, btnResult6, lnrResult6);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_ho);
                mediaAfarin(R.raw.afarin);


            } else if (view.getId() == R.id.btn_option3 && v.getId() == R.id.lnr_result3) {
                btnOption((LinearLayout) v, view, btnResult3, lnrResult3);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_hoo);


            } else {
                mediaWrong();
            }

        } else if (myId == 71) {
            if (view.getId() == R.id.btn_option && v.getId() == R.id.lnr_result) {
                btnOption((LinearLayout) v, view, btnResult, lnrResult);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_cha);


            } else if (view.getId() == R.id.btn_option2 && v.getId() == R.id.lnr_result2) {
                btnOption((LinearLayout) v, view, btnResult2, lnrResult2);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_chaa);


            } else if (view.getId() == R.id.btn_option4 && v.getId() == R.id.lnr_result4) {
                btnOption((LinearLayout) v, view, btnResult4, lnrResult4);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_chi);


            } else if (view.getId() == R.id.btn_option5 && v.getId() == R.id.lnr_result5) {
                btnOption((LinearLayout) v, view, btnResult5, lnrResult5);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_chea);


            } else if (view.getId() == R.id.btn_option6 && v.getId() == R.id.lnr_result6) {
                btnOption((LinearLayout) v, view, btnResult6, lnrResult6);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_cho);
                mediaAfarin(R.raw.afarin);


            } else if (view.getId() == R.id.btn_option3 && v.getId() == R.id.lnr_result3) {
                btnOption((LinearLayout) v, view, btnResult3, lnrResult3);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_choo);


            } else {
                mediaWrong();
            }

        } else if (myId == 72) {
            if (view.getId() == R.id.btn_option && v.getId() == R.id.lnr_result) {
                btnOption((LinearLayout) v, view, btnResult, lnrResult);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_zha);


            } else if (view.getId() == R.id.btn_option2 && v.getId() == R.id.lnr_result2) {
                btnOption((LinearLayout) v, view, btnResult2, lnrResult2);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_zhaa);


            } else if (view.getId() == R.id.btn_option4 && v.getId() == R.id.lnr_result4) {
                btnOption((LinearLayout) v, view, btnResult4, lnrResult4);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_zhi);


            } else if (view.getId() == R.id.btn_option5 && v.getId() == R.id.lnr_result5) {
                btnOption((LinearLayout) v, view, btnResult5, lnrResult5);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_zhea);


            } else if (view.getId() == R.id.btn_option6 && v.getId() == R.id.lnr_result6) {
                btnOption((LinearLayout) v, view, btnResult6, lnrResult6);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_zho);
                mediaAalii();


            } else if (view.getId() == R.id.btn_option3 && v.getId() == R.id.lnr_result3) {
                btnOption((LinearLayout) v, view, btnResult3, lnrResult3);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_zhoo);


            } else {
                mediaWrong();
            }

        } else if (myId == 75) {
            if (view.getId() == R.id.btn_option && v.getId() == R.id.lnr_result) {
                btnOption((LinearLayout) v, view, btnResult, lnrResult);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_sa);


            } else if (view.getId() == R.id.btn_option2 && v.getId() == R.id.lnr_result2) {
                btnOption((LinearLayout) v, view, btnResult2, lnrResult2);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_saa);


            } else if (view.getId() == R.id.btn_option4 && v.getId() == R.id.lnr_result4) {
                btnOption((LinearLayout) v, view, btnResult4, lnrResult4);
                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_si);


            } else if (view.getId() == R.id.btn_option5 && v.getId() == R.id.lnr_result5) {
                btnOption((LinearLayout) v, view, btnResult5, lnrResult5);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_sea);


            } else if (view.getId() == R.id.btn_option6 && v.getId() == R.id.lnr_result6) {
                btnOption((LinearLayout) v, view, btnResult6, lnrResult6);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_so);
                mediaAalii();

            } else if (view.getId() == R.id.btn_option3 && v.getId() == R.id.lnr_result3) {
                btnOption((LinearLayout) v, view, btnResult3, lnrResult3);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_soo);


            } else {
                mediaWrong();
            }

        } else if (myId == 76) {
            if (view.getId() == R.id.btn_option && v.getId() == R.id.lnr_result) {
                btnOption((LinearLayout) v, view, btnResult, lnrResult);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_za);


            } else if (view.getId() == R.id.btn_option2 && v.getId() == R.id.lnr_result2) {
                btnOption((LinearLayout) v, view, btnResult2, lnrResult2);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_zaa);


            } else if (view.getId() == R.id.btn_option4 && v.getId() == R.id.lnr_result4) {
                btnOption((LinearLayout) v, view, btnResult4, lnrResult4);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_zi);


            } else if (view.getId() == R.id.btn_option5 && v.getId() == R.id.lnr_result5) {
                btnOption((LinearLayout) v, view, btnResult5, lnrResult5);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_zea);


            } else if (view.getId() == R.id.btn_option6 && v.getId() == R.id.lnr_result6) {
                btnOption((LinearLayout) v, view, btnResult6, lnrResult6);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_zo);
                mediaAalii();


            } else if (view.getId() == R.id.btn_option3 && v.getId() == R.id.lnr_result3) {
                btnOption((LinearLayout) v, view, btnResult3, lnrResult3);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_zoo);


            } else {
                mediaWrong();
            }

        } else if (myId == 77) {
            if (view.getId() == R.id.btn_option && v.getId() == R.id.lnr_result) {
                btnOption((LinearLayout) v, view, btnResult, lnrResult);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_a);


            } else if (view.getId() == R.id.btn_option2 && v.getId() == R.id.lnr_result2) {
                btnOption((LinearLayout) v, view, btnResult2, lnrResult2);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_aa);


            } else if (view.getId() == R.id.btn_option4 && v.getId() == R.id.lnr_result4) {
                btnOption((LinearLayout) v, view, btnResult4, lnrResult4);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_ii);


            } else if (view.getId() == R.id.btn_option5 && v.getId() == R.id.lnr_result5) {
                btnOption((LinearLayout) v, view, btnResult5, lnrResult5);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_ea);


            } else if (view.getId() == R.id.btn_option6 && v.getId() == R.id.lnr_result6) {
                btnOption((LinearLayout) v, view, btnResult6, lnrResult6);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_o);
                mediaAfarin(R.raw.afarin);


            } else if (view.getId() == R.id.btn_option3 && v.getId() == R.id.lnr_result3) {
                btnOption((LinearLayout) v, view, btnResult3, lnrResult3);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_oo);


            } else {
                mediaWrong();
            }

        } else if (myId == 78) {
            if (view.getId() == R.id.btn_option && v.getId() == R.id.lnr_result) {
                btnOption((LinearLayout) v, view, btnResult, lnrResult);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_sa);


            } else if (view.getId() == R.id.btn_option2 && v.getId() == R.id.lnr_result2) {
                btnOption((LinearLayout) v, view, btnResult2, lnrResult2);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_saa);


            } else if (view.getId() == R.id.btn_option4 && v.getId() == R.id.lnr_result4) {
                btnOption((LinearLayout) v, view, btnResult4, lnrResult4);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_si);


            } else if (view.getId() == R.id.btn_option5 && v.getId() == R.id.lnr_result5) {
                btnOption((LinearLayout) v, view, btnResult5, lnrResult5);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_sea);


            } else if (view.getId() == R.id.btn_option6 && v.getId() == R.id.lnr_result6) {
                btnOption((LinearLayout) v, view, btnResult6, lnrResult6);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_so);
                mediaAfarin(R.raw.afarin);


            } else if (view.getId() == R.id.btn_option3 && v.getId() == R.id.lnr_result3) {
                btnOption((LinearLayout) v, view, btnResult3, lnrResult3);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_soo);


            } else {
                mediaWrong();
            }

        } else if (myId == 79) {
            if (view.getId() == R.id.btn_option && v.getId() == R.id.lnr_result) {
                btnOption((LinearLayout) v, view, btnResult, lnrResult);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_ha);


            } else if (view.getId() == R.id.btn_option2 && v.getId() == R.id.lnr_result2) {
                btnOption((LinearLayout) v, view, btnResult2, lnrResult2);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_haa);


            } else if (view.getId() == R.id.btn_option4 && v.getId() == R.id.lnr_result4) {
                btnOption((LinearLayout) v, view, btnResult4, lnrResult4);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_hi);


            } else if (view.getId() == R.id.btn_option5 && v.getId() == R.id.lnr_result5) {
                btnOption((LinearLayout) v, view, btnResult5, lnrResult5);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_hea);


            } else if (view.getId() == R.id.btn_option6 && v.getId() == R.id.lnr_result6) {
                btnOption((LinearLayout) v, view, btnResult6, lnrResult6);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_ho);
                mediaAalii();


            } else if (view.getId() == R.id.btn_option3 && v.getId() == R.id.lnr_result3) {
                btnOption((LinearLayout) v, view, btnResult3, lnrResult3);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_hoo);


            } else {
                mediaWrong();
            }

        } else if (myId == 80) {
            if (view.getId() == R.id.btn_option && v.getId() == R.id.lnr_result) {
                btnOption((LinearLayout) v, view, btnResult, lnrResult);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_za);


            } else if (view.getId() == R.id.btn_option2 && v.getId() == R.id.lnr_result2) {
                btnOption((LinearLayout) v, view, btnResult2, lnrResult2);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_zaa);


            } else if (view.getId() == R.id.btn_option4 && v.getId() == R.id.lnr_result4) {
                btnOption((LinearLayout) v, view, btnResult4, lnrResult4);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_zi);


            } else if (view.getId() == R.id.btn_option5 && v.getId() == R.id.lnr_result5) {
                btnOption((LinearLayout) v, view, btnResult5, lnrResult5);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_zea);


            } else if (view.getId() == R.id.btn_option6 && v.getId() == R.id.lnr_result6) {
                btnOption((LinearLayout) v, view, btnResult6, lnrResult6);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_zo);
                mediaAfarin(R.raw.afarin);


            } else if (view.getId() == R.id.btn_option3 && v.getId() == R.id.lnr_result3) {
                btnOption((LinearLayout) v, view, btnResult3, lnrResult3);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_zoo);


            } else {
                mediaWrong();
            }

        } else if (myId == 81) {
            if (view.getId() == R.id.btn_option && v.getId() == R.id.lnr_result) {
                btnOption((LinearLayout) v, view, btnResult, lnrResult);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_ta);


            } else if (view.getId() == R.id.btn_option2 && v.getId() == R.id.lnr_result2) {
                btnOption((LinearLayout) v, view, btnResult2, lnrResult2);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_taa);


            } else if (view.getId() == R.id.btn_option4 && v.getId() == R.id.lnr_result4) {
                btnOption((LinearLayout) v, view, btnResult4, lnrResult4);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_ti);


            } else if (view.getId() == R.id.btn_option5 && v.getId() == R.id.lnr_result5) {
                btnOption((LinearLayout) v, view, btnResult5, lnrResult5);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_tea);


            } else if (view.getId() == R.id.btn_option6 && v.getId() == R.id.lnr_result6) {
                btnOption((LinearLayout) v, view, btnResult6, lnrResult6);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_to);
                mediaAalii();


            } else if (view.getId() == R.id.btn_option3 && v.getId() == R.id.lnr_result3) {
                btnOption((LinearLayout) v, view, btnResult3, lnrResult3);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_too);


            } else {
                mediaWrong();
            }

        } else if (myId == 82) {
            if (view.getId() == R.id.btn_option && v.getId() == R.id.lnr_result) {
                btnOption((LinearLayout) v, view, btnResult, lnrResult);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_ga);


            } else if (view.getId() == R.id.btn_option2 && v.getId() == R.id.lnr_result2) {
                btnOption((LinearLayout) v, view, btnResult2, lnrResult2);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_gaa);


            } else if (view.getId() == R.id.btn_option4 && v.getId() == R.id.lnr_result4) {
                btnOption((LinearLayout) v, view, btnResult4, lnrResult4);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_gi);


            } else if (view.getId() == R.id.btn_option5 && v.getId() == R.id.lnr_result5) {
                btnOption((LinearLayout) v, view, btnResult5, lnrResult5);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_gea);


            } else if (view.getId() == R.id.btn_option6 && v.getId() == R.id.lnr_result6) {
                btnOption((LinearLayout) v, view, btnResult6, lnrResult6);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_go);
                mediaAfarin(R.raw.afarin);


            } else if (view.getId() == R.id.btn_option3 && v.getId() == R.id.lnr_result3) {
                btnOption((LinearLayout) v, view, btnResult3, lnrResult3);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_goo);


            } else {
                mediaWrong();
            }

        } else if (myId == 83) {
            if (view.getId() == R.id.btn_option && v.getId() == R.id.lnr_result) {
                btnOption((LinearLayout) v, view, btnResult, lnrResult);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_za);


            } else if (view.getId() == R.id.btn_option2 && v.getId() == R.id.lnr_result2) {
                btnOption((LinearLayout) v, view, btnResult2, lnrResult2);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_zaa);


            } else if (view.getId() == R.id.btn_option4 && v.getId() == R.id.lnr_result4) {
                btnOption((LinearLayout) v, view, btnResult4, lnrResult4);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_zi);


            } else if (view.getId() == R.id.btn_option5 && v.getId() == R.id.lnr_result5) {
                btnOption((LinearLayout) v, view, btnResult5, lnrResult5);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_zea);


            } else if (view.getId() == R.id.btn_option6 && v.getId() == R.id.lnr_result6) {
                btnOption((LinearLayout) v, view, btnResult6, lnrResult6);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_zo);
                mediaAfarin(R.raw.afarin);


            } else if (view.getId() == R.id.btn_option3 && v.getId() == R.id.lnr_result3) {
                btnOption((LinearLayout) v, view, btnResult3, lnrResult3);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_zoo);


            } else {
                mediaWrong();
            }

        }
    }

    private void wordPronunciation(int p) {
        MediaPlayer mediaPlayer = MediaPlayer.create(ActivitySoundAndSign.this, p);
        mediaPlayer.start();
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.release();
            }
        });
    }

    private void btnOption(LinearLayout v, View view, Button btnResult, LinearLayout lnrResult) {
        LinearLayout oldParent = (LinearLayout) view.getParent();
        oldParent.removeView(view);
        LinearLayout newParent = v;
        btnResult.setVisibility(View.GONE);
        lnrResult.setBackgroundColor(0xFF00FF00);
        newParent.addView(view);
    }


    private void mediaBarikalla(int p) {
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                wordPronunciation(p);
            }
        }, 1000);
    }

    private void mediaAalii() {
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                wordPronunciation(R.raw.aali);
            }
        }, 1000);
    }

    private void mediaAfarin(int p) {
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                wordPronunciation(p);
            }
        }, 1000);
    }

    private void mediaWrong() {
        wordPronunciation(R.raw.wrong);
    }

    private void mediaOk(int p) {
        wordPronunciation(p);
    }

    private void changeWordsInTableForNewId() {
        if (newId == 4) {
            btnSign.setText("د");
            btnOption.setText("دا");
            btnOption2.setText("دَ");
        } else if (newId == 5) {
            btnSign.setText("مـ م");
            btnOption.setText("ما");
            btnOption2.setText("مـَ");
        } else if (newId == 6) {
            btnSign.setText("سـ س ");
            btnOption.setText("سا");
            btnOption2.setText("سـَ");
        } else if (newId == 7) {
            btnSign.setText("سـ س ");
            btnOption.setText("سا");
            btnOption2.setText("سـَ");
            btnOption3.setText("سو");
        } else if (newId == 8) {
            btnSign.setText("تـ ت ");
            btnOption.setText("تا");
            btnOption2.setText("تـَ");
            btnOption3.setText("تو");
        } else if (newId == 9) {
            btnSign.setText("ر ");
            btnOption.setText("را");
            btnOption2.setText("رَ");
            btnOption3.setText("رو");
        } else if (newId == 10) {
            btnSign.setText("نـ ن ");
            btnOption.setText("نا");
            btnOption2.setText("نـَ");
            btnOption3.setText("نو");
        } else if (newId == 11) {
            btnSign.setText("نـ ن ");
            btnOption.setText("نا");
            btnOption2.setText("نـَ");
            btnOption3.setText("نو");
            btnOption4.setText("نیـ نی");
        } else if (newId == 12) {
            btnSign.setText("ز ");
            btnOption.setText("زا");
            btnOption2.setText("زَ");
            btnOption3.setText("زو");
            btnOption4.setTextSize(25);
            btnOption4.setText("زیـ  زی");
        } else if (newId == 13) {
            btnSign.setText("سـ س ");
            btnOption.setText("سا");
            btnOption2.setText("سـَ");
            btnOption3.setText("سو");
            btnOption4.setTextSize(25);
            btnOption5.setTextSize(25);
            btnOption4.setText("سیـ سی");
            btnOption5.setText("سـِ سه");
        } else if (newId == 14) {
            btnSign.setText("شـ ش ");
            btnOption.setText("شا");
            btnOption2.setText("شـَ");
            btnOption3.setText("شو");
            btnOption4.setText("شیـ شی");
            btnOption4.setTextSize(25);
            btnOption5.setText("شـِ شه");
        } else if (newId == 15) {
            btnSign.setText("یـ ی");
            btnOption.setText("یا");
            btnOption2.setText("یـَ");
            btnOption3.setText("یو");
            btnOption4.setText("ییـ یی");
            btnOption4.setTextSize(25);
            btnOption5.setText("یـِ یه");
        } else if (newId == 16) {
            btnSign.setText("بـ ب");
            btnOption.setText("با");
            btnOption2.setText("بـَ");
            btnOption3.setText("بو");
            btnOption4.setText("بیـ بی");
            btnOption4.setTextSize(25);
            btnOption5.setText("بـِ به");
            btnOption6.setText("بـُ");
        } else if (newId == 17) {
            btnSign.setText("کـ ک");
            btnOption.setText("کا");
            btnOption2.setText("کـَ");
            btnOption3.setText("کو");
            btnOption4.setText("کیـ کی");
            btnOption4.setTextSize(25);
            btnOption5.setText("کـِ که");
            btnOption6.setText("کـُ");
        } else if (newId == 18) {
            btnSign.setText("و");
            btnOption.setText("وا");
            btnOption2.setText("وَ");
            btnOption3.setText("وو");
            btnOption4.setText("ویـ وی");
            btnOption4.setTextSize(25);
            btnOption5.setText("وِ وه");
            btnOption6.setText("وُ");
        } else if (newId == 19) {
            btnSign.setText("پـ پ");
            btnOption.setText("پا");
            btnOption2.setText("پـَ");
            btnOption3.setText("پو");
            btnOption4.setText("پیـ پی");
            btnOption4.setTextSize(25);
            btnOption5.setText("پـِ په");
            btnOption6.setText("پـُ");
        } else if (newId == 20) {
            btnSign.setText("گـ گ");
            btnOption.setText("گا");
            btnOption2.setText("گـَ");
            btnOption3.setText("گو");
            btnOption4.setText("گیـ گی");
            btnOption4.setTextSize(25);
            btnOption5.setText("گـِ گه");
            btnOption6.setText("گـُ");
        } else if (newId == 21) {
            btnSign.setText("فـ ف");
            btnOption.setText("فا");
            btnOption2.setText("فـَ");
            btnOption3.setText("فو");
            btnOption4.setText("فیـ فی");
            btnOption4.setTextSize(25);
            btnOption5.setText("فـِ فه");
            btnOption6.setText("فـُ");
        } else if (newId == 22) {
            btnSign.setText("خـ خ");
            btnOption.setText("خا");
            btnOption2.setText("خـَ");
            btnOption3.setText("خو");
            btnOption4.setText("خیـ خی");
            btnOption4.setTextSize(25);
            btnOption5.setText("خـِ خه");
            btnOption6.setText("خـُ");
        } else if (newId == 23) {
            btnSign.setText("قـ ق");
            btnOption.setText("قا");
            btnOption2.setText("قـَ");
            btnOption3.setText("قو");
            btnOption4.setText("قیـ قی");
            btnOption4.setTextSize(25);
            btnOption5.setText("قـِ قه");
            btnOption6.setText("قـُ");
        } else if (newId == 67) {
            btnSign.setText("لـ ل");
            btnOption.setText("لـا");
            btnOption2.setText("لـَ");
            btnOption3.setText("لو");
            btnOption4.setText("لیـ لی");
            btnOption4.setTextSize(25);
            btnOption5.setText("لـِ له");
            btnOption6.setText("لـُ");
        } else if (newId == 68) {
            btnSign.setText("جـ ج");
            btnOption.setText("جا");
            btnOption2.setText("جـَ");
            btnOption3.setText("جو");
            btnOption4.setText("جیـ جی");
            btnOption4.setTextSize(25);
            btnOption5.setText("جـِ جه");
            btnOption6.setText("جـُ");
        } else if (newId == 69) {
            btnSign.setText("بـ ب");
            btnOption.setText("با");
            btnOption2.setText("بـَ");
            btnOption3.setText("بو");
            btnOption4.setText("بیـ بی");
            btnOption4.setTextSize(25);
            btnOption5.setText("بـِ به");
            btnOption6.setText("بـُ");
        } else if (newId == 70) {
            btnSign.setText("هـ ـهـ ـه ه");
            btnSign.setTextSize(25);
            btnOption.setText("ها");
            btnOption2.setText("هـَ");
            btnOption3.setText("هو");
            btnOption4.setText("هیـ هی");
            btnOption4.setTextSize(25);
            btnOption5.setText("هـِ هه");
            btnOption6.setText("هـُ");
        } else if (newId == 71) {
            btnSign.setText("چـ چ");
            btnOption.setText("چا");
            btnOption2.setText("چـَ");
            btnOption3.setText("چو");
            btnOption4.setText("چیـ چی");
            btnOption4.setTextSize(25);
            btnOption5.setText("چـِ چه");
            btnOption6.setText("چـُ");
        } else if (newId == 72) {
            btnSign.setText("ژ ");
            btnOption.setText("ژا");
            btnOption2.setText("ژَ");
            btnOption3.setText("ژو");
            btnOption4.setText("ژیـ ژی");
            btnOption4.setTextSize(25);
            btnOption5.setText("ژِ ژه");
            btnOption6.setText("ژُ");
        } else if (newId == 73) {
            btnSign.setText("بـ ب");
            btnOption.setText("با");
            btnOption2.setText("بـَ");
            btnOption3.setText("بو");
            btnOption4.setText("بیـ بی");
            btnOption4.setTextSize(25);
            btnOption5.setText("بـِ به");
            btnOption6.setText("بـُ");
        } else if (newId == 74) {
            btnSign.setText("بـ ب");
            btnOption.setText("با");
            btnOption2.setText("بـَ");
            btnOption3.setText("بو");
            btnOption4.setText("بیـ بی");
            btnOption4.setTextSize(25);
            btnOption5.setText("بـِ به");
            btnOption6.setText("بـُ");
        } else if (newId == 75) {
            btnSign.setText("صـ ص");
            btnOption.setText("صا");
            btnOption2.setText("صـَ");
            btnOption3.setText("صو");
            btnOption4.setText("صیـ صی");
            btnOption4.setTextSize(25);
            btnOption5.setText("صـِ صه");
            btnOption6.setText("صـُ");
        } else if (newId == 76) {
            btnSign.setText("ذ");
            btnOption.setText("ذا");
            btnOption2.setText("ذَ");
            btnOption3.setText("ذو");
            btnOption4.setText("ذیـ ذی");
            btnOption4.setTextSize(25);
            btnOption5.setText("ذِ ذه");
            btnOption6.setText("ذُ");
        } else if (newId == 77) {
            btnSign.setText("عـ ـعـ ـع ع");
            btnSign.setTextSize(25);
            btnOption.setText("عا");
            btnOption2.setText("عـَ");
            btnOption3.setText("عو");
            btnOption4.setText("عیـ عی");
            btnOption4.setTextSize(25);
            btnOption5.setText("عـِ عه");
            btnOption6.setText("عـُ");
        } else if (newId == 78) {
            btnSign.setText("ثـ ث");
            btnOption.setText("ثا");
            btnOption2.setText("ثـَ");
            btnOption3.setText("ثو");
            btnOption4.setText("ثیـ ثی");
            btnOption4.setTextSize(25);
            btnOption5.setText("ثـِ ثه");
            btnOption6.setText("ثـُ");
        } else if (newId == 79) {
            btnSign.setText("حـ ح");
            btnOption.setText("حا");
            btnOption2.setText("حـَ");
            btnOption3.setText("حو");
            btnOption4.setText("حیـ حی");
            btnOption4.setTextSize(25);
            btnOption5.setText("حـِ حه");
            btnOption6.setText("حـُ");
        } else if (newId == 80) {
            btnSign.setText("ضـ ض");
            btnOption.setText("ضا");
            btnOption2.setText("ضـَ");
            btnOption3.setText("ضو");
            btnOption4.setText("ضیـ ضی");
            btnOption4.setTextSize(25);
            btnOption5.setText("ضـِ ضه");
            btnOption6.setText("ضـُ");
        } else if (newId == 81) {
            btnSign.setText("ط");
            btnOption.setText("طا");
            btnOption2.setText("طَ");
            btnOption3.setText("طو");
            btnOption4.setText("طیـ طی");
            btnOption4.setTextSize(25);
            btnOption5.setText("طِ طه");
            btnOption6.setText("طُُ");
        } else if (newId == 82) {
            btnSign.setText("غـ ـغـ ـغ غ");
            btnSign.setTextSize(20);
            btnOption.setText("غا");
            btnOption2.setText("غـَ");
            btnOption3.setText("غو");
            btnOption4.setText("غیـ غی");
            btnOption4.setTextSize(25);
            btnOption5.setText("غـِ غه");
            btnOption6.setText("غـُ");
        } else if (newId == 83) {
            btnSign.setText("ظ");
            btnOption.setText("ظا");
            btnOption2.setText("ظَ");
            btnOption3.setText("ظو");
            btnOption4.setText("ظیـ ظی");
            btnOption4.setTextSize(25);
            btnOption5.setText("ظِ ظه");
            btnOption6.setText("ظُ");
        }
    }

    private void settingTouchAndDragListenerForButtonsForNewId() {

        btnOption.setOnTouchListener(touchListener);
        lnrResult.setOnDragListener(dragListener);

        if (newId == 3 | newId == 4 | newId == 5 | newId == 6) {
            lnrResult2.setOnDragListener(dragListener);
            btnOption2.setOnTouchListener(touchListener);
        } else if (newId == 7 | newId == 8 | newId == 9 | newId == 10) {
            lnrResult2.setOnDragListener(dragListener);
            btnOption2.setOnTouchListener(touchListener);
            lnrResult3.setOnDragListener(dragListener);
            btnOption3.setOnTouchListener(touchListener);
        } else if (newId == 11 | newId == 12) {
            lnrResult2.setOnDragListener(dragListener);
            btnOption2.setOnTouchListener(touchListener);
            lnrResult3.setOnDragListener(dragListener);
            btnOption3.setOnTouchListener(touchListener);
            lnrResult4.setOnDragListener(dragListener);
            btnOption4.setOnTouchListener(touchListener);
        } else if (newId == 13 | newId == 14 | newId == 15) {
            lnrResult2.setOnDragListener(dragListener);
            btnOption2.setOnTouchListener(touchListener);
            lnrResult3.setOnDragListener(dragListener);
            btnOption3.setOnTouchListener(touchListener);
            lnrResult4.setOnDragListener(dragListener);
            btnOption4.setOnTouchListener(touchListener);
            lnrResult5.setOnDragListener(dragListener);
            btnOption5.setOnTouchListener(touchListener);
        } else if (newId == 16 | newId == 17 | newId == 18 | newId == 19 | newId == 20 | newId == 21 | newId == 22 | newId == 23 | newId == 67 | newId == 68
                | newId == 69 | newId == 70 | newId == 71 | newId == 72 | newId == 73 |
                newId == 74 | newId == 75 | newId == 76 | newId == 77 | newId == 78 |
                newId == 79 | newId == 80 | newId == 81 | newId == 82 | newId == 83) {
            lnrResult2.setOnDragListener(dragListener);
            btnOption2.setOnTouchListener(touchListener);
            lnrResult3.setOnDragListener(dragListener);
            btnOption3.setOnTouchListener(touchListener);
            lnrResult4.setOnDragListener(dragListener);
            btnOption4.setOnTouchListener(touchListener);
            lnrResult5.setOnDragListener(dragListener);
            btnOption5.setOnTouchListener(touchListener);
            lnrResult6.setOnDragListener(dragListener);
            btnOption6.setOnTouchListener(touchListener);
        }
    }

    private void settingForDropAndDragsForNewId(View v, View view) {

        if (newId == 2) {
            if (view.getId() == R.id.btn_option && v.getId() == R.id.lnr_result) {
                btnOption((LinearLayout) v, view, btnResult, lnrResult);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_ba);
                mediaAfarin(R.raw.afarin);
            }
        } else if (newId == 3) {
            if (view.getId() == R.id.btn_option && v.getId() == R.id.lnr_result) {
                btnOption((LinearLayout) v, view, btnResult, lnrResult);

                mediaOk(R.raw.ok);

                wordPronunciation(R.raw.tarkib_ba);
            } else if (view.getId() == R.id.btn_option2 && v.getId() == R.id.lnr_result2) {
                btnOption((LinearLayout) v, view, btnResult2, lnrResult2);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_baa);
                mediaAfarin(R.raw.barikala);


            } else {
                mediaWrong();
            }

        } else if (newId == 4) {
            if (view.getId() == R.id.btn_option && v.getId() == R.id.lnr_result) {
                btnOption((LinearLayout) v, view, btnResult, lnrResult);

                mediaOk(R.raw.ok);

                wordPronunciation(R.raw.tarkib_da);
            } else if (view.getId() == R.id.btn_option2 && v.getId() == R.id.lnr_result2) {
                btnOption((LinearLayout) v, view, btnResult2, lnrResult2);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_daa);
                mediaAalii();


            } else {
                mediaWrong();
            }

        } else if (newId == 5) {
            if (view.getId() == R.id.btn_option && v.getId() == R.id.lnr_result) {
                btnOption((LinearLayout) v, view, btnResult, lnrResult);

                mediaOk(R.raw.ok);

                wordPronunciation(R.raw.tarkib_ma);
            } else if (view.getId() == R.id.btn_option2 && v.getId() == R.id.lnr_result2) {
                btnOption((LinearLayout) v, view, btnResult2, lnrResult2);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_maa);


            } else {
                mediaWrong();
                mediaBarikalla(R.raw.barikala);
            }

        } else if (newId == 6) {
            if (view.getId() == R.id.btn_option && v.getId() == R.id.lnr_result) {
                btnOption((LinearLayout) v, view, btnResult, lnrResult);

                mediaOk(R.raw.ok);

                wordPronunciation(R.raw.tarkib_sa);
            } else if (view.getId() == R.id.btn_option2 && v.getId() == R.id.lnr_result2) {
                btnOption((LinearLayout) v, view, btnResult2, lnrResult2);


                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_saa);
                mediaAalii();


            } else {
                mediaWrong();
            }

        } else if (newId == 7) {
            if (view.getId() == R.id.btn_option && v.getId() == R.id.lnr_result) {
                btnOption((LinearLayout) v, view, btnResult, lnrResult);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_sa);


            } else if (view.getId() == R.id.btn_option2 && v.getId() == R.id.lnr_result2) {
                btnOption((LinearLayout) v, view, btnResult2, lnrResult2);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_saa);


            } else if (view.getId() == R.id.btn_option3 && v.getId() == R.id.lnr_result3) {
                btnOption((LinearLayout) v, view, btnResult3, lnrResult3);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_soo);
                mediaAalii();


            } else {
                mediaWrong();
            }

        } else if (newId == 8) {
            if (view.getId() == R.id.btn_option && v.getId() == R.id.lnr_result) {
                btnOption((LinearLayout) v, view, btnResult, lnrResult);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_ta);


            } else if (view.getId() == R.id.btn_option2 && v.getId() == R.id.lnr_result2) {
                btnOption((LinearLayout) v, view, btnResult2, lnrResult2);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_taa);


            } else if (view.getId() == R.id.btn_option3 && v.getId() == R.id.lnr_result3) {
                btnOption((LinearLayout) v, view, btnResult3, lnrResult3);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_too);
                mediaAalii();


            } else {
                mediaWrong();
            }

        } else if (newId == 9) {
            if (view.getId() == R.id.btn_option && v.getId() == R.id.lnr_result) {
                btnOption((LinearLayout) v, view, btnResult, lnrResult);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_ra);


            } else if (view.getId() == R.id.btn_option2 && v.getId() == R.id.lnr_result2) {
                btnOption((LinearLayout) v, view, btnResult2, lnrResult2);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_raa);


            } else if (view.getId() == R.id.btn_option3 && v.getId() == R.id.lnr_result3) {
                btnOption((LinearLayout) v, view, btnResult3, lnrResult3);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_roo);
                mediaAalii();


            } else {
                mediaWrong();
            }

        } else if (newId == 10) {
            if (view.getId() == R.id.btn_option && v.getId() == R.id.lnr_result) {
                btnOption((LinearLayout) v, view, btnResult, lnrResult);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_na);


            } else if (view.getId() == R.id.btn_option2 && v.getId() == R.id.lnr_result2) {
                btnOption((LinearLayout) v, view, btnResult2, lnrResult2);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_naa);


            } else if (view.getId() == R.id.btn_option3 && v.getId() == R.id.lnr_result3) {
                btnOption((LinearLayout) v, view, btnResult3, lnrResult3);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_noo);
                mediaAfarin(R.raw.afarin);


            } else {
                mediaWrong();
            }

        } else if (newId == 11) {
            if (view.getId() == R.id.btn_option && v.getId() == R.id.lnr_result) {
                btnOption((LinearLayout) v, view, btnResult, lnrResult);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_na);


            } else if (view.getId() == R.id.btn_option2 && v.getId() == R.id.lnr_result2) {
                btnOption((LinearLayout) v, view, btnResult2, lnrResult2);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_naa);


            } else if (view.getId() == R.id.btn_option4 && v.getId() == R.id.lnr_result4) {
                btnOption((LinearLayout) v, view, btnResult4, lnrResult4);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_ni);
                mediaAalii();


            } else if (view.getId() == R.id.btn_option3 && v.getId() == R.id.lnr_result3) {
                btnOption((LinearLayout) v, view, btnResult3, lnrResult3);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_noo);


            } else {
                mediaWrong();
            }

        } else if (newId == 12) {
            if (view.getId() == R.id.btn_option && v.getId() == R.id.lnr_result) {
                btnOption((LinearLayout) v, view, btnResult, lnrResult);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_za);


            } else if (view.getId() == R.id.btn_option2 && v.getId() == R.id.lnr_result2) {
                btnOption((LinearLayout) v, view, btnResult2, lnrResult2);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_zaa);


            } else if (view.getId() == R.id.btn_option4 && v.getId() == R.id.lnr_result4) {
                btnOption((LinearLayout) v, view, btnResult4, lnrResult4);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_zi);
                mediaAalii();


            } else if (view.getId() == R.id.btn_option3 && v.getId() == R.id.lnr_result3) {
                btnOption((LinearLayout) v, view, btnResult3, lnrResult3);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_zoo);


            } else {
                mediaWrong();
            }

        } else if (newId == 13) {
            if (view.getId() == R.id.btn_option && v.getId() == R.id.lnr_result) {
                btnOption((LinearLayout) v, view, btnResult, lnrResult);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_sa);


            } else if (view.getId() == R.id.btn_option2 && v.getId() == R.id.lnr_result2) {
                btnOption((LinearLayout) v, view, btnResult2, lnrResult2);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_saa);


            } else if (view.getId() == R.id.btn_option4 && v.getId() == R.id.lnr_result4) {
                btnOption((LinearLayout) v, view, btnResult4, lnrResult4);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_si);


            } else if (view.getId() == R.id.btn_option5 && v.getId() == R.id.lnr_result5) {
                btnOption((LinearLayout) v, view, btnResult5, lnrResult5);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_sea);
                mediaAfarin(R.raw.afarin);


            } else if (view.getId() == R.id.btn_option3 && v.getId() == R.id.lnr_result3) {
                btnOption((LinearLayout) v, view, btnResult3, lnrResult3);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_soo);


            } else {
                mediaWrong();
            }

        } else if (newId == 14) {
            if (view.getId() == R.id.btn_option && v.getId() == R.id.lnr_result) {
                btnOption((LinearLayout) v, view, btnResult, lnrResult);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_sha);


            } else if (view.getId() == R.id.btn_option2 && v.getId() == R.id.lnr_result2) {
                btnOption((LinearLayout) v, view, btnResult2, lnrResult2);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_shaa);


            } else if (view.getId() == R.id.btn_option4 && v.getId() == R.id.lnr_result4) {
                btnOption((LinearLayout) v, view, btnResult4, lnrResult4);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_shi);


            } else if (view.getId() == R.id.btn_option5 && v.getId() == R.id.lnr_result5) {
                btnOption((LinearLayout) v, view, btnResult5, lnrResult5);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_shea);
                mediaAalii();

            } else if (view.getId() == R.id.btn_option3 && v.getId() == R.id.lnr_result3) {
                btnOption((LinearLayout) v, view, btnResult3, lnrResult3);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_shoo);


            } else {
                mediaWrong();
            }

        } else if (newId == 15) {
            if (view.getId() == R.id.btn_option && v.getId() == R.id.lnr_result) {
                btnOption((LinearLayout) v, view, btnResult, lnrResult);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_ya);


            } else if (view.getId() == R.id.btn_option2 && v.getId() == R.id.lnr_result2) {
                btnOption((LinearLayout) v, view, btnResult2, lnrResult2);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_yaa);


            } else if (view.getId() == R.id.btn_option4 && v.getId() == R.id.lnr_result4) {
                btnOption((LinearLayout) v, view, btnResult4, lnrResult4);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_yii);


            } else if (view.getId() == R.id.btn_option5 && v.getId() == R.id.lnr_result5) {
                btnOption((LinearLayout) v, view, btnResult5, lnrResult5);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_yea);
                mediaAalii();


            } else if (view.getId() == R.id.btn_option3 && v.getId() == R.id.lnr_result3) {
                btnOption((LinearLayout) v, view, btnResult3, lnrResult3);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_yoo);


            } else {
                mediaWrong();
            }

        } else if (newId == 16) {
            if (view.getId() == R.id.btn_option && v.getId() == R.id.lnr_result) {
                btnOption((LinearLayout) v, view, btnResult, lnrResult);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_ba);


            } else if (view.getId() == R.id.btn_option2 && v.getId() == R.id.lnr_result2) {
                btnOption((LinearLayout) v, view, btnResult2, lnrResult2);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_baa);


            } else if (view.getId() == R.id.btn_option4 && v.getId() == R.id.lnr_result4) {
                btnOption((LinearLayout) v, view, btnResult4, lnrResult4);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_bi);


            } else if (view.getId() == R.id.btn_option5 && v.getId() == R.id.lnr_result5) {
                btnOption((LinearLayout) v, view, btnResult5, lnrResult5);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_bea);


            } else if (view.getId() == R.id.btn_option6 && v.getId() == R.id.lnr_result6) {
                btnOption((LinearLayout) v, view, btnResult6, lnrResult6);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_bo);
                mediaAalii();


            } else if (view.getId() == R.id.btn_option3 && v.getId() == R.id.lnr_result3) {
                btnOption((LinearLayout) v, view, btnResult3, lnrResult3);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_boo);


            } else {
                mediaWrong();
            }

        } else if (newId == 17) {
            if (view.getId() == R.id.btn_option && v.getId() == R.id.lnr_result) {
                btnOption((LinearLayout) v, view, btnResult, lnrResult);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_ka);


            } else if (view.getId() == R.id.btn_option2 && v.getId() == R.id.lnr_result2) {
                btnOption((LinearLayout) v, view, btnResult2, lnrResult2);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_kaa);


            } else if (view.getId() == R.id.btn_option4 && v.getId() == R.id.lnr_result4) {
                btnOption((LinearLayout) v, view, btnResult4, lnrResult4);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_ki);


            } else if (view.getId() == R.id.btn_option5 && v.getId() == R.id.lnr_result5) {
                btnOption((LinearLayout) v, view, btnResult5, lnrResult5);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_kea);


            } else if (view.getId() == R.id.btn_option6 && v.getId() == R.id.lnr_result6) {
                btnOption((LinearLayout) v, view, btnResult6, lnrResult6);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_ko);
                mediaAalii();


            } else if (view.getId() == R.id.btn_option3 && v.getId() == R.id.lnr_result3) {
                btnOption((LinearLayout) v, view, btnResult3, lnrResult3);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_koo);


            } else {
                mediaWrong();
            }

        } else if (newId == 18) {
            if (view.getId() == R.id.btn_option && v.getId() == R.id.lnr_result) {
                btnOption((LinearLayout) v, view, btnResult, lnrResult);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_va);


            } else if (view.getId() == R.id.btn_option2 && v.getId() == R.id.lnr_result2) {
                btnOption((LinearLayout) v, view, btnResult2, lnrResult2);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_vaa);


            } else if (view.getId() == R.id.btn_option4 && v.getId() == R.id.lnr_result4) {
                btnOption((LinearLayout) v, view, btnResult4, lnrResult4);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_vi);


            } else if (view.getId() == R.id.btn_option5 && v.getId() == R.id.lnr_result5) {
                btnOption((LinearLayout) v, view, btnResult5, lnrResult5);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_vea);


            } else if (view.getId() == R.id.btn_option6 && v.getId() == R.id.lnr_result6) {
                btnOption((LinearLayout) v, view, btnResult6, lnrResult6);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_vo);
                mediaAalii();


            } else if (view.getId() == R.id.btn_option3 && v.getId() == R.id.lnr_result3) {
                btnOption((LinearLayout) v, view, btnResult3, lnrResult3);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_voo);


            } else {
                mediaWrong();
            }

        } else if (newId == 19) {
            if (view.getId() == R.id.btn_option && v.getId() == R.id.lnr_result) {
                btnOption((LinearLayout) v, view, btnResult, lnrResult);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_pa);


            } else if (view.getId() == R.id.btn_option2 && v.getId() == R.id.lnr_result2) {
                btnOption((LinearLayout) v, view, btnResult2, lnrResult2);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_paa);


            } else if (view.getId() == R.id.btn_option4 && v.getId() == R.id.lnr_result4) {
                btnOption((LinearLayout) v, view, btnResult4, lnrResult4);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_pi);


            } else if (view.getId() == R.id.btn_option5 && v.getId() == R.id.lnr_result5) {
                btnOption((LinearLayout) v, view, btnResult5, lnrResult5);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_pea);


            } else if (view.getId() == R.id.btn_option6 && v.getId() == R.id.lnr_result6) {
                btnOption((LinearLayout) v, view, btnResult6, lnrResult6);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_po);
                mediaAalii();


            } else if (view.getId() == R.id.btn_option3 && v.getId() == R.id.lnr_result3) {
                btnOption((LinearLayout) v, view, btnResult3, lnrResult3);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_poo);


            } else {
                mediaWrong();
            }

        } else if (newId == 20) {
            if (view.getId() == R.id.btn_option && v.getId() == R.id.lnr_result) {
                btnOption((LinearLayout) v, view, btnResult, lnrResult);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_gha);


            } else if (view.getId() == R.id.btn_option2 && v.getId() == R.id.lnr_result2) {
                btnOption((LinearLayout) v, view, btnResult2, lnrResult2);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_ghaa);


            } else if (view.getId() == R.id.btn_option4 && v.getId() == R.id.lnr_result4) {
                btnOption((LinearLayout) v, view, btnResult4, lnrResult4);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_ghi);


            } else if (view.getId() == R.id.btn_option5 && v.getId() == R.id.lnr_result5) {
                btnOption((LinearLayout) v, view, btnResult5, lnrResult5);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_ghea);


            } else if (view.getId() == R.id.btn_option6 && v.getId() == R.id.lnr_result6) {
                btnOption((LinearLayout) v, view, btnResult6, lnrResult6);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_gho);
                mediaAfarin(R.raw.afarin);


            } else if (view.getId() == R.id.btn_option3 && v.getId() == R.id.lnr_result3) {
                btnOption((LinearLayout) v, view, btnResult3, lnrResult3);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_ghoo);


            } else {
                mediaWrong();
            }

        } else if (newId == 21) {
            if (view.getId() == R.id.btn_option && v.getId() == R.id.lnr_result) {
                btnOption((LinearLayout) v, view, btnResult, lnrResult);
                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_fa);


            } else if (view.getId() == R.id.btn_option2 && v.getId() == R.id.lnr_result2) {
                btnOption((LinearLayout) v, view, btnResult2, lnrResult2);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_faa);


            } else if (view.getId() == R.id.btn_option4 && v.getId() == R.id.lnr_result4) {
                btnOption((LinearLayout) v, view, btnResult4, lnrResult4);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_fi);


            } else if (view.getId() == R.id.btn_option5 && v.getId() == R.id.lnr_result5) {
                btnOption((LinearLayout) v, view, btnResult5, lnrResult5);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_fea);


            } else if (view.getId() == R.id.btn_option6 && v.getId() == R.id.lnr_result6) {
                btnOption((LinearLayout) v, view, btnResult6, lnrResult6);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_fo);
                mediaAalii();


            } else if (view.getId() == R.id.btn_option3 && v.getId() == R.id.lnr_result3) {
                btnOption((LinearLayout) v, view, btnResult3, lnrResult3);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_foo);


            } else {
                mediaWrong();
            }

        } else if (newId == 22) {
            if (view.getId() == R.id.btn_option && v.getId() == R.id.lnr_result) {
                btnOption((LinearLayout) v, view, btnResult, lnrResult);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_kha);


            } else if (view.getId() == R.id.btn_option2 && v.getId() == R.id.lnr_result2) {
                btnOption((LinearLayout) v, view, btnResult2, lnrResult2);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_khaa);


            } else if (view.getId() == R.id.btn_option4 && v.getId() == R.id.lnr_result4) {
                btnOption((LinearLayout) v, view, btnResult4, lnrResult4);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_khi);


            } else if (view.getId() == R.id.btn_option5 && v.getId() == R.id.lnr_result5) {
                btnOption((LinearLayout) v, view, btnResult5, lnrResult5);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_khea);


            } else if (view.getId() == R.id.btn_option6 && v.getId() == R.id.lnr_result6) {
                btnOption((LinearLayout) v, view, btnResult6, lnrResult6);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_kho);
                mediaAalii();


            } else if (view.getId() == R.id.btn_option3 && v.getId() == R.id.lnr_result3) {
                btnOption((LinearLayout) v, view, btnResult3, lnrResult3);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_khoo);


            } else {
                mediaWrong();
            }

        } else if (newId == 23) {
            if (view.getId() == R.id.btn_option && v.getId() == R.id.lnr_result) {
                btnOption((LinearLayout) v, view, btnResult, lnrResult);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_ggha);


            } else if (view.getId() == R.id.btn_option2 && v.getId() == R.id.lnr_result2) {
                btnOption((LinearLayout) v, view, btnResult2, lnrResult2);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_gghaa);


            } else if (view.getId() == R.id.btn_option4 && v.getId() == R.id.lnr_result4) {
                btnOption((LinearLayout) v, view, btnResult4, lnrResult4);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_gghi);


            } else if (view.getId() == R.id.btn_option5 && v.getId() == R.id.lnr_result5) {
                btnOption((LinearLayout) v, view, btnResult5, lnrResult5);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_gghea);


            } else if (view.getId() == R.id.btn_option6 && v.getId() == R.id.lnr_result6) {
                btnOption((LinearLayout) v, view, btnResult6, lnrResult6);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_ggho);
                mediaAfarin(R.raw.afarin);


            } else if (view.getId() == R.id.btn_option3 && v.getId() == R.id.lnr_result3) {
                btnOption((LinearLayout) v, view, btnResult3, lnrResult3);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_gghoo);


            } else {
                mediaWrong();
            }

        } else if (newId == 67) {
            if (view.getId() == R.id.btn_option && v.getId() == R.id.lnr_result) {
                btnOption((LinearLayout) v, view, btnResult, lnrResult);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_la);


            } else if (view.getId() == R.id.btn_option2 && v.getId() == R.id.lnr_result2) {
                btnOption((LinearLayout) v, view, btnResult2, lnrResult2);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_laa);


            } else if (view.getId() == R.id.btn_option4 && v.getId() == R.id.lnr_result4) {
                btnOption((LinearLayout) v, view, btnResult4, lnrResult4);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_li);


            } else if (view.getId() == R.id.btn_option5 && v.getId() == R.id.lnr_result5) {
                btnOption((LinearLayout) v, view, btnResult5, lnrResult5);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_lea);


            } else if (view.getId() == R.id.btn_option6 && v.getId() == R.id.lnr_result6) {
                btnOption((LinearLayout) v, view, btnResult6, lnrResult6);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_lo);
                mediaAalii();


            } else if (view.getId() == R.id.btn_option3 && v.getId() == R.id.lnr_result3) {
                btnOption((LinearLayout) v, view, btnResult3, lnrResult3);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_loo);


            } else {
                mediaWrong();
            }

        } else if (newId == 68) {
            if (view.getId() == R.id.btn_option && v.getId() == R.id.lnr_result) {
                btnOption((LinearLayout) v, view, btnResult, lnrResult);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_ja);


            } else if (view.getId() == R.id.btn_option2 && v.getId() == R.id.lnr_result2) {
                btnOption((LinearLayout) v, view, btnResult2, lnrResult2);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_jaa);


            } else if (view.getId() == R.id.btn_option4 && v.getId() == R.id.lnr_result4) {
                btnOption((LinearLayout) v, view, btnResult4, lnrResult4);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_ji);


            } else if (view.getId() == R.id.btn_option5 && v.getId() == R.id.lnr_result5) {
                btnOption((LinearLayout) v, view, btnResult5, lnrResult5);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_jea);


            } else if (view.getId() == R.id.btn_option6 && v.getId() == R.id.lnr_result6) {
                btnOption((LinearLayout) v, view, btnResult6, lnrResult6);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_jo);
                mediaAalii();


            } else if (view.getId() == R.id.btn_option3 && v.getId() == R.id.lnr_result3) {
                btnOption((LinearLayout) v, view, btnResult3, lnrResult3);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_joo);


            } else {
                mediaWrong();
            }

        } else if (newId == 70) {
            if (view.getId() == R.id.btn_option && v.getId() == R.id.lnr_result) {
                btnOption((LinearLayout) v, view, btnResult, lnrResult);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_ha);


            } else if (view.getId() == R.id.btn_option2 && v.getId() == R.id.lnr_result2) {
                btnOption((LinearLayout) v, view, btnResult2, lnrResult2);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_haa);


            } else if (view.getId() == R.id.btn_option4 && v.getId() == R.id.lnr_result4) {
                btnOption((LinearLayout) v, view, btnResult4, lnrResult4);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_hi);


            } else if (view.getId() == R.id.btn_option5 && v.getId() == R.id.lnr_result5) {
                btnOption((LinearLayout) v, view, btnResult5, lnrResult5);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_hea);


            } else if (view.getId() == R.id.btn_option6 && v.getId() == R.id.lnr_result6) {
                btnOption((LinearLayout) v, view, btnResult6, lnrResult6);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_ho);
                mediaAfarin(R.raw.afarin);


            } else if (view.getId() == R.id.btn_option3 && v.getId() == R.id.lnr_result3) {
                btnOption((LinearLayout) v, view, btnResult3, lnrResult3);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_hoo);


            } else {
                mediaWrong();
            }

        } else if (newId == 71) {
            if (view.getId() == R.id.btn_option && v.getId() == R.id.lnr_result) {
                btnOption((LinearLayout) v, view, btnResult, lnrResult);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_cha);


            } else if (view.getId() == R.id.btn_option2 && v.getId() == R.id.lnr_result2) {
                btnOption((LinearLayout) v, view, btnResult2, lnrResult2);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_chaa);


            } else if (view.getId() == R.id.btn_option4 && v.getId() == R.id.lnr_result4) {
                btnOption((LinearLayout) v, view, btnResult4, lnrResult4);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_chi);


            } else if (view.getId() == R.id.btn_option5 && v.getId() == R.id.lnr_result5) {
                btnOption((LinearLayout) v, view, btnResult5, lnrResult5);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_chea);


            } else if (view.getId() == R.id.btn_option6 && v.getId() == R.id.lnr_result6) {
                btnOption((LinearLayout) v, view, btnResult6, lnrResult6);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_cho);
                mediaAfarin(R.raw.afarin);


            } else if (view.getId() == R.id.btn_option3 && v.getId() == R.id.lnr_result3) {
                btnOption((LinearLayout) v, view, btnResult3, lnrResult3);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_choo);


            } else {
                mediaWrong();
            }

        } else if (newId == 72) {
            if (view.getId() == R.id.btn_option && v.getId() == R.id.lnr_result) {
                btnOption((LinearLayout) v, view, btnResult, lnrResult);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_zha);


            } else if (view.getId() == R.id.btn_option2 && v.getId() == R.id.lnr_result2) {
                btnOption((LinearLayout) v, view, btnResult2, lnrResult2);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_zhaa);


            } else if (view.getId() == R.id.btn_option4 && v.getId() == R.id.lnr_result4) {
                btnOption((LinearLayout) v, view, btnResult4, lnrResult4);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_zhi);


            } else if (view.getId() == R.id.btn_option5 && v.getId() == R.id.lnr_result5) {
                btnOption((LinearLayout) v, view, btnResult5, lnrResult5);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_zhea);


            } else if (view.getId() == R.id.btn_option6 && v.getId() == R.id.lnr_result6) {
                btnOption((LinearLayout) v, view, btnResult6, lnrResult6);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_zho);
                mediaAalii();


            } else if (view.getId() == R.id.btn_option3 && v.getId() == R.id.lnr_result3) {
                btnOption((LinearLayout) v, view, btnResult3, lnrResult3);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_zhoo);


            } else {
                mediaWrong();
            }

        } else if (newId == 75) {
            if (view.getId() == R.id.btn_option && v.getId() == R.id.lnr_result) {
                btnOption((LinearLayout) v, view, btnResult, lnrResult);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_sa);


            } else if (view.getId() == R.id.btn_option2 && v.getId() == R.id.lnr_result2) {
                btnOption((LinearLayout) v, view, btnResult2, lnrResult2);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_saa);


            } else if (view.getId() == R.id.btn_option4 && v.getId() == R.id.lnr_result4) {
                btnOption((LinearLayout) v, view, btnResult4, lnrResult4);
                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_si);


            } else if (view.getId() == R.id.btn_option5 && v.getId() == R.id.lnr_result5) {
                btnOption((LinearLayout) v, view, btnResult5, lnrResult5);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_sea);


            } else if (view.getId() == R.id.btn_option6 && v.getId() == R.id.lnr_result6) {
                btnOption((LinearLayout) v, view, btnResult6, lnrResult6);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_so);
                mediaAalii();

            } else if (view.getId() == R.id.btn_option3 && v.getId() == R.id.lnr_result3) {
                btnOption((LinearLayout) v, view, btnResult3, lnrResult3);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_soo);


            } else {
                mediaWrong();
            }

        } else if (newId == 76) {
            if (view.getId() == R.id.btn_option && v.getId() == R.id.lnr_result) {
                btnOption((LinearLayout) v, view, btnResult, lnrResult);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_za);


            } else if (view.getId() == R.id.btn_option2 && v.getId() == R.id.lnr_result2) {
                btnOption((LinearLayout) v, view, btnResult2, lnrResult2);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_zaa);


            } else if (view.getId() == R.id.btn_option4 && v.getId() == R.id.lnr_result4) {
                btnOption((LinearLayout) v, view, btnResult4, lnrResult4);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_zi);


            } else if (view.getId() == R.id.btn_option5 && v.getId() == R.id.lnr_result5) {
                btnOption((LinearLayout) v, view, btnResult5, lnrResult5);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_zea);


            } else if (view.getId() == R.id.btn_option6 && v.getId() == R.id.lnr_result6) {
                btnOption((LinearLayout) v, view, btnResult6, lnrResult6);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_zo);
                mediaAalii();


            } else if (view.getId() == R.id.btn_option3 && v.getId() == R.id.lnr_result3) {
                btnOption((LinearLayout) v, view, btnResult3, lnrResult3);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_zoo);


            } else {
                mediaWrong();
            }

        } else if (newId == 77) {
            if (view.getId() == R.id.btn_option && v.getId() == R.id.lnr_result) {
                btnOption((LinearLayout) v, view, btnResult, lnrResult);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_a);


            } else if (view.getId() == R.id.btn_option2 && v.getId() == R.id.lnr_result2) {
                btnOption((LinearLayout) v, view, btnResult2, lnrResult2);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_aa);


            } else if (view.getId() == R.id.btn_option4 && v.getId() == R.id.lnr_result4) {
                btnOption((LinearLayout) v, view, btnResult4, lnrResult4);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_ii);


            } else if (view.getId() == R.id.btn_option5 && v.getId() == R.id.lnr_result5) {
                btnOption((LinearLayout) v, view, btnResult5, lnrResult5);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_ea);


            } else if (view.getId() == R.id.btn_option6 && v.getId() == R.id.lnr_result6) {
                btnOption((LinearLayout) v, view, btnResult6, lnrResult6);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_o);
                mediaAfarin(R.raw.afarin);


            } else if (view.getId() == R.id.btn_option3 && v.getId() == R.id.lnr_result3) {
                btnOption((LinearLayout) v, view, btnResult3, lnrResult3);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_oo);


            } else {
                mediaWrong();
            }

        } else if (newId == 78) {
            if (view.getId() == R.id.btn_option && v.getId() == R.id.lnr_result) {
                btnOption((LinearLayout) v, view, btnResult, lnrResult);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_sa);


            } else if (view.getId() == R.id.btn_option2 && v.getId() == R.id.lnr_result2) {
                btnOption((LinearLayout) v, view, btnResult2, lnrResult2);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_saa);


            } else if (view.getId() == R.id.btn_option4 && v.getId() == R.id.lnr_result4) {
                btnOption((LinearLayout) v, view, btnResult4, lnrResult4);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_si);


            } else if (view.getId() == R.id.btn_option5 && v.getId() == R.id.lnr_result5) {
                btnOption((LinearLayout) v, view, btnResult5, lnrResult5);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_sea);


            } else if (view.getId() == R.id.btn_option6 && v.getId() == R.id.lnr_result6) {
                btnOption((LinearLayout) v, view, btnResult6, lnrResult6);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_so);
                mediaAfarin(R.raw.afarin);


            } else if (view.getId() == R.id.btn_option3 && v.getId() == R.id.lnr_result3) {
                btnOption((LinearLayout) v, view, btnResult3, lnrResult3);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_soo);


            } else {
                mediaWrong();
            }

        } else if (newId == 79) {
            if (view.getId() == R.id.btn_option && v.getId() == R.id.lnr_result) {
                btnOption((LinearLayout) v, view, btnResult, lnrResult);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_ha);


            } else if (view.getId() == R.id.btn_option2 && v.getId() == R.id.lnr_result2) {
                btnOption((LinearLayout) v, view, btnResult2, lnrResult2);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_haa);


            } else if (view.getId() == R.id.btn_option4 && v.getId() == R.id.lnr_result4) {
                btnOption((LinearLayout) v, view, btnResult4, lnrResult4);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_hi);


            } else if (view.getId() == R.id.btn_option5 && v.getId() == R.id.lnr_result5) {
                btnOption((LinearLayout) v, view, btnResult5, lnrResult5);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_hea);


            } else if (view.getId() == R.id.btn_option6 && v.getId() == R.id.lnr_result6) {
                btnOption((LinearLayout) v, view, btnResult6, lnrResult6);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_ho);
                mediaAalii();


            } else if (view.getId() == R.id.btn_option3 && v.getId() == R.id.lnr_result3) {
                btnOption((LinearLayout) v, view, btnResult3, lnrResult3);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_hoo);


            } else {
                mediaWrong();
            }

        } else if (newId == 80) {
            if (view.getId() == R.id.btn_option && v.getId() == R.id.lnr_result) {
                btnOption((LinearLayout) v, view, btnResult, lnrResult);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_za);


            } else if (view.getId() == R.id.btn_option2 && v.getId() == R.id.lnr_result2) {
                btnOption((LinearLayout) v, view, btnResult2, lnrResult2);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_zaa);


            } else if (view.getId() == R.id.btn_option4 && v.getId() == R.id.lnr_result4) {
                btnOption((LinearLayout) v, view, btnResult4, lnrResult4);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_zi);


            } else if (view.getId() == R.id.btn_option5 && v.getId() == R.id.lnr_result5) {
                btnOption((LinearLayout) v, view, btnResult5, lnrResult5);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_zea);


            } else if (view.getId() == R.id.btn_option6 && v.getId() == R.id.lnr_result6) {
                btnOption((LinearLayout) v, view, btnResult6, lnrResult6);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_zo);
                mediaAfarin(R.raw.afarin);


            } else if (view.getId() == R.id.btn_option3 && v.getId() == R.id.lnr_result3) {
                btnOption((LinearLayout) v, view, btnResult3, lnrResult3);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_zoo);


            } else {
                mediaWrong();
            }

        } else if (newId == 81) {
            if (view.getId() == R.id.btn_option && v.getId() == R.id.lnr_result) {
                btnOption((LinearLayout) v, view, btnResult, lnrResult);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_ta);


            } else if (view.getId() == R.id.btn_option2 && v.getId() == R.id.lnr_result2) {
                btnOption((LinearLayout) v, view, btnResult2, lnrResult2);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_taa);


            } else if (view.getId() == R.id.btn_option4 && v.getId() == R.id.lnr_result4) {
                btnOption((LinearLayout) v, view, btnResult4, lnrResult4);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_ti);


            } else if (view.getId() == R.id.btn_option5 && v.getId() == R.id.lnr_result5) {
                btnOption((LinearLayout) v, view, btnResult5, lnrResult5);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_tea);


            } else if (view.getId() == R.id.btn_option6 && v.getId() == R.id.lnr_result6) {
                btnOption((LinearLayout) v, view, btnResult6, lnrResult6);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_to);
                mediaAalii();


            } else if (view.getId() == R.id.btn_option3 && v.getId() == R.id.lnr_result3) {
                btnOption((LinearLayout) v, view, btnResult3, lnrResult3);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_too);


            } else {
                mediaWrong();
            }

        } else if (newId == 82) {
            if (view.getId() == R.id.btn_option && v.getId() == R.id.lnr_result) {
                btnOption((LinearLayout) v, view, btnResult, lnrResult);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_ga);


            } else if (view.getId() == R.id.btn_option2 && v.getId() == R.id.lnr_result2) {
                btnOption((LinearLayout) v, view, btnResult2, lnrResult2);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_gaa);


            } else if (view.getId() == R.id.btn_option4 && v.getId() == R.id.lnr_result4) {
                btnOption((LinearLayout) v, view, btnResult4, lnrResult4);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_gi);


            } else if (view.getId() == R.id.btn_option5 && v.getId() == R.id.lnr_result5) {
                btnOption((LinearLayout) v, view, btnResult5, lnrResult5);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_gea);


            } else if (view.getId() == R.id.btn_option6 && v.getId() == R.id.lnr_result6) {
                btnOption((LinearLayout) v, view, btnResult6, lnrResult6);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_go);
                mediaAfarin(R.raw.afarin);


            } else if (view.getId() == R.id.btn_option3 && v.getId() == R.id.lnr_result3) {
                btnOption((LinearLayout) v, view, btnResult3, lnrResult3);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_goo);


            } else {
                mediaWrong();
            }

        } else if (newId == 83) {
            if (view.getId() == R.id.btn_option && v.getId() == R.id.lnr_result) {
                btnOption((LinearLayout) v, view, btnResult, lnrResult);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_za);


            } else if (view.getId() == R.id.btn_option2 && v.getId() == R.id.lnr_result2) {
                btnOption((LinearLayout) v, view, btnResult2, lnrResult2);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_zaa);


            } else if (view.getId() == R.id.btn_option4 && v.getId() == R.id.lnr_result4) {
                btnOption((LinearLayout) v, view, btnResult4, lnrResult4);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_zi);


            } else if (view.getId() == R.id.btn_option5 && v.getId() == R.id.lnr_result5) {
                btnOption((LinearLayout) v, view, btnResult5, lnrResult5);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_zea);


            } else if (view.getId() == R.id.btn_option6 && v.getId() == R.id.lnr_result6) {
                btnOption((LinearLayout) v, view, btnResult6, lnrResult6);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_zo);
                mediaAfarin(R.raw.afarin);


            } else if (view.getId() == R.id.btn_option3 && v.getId() == R.id.lnr_result3) {
                btnOption((LinearLayout) v, view, btnResult3, lnrResult3);

                mediaOk(R.raw.ok);
                wordPronunciation(R.raw.tarkib_zoo);


            } else {
                mediaWrong();
            }

        }
    }


}
