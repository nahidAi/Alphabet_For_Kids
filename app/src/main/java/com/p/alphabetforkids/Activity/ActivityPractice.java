package com.p.alphabetforkids.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.p.alphabetforkids.R;

public class ActivityPractice extends AppCompatActivity {
    ImageView imgPaint_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);
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
    }

    private void findViewMethod() {
        imgPaint_2 = findViewById(R.id.paint_2);
    }
}
