package com.praktikum.user;

import com.praktikum.action.MahasiswaActions;
import java.util.Scanner;

public class Mahasiswa extends User implements MahasiswaActions {
    public Mahasiswa(String nama, String nim) {
        super(nama, nim);
    }

    @Override
    public void login(String inputNama, String inputNim) {
        if (inputNama.equals(getNama()) && inputNim.equals(getNim())) {
            System.out.println("Login sebagai mahasiswa berhasil!");
        } else {
            System.out.println("Login gagal, coba lagi.");
        }
    }

    @Override
    public void ReportItem(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan Nama Barang: ");
        String namaBarang = scanner.nextLine();

        System.out.print("Masukkan Deskripsi Barang: ");
        String deskripsiBarang = scanner.nextLine();

        System.out.print("Masukkan Lokasi Terakhir/Ditemukan: ");
        String lokasi = scanner.nextLine();

        System.out.println("\nBarang berhasil dilaporkan!");
        System.out.println("Detail Laporan:");
        System.out.println("Nama Barang     : " + namaBarang);
        System.out.println("Deskripsi       : " + deskripsiBarang);
        System.out.println("Lokasi Ditemukan: " + lokasi);

        scanner.close();
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
    }

    @Override
    public void ViewReportItem(){
        System.out.println(">> Fitur Lihat Laporan Belum Tersedia <<");
    }

    @Override
    public void displayAppMenu() {
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        while (true) {
            System.out.println("== Menu Mahasiswa ==");
            System.out.println("1. Laporan Barang Hilang");
            System.out.println("2. Lihat Daftar Barang Hilang");
            System.out.println("3. Keluar");
            System.out.print("Pilih Menu : ");
            pilihan = scanner.nextInt();

            if(pilihan == 1){
                ReportItem();
                break;
            } else if (pilihan == 2) {
                ViewReportItem();
                break;
            } else if (pilihan == 3) {
                System.out.println("Thank You!");
                break;
            } else {
                System.out.println("Pilihan Tidak Valid! Coba Lagi.");
            }
        }
        scanner.close();
    }

}
