import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    private static final Library library = new Library();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            printMenu();
            int choice = readInt("Pilihan: ");
            System.out.println();
            switch (choice) {
                case 1 -> tambahItem();
                case 2 -> tambahAnggota();
                case 3 -> pinjamItem();
                case 4 -> kembalikanItem();
                case 5 -> System.out.println(library.getLibraryStatus());
                case 6 -> System.out.println(library.getAllLogs());
                case 7 -> lihatItemAnggota();
                case 8 -> {
                    running = false;
                    System.out.println("Terima kasih telah menggunakan sistem!");
                }
                default -> System.out.println("Pilihan tidak valid.");
            }
        }
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n=== Sistem Manajemen Perpustakaan ===");
        System.out.println("1. Tambah Item");
        System.out.println("2. Tambah Anggota");
        System.out.println("3. Pinjam Item");
        System.out.println("4. Kembalikan Item");
        System.out.println("5. Lihat Status Perpustakaan");
        System.out.println("6. Lihat Log Aktivitas");
        System.out.println("7. Lihat Item yang Dipinjam Anggota");
        System.out.println("8. Keluar");
    }

    private static void tambahItem() {
        System.out.println("Jenis item: 1) Buku  2) DVD");
        int jenis = readInt("Pilihan: ");
        int id = readInt("ID Item: ");
        String judul = readLine("Judul: ");
        try {
            LibraryItem item;
            if (jenis == 1) {
                String author = readLine("Penulis: ");
                item = new Book(judul, id, author);
            } else if (jenis == 2) {
                int durasi = readInt("Durasi (menit): ");
                item = new DVD(judul, id, durasi);
            } else {
                System.out.println("Jenis item tidak valid.");
                return;
            }
            System.out.println(library.addItem(item));
        } catch (Exception e) {
            System.out.println("Gagal menambah item: " + e.getMessage());
        }
    }

    private static void tambahAnggota() {
        int id = readInt("ID Anggota: ");
        String nama = readLine("Nama: ");
        System.out.println(library.addMember(new Member(nama, id)));
    }

    private static void pinjamItem() {
        try {
            int memberId = readInt("ID Anggota: ");
            Member member = library.findMemberById(memberId);

            int itemId = readInt("ID Item: ");
            LibraryItem item = library.findItemById(itemId);

            int days = readInt("Lama pinjam (hari): ");

            String result = member.borrow(item, days);
            library.getLogger().logActivity(
                    item.getTitle() + " dipinjam oleh " + member.getName() + " selama " + days + " hari");
            System.out.println(result);
        } catch (NoSuchElementException | IllegalStateException | IllegalArgumentException e) {
            System.out.println("Gagal meminjam: " + e.getMessage());
        }
    }

    private static void kembalikanItem() {
        try {
            int memberId = readInt("ID Anggota: ");
            Member member = library.findMemberById(memberId);

            int itemId = readInt("ID Item: ");
            LibraryItem item = library.findItemById(itemId);

            int daysLate = readInt("Hari keterlambatan (0 jika tepat waktu): ");

            String result = member.returnItem(item, daysLate);
            library.getLogger().logActivity(
                    item.getTitle() + " dikembalikan oleh " + member.getName()
                            + (daysLate > 0 ? " (terlambat " + daysLate + " hari)" : ""));
            System.out.println(result);
        } catch (NoSuchElementException | IllegalStateException e) {
            System.out.println("Gagal mengembalikan: " + e.getMessage());
        }
    }

    private static void lihatItemAnggota() {
        try {
            int memberId = readInt("ID Anggota: ");
            Member member = library.findMemberById(memberId);
            System.out.println("Item yang dipinjam oleh " + member.getName() + ":");
            System.out.println(member.getBorrowedItems());
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }

    // ===== Helper input =====
    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Masukkan angka yang valid.");
            }
        }
    }

    private static String readLine(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

}