package View;

import Controller.ControllerSewa;

import java.util.Scanner;

public class ViewSewa {
    private ControllerSewa controllerSewa;

    public ViewSewa(ControllerSewa controllerSewa){
        this.controllerSewa = controllerSewa;
    }

    public void UtamaViewSewa(){
        Scanner input = new Scanner(System.in);
        int pilih;
        x: while (true){
            String tabel = "| %-20s |%n";
            System.out.format("+----------------------+%n");
            System.out.format(tabel, "Menu Sewa");
            System.out.format("+----------------------+%n");
            System.out.format(tabel, "1. Insert Sewa");
            System.out.format(tabel, "2. View Sewa");
            System.out.format(tabel, "3. Update Sewa");
            System.out.format(tabel, "4. Delete Sewa");
            System.out.format(tabel, "5. Kembali");
            System.out.format("+----------------------+%n");
            System.out.print("| Pilih : ");
            pilih = input.nextInt();
            input.nextLine();
            System.out.println("+----------------------+");
            switch (pilih) {
                case 1:
                    controllerSewa.insert();
                    break;
                case 2:
                    controllerSewa.view();
                    break;
                case 3:
                    controllerSewa.update();
                    break;
                case 4:
                    controllerSewa.delete();
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
