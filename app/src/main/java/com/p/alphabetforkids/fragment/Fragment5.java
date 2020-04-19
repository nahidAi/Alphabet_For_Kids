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

public class Fragment5 extends Fragment {
    int myId;
    ImageView img2;
    TextView txt2;

    public Fragment5() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_5, container, false);
        img2 = view.findViewById(R.id.img_2);
        txt2 = view.findViewById(R.id.textView_2);

        myId = 1;

        myId = ActivityReadStoreis.sharedPreferences.getInt("idForFragment", 0);
        setStories();
        return view;
    }

    public void setStories() {
        if (myId == 1) {
            txt2.setText(R.string.a_page2);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_a)
                    .into(img2);

        } if (myId == 2) {
            txt2.setText(R.string.b_page2);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_b)
                    .into(img2);

        }if (myId == 3) {
            txt2.setText(R.string.aa_page2);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_aa)
                    .into(img2);

        }if (myId == 4) {
            txt2.setText(R.string.d_page2);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_d)
                    .into(img2);

        }if (myId == 5) {
            txt2.setText(R.string.m_page2);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_mim)
                    .into(img2);

        }if (myId == 6) {
            txt2.setText(R.string.sin_page2);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_sin)
                    .into(img2);

        }if (myId == 7) {
            txt2.setText(R.string.oo_page2);
            Picasso
                    .with(getContext())
                    .load(R.drawable.h_ooo)
                    .into(img2);

        }if (myId == 8) {
            txt2.setText(R.string.t_page2);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_t)
                    .into(img2);

        }if (myId == 9) {
            txt2.setText(R.string.r_page2);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_r)
                    .into(img2);

        }if (myId == 10) {
            txt2.setText(R.string.n_page2);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_non)
                    .into(img2);

        }if (myId == 11) {
            txt2.setText(R.string.ei_page2);
            Picasso
                    .with(getContext())
                    .load(R.drawable.h_ei)
                    .into(img2);

        }if (myId == 12) {
            txt2.setText(R.string.z_page2);
            Picasso
                    .with(getContext())
                    .load(R.drawable.h_z)
                    .into(img2);

        }if (myId == 12) {
            txt2.setText(R.string.ea_page2);
            Picasso
                    .with(getContext())
                    .load(R.drawable.h_ea)
                    .into(img2);

        }if (myId == 14) {
            txt2.setText(R.string.shin_page2);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_shin)
                    .into(img2);

        }if (myId == 15) {
            txt2.setText(R.string.i_page2);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_i)
                    .into(img2);

        }if (myId == 16) {
            txt2.setText(R.string.o_page2);
            Picasso
                    .with(getContext())
                    .load(R.drawable.h_o)
                    .into(img2);

        }if (myId == 17) {
            txt2.setText(R.string.k_page2);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_kaf)
                    .into(img2);

        }
        if (myId == 18) {
            txt2.setText(R.string.v_page2);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_vav)
                    .into(img2);

        }if (myId == 19) {
            txt2.setText(R.string.p_page2);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_p)
                    .into(img2);

        }if (myId == 20) {
            txt2.setText(R.string.ghaf_page2);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_ghaf)
                    .into(img2);

        }if (myId == 21) {
            txt2.setText(R.string.f_page2);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_f)
                    .into(img2);

        }if (myId == 22) {
            txt2.setText(R.string.kh_page2);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_kh)
                    .into(img2);

        }if (myId == 23) {
            txt2.setText(R.string.gh_page2);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_gh)
                    .into(img2);

        } if (myId == 67) {
            txt2.setText(R.string.lam_page2);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_lam)
                    .into(img2);

        }if (myId == 68) {
            txt2.setText(R.string.j_page2);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_j)
                    .into(img2);

        }if (myId == 69) {
            txt2.setText(R.string.o_estesna_page2);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_o_estesna)
                    .into(img2);

        }if (myId == 70) {
            txt2.setText(R.string.ha4_page2);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_ha4)
                    .into(img2);

        }if (myId == 71) {
            txt2.setText(R.string.ch_page2);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_ch)
                    .into(img2);

        }if (myId == 72) {
            txt2.setText(R.string.zh_page2);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_zh)
                    .into(img2);

        }if (myId == 73) {
            txt2.setText(R.string.kha_page2);
            Picasso
                    .with(getContext())
                    .load(R.drawable.h_kha)
                    .into(img2);

        }
        if (myId == 74) {
            txt2.setText(R.string.tashdid_page2);
            Picasso
                    .with(getContext())
                    .load(R.drawable.h_tashdid)
                    .into(img2);

        }
        if (myId == 75) {
            txt2.setText(R.string.sad_page2);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_sad)
                    .into(img2);

        }if (myId == 76) {
            txt2.setText(R.string.zal_page2);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_zal)
                    .into(img2);

        }if (myId == 77) {
            txt2.setText(R.string.ein_page2);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_ain)
                    .into(img2);

        }if (myId == 78) {
            txt2.setText(R.string.ccc_page2);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_ccc)
                    .into(img2);

        }if (myId == 79) {
            txt2.setText(R.string.h_page2);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_h)
                    .into(img2);

        }if (myId == 80) {
            txt2.setText(R.string.zad_page2);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_zad)
                    .into(img2);

        }if (myId == 81) {
            txt2.setText(R.string.ta_page2);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_ta)
                    .into(img2);

        }if (myId == 82) {
            txt2.setText(R.string.ghein_page2);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_ghein)
                    .into(img2);

        }

        if (myId == 83) {
            txt2.setText(R.string.za_page2);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_za)
                    .into(img2);



        }

    }
}
