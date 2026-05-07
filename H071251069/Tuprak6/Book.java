import java.util.List;

public class Book extends LibraryItem {
    private String author;

    public Book(String title, int itemId, String author) {
        super(title, itemId);
        this.author = author;
    }

    @Override
    public String getDescription() {
        return "Buku: " + title + " oleh " + author + ", ID: " + itemId;
    }

    @Override
    public String borrowItem(int days) {
        if (isBorrowed) {
            throw new IllegalArgumentException("Buku '" + title + "' sedang dipinjam dan belum dikembalikan");
        }
        if (days > 14) {
            throw new IllegalArgumentException("Buku hanya dapat dipinjam maksimal 14 hari");
        }
        if (days <= 0) {
            throw new IllegalArgumentException("Lama peminjaman harus lebih dari 0 hari");
        }
        this.isBorrowed = true;
        return "Item " + title + " berhasil dipinjam selama " + days + " hari";
    }

    @Override
    public double calculateFine(int daysLate) {
        if (daysLate <= 0)
            return 0;
        return daysLate * 10000;
    }

    public String getAuthor() {
        return author;
    }

    public static void printBooks(List<Book> books) {
        if (books == null || books.isEmpty()) {
            System.out.println("Tidak ada buku");
            return;
        }
        System.out.println("+-----+--------------------------------+----------------------+");
        System.out.println("| ID  | Judul                          | Penulis              |");
        System.out.println("+-----+--------------------------------+----------------------+");
        for (Book b : books) {
            System.out.printf("| %-3d | %-30s | %-20s |%n",
                    b.getItemId(), b.getTitle(), b.getAuthor());
        }
        System.out.println("+-----+--------------------------------+----------------------+");
    }
}
