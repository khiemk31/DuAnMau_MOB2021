package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.DAO.NguoiDung_DAO;

public class DangNhap extends AppCompatActivity {
    EditText userName, passWord;
    Button bntLogin;
    CheckBox checkRemeberPass;
    String strUser, strPass;
    NguoiDung_DAO nguoiDung_dao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);
        setTitle("Đăng Nhập");
        userName = (EditText) findViewById(R.id.edUserName);
        passWord = (EditText) findViewById(R.id.edPassword);
        bntLogin = (Button) findViewById(R.id.btnLogin);

        checkRemeberPass = (CheckBox) findViewById(R.id.chkRememberPass);
        nguoiDung_dao = new NguoiDung_DAO(DangNhap.this);
        Log.e("Chạy Đến","Màn HìnH Đăng Nhập");
    }

    public void checkLogin(View view) {
        strUser = userName.getText().toString();
        strPass = passWord.getText().toString();
        if (strUser.isEmpty() || strPass.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Tên đăng nhập và mật khẩu không được bỏ trống", Toast.LENGTH_SHORT).show();
        } else {
            if (nguoiDung_dao.checkLogin(strUser, strPass) > 0) {
                Toast.makeText(getApplicationContext(), "Login Thành Công", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(DangNhap.this, MainActivity.class);
                startActivity(intent);
            }
            if
            (strUser.equalsIgnoreCase("admin") && strPass.equalsIgnoreCase("admin")) {
                rememberUser(strUser, strPass, checkRemeberPass.isChecked());
                Intent intent = new Intent(DangNhap.this, MainActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Login Thành Công", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "Tên đăng nhập và mật khẩu không đúng", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void rememberUser(String u, String p, boolean status) {
        SharedPreferences pref = getSharedPreferences("USER_FILE", MODE_PRIVATE);
        SharedPreferences.Editor edit = pref.edit();
        if (!status) {
            //xoa tinh trang luu tru truoc do
            edit.clear();
        } else {
            //luu du lieu
            edit.putString("USERNAME", u);
            edit.putString("PASSWORD", p);
            edit.putBoolean("REMEMBER", status);
        }
        //luu lai toan bo
        edit.commit();
    }
}