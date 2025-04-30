package model;

public final class Buku { 
    private final String idBuku; 
    protected String judulBuku;
    String genre;
    private int stok;
    private double hargaBuku;

    // Constructor
    public Buku(String idBuku, String judulBuku, String genre, int stok, double hargaBuku2) {
        this.idBuku = idBuku;
        this.judulBuku = judulBuku;
        this.genre = genre;
        this.stok = stok;
        this.hargaBuku = hargaBuku2;
    }

    // Getter 
    public String getIdBuku() { return idBuku; }
    public String getJudulBuku() { return judulBuku; }
    public String getGenre() { return genre; }
    public int getStok() { return stok; }
    public double getHargaBuku() { return hargaBuku; }

    // Setter
    public void setHarga(double hargaBuku) { this.hargaBuku = hargaBuku; }
    public void setStok(int stok) { this.stok = stok; }

    // Method
    public final void menampilkanBuku() {
        System.out.println("ID Buku: " + idBuku);
        System.out.println("Judul Buku: " + judulBuku);
        System.out.println("Genre: " + genre);
        System.out.println("Stok: " + stok);
        System.out.println("Harga Buku: Rp " + hargaBuku);
        System.out.println("------------------------------------");
    }
}
