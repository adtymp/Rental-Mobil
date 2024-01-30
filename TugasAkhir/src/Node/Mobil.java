package Node;

public class Mobil implements Node {
    public String merkMobil;
    public String namaMobil;
    public String warna;
    private String platNomer;
    public int tahun;

    public Mobil(String merkMobil, String namaMobil, String warna, String platNomer, int tahun){
        this.merkMobil = merkMobil;
        this.namaMobil = namaMobil;
        this.warna = warna;
        this.platNomer = platNomer;
        this.tahun = tahun;
    }

    @Override
    public void display(){
        System.out.println("=====================");
        System.out.println("Merk Mobil : "+merkMobil);
        System.out.println("Nama : "+namaMobil);
        System.out.println("Warna : "+warna);
        System.out.println("Plat Nomer : "+platNomer);
        System.out.println("Tahun : "+tahun);
    }

    public String getPlatNomer() {
        return platNomer;
    }

    public void setPlatNomer(String platNomer) {
        this.platNomer = platNomer;
    }
}
