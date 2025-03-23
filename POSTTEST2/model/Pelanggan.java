package model;

public class Pelanggan {
    private String idPelanggan;
    private String namaPelanggan;
    private String alamat;
    private String noTelp;
    private String password;

    public Pelanggan(String idPelanggan, String namaPelanggan, String alamat, String noTelp, String password) {
        this.idPelanggan = idPelanggan;
        this.namaPelanggan = namaPelanggan;
        this.alamat = alamat;
        this.noTelp = noTelp;
        this.password = password;
    }

    public String getIdPelanggan() {
        return idPelanggan;
    }
    public String getNamaPelanggan() {
        return namaPelanggan;
    }
    public String getAlamat() {
        return alamat;
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
    
}
