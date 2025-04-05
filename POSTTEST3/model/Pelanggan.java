package model;

public class Pelanggan extends User {
    private String alamat;

    public Pelanggan(String idPelanggan, String namaPelanggan, String alamat, String noTelp, String password) {
        super(idPelanggan, namaPelanggan, noTelp, password);
        this.alamat = alamat;
    }

    public String getIdPelanggan() {
        return id;
    }

    public String getNamaPelanggan() {
        return nama;
    }

    public String getNoTelpPelanggan() {
        return noTelp;
    }

    public String getPasswordPelanggan() {
        return password;
    }

    public String getAlamat() {
        return alamat;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Alamat: " + alamat);
    }
}
