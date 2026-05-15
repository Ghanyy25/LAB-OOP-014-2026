import java.util.ArrayList;
import java.util.List;

class Library {
    private List<LibraryItem> items = new ArrayList<>(); 
    private List<Member> members = new ArrayList<>(); 
    private LibraryLogger logger = new LibraryLogger(); 

    public String addItem(LibraryItem item) { 
        for (LibraryItem i : items) { 
            if (i.itemId == item.itemId) { 
                throw new IllegalArgumentException("ID item telah digunakan, gunakan ID lain!");
            }
        }
        items.add(item); 
        return item.title + " ditambahkan";
    }

    public void addMember(Member m) { 
        for (Member member : members) { 
            if (member.getId().equals(m.getId())) { 
                throw new IllegalArgumentException("ID member telah digunakan, gunakan ID lain!");
            }
        }
        members.add(m); 
    }

    public Member findMember(String id) { 
        for (Member m : members) { 
            if (m.getId().equals(id)) { 
                return m;
            }
        }
        throw new RuntimeException("Member tidak ditemukan");
    }

    public LibraryItem findItemById(int itemId) { 
        for (LibraryItem item : items) { 
            if (item.itemId == itemId) { 
                return item;
            }
     }
        throw new RuntimeException("Item tidak ditemukan");
    }

    public List<LibraryItem> getItems() {
        return items;
    }

    public LibraryLogger getLogger() {  
        return logger;
    }

    public List<Member> getMembers() {
        return members;
    }

    public String getLibraryStatus(){ 
        StringBuilder sb = new StringBuilder(); 

        sb.append("+-----+----------------------+----------------+\n");
        sb.append("| ID  | Judul                | Status         |\n");
        sb.append("+-----+----------------------+----------------+\n");
        for (LibraryItem item : items) {
            String status = item.isBorrowed ? "Dipinjam" : "Tersedia";
            sb.append(String.format("| %-3d | %-20s | %-14s |\n", item.itemId, item.title, status));
        }
        sb.append("+-----+----------------------+----------------+\n");
        return sb.toString(); 
    }

    public String getAllLogs() {
        return logger.getLogs(); 
    }
}