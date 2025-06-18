package com.praktikum.user;

import com.praktikum.action.MahasiswaActions;

public class Mahasiswa extends User implements MahasiswaActions {
    public Mahasiswa(String nama, String nim) {
        super(nama, nim);
    }

    @Override
    public boolean login(String nama, String nim) {
        return this.getNama().equals(nama) && this.getNim().equals(nim);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
    }

    @Override
    public void ReportItem() {
    }

    @Override
    public void ViewReportItem() {

    }

}
