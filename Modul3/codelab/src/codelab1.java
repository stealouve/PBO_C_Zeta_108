import java.util.Scanner;

class Karakter {
    private String nama;
    private int kesehatan;

    public Karakter(String nama, int kesehatan) {
        this.nama = nama;
        this.kesehatan = kesehatan;
    }

    public String getNama() {
        return nama;
    }

    public int getKesehatan() {
        return kesehatan;
    }

    public void setKesehatan(int kesehatan) {
        this.kesehatan = kesehatan;
    }

    public void serang(Karakter target, int damage, String jenisSerangan) {
        System.out.println(nama + " menyerang " + target.getNama() + " dengan " + jenisSerangan + "!");
        target.setKesehatan(target.getKesehatan() - damage);
        System.out.println("Kesehatan " + target.getNama() + " sekarang: " + target.getKesehatan() + "\n");
    }
}

class Hero extends Karakter {
    public Hero(String nama, int kesehatan) {
        super(nama, kesehatan);
    }

    @Override
    public void serang(Karakter target, int damage, String jenisSerangan) {
        System.out.println(getNama() + " melakukan serangan heroik: " + jenisSerangan + "!");
        super.serang(target, damage, jenisSerangan);
    }
}

class Monster extends Karakter {
    public Monster(String nama, int kesehatan) {
        super(nama, kesehatan);
    }

    @Override
    public void serang(Karakter target, int damage, String jenisSerangan) {
        System.out.println(getNama() + " mengamuk dengan serangan: " + jenisSerangan + "!");
        super.serang(target, damage, jenisSerangan);
    }
}

public class codelab1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Hero Kalea = new Hero("Kalea", 5000);
        Monster Gloo = new Monster("Gloo", 6000);

        System.out.println("Pertarungan dimulai!\n");
        System.out.println(Kalea.getNama() + " vs " + Gloo.getNama());

        int ronde = 1;

        while (Kalea.getKesehatan() > 0 && Gloo.getKesehatan() > 0) {
            System.out.println("Ronde " + ronde);
            System.out.println("Pilihan serangan " + Kalea.getNama() + ":");
            System.out.println("1. Slash (500 damage)");
            System.out.println("2. Power Strike (1000 damage)");
            System.out.println("3. Ultimate Slash (2000 damage)");
            System.out.println("4. Cek Kesehatan");
            System.out.print("Pilih serangan: ");
            int pilihan = scanner.nextInt();

            if (pilihan == 1) {
                Kalea.serang(Gloo, 500, "Slash");
            } else if (pilihan == 2) {
                Kalea.serang(Gloo, 1000, "Power Strike");
            } else if (pilihan == 3) {
                Kalea.serang(Gloo, 2000, "Ultimate Slash");
            } else if (pilihan == 4) {
                System.out.println(Kalea.getNama() + " memiliki kesehatan: " + Kalea.getKesehatan());
                System.out.println(Gloo.getNama() + " memiliki kesehatan: " + Gloo.getKesehatan());
                continue;
            } else {
                System.out.println("Pilihan tidak valid!");
                continue;
            }

            if (Gloo.getKesehatan() > 0) {
                System.out.println(Gloo.getNama() + " menyerang balik!");
                Gloo.serang(Kalea, 750, "Fire Breath");
            }

            ronde++;
        }

        if (Gloo.getKesehatan() == 0 || Gloo.getKesehatan() < 0) {
            System.out.println(Kalea.getNama() + " memenangkan pertarungan!");
        } else {
            System.out.println(Gloo.getNama() + " memenangkan pertarungan!");
        }

        scanner.close();
    }
}