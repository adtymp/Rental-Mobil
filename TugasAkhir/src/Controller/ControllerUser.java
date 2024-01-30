package Controller;

import Model.ModelUser;
import Node.User;

import java.util.ArrayList;
import java.util.Scanner;

public class ControllerUser{
    private ModelUser modelUser;

    public ControllerUser(ModelUser modelUser){
        this.modelUser = modelUser;
        executeUser();
    }
    public void executeUser(){
        modelUser.insert(new User("bret", "222", "Loss Brett", "12345"));
    }

    public void insert() {
        Scanner input = new Scanner(System.in);
        System.out.println("-Tambah User-");
        System.out.print("Masukkan Username : ");
        String username = input.nextLine();
        ArrayList<User> listUser = modelUser.searchName(username);
        if(listUser != null){
            System.out.println("Username Sudah Ada");
        }
        else {
            System.out.print("Masukkan Password : ");
            String password = input.nextLine();
            System.out.print("Masukkan Nama Lengkap : ");
            String nama = input.nextLine();
            System.out.print("Masukkan NIK : ");
            String nik = input.nextLine();
            modelUser.insert(new User(username, password, nama, nik));
        }

    }
    public void update(String username) {
        Scanner input = new Scanner(System.in);
        User user = modelUser.search(username);
        if(user == null){
            System.out.println("User Tidak Ada");
        }
        else {
            System.out.println("-Update User-");
            System.out.print("Masukkan Pasword : ");
            String password = input.nextLine();
            System.out.print("Masukkan Password Baru : ");
            String newPass = input.nextLine();
            modelUser.update(username, password, newPass);
        }
    }
    public void search(String username){
        User user = modelUser.search(username);
        if(user == null){
            System.out.println("User Tidak ada");
        }
        else {
            System.out.println("Username : "+username);
            System.out.println("Nama : "+user.nama);
            System.out.println("NIK : "+user.nik);
            System.out.println(user.getPassword());

        }
    }
}
