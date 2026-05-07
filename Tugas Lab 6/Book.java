// [SOAL 1] Class Book extends LibraryItem
class Book extends LibraryItem {

    // [SOAL 1] Attribute tambahan: author
    private String author;

    public Book(String title, int itemId, String author) {
        super(title, itemId);
        this.author = author;
    }

    // [SOAL 1] Deskripsi: “Buku: [title] oleh [author], ID: [itemId]”
    @Override
    public String getDescription() {
        return "Buku: " + title + " oleh " + author + ", ID: " + itemId;
    }

    // [SOAL 1] Aturan peminjaman max 14 hari + exception
    @Override
    public String borrowItem(int days) {
        if (days > 14) {
            throw new IllegalArgumentException("Maksimal 14 hari");
        }
        if (isBorrowed) {
            throw new IllegalArgumentException("Item sedang dipinjam");
        }
        isBorrowed = true;
        return "Item " + title + " berhasil dipinjam selama " + days + " hari";
    }

    // [SOAL 1] Denda: 10000 per hari
    @Override
    public double calculateFine(int daysLate) {
        return daysLate * 10000;
    }
}