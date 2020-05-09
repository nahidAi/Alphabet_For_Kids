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

public class Fragment3 extends Fragment {
    ImageView img4;
    TextView txt4;
    int myId;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_3, container, false);
        img4 = view.findViewById(R.id.img_4);
        txt4 = view.findViewById(R.id.textView_4);


        myId= ActivityReadStoreis.sharedPreferences .getInt("idForFragment", 0);

        setStories();
        return view;
    }
    public void setStories() {
        if (myId == 1) {
            txt4.setText("یاد گرفتن هیچ درسی سخت نیست، فقط بعضی وقتا باید یکم بیش تر تلاش کنی عزیزم");
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_a)
                    .into(img4);

        } if (myId == 2) {
            txt4.setText(R.string.b_page4);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_b)
                    .into(img4);

        }if (myId == 3) {
            txt4.setText("یاد گرفتن هیچ درسی سخت نیست، فقط بعضی وقتا باید یکم بیش تر تلاش کنی عزیزم");
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_aa)
                    .into(img4);

        }if (myId == 4) {
            txt4.setText(R.string.d_page4);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_d)
                    .into(img4);

        }if (myId == 5) {
            txt4.setText(R.string.m_page4);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_mim)
                    .into(img4);

        }if (myId == 6) {
            txt4.setText(R.string.sin_page4);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_sin)
                    .into(img4);

        }if (myId == 7) {
            txt4.setText(R.string.oo_page4);
            Picasso
                    .with(getContext())
                    .load(R.drawable.h_ooo)
                    .into(img4);

        }if (myId == 8) {
            txt4.setText(R.string.t_page4);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_t)
                    .into(img4);

        }if (myId == 9) {
            txt4.setText(R.string.r_page4);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_r)
                    .into(img4);

        }if (myId == 10) {
            txt4.setText(R.string.n_page4);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_non)
                    .into(img4);

        }if (myId == 11) {
            txt4.setText(R.string.ei_page4);
            Picasso
                    .with(getContext())
                    .load(R.drawable.h_ei_story)
                    .into(img4);

        }if (myId == 12) {
            txt4.setText(R.string.z_page4);
            Picasso
                    .with(getContext())
                    .load(R.drawable.h_z_story)
                    .into(img4);

        }if (myId == 13) {
            txt4.setText(R.string.ea_page4);
            Picasso
                    .with(getContext())
                    .load(R.drawable.h_ea_story)
                    .into(img4);

        }if (myId == 14) {
            txt4.setText(R.string.shin_page4);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_shin)
                    .into(img4);

        }if (myId == 15) {
            txt4.setText(R.string.i_page4);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_i)
                    .into(img4);

        }if (myId == 16) {
            txt4.setText(R.string.o_page4);
            Picasso
                    .with(getContext())
                    .load(R.drawable.h_o_story)
                    .into(img4);

        }if (myId == 17) {
            txt4.setText(R.string.k_page4);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_kaf)
                    .into(img4);

        }if (myId == 18) {
            txt4.setText(R.string.v_page4);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_vav)
                    .into(img4);

        }if (myId == 19) {
            txt4.setText(R.string.p_page4);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_p)
                    .into(img4);

        }if (myId == 20) {
            txt4.setText(R.string.ghaf_page4);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_ghaf)
                    .into(img4);

        }if (myId == 21) {
            txt4.setText(R.string.f_page4);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_f)
                    .into(img4);

        }if (myId == 22) {
            txt4.setText(R.string.kh_page4);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_kh)
                    .into(img4);

        }if (myId == 23) {
            txt4.setText(R.string.gh_page4);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_gh)
                    .into(img4);

        } if (myId == 67) {
            txt4.setText(R.string.lam_page4);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_lam)
                    .into(img4);

        }if (myId == 68) {
            txt4.setText(R.string.j_page4);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_j)
                    .into(img4);

        }if (myId == 69) {
            txt4.setText(R.string.o_estesna_page4);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_o_estesna)
                    .into(img4);

        }if (myId == 70) {
            txt4.setText(R.string.ha4_page4);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_ha4)
                    .into(img4);

        }if (myId == 71) {
            txt4.setText(R.string.ch_page4);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_ch)
                    .into(img4);

        }if (myId == 72) {
            txt4.setText(R.string.zh_page4);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_zh)
                    .into(img4);

        }if (myId == 73) {
            txt4.setText(R.string.kha_page4);
            Picasso
                    .with(getContext())
                    .load(R.drawable.h_kha_story)
                    .into(img4);

        }
        if (myId == 74) {
            txt4.setText(R.string.tashdid_page4);
            Picasso
                    .with(getContext())
                    .load(R.drawable.h_tashdid)
                    .into(img4);

        }
        if (myId == 75) {
            txt4.setText(R.string.sad_page4);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_sad)
                    .into(img4);

        }if (myId == 76) {
            txt4.setText(R.string.zal_page4);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_zal)
                    .into(img4);

        }if (myId == 77) {
            txt4.setText(R.string.ein_page4);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_ain)
                    .into(img4);

        }if (myId == 78) {
            txt4.setText(R.string.ccc_page4);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_ccc)
                    .into(img4);

        }if (myId == 79) {
            txt4.setText(R.string.h_page4);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_h)
                    .into(img4);

        }if (myId == 80) {
            txt4.setText(R.string.zad_page4);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_zad)
                    .into(img4);

        }if (myId == 81) {
            txt4.setText(R.string.ta_page4);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_ta)
                    .into(img4);

        }if (myId == 82) {
            txt4.setText(R.string.ghein_page4);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_ghein)
                    .into(img4);

        }

        if (myId == 83) {
            txt4.setText(R.string.za_page4);
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_za)
                    .into(img4);



        }


    }
}
