package Soal2;

import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static Produk[] stok = new Produk[100];
    static int jumlahProduk = 0;

    public static void main(String[] args) {
        int pilihan = 0;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Produk");
            System.out.println("2. Tampilkan Semua Produk");
            System.out.println("3. Beli Produk");
            System.out.println("4. Keluar");
            System.out.print(">>> Pilih menu (1-4): ");

            if (scan.hasNextInt()) {
                pilihan = scan.nextInt();
                scan.nextLine();
            } else {
                System.out.println("Input tidak valid! Masukkan angka.");
                scan.nextLine();
                pilihan = 0;
                continue;
            }

            if (pilihan == 1) {
                tambahProduk();
            } else if (pilihan == 2) {
                tampilkanSemua();
            } else if (pilihan == 3) {
                beliProduk();
            } else if (pilihan == 4) {
                System.out.println("DOneeeee");
            } else {
                System.out.println("Pilihan menu tidak tersedia.");
            }
        } while (pilihan != 4);

        scan.close();
    }

    static void tambahProduk() {
        if (jumlahProduk >= stok.length) {
            System.out.println("Stok penuh! Tidak bisa menambah produk lagi.");
            return;
        }

        System.out.print("Masukkan nama produk: ");
        String merk = scan.nextLine();

        System.out.print("Masukkan nomor seri: ");
        int nomorSeri = scan.nextInt();
        scan.nextLine();

        for (int i = 0; i < jumlahProduk; i++) {
            if (stok[i].getNomorSeri() == nomorSeri) {
                System.out.println("Gagal: Nomor seri sudah terdaftar! Produk tidak ditambahkan.");
                return;
            }
        }

        System.out.print("Masukkan harga: ");
        double harga = scan.nextDouble();

        System.out.println("Pilih tipe produk:");
        System.out.println("1. Smartphone");
        System.out.println("2. Laptop");
        System.out.println("3. Camera");
        System.out.print("Pilih tipe produk (1-3): ");
        int tipe = scan.nextInt();

        Produk produkBaru = null;

        if (tipe == 1) {
            System.out.print("Masukkan ukuran layar (inci): ");
            double layar = scan.nextDouble();
            System.out.print("Masukkan kapasitas penyimpanan (GB): ");
            int storage = scan.nextInt();
            scan.nextLine();
            produkBaru = new Smartphone(merk, nomorSeri, harga, layar, storage);
        } else if (tipe == 2) {
            System.out.print("Masukkan ukuran RAM (GB): ");
            int ram = scan.nextInt();
            scan.nextLine();
            System.out.print("Masukkan tipe processor: ");
            String processor = scan.nextLine();
            produkBaru = new Laptop(merk, nomorSeri, harga, ram, processor);
        } else if (tipe == 3) {
            System.out.print("Masukkan resolusi (MP): ");
            int resolusi = scan.nextInt();
            scan.nextLine();
            System.out.print("Masukkan tipe lensa: ");
            String lensa = scan.nextLine();
            produkBaru = new Camera(merk, nomorSeri, harga, resolusi, lensa);
        } else {
            System.out.println("Tipe produk tidak valid!");
            return;
        }

        stok[jumlahProduk] = produkBaru;
        jumlahProduk++;
        System.out.println("Produk berhasil ditambahkan!");
    }

    static void tampilkanSemua() {
        System.out.println("\nDaftar Produk:");
        if (jumlahProduk == 0) {
            System.out.println("Stok masih kosong.");
        } else {
            for (int i = 0; i < jumlahProduk; i++) {
                stok[i].tampilInfo();
                System.out.println();
            }
        }
    }

    static void beliProduk() {
        System.out.print("Masukkan nomor seri produk yang ingin dibeli: ");
        if (!scan.hasNextInt()) {
            System.out.println("Input harus berupa angka!");
            scan.nextLine();
            return;
        }
        int cari = scan.nextInt();
        scan.nextLine();
        boolean ketemu = false;

        for (int i = 0; i < jumlahProduk; i++) {
            if (stok[i].getNomorSeri() == cari) {
                System.out.println("Anda telah membeli produk:");
                stok[i].tampilInfo();
                ketemu = true;

                for (int j = i; j < jumlahProduk - 1; j++) {
                    stok[j] = stok[j + 1];
                }
                stok[jumlahProduk - 1] = null;
                jumlahProduk--;
                System.out.println("Produk berhasil dihapus dari stok.");
                break;
            }
        }

        if (!ketemu) {
            System.out.println("Produk dengan nomor seri tersebut tidak ditemukan.");
        }
    }
}