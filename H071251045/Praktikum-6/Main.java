import java.util.Scanner;

public class Main {
    static Scanner anu = new Scanner(System.in);
    static Library library = new Library();
    public static void main(String[] args) {
        while (true) {
        System.out.println("\n=== Sistem Manajemen Perpustakaan ===");
        System.out.println("1. Tambah item");
        System.out.println("2. Tambah anggota");
        System.out.println("3. Pinjamm item");
        System.out.println("4. Kembalikan Item");
        System.out.println("5. Lihat status perpustakaan");
        System.out.println("6. Lihat log aktivitas");
        System.out.println("7. lihat item yang dipinjam anggota");
        System.out.println("8. keluar");
        System.out.println("\nMasukkan Pilihan anda: ");int pil = anu.nextInt();
        anu.nextLine();
        try {
            switch (pil) {
                case 1:
                   System.out.println("\n╔════════════════════════╗");
                    System.out.println("║      TAMBAH ITEM       ║");
                    System.out.println("╚════════════════════════╝");
                    addItem();
                    break;
                case 2:
                    System.out.println("\n╔════════════════════════╗");
                    System.out.println("║     TAMBAH MEMBER      ║");
                    System.out.println("╚════════════════════════╝");
                    addMember();
                    break;
                case 3:
                    System.out.println("╔════════════════════════╗");
                    System.out.println("║         PINJAM         ║");
                    System.out.println("╚════════════════════════╝");
                    BorrowItem();
                    break;
                case 4:
                    System.out.println("\n╔════════════════════════╗");
                    System.out.println("║       KEMBALIKAN       ║");
                    System.out.println("╚════════════════════════╝");
                    ReturnItem();
                    break;
                case 5:
                    System.out.println("\n╔════════════════════════╗");
                    System.out.println("║         STATUS         ║");
                    System.out.println("╚════════════════════════╝");
                    library.getLibraryStatus();
                    break;
                case 6:
                     System.out.println("\n╔════════════════════════╗");
                    System.out.println("║          LOG           ║");
                    System.out.println("╚════════════════════════╝");
                    library.getAllLogs();
                    break;
                case 7:
                    System.out.println("\n╔════════════════════════╗");
                    System.out.println("║ LIHAT PINJAMAN MEMBER  ║");
                    System.out.println("╚════════════════════════╝");
                    viewBorrowedItems();
                    break;
                case 8:
                    System.out.println("Keluar...");
                        return;

            
                default:
                     System.out.println("Menu ke-" + pil + "tidak tersedia");
                }
            }
            catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    static void addItem() {
        System.out.println("╔═══════════╗");
        System.out.println("║ 1.BUKU    ║");
        System.out.println("║ 2.DVD     ║");
        System.out.println("╚═══════════╝");
        System.out.print("Pilih         : ");
        int jenis = anu.nextInt();
        anu.nextLine();

        System.out.print("Judul         : ");
        String title = anu.nextLine();

        System.out.print("ID            : ");
        int id = anu.nextInt();
        anu.nextLine();

        if (jenis == 1) {
            System.out.print("Author        : ");
            String author = anu.nextLine();
            System.out.println(library.addItem(new Book(title, id, author)));

        } else if (jenis == 2) {
            System.out.print("Durasi (menit): ");
            int durasi = anu.nextInt();
            System.out.println(library.addItem(new DVD(title, id, durasi)));

        } else {
            System.out.println("\nJenis tidak valid");
        }
    }
    static void addMember() {
        System.out.print("Nama Member: ");
        String nama = anu.nextLine();

        System.out.print("ID Member  : ");
        int id = anu.nextInt();
        anu.nextLine();

        library.addMember(new Member(nama, id));
        System.out.println("\nMember berhasil ditambahkan");
    }

    static void BorrowItem() {
        System.out.print("Nama Member : ");
        String nama = anu.nextLine();

        System.out.print("ID Item     : ");
        int id = anu.nextInt();

        System.out.print("Jumlah hari : ");
        int hari = anu.nextInt();
        anu.nextLine();

        library.borrowItem(nama, id, hari);
    }
    static void ReturnItem() {
        System.out.print("Nama Member      : ");
        String nama = anu.nextLine();

        System.out.print("ID Item          : ");
        int id = anu.nextInt();

        System.out.print("Terlambat (hari) : ");
        int telat = anu.nextInt();
        anu.nextLine();

        library.returnItem(nama, id, telat);
    }
    static void viewBorrowedItems() {
        System.out.print("Nama Member : ");
        String nama = anu.nextLine();

        Member m = library.findMemberByName(nama);
        m.getBorrowedItems();
    }

}
