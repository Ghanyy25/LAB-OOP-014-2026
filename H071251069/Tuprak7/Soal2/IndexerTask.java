package Tugas7.soal2;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

public class IndexerTask implements Runnable {
    private String namaDokumen;
    private DataProcessor processor;
    private ConcurrentHashMap<String, Integer> hasilIndexing;
    private ConcurrentHashMap<String, String> namaThread;
    private ConcurrentHashMap<String, Long> durasiProses;
    private CountDownLatch latch;

    public IndexerTask(String namaDokumen, DataProcessor processor,
                       ConcurrentHashMap<String, Integer> hasilIndexing,
                       ConcurrentHashMap<String, String> namaThread,
                       ConcurrentHashMap<String, Long> durasiProses,
                       CountDownLatch latch) {
        this.namaDokumen = namaDokumen;
        this.processor = processor;
        this.hasilIndexing = hasilIndexing;
        this.namaThread = namaThread;
        this.durasiProses = durasiProses;
        this.latch = latch;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        long mulai = System.currentTimeMillis();

        try {
            int jumlahKata = processor.process(namaDokumen);
            long durasi = System.currentTimeMillis() - mulai;

            hasilIndexing.put(namaDokumen, jumlahKata);
            namaThread.put(namaDokumen, threadName);
            durasiProses.put(namaDokumen, durasi);

            System.out.println("[" + threadName + "] Selesai memproses " + namaDokumen + " (" + jumlahKata + " kata).");

        } catch (InterruptedException e) {
            System.out.println("[" + threadName + "] Proses " + namaDokumen + " dibatalkan.");
        } finally {
            latch.countDown();
        }
    }
}