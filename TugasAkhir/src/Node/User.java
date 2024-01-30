package Node;

public class User extends Admin{
    public String nama;
    public String nik;

    public User(String username, String password, String nama, String nik){
        super(username, password);
        this.nama = nama;
        this.nik = nik;
    }
    @Override
    public void display(){
        System.out.println("=====================");
        System.out.println("Username :  "+ username);
        System.out.println("Password : "+getPassword());
        System.out.println("Nama Lengkap : "+nama);
        System.out.println("NIK : "+ nik);
    }
}
