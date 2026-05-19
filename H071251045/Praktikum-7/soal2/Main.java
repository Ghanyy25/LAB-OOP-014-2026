package soal2;
import java.util.concurrent.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        String[] documents = {
                "Dokumen_A.txt",
                "Dokumen_B.txt",
                "Dokumen_C.txt",
                "Dokumen_D.txt",
                "Dokumen_E.txt",
                "Dokumen_F.txt",
                "Dokumen_G.txt",
                "Dokumen_H.txt",
                "Dokumen_I.txt",
                "Dokumen_J.txt"
        };
        DataProcessor processor = new DataProcessor();
        ExecutorService executor = Executors.newFixedThreadPool(10);

        List<DocumentResult> hasil = Collections.synchronizedList(new ArrayList<>());

        CountDownLatch latch = new CountDownLatch(documents.length);

        System.out.println("=== MULAI PROCESSING ===\n");

        for (String doc : documents) {
            executor.execute(() -> {
                long start = System.currentTimeMillis();
                int wordCount = processor.process(doc);
                long end = System.currentTimeMillis();
                long duration = end - start;
                hasil.add(new DocumentResult(doc,Thread.currentThread().getName(),wordCount,duration));
                System.out.println("[" + Thread.currentThread().getName() + "] "+ "Selesai memproses "+ doc+ " (" + wordCount + " kata)");
                latch.countDown();
            });
        }

        latch.await();
        executor.shutdown();

        System.out.println("\n=== HASIL AKHIR ===\n");
        System.out.printf("%-15s %-20s %-15s %-10s\n","Dokumen","Thread","Jumlah Kata","Durasi");
        System.out.println(
                "--------------------------------------------------------------"
        );

        int totalWords = 0;
        long totalDuration = 0;

        for (DocumentResult r : hasil) {
            System.out.printf( "%-15s %-20s %-15d %-10d\n",r.documentName,r.threadName,r.wordCount,r.duration);
            totalWords += r.wordCount;
            totalDuration += r.duration;
        }

        double average =(double) totalDuration / hasil.size();
        System.out.println("\nTotal Kata : " + totalWords);
        System.out.println("Rata-rata Durasi : " + average+ " ms" );
    }
}