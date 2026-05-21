package Tugas7.soal2;
import java.util.Random;

public class DataProcessor {
    private Random random = new Random();

    public int process(String fileName) throws InterruptedException {
        int waktuProses = random.nextInt(1500) + 500;
        Thread.sleep(waktuProses);
        int jumlahKata = random.nextInt(251) + 50;
        return jumlahKata;
    }
}
