package Tuprak2;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Program Class Buku ===\n");

        Penulis penulis1 = new Penulis("Andrea Hirata", "Indonesia");
        Penulis penulis2 = new Penulis("J.K. Rowling", "Inggris");

        Buku buku1 = new Buku();
        Buku buku2 = new Buku("Harry Potter", 1997, penulis2);

        Buku buku3 = new Buku();

        System.out.println("1. Menampilkan Informasi Buku:");
        buku1.tampilkanInfo();
        buku2.tampilkanInfo();

        System.out.println("2. Interaksi Antar Objek Buku:");
        buku1.bandingkanBuku(buku2);

        System.out.println("\n=== Doneee ===");
        buku1.setJudul("Ayam1");
        System.out.println(buku1.getJudul());
    }
}