package com.p.alphabetforkids.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetView;
import com.p.alphabetforkids.DrawingView;
import com.p.alphabetforkids.R;

public class ActivityHomeWork extends AppCompatActivity implements View.OnClickListener {
    private DrawingView drawView;
    private ImageButton currPaint, drawBtn, eraseBtn, undoBtn;
    SharedPreferences sharedPreferences;
    private float smallBrush, mediumBrush;
    private int id;
    ImageView imgback, imgMyHome,imghelp;
    boolean isShowTapTargetView = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_work);




        //فول اسکرین کردن صفحه
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //   گرفتن ایدی
        Bundle bundle = getIntent().getExtras();
        id = Integer.parseInt(bundle.getString("newId"));

        imgback = findViewById(R.id.imgBack);
        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(ActivityHomeWork.this, R.raw.click);
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
        imgMyHome = findViewById(R.id.imgMyHome);
        imgMyHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(ActivityHomeWork.this, R.raw.click);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                Intent intent = new Intent(ActivityHomeWork.this, ActivityAllAlphabet.class);
                startActivity(intent);
            }
        });


        drawView = (DrawingView) findViewById(R.id.drawing);
        LinearLayout paintlayout = (LinearLayout) findViewById(R.id.paint_colors);
        currPaint = (ImageButton) paintlayout.getChildAt(0);
        currPaint.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.paint_pressed));

        smallBrush = getResources().getInteger(R.integer.small_size);
        mediumBrush = getResources().getInteger(R.integer.medium_size);


        drawBtn = findViewById(R.id.draw_btn);
        drawBtn.setOnClickListener(this);
        drawView.setLastBrushSize(mediumBrush);
        eraseBtn = findViewById(R.id.erase_btn);
        eraseBtn.setOnClickListener(this);

        undoBtn = findViewById(R.id.undo_btn);
        undoBtn.setOnClickListener(this);


        switchMethodForHomeWork();
        imghelp = findViewById(R.id.imgHelp);
        imghelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(ActivityHomeWork.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.custom_dialog);
                TextView txt = (TextView) dialog.findViewById(R.id.textView);
                txt.setText("گلم در این بخش میتونی قلم مناسب و رنگ دلخواه رو انتخاب کنی و روش نوشتن حروف الفبا رو تمرین کنی");
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

        sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
        boolean showHelp = sharedPreferences.getBoolean("TapTargetView_home_work", false);
        if (showHelp == false) {
            final Drawable drawable = ContextCompat.getDrawable(this, R.drawable.ic_help_black_24dp);
            TapTargetView.showFor(this,
                    TapTarget.forView(findViewById(R.id.imgHelp), "راهنمای تمرین", "گلم در این بخش میتونی قلم مناسب و رنگ دلخواه رو انتخاب کنی و روش نوشتن حروف الفبا رو تمرین کنی")
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
            editor1.putBoolean("TapTargetView_home_work", isShowTapTargetView);
            editor1.apply();
        }

    }


    public void paintClicked(View view) {
        drawView.setErase(false);
        drawView.setBrushSize(drawView.getLastBrushSize());
        if (view != currPaint) {
            ImageButton imgView = (ImageButton) view;
            String color = view.getTag().toString();
            drawView.setColor(color);

            imgView.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.paint_pressed));
            currPaint.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.paint));
            currPaint = (ImageButton) view;
        }

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.draw_btn) {
            final Dialog brushDialog = new Dialog(this);
            brushDialog.setTitle("سایز قلم");
            brushDialog.setContentView(R.layout.brush_chooser_home_work);

            ImageButton smallBtn = brushDialog.findViewById(R.id.small_brush);
            smallBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    drawView.setBrushSize(smallBrush);
                    drawView.setLastBrushSize(smallBrush);
                    drawView.setErase(false);
                    brushDialog.dismiss();
                }
            });
            ImageButton mediumBtn = brushDialog.findViewById(R.id.medium_brush);
            mediumBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    drawView.setBrushSize(mediumBrush);
                    drawView.setLastBrushSize(mediumBrush);
                    drawView.setErase(false);
                    brushDialog.dismiss();
                }
            });

            brushDialog.show();
        } else if (view.getId() == R.id.erase_btn) {
            final Dialog brushDialog = new Dialog(this);
            brushDialog.setTitle("سایز پاک کن");
            brushDialog.setContentView(R.layout.brush_chooser);

            ImageButton smallBtn = (ImageButton) brushDialog.findViewById(R.id.small_brush);
            smallBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    drawView.setErase(true);
                    drawView.setBrushSize(smallBrush);
                    brushDialog.dismiss();
                }
            });
            ImageButton mediumBtn = (ImageButton) brushDialog.findViewById(R.id.medium_brush);
            mediumBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    drawView.setErase(true);
                    drawView.setBrushSize(mediumBrush);
                    brushDialog.dismiss();
                }
            });
            ImageButton largeBtn = (ImageButton) brushDialog.findViewById(R.id.large_brush);
            largeBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    drawView.setErase(true);
                    brushDialog.dismiss();
                }
            });
            brushDialog.show();


        } else if (view.getId() == R.id.undo_btn) {
            drawView.startnew();
        }


    }

    public void switchMethodForHomeWork() {
        switch (id) {
            case 1:
                drawView.setBackgroundResource(R.drawable.h_a);

                break;
            case 2:
                drawView.setBackgroundResource(R.drawable.h_b);
                break;
            case 3:
                drawView.setBackgroundResource(R.drawable.h_aa);
                break;
            case 4:
                drawView.setBackgroundResource(R.drawable.h_d);
                break;
            case 5:
                drawView.setBackgroundResource(R.drawable.h_m);
                break;
            case 6:
                drawView.setBackgroundResource(R.drawable.h_cin);
                break;
            case 7:
                drawView.setBackgroundResource(R.drawable.h_ooo);
                break;
            case 8:
                drawView.setBackgroundResource(R.drawable.h_t);
                break;
            case 9:
                drawView.setBackgroundResource(R.drawable.h_r);
                break;
            case 10:
                drawView.setBackgroundResource(R.drawable.h_non);
                break;
            case 11:
                drawView.setBackgroundResource(R.drawable.h_ei);
                break;
            case 12:
                drawView.setBackgroundResource(R.drawable.h_z);
                break;
            case 13:
                drawView.setBackgroundResource(R.drawable.h_ea);
                break;
            case 14:
                drawView.setBackgroundResource(R.drawable.h_shin);
                break;
            case 15:
                drawView.setBackgroundResource(R.drawable.h_i);
                break;
            case 16:
                drawView.setBackgroundResource(R.drawable.h_o);
                break;
            case 17:
                drawView.setBackgroundResource(R.drawable.h_kaf);
                break;
            case 18:
                drawView.setBackgroundResource(R.drawable.h_v);
                break;
            case 19:
                drawView.setBackgroundResource(R.drawable.h_p);
                break;
            case 20:
                drawView.setBackgroundResource(R.drawable.h_ghaf);
                break;
            case 21:
                drawView.setBackgroundResource(R.drawable.h_f);
                break;
            case 22:
                drawView.setBackgroundResource(R.drawable.h_kh);
                break;
            case 23:
                drawView.setBackgroundResource(R.drawable.h_gh);
                break;
            case 67:
                drawView.setBackgroundResource(R.drawable.h_lam);
                break;
            case 68:
                drawView.setBackgroundResource(R.drawable.h_j);
                break;
            case 69:
                drawView.setBackgroundResource(R.drawable.h_oo);
                break;
            case 70:
                drawView.setBackgroundResource(R.drawable.h_ha);
                break;
            case 71:
                drawView.setBackgroundResource(R.drawable.h_ch);
                break;
            case 72:
                drawView.setBackgroundResource(R.drawable.h_zh);
                break;
            case 73:
                drawView.setBackgroundResource(R.drawable.h_kha);
                break;
            case 74:
                drawView.setBackgroundResource(R.drawable.h_tashdid);
                break;
            case 75:
                drawView.setBackgroundResource(R.drawable.h_sad);
                break;
            case 76:
                drawView.setBackgroundResource(R.drawable.h_zal);
                break;
            case 77:
                drawView.setBackgroundResource(R.drawable.h_ain);
                break;
            case 78:
                drawView.setBackgroundResource(R.drawable.h_ccc);
                break;
            case 79:
                drawView.setBackgroundResource(R.drawable.h_h);
                break;
            case 80:
                drawView.setBackgroundResource(R.drawable.h_za);
                break;
            case 81:
                drawView.setBackgroundResource(R.drawable.h_ta);
                break;
            case 82:
                drawView.setBackgroundResource(R.drawable.h_ghein);
                break;
            case 83:
                drawView.setBackgroundResource(R.drawable.h_za);
                break;
        }
    }


}

