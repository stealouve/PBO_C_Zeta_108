package com.praktikum.main;

import com.praktikum.user.*;
import com.praktikum.data.*;
import java.util.ArrayList;
import java.util.Scanner;

public class LoginSystem {
    private Admin admin;
    private Mahasiswa mahasiswa;

    public static ArrayList<User> userList = new ArrayList<>();
    public static ArrayList<Item> reportedItems = new ArrayList<>();

    public static void initializeData() {
        userList.add(new Admin("zeta", "108", "admin", "kucing"));
        userList.add(new Admin("Lou", "192", "ketua", "anjing"));
        userList.add(new Mahasiswa("zeta", "108"));
        userList.add(new Mahasiswa("Lou", "192"));
    }

    public void menu() {
        System.out.println("Pilih login sebagai: ");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");
        System.out.println("3. Keluar");
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            menu();
            System.out.print("Pilih jenis login (1-3): ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            if (pilihan == 1) {
                loginAsAdmin(scanner);
            } else if (pilihan == 2) {
                loginAsMahasiswa(scanner);
            } else if (pilihan == 3) {
                System.out.println("Anda telah Logout, Terima kasih!");
                break;
            } else {
                System.out.println("Pilihan tidak valid, coba lagi.");
            }
        }
        scanner.close();
    }

    private void loginAsAdmin(Scanner scanner) {
        System.out.print("Masukkan username: ");
        String username = scanner.nextLine();
        System.out.print("Masukkan password: ");
        String password = scanner.nextLine();
        boolean loggedIn = false;

        for (User  user : userList) {
            if (user instanceof Admin) {
                try {
                    if (((Admin) user).login(username, password)) {
                        loggedIn = true;
                        ((Admin) user).displayInfo();
                        ((Admin) user).displayAppMenu();
                        break;
                    }
                } catch (UserNotFoundException e) {
                }
            }
        }

        if (!loggedIn) {
            System.out.println("Username atau password salah untuk admin.");
        }
    }

    private void loginAsMahasiswa(Scanner scanner) {
        System.out.print("Masukkan nama: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan NIM: ");
        String nim = scanner.nextLine();
        boolean loggedIn = false;

        for (User  user : userList) {
            if (user instanceof Mahasiswa) {
                try {
                    if (((Mahasiswa) user).login(nama, nim)) {
                        loggedIn = true;
                        ((Mahasiswa) user).displayInfo();
                        ((Mahasiswa) user).displayAppMenu();
                        break;
                    }
                } catch (UserNotFoundException e) {
                }
            }
        }

        if (!loggedIn) {
            System.out.println("Nama atau NIM salah untuk mahasiswa.");
        }
    }


    public static void main(String[] args) {
        initializeData();
        LoginSystem loginSystem = new LoginSystem();
        loginSystem.start();
    }
}
