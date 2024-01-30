package Controller;

import Model.ModelMobil;
import Node.Mobil;

import java.util.ArrayList;
import java.util.Scanner;

public class ControllerMobil implements CRUD{
    private ModelMobil modelMobil;

    public ControllerMobil(ModelMobil modelMobil){
        this.modelMobil = modelMobil;
        executeMobil();
    }
    public void executeMobil(){
        modelMobil.insert("Toyota", "Avanza", "Hitam", "B 1945 INA", 2010);
        modelMobil.insert("Honda", "Jazz", "Putih", "L 055 IN", 2013);
        modelMobil.insert("Toyota", "Veloz", "Silver", "M 312 CE", 2021);
        modelMobil.insert("Suzuki", "Ertiga", "Silver", "L 1 N", 2023);
        modelMobil.insert("Toyota", "Avanza", "Hitam", "L 2 N", 2015);
    }

    @Override
    public void insert(){
        Scanner input = new Scanner(System.in);
        System.out.println("-Tambah Mobil-");
        System.out.print("Masukkan Merk Mobil : ");
        String merkMobil = input.nextLine();
        System.out.print("Nama Mobil : ");
        String namaMobil = input.nextLine();
        System.out.print("Warna Mobil : ");
        String warna = input.nextLine();
        System.out.print("Plat Nomer : ");
        String plat = input.nextLine();
        System.out.print("Tahun Mobil : ");
        int tahun = input.nextInt();
        modelMobil.insert(merkMobil, namaMobil, warna, plat, tahun);
    }

    @Override
    public void view(){
        modelMobil.viewAllMobil();
    }
    @Override
    public void update() {
        Scanner input = new Scanner(System.in);
        System.out.println("-Update Mobil-");
        System.out.print("Nama Mobil : ");
        String nama = input.nextLine();
        ArrayList<Mobil> listMobil = modelMobil.searchNama(nama);
        if(listMobil == null){
            System.out.println("Mobil Tidak Ditemukan");
        }else {
            System.out.println("Mobil Ditemukan");
            for(Mobil mobil : listMobil){
                System.out.println("Nama Mobil : "+mobil.namaMobil);
                System.out.println("Warna Mobil : "+mobil.warna);
                System.out.println("Plat : "+mobil.getPlatNomer());
                System.out.println("Tahun : "+mobil.tahun);
                System.out.println("=========================");
            }
            System.out.print("Plat Mobil : ");
            String plat =  input.nextLine();
            System.out.println("Masukkan Plat Baru : ");
            String newPlat = input.nextLine();
            Mobil mobil = modelMobil.search(nama, plat);
            if(mobil == null){
                System.out.println("Mobil Tidak Ditemukan");
            }
            else {
                modelMobil.updateMobil(nama, plat, newPlat);
                System.out.println("Mobil Berhasil DiUpdate");
            }
        }
    }
    @Override
    public void delete(){
        Scanner input = new Scanner(System.in);
        System.out.println("-Hapus Mobil-");
        System.out.print("Nama Mobil : ");
        String nama = input.nextLine();
        ArrayList<Mobil> listMobil = modelMobil.searchNama(nama);
        if(listMobil == null){
            System.out.println("Mobil Tidak Ditemukan");
        }else {
            System.out.println("Mobil Ditemukan");
            for(Mobil mobil : listMobil){
                System.out.println("Nama Mobil : "+mobil.namaMobil);
                System.out.println("Warna Mobil : "+mobil.warna);
                System.out.println("Tahun : "+mobil.tahun);
                System.out.println("=========================");
            }
            System.out.print("Warna MObil : ");
            String warna = input.nextLine();
            System.out.print("Tahun Mobil : ");
            int tahun = input.nextInt();
            Mobil mobil = modelMobil.search(nama, warna, tahun);
            if(mobil == null){
                System.out.println("Mobil Tidak Ditemukan");
            }
            else {
                modelMobil.delete(nama, warna, tahun);
                System.out.println("Mobil Berhasil Dihapus");
            }
        }
    }
}
