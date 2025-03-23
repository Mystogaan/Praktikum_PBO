
import service.BukuService;
import java.util.Scanner;

import model.Admin;
import model.Buku;
import model.Pelanggan;

import java.util.ArrayList;

public class Main {
    private static BukuService bukuService = new BukuService();
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Pelanggan> listPelanggan = new ArrayList<>();
    private static ArrayList<Admin> listAdmin = new ArrayList<>();

    public static void main(String[] args) {
        bukuService.tambahBuku(new Buku("001", "Harry Potter","Magic", 10, 100000));
        bukuService.tambahBuku(new Buku("002", "Percy Jackson","Action", 5, 75000));
        bukuService.tambahBuku(new Buku("003", "Sherlock Holmes","Physcology", 7, 80000));
        bukuService.tambahBuku(new Buku("004", "The Hunger Games","Thriler", 3, 90000));
        bukuService.tambahBuku(new Buku("005", "The Lord of The Rings","Fantasy", 2, 120000));

        listPelanggan.add(new Pelanggan("1", "Budi", "Jl. Merdeka No. 1", "08123456789", "budi123"));
        listPelanggan.add(new Pelanggan("2", "Andi", "Jl. Merdeka No. 2", "08123456788", "andi123"));
       

        listAdmin.add(new Admin("1", "Admin1", "admin1", "admin123", "admin@gmail.com", "08123456789"));

        login();
    }

    public static void login() {
        while (true) {
            System.out.println("========================");
            System.out.println("         LOGIN          ");
            System.out.println("========================");

            System.out.print("Masukkan username: ");
            String username = scanner.nextLine();
            System.out.print("Masukkan password: ");
            String password = scanner.nextLine();

            for (Admin admin : listAdmin) {
                if (admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
                    System.out.println("\nLogin berhasil sebagai ADMIN\n");
                    menuAdmin();
                    return;
                }
            }
            for (Pelanggan pelanggan : listPelanggan) {
                if (pelanggan.getNamaPelanggan().equals(username) && pelanggan.getPassword().equals(password)) {
                    System.out.println("\nLogin berhasil sebagai PELANGGAN \n");
                    menuPelanggan();
                    return;
                }
            }
            System.out.println("\nUsername atau password salah! Coba lagi.\n");
        }
    }

    public static void menuAdmin() {
        while (true) {
            System.out.println("========================");
            System.out.println("        MENU ADMIN      ");
            System.out.println("========================");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Hapus Buku");
            System.out.println("3. Lihat Daftar Buku");
            System.out.println("4. Lihat Laporan Penjualan");
            System.out.println("5. Logout");
            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); 

            switch (pilihan) {
                case 1:
                    tambahBuku();
                    break;
                case 2:
                    hapusBuku();
                    break;
                case 3:
                    System.out.println("========================");
                    System.out.println("      DAFTAR BUKU       ");
                    System.out.println("========================");
                    bukuService.tampilkanBuku();
                    break;
                case 4:
                    System.out.println("\nLogout berhasil n");
                    return; 
                default:
                    System.out.println("\n Pilihan tidak valid \n");
            }
        }
    }

    public static void menuPelanggan() {
        while (true) {
            System.out.println("========================");
            System.out.println("     MENU PELANGGAN     ");
            System.out.println("========================");
            System.out.println("1. Lihat Buku");
            System.out.println("2. Beli Buku");
            System.out.println("3. Logout");
            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); 

            switch (pilihan) {
                case 1:
                    System.out.println("\n========================");
                    System.out.println("         DAFTAR BUKU      ");
                    System.out.println("\n========================");
                    bukuService.tampilkanBuku();
                    break;
                case 2:
                    beliBuku();
                    break;
                case 3:
                    System.out.println("\nLogout berhasil n");
                    return; 
                default:
                    System.out.println("\n Pilihan tidak valid \n");
            }
        }
    }

    public static void tambahBuku() {
        System.out.println("========================");
        System.out.println("      TAMBAH BUKU       ");
        System.out.println("========================");
        System.out.print("Masukkan Kode Buku: ");
        String kode = scanner.nextLine();
        System.out.print("Masukkan Nama Buku: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan Genre Buku: ");
        String genre = scanner.nextLine();
        System.out.print("Masukkan Stok Buku: ");
        int stok = scanner.nextInt();
        System.out.print("Masukkan Harga Buku: ");
        int harga = scanner.nextInt();
        scanner.nextLine(); 

        Buku bukuBaru = new Buku(kode, nama, genre, stok, harga);
        bukuService.tambahBuku(bukuBaru);
        System.out.println("\nBuku berhasil ditambahkan!\n");
    }

    public static void hapusBuku() {
        System.out.println("========================");
        System.out.println("      HAPUS BUKU        ");
        System.out.println("========================\n\n");
        bukuService.tampilkanBuku();
        System.out.print("Masukkan Kode Buku yang ingin dihapus: ");
        String kode = scanner.nextLine();
        if (bukuService.hapusBuku(kode)) {
            System.out.println("\nBuku berhasil dihapus! n");
        } else {
            System.out.println("\n Buku tidak ditemukan \n");
        }
    }

    public static void beliBuku() {
        System.out.println("========================");
        System.out.println("       BELI BUKU        ");
        System.out.println("========================");
        bukuService.tampilkanBuku();
        System.out.print("Masukkan Kode Buku yang ingin dibeli: ");
        String kode = scanner.nextLine();
        System.out.print("Masukkan Jumlah Buku yang ingin dibeli: ");
        int jumlah = scanner.nextInt();
        scanner.nextLine(); // Membersihkan buffer input

        if (bukuService.beliBuku(kode, jumlah)) {
            System.out.println("\nPembelian berhasil! n");
        } else {
            System.out.println("\n Pembelian gagal, cek stok atau kode buku \n");
        }
    }
}
