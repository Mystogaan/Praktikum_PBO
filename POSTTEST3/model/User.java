package model;

public class User {
    protected String id;
    protected String nama;
    protected String noTelp;
    protected String password;

    public User(String id, String nama, String noTelp, String password) {
        this.id = id;
        this.nama = nama;
        this.noTelp = noTelp;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void displayInfo() {
        System.out.println("ID: " + id);
        System.out.println("Nama: " + nama);
        System.out.println("No. Telepon: " + noTelp);
    }
}
