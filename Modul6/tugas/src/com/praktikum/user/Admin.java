package com.praktikum.user;

import com.praktikum.action.AdminActions;
import com.praktikum.data.UserNotFoundException;
import com.praktikum.main.LoginSystem;
import java.util.Iterator;
import java.util.Scanner;
import java.util.InputMismatchException;

//import java.util.*;

public class Admin extends User implements AdminActions {
    private String username;
    private String password;

    public Admin(String nama, String nim, String username, String password) {
        super(nama, nim);
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean login(String username, String password) throws UserNotFoundException {
        if (this.username.equals(username) && this.password.equals(password)) {
            return true;
        }
        throw new UserNotFoundException("Username atau password salah.");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
    }

    @Override
    public void ManageItems() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Lihat Laporan");
            System.out.println("2. Tandai Barang Telah Diambil");
            System.out.println("3. Kembali");
            System.out.print("Pilih 1-3 : ");
            int pilihanM = scanner.nextInt();
            scanner.nextLine();

            if (pilihanM == 1) {
                System.out.println("\nDaftar Laporan Barang:");
                for (int i = 0; i < LoginSystem.reportedItems.size(); i++) {
                    if (LoginSystem.reportedItems.get(i).getStatus().equals("Reported")) {
                        System.out.println(i + ". " + LoginSystem.reportedItems.get(i).getItemNama());
                    }
                }

                if (LoginSystem.reportedItems.isEmpty()){
                    System.out.println("Tidak ada laporan Barang hilang");
                    return;
                }
                System.out.println(" ");

            } else if (pilihanM == 2) {
                System.out.print("\nMasukkan indeks barang yang ingin ditandai (angka dari urutan): ");
                try {
                    int index = scanner.nextInt();
                    scanner.nextLine();
                    LoginSystem.reportedItems.get(index).setStatus("Claimed");
                    System.out.println("Status barang berhasil diubah.");
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Indeks tidak valid!");
                } catch (InputMismatchException e) {
                    System.out.println("Input harus angka!");
                    scanner.nextLine();
                }

            } else if (pilihanM == 3) {
                break;
            } else {
                System.out.println("Pilihan tidak valid!");
            }
        }
    }

    @Override
    public void ManageUsers() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Tambahkan identitas Mahasiswa");
            System.out.println("2. Hapus identitas Mahasiswa");
            System.out.println("3. Kembali");
            System.out.print("Pilihan: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Nama Mahasiswa: ");
                String nama = scanner.nextLine();
                System.out.print("NIM: ");
                String nim = scanner.nextLine();
                LoginSystem.userList.add(new Mahasiswa(nama, nim));
                System.out.println("Mahasiswa ditambahkan.");
            } else if (choice == 2) {
                System.out.print("Masukkan NIM Mahasiswa: ");
                String nim = scanner.nextLine();
                boolean ketemu = false;
                Iterator<User> iterator = LoginSystem.userList.iterator();
                while (iterator.hasNext()) {
                    User user = iterator.next();
                    if (user instanceof Mahasiswa && ((Mahasiswa) user).getNim().equals(nim)) {
                        iterator.remove();
                        ketemu = true;
                        System.out.println("Mahasiswa telah dihapus.");
                        break;
                    }
                }
                if (!ketemu) {
                    System.out.println("Nama Mahasiswa tidak ditemukan.");
                }
            } else if (choice == 3) {
                break;
            } else {
                System.out.println("Pilihan tidak valid.");
            }
        }
    }

    @Override
    public void displayAppMenu() {
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        while (true) {
            System.out.println("== Menu Admin ==");
            System.out.println("1. Kelola Laporan Barang");
            System.out.println("2. Kelola Data Mahasiswa");
            System.out.println("3. Kembali ke Menu Utama");
            System.out.print("Pilih Menu : ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            if (pilihan == 1) {
                ManageItems();
            } else if (pilihan == 2) {
                ManageUsers();
            } else if (pilihan == 3) {
                System.out.println("Kembali ke Menu Utama...");
                break;
            } else {
                System.out.println("Pilihan Tidak Valid! Coba Lagi.");
            }
        }
    }

}
