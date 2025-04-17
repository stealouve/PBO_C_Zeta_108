public class Mahasiswa {
    private String nama;
    private String nim;

    public Mahasiswa(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
    }

    public void login(String inputNama, String inputNim) {
        if (inputNama.equals(nama) && inputNim.equals(nim)) {
            System.out.println("Login as Mahasiswa berhasil!");
            System.out.print("Tentang Mahasiswa = ");
            System.out.println(displayInfo());
        } else {
            System.out.println("Nama atau NIM salah! Coba lagi.");
        }
    }

    public String displayInfo() {
        return "Nama: " + nama + ", NIM: " + nim;
    }
}