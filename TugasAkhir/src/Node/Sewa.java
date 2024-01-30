package Node;

public class Sewa implements Node {
    public Mobil mobil;
    public int harga;
    public boolean status;

    public Sewa(Mobil mobil, int harga){
        this.mobil = mobil;
        this.harga = harga;
        this.status = true;
    }
    @Override
    public void display() {
        System.out.println("=====================");
        System.out.println("Mobil : " + mobil.namaMobil);
        System.out.println("Warna : "+mobil.warna);
        System.out.println("Tahun : "+mobil.tahun);
        System.out.println("Harga : " + harga + "/Hari");
        System.out.println((status == false ? "Sedang Disewa" : "Disewakan"));
    }

    public void setStatus() {
        if(status == true){
            this.status = false;
        }
        else{
            this.status = true;
        }
    }
}
