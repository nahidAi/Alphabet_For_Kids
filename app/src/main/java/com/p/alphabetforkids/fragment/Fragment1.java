package com.p.alphabetforkids.fragment;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.p.alphabetforkids.Activity.ActivityReadStoreis;
import com.p.alphabetforkids.Activity.ActivitySoundAndSign;
import com.p.alphabetforkids.R;
import com.squareup.picasso.Picasso;

import androidx.fragment.app.Fragment;
import pl.droidsonroids.gif.GifImageView;

public class Fragment1 extends Fragment {
    ImageView img6;
    TextView txt6;
    int myId;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_1, container, false);
        img6 = view.findViewById(R.id.img_6);
        txt6 = view.findViewById(R.id.textView_6);



        myId= ActivityReadStoreis.sharedPreferences .getInt("idForFragment", 0);

        setStories();
        return view;
    }
    public void setStories() {
        if (myId == 1) {
            txt6.setText("خوشحالی یعنی درس جدیدی یاد گرفته باشی :)");
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_a)
                    .into(img6);

        }if (myId == 2) {
            txt6.setText("خوشحالی یعنی درس جدیدی یاد گرفته باشی :)");
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_b)
                    .into(img6);

        }if (myId == 3) {
            txt6.setText("مطالعه کن، تمرین کن، تکرار کن.آفرین  نو گل زرنگم");
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_aa)
                    .into(img6);

        }if (myId == 4) {
            txt6.setText("هر روز بهتر از دیروزی  آفرین گل من!");
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_d)
                    .into(img6);

        }if (myId == 5) {
            txt6.setText(R.string.m_page6);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_mim)
                    .into(img6);

        }if (myId == 6) {
            txt6.setText(R.string.sin_page6);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_sin)
                    .into(img6);

        }if (myId == 7) {
            txt6.setText(R.string.oo_page6);
            Picasso
                    .with(getContext())
                    .load(R.drawable.h_ooo)
                    .into(img6);

        }if (myId == 8) {
            txt6.setText(R.string.t_page6);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_t)
                    .into(img6);

        }if (myId == 9) {
            txt6.setText(R.string.r_page6);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_r)
                    .into(img6);

        }if (myId == 10) {
            txt6.setText(R.string.n_page6);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_non)
                    .into(img6);

        }if (myId == 11) {
            txt6.setText(R.string.ei_page6);
            Picasso
                    .with(getContext())
                    .load(R.drawable.h_ei)
                    .into(img6);

        }if (myId == 12) {
            txt6.setText(R.string.z_page6);
            Picasso
                    .with(getContext())
                    .load(R.drawable.h_z)
                    .into(img6);

        }if (myId == 12) {
            txt6.setText(R.string.ea_page6);
            Picasso
                    .with(getContext())
                    .load(R.drawable.h_ea)
                    .into(img6);

        }if (myId == 14) {
            txt6.setText(R.string.shin_page6);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_shin)
                    .into(img6);

        }if (myId == 15) {
            txt6.setText(R.string.i_page6);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_i)
                    .into(img6);

        }if (myId == 17) {
            txt6.setText(R.string.k_page6);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_kaf)
                    .into(img6);

        }if (myId == 18) {
            txt6.setText(R.string.v_page6);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_vav)
                    .into(img6);

        }if (myId == 19) {
            txt6.setText(R.string.p_page6);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_p)
                    .into(img6);

        }if (myId == 20) {
            txt6.setText(R.string.ghaf_page6);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_ghaf)
                    .into(img6);

        }if (myId == 21) {
            txt6.setText(R.string.f_page6);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_f)
                    .into(img6);

        }if (myId == 22) {
            txt6.setText(R.string.kh_page6);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_kh)
                    .into(img6);

        }if (myId == 23) {
            txt6.setText(R.string.gh_page6);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_gh)
                    .into(img6);

        } if (myId == 67) {
            txt6.setText(R.string.lam_page6);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_lam)
                    .into(img6);

        }if (myId == 68) {
            txt6.setText(R.string.j_page6);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_j)
                    .into(img6);

        }
        if (myId == 69) {
            txt6.setText(R.string.o_estesna_page6);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_o_estesna)
                    .into(img6);

        }if (myId == 70) {
            txt6.setText(R.string.ha4_page6);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_ha4)
                    .into(img6);

        }if (myId == 71) {
            txt6.setText(R.string.ch_page6);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_ch)
                    .into(img6);

        }if (myId == 72) {
            txt6.setText(R.string.zh_page6);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_zh)
                    .into(img6);

        }if (myId == 73) {
            txt6.setText(R.string.kha_page6);
            Picasso
                    .with(getContext())
                    .load(R.drawable.h_kha)
                    .into(img6);

        }
        if (myId == 74) {
            txt6.setText(R.string.tashdid_page6);
            Picasso
                    .with(getContext())
                    .load(R.drawable.h_tashdid)
                    .into(img6);

        }
        if (myId == 75) {
            txt6.setText(R.string.sad_page6);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_sad)
                    .into(img6);

        }if (myId == 76) {
            txt6.setText(R.string.zal_page6);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_zal)
                    .into(img6);

        }if (myId == 77) {
            txt6.setText(R.string.ein_page6);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_ain)
                    .into(img6);

        }if (myId == 78) {
            txt6.setText(R.string.ccc_page6);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_ccc)
                    .into(img6);

        }if (myId == 79) {
            txt6.setText(R.string.h_page6);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_h)
                    .into(img6);

        }if (myId == 80) {
            txt6.setText(R.string.zad_page6);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_zad)
                    .into(img6);

        }if (myId == 81) {
            txt6.setText(R.string.ta_page6);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_ta)
                    .into(img6);

        }if (myId == 82) {
            txt6.setText(R.string.ghein_page6);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_ghein)
                    .into(img6);

        }

        if (myId == 83) {
            txt6.setText(R.string.za_page6);
            Picasso
                    .with(getContext())
                    .load(R.drawable.jashn)
                    .into(img6);




        }


    }
}
