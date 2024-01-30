import Controller.*;
import Model.*;
import View.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ModelMobil modelMobil = new ModelMobil();
        ModelSewa modelSewa = new ModelSewa();
        ModelUser modelUser = new ModelUser();
        ModelPenyewaan modelPenyewaan = new ModelPenyewaan();
        ModelAdmin modelAdmin = new ModelAdmin();

        ControllerMobil controllerMobil = new ControllerMobil(modelMobil);
        ControllerSewa controllerSewa = new ControllerSewa(modelSewa, modelMobil);
        ControllerPenyewaan controllerPenyewaan = new ControllerPenyewaan(modelPenyewaan, modelUser, modelSewa);
        ControllerUser controllerUser = new ControllerUser(modelUser);
        ControllerAdmin controllerAdmin = new ControllerAdmin(modelAdmin);

        ViewMobil viewMobil = new ViewMobil(controllerMobil);
        ViewSewa viewSewa = new ViewSewa(controllerSewa);
        ViewUser viewUser = new ViewUser(controllerUser, controllerPenyewaan);
        ViewAdmin viewAdmin = new ViewAdmin(controllerAdmin, controllerPenyewaan, viewMobil, viewSewa, viewUser);

        ControllerLogin controllerLogin = new ControllerLogin(viewUser, viewAdmin, modelUser, modelAdmin);
        ViewLogin viewLogin = new ViewLogin(controllerUser, controllerLogin);

        Scanner input = new Scanner(System.in);
        int pilih;
        x : while (true){
            String tabel = "| %-23s |%n";
            System.out.format("+-"+ ("-").repeat(23) + "-+%n");
            System.out.format(tabel, "Selamat Datang di Rental Mobil");
            System.out.format("+-"+ ("-").repeat(23) + "-+%n");
            System.out.format(tabel, "1. Daftar");
            System.out.format(tabel, "2. Login");
            System.out.format(tabel, "3. Keluar");
            System.out.format("+-"+ ("-").repeat(23) + "-+%n");
            System.out.print("| Pilih : ");
            pilih = input.nextInt();
            input.nextLine();
            System.out.format("+-"+ ("-").repeat(23) + "-+%n");
            switch (pilih){
                case 1:
                    controllerUser.insert();
                    break ;
                case 2:
                    viewLogin.insertLogin();
                    break ;
                case 3:
                    System.out.println("Keluar Program");
                    break x;
                default:
                    System.out.println("INVALID INPUT");
                    break ;
            }
        }
    }
}