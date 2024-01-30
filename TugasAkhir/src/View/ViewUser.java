package View;

import Controller.ControllerPenyewaan;
import Controller.ControllerUser;

import java.util.Scanner;

public class ViewUser {
    private ControllerUser controllerUser;
    private ControllerPenyewaan controllerPenyewaan;

    public ViewUser(ControllerUser controllerUser, ControllerPenyewaan controllerPenyewaan){
        this.controllerUser = controllerUser;
        this.controllerPenyewaan = controllerPenyewaan;
    }
    public void viewUtamaUser(String username){
        Scanner input = new Scanner(System.in);
        int pilih;
        x: while (true){
            String tabel = "| %-20s |%n";
            System.out.format("+----------------------+%n");
            System.out.format(tabel, "Menu User");
            System.out.format("+----------------------+%n");
            System.out.format(tabel, "1. Sewa Mobil");
            System.out.format(tabel, "2. View Profil");
            System.out.format(tabel, "3. Update User");
            System.out.format(tabel, "4. Lihat Pemesanan");
            System.out.format(tabel, "5. Batalkan Pemesanan");
            System.out.format(tabel, "6. Kembali");
            System.out.format("+----------------------+%n");
            System.out.print("| Pilih : ");
            pilih = input.nextInt();
            input.nextLine();
            System.out.println("+----------------------+");
            switch (pilih) {
                case 1:
                    controllerPenyewaan.Insert(username);
                    break;
                case 2:
                    controllerUser.search(username);
                    break;
                case 3:
                    controllerUser.update(username);
                    break;
                case 4:
                    controllerPenyewaan.viewPenyewaanUser(username);
                    break;
                case 5:
                    controllerPenyewaan.delete();
                    break;
                case 6:
                    System.out.println("Keluar");
                    break x;
                default:
                    System.out.println("INVALID INPUT!");
                    break;
            }
        }
    }
    public void User(){
        Scanner input = new Scanner(System.in);
        int pilih;
        x: while (true){
            String tabel = "| %-20s |%n";
            System.out.format("+----------------------+%n");
            System.out.format(tabel, "Menu User");
            System.out.format("+----------------------+%n");
            System.out.format(tabel, "1. Tambah User");
            System.out.format(tabel, "2. Lihat User");
            System.out.format(tabel, "3. Update User");
            System.out.format(tabel, "4. Kembali");
            System.out.format("+----------------------+%n");
            System.out.print("| Pilih : ");
            pilih = input.nextInt();
            input.nextLine();
            System.out.println("+----------------------+");
            switch (pilih) {
                case 1:
                    controllerUser.insert();
                    break;
                case 2:
                    System.out.print("Masukkan Username : ");
                    String username = input.nextLine();
                    controllerUser.search(username);
                    break;
                case 3:
                    System.out.print("Masukkan Username : ");
                    username = input.nextLine();
                    controllerUser.update(username);
                    break;
                case 4:
                    System.out.println("Keluar");
                    break x;
                default:
                    System.out.println("INVALID INPUT!");
                    break;
            }
        }
    }
}
