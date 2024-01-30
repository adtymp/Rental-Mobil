package Model;

import Node.Mobil;
import Node.Sewa;

import java.util.ArrayList;

public class ModelSewa {
    public ArrayList<Sewa> listSewa;

    public ModelSewa(){
        listSewa = new ArrayList<>();
    }
    public void insert(Mobil nama, int harga){
        listSewa.add(new Sewa(nama, harga));
    }
    public void viewAllSewa(){
        for (Sewa sewa : listSewa){
            sewa.display();
        }
    }
    public void updateSewa(Mobil mobil, int newHarga){
        for (int i=0; i<listSewa.size(); i++){
            if(mobil.namaMobil.equalsIgnoreCase(listSewa.get(i).mobil.namaMobil)){
                listSewa.get(i).harga = newHarga;
            }
        }
    }
    public void delete(Mobil mobil){
        for (int i=0; i< listSewa.size(); i++){
            if(listSewa.get(i).mobil.namaMobil.equalsIgnoreCase(mobil.namaMobil) && listSewa.get(i).mobil.warna.equalsIgnoreCase(mobil.warna) && listSewa.get(i).mobil.tahun == mobil.tahun)
                listSewa.remove(i);
        }
    }
    public ArrayList<Sewa> searchMobil(String namaMobil){
        ArrayList<Sewa> list = new ArrayList<>();
        for (Sewa rent : listSewa){
            if(rent.mobil.namaMobil.equalsIgnoreCase(namaMobil)){
                list.add(rent);
            }
        }
        return list;
    }
    public ArrayList<Sewa> searchHarga(int harga){
        ArrayList<Sewa> list = new ArrayList<>();
        for (Sewa rent : listSewa){
            if(rent.harga >= harga){
                list.add(rent);
            }
        }
        return list;
    }
    public Sewa search(String nama, String plat){
        Sewa sewa = null;
        for(Sewa rent : listSewa){
            if(rent.mobil.namaMobil.equalsIgnoreCase(nama) && rent.mobil.getPlatNomer().equalsIgnoreCase(plat)){
                return rent;
            }
        }
        return sewa;
    }
    public Sewa search(String nama, String warna, int tahun) {
        Sewa sewa = null;
        for (Sewa rent : listSewa) {
            if (rent.mobil.namaMobil.equalsIgnoreCase(nama) && rent.mobil.warna.equalsIgnoreCase(warna) && rent.mobil.tahun == tahun) {
                return rent;
            }
        }
        return sewa;
    }
}
