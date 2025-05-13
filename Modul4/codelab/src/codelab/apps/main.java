package codelab.apps;

import codelab.perpustakaan.*;

public class main {
    public static void main(String[] args) {
        Anggota anggota1 = new Anggota("Zahra Zusseta", "C108");
        Anggota anggota2 = new Anggota("Dhea Suin","C076");

        Fiksi bukuFiksi = new Fiksi("Luka Cita", "Valerie Patkar");
        NonFiksi bukuNonFiksi = new NonFiksi("Ensiklopedia Dunia", "John Doe");

        bukuFiksi.DisplayInfo();
        bukuNonFiksi.DisplayInfo();
        System.out.println(" ");

        System.out.println(anggota1.getInfo());
        System.out.println(anggota2.getInfo());
        System.out.println(" ");

        anggota1.PinjamBuku(bukuFiksi.getJudul());
        anggota2.PinjamBuku(bukuNonFiksi.getJudul());
        System.out.println(" ");

        anggota1.KembalikanBuku(bukuFiksi.getJudul(), 7);
        anggota2.KembalikanBuku(bukuNonFiksi.getJudul(), 9);
    }
}
