package com.p.alphabetforkids.Activity;

import androidx.appcompat.app.AppCompatActivity;
import pl.droidsonroids.gif.GifImageView;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.ClipData;
import android.content.DialogInterface;
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

public class ActivityBuildWord extends AppCompatActivity {

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


        findView();
        onClickMethod();
        changeWordsInTable();
        settingTouchAndDragListenerForButtons();

    }


    public void changeWordsInTable() {
        if (myId == 2) {
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
            txtMainWord.setText(" اَ    َ");

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
        }


    }

    @SuppressLint("ClickableViewAccessibility")
    public void settingTouchAndDragListenerForButtons() {
        if (myId == 2 | myId == 3 | myId == 4 | myId == 5 | myId == 6 || myId == 7 | myId == 8 | myId == 9 | myId == 10 | myId == 11 | myId == 12 | myId == 13 | myId == 14 | myId == 15
                | myId == 16 | myId == 17 | myId == 18 | myId == 19 | myId == 20 | myId == 21 | myId == 22 | myId == 23) {
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
        if (myId == 2) {
            if (view.getId() == R.id.option4 && v.getId() == R.id.lnr1) {
                oldAndNewParent((LinearLayout) v, view, btnResult1, lnr1);
                mediaOk(R.raw.ok);
                sharedPref();
                intValueMethod();


            } else if (view.getId() == R.id.option2 && v.getId() == R.id.lnr2) {
                oldAndNewParent((LinearLayout) v, view, btnResult2, lnr2);
                mediaOk(R.raw.ok);
                sharedPref();
                intValueMethod();


            } else if (view.getId() == R.id.option3 | view.getId() == R.id.option6 && v.getId() == R.id.lnr6) {
                oldAndNewParent((LinearLayout) v, view, btnResult6, lnr6);
                mediaOk(R.raw.ok);
                sharedPref();
                intValueMethod();

            } else if (view.getId() == R.id.option1 | view.getId() == R.id.option5 && v.getId() == R.id.lnr7) {
                oldAndNewParent((LinearLayout) v, view, btnResult7, lnr7);
                mediaOk(R.raw.ok);
                sharedPref();
                intValueMethod();

            } else if (view.getId() == R.id.option1 | view.getId() == R.id.option5 && v.getId() == R.id.lnr9) {
                oldAndNewParent((LinearLayout) v, view, btnResult9, lnr9);
                mediaOk(R.raw.ok);
                sharedPref();
                intValueMethod();

            } else if (view.getId() == R.id.option3 | view.getId() == R.id.option6 && v.getId() == R.id.lnr8) {
                oldAndNewParent((LinearLayout) v, view, btnResult8, lnr8);
                mediaOk(R.raw.ok);
                sharedPref();
                intValueMethod();

            } else {
                mediaOk(R.raw.wrong);
            }

        } else if (myId == 3) {
            if (view.getId() == R.id.option2 && v.getId() == R.id.lnr1) {
                oldAndNewParent((LinearLayout) v, view, btnResult1, lnr1);
                mediaOk(R.raw.ok);
                sharedPref();
                if (intValue == 4) {
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


            } else if (view.getId() == R.id.option1 | view.getId() == R.id.option3 | view.getId() == R.id.option5 && v.getId() == R.id.lnr2) {
                oldAndNewParent((LinearLayout) v, view, btnResult2, lnr2);
                mediaOk(R.raw.ok);
                sharedPref();
                if (intValue == 4) {
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


            } else if (view.getId() == R.id.option1 | view.getId() == R.id.option3 | view.getId() == R.id.option5 && v.getId() == R.id.lnr6) {
                oldAndNewParent((LinearLayout) v, view, btnResult6, lnr6);
                mediaOk(R.raw.ok);
                sharedPref();
                if (intValue == 4) {
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


            } else if (view.getId() == R.id.option1 | view.getId() == R.id.option3 | view.getId() == R.id.option5 && v.getId() == R.id.lnr8) {
                oldAndNewParent((LinearLayout) v, view, btnResult8, lnr8);
                mediaOk(R.raw.ok);
                sharedPref();
                if (intValue == 4) {
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


            } else if (view.getId() == R.id.option4 && v.getId() == R.id.lnr7) {
                oldAndNewParent((LinearLayout) v, view, btnResult7, lnr7);
                mediaOk(R.raw.ok);
                sharedPref();
                if (intValue == 4) {
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


            } else {
                mediaOk(R.raw.wrong);
            }


        } else if (myId == 4) {
            if (view.getId() == R.id.option3 && v.getId() == R.id.lnr1) {
                oldAndNewParent((LinearLayout) v, view, btnResult1, lnr1);
                mediaOk(R.raw.ok);
                sharedPref();
                if (intValue == 6) {
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


            } else if (view.getId() == R.id.option4 && v.getId() == R.id.lnr2) {
                oldAndNewParent((LinearLayout) v, view, btnResult2, lnr2);
                mediaOk(R.raw.ok);
                sharedPref();
                if (intValue == 6) {
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


            } else if (view.getId() == R.id.option1 | view.getId() == R.id.option5 && v.getId() == R.id.lnr3) {
                oldAndNewParent((LinearLayout) v, view, btnResult3, lnr3);
                mediaOk(R.raw.ok);
                sharedPref();
                if (intValue == 6) {
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


            } else if (view.getId() == R.id.option6 && v.getId() == R.id.lnr6) {
                oldAndNewParent((LinearLayout) v, view, btnResult6, lnr6);
                mediaOk(R.raw.ok);
                sharedPref();
                if (intValue == 6) {
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


            } else if (view.getId() == R.id.option1 | view.getId() == R.id.option5 && v.getId() == R.id.lnr7) {
                oldAndNewParent((LinearLayout) v, view, btnResult7, lnr7);
                mediaOk(R.raw.ok);
                sharedPref();
                if (intValue == 6) {
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


            } else if (view.getId() == R.id.option7 && v.getId() == R.id.lnr8) {
                oldAndNewParent((LinearLayout) v, view, btnResult8, lnr8);
                mediaOk(R.raw.ok);
                sharedPref();
                if (intValue == 6) {
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


            } else if (view.getId() == R.id.option2 && v.getId() == R.id.lnr9) {
                oldAndNewParent((LinearLayout) v, view, btnResult9, lnr9);
                mediaOk(R.raw.ok);
                sharedPref();
                if (intValue == 6) {
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


            } else {
                mediaOk(R.raw.wrong);
            }


        } else if (myId == 5) {
            if (view.getId() == R.id.option6 && v.getId() == R.id.lnr1) {
                oldAndNewParent((LinearLayout) v, view, btnResult1, lnr1);
                mediaOk(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
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


            } else if (view.getId() == R.id.option8 && v.getId() == R.id.lnr2) {
                oldAndNewParent((LinearLayout) v, view, btnResult2, lnr2);
                mediaOk(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
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


            } else if (view.getId() == R.id.option7 && v.getId() == R.id.lnr3) {
                oldAndNewParent((LinearLayout) v, view, btnResult3, lnr3);
                mediaOk(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
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


            } else if (view.getId() == R.id.option3 | view.getId() == R.id.option9 && v.getId() == R.id.lnr4) {
                oldAndNewParent((LinearLayout) v, view, btnResult4, lnr4);
                mediaOk(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
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


            } else if (view.getId() == R.id.option5 && v.getId() == R.id.lnr6) {
                oldAndNewParent((LinearLayout) v, view, btnResult6, lnr6);
                mediaOk(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
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


            } else if (view.getId() == R.id.option1 | view.getId() == R.id.option4 && v.getId() == R.id.lnr7) {
                oldAndNewParent((LinearLayout) v, view, btnResult7, lnr7);
                mediaOk(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
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


            } else if (view.getId() == R.id.option3 | view.getId() == R.id.option9 && v.getId() == R.id.lnr8) {
                oldAndNewParent((LinearLayout) v, view, btnResult8, lnr8);
                mediaOk(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
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


            } else if (view.getId() == R.id.option1 | view.getId() == R.id.option4 && v.getId() == R.id.lnr9) {
                oldAndNewParent((LinearLayout) v, view, btnResult9, lnr9);
                mediaOk(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
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


            } else if (view.getId() == R.id.option2 && v.getId() == R.id.lnr10) {
                oldAndNewParent((LinearLayout) v, view, btnResult10, lnr10);
                mediaOk(R.raw.ok);
                sharedPref();
                if (intValue == 8) {
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


            } else {
                mediaOk(R.raw.wrong);
            }


        } else if (myId == 6) {
            if (view.getId() == R.id.option4 && v.getId() == R.id.lnr1) {
                oldAndNewParent((LinearLayout) v, view, btnResult1, lnr1);
                mediaOk(R.raw.ok);
                sharedPref();
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


            } else if (view.getId() == R.id.option6 | view.getId() == R.id.option7 && v.getId() == R.id.lnr2) {
                oldAndNewParent((LinearLayout) v, view, btnResult2, lnr2);
                mediaOk(R.raw.ok);
                sharedPref();
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


            } else if (view.getId() == R.id.option5 && v.getId() == R.id.lnr3) {
                oldAndNewParent((LinearLayout) v, view, btnResult3, lnr3);
                mediaOk(R.raw.ok);
                sharedPref();
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


            } else if (view.getId() == R.id.option6 | view.getId() == R.id.option7 && v.getId() == R.id.lnr4) {
                oldAndNewParent((LinearLayout) v, view, btnResult4, lnr4);
                mediaOk(R.raw.ok);
                sharedPref();
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


            } else if (view.getId() == R.id.option3 | view.getId() == R.id.option8 && v.getId() == R.id.lnr5) {
                oldAndNewParent((LinearLayout) v, view, btnResult5, lnr5);
                mediaOk(R.raw.ok);
                sharedPref();
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


            } else if (view.getId() == R.id.option3 | view.getId() == R.id.option8 && v.getId() == R.id.lnr6) {
                oldAndNewParent((LinearLayout) v, view, btnResult6, lnr6);
                mediaOk(R.raw.ok);
                sharedPref();
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


            } else if (view.getId() == R.id.option1 && v.getId() == R.id.lnr7) {
                oldAndNewParent((LinearLayout) v, view, btnResult7, lnr7);
                mediaOk(R.raw.ok);
                sharedPref();
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


            } else if (view.getId() == R.id.option2 && v.getId() == R.id.lnr8) {
                oldAndNewParent((LinearLayout) v, view, btnResult8, lnr8);
                mediaOk(R.raw.ok);
                sharedPref();
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


            } else {
                mediaOk(R.raw.wrong);
            }


        } else if (myId == 7) {
            if (view.getId() == R.id.option3 && v.getId() == R.id.lnr1) {
                oldAndNewParent((LinearLayout) v, view, btnResult1, lnr1);
                mediaOk(R.raw.ok);
                sharedPref();
                if (intValue == 3) {
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


            } else if (view.getId() == R.id.option2 && v.getId() == R.id.lnr6) {
                oldAndNewParent((LinearLayout) v, view, btnResult6, lnr6);
                mediaOk(R.raw.ok);
                sharedPref();
                if (intValue == 3) {
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


            } else if (view.getId() == R.id.option4 && v.getId() == R.id.lnr7) {
                oldAndNewParent((LinearLayout) v, view, btnResult7, lnr7);
                mediaOk(R.raw.ok);
                sharedPref();
                if (intValue == 3) {
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


            } else if (view.getId() == R.id.option1 && v.getId() == R.id.lnr8) {
                oldAndNewParent((LinearLayout) v, view, btnResult8, lnr8);
                mediaOk(R.raw.ok);
                sharedPref();
                if (intValue == 3) {
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


            } else {
                mediaOk(R.raw.wrong);
            }

        } else if (myId == 8) {
            if (view.getId() == R.id.option4 | view.getId() == R.id.option6 && v.getId() == R.id.lnr1) {
                oldAndNewParent((LinearLayout) v, view, btnResult1, lnr1);
                mediaOk(R.raw.ok);
                sharedPref();
                if (intValue == 5) {
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


            } else if (view.getId() == R.id.option5 && v.getId() == R.id.lnr2) {
                oldAndNewParent((LinearLayout) v, view, btnResult2, lnr2);
                mediaOk(R.raw.ok);
                sharedPref();
                if (intValue == 5) {
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


            } else if (view.getId() == R.id.option3 && v.getId() == R.id.lnr3) {
                oldAndNewParent((LinearLayout) v, view, btnResult3, lnr3);
                mediaOk(R.raw.ok);
                sharedPref();
                if (intValue == 5) {
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


            } else if (view.getId() == R.id.option4 | view.getId() == R.id.option6 && v.getId() == R.id.lnr6) {
                oldAndNewParent((LinearLayout) v, view, btnResult6, lnr6);
                mediaOk(R.raw.ok);
                sharedPref();
                if (intValue == 5) {
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


            } else if (view.getId() == R.id.option2 && v.getId() == R.id.lnr7) {
                oldAndNewParent((LinearLayout) v, view, btnResult7, lnr7);
                mediaOk(R.raw.ok);
                sharedPref();
                if (intValue == 5) {
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


            } else if (view.getId() == R.id.option1 && v.getId() == R.id.lnr8) {
                oldAndNewParent((LinearLayout) v, view, btnResult8, lnr8);
                mediaOk(R.raw.ok);
                sharedPref();
                if (intValue == 5) {
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


            } else {
                mediaOk(R.raw.wrong);
            }

        } else if (myId == 9) {
            if (view.getId() == R.id.option6 && v.getId() == R.id.lnr1) {
                oldAndNewParent((LinearLayout) v, view, btnResult1, lnr1);
                mediaOk(R.raw.ok);
                sharedPref();
                if (intValue == 9) {
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


            } else if (view.getId() == R.id.option1 | view.getId() == R.id.option7 | view.getId() == R.id.option10 && v.getId() == R.id.lnr2) {
                oldAndNewParent((LinearLayout) v, view, btnResult2, lnr2);
                mediaOk(R.raw.ok);
                sharedPref();
                if (intValue == 9) {
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


            } else if (view.getId() == R.id.option5 && v.getId() == R.id.lnr3) {
                oldAndNewParent((LinearLayout) v, view, btnResult3, lnr3);
                mediaOk(R.raw.ok);
                sharedPref();
                if (intValue == 9) {
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


            } else if (view.getId() == R.id.option1 | view.getId() == R.id.option7 | view.getId() == R.id.option10 && v.getId() == R.id.lnr4) {
                oldAndNewParent((LinearLayout) v, view, btnResult4, lnr4);
                mediaOk(R.raw.ok);
                sharedPref();
                if (intValue == 9) {
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


            } else if (view.getId() == R.id.option9 | view.getId() == R.id.option3 && v.getId() == R.id.lnr5) {
                oldAndNewParent((LinearLayout) v, view, btnResult5, lnr5);
                mediaOk(R.raw.ok);
                sharedPref();
                if (intValue == 9) {
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


            } else if (view.getId() == R.id.option4 && v.getId() == R.id.lnr6) {
                oldAndNewParent((LinearLayout) v, view, btnResult6, lnr6);
                mediaOk(R.raw.ok);
                sharedPref();
                if (intValue == 9) {
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


            } else if (view.getId() == R.id.option2 && v.getId() == R.id.lnr7) {
                oldAndNewParent((LinearLayout) v, view, btnResult7, lnr7);
                mediaOk(R.raw.ok);
                sharedPref();
                if (intValue == 9) {
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


            } else if (view.getId() == R.id.option8 && v.getId() == R.id.lnr8) {
                oldAndNewParent((LinearLayout) v, view, btnResult8, lnr8);
                mediaOk(R.raw.ok);
                sharedPref();
                if (intValue == 9) {
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


            } else if (view.getId() == R.id.option1 | view.getId() == R.id.option7 | view.getId() == R.id.option10 && v.getId() == R.id.lnr9) {
                oldAndNewParent((LinearLayout) v, view, btnResult9, lnr9);
                mediaOk(R.raw.ok);
                sharedPref();
                if (intValue == 9) {
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


            } else if (view.getId() == R.id.option3 | view.getId() == R.id.option9 && v.getId() == R.id.lnr10) {
                oldAndNewParent((LinearLayout) v, view, btnResult10, lnr10);
                mediaOk(R.raw.ok);
                sharedPref();
                if (intValue == 9) {
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


            } else {
                mediaOk(R.raw.wrong);
            }

        } else if (myId == 10) {
            if (view.getId() == R.id.option3 | view.getId() == R.id.option8 && v.getId() == R.id.lnr1) {
                oldAndNewParent((LinearLayout) v, view, btnResult1, lnr1);
                mediaOk(R.raw.ok);
                sharedPref();
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
            } else if (view.getId() == R.id.option6 && v.getId() == R.id.lnr2) {
                oldAndNewParent((LinearLayout) v, view, btnResult2, lnr2);
                mediaOk(R.raw.ok);
                sharedPref();
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
            } else if (view.getId() == R.id.option7 && v.getId() == R.id.lnr3) {
                oldAndNewParent((LinearLayout) v, view, btnResult3, lnr3);
                mediaOk(R.raw.ok);
                sharedPref();
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
            } else if (view.getId() == R.id.option4 && v.getId() == R.id.lnr6) {
                oldAndNewParent((LinearLayout) v, view, btnResult6, lnr6);
                mediaOk(R.raw.ok);
                sharedPref();
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
            } else if (view.getId() == R.id.option5 && v.getId() == R.id.lnr7) {
                oldAndNewParent((LinearLayout) v, view, btnResult7, lnr7);
                mediaOk(R.raw.ok);
                sharedPref();
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
            } else if (view.getId() == R.id.option3 | view.getId() == R.id.option8 && v.getId() == R.id.lnr8) {
                oldAndNewParent((LinearLayout) v, view, btnResult8, lnr8);
                mediaOk(R.raw.ok);
                sharedPref();
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
            } else if (view.getId() == R.id.option2 && v.getId() == R.id.lnr9) {
                oldAndNewParent((LinearLayout) v, view, btnResult9, lnr9);
                mediaOk(R.raw.ok);
                sharedPref();
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
            } else if (view.getId() == R.id.option1 && v.getId() == R.id.lnr10) {
                oldAndNewParent((LinearLayout) v, view, btnResult10, lnr10);
                mediaOk(R.raw.ok);
                sharedPref();
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
            } else {
                mediaOk(R.raw.wrong);
            }

        } else if (myId == 11) {
            if (view.getId() == R.id.option1 && v.getId() == R.id.lnr1) {
                oldAndNewParent((LinearLayout) v, view, btnResult1, lnr1);
                mediaOk(R.raw.ok);
                sharedPref();
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
                    final AlertDialog.Builder builder = new AlertDialog.Builder(ActivityBuildWord.this);
                    builder.setMessage("گلم، ادامه تمرین این حرف رو انجام بده ");
                    builder.setCancelable(false);
                    builder.setPositiveButton("باشه", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {










//                            setContentView(R.layout.activity_build_word);
//                            findView();
//                            onClickMethod();

                            /*txtMainWord.setText("ایـ یـ ی ای");
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
                                    .into(imgLevelTwo);*/
                          //  settingTouchAndDragListenerForButtons();
                           /* if (view.getId() == R.id.option5 && v.getId() == R.id.lnr10) {
                                oldAndNewParent((LinearLayout) v, view, btnResult10, lnr10);
                                mediaOk(R.raw.ok);
                                sharedPref();
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


                            }*/


                        }
                    });
                    builder.setNegativeButton("نه", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            builder.setCancelable(true);

                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();


                }
            } else if (view.getId() == R.id.option8 && v.getId() == R.id.lnr2) {
                oldAndNewParent((LinearLayout) v, view, btnResult2, lnr2);
                mediaOk(R.raw.ok);
                sharedPref();
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
            } else if (view.getId() == R.id.option2 | view.getId() == R.id.option6 && v.getId() == R.id.lnr3) {
                oldAndNewParent((LinearLayout) v, view, btnResult3, lnr3);
                mediaOk(R.raw.ok);
                sharedPref();
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
            } else if (view.getId() == R.id.option7 && v.getId() == R.id.lnr4) {
                oldAndNewParent((LinearLayout) v, view, btnResult4, lnr4);
                mediaOk(R.raw.ok);
                sharedPref();
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
            } else if (view.getId() == R.id.option5 && v.getId() == R.id.lnr6) {
                oldAndNewParent((LinearLayout) v, view, btnResult6, lnr6);
                mediaOk(R.raw.ok);
                sharedPref();
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
            } else if (view.getId() == R.id.option4 && v.getId() == R.id.lnr7) {
                oldAndNewParent((LinearLayout) v, view, btnResult7, lnr7);
                mediaOk(R.raw.ok);
                sharedPref();
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
            } else if (view.getId() == R.id.option3 && v.getId() == R.id.lnr8) {
                oldAndNewParent((LinearLayout) v, view, btnResult8, lnr8);
                mediaOk(R.raw.ok);
                sharedPref();
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
            } else if (view.getId() == R.id.option2 | view.getId() == R.id.option6 && v.getId() == R.id.lnr9) {
                oldAndNewParent((LinearLayout) v, view, btnResult9, lnr9);
                mediaOk(R.raw.ok);
                sharedPref();
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
            } else {
                mediaOk(R.raw.wrong);
            }

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
        if (intValue == 5) {
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

    private void sharedPref() {
        intValue = sharedPreferences.getInt("intValue", 0);
        sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("intValue", intValue + 1);
        editor.apply();
    }

    private void mediaOk(int p) {
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
