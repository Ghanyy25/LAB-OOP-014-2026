package Tugas7.soal1;

public class Gudang {
    private int stok;
    private int kapasitasMaksimal;

    public Gudang(int kapasitasMaksimal) {
        this.stok = 0;
        this.kapasitasMaksimal = kapasitasMaksimal;
    }

    public synchronized void tambahStok(int jumlah) throws InterruptedException {
        while (stok + jumlah > kapasitasMaksimal) {
            System.out.println("  [PEMASOK] Gudang hampir penuh (stok=" + stok + "), menunggu...");
            wait();
        }

        stok += jumlah;
        System.out.println("  [PEMASOK] Menambah " + jumlah + " barang. Stok sekarang: " + stok);

        notifyAll();
    }

    public synchronized void ambilStok(int jumlah) throws InterruptedException {
        while (stok < jumlah) {
            System.out.println("  [KURIR] Stok tidak cukup (stok=" + stok + "), menunggu...");
            wait();
        }

        stok -= jumlah;
        System.out.println("  [KURIR] Mengambil " + jumlah + " barang. Stok sekarang: " + stok);

        notifyAll();
    }

    public synchronized int getStok() {
        return stok;
    }

    public int getKapasitasMaksimal() {
        return kapasitasMaksimal;
    }
}