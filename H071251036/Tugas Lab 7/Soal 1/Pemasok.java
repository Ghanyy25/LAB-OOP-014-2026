import java.util.Random;

public class Pemasok implements Runnable {

    private final Gudang gudang;
    private final Random random = new Random();

    public Pemasok(Gudang gudang) {
        this.gudang = gudang;
    }

    @Override
    public void run() {

        while (!Thread.currentThread().isInterrupted()) {

            try {

                int jumlah = random.nextInt(10) + 1;

                gudang.tambahStok(jumlah);

                // Delay 1 - 2 detik
                Thread.sleep((random.nextInt(2) + 1) * 1000);

            } catch (InterruptedException e) {
                System.out.println(
                        Thread.currentThread().getName()
                                + " dihentikan.");
                Thread.currentThread().interrupt();
            }
        }
    }
}