import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Library{
    List<LibraryItem> Item = new ArrayList<>();
    List<Member> Member = new ArrayList<>();
    LibraryLogger logger = new LibraryLogger();

    // Method untuk cek apakah ID Item sudah ada
    private boolean isItemIdExists(int itemId) {
        for (LibraryItem item : Item) {
            if (item.itemId == itemId) {
                return true;
            }
        }
        return false;
    }

    // Method untuk cek apakah ID Member sudah ada
    private boolean isMemberIdExists(int memberId) {
        for (Member member : Member) {
            if (member.memberId == memberId) {
                return true;
            }
        }
        return false;
    }

    String addItem(LibraryItem item){
        if (item.title.length() > 30){
            throw new IllegalArgumentException("Judul yang dipilih terlalu panjang");
        } if (String.valueOf(item.itemId).length() > 4){
            throw new IllegalArgumentException("Digit ID melebihi batas");
        }
        // Validasi ID tidak boleh duplikat
        if (isItemIdExists(item.itemId)) {
            throw new IllegalArgumentException("ID " + item.itemId + " sudah terdaftar! Gunakan ID yang berbeda.");
        }
        Item.add(item);
        return "Item: [" + item.title + "]\nberhasil di tambahkan";
    }

    void addMember(Member member){
        if (member.name.length() > 30){
            throw new IllegalArgumentException("Input nama terlalu panjang");
        } if (String.valueOf(member.memberId).length() > 4){
            throw new IllegalArgumentException("Digit ID melebihi batas");
        }
        // Validasi ID Member tidak boleh duplikat
        if (isMemberIdExists(member.memberId)) {
            throw new IllegalArgumentException("ID Member " + member.memberId + " sudah terdaftar! Gunakan ID yang berbeda.");
        }
        Member.add(member);
        System.out.println("member: [" + member.name + "]\nberhasil ditambahkan");
    }

    public Member findMemberByName(String name) {
        for (Member m : Member) {
            if (m.name.equalsIgnoreCase(name)) {
                return m;
            }
        }
        throw new NoSuchElementException("Member tidak ditemukan");
    }

    public LibraryItem findItemById(int id) {
        for (LibraryItem item : Item) {
            if (item.itemId == id) {
                return item;
            }
        }
        throw new NoSuchElementException("Item tidak ditemukan");
    }

    public void borrowItem(String memberName, int itemId, int days) {
        Member member = findMemberByName(memberName);
        LibraryItem item = findItemById(itemId);

        String result = member.borrow(item, days);
        System.out.println(result);
        // catat ke log
        logger.logPinjamItem(item.title, member.name);
    }

    public void returnItem(String memberName, int itemId, int daysLate) {
        Member member = findMemberByName(memberName);
        LibraryItem item = findItemById(itemId);
        String result = member.returnItem(item, 0);
        System.out.println(result);
        // catat ke log
        logger.logKembalikanItem(item.title, member.name);
        System.out.println("Denda yang akan anda bayar: Rp " + String.format("%,.2f", item.calculateFine(daysLate)));
    }

    void getLibraryStatus(){
        System.out.println("╔══════╗════════════════════════════════╗══════════╗");
        System.out.println("║ ID   ║             JUDUL              ║ STATUS   ║");
        System.out.println("╠══════╣════════════════════════════════╣══════════╣");
        for (LibraryItem item : Item){
            String status = "-";
            if (item.isBorrowed){status = "dipinjam";} else {status = "tersedia";}
            System.out.printf("║ %-4d ║ %-30s ║ %-8s ║\n", item.itemId, item.title, status);
        }
        System.out.println("╚══════╝════════════════════════════════╝══════════╝");
    }
    public void getAllLogs(){logger.getLogs();}
}

abstract class LibraryItem{
    String title;
    int itemId;
    Boolean isBorrowed;

    public LibraryItem(String title, int itemId) {
        this.title = title;
        this.itemId = itemId;
        this.isBorrowed = false;
    }
    
    abstract String getDescription();
    abstract String borrowItem(int days);
    abstract Double calculateFine(int daysLate);
    
    String returnItem(){
        this.isBorrowed = false;
        return title + " dikembalikan";
    }

    String IsBorrowed(){
        this.isBorrowed = true;
        return title + "dipinjam.";
    }
}

class Book extends LibraryItem{
    String author;
    public Book(String title, int itemId, String author) {
        super(title, itemId);
        this.author = author;
    }
    
    @Override
    String getDescription() {
        return "Buku: ["+title+"] olehh ["+author+"], ID: ["+itemId+"]";
    }
    @Override
    String borrowItem(int days) {
        if (days > 14 || days < 0) {    
            throw new IllegalArgumentException("Masukkann Hari yang valid dengan Maksimal peminjaman 14 hari");
        }if (isBorrowed) {
            throw new IllegalArgumentException("item telah dipinjam dan belum dikembalikan.❌");
        } super.IsBorrowed();
        return getDescription() + " dipinjam ";
    }
    @Override
    Double calculateFine(int daysLate) {
        double denda = daysLate*10000;
        return denda;
    }
    
}
class DVD extends LibraryItem{
    int duration;
    public DVD(String title, int itemId, int duration) {
        super(title, itemId);
        this.duration = duration;
    }
    
    @Override
    String getDescription() {
        return "DVD: ["+title+"], Durasi: ["+duration+" menit], ID: ["+itemId+"]";
    }
    @Override
    String borrowItem(int days) {
       if (days > 7){
            throw new IllegalArgumentException("Maksimal peminjaman 7 hari.");
        } if (isBorrowed) {
            throw new IllegalArgumentException("item telah dipinjam dan belum dikembalikan.");
        }
        super.IsBorrowed();
        return getDescription() + " dipinjam ";
    }
    @Override
    Double calculateFine(int daysLate) {
        double denda = daysLate*25000;
        return denda;
    }
}

class Member{
    String name;
    int memberId;
    List <LibraryItem> borrowedItems;

    public Member(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
        borrowedItems = new ArrayList<>();
    }

    String borrow(LibraryItem item, int days){
        item.borrowItem(days);
        borrowedItems.add(item);
        return "item : [" + item.title + "] \nberhasil di pinjam yey";
    }

    String returnItem(LibraryItem item, int daysLate){
        item.returnItem();
        borrowedItems.remove(item);
        if(daysLate == 0){
            return "item : [" + item.title + "] \nberhasil di kembalikan";
        }
        return "item : [" + item.title + "] \nberhasil di kembalikan, namun dengan denda : Rp " + String.format("%,.2f", item.calculateFine(daysLate));
    }

    void getBorrowedItems(){
        if (borrowedItems.isEmpty()) {
             throw new IllegalArgumentException("Data pinjaman kosong");
        }
        System.out.println("╔══════╗════════════════════════════════╗");
        System.out.println("║ ID   ║             JUDUL              ║");
        System.out.println("╠══════╣════════════════════════════════╣");
        for (LibraryItem item : borrowedItems){
            System.out.printf("║ %-4d ║ %-30s ║\n", item.itemId, item.title);
        }
        System.out.println("╚══════╝════════════════════════════════╝");
    }
}

class LibraryLogger{
    static class logData{
        String judul;
        String NamaMember;
        String waktuPinjamItem;
        String waktuKembalikanItem;

        logData(String judul, String NamaMember, String pinjamItem){
            this.judul = judul;
            this.NamaMember = NamaMember;
            this.waktuPinjamItem = pinjamItem;
            this.waktuKembalikanItem = "-";
        }
    }

    List<logData> catatanAktivitas;
    DateTimeFormatter formatWaktu;  

    public LibraryLogger() {
        catatanAktivitas = new ArrayList<>();
        formatWaktu = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    }

    void logPinjamItem(String judul, String NamaMember){
        String waktuPinjam = LocalDateTime.now().format(formatWaktu);
        catatanAktivitas.add(new logData(judul, NamaMember, waktuPinjam));
    }

    void logKembalikanItem(String judul, String NamaMember){
        String waktuKembali = LocalDateTime.now().format(formatWaktu);
        for (logData log : catatanAktivitas){
            if (log.judul.equals(judul) && log.NamaMember.equals(NamaMember)&& log.waktuKembalikanItem.equals("-")){
                log.waktuKembalikanItem = waktuKembali;
                break;
            }
        }
    }

    public void getLogs(){
        if (catatanAktivitas.isEmpty()){
            System.out.println("belum ada aktivitas");
            return;
        }
        System.out.println("\n╔═════════════════════╔════════════════════════════════╔════════════════════════════════╔═════════════════════╗");
          System.out.println("║ Dipinjam pada       ║ Judul                          ║ Member                         ║ Dikembalikan pada   ║");
          System.out.println("╠═════════════════════╠════════════════════════════════╠════════════════════════════════╠═════════════════════╣");

        for (logData log : catatanAktivitas) {
            System.out.printf("║ %-19s ║ %-30s ║ %-30s ║ %-19s ║\n",log.waktuPinjamItem,log.judul,log.NamaMember,log.waktuKembalikanItem);
        }
          System.out.println("╚═════════════════════╚════════════════════════════════╚════════════════════════════════╚═════════════════════╝");
    }

     public void clearLogs() {
        catatanAktivitas.clear();
        System.out.println("Log berhasil dikosongkan");
    }

}