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

public class Fragment6 extends Fragment {
    ImageView img1;
    TextView txt1;
    int myId;

    public Fragment6() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.tab_6, container, false);
        img1 = view.findViewById(R.id.img_1);
        txt1 = view.findViewById(R.id.textView1);

        // myId = Integer.parseInt(getArguments().getString("id"));


        setStories();
        return view;


    }

    public void setStories() {
        if (myId == 1) {
            txt1.setText("jddgdgl;dgdgdgdg jlgdgdgjdgldgjdgldjdlgdjgdlgdjgdgrtioujgjgdgjdlgdjgdlgjdgd");
            Picasso
                    .with(getContext())
                    .load(R.drawable.story_ccc)
                    .into(img1);

        }

    }
}
