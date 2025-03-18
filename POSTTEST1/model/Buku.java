package model;

public class Buku {
    // Atribut
    private String idBuku;
    private String judulBuku;
    private int stok;
    private double hargaBuku;

    // Constructor
    public Buku(String idBuku, String judulBuku, int stok, double hargaBuku2) {
        this.idBuku = idBuku;
        this.judulBuku = judulBuku;
        this.stok = stok;
        this.hargaBuku = hargaBuku2;
    }

    // Getter 
    public String getIdBuku() {
        return idBuku;
    }
    public String getJudulBuku() {
        return judulBuku;
    }
    public int getStok() {
        return stok;
    }
    public double getHargaBuku() {
        return hargaBuku;
    }

    // Setter
    public void setHarga(double hargaBuku) 
    { 
        this.hargaBuku = hargaBuku; 
    }
    public void setStok(int stok) 
    { 
        this.stok = stok; 
    }

    // Method
    public void menampilkanBuku() {
        System.out.println("====================================");
        System.out.println("        Buku yang tersedia:         ");
        System.out.println("====================================");
        System.out.println("ID Buku: " + idBuku);
        System.out.println("Judul Buku: " + judulBuku);
        System.out.println("Stok: " + stok);
        System.out.println("Harga Buku: Rp " + hargaBuku);
        System.out.println("------------------------------------");
    }
}
