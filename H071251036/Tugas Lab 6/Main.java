import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library lib = new Library();

        Member member = new Member("Budi", 1);
        lib.addMember(member);

        while (true) {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Tambah DVD");
            System.out.println("3. Pinjam Item");
            System.out.println("4. Kembalikan Item");
            System.out.println("5. Lihat Status");
            System.out.println("6. Lihat Log");
            System.out.println("7. Hapus Item");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");

            int pilih = sc.nextInt();

            try {
                switch (pilih) {
                    case 1:
                        sc.nextLine();
                        System.out.print("Judul: ");
                        String judul = sc.nextLine();
                        System.out.print("ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Author: ");
                        String author = sc.nextLine();

                        System.out.println(lib.addItem(new Book(judul, id, author)));
                        break;

                    case 2:
                        sc.nextLine();
                        System.out.print("Judul: ");
                        String j = sc.nextLine();
                        System.out.print("ID: ");
                        int i = sc.nextInt();
                        System.out.print("Durasi: ");
                        int d = sc.nextInt();

                        System.out.println(lib.addItem(new DVD(j, i, d)));
                        break;

                    case 3:
                        System.out.print("ID item: ");
                        int idPinjam = sc.nextInt();
                        System.out.print("Hari: ");
                        int hari = sc.nextInt();

                        LibraryItem item = lib.findItemById(idPinjam);
                        System.out.println(member.borrow(item, hari, lib.getLogger()));
                        break;

                    case 4:
                        System.out.print("ID item: ");
                        int idKembali = sc.nextInt();
                        System.out.print("Telat (hari): ");
                        int telat = sc.nextInt();

                        LibraryItem item2 = lib.findItemById(idKembali);
                        System.out.println(member.returnItem(item2, telat, lib.getLogger()));
                        break;

                    case 5:
                        System.out.println(lib.getLibraryStatus());
                        break;

                    case 6:
                        System.out.println(lib.getAllLogs());
                        break;

                    case 7:
                         System.out.print("Masukkan ID item yang ingin dihapus: ");
                         int idHapus = sc.nextInt();

                         System.out.println(lib.removeItem(idHapus));
                        break;    

                    case 0:
                        return;
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
//1.menghilangkan angka mines pada method mengembalikan buku agar tidak menerima mines
//2.tidak boleh memiliki id yang sama padah tambah buku dan dvd
//3.tambah method untuk menghpus buku dan dvd