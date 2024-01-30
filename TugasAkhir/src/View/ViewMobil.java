package View;

import Controller.ControllerMobil;

import java.util.Scanner;

public class ViewMobil {
    private ControllerMobil controllerMobil;

    public ViewMobil(ControllerMobil controllerMobil){
        this.controllerMobil = controllerMobil;
    }

    public void UtamaViewMobil(){
        Scanner input = new Scanner(System.in);
        int pilih;
        x: while (true){
            String tabel = "| %-20s |%n";
            System.out.format("+----------------------+%n");
            System.out.format(tabel, "Menu Mobil");
            System.out.format("+----------------------+%n");
            System.out.format(tabel, "1. Insert Mobil");
            System.out.format(tabel, "2. View Mobil");
            System.out.format(tabel, "3. Update Mobil");
            System.out.format(tabel, "4. Delete Mobil");
            System.out.format(tabel, "5. Kembali");
            System.out.format("+----------------------+%n");
            System.out.print("| Pilih : ");
            pilih = input.nextInt();
            input.nextLine();
            System.out.println("+----------------------+");
            switch (pilih) {
                case 1:
                    controllerMobil.insert();
                    break;
                case 2:
                    controllerMobil.view();
                    break;
                case 3:
                    controllerMobil.update();
                    break;
                case 4:
                    controllerMobil.delete();
                    break;
                case 5:
                    System.out.println("Keluar");
                    break x;
                default:
                    System.out.println("INVALID INPUT!");
                    break;
            }
        }
    }
}
