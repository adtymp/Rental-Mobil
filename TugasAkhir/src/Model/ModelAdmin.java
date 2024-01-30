package Model;

import Node.Admin;

import java.util.ArrayList;

public class ModelAdmin {
    public ArrayList<Admin> listAdmin;

    public ModelAdmin(){
        listAdmin = new ArrayList<>();
    }
    public void insert(String username, String password){
        listAdmin.add(new Admin(username, password));
    }
    public void viewAll(){
        for (Admin admin : listAdmin){
            admin.display();
        }
    }
//    public void update(String username, String newPassword){
//        for(int i=0; i<listAdmin.size(); i++){
//            if(username.equalsIgnoreCase(listAdmin.get(i).username)){
//                listAdmin.get(i).setPassword(newPassword);
//            }
//        }
//    }
    public ArrayList<Admin> search(String username, String password){
        ArrayList<Admin> list = new ArrayList<>();
        for (Admin admin : listAdmin){
            if(admin.username.equalsIgnoreCase(username) && admin.getPassword().equalsIgnoreCase(password)){
                list.add(admin);
            }
        }
        return list;
    }
}
