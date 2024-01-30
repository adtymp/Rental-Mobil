package Controller;
import Model.ModelMobil;
import Model.ModelSewa;
import Node.Mobil;
import Node.Sewa;

import java.util.ArrayList;
import java.util.Scanner;

public class ControllerSewa implements CRUD{
    private ModelSewa modelSewa;
    private ModelMobil modelMobil;

    public ControllerSewa(ModelSewa modelSewa, ModelMobil modelMobil){
        this.modelSewa = modelSewa;
        this.modelMobil = modelMobil;
        executeSewa();
    }
    public void executeSewa(){
        modelSewa.insert(modelMobil.search("Avanza", "Hitam", 2015), 500000);
        modelSewa.insert(modelMobil.search("Ertiga", "Silver", 2023), 750000);
        modelSewa.insert(modelMobil.search("Jazz", "Putih", 2013), 350000);
    }

    @Override
    public void insert() {
        Scanner input = new Scanner(System.in);
        System.out.println("-Tambah Sewa-");
        System.out.print("Nama Mobil : ");
        String nama = input.nextLine();
        ArrayList<Mobil>listMobil = modelMobil.searchNama(nama);
        if(listMobil == null){
            System.out.println("Mobil Tidak Ditemukan");
        }else {
            System.out.println("Mobil Ditemukan");
            for (Mobil mobil : listMobil) {
                System.out.println("Nama Mobil : " + mobil.namaMobil);
                System.out.println("Warna Mobil : "+mobil.warna);
                System.out.println("Plat : "+mobil.getPlatNomer());
                System.out.println("Tahun : " + mobil.tahun);
                System.out.println("=========================");
            }
            System.out.print("Plat Mobil : ");
            String plat = input.nextLine();
            System.out.print("Harga : ");
            int harga = input.nextInt();
            modelSewa.insert(modelMobil.search(nama, plat), harga);
            System.out.println("Mobil Berhasil Ditambahkan Pada List Sewa");
        }
    }
    @Override
    public void view(){
        modelSewa.viewAllSewa();
    }

    @Override
    public void update(){
        Scanner input = new Scanner(System.in);
        System.out.println("-Update Sewa-");
        System.out.print("Nama Mobil : ");
        String nama = input.nextLine();
        ArrayList<Mobil>listMobil = modelMobil.searchNama(nama);
        if(listMobil == null){
            System.out.println("Mobil Tidak Ditemukan");
        }else {
            System.out.println("Mobil Ditemukan");
            for (Mobil mobil : listMobil) {
                System.out.println("Nama Mobil : " + mobil.namaMobil);
                System.out.println("Warna Mobil : " + mobil.warna);
                System.out.println("Tahun : " + mobil.tahun);
                System.out.println("=========================");
            }
            System.out.print("Plat Mobil : ");
            String plat = input.nextLine();
            System.out.print("Masukkan Harga Baru : ");
            int newHarga = input.nextInt();
            modelSewa.updateSewa(modelMobil.search(nama, plat), newHarga);
            System.out.println("Mobil Berhasil Ditambahkan Pada List Sewa");
        }
    }
    @Override
    public void delete(){
        Scanner input = new Scanner(System.in);
        System.out.println("-Hapus Sewa-");
        System.out.print("Nama Mobil : ");
        String nama = input.nextLine();
        ArrayList<Sewa> listSewa = modelSewa.searchMobil(nama);
        if(listSewa == null){
            System.out.println("List Sewa Tidak Ditemukan");
        }
        else {
            System.out.print("Warna Mobil : ");
            String warna = input.nextLine();
            System.out.print("Tahun Mobil : ");
            int tahun = input.nextInt();
            Sewa sewa = modelSewa.search(nama, warna, tahun);
            if (sewa == null){
                System.out.println("List Sewa Tidak Ditemukan");
            }
            else {
                modelSewa.delete(modelMobil.search(nama, warna, tahun));
                System.out.println("Mobil telah Dihapus dari List Sewa");
            }

        }
    }
}
