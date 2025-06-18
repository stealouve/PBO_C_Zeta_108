package com.praktikum.data;

import com.praktikum.user.User;

public class Item {
    private String itemNama;
    private String deskripsi;
    private String location;
    private String status;
    private String reported;

    public Item(String itemNama, String deskripsi, String location, User currentUser ) {
        this.itemNama = itemNama;
        this.deskripsi = deskripsi;
        this.location = location;
        this.status = "Reported";
        this.reported = currentUser .getNim();
    }

    public String getItemNama() {
        return itemNama;
    }

    public String getReported() {
        return reported;
    }

    public void setReported(String reported) {
        this.reported = reported;
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
