package com.p.alphabetforkids.Activity;

import androidx.appcompat.app.AppCompatActivity;
import mehdi.sakout.aboutpage.AboutPage;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.p.alphabetforkids.R;

public class ActivityContactUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_contact_us);

        // فول اسکرین کردن صفحه
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        View aboutPage = new AboutPage(this)
                .isRTL(true)
                .setImage(R.drawable.web_hi_res_512)
                .setDescription(" تیم برنامه نویسی 'wia developers' ")
                .addGroup("ارتباط با ما")
                .addEmail("na.mehr20@gmail.com")
                .create();
        setContentView(aboutPage);
    }
}
