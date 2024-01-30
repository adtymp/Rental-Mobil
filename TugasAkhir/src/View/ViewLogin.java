package View;

import Controller.ControllerLogin;
import Controller.ControllerUser;

import java.util.Scanner;

public class ViewLogin {
    private ControllerUser controllerUser;
    private ControllerLogin controllerLogin;

    public ViewLogin(ControllerUser controllerUser, ControllerLogin controllerLogin){
        this.controllerUser = controllerUser;
        this.controllerLogin = controllerLogin;
    }
    public void insertLogin() {
        Scanner input = new Scanner(System.in);
        System.out.println(" - LOGIN -");
        System.out.print("Masukkan username : ");
        String username = input.nextLine();
        System.out.print("Masukkan password : ");
        String password = input.nextLine();
        controllerLogin.validasiLogin(username, password);
    }

}
