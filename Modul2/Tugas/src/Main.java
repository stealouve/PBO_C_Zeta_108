class KarakterGame {
    private String nama;
    private int kesehatan;

    public KarakterGame(String nama, int kesehatan) {
        this.nama = nama;
        this.kesehatan = kesehatan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getKesehatan() {
        return kesehatan;
    }

    public void setKesehatan(int kesehatan) {
        this.kesehatan = kesehatan;
    }

    public void serang(KarakterGame target) {
    } //superclass
}

class Pahlawan extends KarakterGame {

    public Pahlawan(String nama, int kesehatan) {
        super(nama, kesehatan);
    }

    @Override
    public void serang(KarakterGame target) {
        System.out.println(getNama() + " menyerang " + target.getNama() + " menggunakan Lantern Flare!");
        target.setKesehatan(target.getKesehatan() - 40);
        System.out.println("Kesehatan " + target.getNama() + " sekarang: " + target.getKesehatan());
    }
}

public class Main {
    public static void main(String[] args) {
        Pahlawan pahlawan = new Pahlawan("Zhuxin", 150);
        KarakterGame musuh = new KarakterGame("Xavier", 200);

        pahlawan.serang(musuh);
    }
}