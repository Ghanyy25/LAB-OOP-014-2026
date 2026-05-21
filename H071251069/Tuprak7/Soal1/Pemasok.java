package Tugas7.soal1;

import java.util.Random;

public class Pemasok implements Runnable {

    private Gudang gudang;
    private String nama;
    private Random random = new Random();

    public Pemasok(Gudang gudang, String nama) {
        this.gudang = gudang;
        this.nama = nama;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                int jumlahBarang = random.nextInt(10) + 1;

                gudang.tambahStok(jumlahBarang);

                int delay = random.nextInt(1000) + 1000;
                Thread.sleep(delay);
            }
        } catch (InterruptedException e) {
            System.out.println("  [" + nama + "] Berhenti bekerja.");
        }
    }
}