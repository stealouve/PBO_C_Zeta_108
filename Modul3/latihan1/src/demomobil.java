class mobil {
    String nama;
    int speed;

    public mobil(String nama, int speed){
        this.nama = nama;
        this.speed = speed;
    }
    public void cetak()
    {
        System.out.println("nama mobil: "+nama +" kecepatan: "+speed);
    }
}
public class demomobil{
    public static void main(String[] args)
    {
        mobil obj = new mobil("avanza", 5000);
        mobil obj1 = new mobil("honda", 400);
        obj.cetak();
        obj1.cetak();
    }
}
