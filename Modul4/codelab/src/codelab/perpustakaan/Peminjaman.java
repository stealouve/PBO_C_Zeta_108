package codelab.perpustakaan;

public interface Peminjaman {
    void PinjamBuku(String judul);
    void KembalikanBuku(String judul, int hari);
}
