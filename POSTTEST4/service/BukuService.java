package service;
import model.Buku;
import java.util.ArrayList;

public class BukuService {
    private static ArrayList<Buku> listBuku = new ArrayList<Buku>();

    public void tambahBuku(Buku buku) {
        listBuku.add(buku);
    }

    public void tampilkanBuku() {
        if(daftarBuku().isEmpty()) {
            System.out.println("Tidak ada buku yang tersedia");
        } else {
            for(Buku buku : daftarBuku()) {
                buku.menampilkanBuku();
            }
        }
    }

    public Buku cariBuku(String idBuku) {
        for (Buku buku : listBuku) {
            if (buku.getIdBuku().equals(idBuku)) {
                return buku;
            }
        }
        return null;
    }

    public void updateBuku(String idBuku, double hargaBuku, int stok) {
        Buku buku = cariBuku(idBuku);
        if (buku != null) {
            buku.setHarga(hargaBuku);
            buku.setStok(stok);
            System.out.println("Buku berhasil diupdate!");
        } else {
            System.out.println("Buku tidak ditemukan.");
        }
    }
    
    public boolean hapusBuku(String idBuku) {                                      
        Buku buku = cariBuku(idBuku);
        if (buku != null) {
            listBuku.remove(buku);
            System.out.println("Buku berhasil dihapus!");
            return true;
        } else {
            System.out.println("Buku tidak ditemukan.");
            return false;
        }
    }
    

    public boolean beliBuku(String idBuku, int jumlah) {
        Buku buku = cariBuku(idBuku);
        if (buku != null && buku.getStok() >= jumlah) {
            buku.setStok(buku.getStok() - jumlah);
            System.out.println("✅ Pembelian berhasil!");
            return true;
        } else {
            System.out.println("Pembelian gagal, stok tidak mencukupi atau buku tidak ditemukan.");
            return false;
        }
    }    

    public ArrayList<Buku> daftarBuku() {
        return listBuku;
    }
}
