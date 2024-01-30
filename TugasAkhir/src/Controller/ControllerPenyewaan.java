package Controller;

import Model.ModelPenyewaan;
import Model.ModelSewa;
import Model.ModelUser;
import Node.Penyewaan;
import Node.Sewa;

import java.util.ArrayList;
import java.util.Scanner;

public class ControllerPenyewaan {
    private ModelPenyewaan modelPenyewaan;
    private ModelUser modelUser;
    private ModelSewa modelSewa;

    public ControllerPenyewaan(ModelPenyewaan modelPenyewaan, ModelUser modelUser, ModelSewa modelSewa){
        this.modelPenyewaan = modelPenyewaan;
        this.modelUser = modelUser;
        this.modelSewa = modelSewa;
    }
    public void Insert(String username) {
        Scanner inputPilih = new Scanner(System.in);
        Scanner input = new Scanner(System.in);
        System.out.println("-Sewa Mobil-");
        System.out.print("Cari Berdasarkan\n1. Harga Rata - rata\n2. Nama Mobil\nPilih :");
        int pilih = inputPilih.nextInt();
        if (pilih == 1) {
            System.out.print("Masukkan Harga : ");
            int harga = input.nextInt();
            ArrayList<Sewa> listSewa = modelSewa.searchHarga(harga);
            if (listSewa == null) {
                System.out.println("List Tidak Ditemukan");
            } else {
                System.out.println("Pencarian Berdasarkan Harga");
                for (Sewa sewa : listSewa) {
                    sewa.display();
                }
                input.nextLine();
                System.out.print("Masukkan Nama Mobil : ");
                String nama = input.nextLine();
                System.out.print("Warna Mobil : ");
                String warna = input.nextLine();
                System.out.print("Tahun Mobil : ");
                int tahun = input.nextInt();
                System.out.print("Hari Sewa : ");
                int hari = input.nextInt();
                Sewa sewa = modelSewa.search(nama, warna, tahun);
                if (sewa != null) {
                    modelPenyewaan.insert(modelUser.search(username), modelSewa.search(nama, warna, tahun), hari);
                    System.out.println("Mobil Berhasil Disewa");
                } else {
                    System.out.println("Mobil Tidak Ditemukan");
                }
            }
        }
    }

    public void view(){
        modelPenyewaan.viewAll();
    }
    public void delete(){
        Scanner input = new Scanner(System.in);
        System.out.println("-Batalkan Penyewaan-");
        System.out.print("Masukkan Nama Mobil : ");
        String nama = input.nextLine();
        System.out.print("Masukkan Plat Mobil  : ");
        String plat = input.nextLine();
        modelPenyewaan.delete(modelSewa.search(nama, plat));
        System.out.println("Pembatalan Sukses");
    }
    public void viewPenyewaanUser(String username){
        ArrayList<Penyewaan> listPenyewaan = modelPenyewaan.searchUser(username);
        if(listPenyewaan.isEmpty()){
            System.out.println("Belum Ada Penyewaan");
        }
        else {
            for (Penyewaan penyewaan : modelPenyewaan.searchUser(username)){
                System.out.println("Nama User : "+penyewaan.user.nama);
                System.out.println("Merk Mobil : "+penyewaan.sewa.mobil.merkMobil);
                System.out.println("Nama Mobil : "+penyewaan.sewa.mobil.namaMobil);
                System.out.println("Warna : "+penyewaan.sewa.mobil.warna);
                System.out.println("Tahun Mobil : "+penyewaan.sewa.mobil.tahun);
                System.out.println("Plat : "+penyewaan.sewa.mobil.getPlatNomer());
                System.out.println("Penyewaan : "+penyewaan.jmlHari + " Hari");
                System.out.println("Total Harga : "+penyewaan.totalHarga);

            }
        }
    }
}