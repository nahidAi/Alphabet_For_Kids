package com.p.alphabetforkids.Activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.p.alphabetforkids.Adapter.AdapterAlfabet;
import com.p.alphabetforkids.Model.ItemModel;
import com.p.alphabetforkids.R;
import com.p.alphabetforkids.WellcomActivity;
import com.p.alphabetforkids.database.MyDatabase;
import com.p.alphabetforkids.util.IabHelper;
import com.p.alphabetforkids.util.IabResult;
import com.p.alphabetforkids.util.Inventory;
import com.p.alphabetforkids.util.Purchase;


import java.util.ArrayList;
import java.util.List;

public class ActivityAllAlphabet extends AppCompatActivity implements IabHelper.OnIabSetupFinishedListener, IabHelper.QueryInventoryFinishedListener {

    MyDatabase database;
    RecyclerView recyclerView;
    AdapterAlfabet adapterAlfabet;
    List<ItemModel> itemModelList = new ArrayList<>();
    ProgressDialog progressDialog;
    private IabHelper iabHelper;
    private static final String PRODUCT_PREMIUM_ACCOUNT = "alphabet_for_kids";
    private boolean isPremiumAccount = false;
    public Button btnBuy;
    ImageView img_contact_us;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_alphabet);

        if (getIntent().getBooleanExtra("EXIT", false)) {
            finish();
        }

        checkAccount();

        img_contact_us = findViewById(R.id.contact_us);
        img_contact_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityAllAlphabet.this, ActivityContactUs.class);
                startActivity(intent);
            }
        });


        // فول اسکرین کردن صفحه
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        database = new MyDatabase(this);


        itemModelList = database.allAlphabet();
        recyclerView = findViewById(R.id.recyclerview);
        adapterAlfabet = new AdapterAlfabet(this, itemModelList);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
        recyclerView.setAdapter(adapterAlfabet);

        btnBuy = findViewById(R.id.btnBuy);
        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    purchasePremiumAccount();
                }catch (Exception e){
                    Toast.makeText(ActivityAllAlphabet.this, "از نصب برنامه بازار روی گوشی خودتون اطمینان دارید؟ دسترسی به اینترنت دارید؟دوباره امتحان کنید", Toast.LENGTH_LONG).show();
                }

            }
        });
        sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
        sharedPreferences.getBoolean("buy_is_ok", false);
        boolean isBuy = sharedPreferences.getBoolean("buy_is_ok", false);
        if (isBuy == true) {
            btnBuy.setVisibility(View.GONE);
        }

    }


    // برای اینکه دکمه بک گوشی کار نکنه
    @Override
    public void onBackPressed() {
        iabHelper = null;

        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);



    }

    // داده های فیک برای تست
    private List<ItemModel> generateItem() {
        List<ItemModel> models = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            ItemModel itemModel = new ItemModel();
            itemModel.setTitle("سـ  س ");
            models.add(itemModel);

        }
        return models;
    }


    @Override
    public void onIabSetupFinished(IabResult result) {
        if (result.isSuccess()) {
            List<String> products = new ArrayList<>();
            products.add(PRODUCT_PREMIUM_ACCOUNT);
            iabHelper.queryInventoryAsync(true, products, this);
        } else {
            Toast.makeText(this, "خطایی بوجود آمده است", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onQueryInventoryFinished(IabResult result, Inventory inv) {
        if (result.isSuccess()) {
            Purchase purchase = inv.getPurchase(PRODUCT_PREMIUM_ACCOUNT);

            if (purchase != null) {
                isPremiumAccount = true;


            }
        }

    }

    public void checkAccount() {
        iabHelper = new IabHelper(this, "MIHNMA0GCSqGSIb3DQEBAQUAA4G7ADCBtwKBrwDGIMXT/RKS03RPQ+yBErGENa968ocMSV6xwWUlabGBal2fLnuvSfK52N1LB3QQrp+rHsqIF4kRzYgqZFKFEToxC7i21XgIg6f7JigwD4X/zpnznvJhYh1+OOfH7oLQ6EUG9UnPONVSnzhWwXY1oF5K0njZfUIZu0QXCt8W/bTUVlPqzhpcsupltRpvInTtrGpYQ94yj4b2vCnCpB26ZlU9mb3jrXgxZMnRCbPUFOkCAwEAAQ==");
        iabHelper.startSetup(this);
    }

    public void purchasePremiumAccount() {
        iabHelper.launchPurchaseFlow(this, PRODUCT_PREMIUM_ACCOUNT, 1001, new IabHelper.OnIabPurchaseFinishedListener() {
            @Override
            public void onIabPurchaseFinished(IabResult result, Purchase info) {
                if (result.isSuccess()) {
                    if (info != null) {
                        // صفحه جزییات رو برای کاربد بازش کن
                        isPremiumAccount = true;
                        btnBuy.setVisibility(View.GONE);

                        sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putBoolean("buy_is_ok", isPremiumAccount);
                        editor.apply();


                    } else {
                        Toast.makeText(ActivityAllAlphabet.this, "متاسفانه خرید انجام نشد", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 1001) {
            iabHelper.handleActivityResult(requestCode, resultCode, data);
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (iabHelper != null) {
            iabHelper = null;
            iabHelper.dispose();
        }
    }


    public boolean getIsPremiumAccount() {
        return isPremiumAccount;
    }


}



