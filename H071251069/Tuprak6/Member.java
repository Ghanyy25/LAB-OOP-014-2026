import java.util.ArrayList;
import java.util.List;

public class Member {
    private String name;
    private int memberId;
    private List<LibraryItem> borrowedItems;

    public Member(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
        this.borrowedItems = new ArrayList<>();
    }

    public String borrow(LibraryItem item, int days) {

        if (item.isBorrowed()) {
            throw new IllegalStateException("Item " + item.getTitle() + " tidak tersedia (sedang dipinjam)");
        }

        String result = item.borrowItem(days);
        borrowedItems.add(item);
        return result;
    }

    public String returnItem(LibraryItem item, int daysLate) {
        if (!borrowedItems.contains(item)) {
            throw new IllegalStateException("Item " + item.getTitle() + " tidak dipinjam oleh " + name);
        }
        item.returnItem();
        borrowedItems.remove(item);
        double fine = item.calculateFine(daysLate);
        return String.format("Item %s berhasil dikembalikan dengan denda: Rp %,.0f",
                item.getTitle(), fine);
    }

    public String getBorrowedItems() {
        if (borrowedItems.isEmpty()) {
            return "Tidak ada item yang dipinjam";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("+-----+--------------------------------+\n");
        sb.append("| ID  | Judul                          |\n");
        sb.append("+-----+--------------------------------+\n");
        for (LibraryItem item : borrowedItems) {
            sb.append(String.format("| %-3d | %-30s |%n", item.getItemId(), item.getTitle()));
        }
        sb.append("+-----+--------------------------------+");
        return sb.toString();
    }

    public String getName() {
        return name;
    }

    public int getMemberId() {
        return memberId;
    }

    public List<LibraryItem> getBorrowedItemsList() {
        return borrowedItems;
    }
}
