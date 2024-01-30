package View;

import Controller.ControllerAdmin;
import Controller.ControllerPenyewaan;

import java.util.Scanner;

public class ViewAdmin {
    private ControllerAdmin controllerAdmin;
    private ControllerPenyewaan controllerPenyewaan;
    private ViewMobil viewMobil;
    private ViewSewa viewSewa;
    private ViewUser viewUser;

    public ViewAdmin(ControllerAdmin controllerAdmin, ControllerPenyewaan controllerPenyewaan, ViewMobil viewMobil, ViewSewa viewSewa, ViewUser viewUser){
        this.controllerAdmin = controllerAdmin;
        this.controllerPenyewaan = controllerPenyewaan;
        this.viewMobil = viewMobil;
        this.viewSewa = viewSewa;
        this.viewUser = viewUser;
    }
    public void viewUtamaAdmin(){
        Scanner input = new Scanner(System.in);
        int pilih;
        x: while (true){
            String tabel = "| %-25s |%n";
            System.out.format("+-"+ ("-").repeat(25) + "-+%n");
            System.out.format(tabel, "Menu Admin");
            System.out.format("+-"+ ("-").repeat(25) + "-+%n");
            System.out.format(tabel, "1. View Admin");
            System.out.format(tabel, "2. Menu Mobil");
            System.out.format(tabel, "3. Menu Sewa");
            System.out.format(tabel, "4. Menu User");
            System.out.format(tabel, "5. Lihat Semua Pemesanan");
            System.out.format(tabel, "6. Kembali");
            System.out.format("+-"+ ("-").repeat(25) + "-+%n");
            System.out.print("| Pilih : ");
            pilih = input.nextInt();
            input.nextLine();
            System.out.format("+-"+ ("-").repeat(25) + "-+%n");
            switch (pilih) {
                case 1:
                    controllerAdmin.viewAllAdmin();
                    break;
                case 2:
                    viewMobil.UtamaViewMobil();
                    break;
                case 3:
                    viewSewa.UtamaViewSewa();
                    break;
                case 4:
                    viewUser.User();
                    break ;
                case 5:
                    controllerPenyewaan.view();
                    break ;
                case 6:
                    System.out.println("Keluar");
                    break x;
                default:
                    System.out.println("INVALID INPUT!");
                    break;
            }
        }
    }
}
