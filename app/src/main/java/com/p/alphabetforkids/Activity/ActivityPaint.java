package com.p.alphabetforkids.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.p.alphabetforkids.DrawingView;
import com.p.alphabetforkids.R;

import java.util.UUID;

public class ActivityPaint extends AppCompatActivity implements View.OnClickListener {
    private DrawingView drawView;
    private ImageButton currPaint, drawBtn,eraseBtn,newBtn,saveBtn;
    private float smallBrush, mediumBrush, largeBrush;
    private ImageView imgback,imgMyHome,imgHelp;
    MediaPlayer mediaPlayer;
    int re;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paint);

        imgHelp = findViewById(R.id.imgHelp);
        imgHelp.setVisibility(View.GONE);

        //فول اسکرین کردن صفحه
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        imgback = findViewById(R.id.imgBack);
        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer = MediaPlayer.create(ActivityPaint.this, R.raw.click);
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

                mediaPlayer = MediaPlayer.create(ActivityPaint.this, R.raw.click);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                Intent intent = new Intent(ActivityPaint.this, ActivityAllAlphabet.class);
                startActivity(intent);
            }
        });

        drawView = (DrawingView) findViewById(R.id.drawing);
        LinearLayout paintlayout = (LinearLayout) findViewById(R.id.paint_colors);
        currPaint = (ImageButton) paintlayout.getChildAt(0);
        currPaint.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.paint_pressed));

        smallBrush = getResources().getInteger(R.integer.small_size);
        mediumBrush = getResources().getInteger(R.integer.medium_size);
        largeBrush = getResources().getInteger(R.integer.large_size);

        drawBtn = findViewById(R.id.draw_btn);
        drawBtn.setOnClickListener(this);
        drawView.setLastBrushSize(mediumBrush);
        eraseBtn = findViewById(R.id.erase_btn);
        eraseBtn.setOnClickListener(this);

        newBtn = findViewById(R.id.new_btn);
        newBtn.setOnClickListener(this);

        saveBtn = findViewById(R.id.save_btn);
        saveBtn.setOnClickListener(this);




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
            brushDialog.setContentView(R.layout.brush_chooser);

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
            ImageButton largeBtn = brushDialog.findViewById(R.id.large_brush);
            largeBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    drawView.setBrushSize(largeBrush);
                    drawView.setLastBrushSize(largeBrush);
                    drawView.setErase(false);
                    brushDialog.dismiss();
                }
            });
            brushDialog.show();
        }
        else if (view.getId()==R.id.erase_btn){
            final Dialog brushDialog = new Dialog(this);
            brushDialog.setTitle("Eraser size");
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
                    drawView.setBrushSize(largeBrush);
                    brushDialog.dismiss();
                }
            });
            brushDialog.show();



        }
        else if (view.getId()==R.id.new_btn){
            AlertDialog.Builder newDialog = new AlertDialog.Builder(this);
            newDialog.setTitle("نقاشی جدید");
            newDialog.setMessage("عزیزم میخوای یک صفحه ی جدید باز کنی؟");
            newDialog.setPositiveButton("آره", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    drawView.startnew();
                    dialog.dismiss();
                }
            });
            newDialog.setNegativeButton("نه", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            newDialog.show();
        }

        else if (view.getId()==R.id.save_btn){
            AlertDialog.Builder newDialog = new AlertDialog.Builder(this);
            newDialog.setTitle("ذخیره نقاشی");
            newDialog.setMessage("عزیزم میخوای نقاشی رو توی گوشی ذخیره کنی؟");
            newDialog.setPositiveButton("آره", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if (re!=1){
                        ActivityCompat.requestPermissions(ActivityPaint.this,
                                new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                                1);
                        re = 1;
                    }


                    drawView.setDrawingCacheEnabled(true);
                    String imgSaved = MediaStore.Images.Media.insertImage(getContentResolver(),drawView.getDrawingCache(), UUID.randomUUID().toString()
                    +" .png", "drawing");
                    if (imgSaved!=null){
                        Toast saveToast = Toast.makeText(getApplicationContext()," گلم نقاشی در گالری ذخیره شد",Toast.LENGTH_SHORT);
                        saveToast.show();

                    }else {
                        Toast.makeText(ActivityPaint.this, "عه! ذخیره نشد", Toast.LENGTH_SHORT).show();
                    }
                    drawView.destroyDrawingCache();
                }
            });
            newDialog.setNegativeButton("نه", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            newDialog.show();

        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 1: {

                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    Toast.makeText(ActivityPaint.this, "Permission denied to read your External storage", Toast.LENGTH_SHORT).show();
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }
}
