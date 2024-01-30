package Controller;

import Model.ModelAdmin;

public class ControllerAdmin {
    private ModelAdmin modelAdmin;

    public ControllerAdmin(ModelAdmin modelAdmin){
        this.modelAdmin = modelAdmin;
        execute();
    }
    public void execute(){
        modelAdmin.insert("admin", "12345");
        modelAdmin.insert("saya", "admin");
    }
    public void viewAllAdmin(){
        modelAdmin.viewAll();
    }
}
