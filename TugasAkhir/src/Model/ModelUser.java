package Model;

import Node.User;

import java.util.ArrayList;

public class ModelUser {
    public ArrayList<User> listUser;

    public ModelUser(){
        listUser = new ArrayList<>();
    }
    public void insert(User user){
        listUser.add(user);
    }
    public void viewAll(){
        for(User user : listUser){
            user.display();
        }
    }
    public void update(String username, String password, String newPassword){
        for(int i=0; i<listUser.size(); i++){
            if(listUser.get(i).username.equalsIgnoreCase(username) && listUser.get(i).getPassword().equalsIgnoreCase(password)){
                listUser.get(i).setPassword(newPassword);
            }
        }
    }
    public User search(String username){
        User pengguna = null;
        for (User user : listUser){
            if(user.username.equalsIgnoreCase(username)){
                return user;
            }
        }
        return pengguna;
    }
    public ArrayList<User> searchName(String username){
        ArrayList<User> list = new ArrayList<>();
        for (User user : listUser){
            if(user.username.equalsIgnoreCase(username)){
                list.add(user);
            }
        }
        return list;
    }
    public ArrayList<User> searchName(String username, String pass){
        ArrayList<User> list = new ArrayList<>();
        for (User user : listUser){
            if(user.username.equalsIgnoreCase(username) && user.getPassword().equalsIgnoreCase(pass)){
                list.add(user);
            }
        }
        return list;
    }
}
