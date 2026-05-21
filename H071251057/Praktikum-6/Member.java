import java.util.ArrayList;
import java.util.List;

class Member { 
    private String name ;
    private String memberId ;
    private List<LibraryItem> borrowedItems ; 

    public Member(String name, String memberId) { 
        this.name = name;
        this.memberId = memberId;
        this.borrowedItems = new ArrayList<>(); 
    }

    public String getName() {
        return name ;
    }

    public String getId() {
        return memberId;
    }

    public String borrow(LibraryItem item, int days) { 
        if(item.isBorrowed) { 
            throw new IllegalArgumentException("Item sedang dipinjam");
        }
        borrowedItems.add(item); 
        return item.borrowItem(days); 
    }

    public String returnItem(LibraryItem item, int daysLate) { 
        if (daysLate < 0) { 
            throw new IllegalArgumentException("Jumlah hari keterlambatan tidak valid");
        }
        borrowedItems.remove(item); 
        double fine = item.calculateFine(daysLate); 
        item.returnItem(); 
        return "Item " + item.title + " dikembalikan dengan denda: Rp " + fine;
    }

    public void getBorrowedItems(){ 
        if(borrowedItems.isEmpty()){ 
            System.out.println("Tidak ada item yang dipinjam");
            return;
        }
        System.out.println("+-----+----------------------+");
        System.out.println("| ID  | Judul                |");
        System.out.println("+-----+----------------------+");
        for (LibraryItem item : borrowedItems) { 
            System.out.printf("| %-3d | %-20s |\n", item.itemId, item.title); 
        }
        System.out.println("+-----+----------------------+");
    }
}