package com.p.alphabetforkids.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import pl.droidsonroids.gif.GifImageView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.p.alphabetforkids.Adapter.Pager;
import com.p.alphabetforkids.R;
import com.wajahatkarim3.easyflipviewpager.BookFlipPageTransformer;

public class ActivityReadStoreis extends AppCompatActivity implements TabLayout.OnTabSelectedListener {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    MediaPlayer mediaPlayer;
    int myId;
    public static TextView storyName;
    public static GifImageView gifImageView;
    ImageView imgBack;
    public static SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_stories);


        final AlertDialog.Builder builder = new AlertDialog.Builder(ActivityReadStoreis.this);
        builder.setMessage("گلم از بزرگترها خواهش کن برات داستان الفبارو بخونن. یادت باشه برای ورق زدن صفحه انگشتت رو روی صفحه بکشی");
        builder.setCancelable(false);
        builder.setPositiveButton("باشه", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                builder.setCancelable(true);
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

        //گرفتن آیدی
        Bundle bundle = getIntent().getExtras();
        myId = Integer.parseInt(bundle.getString("id"));

        sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("idForFragment", myId);
        editor.apply();

        //فول اسکرین کردن صفحه
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        findViewMethod();


        tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        //Adding the tabs using addTab() method
        tabLayout.addTab(tabLayout.newTab().setText("Tab1"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab2"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab3"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab4"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab5"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab6"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setVisibility(View.GONE);


        //Initializing viewPager
        viewPager = (ViewPager) findViewById(R.id.pager);

        //Creating our pager adapter
        Pager adapter = new Pager(getSupportFragmentManager(), tabLayout.getTabCount());

        //Adding adapter to pager
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(6);
        BookFlipPageTransformer bookFlipPageTransformer = new BookFlipPageTransformer();
        bookFlipPageTransformer.setScaleAmountPercent(10f);
        viewPager.setPageTransformer(true, bookFlipPageTransformer);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if (state == 1) {
                    mediaPlayer = MediaPlayer.create(ActivityReadStoreis.this, R.raw.sound_pager);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
                }
            }
        });
        //Adding onTabSelectedListener to swipe views
        tabLayout.setOnTabSelectedListener(this);

        setStories();
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    public void findViewMethod() {
        gifImageView = findViewById(R.id.tashvigh_soti);
        storyName = findViewById(R.id.txtstoryname);
        imgBack = findViewById(R.id.imgBack);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });


    }

    public void setStories() {
        if (myId == 1) {
            storyName.setText("داستان نشانه آ ");
        }
        if (myId == 2) {
            storyName.setText("داستان نشانه ب ");
        }
        if (myId == 3) {
            storyName.setText("داستان نشانه اَ   َ ");
        }
        if (myId == 4) {
            storyName.setText("داستان نشانه د ");
        }
        if (myId == 5) {
            storyName.setText("داستان نشانه مـ م ");
        }
        if (myId == 6) {
            storyName.setText("داستان نشانه سـ س");
        }
        if (myId == 7) {
            storyName.setText("داستان نشانه او و ");
        }
        if (myId == 8) {
            storyName.setText("داستان نشانه تـ ت");
        }
        if (myId == 9) {
            storyName.setText("داستان نشانه ر");
        }
        if (myId == 10) {
            storyName.setText("داستان نشانه نـ ن");
        }
        if (myId == 11) {
            storyName.setText(" داستان نشانه ایـ یـ ی ای ");
        }
        if (myId == 12) {
            storyName.setText("داستان نشانه ز");
        }
        if (myId == 13) {
            storyName.setText("داستان نشانه اِ  ِ  ـه ه");
        }
        if (myId == 14) {
            storyName.setText("داستان نشانه شـ ش");
        }
        if (myId == 15) {
            storyName.setText("داستان نشانه یـ ی");
        }
        if (myId == 16) {
            storyName.setText(" داستان نشانه اُ ُ");
        }
        if (myId == 17) {
            storyName.setText("داستان نشانه کـ ک");
        }
        if (myId == 18) {
            storyName.setText("داستان نشانه و");
        }
        if (myId == 19) {
            storyName.setText("داستان نشانه پـ پ");
        }
        if (myId == 20) {
            storyName.setText("داستان نشانه گـ گ");
        }
        if (myId == 21) {
            storyName.setText("داستان نشانه فـ ف");
        }
        if (myId == 22) {
            storyName.setText("داستان نشانه خـ خ");
        }
        if (myId == 23) {
            storyName.setText("داستان نشانه قـ ق");
        }
        if (myId == 67) {
            storyName.setText("داستان نشانه لـ ل");
        }
        if (myId == 68) {
            storyName.setText("داستان نشانه جـ ج");
        }
        if (myId == 69) {
            storyName.setText("داستان نشانه و --> ُ");
        }
        if (myId == 70) {
            storyName.setText("داستان نشانه هـ ـهـ ـه ه");
        }
        if (myId == 71) {
            storyName.setText("داستان نشانه چـ چ");
        }
        if (myId == 72) {
            storyName.setText("داستان نشانه ژ");
        }
        if (myId == 73) {
            storyName.setText("داستان نشانه خوا");
        }
        if (myId == 74) {
            storyName.setText("داستان نشانه  ّ");
        }
        if (myId == 75) {
            storyName.setText("داستان نشانه صـ ص");
        }
        if (myId == 76) {
            storyName.setText("داستان نشانه ذ");
        }
        if (myId == 77) {
            storyName.setText("داستان نشانه عـ ـعـ ـع ع");
        }
        if (myId == 78) {
            storyName.setText("داستان نشانه ثـ ث");
        }
        if (myId == 79) {
            storyName.setText("داستان نشانه حـ ح");
        }
        if (myId == 80) {
            storyName.setText("داستان نشانه ضـ ض");
        }
        if (myId == 81) {
            storyName.setText("داستان نشانه ط");
        }
        if (myId == 82) {
            storyName.setText("داستان نشانه غـ ـغـ ـغ غ");
        }
        if (myId == 83) {
            storyName.setText("داستان نشانه ظ");

        }


    }


}
