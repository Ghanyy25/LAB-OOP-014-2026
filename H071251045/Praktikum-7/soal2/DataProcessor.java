package soal2;
import java.util.Random;

public class DataProcessor {
    private Random random = new Random();

    public int process(String fileName) {

        try {
            int sleepTime = 500 + random.nextInt(1501);
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 100 + random.nextInt(900);
    }
}