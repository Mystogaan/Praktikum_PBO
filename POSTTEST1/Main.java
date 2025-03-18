import model.Buku;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Buku> listBuku = new ArrayList<Buku>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int pilihanMenu;
        do
        {
            System.out.println("====================================");
            System.out.println("          Aplikasi Toko Buku        ");
            System.out.println("====================================");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Tampilkan Buku");
            System.out.println("3. Ubah Harga Buku");
            System.out.println("4. Ubah Stok Buku");
            System.out.println("5. Keluar");
            System.out.print("Pilihan Menu: ");
            pilihanMenu = input.nextInt();
            switch (pilihanMenu)
            {
                case 1:
                    tambahBuku();
                    break;
                case 2:
                    tampilkanBuku();
                    break;
                case 3:
                    ubahHargaBuku();
                    break;
                case 4:
                    ubahStokBuku();
                    break;
                case 5:
                    System.out.println("Terima kasih telah menggunakan aplikasi ini!");
                    break;
                default:
                    System.out.println("Pilihan menu tidak valid!");
            }
        } while (pilihanMenu != 5);
    }

    public static void tambahBuku() {
        System.out.println("====================================");
        System.out.println("          Tambah Data Buku           ");
        System.out.println("====================================");
        System.out.print("ID Buku: ");
        String idBuku = input.next();
        System.out.print("Judul Buku: ");
        String judulBuku = input.next();
        System.out.print("Stok: ");
        int stok = input.nextInt();
        System.out.print("Harga Buku: ");
        double hargaBuku = input.nextDouble();
        listBuku.add(new Buku(idBuku, judulBuku, stok, hargaBuku));
    }

    public static void tampilkanBuku() {
        System.out.println("====================================");
        System.out.println("        Buku yang tersedia:         ");
        System.out.println("====================================");
        for (Buku buku : listBuku) {
            buku.menampilkanBuku();
        }
    }

    public static void ubahHargaBuku() {
        System.out.println("====================================");
        System.out.println("          Ubah Harga Buku            ");
        System.out.println("====================================");
        System.out.print("ID Buku: ");
        String idBuku = input.next();
        System.out.print("Harga Buku Baru: ");
        double hargaBuku = input.nextDouble();
        for (Buku buku : listBuku) {
            if (buku.getIdBuku().equals(idBuku)) {
                buku.setHarga(hargaBuku);
            }
        }
    }

    public static void ubahStokBuku() {
        System.out.println("====================================");
        System.out.println("          Ubah Stok Buku             ");
        System.out.println("====================================");
        System.out.print("ID Buku: ");
        String idBuku = input.next();
        System.out.print("Stok Buku Baru: ");
        int stok = input.nextInt();
        for (Buku buku : listBuku) {
            if (buku.getIdBuku().equals(idBuku)) {
                buku.setStok(stok);
            }
        }
    }

}


