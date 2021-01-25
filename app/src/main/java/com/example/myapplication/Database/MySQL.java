package com.example.myapplication.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.myapplication.DAO.HoaDon_DAO;
import com.example.myapplication.DAO.NguoiDung_DAO;
import com.example.myapplication.DAO.Sach_DAO;
import com.example.myapplication.DAO.TheLoai_DAO;

public class MySQL extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "dbBookManager";
    public static final int VERSION = 1;

    public MySQL(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(NguoiDung_DAO.SQL_NGUOI_DUNG);
        db.execSQL(TheLoai_DAO.SQL_THE_LOAI);
        db.execSQL(Sach_DAO.SQL_SACH);
        db.execSQL(HoaDon_DAO.SQL_HOA_DON);
//        db.execSQL(HoaDonChiTietDAO.SQL_HOA_DON_CHI_TIET);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if exists " + NguoiDung_DAO.TABLE_NAME);
//        db.execSQL("Drop table if exists " + TheLoaiDAO.TABLE_NAME);
//        db.execSQL("Drop table if exists " + SachDAO.TABLE_NAME);
//        db.execSQL("Drop table if exists " + HoaDonDAO.TABLE_NAME);
//        db.execSQL("Drop table if exists " + HoaDonChiTietDAO.TABLE_NAME);
    }
}
