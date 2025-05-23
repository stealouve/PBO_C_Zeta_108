import java.util.Scanner;

public class LoginSystem {
    private Admin admin;
    private Mahasiswa mahasiswa;

    public LoginSystem() {
        admin = new Admin("Zeta", "108", "admin", "kucingterbang");
        mahasiswa = new Mahasiswa("Zeta", "108");
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
                System.out.print("Masukkan username: ");
                String username = scanner.nextLine();
                System.out.print("Masukkan password: ");
                String password = scanner.nextLine();
                admin.login(username, password);
                admin.displayInfo();
            } else if (pilihan == 2) {
                System.out.print("Masukkan nama: ");
                String nama = scanner.nextLine();
                System.out.print("Masukkan NIM: ");
                String nim = scanner.nextLine();
                mahasiswa.login(nama, nim);
                mahasiswa.displayInfo();
            } else if (pilihan == 3) {
                System.out.println("Anda telah Logout, terima kasih!");
                break;
            } else {
                System.out.println("Pilihan tidak valid, coba lagi.");
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        LoginSystem loginSystem = new LoginSystem();
        loginSystem.start();
    }
}