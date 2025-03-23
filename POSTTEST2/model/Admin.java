package model;

public class Admin {
    private String idAdmin;
    private String namaAdmin;
    private String username;
    private String password;
    private String email;
    private String noTelp;

    public Admin(String idAdmin, String namaAdmin, String username, String password, String email, String noTelp) {
        this.idAdmin = idAdmin;
        this.namaAdmin = namaAdmin;
        this.username = username;
        this.password = password;
        this.email = email;
        this.noTelp = noTelp;
    }

    public String getIdAdmin() {
        return idAdmin;
    }
    public String getNamaAdmin() {
        return namaAdmin;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getEmail() {
        return email;
    }
    public String getNoTelp() {
        return noTelp;
    }
}
