class manusia{
    String nama;
    int umur;

    public manusia(String nama, int umur) {
        this.nama = nama;
        this.umur = umur;
    }
}
class mahasiswa extends manusia{
    int nim;

    public mahasiswa(String nama, int umur, int nim) {
        super(nama, umur);
        this.nim = nim;
    }
}
public class contohPewarisan {
    public static void main (String[] args){

        mahasiswa obj = new mahasiswa("Zeta",19,108);
        System.out.println("nama: "+obj.nama+" umur: "+obj.umur+ " nim: "+obj.nim );
    }
}
