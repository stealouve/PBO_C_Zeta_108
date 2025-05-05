package codelab.perpustakaan;

public class Fiksi extends Buku {
    public Fiksi(String judul, String penulis) {
        super(judul, penulis);
    }

    @Override
    public void DisplayInfo(){
        System.out.println("Buku Fiksi: "+judul+" Oleh "+penulis);
    }
}
