public class Barang {
    private String nama;
    private int stock;

    public Barang(String nama, int stock) {
        this.nama = nama;
        this.stock = stock;
    }

    public String getNama() {
        return nama;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    public void kurangiStok(int jumlah) {
        if (jumlah > stock) {
            throw new StockTidakCukupException("Stok tidak cukup! Tersedia: " + stock);
        }
        stock -= jumlah;
    }
}
