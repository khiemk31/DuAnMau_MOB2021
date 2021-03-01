package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.myapplication.Fragment.NguoiDung_Fragment;
import com.example.myapplication.Fragment.LoaiSach_Fragment;
import com.example.myapplication.Fragment.PhieuMuon_Fragment;

public class PagerAdapter extends FragmentStatePagerAdapter {
    public PagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new PhieuMuon_Fragment();
                break;
            case 1:
                fragment = new NguoiDung_Fragment();
                break;
            case 2:
                fragment = new LoaiSach_Fragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
