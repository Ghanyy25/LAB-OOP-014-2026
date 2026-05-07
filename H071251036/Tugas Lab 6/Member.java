import java.util.*;
import java.text.NumberFormat;

// [SOAL 1] Class Member
class Member {

    // [SOAL 1] Attribute: name, memberId, borrowedItems (List)
    private String name;
    private int memberId;
    private List<LibraryItem> borrowedItems = new ArrayList<>();

    // [SOAL 1] Constructor
    public Member(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
    }

    // [SOAL 1] Method: borrow(LibraryItem item, int days)
    public String borrow(LibraryItem item, int days, LibraryLogger logger) {

        // [SOAL 1] Exception jika item tidak tersedia
        if (item.isBorrowed()) {
            throw new IllegalStateException("Item tidak tersedia");
        }

        // [SOAL 1] Memanggil method borrowItem dari item
        String result = item.borrowItem(days);

        // [SOAL 1] Menambahkan ke daftar borrowedItems
        borrowedItems.add(item);

        // [SOAL 2] Logging aktivitas peminjaman
        String type = (item instanceof Book) ? "Buku" : "DVD";
        logger.logBorrow(type, name);

        // [SOAL 1] Mengembalikan string sesuai format
        return result;
    }

   // [SOAL 1] Method: returnItem(LibraryItem item, int daysLate)
public String returnItem(LibraryItem item, int daysLate, LibraryLogger logger) {

    // [TAMBAHAN] Tidak boleh minus
    if (daysLate < 0) {
        throw new IllegalArgumentException("Hari keterlambatan tidak boleh minus");
    }

    // [SOAL 1] Memanggil returnItem dari item
    item.returnItem();

    // [SOAL 1] Menghapus dari daftar peminjaman
    borrowedItems.remove(item);

    // [SOAL 1] Menghitung denda
    double fine = item.calculateFine(daysLate);

    // [SOAL 1] Format rupiah
    NumberFormat format = NumberFormat.getInstance(new Locale("id", "ID"));
    String formattedFine = format.format(fine);

    // [SOAL 2] Logging aktivitas pengembalian
    String type = (item instanceof Book) ? "Buku" : "DVD";
    logger.logReturn(type, name);

    // [SOAL 1] Return sesuai format soal
    return "Item " + item.getTitle() +
            " berhasil dikembalikan dengan denda: Rp " + formattedFine;
}

    // [SOAL 1] Method: getBorrowedItems()
    public void getBorrowedItems() {

        // [SOAL 1] Jika kosong
        if (borrowedItems.isEmpty()) {
            System.out.println("Tidak ada item yang dipinjam");
        } else {
            // [SOAL 1] Print daftar item
            System.out.println("Daftar item dipinjam:");
            for (LibraryItem item : borrowedItems) {
                System.out.println("- " + item.getDescription());
            }
        }
    }

    public String getName() {
        return name;
    }
}