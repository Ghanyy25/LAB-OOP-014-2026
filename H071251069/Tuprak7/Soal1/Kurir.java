package Tugas7.soal1;
import java.util.Random;

public class Kurir implements Runnable {

    private Gudang gudang;
    private String nama;
    private Random random = new Random();

    public Kurir(Gudang gudang, String nama) {
        this.gudang = gudang;
        this.nama = nama;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                int jumlahAmbil = random.nextInt(5) + 1;

                gudang.ambilStok(jumlahAmbil);

                int delay = random.nextInt(1000) + 2000;
                Thread.sleep(delay);
            }
        } catch (InterruptedException e) {
            System.out.println("  [" + nama + "] Berhenti bekerja.");
        }
    }
}