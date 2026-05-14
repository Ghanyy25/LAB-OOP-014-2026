import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class DataProcessor {

    // Random untuk simulasi delay
    private final Random random = new Random();

    /*
     * Method process()
     * Membaca file dan menghitung jumlah kata
     */
    public int process(String fileName)
            throws InterruptedException, IOException {

        // Simulasi delay 500ms - 2000ms
        int delay =
                random.nextInt(1501) + 500;

        Thread.sleep(delay);

        // Membaca isi file
        String content =
                new String(
                        Files.readAllBytes(
                                Paths.get(fileName)));

        // Menghapus spasi kosong
        content = content.trim();

        // Jika file kosong
        if (content.isEmpty()) {
            return 0;
        }

        // Memisahkan kata berdasarkan spasi
        String[] words =
                content.split("\\s+");

        // Return jumlah kata
        return words.length;
    }
}