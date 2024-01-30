package Model;

import Node.Mobil;

import java.util.ArrayList;

public  class ModelMobil{
    public ArrayList<Mobil> listMobil;

    public ModelMobil(){
        listMobil = new ArrayList<>();
    }
    public void insert(String merk, String nama, String warna, String platNomer, int tahun){
        listMobil.add(new Mobil(merk, nama, warna, platNomer, tahun));
    }

    public void viewAllMobil(){
        for (int i=0; i<listMobil.size(); i++){
            listMobil.get(i).display();
        }
    }
    public void updateMobil(String nama, String plat, String newPlat){
        for (int i=0; i<listMobil.size(); i++){
            if(listMobil.get(i).namaMobil.equalsIgnoreCase(nama)&& listMobil.get(i).getPlatNomer().equalsIgnoreCase(plat)){
                listMobil.get(i).setPlatNomer(newPlat);
            }
        }
    }
    public void delete(String nama, String warna, int tahun){
        for(int i=0; i< listMobil.size(); i++){
            if(nama.equalsIgnoreCase(listMobil.get(i).namaMobil) && warna.equalsIgnoreCase(listMobil.get(i).warna) && tahun == listMobil.get(i).tahun){
                listMobil.remove(i);
            }
        }
    }
    public Mobil search(String nama, String warna, int tahun){
        Mobil mobil = null;
        for(Mobil car  : listMobil){
            if(car.namaMobil.equalsIgnoreCase(nama) && car.warna.equalsIgnoreCase(warna) && car.tahun == tahun){
                return car;
            }
        }
        return mobil;
    }
    public Mobil search(String nama, String plat){
        Mobil mobil = null;
        for(Mobil car  : listMobil){
            if(car.namaMobil.equalsIgnoreCase(nama) && car.getPlatNomer().equalsIgnoreCase(plat)){
                return car;
            }
        }
        return mobil;
    }
    public ArrayList<Mobil> searchNama(String nama){
        ArrayList<Mobil> list = new ArrayList<>();
        for(Mobil car : listMobil){
            if(car.namaMobil.equalsIgnoreCase(nama)){
                list.add(car);
            }
        }
        return list;
    }
}
