package com.praktikum.user;

import com.praktikum.action.MahasiswaActions;
import com.praktikum.main.LoginSystem;
import com.praktikum.data.*;
import java.util.Scanner;

public class Mahasiswa extends User implements MahasiswaActions {
    public Mahasiswa(String nama, String nim) {
        super(nama, nim);
    }

    @Override
    public boolean login(String nama, String nim) throws UserNotFoundException {
        if (this.getNama().equals(nama) && this.getNim().equals(nim)) {
            return true;
        }
        throw new UserNotFoundException("User  tidak ditemukan.");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
    }

    @Override
    public void ReportItem() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan Nama Barang: ");
        String namaBarang = scanner.nextLine();

        System.out.print("Masukkan Deskripsi Barang: ");
        String deskripsiBarang = scanner.nextLine();

        System.out.print("Masukkan Lokasi Terakhir/Ditemukan: ");
        String lokasi = scanner.nextLine();

        Item item = new Item(namaBarang, deskripsiBarang, lokasi, "Reported");
        LoginSystem.reportedItems.add(item);

        System.out.println("Barang berhasil dilaporkan!");
        System.out.println("Detail Laporan:");
        System.out.println("Nama Barang     : " + namaBarang);
        System.out.println("Deskripsi       : " + deskripsiBarang);
        System.out.println("Lokasi Ditemukan: " + lokasi);
    }

    @Override
    public void ViewReportItem() {
        if (LoginSystem.reportedItems.isEmpty()) {
            System.out.println("Belum ada laporan barang.");
            return;
        }

        for (Item item : LoginSystem.reportedItems) {
            if (item.getStatus().equals("Reported")) {
                System.out.println("Barang: " + item.getItemNama());
                System.out.println("Deskripsi: " + item.getDeskripsi());
                System.out.println("Lokasi: " + item.getLocation());
                System.out.println("-----------------------------");
            }
        }
    }

    @Override
    public void displayAppMenu() {
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        while (true) {
            System.out.println("== Menu Mahasiswa ==");
            System.out.println("1. Laporan Barang Hilang");
            System.out.println("2. Lihat Daftar Barang Hilang");
            System.out.println("3. Kembali ke Menu Utama");
            System.out.print("Pilih Menu : ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            if (pilihan == 1) {
                ReportItem();
            } else if (pilihan == 2) {
                ViewReportItem();
            } else if (pilihan == 3) {
                System.out.println("Kembali ke Menu Utama...");
                break;
            } else {
                System.out.println("Pilihan Tidak Valid! Coba Lagi.");
            }
        }
    }

}
