package com.example.listview;

public class ItemData {
    // Member Variable ------------------------------------------------------
    private String  name;
    private String  phone;
    private String  address;
    private int     imgResId;

    // Constructor Method ----------------------------------------------------
    public ItemData(String name, String phone, String address, int imgResId) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.imgResId = imgResId;
    }

    // Member Variable 제어 메서드 ----------------------------------------------
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getImgResId() {
        return imgResId;
    }

    public void setImgResId(int imgResId) {
        this.imgResId = imgResId;
    }
}
