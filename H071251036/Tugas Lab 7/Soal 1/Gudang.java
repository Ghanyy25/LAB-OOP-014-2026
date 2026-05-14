public class Gudang {

    private int stok = 0;
    private final int kapasitasMaksimal;

    public Gudang(int kapasitasMaksimal) {
        this.kapasitasMaksimal = kapasitasMaksimal;
    }

    // Method untuk menambah stok
    public synchronized void tambahStok(int jumlah) throws InterruptedException {

        while (stok + jumlah > kapasitasMaksimal) {
            System.out.println(
                    Thread.currentThread().getName()
                            + " menunggu, gudang penuh...");
            wait();
        }

        stok += jumlah;

        System.out.println(
                Thread.currentThread().getName()
                        + " menambah stok "
                        + jumlah
                        + " | Total stok: "
                        + stok);

        notifyAll();
    }

    // Method untuk mengambil stok
    public synchronized void ambilStok(int jumlah) throws InterruptedException {

        while (stok < jumlah) {
            System.out.println(
                    Thread.currentThread().getName()
                            + " menunggu, stok tidak cukup...");
            wait();
        }

        stok -= jumlah;

        System.out.println(
                Thread.currentThread().getName()
                        + " mengambil stok "
                        + jumlah
                        + " | Sisa stok: "
                        + stok);

        notifyAll();
    }

    public synchronized int getStok() {
        return stok;
    }

    public int getKapasitasMaksimal() {
        return kapasitasMaksimal;
    }
}