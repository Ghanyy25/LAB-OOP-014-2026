import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Library lib = new Library(); 

        while (true) { 
            System.out.println("\n=== Sistem Manajemen Perpustakaan ===");
            System.out.println("1. Tambah Item");
            System.out.println("2. Tambah Anggota");
            System.out.println("3. Pinjam Item");
            System.out.println("4. Kembalikan Item");
            System.out.println("5. Lihat Status Perpustakaan");
            System.out.println("6. Lihat Log Aktivitas");
            System.out.println("7. Lihat Item yang Dipinjam Anggota");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");

            int pilih = input.nextInt();
            input.nextLine();

            try { 
                switch (pilih) { 
                    case 1:
                        System.out.println("1. Book");
                        System.out.println("2. DVD");

                        int jenis;
                        while (true) {
                            System.out.print("Jenis Item: ");
                            jenis = input.nextInt();
                            if (jenis == 1 || jenis == 2) {
                                break;
                            }
                            System.out.println("Jenis item tidak valid!");
                        }
                        input.nextLine();

                        System.out.print("Judul: ");
                        String title = input.nextLine();

                        int id;
                        while (true) {
                            System.out.print("ID item: ");
                            id = input.nextInt();
                            if (id < 0) {
                                System.out.println("ID tidak boleh negatif!");
                                continue;
                            }

                            boolean ada = false;
                            for (LibraryItem item : lib.getItems()) {
                                if (item.itemId == id) {
                                    ada = true;
                                    break;
                                }
                            }
                            if (!ada) {
                                break;
                            }
                            System.out.println("ID item sudah digunakan!");
                        }
                        input.nextLine();

                        if (jenis == 1) {
                            System.out.print("Author: ");
                            String author = input.nextLine();
                            System.out.println(lib.addItem(new Book(title, id, author)));
                        } else {

                            int dur;
                            while (true) {
                                System.out.print("Durasi: ");
                                dur = input.nextInt();
                                if (dur > 0) {
                                    break;
                                }
                                System.out.println("Durasi harus lebih dari 0!");
                            }
                            System.out.println(lib.addItem(new Dvd(title, id, dur)));
                        }
                        break;

                    case 2:
                        System.out.print("Nama: ");
                        String nama = input.nextLine();

                        String mid;
                        while (true){
                            System.out.print("ID Member:");
                            mid = input.nextLine();
                            if (mid.isEmpty()) {
                                System.out.println("ID member tidak boleh kosong!");
                                continue;
                            }

                            boolean ada = false;
                            for (Member member : lib.getMembers()) {
                                if (member.getId().equals(mid)) {
                                    ada = true;
                                    break;
                                }
                            }
                            if (!ada) {
                                break;
                            }
                            System.out.println("ID member sudah digunakan!");
                        }
                        Member newmemb = new Member(nama, mid);
                        lib.addMember(newmemb);
                        System.out.println("Member berhasil ditambahkan");
                        break;

                    case 3:
                        System.out.print("ID Member: ");
                        Member m = lib.findMember(input.nextLine());

                        System.out.print("ID Item: ");
                        LibraryItem item = lib.findItemById(input.nextInt());

                        System.out.print("Hari: ");
                        int d = input.nextInt();
                        input.nextLine();

                        System.out.println(m.borrow(item, d));
                        lib.getLogger().logActivity(item.title, m.getName(), false);
                        break;

                    case 4:
                        System.out.print("ID Member: ");
                        Member m2 = lib.findMember(input.nextLine());

                        System.out.print("ID Item: ");
                        LibraryItem item2 = lib.findItemById(input.nextInt());

                        System.out.print("Telat: ");
                        int late = input.nextInt();
                        input.nextLine();

                        System.out.println(m2.returnItem(item2, late));
                        lib.getLogger().logActivity(item2.title, m2.getName(), true);
                        break;

                    case 5:
                        System.out.println(lib.getLibraryStatus());
                        break;

                    case 6:
                        System.out.println(lib.getAllLogs());
                        break;

                    case 7:
                        System.out.print("ID Member: ");
                        lib.findMember(input.nextLine()).getBorrowedItems();
                        break;

                    case 0:
                        return;

                    default:
                        System.out.println("Pilihan tidak valid!");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}