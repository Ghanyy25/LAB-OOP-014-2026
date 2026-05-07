// [SOAL 1] Class DVD extends LibraryItem
class DVD extends LibraryItem {

    // [SOAL 1] Attribute tambahan: duration
    private int duration;

    public DVD(String title, int itemId, int duration) {
        super(title, itemId);
        this.duration = duration;
    }

    // [SOAL 1] Deskripsi: “DVD: [title], durasi [duration] menit, ID: [itemId]”
    @Override
    public String getDescription() {
        return "DVD: " + title + ", durasi " + duration + " menit, ID: " + itemId;
    }

    // [SOAL 1] Aturan peminjaman max 7 hari + exception
    @Override
    public String borrowItem(int days) {
        if (days > 7) {
            throw new IllegalArgumentException("Maksimal 7 hari");
        }
        if (isBorrowed) {
            throw new IllegalArgumentException("Item sedang dipinjam");
        }
        isBorrowed = true;
        return "Item " + title + " berhasil dipinjam selama " + days + " hari";
    }

    // [SOAL 1] Denda: 25000 per hari
    @Override
    public double calculateFine(int daysLate) {
        return daysLate * 25000;
    }
}