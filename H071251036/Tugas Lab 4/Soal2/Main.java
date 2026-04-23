import java.util.*;

// ===== CLASS =====
class Produk {
    String merek;
    String nomorSeri;
    double harga;

    Produk(String merek, String nomorSeri, double harga) {
        this.merek = merek;
        this.nomorSeri = nomorSeri;
        this.harga = harga;
    }

    void tampilkanInfo() {
        System.out.println("Merek: " + merek);
        System.out.println("Nomor Seri: " + nomorSeri);
        System.out.println("Harga: " + harga);
    }
}

class Smartphone extends Produk {
    double layar;
    int storage;

    Smartphone(String m, String s, double h, double l, int st) {
        super(m, s, h);
        layar = l;
        storage = st;
    }

    void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Layar: " + layar);
        System.out.println("Storage: " + storage);
    }
}

class Laptop extends Produk {
    String processor;

    Laptop(String m, String s, double h, String p) {
        super(m, s, h);
        processor = p;
    }

    void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Processor: " + processor);
    }
}

class Kamera extends Produk {
    int mp;

    Kamera(String m, String s, double h, int mp) {
        super(m, s, h);
        this.mp = mp;
    }

    void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Megapixel: " + mp);
    }
}

// ===== MAIN =====
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Produk> daftarProduk = new ArrayList<>();

        int pilihan;

        do {
            System.out.println("\n=== MENU TOKO ===");
            System.out.println("1. Tambah Produk");
            System.out.println("2. Tampilkan Produk");
            System.out.println("3. Beli Produk");
            System.out.println("4. Keluar");
            System.out.print("Pilih: ");
            pilihan = Integer.parseInt(input.nextLine());

            if (pilihan == 1) {
                System.out.println("1. Smartphone\n2. Laptop\n3. Kamera");
                int jenis = Integer.parseInt(input.nextLine());

                System.out.print("Merek: ");
                String merek = input.nextLine();

                String seri;
                boolean ada;

                // 🔥 CEK NOMOR SERI
                do {
                    ada = false;
                    System.out.print("Nomor Seri: ");
                    seri = input.nextLine();

                    for (Produk p : daftarProduk) {
                        if (p.nomorSeri.equalsIgnoreCase(seri)) {
                            System.out.println("❌ Nomor seri sudah ada!");
                            ada = true;
                            break;
                        }
                    }
                } while (ada);

                System.out.print("Harga: ");
                double harga = Double.parseDouble(input.nextLine());

                if (jenis == 1) {
                    System.out.print("Layar: ");
                    double layar = Double.parseDouble(input.nextLine());

                    System.out.print("Storage: ");
                    int storage = Integer.parseInt(input.nextLine());

                    daftarProduk.add(new Smartphone(merek, seri, harga, layar, storage));

                } else if (jenis == 2) {
                    System.out.print("Processor: ");
                    String proc = input.nextLine();

                    daftarProduk.add(new Laptop(merek, seri, harga, proc));

                } else if (jenis == 3) {
                    System.out.print("Megapixel: ");
                    int mp = Integer.parseInt(input.nextLine());

                    daftarProduk.add(new Kamera(merek, seri, harga, mp));
                }

                System.out.println("✅ Produk ditambahkan!");

            } else if (pilihan == 2) {
                if (daftarProduk.isEmpty()) {
                    System.out.println("Belum ada produk!");
                } else {
                    for (Produk p : daftarProduk) {
                        System.out.println("\n-------------");
                        p.tampilkanInfo();
                    }
                }

            } else if (pilihan == 3) {
                System.out.print("Masukkan nomor seri: ");
                String cari = input.nextLine();

                boolean ditemukan = false;

                for (int i = 0; i < daftarProduk.size(); i++) {
                    if (daftarProduk.get(i).nomorSeri.equalsIgnoreCase(cari)) {
                        System.out.println("Produk ditemukan:");
                        daftarProduk.get(i).tampilkanInfo();

                        System.out.println("✅ Berhasil dibeli!");
                        daftarProduk.remove(i); // 🔥 HAPUS

                        ditemukan = true;
                        break;
                    }
                }

                if (!ditemukan) {
                    System.out.println("❌ Produk tidak ditemukan!");
                }
            }

        } 
     while (pilihan != 4);
     input.close(); // ✅ tambahkan ini
     System.out.println("Program selesai.");    
    }
}