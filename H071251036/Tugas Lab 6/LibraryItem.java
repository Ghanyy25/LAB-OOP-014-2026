// [SOAL 1] Abstract class LibraryItem
abstract class LibraryItem {

    // [SOAL 1] Atribut: title, itemId, isBorrowed
    protected String title;
    protected int itemId;
    protected boolean isBorrowed;

    // [SOAL 1] Constructor
    public LibraryItem(String title, int itemId) {
        this.title = title;
        this.itemId = itemId;
        this.isBorrowed = false;
    }

    // [SOAL 1] Abstract method: getDescription()
    public abstract String getDescription();

    // [SOAL 1] Abstract method: borrowItem(int days)
    public abstract String borrowItem(int days);

    // [SOAL 1] Abstract method: calculateFine(int daysLate)
    public abstract double calculateFine(int daysLate);

    // [SOAL 1] Method: returnItem()
    public String returnItem() {
        this.isBorrowed = false;
        return title + " dikembalikan";
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public String getTitle() {
        return title;
    }

    public int getItemId() {
        return itemId;
    }
}