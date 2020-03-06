package com.p.alphabetforkids.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.p.alphabetforkids.R;

public class ActivityPractice extends AppCompatActivity {
    ImageView imgPaint_2,homeWork, imgback,findInSentence, soundAndSign;
    private  int myId;
    private  int myRow;

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
        soundAndSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityPractice.this, ActivitySoundAndSign.class);
                if (myId==1|myId==69|myId==73|myId==74){
                    final AlertDialog.Builder builder = new AlertDialog.Builder(ActivityPractice.this);
                    builder.setMessage("عزیزم این تمرین برای این حرف فعال نیست ");
                    builder.setCancelable(true);
                    builder.setPositiveButton("باشه", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                           builder.setCancelable(true);
                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                   // Toast.makeText(ActivityPractice.this, "این تمرین برای سایر حروف طراحی شده است", Toast.LENGTH_SHORT).show();
                }else {
                    intent.putExtra("id",myId+"");
                    intent.putExtra("row",myRow+"");
                    startActivity(intent);
                }

            }
        });
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
        soundAndSign = findViewById(R.id.build_word);

    }
}
