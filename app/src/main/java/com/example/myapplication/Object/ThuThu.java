package com.example.myapplication.Object;

public class ThuThu {
    private int id;
    private String userName;
    private String password;
    private String phone;
    private String hoTen;

    public ThuThu() {
    }

    public ThuThu(int id, String userName, String password, String phone, String hoTen) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.phone = phone;
        this.hoTen = hoTen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String toString() {
        return "Người Dùng{" +
                "Tên Tài Khoản ='" + userName + '\'' +
                ", Mật Khẩu ='" + password + '\'' +
                ", Số Điện Thoại ='" + phone + '\'' +
                ", Họ Và Tên ='" + hoTen + '\'' +
                '}';
    }
}
