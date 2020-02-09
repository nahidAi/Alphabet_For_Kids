package com.p.alphabetforkids;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import pl.droidsonroids.gif.GifImageView;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class ActivityFindIntoSentence extends AppCompatActivity {
    SpannableString spannableString;
    ClickableSpan clickableSpan;
    SeekBar seekBar;
    String text;
    TextView headerText;
    SharedPreferences sharedPreferences;
    MediaPlayer mediaPlayer;
    GifImageView gifImageView;
    Button reNew;
    ImageView imgback;


    private int id;
    private TextView textview;
    int progressValue;
    boolean a, b, c, d, f, j, h, i, g, k = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_into_sentence);

        findViewMethod();

        //فول اسکرین کردن صفحه
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        //   گرفتن ایدی
        Bundle bundle = getIntent().getExtras();
        // id = Integer.parseInt(bundle.getString("newId"));
        id = 21;


        // مقدار پیش فرض شیردپرفرنسز
        sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("progress_value", 0);
        editor.apply();


        findWordInSentecce();

        onClickMethod();


    }

    private void onClickMethod() {
        reNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recreate();
                //-------------
                sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("progress_value", 0);
                editor.apply();
                //-------------
                a = false;
                seekBar.setProgress(0);

                changeWordsFor_a();


            }
        });
        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void findViewMethod() {
        seekBar = findViewById(R.id.seekBar);
        textview = (TextView) findViewById(R.id.txtData);
        headerText = findViewById(R.id.header_txt);
        gifImageView = findViewById(R.id.tashvigh_soti);
        reNew = findViewById(R.id.txtReNew);
        imgback = findViewById(R.id.imgBack);


    }

    public void findWordInSentecce() {
        switch (id) {
            case 1:
                changeWordsFor_a();
                break;
            case 2:
                changeWordsFor_b();
                break;
            case 3:
                changeWordsFor_p();
                break;
            case 4:
                changeWordsFor_t();
                break;
            case 5:
                changeWordsFor_ccc();
                break;
            case 6:
                changeWordsFor_j();
                break;
            case 7:
                changeWordsFor_ch();
                break;
            case 8:
                changeWordsFor_h();
                break;
            case 9:
                changeWordsFor_kh();
                break;
            case 10:
                changeWordsFor_d();
                break;
            case 11:
                changeWordsFor_zal();
                break;
            case 12:
                changeWordsFor_r();
                break;
            case 13:
                changeWordsFor_z();
                break;
            case 14:
                changeWordsFor_zh();
                break;
            case 15:
                changeWordsFor_sin();
                break;
            case 16:
                changeWordsFor_shin();
                break;
            case 17:
                changeWordsFor_sad();
                break;
            case 18:
                changeWordsFor_zad();
                break;
            case 19:
                changeWordsFor_ta();
                break;
            case 20:
                changeWordsFor_za();
                break;
            case 21:
                changeWordsFor_ein();
                break;

        }


    }

    public void changeWordsFor_a() {
        headerText.setText("آ ا");
        text = "باران آمَد.\n" +
                "لیوان آب دارَد.\n" +
                "مادَر آش دُرُست می\u200Cکند.\n" +
                "مَن باسَواد هَستَم.\n";

        spannableString = new SpannableString(text);
        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {

                clicked = true;
                view.invalidate();


                if (a == false) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);
                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    a = true;


                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.barikala);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
                    if (progressValue == 9) {
                        mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                        mediaPlayer.start();
                        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                mp.release();
                            }
                        });

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


            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };

        spannableString.setSpan(clickableSpan, 1, 2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());


        //------------------------------------------------------------------------------------------


        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (b == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    b = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 3, 4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());


        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.afarin);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                if (c == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    c = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });

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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 6, 7, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });


                if (d == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    d = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 15, 16, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                if (i == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    i = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 18, 19, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (f == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    f = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 22, 23, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                if (j == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    j = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 29, 30, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.aali);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (h == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    h = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 34, 35, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////


        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (g == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    g = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 57, 58, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();


                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (k == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    k = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 61, 62, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());


    }

    public void changeWordsFor_b() {
        headerText.setText("بـ ب ");
        text = "بابا در برف آمَد.\n" +
                "مَن تاب بازی دوست دارَم.\n" +
                "کِتاب دوست ما اَست.\n" +
                "مَن توپ بازی دوست دارم.\n" +
                "بَرادَرَم اَسب دارَد.\n" +
                "مَن هَمیشه بَرنده هَستم.\n";

        spannableString = new SpannableString(text);
        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {

                clicked = true;
                view.invalidate();


                if (a == false) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);
                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    a = true;


                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.barikala);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
                    if (progressValue == 9) {
                        mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                        mediaPlayer.start();
                        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                mp.release();
                            }
                        });

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


            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };

        spannableString.setSpan(clickableSpan, 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());


        //------------------------------------------------------------------------------------------


        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (b == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    b = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 2, 3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());


        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.afarin);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                if (c == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    c = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });

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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 8, 9, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });


                if (d == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    d = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 24, 25, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                if (i == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    i = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 26, 27, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (f == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    f = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 47, 48, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                if (j == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    j = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 71, 72, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.aali);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (h == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    h = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 87, 88, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (k == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    k = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 100, 101, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (g == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    g = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 120, 121, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////


    }

    public void changeWordsFor_p() {
        headerText.setText("پـ پ  ");
        text = "پُرتقال خوش مَزه اَست.\n" +
                "پِدَرَم پارچه می\u200Cفروشد.\n" +
                "پِدَربُزرگ سوپ می\u200Cپَزَد.\n" +
                "مَن با پا توپ می\u200Cزَنم.\n" +
                "پَرَنده پَرواز می\u200Cکُنَد.\n";

        spannableString = new SpannableString(text);
        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {

                clicked = true;
                view.invalidate();


                if (a == false) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);
                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    a = true;


                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.barikala);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
                    if (progressValue == 9) {
                        mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                        mediaPlayer.start();
                        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                mp.release();
                            }
                        });

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


            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };

        spannableString.setSpan(clickableSpan, 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());


        //------------------------------------------------------------------------------------------


        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (b == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    b = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 23, 24, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());


        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.afarin);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                if (c == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    c = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });

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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 31, 32, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });


                if (d == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    d = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 47, 48, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                if (i == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    i = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 60, 61, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (f == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    f = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 65, 66, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                if (j == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    j = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 79, 80, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.aali);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (h == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    h = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 84, 85, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (k == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    k = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 95, 96, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (g == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    g = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 103, 104, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////


    }

    public void changeWordsFor_t() {
        headerText.setText("تـ ت ");
        text = "تارا توپ دارَد.\n" +
                "دَر تابستان توت خوردَم.\n" +
                "تارا تاب\u200Cبازی می\u200Cکُنَد.\n" +
                "تَرانه دوست نِدا اَست.\n";

        spannableString = new SpannableString(text);
        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {

                clicked = true;
                view.invalidate();


                if (a == false) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);
                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    a = true;


                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.barikala);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
                    if (progressValue == 9) {
                        mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                        mediaPlayer.start();
                        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                mp.release();
                            }
                        });

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


            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };

        spannableString.setSpan(clickableSpan, 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());


        //------------------------------------------------------------------------------------------


        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (b == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    b = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 5, 6, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());


        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.afarin);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                if (c == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    c = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });

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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 20, 21, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });


                if (d == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    d = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 24, 25, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                if (i == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    i = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 28, 29, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (f == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    f = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 30, 31, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                if (j == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    j = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 40, 41, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.aali);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (h == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    h = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 45, 46, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (k == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    k = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 64, 65, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (g == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    g = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 74, 75, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (g == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    g = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 84, 85, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());


    }

    public void changeWordsFor_ccc() {
        headerText.setText("ثـ ث ");
        text = "\n" +
                "ثریا با ثَمین دوست اَست.\n" +
                "ثَمین لثه دارَد.\n" +
                "ثابت ثـ غیراخر دارَد.\n" +
                "وَرزِش باعِث سَلامَتی اَست.\n" +
                "مُثَلَث سه ضِلع دارَد.\n" +
                "ثُریا مَدرَسه را دوست دارَد.\n";

        spannableString = new SpannableString(text);
        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {

                clicked = true;
                view.invalidate();


                if (a == false) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);
                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    a = true;


                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.barikala);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
                    if (progressValue == 9) {
                        mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                        mediaPlayer.start();
                        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                mp.release();
                            }
                        });

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


            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };

        spannableString.setSpan(clickableSpan, 1, 2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());


        //------------------------------------------------------------------------------------------


        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (b == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    b = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 9, 10, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());


        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.afarin);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                if (c == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    c = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });

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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 26, 27, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });


                if (d == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    d = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 33, 34, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                if (i == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    i = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 43, 44, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (f == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    f = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 48, 49, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                if (j == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    j = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 76, 77, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.aali);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (h == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    h = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 95, 96, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (k == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    k = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 99, 100, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (g == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    g = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 116, 117, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////


    }

    public void changeWordsFor_j() {
        headerText.setText("جـ ج ");
        text = "جوجه کِنار دِرَخت کاج اَست.\n" +
                "مَن وسایلم را جَمع می\u200Cکُنَم.\n" +
                "جا\u200Cمِدادی من زیبا است.\n" +
                "گنج،نارنج،برنج و پنج همگی ج اخر دارَند. \n";

        spannableString = new SpannableString(text);
        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {

                clicked = true;
                view.invalidate();


                if (a == false) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);
                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    a = true;


                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.barikala);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
                    if (progressValue == 9) {
                        mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                        mediaPlayer.start();
                        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                mp.release();
                            }
                        });

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


            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };

        spannableString.setSpan(clickableSpan, 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());


        //------------------------------------------------------------------------------------------


        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (b == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    b = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 2, 3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());


        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.afarin);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                if (c == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    c = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });

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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 20, 21, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });


                if (d == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    d = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 42, 43, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());

        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (f == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    f = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 57, 58, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                if (j == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    j = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 82, 83, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.aali);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (h == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    h = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 88, 89, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (k == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    k = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 93, 94, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (g == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    g = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 99, 100, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                if (i == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    i = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 106, 107, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());


    }

    public void changeWordsFor_ch() {
        headerText.setText("چـ چ ");
        text = "چِراغ روشَن اَست.\n" +
                "چِلچِله آواز می\u200Cخوانَد.\n" +
                "چِنار چَتر دارَد.\n" +
                "کبریت اَز چوب دُرُست شده اَست.\n" +
                "ما چادُر مسافِرتی داریم.\n" +
                "چاقو،چراغ هَر دو  حرف چـ غیرآخر دارند.\n";

        spannableString = new SpannableString(text);
        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {

                clicked = true;
                view.invalidate();


                if (a == false) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);
                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    a = true;


                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.barikala);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
                    if (progressValue == 9) {
                        mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                        mediaPlayer.start();
                        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                mp.release();
                            }
                        });

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


            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };

        spannableString.setSpan(clickableSpan, 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());


        //------------------------------------------------------------------------------------------


        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (b == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    b = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 18, 19, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());


        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.afarin);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                if (c == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    c = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });

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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 21, 22, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });


                if (d == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    d = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 42, 43, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());

        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (f == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    f = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 48, 49, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                if (j == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    j = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 70, 71, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.aali);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (h == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    h = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 94, 95, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (k == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    k = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 116, 117, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (g == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    g = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 121, 122, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                if (i == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    i = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 138, 139, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());


    }

    public void changeWordsFor_h() {
        headerText.setText("حـ ح ");
        text = "حِسام صُبح زود از خواب بُلند می\u200Cشَوَد.\n" +
                "حَمید حوله دارَد.\n" +
                "حسام و حمید صُبحانه می\u200Cخورند.\n" +
                "حمید وَ حِسام همیشه دَر صُلح هَستَند.\n";

        spannableString = new SpannableString(text);
        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {

                clicked = true;
                view.invalidate();


                if (a == false) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);
                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    a = true;


                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.barikala);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
                    if (progressValue == 9) {
                        mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                        mediaPlayer.start();
                        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                mp.release();
                            }
                        });

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


            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };

        spannableString.setSpan(clickableSpan, 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());


        //------------------------------------------------------------------------------------------


        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (b == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    b = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 9, 10, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());


        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.afarin);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                if (c == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    c = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });

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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 39, 40, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });


                if (d == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    d = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 45, 46, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());

        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (f == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    f = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 57, 58, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                if (j == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    j = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 64, 65, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.aali);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (h == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    h = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 72, 73, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (k == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    k = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 87, 88, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (g == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    g = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 95, 96, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////


        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                if (i == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    i = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 114, 115, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());


    }

    public void changeWordsFor_kh() {
        headerText.setText("خـ خ ");
        text = "دِرَخت خانه ی ما شاخه دارَد.\n" +
                "یَخ خیلی سرد اَست.\n" +
                "مَن خَمیردندان وَ خودکار دارَم.\n" +
                "خَیاط با نَخ لِباس می\u200Cدوزَد.\n" +
                "مَن خیار وَ سیب دوست دارَم.\n";

        spannableString = new SpannableString(text);
        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {

                clicked = true;
                view.invalidate();


                if (a == false) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);
                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    a = true;


                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.barikala);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
                    if (progressValue == 9) {
                        mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                        mediaPlayer.start();
                        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                mp.release();
                            }
                        });

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


            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };

        spannableString.setSpan(clickableSpan, 4, 5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());


        //------------------------------------------------------------------------------------------


        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (b == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    b = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 7, 8, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());


        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.afarin);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                if (c == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    c = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });

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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 19, 20, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });


                if (d == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    d = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 31, 32, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());

        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (f == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    f = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 33, 34, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                if (j == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    j = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 52, 53, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.aali);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (h == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    h = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 66, 67, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (k == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    k = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 80, 81, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (g == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    g = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 91, 92, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////


        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                if (i == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    i = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 113, 114, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());


    }

    public void changeWordsFor_d() {
        headerText.setText("د ");
        text = "دیبا، دُنیا ، دانیال وَ نِدا  با هَم دوست هَستند.\n" +
                "آن\u200Cها دانِشجوهای کوچولو هَستَند.\n" +
                "آن\u200Cها شاخه\u200Cهای دِرَختان را قطع نمی\u200Cکُنند.\n";

        spannableString = new SpannableString(text);
        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {

                clicked = true;
                view.invalidate();


                if (a == false) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);
                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    a = true;


                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.barikala);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
                    if (progressValue == 9) {
                        mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                        mediaPlayer.start();
                        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                mp.release();
                            }
                        });

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


            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };

        spannableString.setSpan(clickableSpan, 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());


        //------------------------------------------------------------------------------------------


        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (b == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    b = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 6, 7, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());


        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.afarin);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                if (c == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    c = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });

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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 14, 15, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });


                if (d == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    d = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 26, 27, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());

        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (f == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    f = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 37, 38, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                if (j == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    j = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 47, 48, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.aali);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (h == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    h = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 56, 57, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (k == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    k = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 80, 81, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (g == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    g = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 98, 99, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////


        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                if (i == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    i = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 122, 123, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());


    }

    public void changeWordsFor_zal() {
        headerText.setText("ذ ");
        text = "ذُرّت خیلی لذیذ اَست.\n" +
                "سُرسُره\u200C بازی خیلی لِذّت دارد.\n" +
                "آش غذای لَذیذی اَست.\n" +
                "خوردن ذُرَّت دَر تابستان لذیذتَر اَست.\n";

        spannableString = new SpannableString(text);
        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {

                clicked = true;
                view.invalidate();


                if (a == false) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);
                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    a = true;


                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.barikala);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
                    if (progressValue == 9) {
                        mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                        mediaPlayer.start();
                        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                mp.release();
                            }
                        });

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


            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };

        spannableString.setSpan(clickableSpan, 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());


        //------------------------------------------------------------------------------------------


        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (b == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    b = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 12, 13, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());


        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.afarin);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                if (c == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    c = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });

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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 14, 15, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });


                if (d == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    d = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 43, 44, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());

        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (f == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    f = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 57, 58, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                if (j == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    j = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 63, 64, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.aali);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (h == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    h = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 65, 66, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (k == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    k = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 80, 81, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (g == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    g = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 100, 101, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////


        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                if (i == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    i = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 102, 103, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());


    }

    public void changeWordsFor_r() {
        headerText.setText("ر ");
        text = "رَعنا وَ رِضا خواهر وَ بَرادَر هَستَند.\n" +
                "آرمان رادیو گوش می\u200Cکُنَد.\n" +
                "مَن هَر روز شیر می\u200Cخورَم.\n";

        spannableString = new SpannableString(text);
        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {

                clicked = true;
                view.invalidate();


                if (a == false) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);
                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    a = true;


                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.barikala);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
                    if (progressValue == 9) {
                        mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                        mediaPlayer.start();
                        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                mp.release();
                            }
                        });

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


            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };

        spannableString.setSpan(clickableSpan, 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());


        //------------------------------------------------------------------------------------------


        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (b == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    b = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 9, 10, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());


        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.afarin);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                if (c == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    c = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });

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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 18, 19, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });


                if (d == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    d = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 25, 26, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());

        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (f == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    f = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 29, 30, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                if (j == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    j = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 41, 42, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.aali);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (h == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    h = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 46, 47, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (k == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    k = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 72, 73, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (g == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    g = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 74, 75, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////


        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                if (i == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    i = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 80, 81, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////


        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                if (i == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    i = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 87, 88, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());


    }

    public void changeWordsFor_z() {
        headerText.setText("ز ");
        text = "زیبا دُختر زِرَنگی اَست.\n" +
                "زَنبورعَسل  برای بچه ها عسَل دُرُست می\u200Cکُنَد.\n" +
                "مَن زانو دارَم.\n" +
                "زیبا ، زینب، زیوَر ، پَری\u200Cناز، فائزه وَ نازگُل با هم به مدرَسه می\u200Cرَوَند.\n";

        spannableString = new SpannableString(text);
        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {

                clicked = true;
                view.invalidate();


                if (a == false) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);
                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    a = true;


                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.barikala);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
                    if (progressValue == 9) {
                        mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                        mediaPlayer.start();
                        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                mp.release();
                            }
                        });

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


            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };

        spannableString.setSpan(clickableSpan, 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());


        //------------------------------------------------------------------------------------------


        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (b == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    b = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 11, 12, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());


        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.afarin);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                if (c == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    c = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });

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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 25, 26, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });


                if (d == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    d = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 75, 76, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());

        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (f == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    f = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 87, 88, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                if (j == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    j = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 94, 95, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.aali);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (h == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    h = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 100, 101, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (k == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    k = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 115, 116, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (g == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    g = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 121, 122, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////


        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                if (i == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    i = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 129, 130, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());


    }

    public void changeWordsFor_zh() {
        headerText.setText("ژ ");
        text = "ژاله ، بیژَن ، مَنیژه  به مَهدکودک می\u200Cرَوَند.\n" +
                "اَگَر به گُل آب نَدَهیم پَژمُرده می\u200Cشود.\n" +
                "اگر به گُل زیاد آب بدهیم باز هم پَژمُرده  می\u200Cشَوَد.\n" +
                "بیژن ژِله دوست دارَد.\n" +
                "ژاکت منیژه ژولیده شده اَست.\n";

        spannableString = new SpannableString(text);
        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {

                clicked = true;
                view.invalidate();


                if (a == false) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);
                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    a = true;


                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.barikala);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
                    if (progressValue == 9) {
                        mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                        mediaPlayer.start();
                        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                mp.release();
                            }
                        });

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


            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };

        spannableString.setSpan(clickableSpan, 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());


        //------------------------------------------------------------------------------------------


        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (b == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    b = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 9, 10, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());


        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.afarin);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                if (c == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    c = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });

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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 19, 20, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });


                if (d == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    d = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 72, 73, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());

        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (f == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    f = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 121, 122, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                if (j == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    j = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 144, 145, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.aali);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (h == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    h = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 141, 142, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (k == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    k = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 161, 162, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (g == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    g = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 169, 170, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////


        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                if (i == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    i = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 172, 173, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());


    }

    public void changeWordsFor_sin() {
        headerText.setText("سـ س ");
        text = "سَمنو ، سیب ، ساعَت ، سَبزه ، سکه ، سیر وَ سرکه \n" +
                " داخل سُفره ی  هَفت سین هَستَند.\n" +
                "کشاورز داس دارد.\n";

        spannableString = new SpannableString(text);
        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {

                clicked = true;
                view.invalidate();


                if (a == false) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);
                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    a = true;


                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.barikala);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
                    if (progressValue == 9) {
                        mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                        mediaPlayer.start();
                        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                mp.release();
                            }
                        });

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


            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };

        spannableString.setSpan(clickableSpan, 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());


        //------------------------------------------------------------------------------------------


        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (b == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    b = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 8, 9, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());


        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.afarin);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                if (c == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    c = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });

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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 14, 15, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });


                if (d == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    d = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 22, 23, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());

        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (f == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    f = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 30, 31, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                if (j == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    j = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 36, 37, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.aali);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (h == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    h = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 43, 44, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (k == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    k = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 55, 56, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (g == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    g = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 69, 70, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////


        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                if (i == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    i = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 75, 76, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////


        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                if (i == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    i = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 91, 92, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());


    }

    public void changeWordsFor_shin() {
        headerText.setText("شـ ش ");
        text = "روی کیک تَولُد شاهین یک شَمع خیلی زیبا هست.\n" +
                "دوستَش شایان برایَش کَفش کادو داده اَست.\n" +
                "شایان و شاهین و رَشید خیلی خوشحال هَستَند.\n";

        spannableString = new SpannableString(text);
        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {

                clicked = true;
                view.invalidate();


                if (a == false) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);
                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    a = true;


                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.barikala);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
                    if (progressValue == 9) {
                        mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                        mediaPlayer.start();
                        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                mp.release();
                            }
                        });

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


            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };

        spannableString.setSpan(clickableSpan, 15, 16, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());


        //------------------------------------------------------------------------------------------


        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (b == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    b = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 24, 25, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());


        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.afarin);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                if (c == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    c = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });

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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 49, 50, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });


                if (d == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    d = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 51, 52, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());

        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (f == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    f = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 62, 63, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                if (j == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    j = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 67, 68, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.aali);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (h == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    h = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 85, 86, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (k == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    k = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 93, 94, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (g == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    g = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 103, 104, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////


        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                if (i == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    i = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 114, 115, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());


    }

    public void changeWordsFor_sad() {
        headerText.setText("صـ ص ");
        text = "صادِق صورَتَش را با صابون مخصوص به خود می\u200Cشویَد.\n" +
                "صادق صبح خیلی زود قبل\n" +
                " از طلوع خورشید قُرص ماه را تماشا میکُنَد. \n" +
                "او شانه ی مَخصوص دارَد.\n";

        spannableString = new SpannableString(text);
        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {

                clicked = true;
                view.invalidate();


                if (a == false) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);
                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    a = true;


                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.barikala);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
                    if (progressValue == 9) {
                        mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                        mediaPlayer.start();
                        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                mp.release();
                            }
                        });

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


            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };

        spannableString.setSpan(clickableSpan, 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());


        //------------------------------------------------------------------------------------------


        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (b == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    b = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 6, 7, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());


        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.afarin);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                if (c == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    c = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });

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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 20, 21, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });


                if (d == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    d = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 28, 29, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());

        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (f == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    f = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 49, 50, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                if (j == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    j = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 54, 55, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.aali);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (h == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    h = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 90, 91, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (k == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    k = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 128, 129, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (g == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    g = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 130, 131, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////


        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                if (i == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    i = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 30, 31, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());


    }

    public void changeWordsFor_zad() {
        headerText.setText("ضـ ض ");
        text = "فاضِل درس ریاضی را دوست دارَد.\n" +
                "حوض پر از آب اَست.\n" +
                "قاضی بایَد عادل باشَد.\n" +
                "مَرضیه ضبط صوت دارَد.\n" +
                "راضیه و رضا  دَفتر ریاضی دارند.\n" +
                "او مریض اَست.\n";

        spannableString = new SpannableString(text);
        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {

                clicked = true;
                view.invalidate();


                if (a == false) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);
                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    a = true;


                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.barikala);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
                    if (progressValue == 9) {
                        mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                        mediaPlayer.start();
                        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                mp.release();
                            }
                        });

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


            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };

        spannableString.setSpan(clickableSpan, 2, 3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());


        //------------------------------------------------------------------------------------------


        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (b == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    b = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 33, 34, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());


        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.afarin);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                if (c == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    c = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });

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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 52, 53, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });


                if (d == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    d = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 76, 77, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());

        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (f == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    f = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 80, 81, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                if (j == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    j = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 97, 98, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.aali);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (h == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    h = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 104, 105, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (k == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    k = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 117, 118, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (g == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    g = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 133, 134, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////


        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                if (i == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    i = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 13, 14, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());


    }
    public void changeWordsFor_ta() {
        headerText.setText("ط ");
        text = "طوطی پرنده ی باهوشی اَست.\n" +
                "طَناز طَبل دارَد.\n" +
                "طاهِره یک طوطی سُخَن گو دارَد.\n" +
                "پِدَر طاهر یِک طَبلِ بُزُرگ برای طاهِر خَریده اَست.\n";

        spannableString = new SpannableString(text);
        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {

                clicked = true;
                view.invalidate();


                if (a == false) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);
                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    a = true;


                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.barikala);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
                    if (progressValue == 9) {
                        mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                        mediaPlayer.start();
                        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                mp.release();
                            }
                        });

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


            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };

        spannableString.setSpan(clickableSpan, 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());


        //------------------------------------------------------------------------------------------


        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (b == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    b = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 2, 3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());


        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.afarin);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                if (c == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    c = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });

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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 26, 27, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });


                if (d == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    d = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 32, 33, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());

        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (f == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    f = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 44, 45, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                if (j == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    j = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 54, 55, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.aali);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (h == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    h = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 56, 57, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (k == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    k = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 81, 82, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (g == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    g = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 90, 91, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////


        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                if (i == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    i = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 108, 109, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////


        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                if (i == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    i = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 91, 92, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());


    }
    public void changeWordsFor_za() {
        headerText.setText("ظ ");
        text = "حافِظ شاعِر بُزُرگی بود.\n" +
                "من هِنگام رَفتَن به مَدرَسه  خُداحافِظی می\u200Cکُنَم.\n" +
                "امیرحافِظ دَرسَش را خوب حفظ می\u200Cکند.\n" +
                "خُدا ظالم را دوست ندارد.\n" +
                "حافِظ ، خُداحافِظ ، ظالِم وظَرف  همگی حرف  ظ  دارَند.\n";

        spannableString = new SpannableString(text);
        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {

                clicked = true;
                view.invalidate();


                if (a == false) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);
                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    a = true;


                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.barikala);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
                    if (progressValue == 9) {
                        mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                        mediaPlayer.start();
                        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                mp.release();
                            }
                        });

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


            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };

        spannableString.setSpan(clickableSpan, 4, 5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());




        //------------------------------------------------------------------------------------------


        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (b == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    b = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 62, 63, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());


        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.afarin);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                if (c == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    c = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });

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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 83, 84, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });


                if (d == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    d = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 101, 102, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());

        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (f == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    f = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 116, 117, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                if (j == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    j = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 140, 141, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.aali);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (h == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    h = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 152, 153, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (k == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    k = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 156, 157, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (g == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    g = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 163, 164, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////


        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                if (i == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    i = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 179, 180, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());



    }
    public void changeWordsFor_ein() {
        headerText.setText("عـ ـعـ ـع ع ");
        text = "گوسفَند بَع بَع می\u200Cکُنَد.\n" +
                "موقع طُلوع  من به آسمان نگاه کردَم.\n" +
                "مربَع چهار ضلع دارَد.\n" +
                "سَعید و مَسعود و جَعفَر و علی با هم دوست هَستَند.\n";

        spannableString = new SpannableString(text);
        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {

                clicked = true;
                view.invalidate();


                if (a == false) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);
                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    a = true;


                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.barikala);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
                    if (progressValue == 9) {
                        mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                        mediaPlayer.start();
                        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                mp.release();
                            }
                        });

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


            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };

        spannableString.setSpan(clickableSpan, 10, 11, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());


        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (f == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    f = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 14, 15, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());


        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (b == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    b = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 29, 30, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());


        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.afarin);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                if (c == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    c = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });

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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 35, 36, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });


                if (d == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    d = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 66, 67, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());


        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                if (j == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    j = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 72, 73, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.aali);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (h == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    h = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 86, 87, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (k == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    k = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 95, 96, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////

        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                if (g == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    g = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 103, 104, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////


        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                if (i == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    i = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 110, 111, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        ////////////////////////////////////////////////////////////////////////////


        clickableSpan = new ClickableSpan() {
            boolean clicked = false;

            @Override
            public void onClick(@NonNull View view) {
                clicked = true;
                view.invalidate();
                mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.lip);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                if (j == false) {
                    progressValue = sharedPreferences.getInt("progress_value", 0);
                    seekBar.setProgress(progressValue + 1);

                    sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("progress_value", progressValue + 1);
                    editor.apply();
                    j = true;

                }
                if (progressValue == 9) {
                    mediaPlayer = MediaPlayer.create(ActivityFindIntoSentence.this, R.raw.horaa);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
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

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                if (this.clicked) ds.setColor(Color.RED);
            }
        };
        spannableString.setSpan(clickableSpan, 75, 76, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
        textview.setMovementMethod(LinkMovementMethod.getInstance());


    }


}
