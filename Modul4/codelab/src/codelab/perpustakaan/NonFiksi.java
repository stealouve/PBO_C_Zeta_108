package codelab.perpustakaan;

public class NonFiksi extends Buku {
    public NonFiksi(String judul, String penulis) {
        super(judul, penulis);
    }

    @Override
    public void DisplayInfo(){
        System.out.println("Buku Non Fiksi: "+judul+" Oleh "+penulis);
    }
}