import java.util.Scanner;

class User {
    private String nama;
    private String nim;

    public User(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public String getNim() {
        return nim;
    }

    public void login(String inputNama, String inputNim) {
        System.out.println("Login Gagal!");
    }

    public void displayInfo() {
        System.out.println("Nama: " + nama);
        System.out.println("NIM: " + nim);
    }
}

class Admin extends User {
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
}

class Mahasiswa extends User {
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
    public void displayInfo() {
        super.displayInfo();
    }
}

class LoginSystem {
    private Admin admin;
    private Mahasiswa mahasiswa;

    public LoginSystem() {
        admin = new Admin("zeta", "108", "admin", "kucingterbang");
        mahasiswa = new Mahasiswa("zeta", "108");
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
                System.out.println("Anda telah Logout,  Terima kasih!");
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
