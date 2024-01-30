package Model;

import Node.Penyewaan;
import Node.Sewa;
import Node.User;

import java.util.ArrayList;

public class ModelPenyewaan {
    public ArrayList<Penyewaan> listPenyewaan;

    public ModelPenyewaan(){
        listPenyewaan = new ArrayList<>();
    }
    public void insert(User user, Sewa sewa, int hari){
        listPenyewaan.add(new Penyewaan(user, sewa, hari));
        sewa.setStatus();
    }
    public void viewAll(){
        for (Penyewaan penyewaan : listPenyewaan){
            penyewaan.display();
        }
    }
    public void delete(Sewa sewa){
        for (int i=0; i<listPenyewaan.size(); i++){
            if(listPenyewaan.get(i).sewa.mobil.namaMobil.equalsIgnoreCase(sewa.mobil.namaMobil) && listPenyewaan.get(i).sewa.mobil.getPlatNomer().equalsIgnoreCase(sewa.mobil.getPlatNomer())){
                listPenyewaan.remove(i);
                sewa.setStatus();
            }
        }
    }
    public ArrayList<Penyewaan> searchUser(String nama){
        ArrayList<Penyewaan> list = new ArrayList<>();
        for (Penyewaan penyewaan : listPenyewaan){
            if(penyewaan.user.username.equalsIgnoreCase(nama)){
                list.add(penyewaan);
            }
        }
        return list;
    }
}
