package Node;

public class Penyewaan implements Node{
    public User user;
    public Sewa sewa;
    public int jmlHari;
    public int totalHarga;

    public Penyewaan(User user, Sewa sewa, int jmlHari){
        this.user = user;
        this.sewa = sewa;
        this.jmlHari = jmlHari;
        this.totalHarga = jmlHari * setHarga();
    }
    @Override
    public void display() {
        System.out.println("=====================");
        if (user != null) {
            System.out.println("Nama Penyewa : " + user.nama);
        } else {
            System.out.println("Nama Penyewa : [User tidak tersedia]");
        }

        if (sewa != null && sewa.mobil != null) {
            System.out.println("Mobil");
            System.out.println("Nama Mobil : " + sewa.mobil.namaMobil);
            System.out.println("Warna Mobil : " + sewa.mobil.warna);
            System.out.println("Plat : " + sewa.mobil.getPlatNomer());
        } else {
            System.out.println("Informasi Mobil tidak tersedia");
        }

        System.out.println(jmlHari + " Hari Penyewaan");
        System.out.println("Total Biaya : " + totalHarga);
    }
    public int setHarga(){
        return sewa.harga;
    }
}
