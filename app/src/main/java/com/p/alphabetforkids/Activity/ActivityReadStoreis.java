package com.p.alphabetforkids.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
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
    TextView storyName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_stories);

        //گرفتن آیدی
        Bundle bundle = getIntent().getExtras();
        myId = Integer.parseInt(bundle.getString("id"));

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
        storyName = findViewById(R.id.txtstoryname);

    }

    public void setStories() {
        if (myId == 1) {
            storyName.setText("پروانه ها");
           /* Bundle bundle1 = new Bundle();
            bundle1.putString("id", myId + "");
            Tab6 tab6 = new Tab6();
            tab6.setArguments(bundle1);*/

            /*Tab5 tab5 = new Tab5();
            tab5.setArguments(bundle1);

            Tab4 tab4 = new Tab4();
            tab4.setArguments(bundle1);

            Tab3 tab3 = new Tab3();
            tab3.setArguments(bundle1);

            Tab2 tab2 = new Tab2();
            tab2.setArguments(bundle1);

            Tab1 tab1 = new Tab1();
            tab1.setArguments(bundle1);*/
        }


        if (myId == 2) {
            storyName.setText("گربه پشمالو");
        }
        if (myId == 3) {
            storyName.setText("لاک پشت و خرگوش");
        }
        if (myId == 4) {
            storyName.setText("لاک پشت و خرگوش");
        }
        if (myId == 5) {
            storyName.setText("لاک پشت و خرگوش");
        }
        if (myId == 6) {
            storyName.setText("لاک پشت و خرگوش");
        }
        if (myId == 7) {
            storyName.setText("لاک پشت و خرگوش");
        }
        if (myId == 8) {
            storyName.setText("لاک پشت و خرگوش");
        }
        if (myId == 9) {
            storyName.setText("لاک پشت و خرگوش");
        }
        if (myId == 10) {
            storyName.setText("لاک پشت و خرگوش");
        }
        if (myId == 11) {
            storyName.setText("لاک پشت و خرگوش");
        }
        if (myId == 12) {
            storyName.setText("لاک پشت و خرگوش");
        }
        if (myId == 13) {
            storyName.setText("لاک پشت و خرگوش");
        }
        if (myId == 14) {
            storyName.setText("لاک پشت و خرگوش");
        }
        if (myId == 15) {
            storyName.setText("لاک پشت و خرگوش");
        }
        if (myId == 16) {
            storyName.setText("لاک پشت و خرگوش");
        }
        if (myId == 17) {
            storyName.setText("لاک پشت و خرگوش");
        }
        if (myId == 18) {
            storyName.setText("لاک پشت و خرگوش");
        }
        if (myId == 19) {
            storyName.setText("لاک پشت و خرگوش");
        }
        if (myId == 20) {
            storyName.setText("لاک پشت و خرگوش");
        }
        if (myId == 21) {
            storyName.setText("لاک پشت و خرگوش");
        }
        if (myId == 22) {
            storyName.setText("لاک پشت و خرگوش");
        }
        if (myId == 23) {
            storyName.setText("لاک پشت و خرگوش");
        }
        if (myId == 67) {
            storyName.setText("لاک پشت و خرگوش");
        }
        if (myId == 68) {
            storyName.setText("لاک پشت و خرگوش");
        }
        if (myId == 69) {
            storyName.setText("لاک پشت و خرگوش");
        }
        if (myId == 70) {
            storyName.setText("لاک پشت و خرگوش");
        }
        if (myId == 71) {
            storyName.setText("لاک پشت و خرگوش");
        }
        if (myId == 72) {
            storyName.setText("لاک پشت و خرگوش");
        }
        if (myId == 73) {
            storyName.setText("لاک پشت و خرگوش");
        }
        if (myId == 74) {
            storyName.setText("لاک پشت و خرگوش");
        }
        if (myId == 75) {
            storyName.setText("لاک پشت و خرگوش");
        }
        if (myId == 76) {
            storyName.setText("لاک پشت و خرگوش");
        }
        if (myId == 77) {
            storyName.setText("لاک پشت و خرگوش");
        }
        if (myId == 78) {
            storyName.setText("لاک پشت و خرگوش");
        }
        if (myId == 79) {
            storyName.setText("لاک پشت و خرگوش");
        }
        if (myId == 80) {
            storyName.setText("لاک پشت و خرگوش");
        }
        if (myId == 81) {
            storyName.setText("لاک پشت و خرگوش");
        }
        if (myId == 82) {
            storyName.setText("لاک پشت و خرگوش");
        }
        if (myId == 83) {
            storyName.setText("لاک پشت و خرگوش");
        }


    }


}
