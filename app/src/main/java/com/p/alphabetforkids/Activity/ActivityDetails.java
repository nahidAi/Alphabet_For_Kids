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
            img_three_example, img_end_example, imgOne, imgTwo, imgThree, imgEnd, imgReNew, imgMute;

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
                mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.p);
                mediaPlayer.start();
                break;
            case 4:
                mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.t);
                mediaPlayer.start();
                break;
            case 5:
                mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.ccc);
                mediaPlayer.start();
                break;
            case 6:
                mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.j);
                mediaPlayer.start();
                break;
            case 7:
                mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.ch);
                mediaPlayer.start();
                break;
            case 8:
                mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.h);
                mediaPlayer.start();
                break;
            case 9:
                mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.kh);
                mediaPlayer.start();
                break;
            case 10:
                mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.d);
                mediaPlayer.start();
                break;
            case 11:
                mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.zal);
                mediaPlayer.start();
                break;
            case 12:
                mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.r);
                mediaPlayer.start();
                break;
            case 13:
                mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.z);
                mediaPlayer.start();
                break;
            case 14:
                mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.zh);
                mediaPlayer.start();
                break;
            case 15:
                mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.sin);
                mediaPlayer.start();
                break;
            case 16:
                mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.sh);
                mediaPlayer.start();
                break;
            case 17:
                mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.sad);
                mediaPlayer.start();
                break;
            case 18:
                mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.zad);
                mediaPlayer.start();
                break;
            case 19:
                mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.ta);
                mediaPlayer.start();
                break;
            case 20:
                mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.za);
                mediaPlayer.start();
                break;
            case 21:
                mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.ain);
                mediaPlayer.start();
                break;
            case 22:
                mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.ghain);
                mediaPlayer.start();
                break;
            case 23:
                mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.f);
                mediaPlayer.start();
                break;
            case 67:
                mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.gh);
                mediaPlayer.start();
                break;
            case 68:
                mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.k);
                mediaPlayer.start();
                break;
            case 69:
                mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.ghaf);
                mediaPlayer.start();
                break;
            case 70:
                mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.lam);
                mediaPlayer.start();
                break;
            case 71:
                mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.m);
                mediaPlayer.start();
                break;
            case 72:
                mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.non);
                mediaPlayer.start();
                break;
            case 73:
                mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.v);
                mediaPlayer.start();
                break;
            case 74:
                mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.he4);
                mediaPlayer.start();
                break;
            case 75:
                mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.i);
                mediaPlayer.start();
                break;
            case 76:
                mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.ei);
                mediaPlayer.start();
                break;
            case 77:
                mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.aa);
                mediaPlayer.start();
                break;
            case 78:
                mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.ea);
                mediaPlayer.start();
                break;
            case 79:
                mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.o);
                mediaPlayer.start();
                break;
            case 80:
                mediaPlayer = MediaPlayer.create(ActivityDetails.this, R.raw.tashdid);
                mediaPlayer.start();
                break;

        }


    }

    private void setTextMethod() {
        txtTop.setText(title);
        //  دادن انیمیشن به تکست
        YoYo.with(Techniques.Shake).duration(1200)
                .playOn(txtTop);

        if (id_word_count == 4) {
            txtFirstAlphabet.setText(first_alphabet_word);
            txtEndAlphabetWords.setText(end_alphabet_words);
            txtSecond_word.setText(second_alphabet_words);
            txtThird_word.setText(third_alphabet_words);


            //  دادن انیمیشن به تکست
            handler = new Handler();
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
            }, 21000);


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
                                .playOn(txtEndAlphabetWords)
                                .stop(true);


                    } else if (isRenew == false) {
                        YoYo.with(Techniques.Shake).duration(1200)
                                .playOn(txtEndAlphabetWords);

                    }


                }
            }, 10000);


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
            txtFirstAlphabet.setText(first_alphabet_word);
            handler = new Handler();
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
            }, 5000);

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
        imgBackLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
                myDatabase = new MyDatabase(getApplicationContext());
                int nextRow = myRow++;
                itemModel = myDatabase.selectAlphabetByRow(nextRow + 1);

                // اطلاعات سطر جدید که با کلیک روی  فلش سمت چپ دریافت کردم
                int newMyId = itemModel.getId();
                int newWordCount = itemModel.getId_word_count();


                //setTextForRowId();


                Toast.makeText(ActivityDetails.this, "my id is " + itemModel.getId() + "my row is " + itemModel.getRow(), Toast.LENGTH_SHORT).show();


            }
        });
        imgBackRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ActivityDetails.this, "clicked", Toast.LENGTH_SHORT).show();
            }
        });
        imgPractice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityDetails.this, ActivityPractice.class);
                intent.putExtra("id",myId+"");
                startActivity(intent);
            }
        });
        imgHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityDetails.this, ActivityAllAlphabet.class);
                startActivity(intent);
            }
        });
        imgMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                    Toast.makeText(ActivityDetails.this, "صدا قطع شد", Toast.LENGTH_SHORT).show();


                } else if (isMute == true) {
                    int myImgMute = getResources().getIdentifier("smile", "drawable", getPackageName());
                    imgMute.setImageResource(myImgMute);
                    isMute = false;
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("isMuteSound", isMute);
                    editor.apply();
                    switchMethod();
                    setTextMethod();
                    Toast.makeText(ActivityDetails.this, "در حال اجرا", Toast.LENGTH_SHORT).show();


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


    public void setTextForRowId() {

        txtTop.setText(itemModel.getTitle());
        //  دادن انیمیشن به تکست
        YoYo.with(Techniques.Shake).duration(1200)
                .playOn(txtTop);

        if (itemModel.getId_word_count() == 4) {
            txtFirstAlphabet.setText(itemModel.getFirst_alphabet_word());
            txtEndAlphabetWords.setText(itemModel.getEnd_alphabet_word());
            txtSecond_word.setText(itemModel.getSecond_alphabet_words());
            txtThird_word.setText(itemModel.getThird_alphabet_words());


            //  دادن انیمیشن به تکست
            handler = new Handler();
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
            }, 21000);


            int id = getResources().getIdentifier(itemModel.getExampleOne(), "drawable", getPackageName());
            int id_2 = getResources().getIdentifier(itemModel.getExampleTwo(), "drawable", getPackageName());
            int id_3 = getResources().getIdentifier(itemModel.getExampleThree(), "drawable", getPackageName());
            int id_4 = getResources().getIdentifier(itemModel.getExampleEnd(), "drawable", getPackageName());
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


            int img_1 = getResources().getIdentifier(itemModel.getImg_one(), "drawable", getPackageName());
            int img_2 = getResources().getIdentifier(itemModel.getImg_two(), "drawable", getPackageName());
            int img_3 = getResources().getIdentifier(itemModel.getImg_three(), "drawable", getPackageName());
            int img_4 = getResources().getIdentifier(itemModel.getImg_four(), "drawable", getPackageName());
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


        } else if (itemModel.getId_word_count() == 2) {
            txtFirstAlphabet.setText(itemModel.getFirst_alphabet_word());
            txtEndAlphabetWords.setText(itemModel.getEnd_alphabet_word());
            handler = new Handler();

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
                                .playOn(txtEndAlphabetWords)
                                .stop(true);


                    } else if (isRenew == false) {
                        YoYo.with(Techniques.Shake).duration(1200)
                                .playOn(txtEndAlphabetWords);

                    }


                }
            }, 10000);


            int id = getResources().getIdentifier(itemModel.getExampleOne(), "drawable", getPackageName());
            int id_4 = getResources().getIdentifier(itemModel.getExampleEnd(), "drawable", getPackageName());
            Picasso
                    .with(getApplicationContext())
                    .load(id)
                    .into(img_one_example);
            Picasso
                    .with(getApplicationContext())
                    .load(id_4)
                    .into(img_end_example);

            int img_1 = getResources().getIdentifier(itemModel.getImg_one(), "drawable", getPackageName());
            int img_4 = getResources().getIdentifier(itemModel.getImg_four(), "drawable", getPackageName());
            Picasso
                    .with(getApplicationContext())
                    .load(img_1)
                    .into(imgOne);
            Picasso
                    .with(getApplicationContext())
                    .load(img_4)
                    .into(imgEnd);


        } else {
            txtFirstAlphabet.setText(itemModel.getFirst_alphabet_word());
            handler = new Handler();
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
            }, 5000);

            int id = getResources().getIdentifier(itemModel.getExampleOne(), "drawable", getPackageName());
            Picasso
                    .with(getApplicationContext())
                    .load(id)
                    .into(img_one_example);

            int img_1 = getResources().getIdentifier(itemModel.getImg_one(), "drawable", getPackageName());
            Picasso
                    .with(getApplicationContext())
                    .load(img_1)
                    .into(imgOne);
        }


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
