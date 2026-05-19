import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner anu = new Scanner(System.in);
        ArrayList<product> products = new ArrayList<>();
        while (true){
            try{
                System.out.println("\nMENU");
                System.out.println("1. Tambah Produk      ");
                System.out.println("2. Tampilkan Semua Produk");
                System.out.println("3. Beli Produk        ");
                System.out.println("4. Exit               ");
                System.out.print("Pilih Menu : ");
                int menu = anu.nextInt();
                if (menu == 1){
                    anu.nextLine();
                    System.out.print("Nama Brand : ");
                    String brand = anu.nextLine();
                    System.out.print("Series Number : ");
                    int seriesnumber = anu.nextInt();
                    System.out.print("Price : ");
                    double price = anu.nextDouble();
                    boolean valid = true;
                    if (price <= 0 || seriesnumber <= 0){
                        System.out.println("Harap masukkan angka positif");
                        valid = false;
                    }
                    for (product cek : products){
                        if (seriesnumber == cek.seriesnumber){
                            System.out.println("Series number sudah ada.");
                            valid = false;
                        }
                    } 
                    if (valid){
                        System.out.println("Pilih tipe produk");
                        System.out.println("1. HP ");
                        System.out.println("2. Laptop  ");
                        System.out.println("3. Camera ");
                        System.out.print("Pilih Tipe : ");
                        int tipe = anu.nextInt();
                        boolean validasitipe = true;
                        if (tipe == 1){
                            System.out.print("Screen Size : ");
                            double screenSize = anu.nextDouble();
                            System.out.print("Storage Capacity : ");
                            int storageCapacity = anu.nextInt();
                            if (screenSize <= 0 || storageCapacity <= 0){
                                System.out.println("Harap masukkan angka positif");
                                validasitipe = false;
                            } 
                            if (validasitipe) {
                                products.add(new hp(brand, seriesnumber, price, screenSize, storageCapacity));
                                System.out.println("produk berhasil ditambahkan");
                            }
                        } else if (tipe == 2){
                            System.out.print("RAM Size : ");
                            double RamSize = anu.nextDouble();
                            anu.nextLine();
                            System.out.print("Processor Type : ");
                            String processorType = anu.nextLine();
                            if (RamSize <= 0){
                                System.out.print("Harap masukkan angka yang benar");
                                validasitipe = false;
                            }
                            if (validasitipe) {
                                products.add(new laptop(brand, seriesnumber, price, RamSize, processorType));
                                System.out.print("produk berhasil ditambahkan");
                            }
                        } else if (tipe == 3){
                            System.out.println("Resolution : ");
                            double resolution = anu.nextDouble();
                            anu.nextLine();
                            System.out.println("Lens Type : ");
                            String lensType = anu.nextLine();
                            if (resolution <= 0){
                                System.out.println("Harap masukkan angka yang benar");
                                validasitipe = false;
                            } if (validasitipe) {
                                products.add(new camera(brand, seriesnumber, price, resolution, lensType));
                                System.out.println("produk berhasil ditambahkan");
                            }
                        } else {
                            System.out.println("Tipe ke-"+ tipe + " tidak tersedia");
                        }
                    }

                } else if (menu == 2){
                    for (product p : products){
                        p.displayInfo();
                    }
                } else if (menu == 3){
                    System.out.print("Masukkan series number produk yang ingin dibeli : ");
                    int seriesnumber = anu.nextInt();
                    boolean found = false;
                    for (product p : products){
                        if (seriesnumber == p.seriesnumber){
                            System.out.println("Anda membeli produk dengan series number " + seriesnumber);
                            System.out.println("Total harga yang harus dibayar : Rp " + p.price);
                            System.out.println("transaksi berhasil");
                            products.remove(p);
                            found = true;
                        }
                    }
                    if (!found){
                        System.out.println("Produk dengan series number " + seriesnumber + " tidak ditemukan");
                    }
                } else if (menu == 4){
                    System.out.println("Terima kasih telah menggunakan program ini.");
                    break;
                } else {
                    System.out.println("Menu ke-"+ menu + " tidak tersedia");
                }

            }catch (Exception e) {
                anu.nextLine();

            }
        }
        anu.close();
    }
}