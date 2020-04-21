package com.p.alphabetforkids.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.p.alphabetforkids.R;

public class ActivityPurchase extends AppCompatActivity {
    ImageView imageToolbarBack;
    Button btnBuy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);

        imageToolbarBack = findViewById(R.id.imageToolbarBack);
        imageToolbarBack.setVisibility(View.GONE);

        btnBuy = findViewById(R.id.btnBuy);
        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });
    }


}
