package codelab.perpustakaan;

public class Anggota implements Peminjaman {
    private String nama;
    private String idAnggota;
    public String Info;

    public Anggota(String nama, String idAnggota) {
        this.nama = nama;
        this.idAnggota = idAnggota;
    }

    public String getInfo() {
        return "Anggota: " + nama + " (ID: " + idAnggota + ")";
    }


    @Override
    public void PinjamBuku(String judul){
        System.out.println(nama+" meminjam buku berjudul: "+judul);
    }

    @Override
    public void KembalikanBuku(String judul,int hari){
        System.out.println(nama+" mengembalikan buku berjudul: "+judul+" selama "+hari+" hari.");
    }
}