import java.util.Scanner;

public class LoginSystem {
    private Admin admin;
    private Mahasiswa mahasiswa;

    public LoginSystem() {
        admin = new Admin("admin", "pasieniki");
        mahasiswa = new Mahasiswa("zeta", "108");
    }

    public void showMenu() {
        System.out.println("Sistem Login: ");
        System.out.println("1. Login sebagai Admin");
        System.out.println("2. Login sebagai Mahasiswa");
        System.out.println("3. Keluar");
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            showMenu();
            System.out.print("Pilih jenis login (1-3): ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            if (pilihan == 1) {
                System.out.print("Masukkan username: ");
                String username = scanner.nextLine();
                System.out.print("Masukkan password: ");
                String password = scanner.nextLine();
                admin.login(username, password);

            } else if (pilihan == 2) {
                System.out.print("Masukkan nama: ");
                String nama = scanner.nextLine();
                System.out.print("Masukkan NIM: ");
                String nim = scanner.nextLine();
                mahasiswa.login(nama, nim);

            } else if (pilihan == 3) {
                System.out.println("Thank You!");
                break;

            } else {
                System.out.println("Pilihan tidak valid! Silakan coba lagi.");
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        LoginSystem loginSystem = new LoginSystem();
        loginSystem.run();
    }
}