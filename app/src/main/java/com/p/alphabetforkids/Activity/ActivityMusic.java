package com.p.alphabetforkids.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.p.alphabetforkids.R;

public class ActivityMusic extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    private int Id;
    ImageView imgToolbarBack,imgMyHome;
    private Button btnMusicText;
    private TextView txtMusic;
    private Boolean isVisible = true;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        //فول اسکرین کردن صفحه
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
       //   گرفتن ایدی
        Bundle bundle = getIntent().getExtras();
        Id = Integer.parseInt(bundle.getString("id"));
        switchMethodForPoetry();
        findView_onClick();
    }

    public void switchMethodForPoetry() {
        switch (Id) {
            case 1:
                mediaPlayer = MediaPlayer.create(ActivityMusic.this, R.raw.m_a);
                mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(100,100);
                mediaPlayer.start();

                break;
            case 2:
                mediaPlayer = MediaPlayer.create(ActivityMusic.this, R.raw.m_b);
                mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(100,100);
                mediaPlayer.start();
                break;
            case 3:
                mediaPlayer = MediaPlayer.create(ActivityMusic.this, R.raw.m_aa);
                mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(100,100);
                mediaPlayer.start();
                break;
            case 4:
                mediaPlayer = MediaPlayer.create(ActivityMusic.this, R.raw.m_d);
                mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(100,100);
                mediaPlayer.start();
                break;
            case 5:
                mediaPlayer = MediaPlayer.create(ActivityMusic.this, R.raw.m_m);
                mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(100,100);
                mediaPlayer.start();
                break;
            case 6:
                mediaPlayer = MediaPlayer.create(ActivityMusic.this, R.raw.m_c);
                mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(100,100);
                mediaPlayer.start();
                break;
            case 7:
                mediaPlayer = MediaPlayer.create(ActivityMusic.this, R.raw.m_ooo);
                mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(100,100);
                mediaPlayer.start();
                break;
            case 8:
                mediaPlayer = MediaPlayer.create(ActivityMusic.this, R.raw.m_t);
                mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(100,100);
                mediaPlayer.start();
                break;
            case 9:
                mediaPlayer = MediaPlayer.create(ActivityMusic.this, R.raw.m_r);
                mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(100,100);
                mediaPlayer.start();
                break;
            case 10:
                mediaPlayer = MediaPlayer.create(ActivityMusic.this, R.raw.m_n);
                mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(100,100);
                mediaPlayer.start();
                break;
            case 11:
                mediaPlayer = MediaPlayer.create(ActivityMusic.this, R.raw.m_ei);
                mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(100,100);
                mediaPlayer.start();
                break;
            case 12:
                mediaPlayer = MediaPlayer.create(ActivityMusic.this, R.raw.m_z);
                mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(100,100);
                mediaPlayer.start();
                break;
            case 13:
                mediaPlayer = MediaPlayer.create(ActivityMusic.this, R.raw.m_ea);
                mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(100,100);
                mediaPlayer.start();
                break;
            case 14:
                mediaPlayer = MediaPlayer.create(ActivityMusic.this, R.raw.m_sh);
                mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(100,100);
                mediaPlayer.start();
                break;
            case 15:
                mediaPlayer = MediaPlayer.create(ActivityMusic.this, R.raw.m_i);
                mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(100,100);
                mediaPlayer.start();
                break;
            case 16:
                mediaPlayer = MediaPlayer.create(ActivityMusic.this, R.raw.m_o);
                mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(100,100);
                mediaPlayer.start();
                break;
            case 17:
                mediaPlayer = MediaPlayer.create(ActivityMusic.this, R.raw.m_k);
                mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(100,100);
                mediaPlayer.start();
                break;
            case 18:
                mediaPlayer = MediaPlayer.create(ActivityMusic.this, R.raw.m_v);
                mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(100,100);
                mediaPlayer.start();
                break;
            case 19:
                mediaPlayer = MediaPlayer.create(ActivityMusic.this, R.raw.m_p);
                mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(100,100);
                mediaPlayer.start();
                break;
            case 20:
                mediaPlayer = MediaPlayer.create(ActivityMusic.this, R.raw.m_ghaf);
                mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(100,100);
                mediaPlayer.start();
                break;
            case 21:
                mediaPlayer = MediaPlayer.create(ActivityMusic.this, R.raw.m_f);
                mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(100,100);
                mediaPlayer.start();
                break;
            case 22:
                mediaPlayer = MediaPlayer.create(ActivityMusic.this, R.raw.m_kh);
                mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(100,100);
                mediaPlayer.start();
                break;
            case 23:
                mediaPlayer = MediaPlayer.create(ActivityMusic.this, R.raw.m_gh);
                mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(100,100);
                mediaPlayer.start();
                break;
            case 67:
                mediaPlayer = MediaPlayer.create(ActivityMusic.this, R.raw.m_l);
                mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(100,100);
                mediaPlayer.start();
                break;
            case 68:
                mediaPlayer = MediaPlayer.create(ActivityMusic.this, R.raw.m_j);
                mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(100,100);
                mediaPlayer.start();
                break;
            case 69:
                mediaPlayer = MediaPlayer.create(ActivityMusic.this, R.raw.oo);
                mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(100,100);
                mediaPlayer.start();
                break;
            case 70:
                mediaPlayer = MediaPlayer.create(ActivityMusic.this, R.raw.m_ha);
                mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(100,100);
                mediaPlayer.start();
                break;
            case 71:
                mediaPlayer = MediaPlayer.create(ActivityMusic.this, R.raw.m_ch);
                mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(100,100);
                mediaPlayer.start();
                break;
            case 72:
                mediaPlayer = MediaPlayer.create(ActivityMusic.this, R.raw.m_zh);
                mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(100,100);
                mediaPlayer.start();
                break;
            case 73:
                mediaPlayer = MediaPlayer.create(ActivityMusic.this, R.raw.m_kha);
                mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(100,100);
                mediaPlayer.start();
                break;
            case 74:
                mediaPlayer = MediaPlayer.create(ActivityMusic.this, R.raw.m_tashdid);
                mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(100,100);
                mediaPlayer.start();
                break;
            case 75:
                mediaPlayer = MediaPlayer.create(ActivityMusic.this, R.raw.m_sad);
                mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(100,100);
                mediaPlayer.start();
                break;
            case 76:
                mediaPlayer = MediaPlayer.create(ActivityMusic.this, R.raw.m_zal);
                mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(100,100);
                mediaPlayer.start();
                break;
            case 77:
                mediaPlayer = MediaPlayer.create(ActivityMusic.this, R.raw.m_ain);
                mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(100,100);
                mediaPlayer.start();
                break;
            case 78:
                mediaPlayer = MediaPlayer.create(ActivityMusic.this, R.raw.m_ccc);
                mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(100,100);
                mediaPlayer.start();
                break;
            case 79:
                mediaPlayer = MediaPlayer.create(ActivityMusic.this, R.raw.m_h);
                mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(100,100);
                mediaPlayer.start();
                break;
            case 80:
                mediaPlayer = MediaPlayer.create(ActivityMusic.this, R.raw.m_zad);
                mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(100,100);
                mediaPlayer.start();
                break;
            case 81:
                mediaPlayer = MediaPlayer.create(ActivityMusic.this, R.raw.m_ta);
                mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(100,100);
                mediaPlayer.start();
                break;
            case 82:
                mediaPlayer = MediaPlayer.create(ActivityMusic.this, R.raw.m_ghein);
                mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(100,100);
                mediaPlayer.start();
                break;
            case 83:
                mediaPlayer = MediaPlayer.create(ActivityMusic.this, R.raw.m_za);
                mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(100,100);
                mediaPlayer.start();
                break;
        }
    }

    public void findView_onClick() {
        imgMyHome = findViewById(R.id.imgMyHome);
        imgMyHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
                mediaPlayer = MediaPlayer.create(ActivityMusic.this, R.raw.click);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                Intent intent = new Intent(ActivityMusic.this, ActivityAllAlphabet.class);
                startActivity(intent);
            }
        });
        txtMusic = findViewById(R.id.txtMusic);

        imgToolbarBack = findViewById(R.id.imageToolbarBack);
        imgToolbarBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
                finish();
                mediaPlayer = MediaPlayer.create(ActivityMusic.this, R.raw.click);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

            }
        });
        btnMusicText = findViewById(R.id.btnMusicText);
        btnMusicText.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (isVisible){
                    txtMusic.setVisibility(View.VISIBLE);
                    isVisible=false;
                    btnMusicText.setText("حذف متن");
                }else  if (!isVisible){
                    txtMusic.setVisibility(View.GONE);
                    isVisible=true;
                    btnMusicText.setText(" متن  شعر");
                }


            }
        });
       setTextForPoetry();
    }

    // برای اینکه دکمه بک خود گوشی کار نکنه
   /* @Override
    public void onBackPressed() {

    }*/

    @SuppressLint("SetTextI18n")
    public void setTextForPoetry() {
        switch (Id) {
            case 1:
               txtMusic.setText(" آ ا\n\n"+"آ خوشگل اَست و زیبا\n"  +
                       "روی سرش یِک کُلاه\n" +
                       "خواهر اون بی کُلـاه\n" +
                       "دوست همه ی بچه ها\n");

                break;
            case 2:
               txtMusic.setText("بـ ب\n\n"+"وقتی که لبخند میزنی\n" +
                       "\" ب \" رو به یادت میاری\n" +
                       "خالی به زیر لب داره\n" +
                       "غیر آخر و آخر داره\n" +
                       "من \"ب\" آخر هستم \n" +
                       "همیشه آخر هستم\n" +
                       "دوستَم \" بـ \" غیر آخر\n" +
                       "هیچ وقت نمیاد آخر\n");
                break;
            case 19:
               txtMusic.setText(" پـ پ\n\n"+"(پ) که می گن من هستم درست شکل (ب) هستم\n" +
                       "\n" +
                       "سه نقطه گرد و کوچک پایین پام گذاشتم\n" +
                       "\n" +
                       "با (پ ) غیر آخرم اوٌل و وسط هستم\n" +
                       "\n" +
                       "پرستو پا و پر داره پرواز و خیلی دوست داره\n" +
                       "\n" +
                       "پدر بزرگ سوپ می پزه پروانه ها رو دوست داره\n");
                break;
            case 8:
               txtMusic.setText(" تـ ت\n\n"+"اسمت چیه (ب) هستی؟ نه نه من (ت) هستم\n" +
                       "من (ت) آخر هستم  بر روی خط نشستم\n" +
                       "با دوتا شکل زیبا  شبیه قایق هستم\n" +
                       "با (تـ ) غیرآخرم اول و وسط هستم\n");
                break;
            case 78:
               txtMusic.setText(" ثـ ث\n\n"+"ما هستيم دو برادر غيرآخر و آخر\n" +
                       "\n" +
                       "با (س،ص) همصدا هستيم از آنها جدا هستيم\n" +
                       "\n" +
                       "دو شكل داريم ،بچّه ها سه نقطه داريم بالا\n" +
                       "\n" +
                       "كشيده داريم صدا نشستيم در ثريّا\n" +
                       "\n" +
                       "آخر باعث هستيم در مثلّث نشستيم\n");
                break;
            case 68:
               txtMusic.setText(" جـ ج\n\n"+"اسمت چیه ؟( خ ) هستی نه نه من ( ج ) هستم\n" +
                       "\n" +
                       " یه نقطه ی خیلی کوچک پایین پام گذاشتم\n" +
                       "\n" +
                       "من ( ج ) آخر هستم آخر گنج نشستم\n" +
                       "\n" +
                       "در درس نارنج و برنج آخر پنج هم هستم\n" +
                       "\n" +
                       "با ( جـ ) غیر آخرم دو شکل زیبا هستم\n");
                break;
            case 71:
               txtMusic.setText(" چـ چ\n\n"+"چ اول چراغه دست نزنی چون داغه\n" +
                       "\n" +
                       "چراغ  رو سقف خونه  با سیمش آویزونه\n" +
                       "\n" +
                       "رو دیوار کلیدش با اون رنگ سفیدش\n" +
                       "\n" +
                       "به من میگه :« تیک و تیک ! روشن می خوای یا تاریک ؟»\n" +
                       "\n" +
                       "چراغ که روشن میشه ماه شب من میشه\n");
                break;
            case 79:
               txtMusic.setText(" حـ ح\n\n"+"ما دو نفر برادر غير آخر و آخر\n" +
                       "\n" +
                       "باهـ ـهـ ـه ه همصدا هستيم از آن ها جدا هستيم\n" +
                       "\n" +
                       "هيچ نقطه اي نيست با ما نه در پايين ،نه  بالا\n" +
                       "\n" +
                       "اوّل حوله هستيم تويِ صبحانه هستيم\n" +
                       "\n" +
                       "در آخر صبح هستيم در آخر صلح هستيم\n");
                break;
            case 22:
               txtMusic.setText(" خـ خ\n\n"+"ما دونفر برادر غیر آخر و آخر\n" +
                       "\n" +
                       "شکلی داریم خمیده صدا داریم کشیده\n" +
                       "\n" +
                       "آمده ایم در هر جا یک نقطه داریم  بالا\n" +
                       "\n" +
                       "اول خانه هستیم وسط شاخه هستیم\n" +
                       "\n" +
                       "آمدیم آخر نخ نشستیم آخر یخ\n");
                break;
            case 4:
               txtMusic.setText(" د\n\n"+"(د) کمرش شکسته تنها رو خط نشسته\n" +
                       "کمری دولا داره اخلاقی زیبا داره\n" +
                       "آمده در همه جا کشیده نیست این صدا\n" +
                       "هر جا صدایش کنید فقط یه شکلی هستش\n");
                break;
            case 76:
              txtMusic.setText(" ذ\n\n"+"چه شکل خوبی دارم چه رنگ و رویی دارم\n" +
                      "\n" +
                      "با ز هم صدا هستم   کمری دولا دارم\n" +
                      "\n" +
                      "شکل من هست مثل دال( د )در پیشانی دارم خال\n" +
                      "\n" +
                      "این خال همان نقطه است روی سرم خفته است\n" +
                      "\n" +
                      "آمده ایم در لذّت در لذیذ و در ذرّت\n");
                break;
            case 9:
              txtMusic.setText(" ر\n\n"+"کودک خوب و نازم من سرسره می سازم\n" +
                      "\n" +
                      "شکل سرسره دارم در سر نقطه ندارم\n" +
                      "\n" +
                      "در همه جا می آیم کشیده است صدایم\n" +
                      "\n" +
                      "در اول رام هستم در آخر ابر هستم\n");
                break;
            case 12:
               txtMusic.setText(" ز\n\n"+"ز شیرین زَبونم یه شکل دارم مثل کَمونم\n" +
                       "\n" +
                       "شکل سُرسُره دارم در سَر یک نُقطه دارم\n" +
                       "\n" +
                       "در همه جا می آیم کشیده است صِدایم\n" +
                       "\n" +
                       "هستم با  \" ر\" برابر ولی یک نقطه بر سَر\n");
                break;
            case 72:
               txtMusic.setText(" ژ\n\n"+"در ژاله و مَنيژه در ژاكت ژوليده\n" +
                       "\n" +
                       "در ژِله خوشمزه در گُل ها ی پژمرده\n" +
                       "\n" +
                       "روي خَط زَمينه ِصداي \" ژ\" آمده\n" +
                       "\n" +
                       "در جدول الفبا داره ، يك شِكل تنها\n");
                break;
            case 6:
               txtMusic.setText(" سـ س\n\n"+"(س) سه تا دندونه داره  آمده توی خونه \n" +
                       "سبد رو برمیداره  سیب توی اون میزاره\n" +
                       "من (س) آخر هستم همیشه آخر هستم\n" +
                       "دوستم (سـ) غیر آخر  هیچوقت نمیاد آخر\n");
                break;
            case 14:
                txtMusic.setText(" شـ ش\n\n"+"(ش) سه تا دندونه داره  بالاش سه تا نقطه داره\n" +
                        "(شـ) غیرآخر (ش) آخر   هستن دوتا برادر\n" +
                        "(شـ)غیرآخر در شکلات  (ش) آخر در کاسه آش  \n");
                break;
            case 75:
                txtMusic.setText(" صـ ص\n\n"+"صبح که از خواب پا میشم مثل یه گل وا میشم\n" +
                        "\n" +
                        "صورتم را می شویم تا که تمیز و ناز بشم\n" +
                        "\n" +
                        "ما دونفر برادر غیر آخر و آخر\n" +
                        "\n" +
                        "با سـ س هم صدا هستیم از آنها جدا هستیم\n" +
                        "\n" +
                        "آمده ایم در هر جا  کشیده داریم صدا\n" +
                        "\n" +
                        "در صابون و قرص هستیم  دو جای مخصوص هستیم\n");
                break;
            case 80:
               txtMusic.setText(" ضـ ض\n\n"+"ما هستيم دو برادر غير آخر و آخر\n" +
                       "\n" +
                       "با(ز-ذ)همصدا هستيم ازآن ها جدا هستيم\n" +
                       "\n" +
                       "دو شكل داريم بچّه ها كشيده است اين صدا\n" +
                       "\n" +
                       "نشسته ايم در قاضي  آمده ايم در رياضي\n");
                break;
            case 81:
              txtMusic.setText(" ط\n\n"+"\n" +
                      "بچّه ها من (طا) هستم  با(تـ ت)همصدا هستم\n" +
                      "\n" +
                      "يك شكل دارم بچّه ها  مي آيم در همه جا\n" +
                      "\n" +
                      "در هر كجا بيايم  با همين شكل مي آيم\n" +
                      "\n" +
                      "در سر نقطه ندارم كشيده نيست صدايم\n" +
                      "\n" +
                      "من هستم وسط سطل  در خط و طوطي و طبل\n");
                break;
            case 83:
               txtMusic.setText(" ظ\n\n"+"بچّه ها من ظا هستم  با ز همصدا هستم\n" +
                       "\n" +
                       "يك شكل دارم بچّه ها در همه جا مي آيم\n" +
                       "\n" +
                       "كشيده است صدايم  آمده ام در حافظ\n" +
                       "\n" +
                       "آخر خداحافظ\n");
                break;
            case 77:
               txtMusic.setText(" عـ ـعـ ـع ع\n\n"+"(عـ) عين غير آخرم من  اوّل و وسط ،نشستم\n" +
                       "\n" +
                       "مرا ببين در عاقل در مزرعه و عادل\n" +
                       "\n" +
                       "( ﻌ ) من عِين وسط هستم باز كرده ام،دو دستم\n" +
                       "\n" +
                       "در وسط مي نشينم دست دوستی مي گيرم\n" +
                       "\n" +
                       "( ﻊ )عين آخر چسبانم من دوست مهربانم\n" +
                       "\n" +
                       "مرا ببين در بَع بَع در موقع و مربّع\n" +
                       "\n" +
                       "(ع) آخرتنهايم تنها ی تنها هستم\n" +
                       "\n" +
                       "آمده ام،در شروع نشسته ام در طلوع\n");
                break;
            case 82:
               txtMusic.setText(" غـ ـغـ ـغ غ\n\n"+"ما چهار تا غين هستيم كنار هم نشستيم\n" +
                       "\n" +
                       "هم تنهاييم ،هم چسبان مهربانيم و خندان\n" +
                       "\n" +
                       "آمده ايم در هر جا يك نقطه داريم بالا\n" +
                       "\n" +
                       "نشسته ايم درباغچه آمده ايم در غنچه\n" +
                       "\n" +
                       "در آخر تيغ هستيم در آخر جيغ هستيم\n" +
                       "\n" +
                       "آمده ايم آخر باغ نشسته ایم  آخر داغ\n");
                break;
            case 21:
               txtMusic.setText(" فـ ف\n\n"+"فهمیدم و فهمیدم معلّم عزیزم\n" +
                       "بگو برام بدونم فکر کنم و بخونم\n" +
                       "این یکی غیر آخر با فکر میاد همیشه\n" +
                       "آهای آهای نگاه کن یه نقطه هم که روشه\n" +
                       "ف آخرشده خسته ببین آخر نشسته\n");
                break;
            case 23:
               txtMusic.setText(" قـ ق\n\n"+"ما دو نفر برادر غـیر آخـر و آخـر\n" +
                       "\n" +
                       "قد خمیده داریم درسر دو نقطه داریم\n" +
                       "\n" +
                       "قـ غیرآخر را نگاه کن کنار قند و قندون\n" +
                       "\n" +
                       "ق آخر چه خسته توی اُتاق نشسته\n");
                break;
            case 17:
               txtMusic.setText(" کـ ک\n\n"+"من ک آخر هستم\n" +
                       "\n" +
                       "همیشه آخر هستم\n" +
                       "\n" +
                       "دوستم کـ غیر آخر\n" +
                       "\n" +
                       "هیچ وقت نمیاد آخر\n" +
                       "\n" +
                       "اول کمرو هستم\n" +
                       "\n" +
                       "اول کمسو هستم\n" +
                       "\n" +
                       "آمده ام آخر باک\n" +
                       "\n" +
                       "نشسته ام آخر ساک\n");
                break;
            case 20:
               txtMusic.setText(" گـ گ\n\n"+"من (گ) آخر هستم همیشه آخر هستم\n" +
                       "دوستم (گـ) غیرآخر هیچوقت نمیاد آخر\n" +
                       "در اول گوش هستم  آخر برگ نشستم \n");
                break;
            case 67:
               txtMusic.setText(" لـ ل\n\n"+"ل ل ل، ل هستم ،من ل آخرِ هستم\n" +
                       "\n" +
                       "آخر سال،آخر شال،آخر مال نشستم\n" +
                       "\n" +
                       "با دو تا شكلِ زيبام من دوستِ بلبل هستم\n" +
                       "\n" +
                       "آخر گل،آخر كل،آخر سنبل نشستم\n");
                break;
            case 5:
               txtMusic.setText(" مـ م\n\n"+"م م م هستم  من (م) آخر هستم\n" +
                       "آخر حرف پرچم  آخر امام هستم\n" +
                       "ما (مـ) غیرآخرم اول و وسط هستم\n" +
                       "به حرف بعد از خودم حتما باید بچسبم\n");
                break;
            case 10:
               txtMusic.setText(" نـ ن\n\n"+"ن ن ن هستم   مثل یه کاسه هستم\n" +
                       "نقطه ای گرد و کوچک بالای سر گذاشتم\n" +
                       "اول و آخرنان آمده ام نشسته ام\n" +
                       "با (نـ) غیر آخرم  اول و وسط هستم\n");
                break;
            case 18:
               txtMusic.setText(" و\n\n"+"یک شکل دارم, تنهایم\n" +
                       "\n" +
                       "کشیده است,صدایم\n" +
                       "\n" +
                       "من که یک شکلی هستم\n" +
                       "\n" +
                       "در همه جا نشستم\n" +
                       "\n" +
                       "آمده ام در باور\n" +
                       "\n" +
                       "درسرو نشستم آخر\n");
                break;
            case 70:
               txtMusic.setText(" هـ ـهـ ـه ه\n\n"+"ما،چهار تابرادَر\n" +
                       "\n" +
                       "وسط و غیر آخر\n" +
                       "\n" +
                       "هم اول و هم آخر\n" +
                       "\n" +
                       "هم تنهاییم ،هم چسبان\n" +
                       "\n" +
                       "مهربانیم و خندان\n" +
                       "\n" +
                       "می گوییم، ای بچه ها\n" +
                       "\n" +
                       "کشیده است این صدا\n");
                break;
            case 15:
               txtMusic.setText(" یـ ی\n\n"+"من ی آخر هستم همیشه آخر هستم\n" +
                       "\n" +
                       "دوستم یـ غیر آخر هیچ وقت نمیاد آخر\n" +
                       "\n" +
                       "یـ غیر آخر منم رو خط دنباله داره منم\n" +
                       "\n" +
                       "دو نقطه دارم در پایین شکل من را خوب ببین\n");
                break;
            case 11:
              txtMusic.setText(" ایـ یـ ی ای\n\n"+"\n" +
                      "ما همگی (ایـ یـ ی ای) هستیم\n" +
                      "(ایـ) اولم (ایـ) اول اول ایران هستم\n" +
                      "(یـ) وسطم خوب میدونم در وسط میز هستم\n" +
                      "(ی) چسبان آخرم آخر سینی هستم\n" +
                      "(ای) آخرم تنها و بی درد سرم\n" +
                      "آخر میام همیشه در آخر قهوه ای  چسبیده هم نمیشه\n");
                break;
            case 3:
               txtMusic.setText("اَ  َ \n\n"+"(اَ) در اولم همیشه جایم عوض نمیشه\n" +
                       "قد درازی دارم کلاه رو کج میزارم\n" +
                       "آمده ام در اَنبار  اول اَبر و اَنار\n" +
                       "سواری می خورد او  -َ دوم کوچولو\n" +
                       "آمده در برادَر  نشسته در بَرابَر\n");
                break;
            case 13:
               txtMusic.setText(" اِ ِ ـه ه\n\n"+"ما همگی ( اِ –ِ  ـه ه) هستیم\n" +
                       "(اِ ) اولم  (اِ)  اول    همیشه در اولم\n" +
                       "(-ِ )غیر اولم من اما کمی ناقلام همیشه زیر حرفام\n" +
                       "(ـه )چسبان آخرم آروم و سر به زیرم\n" +
                       "(ه )آخرم تنها و بی دردسرم\n" +
                       "آخر میام همیشه  چسبیده هم نمیشه \n");
                break;
            case 16:
              txtMusic.setText(" اُ  ُ\n\n"+"من (اُ) اول هستم   قد بلندی دارم\n" +
                      "شکل قشنگی دارم  در اولم در اول\n" +
                      "در اولم بچه ها با یک نشان زیبا\n" +
                      "دوستم ( –ُ) غیر اول  هیچوقت نمیاد اول\n" +
                      "چون که کمی ناقلاست  همش سوار حرفاست\n");
                break;
            case 74:
               txtMusic.setText("ــّـ (تشدید)   وقتی دو حرف با هم باشه  اولی بی صدا باشه دومی با صدا باشه\n\n" +
                       "\n" +
                       "اولی رو بر می داریم   به جاش یه تشدید میزاریم\n");
                break;
            case 73:
                txtMusic.setText(" خوا\n\n"+"با هم هستیم  سه نفر صدا داریم ،دو نفر\n" +
                        "من که این شکلی \"و\" هستم در وسط ها نشستم\n" +
                        "نوشته می شوم من خوانده نمیشوم من\n" +
                        "در خواهر و خواب هستم در تخت خواب نشستم\n" +
                        "در هر جایی که هستم من بی صدا نشستم\n");
                break;
            case 69:
                txtMusic.setText(" و->اُ  \n\n"+"آهای آهای بچه ها  از جای خود زود پاشید\n" +
                        "هر جا که من رو دیدید خیلی مواظب باشید\n" +
                        "گول نخورید به شکلم شبیه واو یا اویم\n" +
                        "درباره ی صدام هم  می خوام برات بگویم\n" +
                        "من صدای اُ هستم از هر اُیی  جدایم\n" +
                        "در خود و نوک  یا خورشید  این شکلی من می آیم\n");
                break;
            case 7:
                txtMusic.setText(" او و\n\n"+"او اولّم  او اوّل   اوّل فقط می آیم\n" +
                        "خوب میدونی شبیه  گرگ می مونه صدایم\n" +
                        "امّا  و  غیر اوّل   صداش شبیه من هست\n" +
                        "مثل من او عصایی ندارد هرگز به دست\n" +
                        "او مثل توت و آلو  او آخر زردآلو\n");
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mediaPlayer.stop();
        finish();
    }
}
