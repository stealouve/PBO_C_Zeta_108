public class User {
    private String nama; //encapsulation
    private String nim;

    public User(String nama, String nim) { //membuat nilai awal saat akan membuat objek
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
