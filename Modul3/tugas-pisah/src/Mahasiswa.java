public class Mahasiswa extends User {
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
