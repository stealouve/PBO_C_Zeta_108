package com.praktikum.user;

import com.praktikum.action.AdminActions;
import java.util.Scanner;

public class Admin extends User implements AdminActions {
    private String username;
    private String password;

    public Admin(String nama, String nim, String username, String password) {
        super(nama, nim);
        this.username = username;
        this.password = password;
    }

    @Override
    public void login(String inputUsername, String inputPassword) {
        if (inputUsername.equals(username) && inputPassword.equals(password)) {
            System.out.println("Login sebagai admin berhasil!");
        } else {
            System.out.println("Login Gagal, coba lagi.");
        }
    }

    @Override
    public void displayInfo() { super.displayInfo();
    }

    @Override
    public void ManageItems() {
        System.out.println(">> Fitur Kelola Barang Belum Tersedia <<");
    }

    @Override
    public void ManageUsers() {
        System.out.println(">> Fitur Kelola Mahasiswa Belum Tersedia <<");
    }

    @Override
    public void displayAppMenu() {
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        while (true) {
            System.out.println("== Menu Admin ==");
            System.out.println("1. Kelola Laporan Barang");
            System.out.println("2. Kelola Data Mahasiswa");
            System.out.println("3. Keluar");
            System.out.print("Pilih Menu : ");
            pilihan = scanner.nextInt();

            if(pilihan == 1){
                ManageItems();
            } else if (pilihan == 2) {
                ManageUsers();
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
