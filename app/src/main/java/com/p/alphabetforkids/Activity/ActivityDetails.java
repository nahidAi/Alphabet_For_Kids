package com.p.alphabetforkids.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.p.alphabetforkids.R;

public class ActivityDetails extends AppCompatActivity {
    ImageView imgbackRight,imagbackLeft,imgMusic,imgHome,imgEdit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        findView();
        onClick();

        //فول اسکرین کردن صفحه
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


    }
    public void findView(){
        imagbackLeft = findViewById(R.id.back_left);
        imgbackRight = findViewById(R.id.back_right);
        imgMusic = findViewById(R.id.music);
        imgHome = findViewById(R.id.home);
        imgEdit = findViewById(R.id.edit);
    }
    public  void onClick(){
        imagbackLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ActivityDetails.this, "clicked", Toast.LENGTH_SHORT).show();
            }
        });
        imgbackRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ActivityDetails.this, "clicked", Toast.LENGTH_SHORT).show();
            }
        });
        imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ActivityDetails.this, "clicked", Toast.LENGTH_SHORT).show();
            }
        });
        imgHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ActivityDetails.this, "clicked", Toast.LENGTH_SHORT).show();
            }
        });
        imgMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ActivityDetails.this, "clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
