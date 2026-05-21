import java.util.Scanner;
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Product[] stokProduk = new Product[100]; // array yg bisa menampung 100 produk
        int totalProduk = 0;
        // produk awal
        stokProduk[totalProduk++] = new Smartphone("Samsung", 123456, 899.99, 6.5, 256);
        stokProduk[totalProduk++] = new Laptop("Dell", 987654, 1299.99, 16, "Intel Core i7");
        stokProduk[totalProduk++] = new Camera("Canon", 456789, 699.99, 24, "Telephoto");

        boolean info = true; 

        while (info) {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Produk");
            System.out.println("2. Tampilkan Semua Produk");
            System.out.println("3. Beli Produk");
            System.out.println("4. Keluar");
            System.out.print("\n>>> Pilih menu (1-4): ");
            int menu = scanner.nextInt();
            scanner.nextLine();

            if (menu == 1) { 
                System.out.print("Masukkan nama produk: ");
                String brand = scanner.nextLine();

                int seriesNumber;
                boolean ada;
                do {
                    ada = false;
                    System.out.print("Masukkan nomor seri: ");
                    seriesNumber = scanner.nextInt(); 
                    for (int i = 0; i < totalProduk; i++){
                        if (stokProduk[i].SeriesNumber() == seriesNumber){
                            ada = true;                         
                            System.out.println("Nomor seri telah digunakan ! Silahkan ganti nomor seri.\n");
                            break;
                        }
                    }
                } while (ada);

                System.out.print("Masukkan harga: ");
                double price = scanner.nextDouble();

                System.out.println("Pilih tipe produk:");
                System.out.println("1. Smartphone");
                System.out.println("2. Laptop");
                System.out.println("3. Camera");
                System.out.print("Pilih tipe produk (1-3): ");
                int type = scanner.nextInt();
                scanner.nextLine();

                if (type == 1) {
                    System.out.print("Masukkan ukuran layar (inci): ");
                    double screenSize = scanner.nextDouble();
                    System.out.print("Masukkan kapasitas penyimpanan (GB): ");
                    int storage = scanner.nextInt();
                    stokProduk[totalProduk++] = new Smartphone(brand, seriesNumber, price, screenSize, storage);
                    // Menambahkan produk hp baru ke dalam stok
                } else if (type == 2) {
                    System.out.print("Masukkan tipe prosesor: ");
                    String proc = scanner.nextLine();
                    System.out.print("Masukkan ukuran RAM (GB): ");
                    int ram = scanner.nextInt();
                    stokProduk[totalProduk++] = new Laptop(brand, seriesNumber, price, ram, proc);
                } else if (type == 3) {
                    System.out.print("Masukkan resolusi (MP): ");
                    int res = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Masukkan tipe lensa: ");
                    String lens = scanner.nextLine();
                    stokProduk[totalProduk++] = new Camera(brand, seriesNumber, price, res, lens);
                }

            } else if (menu == 2) { 
                System.out.println("Daftar Produk:");
                for (int i = 0; i < totalProduk; i++) {  //jika i = 0, maka akan menampilkan produk pertama, jika i < topro maka akan bertambah 1
                    stokProduk[i].displayInfo();
                }

            } else if (menu == 3) { 
                System.out.print("Masukkan nomor seri produk yang ingin dibeli: ");
                int targetSeri = scanner.nextInt();
                boolean ditemukan = false; // blm mnemukn
                // untuk mncari produk dlm array berdasarkan nomor seri
                for (int i = 0; i < totalProduk; i++) {
                    if (stokProduk[i].SeriesNumber() == targetSeri) {
                        ditemukan = true;
                        System.out.println("Anda telah membeli produk:");
                        stokProduk[i].displayInfo();
                        // untuk menghapus produk yang sudah dibeli, menggeser semua produk setelahnya ke kiri
                        for (int j = i; j < totalProduk - 1; j++) {
                            stokProduk[j] = stokProduk[j + 1];
                        }
                        stokProduk[totalProduk - 1] = null; // mengosongkan slot terakhir krn -1
                        totalProduk--;
                        break;
                    }
                }
                if (!ditemukan) {
                    System.out.println("Produk dengan nomor seri tersebut tidak ditemukan.");
                }
            } else if (menu == 4) { 
                System.out.println("Terima kasih telah menggunakan layanan kami. Sampai jumpa!");
                info = false;
            }
        }
        scanner.close();
    }
}