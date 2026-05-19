package Baru;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan nama pengguna: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan NIM pengguna: ");
        String nim = scanner.nextLine();
        System.out.print("Masukkan merk laptop: ");
        String merk = scanner.nextLine();

        Tugas tugas1 = new Tugas("Sedang", 2);
        User pengguna3 = new User();
        Laptop laptop1 = new Laptop(merk, tugas1);
        User pengguna1 = new User(nama, nim, laptop1);
        User pengguna2 = new User("Arip", "H071251099", new Laptop(" MacBook", new Tugas("Sulit", 5)));

        pengguna3.bandingkanLaptop(pengguna2);
        // pengguna1.selamatDatang();
        // laptop1.menuTugas();
        // pengguna1.bandingkanLaptop(pengguna2);

        Laptop laptopbaru = new Laptop();
        System.out.println(laptopbaru.getMerk());
        laptopbaru.setMerk(" Macbook");
        System.out.println(laptopbaru.getMerk());
        scanner.close();
    }
}