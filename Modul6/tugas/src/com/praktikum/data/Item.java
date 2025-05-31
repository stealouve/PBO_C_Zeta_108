package com.praktikum.data;

public class Item {
    private String itemNama;
    private String deskripsi;
    private String location;
    private String status;

    public Item(String itemNama, String deskripsi, String location, String status) {
        this.itemNama = itemNama;
        this.deskripsi = deskripsi;
        this.location = location;
        this.status = status;
    }

    public String getItemNama() {
        return itemNama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public String getLocation() {
        return location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
