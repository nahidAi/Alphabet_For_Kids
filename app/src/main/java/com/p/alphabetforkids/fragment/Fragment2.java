package com.p.alphabetforkids.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.p.alphabetforkids.Activity.ActivityReadStoreis;
import com.p.alphabetforkids.R;
import com.squareup.picasso.Picasso;

import androidx.fragment.app.Fragment;
import pl.droidsonroids.gif.GifImageView;

public class Fragment2 extends Fragment {
    ImageView img5;
    TextView txt5;
    int myId;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_2, container, false);
        img5 = view.findViewById(R.id.img_5);
        txt5 = view.findViewById(R.id.textView_5);



        myId= ActivityReadStoreis.sharedPreferences .getInt("idForFragment", 0);

        setStories();
        return view;
    }
    public void setStories() {
        if (myId == 1) {
            txt5.setText("نتیجه هر چی که باشه من بهت افتخار می کنم کوچولوی خوشگلم");
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_a)
                    .into(img5);

        }if (myId == 2) {
            txt5.setText("تو می تونی تو سخت ترین امتحانا هم نتیجه ی خوبی بگیری");
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_b)
                    .into(img5);

        }if (myId == 3) {
            txt5.setText("تو می تونی تو سخت ترین امتحانا هم نتیجه ی خوبی بگیری");
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_aa)
                    .into(img5);

        }if (myId == 4) {
            txt5.setText("تو بهترینی! آفرین دانش آموز زرنگ :)");
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_d)
                    .into(img5);

        }if (myId == 5) {
            txt5.setText(R.string.m_page5);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_mim)
                    .into(img5);

        }if (myId == 6) {
            txt5.setText(R.string.sin_page5);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_sin)
                    .into(img5);

        }if (myId == 7) {
            txt5.setText(R.string.oo_page5);
            Picasso
                    .with(getContext())
                    .load(R.drawable.h_ooo)
                    .into(img5);

        }if (myId == 8) {
            txt5.setText(R.string.t_page5);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_t)
                    .into(img5);

        }if (myId == 9) {
            txt5.setText(R.string.r_page5);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_r)
                    .into(img5);

        }if (myId == 10) {
            txt5.setText(R.string.n_page5);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_non)
                    .into(img5);

        }if (myId == 11) {
            txt5.setText(R.string.ei_page5);
            Picasso
                    .with(getContext())
                    .load(R.drawable.h_ei)
                    .into(img5);

        }if (myId == 12) {
            txt5.setText(R.string.z_page5);
            Picasso
                    .with(getContext())
                    .load(R.drawable.h_z)
                    .into(img5);

        }if (myId == 12) {
            txt5.setText(R.string.ea_page5);
            Picasso
                    .with(getContext())
                    .load(R.drawable.h_ea)
                    .into(img5);

        }if (myId == 14) {
            txt5.setText(R.string.shin_page5);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_shin)
                    .into(img5);

        }if (myId == 15) {
            txt5.setText(R.string.i_page5);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_i)
                    .into(img5);

        }if (myId == 16) {
            txt5.setText(R.string.o_page5);
            Picasso
                    .with(getContext())
                    .load(R.drawable.h_o)
                    .into(img5);

        }if (myId == 17) {
            txt5.setText(R.string.k_page5);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_kaf)
                    .into(img5);

        }if (myId == 18) {
            txt5.setText(R.string.v_page5);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_vav)
                    .into(img5);

        }if (myId == 19) {
            txt5.setText(R.string.p_page5);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_p)
                    .into(img5);

        }if (myId == 20) {
            txt5.setText(R.string.ghaf_page5);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_ghaf)
                    .into(img5);

        }if (myId == 21) {
            txt5.setText(R.string.f_page5);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_f)
                    .into(img5);

        }if (myId == 22) {
            txt5.setText(R.string.kh_page5);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_kh)
                    .into(img5);

        }if (myId == 23) {
            txt5.setText(R.string.gh_page5);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_gh)
                    .into(img5);

        } if (myId == 67) {
            txt5.setText(R.string.lam_page5);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_lam)
                    .into(img5);

        }if (myId == 68) {
            txt5.setText(R.string.j_page5);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_j)
                    .into(img5);

        }if (myId == 69) {
            txt5.setText(R.string.o_estesna_page5);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_o_estesna)
                    .into(img5);

        }if (myId == 70) {
            txt5.setText(R.string.ha4_page5);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_ha4)
                    .into(img5);

        }if (myId == 71) {
            txt5.setText(R.string.ch_page5);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_ch)
                    .into(img5);

        }if (myId == 72) {
            txt5.setText(R.string.zh_page5);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_zh)
                    .into(img5);

        }if (myId == 73) {
            txt5.setText(R.string.kha_page5);
            Picasso
                    .with(getContext())
                    .load(R.drawable.h_kha)
                    .into(img5);

        }
        if (myId == 74) {
            txt5.setText(R.string.tashdid_page5);
            Picasso
                    .with(getContext())
                    .load(R.drawable.h_tashdid)
                    .into(img5);

        }
        if (myId == 75) {
            txt5.setText(R.string.sad_page5);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_sad)
                    .into(img5);

        }if (myId == 76) {
            txt5.setText(R.string.zal_page5);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_zal)
                    .into(img5);

        }if (myId == 77) {
            txt5.setText(R.string.ein_page5);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_ain)
                    .into(img5);

        }if (myId == 78) {
            txt5.setText(R.string.ccc_page5);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_ccc)
                    .into(img5);

        }if (myId == 79) {
            txt5.setText(R.string.h_page5);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_h)
                    .into(img5);

        }if (myId == 80) {
            txt5.setText(R.string.zad_page5);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_zad)
                    .into(img5);

        }if (myId == 81) {
            txt5.setText(R.string.ta_page5);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_ta)
                    .into(img5);

        }if (myId == 82) {
            txt5.setText(R.string.ghein_page5);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_ghein)
                    .into(img5);

        }

        if (myId == 83) {
            txt5.setText(R.string.za_page5);
            Picasso
                    .with(getContext())
                    .load(R.drawable.jashn)
                    .into(img5);
            


        }


    }
}
