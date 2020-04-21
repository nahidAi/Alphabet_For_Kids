package com.p.alphabetforkids.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.hujiaweibujidao.wava.Techniques;
import com.github.hujiaweibujidao.wava.YoYo;
import com.p.alphabetforkids.Model.ItemModel;
import com.p.alphabetforkids.R;
import com.p.alphabetforkids.database.MyDatabase;
import com.squareup.picasso.Picasso;

public class ActivityDetails extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    SharedPreferences sharedPreferences;

    ImageView imgBackRight, imgBackLeft, imgMusic, imgHome, imgPractice, img_one_example, img_two_example,
            img_three_example, img_end_example, imgOne, imgTwo, imgThree, imgEnd, imgReNew, imgMute, imgHomeToolbar, imgBack;

    TextView txtTop, txtFirstAlphabet, txtEndAlphabetWords, txtSecond_word, txtThird_word;

    private int myId, id_word_count, myRow;


    private String title, first_alphabet_word, end_alphabet_words, second_alphabet_words, third_alphabet_words, one_example,
            two_example, three_example, end_example, img_one, img_two, img_three, img_end, Poetry;

    boolean isMute = false;
    boolean isRenew = false;
    boolean soundTF;
    Handler handler;
    MyDatabase myDatabase;
    ItemModel itemModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getIntentMethod();
        findView();
        onClick();

        setTextMethod();
        switchMethod();


        sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
        // چک کردن شیرد پرفرنسز برای قطع صدا
        soundTF = sharedPreferences.getBoolean("isMuteSound", false);
        isMute = soundTF;
        if (soundTF == true) {
            mediaPlayer.stop();
            int myImgMuteZip = getResources().getIdentifier("muted", "drawable", getPackageName());
            imgMute.setImageResource(myImgMuteZip);
        }


        //فول اسکرین کردن صفحه
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


    }


    private void switchMethod() {

        switch (myId) {
            case 1:
                mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.a);
                mediaPlayer.start();
                break;
            case 2:
                mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.b);
                mediaPlayer.start();
                break;
            case 3:
                mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.aa);
                mediaPlayer.start();
                break;
            case 4:
                mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.d);
                mediaPlayer.start();
                break;
            case 5:
                mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.m);
                mediaPlayer.start();
                break;
            case 6:
                mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.sin);
                mediaPlayer.start();
                break;
            case 7:
                mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.ooo);
                mediaPlayer.start();
                break;
            case 8:
                mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.t);
                mediaPlayer.start();
                break;
            case 9:
                mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.r);
                mediaPlayer.start();
                break;
            case 10:
                mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.non);
                mediaPlayer.start();
                break;
            case 11:
                mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.ei);
                mediaPlayer.start();
                break;
            case 12:
                mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.z);
                mediaPlayer.start();
                break;
            case 13:
                mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.ea);
                mediaPlayer.start();
                break;
            case 14:
                mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.sh);
                mediaPlayer.start();
                break;
            case 15:
                mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.i);
                mediaPlayer.start();
                break;
            case 16:
                mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.o);
                mediaPlayer.start();
                break;
            case 17:
                mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.k);
                mediaPlayer.start();
                break;
            case 18:
                mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.v);
                mediaPlayer.start();
                break;
            case 19:
                mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.p);
                mediaPlayer.start();
                break;
            case 20:
                mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.ghaf);
                mediaPlayer.start();
                break;
            case 21:
                mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.f);
                mediaPlayer.start();
                break;
            case 22:
                mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.kh);
                mediaPlayer.start();
                break;
            case 23:
                mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.gh);
                mediaPlayer.start();
                break;
            case 67:
                mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.lam);
                mediaPlayer.start();
                break;
            case 68:
                mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.j);
                mediaPlayer.start();
                break;
            case 69:
                mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.oo);
                mediaPlayer.start();
                break;
            case 70:
                mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.he4);
                mediaPlayer.start();
                break;
            case 71:
                mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.ch);
                mediaPlayer.start();
                break;
            case 72:
                mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.zh);
                mediaPlayer.start();
                break;
            case 73:
                mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.kha);
                mediaPlayer.start();
                break;
            case 74:
                mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.tashdid);
                mediaPlayer.start();
                break;
            case 75:
                mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.sad);
                mediaPlayer.start();
                break;
            case 76:
                mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.zal);
                mediaPlayer.start();
                break;
            case 77:
                mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.ain);
                mediaPlayer.start();
                break;
            case 78:
                mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.ccc);
                mediaPlayer.start();
                break;
            case 79:
                mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.h);
                mediaPlayer.start();
                break;
            case 80:
                mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.zad);
                mediaPlayer.start();
                break;
            case 81:
                mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.ta);
                mediaPlayer.start();
                break;
            case 82:
                mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.ghain);
                mediaPlayer.start();
                break;
            case 83:
                mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.za);
                mediaPlayer.start();
                break;


        }


    }

    private void setTextMethod() {
        setTextForTitle(title);

        if (id_word_count == 4) {
            txtFirstAlphabet.setText(first_alphabet_word);
            txtEndAlphabetWords.setText(end_alphabet_words);
            txtSecond_word.setText(second_alphabet_words);
            txtThird_word.setText(third_alphabet_words);


            //  دادن انیمیشن به تکست
           /* handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (isRenew == true) {
                        YoYo.with(Techniques.Shake).duration(1200)
                                .playOn(txtFirstAlphabet)
                                .stop(true);
                    } else if (isRenew == false) {
                        YoYo.with(Techniques.Shake).duration(1200)
                                .playOn(txtFirstAlphabet);
                    }


                }
            }, 6000);


            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (isRenew == true) {
                        YoYo.with(Techniques.Shake).duration(1200)
                                .playOn(txtSecond_word)
                                .stop(true);
                    } else if (isRenew == false) {
                        YoYo.with(Techniques.Shake).duration(1200)
                                .playOn(txtSecond_word);
                    }


                }
            }, 10000);


            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (isRenew == true) {
                        YoYo.with(Techniques.Shake).duration(1200)
                                .playOn(txtThird_word)
                                .stop(true);
                    } else if (isRenew == false) {
                        YoYo.with(Techniques.Shake).duration(1200)
                                .playOn(txtThird_word);
                    }

                }
            }, 15000);


            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (isRenew == true) {
                        YoYo.with(Techniques.Shake).duration(1200)
                                .playOn(txtEndAlphabetWords)
                                .stop(true);
                    } else if (isRenew == false) {
                        YoYo.with(Techniques.Shake).duration(1200)
                                .playOn(txtEndAlphabetWords);
                    }

                }
            }, 21000);*/


            int id = getResources().getIdentifier(one_example, "drawable", getPackageName());
            int id_2 = getResources().getIdentifier(two_example, "drawable", getPackageName());
            int id_3 = getResources().getIdentifier(three_example, "drawable", getPackageName());
            int id_4 = getResources().getIdentifier(end_example, "drawable", getPackageName());
            Picasso
                    .with(getApplicationContext())
                    .load(id)
                    .into(img_one_example);
            Picasso
                    .with(getApplicationContext())
                    .load(id_2)
                    .into(img_two_example);
            Picasso
                    .with(getApplicationContext())
                    .load(id_3)
                    .into(img_three_example);
            Picasso
                    .with(getApplicationContext())
                    .load(id_4)
                    .into(img_end_example);


            int img_1 = getResources().getIdentifier(img_one, "drawable", getPackageName());
            int img_2 = getResources().getIdentifier(img_two, "drawable", getPackageName());
            int img_3 = getResources().getIdentifier(img_three, "drawable", getPackageName());
            int img_4 = getResources().getIdentifier(img_end, "drawable", getPackageName());
            Picasso
                    .with(getApplicationContext())
                    .load(img_1)
                    .into(imgOne);
            Picasso
                    .with(getApplicationContext())
                    .load(img_2)
                    .into(imgTwo);
            Picasso
                    .with(getApplicationContext())
                    .load(img_3)
                    .into(imgThree);
            Picasso
                    .with(getApplicationContext())
                    .load(img_4)
                    .into(imgEnd);


        } else if (id_word_count == 2) {
            txtFirstAlphabet.setText(first_alphabet_word);
            txtEndAlphabetWords.setText(end_alphabet_words);
            handler = new Handler();

           /* handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    if (isRenew == true) {
                        YoYo.with(Techniques.Shake).duration(1200)
                                .playOn(txtFirstAlphabet)
                                .stop(true);


                    } else if (isRenew == false) {
                        YoYo.with(Techniques.Shake).duration(1200)
                                .playOn(txtFirstAlphabet);
                    }

                }
            }, 6000);*/


           /* handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (isRenew == true) {
                        YoYo.with(Techniques.Shake).duration(1200)
                                .playOn(txtEndAlphabetWords)
                                .stop(true);


                    } else if (isRenew == false) {
                        YoYo.with(Techniques.Shake).duration(1200)
                                .playOn(txtEndAlphabetWords);

                    }


                }
            }, 10000);*/


            int id = getResources().getIdentifier(one_example, "drawable", getPackageName());
            int id_4 = getResources().getIdentifier(end_example, "drawable", getPackageName());
            Picasso
                    .with(getApplicationContext())
                    .load(id)
                    .into(img_one_example);
            Picasso
                    .with(getApplicationContext())
                    .load(id_4)
                    .into(img_end_example);

            int img_1 = getResources().getIdentifier(img_one, "drawable", getPackageName());
            int img_4 = getResources().getIdentifier(img_end, "drawable", getPackageName());
            Picasso
                    .with(getApplicationContext())
                    .load(img_1)
                    .into(imgOne);
            Picasso
                    .with(getApplicationContext())
                    .load(img_4)
                    .into(imgEnd);


        } else {
            if (myId == 74) {
                txtTop.setText(" ّ  ");
            }
            txtFirstAlphabet.setText(first_alphabet_word);


           /* handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (isRenew == true) {
                        YoYo.with(Techniques.Shake).duration(1200)
                                .playOn(txtFirstAlphabet)
                                .stop(true);
                    } else if (isRenew == false) {
                        YoYo.with(Techniques.Shake).duration(1200)
                                .playOn(txtFirstAlphabet);
                    }


                }
            }, 5000);*/

            int id = getResources().getIdentifier(one_example, "drawable", getPackageName());
            Picasso
                    .with(getApplicationContext())
                    .load(id)
                    .into(img_one_example);

            int img_1 = getResources().getIdentifier(img_one, "drawable", getPackageName());
            Picasso
                    .with(getApplicationContext())
                    .load(img_1)
                    .into(imgOne);
        }

    }

    private void getIntentMethod() {

        Bundle bundle = getIntent().getExtras();
        myId = Integer.parseInt(bundle.getString("id"));
        id_word_count = Integer.parseInt(bundle.getString("id_word_count"));
        myRow = Integer.parseInt(bundle.getString("row"));
        title = bundle.getString("title");
        first_alphabet_word = bundle.getString("first_alphabet_word");
        end_alphabet_words = bundle.getString("end_alphabet_words");
        second_alphabet_words = bundle.getString("second_alphabet_words");
        third_alphabet_words = bundle.getString("third_alphabet_words");


        one_example = bundle.getString("one_example");
        two_example = bundle.getString("two_example");
        three_example = bundle.getString("three_example");
        end_example = bundle.getString("four_example");

        img_one = bundle.getString("img_one");
        img_two = bundle.getString("img_two");
        img_three = bundle.getString("img_three");
        img_end = bundle.getString("img_end");
        Poetry = bundle.getString("Poetry");


        if (id_word_count == 1) {
            setContentView(R.layout.activity_details_for_one_word);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        }

        if (id_word_count == 2) {
            setContentView(R.layout.activity_details_for_two_word);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        } else if (id_word_count == 4) {
            setContentView(R.layout.activity_details_for_four_word);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        }


//////////////////////////////////////////////////////////////////////


    }

    public void findView() {
        imgBack = findViewById(R.id.imgBack);
        imgHomeToolbar = findViewById(R.id.imgMyHome);
        imgHomeToolbar.setVisibility(View.GONE);
        imgBackLeft = findViewById(R.id.back_left);
        imgBackRight = findViewById(R.id.back_rightt);
        imgMusic = findViewById(R.id.music);
        imgHome = findViewById(R.id.home);
        imgPractice = findViewById(R.id.img_practice);
        txtTop = findViewById(R.id.txt_top);
        txtFirstAlphabet = findViewById(R.id.txt_wordForFirstAlphabet);
        txtEndAlphabetWords = findViewById(R.id.txt_wordForEndAlphabet);
        txtSecond_word = findViewById(R.id.txt_secound_word);
        txtThird_word = findViewById(R.id.txt_third_word);
        img_one_example = findViewById(R.id.img_example_one);
        img_two_example = findViewById(R.id.img_example_two);
        img_three_example = findViewById(R.id.img_example_three);
        img_end_example = findViewById(R.id.img_example_end);

        imgOne = findViewById(R.id.img_one);
        imgTwo = findViewById(R.id.img_two);
        imgThree = findViewById(R.id.img_three);
        imgEnd = findViewById(R.id.img_end);

        imgReNew = findViewById(R.id.renew);
        imgMute = findViewById(R.id.mute);


    }

    public void onClick() {
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.click);
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
        imgBackLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
                if (myId == 23) {
                    myId = myId + 44;
                } else if (myId == 83) {
                    myId = 83;
                } else {
                    myId = myId + 1;
                }

                if (myId == 1 | myId == 2 | myId == 3 | myId == 5 | myId == 6 | myId == 7 | myId == 8 | myId == 10
                        | myId == 14 | myId == 15 | myId == 16 | myId == 17 | myId == 19
                        | myId == 20 | myId == 21 | myId == 22 | myId == 23 | myId == 67 | myId == 68 | myId == 71
                        | myId == 75 | myId == 78 | myId == 79 | myId == 80) {
                    id_word_count = 2;
                    setContentView(R.layout.activity_details_for_two_word);
                    getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);


                } else if (myId == 4 | myId == 9 | myId == 12 | myId == 18 | myId == 69 | myId == 72 | myId == 73
                        | myId == 74 | myId == 76 | myId == 81 | myId == 83) {
                    id_word_count = 1;
                    setContentView(R.layout.activity_details_for_one_word);
                    getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);


                } else if (myId == 11 | myId == 13 | myId == 70 | myId == 77 | myId == 82) {
                    id_word_count = 4;
                    setContentView(R.layout.activity_details_for_four_word);
                    getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

                }
                MediaPlayer mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.click);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });


                setting();


            }
        });
        imgBackRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();


                if (myId == 67) {
                    myId = myId - 44;
                } else if (myId == 1) {
                    myId = 1;
                } else {
                    myId = myId - 1;
                }

                if (myId == 1 | myId == 2 | myId == 3 | myId == 5 | myId == 6 | myId == 7 | myId == 8 | myId == 10
                        | myId == 14 | myId == 15 | myId == 16 | myId == 17 | myId == 19
                        | myId == 20 | myId == 21 | myId == 22 | myId == 23 | myId == 67 | myId == 68 | myId == 71
                        | myId == 75 | myId == 78 | myId == 79 | myId == 80) {
                    id_word_count = 2;
                    setContentView(R.layout.activity_details_for_two_word);
                    getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);


                } else if (myId == 4 | myId == 9 | myId == 12 | myId == 18 | myId == 69 | myId == 72 | myId == 73
                        | myId == 74 | myId == 76 | myId == 81 | myId == 83) {
                    id_word_count = 1;
                    setContentView(R.layout.activity_details_for_one_word);
                    getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);


                } else if (myId == 11 | myId == 13 | myId == 70 | myId == 77 | myId == 82) {
                    id_word_count = 4;
                    setContentView(R.layout.activity_details_for_four_word);
                    getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

                }
                MediaPlayer mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.click);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                setting();
            }
        });
        imgPractice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.click);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                Intent intent = new Intent(ActivityDetails.this, ActivityPractice.class);
                intent.putExtra("id", myId + "");
                intent.putExtra("row", myRow + "");
                startActivity(intent);
            }
        });
        imgHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.click);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                Intent intent = new Intent(ActivityDetails.this, ActivityAllAlphabet.class);
                startActivity(intent);
            }
        });
        imgMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.click);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                Intent intent = new Intent(ActivityDetails.this, ActivityMusic.class);
                intent.putExtra("id", myId + "");
                startActivity(intent);

            }
        });
        imgMute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isMute == false) {
                    int myImgMuteZip = getResources().getIdentifier("muted", "drawable", getPackageName());
                    imgMute.setImageResource(myImgMuteZip);
                    mediaPlayer.stop();
                    isMute = true;
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("isMuteSound", isMute);
                    editor.apply();
                    Toast toast = Toast.makeText(getApplicationContext(), "صدا رو قطع کردی :)", Toast.LENGTH_LONG);
                    View view = toast.getView();
                    view.setBackgroundResource(R.drawable.custom_toast);
                    toast.setView(view);
                    toast.show();

                } else if (isMute == true) {
                    int myImgMute = getResources().getIdentifier("smile", "drawable", getPackageName());
                    imgMute.setImageResource(myImgMute);
                    isMute = false;
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("isMuteSound", isMute);
                    editor.apply();
                    switchMethod();
                    setTextMethod();
                   // Toast.makeText(ActivityDetails.this, "در حال اجرا", Toast.LENGTH_SHORT).show();


                }


            }
        });
        imgReNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isRenew = true;
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                }
                handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        isRenew = false;

                    }
                }, 5000);


                if (isMute == false) {
                    setTextMethod();
                    switchMethod();
                }


            }
        });

    }

    @Override
    public void onPause() {
        super.onPause();
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            // System.exit(0);
        } else
            return;
    }

    // برای اینکه دکمه بک گوشی کار نکنه
   /* @Override
    public void onBackPressed() {

    }*/

    @Override
    public void onStop() {
        super.onStop();
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            // System.exit(0);
        } else
            return;
    }

    // دادن انیمیشن در رفتن از یک اکتیویتی به اکتیویتی دیگر
    @Override
    public void finish() {
        super.finish();
        // overridePendingTransition(R.anim.slide_out_right, R.anim.slide_in_left);
    }


    public void setting() {

        findView();
        soundTF = sharedPreferences.getBoolean("isMuteSound", false);
        isMute = soundTF;
        if (soundTF == true) {

            int myImgMuteZip = getResources().getIdentifier("muted", "drawable", getPackageName());
            imgMute.setImageResource(myImgMuteZip);
        }


        setTextForNewIdGoLeft();

        onClickForNewId();
        if (soundTF == true) {
            mediaPlayer.stop();
        } else {
            switchMethod();
        }


    }

    private void setTextForNewIdGoLeft() {
        if (myId == 1) {
            setTextForTitle("آ ا");
            txtFirstAlphabet.setText("آ");
            txtEndAlphabetWords.setText("ا");
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.snowman)
                    .into(imgOne);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.a_1)
                    .into(img_one_example);

            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.almond)
                    .into(imgEnd);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.a_2)
                    .into(img_end_example);
        }
        if (myId == 2) {
            setTextForTitle("بـ ب");
            txtFirstAlphabet.setText("بـ");
            txtEndAlphabetWords.setText("ب");
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.ballons)
                    .into(imgOne);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.b_1)
                    .into(img_one_example);

            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.books)
                    .into(imgEnd);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.b_2)
                    .into(img_end_example);
        }
        if (myId == 3) {
            setTextForTitle("اَ  َ");
            txtFirstAlphabet.setText("اَ");
            txtEndAlphabetWords.setText(" َ  ");
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.pomegranate)
                    .into(imgOne);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.aa_1)
                    .into(img_one_example);

            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.hand)
                    .into(imgEnd);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.aa_2)
                    .into(img_end_example);

        }
        if (myId == 4) {
            setTextForTitle("د");
            txtFirstAlphabet.setText("د");
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.christmas_tree)
                    .into(imgOne);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.d)
                    .into(img_one_example);


        }
        if (myId == 5) {
            setTextForTitle("مـ م");
            txtFirstAlphabet.setText("مـ");
            txtEndAlphabetWords.setText("م");
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.clown_fish)
                    .into(imgOne);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.m_1)
                    .into(img_one_example);

            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.almond)
                    .into(imgEnd);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.m_2)
                    .into(img_end_example);
        }
        if (myId == 6) {
            setTextForTitle("سـ س");
            txtFirstAlphabet.setText("سـ");
            txtEndAlphabetWords.setText("س");
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.apple)
                    .into(imgOne);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.cin_1)
                    .into(img_one_example);

            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.farming_and_gardening)
                    .into(imgEnd);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.cin_2)
                    .into(img_end_example);
        }
        if (myId == 7) {
            setTextForTitle("او  و");
            txtFirstAlphabet.setText("او");
            txtEndAlphabetWords.setText("و");
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.finger)
                    .into(imgOne);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.ooo_1)
                    .into(img_one_example);

            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.gazelle)
                    .into(imgEnd);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.ooo_2)
                    .into(img_end_example);
        }
        if (myId == 8) {
            setTextForTitle("تـ ت");
            txtFirstAlphabet.setText("تـ");
            txtEndAlphabetWords.setText("ت");
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.strawberry)
                    .into(imgOne);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.t_1)
                    .into(img_one_example);

            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.hand)
                    .into(imgEnd);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.t_2)
                    .into(img_end_example);
        }
        if (myId == 9) {
            setTextForTitle("ر");
            txtFirstAlphabet.setText("ر");

            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.fox)
                    .into(imgOne);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.r)
                    .into(img_one_example);


        }
        if (myId == 10) {
            setTextForTitle("نـ ن");
            txtFirstAlphabet.setText("نـ");
            txtEndAlphabetWords.setText("ن");
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.whale)
                    .into(imgOne);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.n_1)
                    .into(img_one_example);

            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.vase)
                    .into(imgEnd);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.n_2)
                    .into(img_end_example);
        }
        if (myId == 11) {
            setTextForTitle("ایـ یـ ی ای");
            txtFirstAlphabet.setText("ایـ");
            txtSecond_word.setText("یـ");
            txtThird_word.setText("ی");
            txtEndAlphabetWords.setText("ای");
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.iran)
                    .into(imgOne);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.ei_1)
                    .into(img_one_example);


            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.desk)
                    .into(imgTwo);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.ei_2)
                    .into(img_two_example);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.mini_donut)
                    .into(imgThree);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.ei_3)
                    .into(img_three_example);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.toast)
                    .into(imgEnd);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.ei_4)
                    .into(img_end_example);

        }
        if (myId == 12) {
            setTextForTitle("ز");
            txtFirstAlphabet.setText("ز");
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.bee)
                    .into(imgOne);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.z)
                    .into(img_one_example);
        }
        if (myId == 13) {
            setTextForTitle("اِ  ِ ـه ه");
            txtFirstAlphabet.setText("اِ");
            txtSecond_word.setText("ِ ");
            txtThird_word.setText("ـه");
            txtEndAlphabetWords.setText("ه");
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.food_and_restaurant)
                    .into(imgOne);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.ea_1)
                    .into(img_one_example);


            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.christmas_tree)
                    .into(imgTwo);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.ea_2)
                    .into(img_two_example);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.jelly)
                    .into(imgThree);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.ea_3)
                    .into(img_three_example);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.farm)
                    .into(imgEnd);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.ea_4)
                    .into(img_end_example);

        }
        if (myId == 14) {
            setTextForTitle("شـ ش");
            txtFirstAlphabet.setText("شـ");
            txtEndAlphabetWords.setText("ش");
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.candle)
                    .into(imgOne);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.sh_1)
                    .into(img_one_example);

            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.sneaker)
                    .into(imgEnd);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.sh_2)
                    .into(img_end_example);
        }
        if (myId == 15) {
            setTextForTitle("یـ ی");
            txtFirstAlphabet.setText("یـ");
            txtEndAlphabetWords.setText("ی");
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.thaw)
                    .into(imgOne);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.i)
                    .into(img_one_example);

            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.tea)
                    .into(imgEnd);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.i_2)
                    .into(img_end_example);
        }
        if (myId == 16) {
            setTextForTitle("اُ  ُ");
            txtFirstAlphabet.setText("اُ");
            txtEndAlphabetWords.setText(" ُ  ");
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.duckling)
                    .into(imgOne);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.o_1)
                    .into(img_one_example);

            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.flower)
                    .into(imgEnd);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.o_2)
                    .into(img_end_example);
        }
        if (myId == 17) {
            setTextForTitle("کـ ک");
            txtFirstAlphabet.setText("کـ");
            txtEndAlphabetWords.setText("ک");
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.books)
                    .into(imgOne);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.k_1)
                    .into(img_one_example);

            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.books)
                    .into(imgEnd);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.k_2)
                    .into(img_end_example);
        }
        if (myId == 18) {
            setTextForTitle("و");
            txtFirstAlphabet.setText("و");
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.baby_bath_tub)
                    .into(imgOne);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.v)
                    .into(img_one_example);
        }
        if (myId == 19) {
            setTextForTitle("پـ پ");
            txtFirstAlphabet.setText("پـ");
            txtEndAlphabetWords.setText("پ");
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.butterfly)
                    .into(imgOne);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.p_1)
                    .into(img_one_example);

            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.books)
                    .into(imgEnd);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.p_2)
                    .into(img_end_example);
        }
        if (myId == 20) {
            setTextForTitle("گـ گ");
            txtFirstAlphabet.setText("گـ");
            txtEndAlphabetWords.setText("گ");
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.flower)
                    .into(imgOne);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.ghaf_1)
                    .into(img_one_example);

            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.boil)
                    .into(imgEnd);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.ghaf_2)
                    .into(img_end_example);
        }
        if (myId == 21) {
            setTextForTitle("فـ ف");
            txtFirstAlphabet.setText("فـ");
            txtEndAlphabetWords.setText("ف");
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.elephant)
                    .into(imgOne);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.f_1)
                    .into(img_one_example);

            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.climate)
                    .into(imgEnd);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.f_2)
                    .into(img_end_example);
        }
        if (myId == 22) {
            setTextForTitle("خـ خ");
            txtFirstAlphabet.setText("خـ");
            txtEndAlphabetWords.setText("خ");
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.sun)
                    .into(imgOne);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.kh_1)
                    .into(img_one_example);

            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.insect)
                    .into(imgEnd);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.kh_2)
                    .into(img_end_example);
        }
        if (myId == 23) {
            setTextForTitle("قـ ق");
            txtFirstAlphabet.setText("قـ");
            txtEndAlphabetWords.setText("ق");
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.frog)
                    .into(imgOne);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.gh_1)
                    .into(img_one_example);

            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.boat)
                    .into(imgEnd);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.gh_2)
                    .into(img_end_example);
        }
        if (myId == 67) {
            setTextForTitle("لـ ل");
            txtFirstAlphabet.setText("لـ");
            txtEndAlphabetWords.setText("ل");
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.turtle)
                    .into(imgOne);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.l_1)
                    .into(img_one_example);

            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.construction_and_tools)
                    .into(imgEnd);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.l_2)
                    .into(img_end_example);
        }
        if (myId == 68) {
            setTextForTitle("جـ ج");
            txtFirstAlphabet.setText("جـ");
            txtEndAlphabetWords.setText("ج");
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.chick)
                    .into(imgOne);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.j_1)
                    .into(img_one_example);

            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.woodland)
                    .into(imgEnd);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.j_2)
                    .into(img_end_example);
        }
        if (myId == 69) {
            setTextForTitle("و--> ُ");
            txtFirstAlphabet.setText("و");
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.pen)
                    .into(imgOne);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.oo_1)
                    .into(img_one_example);
        }
        if (myId == 70) {
            setTextForTitle("هـ ـهـ ـه ه");
            txtFirstAlphabet.setText("هـ");
            txtSecond_word.setText("ـهـ");
            txtThird_word.setText("ـه");
            txtEndAlphabetWords.setText("ه");
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.carrot)
                    .into(imgOne);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.ha_1)
                    .into(img_one_example);


            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.moonlight)
                    .into(imgTwo);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.ha_2)
                    .into(img_two_example);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.home_yellow)
                    .into(imgThree);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.ha_3)
                    .into(img_three_example);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.moon_phase)
                    .into(imgEnd);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.ha_4)
                    .into(img_end_example);
        }
        if (myId == 71) {
            setTextForTitle("چـ چ");
            txtFirstAlphabet.setText("چـ");
            txtEndAlphabetWords.setText("چ");
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.grass)
                    .into(imgOne);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.ch_1)
                    .into(img_one_example);

            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.mushroom)
                    .into(imgEnd);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.ch_2)
                    .into(img_end_example);
        }
        if (myId == 72) {
            setTextForTitle("ژ");
            txtFirstAlphabet.setText("ژ");
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.jelly)
                    .into(imgOne);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.gh)
                    .into(img_one_example);
        }
        if (myId == 73) {
            setTextForTitle("خوا");
            txtFirstAlphabet.setText("خوا");
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.bed)
                    .into(imgOne);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.kha_1)
                    .into(img_one_example);
        }
        if (myId == 74) {
            setTextForTitle(" ّ ");
            txtFirstAlphabet.setText(" ّ  ");
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.art)
                    .into(imgOne);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.tashdid)
                    .into(img_one_example);
        }
        if (myId == 75) {
            setTextForTitle("صـ ص");
            txtFirstAlphabet.setText("صـ");
            txtEndAlphabetWords.setText("ص");
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.soap)
                    .into(imgOne);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.sad_1)
                    .into(img_one_example);

            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.fun)
                    .into(imgEnd);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.sad_2)
                    .into(img_end_example);
        }
        if (myId == 76) {
            setTextForTitle("ذ");
            txtFirstAlphabet.setText("ذ");
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.corn)
                    .into(imgOne);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.zal)
                    .into(img_one_example);
        }
        if (myId == 77) {
            setTextForTitle("عـ ـعـ ـع ع");
            txtFirstAlphabet.setText("عـ");
            txtSecond_word.setText("ـعـ");
            txtThird_word.setText("ـع");
            txtEndAlphabetWords.setText("ع");
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.doll)
                    .into(imgOne);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.ain_1)
                    .into(img_one_example);


            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.human)
                    .into(imgTwo);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.ain_2)
                    .into(img_two_example);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.cube)
                    .into(imgThree);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.ain_3)
                    .into(img_three_example);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.judo)
                    .into(imgEnd);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.ain_4)
                    .into(img_end_example);

        }
        if (myId == 78) {
            setTextForTitle("ثـ ث");
            txtFirstAlphabet.setText("ثـ");
            txtEndAlphabetWords.setText("ث");
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.girl)
                    .into(imgOne);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.ccc_1)
                    .into(img_one_example);

            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.dental)
                    .into(imgEnd);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.ccc_2)
                    .into(img_end_example);
        }
        if (myId == 79) {
            setTextForTitle("حـ ح");
            txtFirstAlphabet.setText("حـ");
            txtEndAlphabetWords.setText("ح");
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.snail)
                    .into(imgOne);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.h_1)
                    .into(img_one_example);

            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.wild_life)
                    .into(imgEnd);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.h_2)
                    .into(img_end_example);
        }
        if (myId == 80) {
            setTextForTitle("ضـ ض");
            txtFirstAlphabet.setText("ضـ");
            txtEndAlphabetWords.setText("ض");
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.vhs)
                    .into(imgOne);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.zad_1)
                    .into(img_one_example);

            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.pool)
                    .into(imgEnd);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.zad_2)
                    .into(img_end_example);
        }
        if (myId == 81) {
            setTextForTitle("ط");
            txtFirstAlphabet.setText("ط");
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.parrot)
                    .into(imgOne);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.ta_1)
                    .into(img_one_example);
        }
        if (myId == 82) {
            setTextForTitle("غـ ـغـ ـغ غ ");
            txtFirstAlphabet.setText("غـ");
            txtSecond_word.setText("ـغـ");
            txtThird_word.setText("ـغ");
            txtEndAlphabetWords.setText("غ");
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.goose)
                    .into(imgOne);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.gain_1)
                    .into(img_one_example);


            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.owl)
                    .into(imgTwo);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.gain_2)
                    .into(img_two_example);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.art_and_design)
                    .into(imgThree);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.gain_3)
                    .into(img_three_example);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.lamp)
                    .into(imgEnd);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.gain_4)
                    .into(img_end_example);

        }
        if (myId == 83) {
            setTextForTitle("ظ");
            txtFirstAlphabet.setText("ظ");
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.lunch_box)
                    .into(imgOne);
            Picasso
                    .with(getApplicationContext())
                    .load(R.drawable.za)
                    .into(img_one_example);
        }
    }

    private void setTextForTitle(String s) {
        txtTop.setText(s);
        //  دادن انیمیشن به تکست
        YoYo.with(Techniques.Shake).duration(1200)
                .playOn(txtTop);
    }

    public void onClickForNewId() {
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.click);
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
        imgBackLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
                if (myId == 23) {
                    myId = myId + 44;
                } else if (myId == 83) {
                    myId = 83;
                } else {
                    myId = myId + 1;
                }

                if (myId == 1 | myId == 2 | myId == 3 | myId == 5 | myId == 6 | myId == 7 | myId == 8 | myId == 10
                        | myId == 14 | myId == 15 | myId == 16 | myId == 17 | myId == 19
                        | myId == 20 | myId == 21 | myId == 22 | myId == 23 | myId == 67 | myId == 68 | myId == 71
                        | myId == 75 | myId == 78 | myId == 79 | myId == 80) {
                    id_word_count = 2;
                    setContentView(R.layout.activity_details_for_two_word);
                    getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);


                } else if (myId == 4 | myId == 9 | myId == 12 | myId == 18 | myId == 69 | myId == 72 | myId == 73
                        | myId == 74 | myId == 76 | myId == 81 | myId == 83) {
                    id_word_count = 1;
                    setContentView(R.layout.activity_details_for_one_word);
                    getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);


                } else if (myId == 11 | myId == 13 | myId == 70 | myId == 77 | myId == 82) {
                    id_word_count = 4;
                    setContentView(R.layout.activity_details_for_four_word);
                    getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

                }
                MediaPlayer mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.click);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });


                setting();


            }
        });
        imgBackRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();


                if (myId == 67) {
                    myId = myId - 44;
                } else if (myId == 1) {
                    myId = 1;
                } else {
                    myId = myId - 1;
                }

                if (myId == 1 | myId == 2 | myId == 3 | myId == 5 | myId == 6 | myId == 7 | myId == 8 | myId == 10
                        | myId == 14 | myId == 15 | myId == 16 | myId == 17 | myId == 19
                        | myId == 20 | myId == 21 | myId == 22 | myId == 23 | myId == 67 | myId == 68 | myId == 71
                        | myId == 75 | myId == 78 | myId == 79 | myId == 80) {
                    id_word_count = 2;
                    setContentView(R.layout.activity_details_for_two_word);
                    getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);


                } else if (myId == 4 | myId == 9 | myId == 12 | myId == 18 | myId == 69 | myId == 72 | myId == 73
                        | myId == 74 | myId == 76 | myId == 81 | myId == 83) {
                    id_word_count = 1;
                    setContentView(R.layout.activity_details_for_one_word);
                    getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);


                } else if (myId == 11 | myId == 13 | myId == 70 | myId == 77 | myId == 82) {
                    id_word_count = 4;
                    setContentView(R.layout.activity_details_for_four_word);
                    getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

                }
                MediaPlayer mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.click);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                setting();
            }
        });
        imgPractice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.click);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                Intent intent = new Intent(ActivityDetails.this, ActivityPractice.class);
                intent.putExtra("id", myId + "");
                intent.putExtra("row", myRow + "");
                startActivity(intent);
            }
        });
        imgHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.click);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                Intent intent = new Intent(ActivityDetails.this, ActivityAllAlphabet.class);
                startActivity(intent);
            }
        });
        imgMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.click);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                Intent intent = new Intent(ActivityDetails.this, ActivityMusic.class);
                intent.putExtra("id", myId + "");
                startActivity(intent);

            }
        });
        imgMute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isMute == false) {
                    int myImgMuteZip = getResources().getIdentifier("muted", "drawable", getPackageName());
                    imgMute.setImageResource(myImgMuteZip);
                    mediaPlayer.stop();
                    isMute = true;
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("isMuteSound", isMute);
                    editor.apply();
                    Toast toast = Toast.makeText(getApplicationContext(), "صدا رو قطع کردی :)", Toast.LENGTH_LONG);
                    View view = toast.getView();
                    view.setBackgroundResource(R.drawable.custom_toast);
                    toast.setView(view);
                    toast.show();


                } else if (isMute == true) {
                    int myImgMute = getResources().getIdentifier("smile", "drawable", getPackageName());
                    imgMute.setImageResource(myImgMute);
                    isMute = false;
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("isMuteSound", isMute);
                    editor.apply();
                    switchMethod();
                    setTextForNewIdGoLeft();
                    //Toast.makeText(ActivityDetails.this, "در حال اجرا", Toast.LENGTH_SHORT).show();


                }


            }
        });
        imgReNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isRenew = true;
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                }
                handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        isRenew = false;

                    }
                }, 5000);


                if (isMute == false) {
                    setTextForNewIdGoLeft();
                    switchMethod();
                }


            }
        });

    }

}
