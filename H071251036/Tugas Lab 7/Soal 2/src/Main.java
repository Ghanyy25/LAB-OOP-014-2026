import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args)
            throws InterruptedException {

        System.out.println(
                "Working Directory : "
                        + System.getProperty("user.dir"));

        List<String> dokumen =
                new ArrayList<>();

        dokumen.add(
                Paths.get(
                        "Soal 2",
                        "dokumen",
                        "Dokumen1.txt").toString());

        dokumen.add(
                Paths.get(
                        "Soal 2",
                        "dokumen",
                        "Dokumen2.txt").toString());

        dokumen.add(
                Paths.get(
                        "Soal 2",
                        "dokumen",
                        "Dokumen3.txt").toString());

        ConcurrentHashMap<String, Integer>
                hasilKata =
                new ConcurrentHashMap<>();

        ConcurrentHashMap<String, String>
                threadHandler =
                new ConcurrentHashMap<>();

        ConcurrentHashMap<String, Long>
                durasiProses =
                new ConcurrentHashMap<>();

        ExecutorService executor =
                Executors.newFixedThreadPool(4);

        CountDownLatch latch =
                new CountDownLatch(
                        dokumen.size());

        DataProcessor processor =
                new DataProcessor();

        for (String file : dokumen) {

            executor.execute(() -> {

                long start =
                        System.currentTimeMillis();

                try {

                    // Proses file
                    int jumlahKata =
                            processor.process(file);

                    long end =
                            System.currentTimeMillis();

                    long durasi =
                            end - start;

                    // Simpan jumlah kata
                    hasilKata.put(
                            file,
                            jumlahKata);

                    // Simpan nama thread
                    threadHandler.put(
                            file,
                            Thread.currentThread()
                                    .getName());

                    // Simpan durasi
                    durasiProses.put(
                            file,
                            durasi);

                    // Monitoring realtime
                    System.out.println(
                            "[" +
                                    Thread.currentThread()
                                            .getName()
                                    + "] "
                                    + "Selesai memproses "
                                    + file
                                    + " ("
                                    + jumlahKata
                                    + " kata)");

                } catch (
                        InterruptedException
                        | IOException e) {

                    System.out.println(
                            "Error membaca file : "
                                    + file);

                    e.printStackTrace();

                } finally {

                    // Mengurangi latch
                    latch.countDown();
                }
            });
        }

        // =====================================
        // MENUNGGU SEMUA THREAD SELESAI
        // =====================================

        latch.await();

        // =====================================
        // SHUTDOWN EXECUTOR
        // =====================================

        executor.shutdown();

        // =====================================
        // OUTPUT AKHIR
        // =====================================

        System.out.println(
                "\n========== HASIL AKHIR ==========\n");

        int totalKata = 0;

        long totalDurasi = 0;

        System.out.printf(
                "%-40s %-20s %-15s %-15s\n",
                "Nama Dokumen",
                "Thread",
                "Jumlah Kata",
                "Durasi(ms)");

        System.out.println(
                "---------------------------------------------------------------------------------------");

        for (Map.Entry<String, Integer>
                entry
                : hasilKata.entrySet()) {

            String file =
                    entry.getKey();

            int jumlahKata =
                    entry.getValue();

            long durasi =
                    durasiProses.get(file);

            totalKata += jumlahKata;

            totalDurasi += durasi;

            System.out.printf(
                    "%-40s %-20s %-15d %-15d\n",
                    file,
                    threadHandler.get(file),
                    jumlahKata,
                    durasi);
        }

        // Menghitung rata-rata durasi
        double rataRata =
                (double) totalDurasi
                        / hasilKata.size();

        System.out.println(
                "\nTotal Kata Keseluruhan : "
                        + totalKata);

        System.out.println(
                "Rata-rata Waktu Proses : "
                        + rataRata
                        + " ms");

        System.out.println(
                "\nSemua dokumen selesai diproses.");
    }
}