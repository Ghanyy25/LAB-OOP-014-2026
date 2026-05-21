package Tugas7.soal2;

import java.util.concurrent.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("=== SEARCH ENGINE INDEXER DIMULAI ===\n");

        String[] dokumen = {
                "Dokumen_A.txt", "Dokumen_B.txt", "Dokumen_C.txt",
                "Dokumen_D.txt", "Dokumen_E.txt", "Dokumen_F.txt",
                "Dokumen_G.txt", "Dokumen_H.txt", "Dokumen_I.txt",
                "Dokumen_J.txt"
        };

        ExecutorService executor = Executors.newFixedThreadPool(4);
        DataProcessor processor = new DataProcessor();

        ConcurrentHashMap<String, Integer> hasilIndexing = new ConcurrentHashMap<>();
        ConcurrentHashMap<String, String> namaThread = new ConcurrentHashMap<>();
        ConcurrentHashMap<String, Long> durasiProses = new ConcurrentHashMap<>();

        CountDownLatch latch = new CountDownLatch(dokumen.length);

        for (String namaDok : dokumen) {
            IndexerTask task = new IndexerTask(namaDok, processor, hasilIndexing, namaThread, durasiProses, latch);
            executor.submit(task);
        }

        System.out.println("Menunggu semua dokumen selesai diproses...\n");
        latch.await();
        executor.shutdown();

        System.out.println("\n=== HASIL AKHIR INDEXING ===");
        System.out.printf("%-18s %-25s %-15s%n", "Nama Dokumen", "Thread", "Durasi (ms)");
        System.out.println("-----------------------------------------------------------");

        List<String> daftarDok = new ArrayList<>(hasilIndexing.keySet());
        Collections.sort(daftarDok);

        int totalKata = 0;
        long totalDurasi = 0;

        for (String dok : daftarDok) {
            System.out.printf("%-18s %-25s %-15d%n", dok, namaThread.get(dok), durasiProses.get(dok));
            totalKata += hasilIndexing.get(dok);
            totalDurasi += durasiProses.get(dok);
        }

        System.out.println("-----------------------------------------------------------");
        System.out.println("Total kata seluruh dokumen  : " + totalKata + " kata");
        System.out.printf("Rata-rata waktu pemrosesan  : %.0f ms%n", (double) totalDurasi / dokumen.length);
        System.out.println("\nIndexing selesai!");
    }
}