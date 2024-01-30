package Controller;

import Model.ModelAdmin;
import Model.ModelUser;
import Node.Admin;
import Node.User;
import View.ViewAdmin;
import View.ViewSewa;
import View.ViewUser;

import java.util.ArrayList;

public class ControllerLogin {
    private ModelUser modelUser;
    private ModelAdmin modelAdmin;
    private ViewAdmin viewAdmin;
    private ViewUser viewUser;

    public ControllerLogin(ViewUser viewUser, ViewAdmin viewAdmin, ModelUser modelUser, ModelAdmin modelAdmin) {
        this.viewAdmin = viewAdmin;
        this.viewUser = viewUser;
        this.modelUser = modelUser;
        this.modelAdmin = modelAdmin;
    }

    public void validasiLogin(String username, String password) {
        ArrayList<User> listUser = modelUser.searchName(username, password);
        if(listUser != null) {
            for (User user : listUser) {
                if (user.username.equalsIgnoreCase(username) && user.getPassword().equals(password)) {
                    viewUser.viewUtamaUser(username);
                    return;
                }
            }
        }
        else {
            System.out.println("User Tidak Ditemukan");
        }

        ArrayList<Admin> listAdmin = modelAdmin.search(username, password);
        if(listAdmin != null) {
            for(Admin admin : listAdmin) {
                if(admin.username.equals(username) && admin.getPassword().equals(password)) {
                    viewAdmin.viewUtamaAdmin();
                }
            }
        }
    }
}
