package com.p.alphabetforkids.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.p.alphabetforkids.R;

public class ActivityPractice extends AppCompatActivity {
    ImageView imgPaint_2, homeWork, imgback, findInSentence, soundAndSign,readHistory,buildWord,imgHome;
    private int myId;
    private int myRow;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);

        //فول اسکرین کردن صفحه
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //   گرفتن ایدی
        Bundle bundle = getIntent().getExtras();
        myId = Integer.parseInt(bundle.getString("id"));
        myRow = Integer.parseInt(bundle.getString("row"));


        findViewMethod();
        onClickMeThod();
    }

    private void onClickMeThod() {
        imgHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer = MediaPlayer.create(ActivityPractice.this, R.raw.click);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                Intent intent = new Intent(ActivityPractice.this, ActivityAllAlphabet.class);
                startActivity(intent);
            }
        });
        readHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer = MediaPlayer.create(ActivityPractice.this, R.raw.click);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                Intent intent = new Intent(ActivityPractice.this, ActivityReadStoreis.class);
                intent.putExtra("id",myId+"");
                startActivity(intent);





            }
        });
        buildWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer = MediaPlayer.create(ActivityPractice.this, R.raw.click);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                Intent intent = new Intent(ActivityPractice.this, ActivityBuildWord.class);
                intent.putExtra("id", myId + "");
                startActivity(intent);

            }
        });
        soundAndSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer = MediaPlayer.create(ActivityPractice.this, R.raw.click);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                Intent intent = new Intent(ActivityPractice.this, ActivitySoundAndSign.class);
                if (myId == 1 | myId == 69 | myId == 73 | myId == 74) {
                    final Dialog dialog = new Dialog(ActivityPractice.this);
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog.setContentView(R.layout.custom_dialog);
                    TextView txt = (TextView) dialog.findViewById(R.id.textView);
                    txt.setText("دانشجو کوچولوی عزیزم انجام این تمرین برای این حرف نیاز نیست");
                    Button dismissButton = (Button) dialog.findViewById(R.id.button);
                    dismissButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });
                    dialog.show();

                } else {
                    intent.putExtra("id", myId + "");
                    intent.putExtra("row", myRow + "");
                    startActivity(intent);
                }

            }
        });
        imgPaint_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer = MediaPlayer.create(ActivityPractice.this, R.raw.click);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                Intent intent = new Intent(ActivityPractice.this, ActivityPaint.class);
                startActivity(intent);
            }
        });
        homeWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer = MediaPlayer.create(ActivityPractice.this, R.raw.click);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                Intent intent = new Intent(ActivityPractice.this, ActivityHomeWork.class);
                intent.putExtra("newId", myId + "");
                startActivity(intent);
            }
        });
        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer = MediaPlayer.create(ActivityPractice.this, R.raw.click);
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
        findInSentence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer = MediaPlayer.create(ActivityPractice.this, R.raw.click);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                Intent intent = new Intent(ActivityPractice.this, ActivityFindIntoSentence.class);
                intent.putExtra("newId", myId + "");
                startActivity(intent);
            }
        });
    }

    private void findViewMethod() {
        imgHome = findViewById(R.id.imgMyHome);
        imgPaint_2 = findViewById(R.id.paint_2);
        homeWork = findViewById(R.id.homeWork);
        imgback = findViewById(R.id.imgBack);
        findInSentence = findViewById(R.id.find_into_sentence);
        soundAndSign = findViewById(R.id.build_word);
        buildWord = findViewById(R.id.biuldWord);
        readHistory = findViewById(R.id.historyRead);

    }
}
