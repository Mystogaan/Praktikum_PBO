package model;

public abstract class User {
    protected String id;
    protected String nama;
    protected String noTelp;
    protected String password;
    protected String role;

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
    }
    
    // Overload
    public void displayInfo(boolean detail) {
        if (detail) {
            System.out.println("ID: " + id);
            System.out.println("Nama: " + nama);
            System.out.println("role: " + role);
            System.out.println("No HP: " + noTelp);
        } else {
            displayInfo(); // panggil yang versi singkat
        }
    }

    public void setPassword(String password, String confirmPassword) {
        if (password.equals(confirmPassword)) {
            this.password = password;
        } else {
            System.out.println("Password dan konfirmasi tidak cocok!");
        }
    }
    
    public abstract String getRole(); // method abstract, harus diimplementasikan di subclass

    
}
