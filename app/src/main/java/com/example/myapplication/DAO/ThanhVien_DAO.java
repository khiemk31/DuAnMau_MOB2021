package com.example.myapplication.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.myapplication.Database.MySQL;

public class ThanhVien_DAO {
    private SQLiteDatabase db;
    private MySQL mySQL;
    public static final String TABLE_NAME = "ThanhVien";
    public static final String SQL_ThanhVien="create table ThanhVien(" +
                                                        "maTV INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                                        "hoTen TEXT NOT NULL, " +
                                                        "namSinh TEXT NOT NULL";
    public static final String TAG = "ThanhVien_DAO";

    public ThanhVien_DAO(Context context) {
        mySQL = new MySQL(context);
        db = mySQL.getWritableDatabase();
    }
}
