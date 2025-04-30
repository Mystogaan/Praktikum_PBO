package model;

public class Admin extends User {
    private String username;
    private String email;

    public Admin(String idAdmin, String namaAdmin, String username, String password, String email, String noTelp) {
        super(idAdmin, namaAdmin, noTelp, password);
        this.username = username;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void tampilkanPesan() {
        System.out.println("Selamat datang, " + nama);
    }
    
    @Override
    public void salamPenutup() {
        System.out.println("Terima kasih telah menggunakan aplikasi kami.");
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
    }

    @Override
    public void displayInfo(boolean detail) {
        super.displayInfo(detail); // panggil dari User

        if (detail) {
            System.out.println("Username: " + username);
            System.out.println("Email: " + email);
        }
    }

    @Override
    public String getRole() {
        return "Admin";
    }
}
