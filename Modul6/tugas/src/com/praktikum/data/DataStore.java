package com.praktikum.data;

import com.praktikum.user.*;
import java.util.ArrayList;

public class DataStore {
    public static ArrayList<User> userList = new ArrayList<>();
    public static ArrayList<Item> reportedItems = new ArrayList<>();

    static {
        userList.add(new Admin("zeta", "108", "admin", "260306"));
        userList.add(new Admin("duit", "090", "ketua", "150706"));
        userList.add(new Mahasiswa("zeta", "108"));
        userList.add(new Mahasiswa("duit", "090"));

        reportedItems.add(new Item("HP", "Smartphone", "Lab E", userList.get(1)));
        reportedItems.add(new Item("Dompet", "Dompet Pria Kulit Hitam", "LAB A", userList.get(2)));
        reportedItems.get(1).setStatus("Claimed");
    }

    public static ArrayList<Item> getReportedItems() {
        return reportedItems;
    }

    public static ArrayList<User> getUserList() {
        return userList;
    }
}
