package Node;

public class Admin implements Node{
    public String username;
    private String password;

    public Admin(String username, String password){
        this.username = username;
        this.password = password;
    }

    @Override
    public void display() {
        System.out.println("=====================");
        System.out.println("Username : "+username);
        System.out.println("Password : "+password);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
