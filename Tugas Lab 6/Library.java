import java.util.*;

class Library {
    private List<LibraryItem> items = new ArrayList<>();
    private List<Member> members = new ArrayList<>();
    private LibraryLogger logger = new LibraryLogger();

    public String addItem(LibraryItem item) {

    for (LibraryItem i : items) {
        if (i.getItemId() == item.getItemId()) {
            throw new IllegalArgumentException("ID item sudah digunakan");
        }
    }

    items.add(item);
    return item.getTitle() + " berhasil ditambahkan";
}
    public void addMember(Member m) {
        members.add(m);
    }

    public String removeItem(int itemId) {

    Iterator<LibraryItem> iterator = items.iterator();

    while (iterator.hasNext()) {
        LibraryItem item = iterator.next();

        if (item.getItemId() == itemId) {
            iterator.remove();
            return item.getTitle() + " berhasil dihapus";
        }
    }

    throw new NoSuchElementException("Item tidak ditemukan");
}

    public LibraryItem findItemById(int id) {
        for (LibraryItem item : items) {
            if (item.getItemId() == id) return item;
        }
        throw new NoSuchElementException("Item tidak ditemukan");
    }

    public String getLibraryStatus() {
        StringBuilder sb = new StringBuilder();
        for (LibraryItem item : items) {
            sb.append(item.getDescription())
              .append(" - ")
              .append(item.isBorrowed() ? "Dipinjam" : "Tersedia")
              .append("\n");
        }
        return sb.toString();
    }

    public LibraryLogger getLogger() {
        return logger;
    }

    public String getAllLogs() {
        return logger.getLogs();
    }
}