package com.p.alphabetforkids.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.p.alphabetforkids.fragment.Fragment1;
import com.p.alphabetforkids.fragment.Fragment2;
import com.p.alphabetforkids.fragment.Fragment3;
import com.p.alphabetforkids.fragment.Fragment4;
import com.p.alphabetforkids.fragment.Fragment5;
import com.p.alphabetforkids.fragment.Fragment6;

public class Pager extends FragmentStatePagerAdapter {
    int tabCount;
    public Pager(@NonNull FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount= tabCount;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Fragment1 fragment1 = new Fragment1();
                return fragment1;
            case 1:
                Fragment2 fragment2 = new Fragment2();
                return fragment2;
            case 2:
                Fragment3 fragment3 = new Fragment3();
                return fragment3;
            case 3:
                Fragment4 fragment4 = new Fragment4();
                return fragment4;
            case 4:
                Fragment5 fragment5 = new Fragment5();
                return fragment5;
            case 5:
                Fragment6 fragment6 = new Fragment6();
                return fragment6;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
