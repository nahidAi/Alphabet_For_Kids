package com.p.alphabetforkids.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.p.alphabetforkids.R;

public class ActivityContactUs extends AppCompatActivity {
    LinearLayout lnrEmail;
    LinearLayout lnrComment;
    ImageView imgback, imgHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        // فول اسکرین کردن صفحه
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        lnrEmail = findViewById(R.id.lnr_email);
        lnrComment = findViewById(R.id.lnr_comment);
        lnrComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_EDIT);
                intent.setData(Uri.parse("bazaar://details?id=" + "com.p.alphabetforkids"));
                intent.setPackage("com.farsitel.bazaar");
                startActivity(intent);

            }
        });
        lnrEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* Intent email = new Intent(android.content.Intent.ACTION_SEND);
                email.setType("na.mehr20@gmail.com");*/

                SendEmail();

            }
        });
        imgback = findViewById(R.id.imgBack);
        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });
        imgHome = findViewById(R.id.imgMyHome);
        imgHome.setVisibility(View.GONE);
    }
    private void SendEmail() {
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "na.mehr20@gmail.com", null));
        intent.putExtra("android.intent.extra.SUBJECT", "Send From Application Android");
        startActivity(Intent.createChooser(intent, "لطفا انتخاب کنید...  :"));
    }
}
