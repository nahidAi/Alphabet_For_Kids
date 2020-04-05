package com.p.alphabetforkids.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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


        View view = inflater.inflate(R.layout.tab_5, container, false);
        img2 = view.findViewById(R.id.img_2);
        txt2 = view.findViewById(R.id.textView_2);

        myId = 1;


        setStories();
        return view;
    }

    public void setStories() {
        if (myId == 1) {
            txt2.setText("jddgdgl;dgdgdgdg jlgdgdrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbnnnnnnnnnnnnngjdgldgjdgldjdlgdjgdlgdjgdgrtioujgjgdgjdlgdjgdlgjdgd");
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_ccc)
                    .into(img2);

        }

    }
}
