class Dvd extends LibraryItem {
    private int duration;

    public Dvd(String title, int itemId, int duration){
        super(title, itemId);
        this.duration = duration;
    }

    @Override
    public String borrowItem(int days) {
        if (days > 7 || isBorrowed) {
            throw new IllegalArgumentException("Tidak bisa meminjam DVD. Kembalikan DVD terlebih dahulu!");
        }
        isBorrowed = true;
        return "Item " + title + " telah dipinjam selama " + days + " hari";
    }

    @Override
    public double calculateFine(int daysLate){
        return daysLate * 25000;
    }

    @Override
    public String getDescription(){
        return "DVD " + title + ", durasi " + duration + " menit, ID: " + itemId;
    }
}
