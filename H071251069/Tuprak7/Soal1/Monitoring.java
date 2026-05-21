package Tugas7.soal1;

public class Monitoring implements Runnable {
    private Gudang gudang;

    public Monitoring(Gudang gudang) {
        this.gudang = gudang;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                tampilkanStatus();
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("  [MONITORING] Berhenti memantau.");
        }
    }

    private void tampilkanStatus() {
        int stok = gudang.getStok();
        int maks = gudang.getKapasitasMaksimal();

        int panjangBar = 20;
        int terisi = (int) ((double) stok / maks * panjangBar);
        int kosong = panjangBar - terisi;

        String bar = "";
        for (int i = 0; i < terisi; i++)
            bar += "#";
        for (int i = 0; i < kosong; i++)
            bar += "-";

        int persen = (int) ((double) stok / maks * 100);

        System.out.println("  Status Gudang: [" + bar + "] " + persen + "% (" + stok + "/" + maks + ")");
    }
}