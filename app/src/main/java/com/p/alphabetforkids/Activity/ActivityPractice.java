package com.p.alphabetforkids.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.p.alphabetforkids.ActivityFindIntoSentence;
import com.p.alphabetforkids.R;

public class ActivityPractice extends AppCompatActivity {
    ImageView imgPaint_2,homeWork, imgback,findInSentence;
    private  int myId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);

        //   گرفتن ایدی
        Bundle bundle = getIntent().getExtras();
        myId = Integer.parseInt(bundle.getString("id"));


        findViewMethod();
        onClickMeThod();
    }

    private void onClickMeThod() {
        imgPaint_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityPractice.this,ActivityPaint.class);
                startActivity(intent);
            }
        });
        homeWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityPractice.this,ActivityHomeWork.class);
                intent.putExtra("newId", myId+"");
                startActivity(intent);
            }
        });
        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        findInSentence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityPractice.this, ActivityFindIntoSentence.class);
                intent.putExtra("newId", myId+"");
                startActivity(intent);
            }
        });
    }

    private void findViewMethod() {
        imgPaint_2 = findViewById(R.id.paint_2);
        homeWork = findViewById(R.id.homeWork);
        imgback = findViewById(R.id.imgBack);
        findInSentence = findViewById(R.id.find_into_sentence);

    }
}
