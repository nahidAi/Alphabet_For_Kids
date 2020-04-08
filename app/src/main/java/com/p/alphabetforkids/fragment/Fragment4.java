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

public class Fragment4 extends Fragment {
    ImageView img3;
    TextView txt3;
    int myId;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_4, container, false);
        img3 = view.findViewById(R.id.img_3);
        txt3 = view.findViewById(R.id.textView_3);


        myId= ActivityReadStoreis.sharedPreferences .getInt("idForFragment", 0);

        setStories();
        return view;
    }
    public void setStories() {
        if (myId == 1) {
            txt3.setText(R.string.a_page3);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_a)
                    .into(img3);

        } if (myId == 2) {
            txt3.setText(R.string.b_page3);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_b)
                    .into(img3);

        }if (myId == 3) {
            txt3.setText(R.string.aa_page3);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_aa)
                    .into(img3);

        }if (myId == 4) {
            txt3.setText(R.string.d_page3);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_d)
                    .into(img3);

        }if (myId == 5) {
            txt3.setText(R.string.m_page3);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_mim)
                    .into(img3);

        }if (myId == 6) {
            txt3.setText(R.string.sin_page3);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_sin)
                    .into(img3);

        }if (myId == 7) {
            txt3.setText(R.string.oo_page3);
            Picasso
                    .with(getContext())
                    .load(R.drawable.h_ooo)
                    .into(img3);

        }if (myId == 8) {
            txt3.setText(R.string.t_page3);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_t)
                    .into(img3);

        }if (myId == 9) {
            txt3.setText(R.string.r_page3);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_r)
                    .into(img3);

        }if (myId == 10) {
            txt3.setText(R.string.n_page3);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_non)
                    .into(img3);

        }if (myId == 11) {
            txt3.setText(R.string.ei_page3);
            Picasso
                    .with(getContext())
                    .load(R.drawable.h_ei)
                    .into(img3);

        }if (myId == 12) {
            txt3.setText(R.string.z_page3);
            Picasso
                    .with(getContext())
                    .load(R.drawable.h_z)
                    .into(img3);

        }if (myId == 12) {
            txt3.setText(R.string.ea_page3);
            Picasso
                    .with(getContext())
                    .load(R.drawable.h_ea)
                    .into(img3);

        }if (myId == 14) {
            txt3.setText(R.string.shin_page3);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_shin)
                    .into(img3);

        }if (myId == 15) {
            txt3.setText(R.string.i_page3);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_i)
                    .into(img3);

        }if (myId == 17) {
            txt3.setText(R.string.k_page3);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_kaf)
                    .into(img3);

        }if (myId == 18) {
            txt3.setText(R.string.v_page3);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_vav)
                    .into(img3);

        }if (myId == 19) {
            txt3.setText(R.string.p_page3);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_p)
                    .into(img3);

        }if (myId == 20) {
            txt3.setText(R.string.ghaf_page3);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_ghaf)
                    .into(img3);

        }if (myId == 21) {
            txt3.setText(R.string.f_page3);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_f)
                    .into(img3);

        }if (myId == 22) {
            txt3.setText(R.string.kh_page3);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_kh)
                    .into(img3);

        }if (myId == 23) {
            txt3.setText(R.string.gh_page3);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_gh)
                    .into(img3);

        } if (myId == 67) {
            txt3.setText(R.string.lam_page3);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_lam)
                    .into(img3);

        }if (myId == 68) {
            txt3.setText(R.string.j_page3);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_j)
                    .into(img3);

        }if (myId == 69) {
            txt3.setText(R.string.o_estesna_page3);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_o_estesna)
                    .into(img3);

        }if (myId == 70) {
            txt3.setText(R.string.ha4_page3);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_ha4)
                    .into(img3);

        }if (myId == 71) {
            txt3.setText(R.string.ch_page3);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_ch)
                    .into(img3);

        }
        if (myId == 72) {
            txt3.setText(R.string.zh_page3);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_zh)
                    .into(img3);

        }if (myId == 73) {
            txt3.setText(R.string.kha_page3);
            Picasso
                    .with(getContext())
                    .load(R.drawable.h_kha)
                    .into(img3);

        }
        if (myId == 74) {
            txt3.setText(R.string.tashdid_page3);
            Picasso
                    .with(getContext())
                    .load(R.drawable.h_tashdid)
                    .into(img3);

        }
        if (myId == 75) {
            txt3.setText(R.string.sad_page3);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_sad)
                    .into(img3);

        }if (myId == 76) {
            txt3.setText(R.string.zal_page3);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_zal)
                    .into(img3);

        }if (myId == 77) {
            txt3.setText(R.string.ein_page3);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_ain)
                    .into(img3);

        }if (myId == 78) {
            txt3.setText(R.string.ccc_page3);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_ccc)
                    .into(img3);

        }if (myId == 79) {
            txt3.setText(R.string.h_page3);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_h)
                    .into(img3);

        }if (myId == 80) {
            txt3.setText(R.string.zad_page3);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_zad)
                    .into(img3);

        }if (myId == 81) {
            txt3.setText(R.string.ta_page3);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_ta)
                    .into(img3);

        }if (myId == 82) {
            txt3.setText(R.string.ghein_page3);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_ghein)
                    .into(img3);

        }

        if (myId == 83) {
            txt3.setText(R.string.za_page3);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_za)
                    .into(img3);



        }


    }
}
