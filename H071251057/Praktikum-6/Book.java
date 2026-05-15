class Book extends LibraryItem { 
    private String author ;

    public Book(String title, int itemId, String author){
        super(title, itemId); 
        this.author = author ; 
    }

    @Override 
    public String borrowItem(int days) { 
        if(days > 14 || isBorrowed) { 
            throw new IllegalArgumentException("Belum bisa meminjam buku. Kembalikan buku terlebih dahulu!"); 
        }
        isBorrowed = true ; 
        return "Item " +  title + " telah dipinjam selama " + days + " hari."; 
    }

    @Override
    public double calculateFine(int daysLate) {
        return daysLate * 10000;
    }

    @Override
    public String getDescription(){ 
        return "Buku: " + title + " oleh" + author + " , ID: " + itemId;
    }
}
