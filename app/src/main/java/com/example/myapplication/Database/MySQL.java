package com.example.myapplication.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.myapplication.DAO.HoaDonChiTiet_DAO;
import com.example.myapplication.DAO.HoaDon_DAO;
import com.example.myapplication.DAO.ThuThu_DAO;
import com.example.myapplication.DAO.Sach_DAO;
import com.example.myapplication.DAO.ThanhVien_DAO;
import com.example.myapplication.DAO.TheLoai_DAO;

public class MySQL extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "QLTHUVIEN";
    public static final int VERSION = 1;

    public MySQL(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //Tạo Bảng Thủ Thư:
        String createTableThuThu =
                "create table ThuThu (" +
                        "maTT TEXT PRIMARY KEY, " +
                        "hoTen TEXT NOT NULL, " +
                        "matKhau TEXT NOT NULL)";
        db.execSQL(createTableThuThu);

        //Tạo Bảng Thành Viên:
        String createTableThanhVien =
                "create table ThanhVien (" +
                        "maTV INTEGER PRIMARY KEY , " +
                        "hoTen TEXT NOT NULL, " +
                        "namSinh TEXT NOT NULL)";
        db.execSQL(createTableThanhVien);

        //Tạo Bảng Loại Sách:
        String createTableLoaiSach =
                "create table LoaiSach (" +
                        "maLoai INTEGER PRIMARY KEY , " +
                        "tenLoai TEXT NOT NULL)";
        db.execSQL(createTableLoaiSach);

        //Tạo Bảng Sách:
        String createTableSach =
                "create table Sach (" +
                        "maSach INTEGER PRIMARY KEY , " +
                        "tenSach TEXT NOT NULL, " +
                        "giaThue INTEGER NOT NULL, " +
                        "maLoai INTEGER REFERENCES LoaiSach(maLoai))";
        db.execSQL(createTableSach);

        //Tạo Bảng Phiếu Mượn:
        String createTablePhieuMuon =
                "create table PhieuMuon (" +
                        "maPM INTERGER PRIMARY KEY , " +
                        "maTT TEXT REFERENCES ThuThu(maTT), " +
                        "maTV INTERGER REFERENCES ThanhVien(maTV), " +
                        "maSach INTERGER REFERENCES Sach(maSach), " +
                        "tienThue INTERGER NOT NULL, " +
                        "ngay DATE NOT NULL ," +
                        "traSach INTERGER NOT NULL) ";
        db.execSQL(createTablePhieuMuon);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String dropTableThuThu ="drop table if exists ThuThu";
        db.execSQL(dropTableThuThu);
        String dropTableThanhVien ="drop table if exists ThanhVien";
        db.execSQL(dropTableThanhVien);
        String dropTableLoaiSach ="drop table if exists LoaiSach";
        db.execSQL(dropTableLoaiSach);
        String dropTableSach ="drop table if exists Sach";
        db.execSQL(dropTableSach);
        String dropTablePhieuMuon="drop table if exists PhieuMuon";
        db.execSQL(dropTablePhieuMuon);

        onCreate(db);
    }
}
