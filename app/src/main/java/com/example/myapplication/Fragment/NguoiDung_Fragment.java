package com.example.myapplication.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.Adapter.NguoiDungAdapter;
import com.example.myapplication.DAO.ThuThu_DAO;
import com.example.myapplication.Object.ThuThu;
import com.example.myapplication.R;

import java.util.ArrayList;

public class NguoiDung_Fragment extends Fragment {
    @Override
    public void onStart() {
        super.onStart();
    }

    public NguoiDung_Fragment() {

    }

    private View rootview;
    NguoiDungAdapter adapter;
    ArrayList<ThuThu> list;
    ListView lv_nguoidung;
    ThuThu_DAO thuThu_dao;
    Button btnThemNguoiDung;
    EditText edUser, edPass,edRePass, edPhone, edFullName;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @NonNull ViewGroup container, @NonNull Bundle savedInstanceState) {

        rootview = inflater.inflate(R.layout.fragment_nguoidung, container, false);
//        initView();
        return rootview;
    }

//    private void initView() {
//        lv_nguoidung = rootview.findViewById(R.id.lvNguoiDung);
//        list = new ArrayList<>();
//        adapter = new NguoiDungAdapter(, R.layout.item_nguoi_dung, list);
//
//        adapter.notifyDataSetChanged();
//        lv_nguoidung.setAdapter(adapter);
//    }
}