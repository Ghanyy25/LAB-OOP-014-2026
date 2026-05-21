import java.util.Random;

class DataProcessor {
    Random random = new Random();

    public int process(String fileName) throws InterruptedException {
        int waktuProses = random.nextInt(1500) + 500; 
        Thread.sleep(waktuProses);
        int jumlahKata = random.nextInt(900) + 100;
        return jumlahKata;
    }
}

class HasilData {
    String namaDokumen; 
    String namaThread;
    int jumlahKata;
    long durasi;

    public HasilData(String namaDokumen, String namaThread, int jumlahKata, long durasi) { 
        this.namaDokumen = namaDokumen;
        this.namaThread = namaThread;
        this.jumlahKata = jumlahKata;
        this.durasi = durasi;
    }
}

class IndexingTask extends Thread { 
    private String namaDokumen;
    private DataProcessor processor;
    private HasilData[] hasil; 
    private int index; 

    public IndexingTask(String namaDokumen, DataProcessor processor, HasilData[] hasil, int index) { 
        this.namaDokumen = namaDokumen;
        this.processor = processor;
        this.hasil = hasil;
        this.index = index;
    }

    @Override 
    public void run() { 
        long start = System.currentTimeMillis(); 
        try {
            int jumlahKata = processor.process(namaDokumen); 
            long end = System.currentTimeMillis(); 
            long durasi = end - start; 
            String namaThread = getName(); 

            hasil[index] = new HasilData(namaDokumen, namaThread, jumlahKata, durasi);
            System.out.println("[" + namaThread + "] " + "Selesai memproses " + namaDokumen + " (" + jumlahKata + " kata)");

        } catch (InterruptedException e) {
            System.out.println(namaDokumen + " gagal diproses.");
        }
    }
}

public class Soal2 {
    public static void main(String[] args) { 
        String[] daftarDokumen = { 
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

        HasilData[] hasil = new HasilData[daftarDokumen.length];
        IndexingTask[] threads = new IndexingTask[daftarDokumen.length]; 
        DataProcessor processor = new DataProcessor();
        
        for (int i = 0; i < daftarDokumen.length; i++) { 
            threads[i] = new IndexingTask(daftarDokumen[i], processor, hasil, i); 
            threads[i].start(); 
        }
        
        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join(); 
            } catch (InterruptedException e) {
                e.printStackTrace(); 
            }
        }

        System.out.println("\n========== HASIL AKHIR ==========\n");
        System.out.printf("%-20s %-20s %-15s %-15s\n","Dokumen", "Thread", "Jumlah Kata", "Durasi(ms)");

        int totalKata = 0;
        long totalDurasi = 0;
        
        for (int i = 0; i < hasil.length; i++) {
            System.out.printf("%-20s %-20s %-15d %-15d\n",
                hasil[i].namaDokumen,
                hasil[i].namaThread,
                hasil[i].jumlahKata,
                hasil[i].durasi);
            totalKata += hasil[i].jumlahKata;
            totalDurasi += hasil[i].durasi;
        }

        double rataRata = (double) totalDurasi / hasil.length;

        System.out.println("\n================================");
        System.out.println("Total Kata Keseluruhan : " + totalKata);
        System.out.println("Rata-rata Waktu Proses : " + rataRata + " ms");
    }
}
