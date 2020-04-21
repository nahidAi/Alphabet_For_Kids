package com.p.alphabetforkids.fragment;

import android.content.SharedPreferences;
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

import static android.content.Context.MODE_PRIVATE;

public class Fragment6 extends Fragment {
    ImageView img1;
    TextView txt1;
    int myId;

    public Fragment6() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_6, container, false);
        img1 = view.findViewById(R.id.img_1);
        txt1 = view.findViewById(R.id.textView1);


        myId= ActivityReadStoreis.sharedPreferences .getInt("idForFragment", 0);

        setStories();
        return view;


    }

    public void setStories() {
        if (myId == 1) {
            txt1.setText(R.string.a_page1);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_a)
                    .into(img1);

        } if (myId == 2) {
            txt1.setText(R.string.b_page1);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_b)
                    .into(img1);

        }if (myId == 3) {
            txt1.setText(R.string.aa_page1);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_aa)
                    .into(img1);

        }if (myId == 4) {
            txt1.setText(R.string.d_page1);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_d)
                    .into(img1);

        }if (myId == 5) {
            txt1.setText(R.string.m_page1);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_mim)
                    .into(img1);

        }if (myId == 6) {
            txt1.setText(R.string.sin_page1);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_sin)
                    .into(img1);

        }if (myId == 7) {
            txt1.setText(R.string.oo_page1);
            Picasso
                    .with(getContext())
                    .load(R.drawable.h_ooo)
                    .into(img1);

        }if (myId == 8) {
            txt1.setText(R.string.t_page1);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_t)
                    .into(img1);

        }if (myId == 9) {
            txt1.setText(R.string.r_page1);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_r)
                    .into(img1);

        }if (myId == 10) {
            txt1.setText(R.string.n_page1);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_non)
                    .into(img1);

        }if (myId == 11) {
            txt1.setText(R.string.ei_page1);
            Picasso
                    .with(getContext())
                    .load(R.drawable.h_ei)
                    .into(img1);

        }if (myId == 12) {
            txt1.setText(R.string.z_page1);
            Picasso
                    .with(getContext())
                    .load(R.drawable.h_z)
                    .into(img1);

        }if (myId == 13) {
            txt1.setText(R.string.ea_page1);
            Picasso
                    .with(getContext())
                    .load(R.drawable.h_ea)
                    .into(img1);

        }if (myId == 14) {
            txt1.setText(R.string.shin_page1);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_shin)
                    .into(img1);

        }if (myId == 15) {
            txt1.setText(R.string.i_page1);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_i)
                    .into(img1);

        }if (myId == 16) {
            txt1.setText(R.string.o_page1);
            Picasso
                    .with(getContext())
                    .load(R.drawable.h_o)
                    .into(img1);

        }if (myId == 17) {
            txt1.setText(R.string.k_page1);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_kaf)
                    .into(img1);

        }if (myId == 18) {
            txt1.setText(R.string.v_page1);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_vav)
                    .into(img1);

        }if (myId == 19) {
            txt1.setText(R.string.p_page1);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_p)
                    .into(img1);

        }if (myId == 20) {
            txt1.setText(R.string.ghaf_page1);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_ghaf)
                    .into(img1);

        }if (myId == 21) {
            txt1.setText(R.string.f_page1);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_f)
                    .into(img1);

        }if (myId == 22) {
            txt1.setText(R.string.kh_page1);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_kh)
                    .into(img1);

        }if (myId == 23) {
            txt1.setText(R.string.gh_page1);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_gh)
                    .into(img1);

        }
        if (myId == 67) {
            txt1.setText(R.string.lam_page1);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_lam)
                    .into(img1);

        } if (myId == 68) {
            txt1.setText(R.string.j_page1);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_j)
                    .into(img1);

        }if (myId == 69) {
            txt1.setText(R.string.o_estesna_page1);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_o_estesna)
                    .into(img1);

        }if (myId == 70) {
            txt1.setText(R.string.ha4_page1);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_ha4)
                    .into(img1);

        }if (myId == 71) {
            txt1.setText(R.string.ch_page1);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_ch)
                    .into(img1);

        }if (myId == 72) {
            txt1.setText(R.string.zh_page1);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_zh)
                    .into(img1);

        }if (myId == 73) {
            txt1.setText(R.string.kha_page1);
            Picasso
                    .with(getContext())
                    .load(R.drawable.h_kha)
                    .into(img1);

        }
        if (myId == 74) {
            txt1.setText(R.string.tashdid_page1);
            Picasso
                    .with(getContext())
                    .load(R.drawable.h_tashdid)
                    .into(img1);

        }
        if (myId == 75) {
            txt1.setText(R.string.sad_page1);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_sad)
                    .into(img1);

        } if (myId == 76) {
            txt1.setText(R.string.zal_page1);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_zal)
                    .into(img1);

        }if (myId == 77) {
            txt1.setText(R.string.ein_page1);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_ain)
                    .into(img1);

        }if (myId == 78) {
            txt1.setText(R.string.ccc_page1);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_ccc)
                    .into(img1);

        }if (myId == 79) {
            txt1.setText(R.string.h_page1);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_h)
                    .into(img1);

        }if (myId == 80) {
            txt1.setText(R.string.zad_page1);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_zad)
                    .into(img1);

        }if (myId == 81) {
            txt1.setText(R.string.ta_page1);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_ta)
                    .into(img1);

        }if (myId == 82) {
            txt1.setText(R.string.ghein_page1);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_ghein)
                    .into(img1);

        }

 if (myId == 83) {
            txt1.setText(R.string.za_page1);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_za)
                    .into(img1);



        }


    }
}
