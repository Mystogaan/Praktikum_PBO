import service.BukuService;
import java.util.Scanner;
import model.Admin;
import model.Buku;
import model.Pelanggan;
import model.User;
import java.util.ArrayList;

public class Main {
    private static BukuService bukuService = new BukuService();
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<User> users = new ArrayList<>(); 

    public static void main(String[] args) {
        // Menambahkan buku ke dalam daftar
        bukuService.tambahBuku(new Buku("001", "Harry Potter", "Magic", 10, 100000));
        bukuService.tambahBuku(new Buku("002", "Percy Jackson", "Action", 5, 75000));
        bukuService.tambahBuku(new Buku("003", "Sherlock Holmes", "Psychology", 7, 80000));
        bukuService.tambahBuku(new Buku("004", "The Hunger Games", "Thriller", 3, 90000));
        bukuService.tambahBuku(new Buku("005", "The Lord of The Rings", "Fantasy", 2, 120000));

        // Menambahkan data pengguna (Admin dan Pelanggan)
        users.add(new Pelanggan("1", "Budi", "Jl. Merdeka No. 1", "08123456789", "budi123"));
        users.add(new Pelanggan("2", "Andi", "Jl. Merdeka No. 2", "08123456788", "andi123"));
        users.add(new Admin("A1", "Admin1", "admin1", "admin123", "admin@gmail.com", "08123456789"));

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

            for (User user : users) {
                if (user instanceof Admin && ((Admin) user).getUsername().equals(username) && user.getPassword().equals(password)) {
                    System.out.println("\nLogin berhasil sebagai ADMIN\n");

                    // Tampilkan info user
                    user.displayInfo();
                    System.out.println("\nDisplay Info Lengkap menggunakan Overload: ");
                    user.displayInfo(true);
                    System.out.println("Role: " + user.getRole());
                    menuAdmin();
                    return;
                } else if (user instanceof Pelanggan && ((Pelanggan) user).getNamaPelanggan().equals(username) && user.getPassword().equals(password)) {
                    System.out.println("\nLogin berhasil sebagai PELANGGAN\n");

                    // Tampilkan info user
                    user.displayInfo();
                    System.out.println("\nDisplay Info Lengkap menggunakan Overload: ");
                    user.displayInfo(true);
                    System.out.println("Role: " + user.getRole());
                    menuPelanggan();
                    return;
                }
            }
            System.out.println("\nUsername atau password salah! Coba lagi.\n");
        }
    }

    public static void menuAdmin() {
        while (true) {
            users.get(0).tampilkanPesan(); // Tampilkan pesan selamat datang
            System.out.println("========================");
            System.out.println("        MENU ADMIN      ");
            System.out.println("========================");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Hapus Buku");
            System.out.println("3. Lihat Daftar Buku");
            System.out.println("4. Logout");
            System.out.print("Pilih menu: ");
            
            int pilihan = -1;
            try {
                pilihan = scanner.nextInt();
                scanner.nextLine(); // clear newline
            } catch (Exception e) {
                System.out.println("\nInput harus berupa angka!\n");
                scanner.nextLine(); // buang input salah
                continue; // kembali ke menu
            }
    
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
                    System.out.println("\nLogout berhasil\n");
                    users.get(0).salamPenutup();
                    return;
                default:
                    System.out.println("\nPilihan tidak valid \n");
            }
        }
    }    

    public static void menuPelanggan() {
    while (true) {
        users.get(1).tampilkanPesan(); // Tampilkan pesan selamat datang
        System.out.println("========================");
        System.out.println("     MENU PELANGGAN     ");
        System.out.println("========================");
        System.out.println("1. Lihat Buku");
        System.out.println("2. Beli Buku");
        System.out.println("3. Logout");
        System.out.print("Pilih menu: ");

        int pilihan = -1;
        try {
            pilihan = scanner.nextInt();
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("\nInput harus berupa angka!\n");
            scanner.nextLine();
            continue;
        }

        switch (pilihan) {
            case 1:
                System.out.println("\n========================");
                System.out.println("      DAFTAR BUKU      ");
                System.out.println("========================\n");
                bukuService.tampilkanBuku();
                break;
            case 2:
                beliBuku();
                break;
            case 3:
                System.out.println("\nLogout berhasil\n");
                users.get(1).salamPenutup();
                return;
            default:
                System.out.println("\nPilihan tidak valid \n");
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

    int stok = 0;
    int harga = 0;
    try {
        System.out.print("Masukkan Stok Buku: ");
        stok = scanner.nextInt();
        System.out.print("Masukkan Harga Buku: ");
        harga = scanner.nextInt();
        scanner.nextLine();
    } catch (Exception e) {
        System.out.println("\nInput stok dan harga harus berupa angka!\n");
        scanner.nextLine();
        return;
    }

    Buku bukuBaru = new Buku(kode, nama, genre, stok, harga);
    bukuService.tambahBuku(bukuBaru);
    System.out.println("\nBuku berhasil ditambahkan!\n");
}


    public static void hapusBuku() {
        System.out.println("========================");
        System.out.println("      HAPUS BUKU        ");
        System.out.println("========================\n");
        bukuService.tampilkanBuku();
        System.out.print("Masukkan Kode Buku yang ingin dihapus: ");
        String kode = scanner.nextLine();
        if (bukuService.hapusBuku(kode)) {
            System.out.println("\nBuku berhasil dihapus!\n");
        } else {
            System.out.println("\nBuku tidak ditemukan\n");
        }
    }

    public static void beliBuku() {
        System.out.println("========================");
        System.out.println("       BELI BUKU        ");
        System.out.println("========================");
        bukuService.tampilkanBuku();
        System.out.print("Masukkan Kode Buku yang ingin dibeli: ");
        String kode = scanner.nextLine();
    
        int jumlah = 0;
        try {
            System.out.print("Masukkan Jumlah Buku yang ingin dibeli: ");
            jumlah = scanner.nextInt();
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("\nInput jumlah harus berupa angka!\n");
            scanner.nextLine();
            return;
        }
    
        if (bukuService.beliBuku(kode, jumlah)) {
            System.out.println("\nPembelian berhasil!\n");
        } else {
            System.out.println("\nPembelian gagal, cek stok atau kode buku\n");
        }
    }
    
}
